package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class TC003_POST_Login_Employee_Success extends BaseClass {

    @Test
    public void POSTLoginEmployeeSuccess()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("access_role","partner");
        requestParams.put("device_id","be62fd9888b4b65f");
        requestParams.put("device_type","0");
        requestParams.put("email","denisemployee2@yopmail.com");
        requestParams.put("fcm_token","fDDhTN-5wmY:APA91bFHUVF9Q_WS_ZsjjcdVjHJFakvvHngUjHm9NoeMVxo_hrDYBG1wFPIM89sYyPdwJoImAeOQS8-DULx3ANHGWef1QCWkRhKS_HU3Ex0PnbA0-iVUve7r5z3QKo182wxJbuzHr1xP");
        requestParams.put("login_as_provider","false");
        requestParams.put("password","123456");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/auth/login");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        //Get Response Value from JSON Array for Particular field value
        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));
        System.out.println("Access Token : "+response.jsonPath().getJsonObject("data.device_details[0].access_token"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            // set the properties value
            prop.setProperty("Login_Employee_Access_Token", response.jsonPath().<String>getJsonObject("data.device_details[0].access_token"));
            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            // save properties to Personal.Properties file
            prop.store(output, "save");
            System.out.println(prop);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}