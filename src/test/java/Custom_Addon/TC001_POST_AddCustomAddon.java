package Custom_Addon;

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

public class TC001_POST_AddCustomAddon extends BaseClass {

    @Test
    public void POSTAddCustomAddon()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        File file = new File(System.getProperty("user.dir")+"./Image/Screenshot (48).png");

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.multiPart("title","Game Room");
        httpRequest.multiPart("max_limit","2");
        httpRequest.multiPart("room_id",prop.getProperty("login_customer_room_type_id1"));
        httpRequest.multiPart("address_id",prop.getProperty("login_customer_default_home_address_id"));
        httpRequest.multiPart("documents",file);

        httpRequest.header("Content-Type","multipart/form-data");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/custom_addon/add");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : " + response.jsonPath().getJsonObject("message"));
        System.out.println("Add_Custom_Addon_Id" + response.jsonPath().<String>getJsonObject("data._id"));
        System.out.println("Add_Custom_Addon_Image_URL" + response.jsonPath().<String>getJsonObject("data.addon_image_url"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set The Properties Value In personal.Properties File
            prop.setProperty("Add_Custom_Addon_Id",response.jsonPath().<String>getJsonObject("data._id"));
            prop.setProperty("Add_Custom_Addon_Image_URL",response.jsonPath().<String>getJsonObject("data.addon_image_url"));

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
