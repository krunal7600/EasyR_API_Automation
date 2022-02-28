package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_POST_AppTheme extends BaseClass {

    @Test
    public void POSTAppTheme()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("access_role",prop.getProperty("login_customer_access_role"));
        requestParams.put("device_id",prop.getProperty("login_customer_device_id"));
        requestParams.put("device_type","0");
        requestParams.put("email",prop.getProperty("login_customer_email"));
        requestParams.put("fcm_token","fDDhTN-5wmY:APA91bFHUVF9Q_WS_ZsjjcdVjHJFakvvHngUjHm9NoeMVxo_hrDYBG1wFPIM89sYyPdwJoImAeOQS8-DULx3ANHGWef1QCWkRhKS_HU3Ex0PnbA0-iVUve7r5z3QKo182wxJbuzHr1xP");
        requestParams.put("login_as_provider","false");
        requestParams.put("password","123456");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/auth/appTheme");

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
