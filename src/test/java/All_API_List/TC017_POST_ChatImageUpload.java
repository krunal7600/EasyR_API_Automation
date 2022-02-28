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

public class TC017_POST_ChatImageUpload extends BaseClass {

    @Test
    public void POSTChatImageUpload()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        File file = new File("C:/Users/agilepc-142/OneDrive/Pictures/Screenshots/Screenshot (38).png");

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.multiPart("documents",file);
        httpRequest.multiPart("fileType",".png");

        httpRequest.header("Content-Type","multipart/form-data");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/chatService/uploadChatMedia");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));
        System.out.println("Chat Uploaded Image URL : "+response.jsonPath().getJsonObject("data.mediaUrl"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            // Set The Properties Value In personal.Properties File
            prop.setProperty("Chat_Uploaded_Image_URL", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.mediaUrl")));

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