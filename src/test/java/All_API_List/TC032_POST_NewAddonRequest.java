package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC032_POST_NewAddonRequest extends BaseClass {

    @Test
    public void POSTNewAddonRequest()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","text/plain").header("Content-Type","application/json").header("language_code","en").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).header("login_as_provider","false").body("{"+"\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\","+"\"rooms\":["+"{"+"\"add_on\":["+"{"+"\"_id\":\""+prop.getProperty("WholeHouse_addons[1]._id")+"\","+"\"count\":1"+"}"+"],"+"\"room_id\":\""+prop.getProperty("WholeHouse_id")+"\""+"}"+"],"+"\"selected_custom_addon_manager_requested_ids\":[]"+"}").post("/api/service/new_addon_request");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
