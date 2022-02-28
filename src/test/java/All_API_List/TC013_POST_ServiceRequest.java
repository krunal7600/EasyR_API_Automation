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

public class TC013_POST_ServiceRequest extends BaseClass {

    @Test
    public void POSTServiceRequest()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("address_line","Abhishree Avenue, Surendra Mangaldas Road, Ahmedabad, 380006");
        requestParams.put("apartment_number","");
        requestParams.put("average_rating",0.0);
        requestParams.put("city","");
        requestParams.put("cleaning_area_size_type",10);
        requestParams.put("date_to_start","2022-02-28T09:16:00.000Z");
        requestParams.put("event_home_details_id","615fd20ea11bed186c7ccd5d");
        requestParams.put("floor","");
        requestParams.put("house_floor","1");
        requestParams.put("house_key_note","");
        requestParams.put("house_type","1");
        requestParams.put("is_for_favorite",false);
        requestParams.put("is_repetitive_order",false);
        requestParams.put("is_self_cleaning",false);
        requestParams.put("lat",23.0217537);
        requestParams.put("lng",72.5446148);
        requestParams.put("number_of_floor","2");
        requestParams.put("pets","[]");
        requestParams.put("repeat_days","[]");
        requestParams.put("repeat_in_terms",0);
        requestParams.put("repeat_month_date","2022-02-28T09:16:00.000Z");
        requestParams.put("sub_service_id",prop.getProperty("Private_Cleaning_Sub_Service_Id"));
        requestParams.put("sub_service_type",2);
        requestParams.put("target_provider_type",2);
        requestParams.put("time_range_end","14:46");
        requestParams.put("time_range_start","14:46");
        requestParams.put("unit_door","");
        requestParams.put("zipcode","380006");

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/service/request");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        //Get Response Value from JSON Array for Particular field value
        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));
        System.out.println("Order Id : "+response.jsonPath().getJsonObject("data.order_id"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            // set the properties value
            prop.setProperty("Service_Request_order_id", response.jsonPath().<String>getJsonObject("data.order_id"));
            prop.setProperty("Service_Request_parent_order_id", response.jsonPath().<String>getJsonObject("data.parent_order_id"));
            prop.setProperty("Service_Request_total_providers", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.total_providers")));
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
