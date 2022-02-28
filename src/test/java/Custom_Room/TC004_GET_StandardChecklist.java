package Custom_Room;

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

public class TC004_GET_StandardChecklist extends BaseClass {

    @Test
    public void GETStandardChecklist()
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

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.GET,"/api/custom_room/get_standard_checklist");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : " + response.jsonPath().getJsonObject("message"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set The Properties Value In personal.Properties File
            prop.setProperty("Custom_Room_Standard_Checklist_1_Id",response.jsonPath().<String>getJsonObject("data[0]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_2_Id",response.jsonPath().<String>getJsonObject("data[1]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_3_Id",response.jsonPath().<String>getJsonObject("data[2]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_4_Id",response.jsonPath().<String>getJsonObject("data[3]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_5_Id",response.jsonPath().<String>getJsonObject("data[4]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_6_Id",response.jsonPath().<String>getJsonObject("data[5]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_7_Id",response.jsonPath().<String>getJsonObject("data[6]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_8_Id",response.jsonPath().<String>getJsonObject("data[7]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_9_Id",response.jsonPath().<String>getJsonObject("data[8]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_10_Id",response.jsonPath().<String>getJsonObject("data[9]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_11_Id",response.jsonPath().<String>getJsonObject("data[10]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_12_Id",response.jsonPath().<String>getJsonObject("data[11]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_13_Id",response.jsonPath().<String>getJsonObject("data[12]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_14_Id",response.jsonPath().<String>getJsonObject("data[13]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_15_Id",response.jsonPath().<String>getJsonObject("data[14]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_16_Id",response.jsonPath().<String>getJsonObject("data[15]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_17_Id",response.jsonPath().<String>getJsonObject("data[16]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_18_Id",response.jsonPath().<String>getJsonObject("data[17]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_19_Id",response.jsonPath().<String>getJsonObject("data[18]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_20_Id",response.jsonPath().<String>getJsonObject("data[19]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_21_Id",response.jsonPath().<String>getJsonObject("data[20]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_22_Id",response.jsonPath().<String>getJsonObject("data[21]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_23_Id",response.jsonPath().<String>getJsonObject("data[22]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_24_Id",response.jsonPath().<String>getJsonObject("data[23]._id"));
            prop.setProperty("Custom_Room_Standard_Checklist_25_Id",response.jsonPath().<String>getJsonObject("data[24]._id"));

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
