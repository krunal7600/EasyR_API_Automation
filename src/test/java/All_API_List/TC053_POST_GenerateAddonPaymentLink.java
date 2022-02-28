package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC053_POST_GenerateAddonPaymentLink extends BaseClass {

    @Test
    public void POSTGenerateAddonPaymentLink()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        String abc = new String(prop.getProperty("total_addon_amount"));
        System.out.println(abc);
        Float total_amount = new Float(abc);
        System.out.println(total_amount);

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("addon_payent_type",2);
        requestParams.put("addon_request_id",prop.getProperty("addon_request_id"));
        requestParams.put("order_addon_amount",total_amount);
        requestParams.put("order_id",prop.getProperty("Service_Request_order_id"));
        requestParams.put("reepay_customer_id",prop.getProperty("login_customer_reepay_customer_id"));

//        requestParams.put("addon_payent_type",2);
//        requestParams.put("addon_request_id","61f927a9de8376448ac630cd");
//        requestParams.put("order_addon_amount",13.75);
//        requestParams.put("order_id","61f9272dde8376448ac630b8");
//        requestParams.put("reepay_customer_id","cust-0142");

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/reepay/generate_addon_payment_link");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));
        System.out.println("Addon_Payment_URL : "+response.jsonPath().getJsonObject("data.url"));
    }
}