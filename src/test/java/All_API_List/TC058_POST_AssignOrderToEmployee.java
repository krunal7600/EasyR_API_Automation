package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC058_POST_AssignOrderToEmployee extends BaseClass {

    @Test
    public void POSTAssignOrderToEmployee() {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("emp_id", prop.getProperty("list_emp_denis_Manager_(Self)_id"));
        requestParams.put("order_id", prop.getProperty("Service_Request_order_id"));

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("language_code", "en");
        httpRequest.header("Authorization", prop.getProperty("Login_Partner_Access_Token"));
        httpRequest.header("login_as_provider", "false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST, "/api/service/assign_order_to_employee");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode, 200);

        System.out.println("Success Message : " + response.jsonPath().getJsonObject("message"));

    }
}
