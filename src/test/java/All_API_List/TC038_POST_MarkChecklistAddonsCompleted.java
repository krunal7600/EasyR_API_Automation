package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC038_POST_MarkChecklistAddonsCompleted extends BaseClass {

    @Test
    public void POSTMarkChecklistAddonsCompleted()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","text/plain").header("Content-Type","application/json").header("language_code","en").header("Authorization",prop.getProperty("Login_Partner_Access_Token")).header("login_as_provider","false").body("{\"addons\":[{\"addon_id\":\""+prop.getProperty("addon_id_1")+"\",\"uid\":1},{\"addon_id\":\""+prop.getProperty("WholeHouse_addons[1]._id")+"\",\"uid\":1},{\"addon_id\":\""+prop.getProperty("Kitchen_addons_news[1]._id")+"\",\"uid\":2}],\"checklists\":[{\"room_type_id\":\""+prop.getProperty("login_customer_room_type_id1")+"\",\"subfield_id\":[1,2,3,4,5,6,7,8,9,10],\"uid\":2}],\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\"}").post("/api/service/mark_checklist_addons_completed");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));

    }
}
