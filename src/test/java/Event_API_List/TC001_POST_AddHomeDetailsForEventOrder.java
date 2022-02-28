package Event_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_POST_AddHomeDetailsForEventOrder extends BaseClass {

    @Test
    public void POSTAddHomeDetailsForEventOrder()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{"+"\"address_details\":{"+"\"address\":\""+prop.getProperty("login_customer_address")+"\","+"\"apartment_number\":\""+prop.getProperty("apartment_number")+"\","+"\"city\":\""+prop.getProperty("login_customer_city")+"\","+"\"floor\":\""+prop.getProperty("login_customer_floor")+"\","+"\"house_floor\":\""+prop.getProperty("login_customer_house_floor")+"\","+"\"house_type\":\""+prop.getProperty("login_customer_house_type")+"\","+"\"lat\":\""+prop.getProperty("login_customer_lat")+"\","+"\"lng\":\""+prop.getProperty("login_customer_lng")+"\","+"\"number_of_floor\":\""+prop.getProperty("login_customer_number_of_floor")+"\","+"\"zipcode\":\""+prop.getProperty("login_customer_zipcode")+"\","+"\"ground_floor_type\":\""+prop.getProperty("login_customer_ground_floor_type")+"\","+"\"unit_door\":\""+prop.getProperty("login_customer_unit_door")+"\""+"},"+"\"cleaning_service\":{"+"\"home_size\":\""+prop.getProperty("login_customer_home_size")+"\","+"\"pets\":\""+prop.getProperty("login_customer_pets")+"\","+"\"room_types\":["+"{"+"\"count\":1,"+"\"room_type_id\":\""+prop.getProperty("login_customer_room_type_id1")+"\""+"}"+"]"+"},"+"\"window_service\":{"+"\"house_type\":\""+prop.getProperty("login_customer_house_type")+"\","+"\"windows\":[]"+"}"+"}"+"}"+"}").post("/api/event/add_home_details_for_event_order");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}