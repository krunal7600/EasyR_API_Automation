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

public class TC004_GET_Metadata extends BaseClass {

    @Test
    public void GETMetadata()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/auth/metaData");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);


        System.out.println("Success Message : " +response.jsonPath().getJsonObject("message"));
        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set the properties value
            prop.setProperty("Private_Cleaning_Id",response.jsonPath().<String>getJsonObject("data.services[0].main._id"));
            prop.setProperty("Private_Cleaning_Name",response.jsonPath().<String>getJsonObject("data.services[0].main.name"));
            prop.setProperty("Private_Cleaning_Mapping_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.services[0].main.mapping_id")));
            prop.setProperty("Private_Cleaning_Country_Id",response.jsonPath().<String>getJsonObject("data.services[0].main.country_id"));

            prop.setProperty("Private_Cleaning_Sub_Service_Type", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.services[0].sub.service_type[0]")));
            prop.setProperty("Private_Cleaning_Sub_Service_Id",response.jsonPath().<String>getJsonObject("data.services[0].sub._id[0]"));
            prop.setProperty("Private_Cleaning_Sub_Service_Mapping_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.services[0].sub.mapping_id[0]")));
            prop.setProperty("Private_Cleaning_Sub_Service_Name",response.jsonPath().<String>getJsonObject("data.services[0].sub.name[0]"));

            prop.setProperty("Moving_In_and_Out_Cleaning_Service_Type", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.services[0].sub.service_type[1]")));
            prop.setProperty("Moving_In_and_Out_Cleaning_Sub_Service_Id",response.jsonPath().<String>getJsonObject("data.services[0].sub._id[1]"));
            prop.setProperty("Moving_In_and_Out_Cleaning_Sub_Service_Mapping_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.services[0].sub.mapping_id[1]")));
            prop.setProperty("Moving_In_and_Out_Cleaning_Sub_Service_Name",response.jsonPath().<String>getJsonObject("data.services[0].sub.name[1]"));

            prop.setProperty("Deep_Cleaning_Sub_Service_Type", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.services[0].sub.service_type[2]")));
            prop.setProperty("Deep_Cleaning_Sub_Service_Id",response.jsonPath().<String>getJsonObject("data.services[0].sub._id[2]"));
            prop.setProperty("Deep_Cleaning_Sub_Service_Mapping_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.services[0].sub.mapping_id[2]")));
            prop.setProperty("Deep_Cleaning_Sub_Service_Name",response.jsonPath().<String>getJsonObject("data.services[0].sub.name[2]"));

            prop.setProperty("Window_Cleaning_Id",response.jsonPath().<String>getJsonObject("data.services[1].main._id"));
            prop.setProperty("Window_Cleaning_Name",response.jsonPath().<String>getJsonObject("data.services[1].main.name"));
            prop.setProperty("Window_Cleaning_Mapping_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.services[1].main.mapping_id")));
            prop.setProperty("Window_Cleaning_Country_Id",response.jsonPath().<String>getJsonObject("data.services[1].main.country_id"));

            prop.setProperty("Window_Cleaning_Sub_Service_Type", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.services[1].sub.service_type[0]")));
            prop.setProperty("Window_Cleaning_Sub_Service_Id",response.jsonPath().<String>getJsonObject("data.services[1].sub._id[0]"));
            prop.setProperty("Window_Cleaning_Sub_Service_Mapping_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.services[1].sub.mapping_id[0]")));
            prop.setProperty("Window_Cleaning_Sub_Service_Name",response.jsonPath().<String>getJsonObject("data.services[1].sub.name[0]"));


            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            //Save properties to Personal.Properties file
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
