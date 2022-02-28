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

public class TC016_POST_ChecklistImageUpload extends BaseClass {

    @Test
    public void POSTChecklistImageUpload()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        File file = new File("C:/Users/agilepc-142/OneDrive/Pictures/Screenshots/Screenshot (38).png");

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.multiPart("images",file);

        httpRequest.header("Content-Type","multipart/form-data");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/service/checklist/images/upload");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));
        System.out.println("CheckList Uploaded Image URL : "+response.jsonPath().getJsonObject("data.images.url"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            // Set The Properties Value In personal.Properties File
            prop.setProperty("Check_List_Uploaded_Image_Name", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.images.name")));
            prop.setProperty("Check_List_Uploaded_Image_URL", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.images.url")));

            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            // save properties to project root folder
            prop.store(output, "save");
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