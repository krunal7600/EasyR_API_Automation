package Custom_Addon;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC008_POST_SubmitPrice_Company extends BaseClass {

    @Test
    public void POSTSubmitPrice_Company()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Partner_Access_Token")).body("{"+"\"price_details\":[{\"_id\":\"615b2298bd37c345ba3a8568\",\"price\":522}],"+"\"order_id\":\"615d4f011a15132795eb927f\""+"}").post("/api/custom_addon/submit_price");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
