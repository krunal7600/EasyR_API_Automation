package Custom_Room;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_POST_EditCustomRoom extends BaseClass {

    @Test
    public void POSTEditCustomRoom()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{\"custom_room_id\":\""+prop.getProperty("Custom_Room_Id")+"\",\"max_limit\":1,\"selected_addon_ids\":[\""+prop.getProperty("Custom_Room_Standard_Addon_1_Id")+"\"],\"selected_checklist_ids\":[\""+prop.getProperty("Custom_Room_Standard_Checklist_1_Id")+"\",\""+prop.getProperty("Custom_Room_Standard_Checklist_2_Id")+"\"],\"title\":\"\"}\n").post("/api/custom_room/edit");

        //Print Response In Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : " + response.jsonPath().getJsonObject("message"));
    }
}
