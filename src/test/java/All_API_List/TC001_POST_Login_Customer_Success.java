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

public class TC001_POST_Login_Customer_Success extends BaseClass {

    @Test
    public void POSTLoginCustomerSuccess()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("access_role","customer");
        requestParams.put("device_id","be62fd9888b4b65f");
        requestParams.put("device_type","0");
        requestParams.put("email","krunalparekh97agileinfoways@gmail.com");
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

            // Set The Properties Value In personal.Properties File
            prop.setProperty("Login_Customer_Access_Token", response.jsonPath().<String>getJsonObject("data.device_details[0].access_token"));
            prop.setProperty("login_customer_customer_id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.customer_id")));
            prop.setProperty("login_customer_first_name", response.jsonPath().<String>getJsonObject("data.first_name") );
            prop.setProperty("login_customer_last_name", response.jsonPath().<String>getJsonObject("data.last_name") );
            prop.setProperty("login_customer_favourite_providers1", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.favourite_providers[0]")));
            prop.setProperty("login_customer_favourite_providers2", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.favourite_providers[1]")));
            prop.setProperty("login_customer_pets", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.pets")));
            prop.setProperty("login_customer_average_rating", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.average_rating")));
            prop.setProperty("login_customer_requested_for_service_provider", String.valueOf(response.jsonPath().<Boolean>getJsonObject("data.requested_for_service_provider")));
            prop.setProperty("login_customer_selected_language", response.jsonPath().<String>getJsonObject("data.selected_language") );
            prop.setProperty("login_customer_device_id", response.jsonPath().<String>getJsonObject("data.device_details[0].device_id") );
            prop.setProperty("login_customer__id", response.jsonPath().<String>getJsonObject("data._id") );
            prop.setProperty("login_customer_email", response.jsonPath().<String>getJsonObject("data.email") );
            prop.setProperty("login_customer_country_code", response.jsonPath().<String>getJsonObject("data.country_code") );
            prop.setProperty("login_customer_mobile_number", response.jsonPath().<String>getJsonObject("data.mobile_number") );
            prop.setProperty("login_customer_access_role", response.jsonPath().<String>getJsonObject("data.access_role") );
            prop.setProperty("login_customer_user_type", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.user_type")));
            prop.setProperty("login_customer_reepay_customer_id", response.jsonPath().<String>getJsonObject("data.reepay_customer_id") );
            prop.setProperty("login_customer_updated_at", response.jsonPath().<String>getJsonObject("data.updated_at") );
            prop.setProperty("login_customer_created_at", response.jsonPath().<String>getJsonObject("data.created_at") );
            prop.setProperty("login_customer_address", response.jsonPath().<String>getJsonObject("data.address") );
            prop.setProperty("apartment_number", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.home_details[0].address_details[0].apartment_number")));
            prop.setProperty("login_customer_city", response.jsonPath().<String>getJsonObject("data.home_details.address_details.city") );
            prop.setProperty("login_customer_floor", response.jsonPath().<String>getJsonObject("data.home_details.address_details.floor") );
            prop.setProperty("login_customer_house_floor", response.jsonPath().<String>getJsonObject("data.home_details.address_details.house_floor") );
            prop.setProperty("login_customer_house_type", response.jsonPath().<String>getJsonObject("data.home_details.address_details.house_type") );
            prop.setProperty("login_customer_lat", String.valueOf(response.jsonPath().<Float>getJsonObject("data.home_details.address_details.lat")));
            prop.setProperty("login_customer_lng", String.valueOf(response.jsonPath().<Float>getJsonObject("data.home_details.address_details.lng")));
            prop.setProperty("login_customer_number_of_floor", response.jsonPath().<String>getJsonObject("data.home_details.address_details.number_of_floor") );
            prop.setProperty("login_customer_zipcode", response.jsonPath().<String>getJsonObject("data.home_details.address_details.zipcode") );
            prop.setProperty("login_customer_ground_floor_type", response.jsonPath().<String>getJsonObject("data.home_details.address_details.ground_floor_type") );
            prop.setProperty("login_customer_unit_door", response.jsonPath().<String>getJsonObject("data.home_details.address_details.unit_door") );
            prop.setProperty("login_customer_home_size", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.home_details.cleaning_service.home_size")));
            prop.setProperty("login_customer_pets.count", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.home_details.cleaning_service.pets.count")));
            prop.setProperty("login_customer_pets.id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.home_details.cleaning_service.pets.id")));
            prop.setProperty("login_customer_pets.name", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.home_details.cleaning_service.pets.name")));
            prop.setProperty("login_customer_room_type_id1", response.jsonPath().<String>getJsonObject("data.home_details.cleaning_service.room_types.room_type_id[0]") );
            prop.setProperty("login_customer_default_home_address_id", response.jsonPath().<String>getJsonObject("data.home_details.default_home_address_id") );

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