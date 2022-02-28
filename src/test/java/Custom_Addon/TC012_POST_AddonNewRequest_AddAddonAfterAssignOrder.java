package Custom_Addon;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC012_POST_AddonNewRequest_AddAddonAfterAssignOrder extends BaseClass {

    @Test
    public void POSTAddonNewRequest_AddAddonAfterAssignOrder()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{"+"\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\","+"\"rooms\":["+"{"+"\"add_on\":["+"{"+"\"_id\":\""+prop.getProperty("Add_Custom_Addon_Id")+"\","+"\"count\":1,"+"\"is_custom\":true"+"}"+"],"+"\"room_id\":\""+prop.getProperty("Kitchen_id")+"\""+"}"+"],"+"\"selected_custom_addon_ids\":[\""+prop.getProperty("Add_Custom_Addon_Id")+"\"]"+"}").post("/api/service/new_addon_request");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
