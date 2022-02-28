package All_API_List;

import BaseClass.BaseClass;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class TC056_POST_GetHomeDetails extends BaseClass {

    @Test
    public void POSTGetHomeDetails()
    {
        //Specify Base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Request And Sending A Parameters For POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("order_id",prop.getProperty("Service_Request_order_id"));
        requestParams.put("user_id",prop.getProperty("login_customer__id"));

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/get_home_details");

        //Print Response In Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set The Properties Value In personal.Properties File
            prop.setProperty("GetHomeDetails_RoomTypeId",String.valueOf(response.jsonPath().<String>getJsonObject("data.list[0].room_type_id")));
            prop.setProperty("GetHomeDetails_Count",String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].count")));

            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            //Save properties to project root folder
            prop.store(output,"save");
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