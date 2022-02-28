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

public class TC002_POST_Login_Partner_Success extends BaseClass {

    @Test
    public void POSTLoginPartnerSuccess()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("access_role","partner");
        requestParams.put("device_id","05c51d84322dd286");
        requestParams.put("device_type","0");
        requestParams.put("email","denismanager1@yopmail.com");
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
            prop.setProperty("Login_Partner_Access_Token", response.jsonPath().<String>getJsonObject("data.device_details[0].access_token"));
            prop.setProperty("login_partner_customer_id", response.jsonPath().<String>getJsonObject("data.customer_id"));
            prop.setProperty("login_partner_first_name", response.jsonPath().<String>getJsonObject("data.first_name"));
            prop.setProperty("login_partner_last_name", response.jsonPath().<String>getJsonObject("data.last_name"));
            prop.setProperty("login_partner_house_type", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.house_type")));
            prop.setProperty("login_partner_customer_id", response.jsonPath().<String>getJsonObject("data.customer_id"));
            prop.setProperty("login_partner_number_of_floor", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.number_of_floor")));
            prop.setProperty("login_partner_house_floor", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.house_floor")));
            prop.setProperty("login_partner_ground_floor_type", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.ground_floor_type")));
            prop.setProperty("login_partner_languages_known", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.languages_known")));
            prop.setProperty("login_partner_selected_language", response.jsonPath().<String>getJsonObject("data.selected_language"));
            prop.setProperty("login_partner_provided_services", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.provided_services")));
            prop.setProperty("login_partner__id", response.jsonPath().<String>getJsonObject("data._id"));
            prop.setProperty("login_partner_email", response.jsonPath().<String>getJsonObject("data.email"));
            prop.setProperty("login_partner_access_role", response.jsonPath().<String>getJsonObject("data.access_role"));
            prop.setProperty("login_partner_company_id", response.jsonPath().<String>getJsonObject("data.company_id"));
            prop.setProperty("login_partner_created_at", response.jsonPath().<String>getJsonObject("data.created_at"));
            prop.setProperty("login_partner_gender", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.gender")));
            prop.setProperty("login_partner_mobile_number", response.jsonPath().<String>getJsonObject("data.mobile_number"));
            prop.setProperty("login_partner_user_type", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.user_type")));
            prop.setProperty("login_partner_employee_count", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.employee_count")));

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
