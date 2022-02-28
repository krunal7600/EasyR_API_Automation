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

public class TC024_POST_JobDetails_CustomerSide extends BaseClass {

    @Test
    public void POSTJobDetailsCustomerSide()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("order_id",prop.getProperty("Service_Request_order_id"));

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/job/details");

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

            //Set The Properties Value In personal.Properties File
            prop.setProperty("accepted_by", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.accepted_by")));
            prop.setProperty("order_display_id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.order_display_id")));
            prop.setProperty("Order_Status", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.order_status")));

            prop.setProperty("room_type_id", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.room_types.checklists.room_type_id")));
            prop.setProperty("uid", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.room_types.checklists.uid")));
            prop.setProperty("room_checklist_id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.room_types.checklists.room_checklist_id")));
            prop.setProperty("count", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.room_types.checklists.count")));

            prop.setProperty("addon_id_1", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.room_types.checklists.addons[0].addon_id[0]")));
            prop.setProperty("uid_1", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.room_types.checklists.addons[0].uid[0]")));
            prop.setProperty("room_addon_id_1", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.room_types.checklists.addons[0].room_addon_id[0]")));
            prop.setProperty("count_1", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.room_types.checklists.addons[0].count[0]")));

            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            //Save properties to project root folder
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
