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

public class TC012_GET_HomeDetailsKeys extends BaseClass {

    @Test
    public void GETHomeDetailsKeys()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.GET,"/api/home_details/keys/" + prop.getProperty("login_customer_default_home_address_id"));

        //Print Response in Console Window
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

            //Set the properties value
            prop.setProperty("Single_Window_1_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[0]._id"));
            prop.setProperty("Single_Window_2_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[1]._id"));
            prop.setProperty("Single_Window_3_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[2]._id"));
            prop.setProperty("Single_Window_4_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[3]._id"));
            prop.setProperty("Single_Window_5_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[4]._id"));
            prop.setProperty("Single_Window_6_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[5]._id"));
            prop.setProperty("Single_Window_7_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[6]._id"));
            prop.setProperty("Single_Window_8_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[7]._id"));
            prop.setProperty("Single_Window_9_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[8]._id"));
            prop.setProperty("Single_Window_10_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[9]._id"));
            prop.setProperty("Single_Window_11_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[10]._id"));
            prop.setProperty("Single_Window_12_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[0].windows[11]._id"));

            prop.setProperty("Double_Window_1_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[0]._id"));
            prop.setProperty("Double_Window_2_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[1]._id"));
            prop.setProperty("Double_Window_3_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[2]._id"));
            prop.setProperty("Double_Window_4_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[3]._id"));
            prop.setProperty("Double_Window_5_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[4]._id"));
            prop.setProperty("Double_Window_6_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[5]._id"));
            prop.setProperty("Double_Window_7_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[6]._id"));
            prop.setProperty("Double_Window_8_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[7]._id"));
            prop.setProperty("Double_Window_9_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[8]._id"));
            prop.setProperty("Double_Window_10_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[9]._id"));
            prop.setProperty("Double_Window_11_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[10]._id"));
            prop.setProperty("Double_Window_12_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[1].windows[11]._id"));

            prop.setProperty("Triple_Window_1_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[0]._id"));
            prop.setProperty("Triple_Window_2_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[1]._id"));
            prop.setProperty("Triple_Window_3_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[2]._id"));
            prop.setProperty("Triple_Window_4_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[3]._id"));
            prop.setProperty("Triple_Window_5_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[4]._id"));
            prop.setProperty("Triple_Window_6_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[5]._id"));
            prop.setProperty("Triple_Window_7_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[6]._id"));
            prop.setProperty("Triple_Window_8_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[7]._id"));
            prop.setProperty("Triple_Window_9_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[8]._id"));
            prop.setProperty("Triple_Window_10_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[9]._id"));
            prop.setProperty("Triple_Window_11_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[10]._id"));
            prop.setProperty("Triple_Window_12_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[2].windows[11]._id"));

            prop.setProperty("Door_Window_1_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[0]._id"));
            prop.setProperty("Door_Window_2_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[1]._id"));
            prop.setProperty("Door_Window_3_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[2]._id"));
            prop.setProperty("Door_Window_4_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[3]._id"));
            prop.setProperty("Door_Window_5_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[4]._id"));
            prop.setProperty("Door_Window_6_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[5]._id"));
            prop.setProperty("Door_Window_7_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[3].windows[6]._id"));

            prop.setProperty("Special_Window_1_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[0]._id"));
            prop.setProperty("Special_Window_2_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[1]._id"));
            prop.setProperty("Special_Window_3_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[2]._id"));
            prop.setProperty("Special_Window_4_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[3]._id"));
            prop.setProperty("Special_Window_5_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[4]._id"));
            prop.setProperty("Special_Window_6_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[5]._id"));
            prop.setProperty("Special_Window_7_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[6]._id"));
            prop.setProperty("Special_Window_8_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[7]._id"));
            prop.setProperty("Special_Window_9_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[8]._id"));
            prop.setProperty("Special_Window_10_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[9]._id"));
            prop.setProperty("Special_Window_11_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[10]._id"));
            prop.setProperty("Special_Window_12_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[11]._id"));
            prop.setProperty("Special_Window_13_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[12]._id"));
            prop.setProperty("Special_Window_14_Id : ",response.jsonPath().<String>getJsonObject("data.window_service[4].windows[13]._id"));

            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            // save properties to project root folder
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