package Custom_Room;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_AddHomeDetailsForEventOrder extends BaseClass {

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

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{"+"\"address_details\":{"+"\"address\":\"Gujarat 380007, India\","+"\"apartment_number\":\"\","+"\"city\":\"Ahmedabad\","+"\"floor\":\"7th\","+"\"house_floor\":\"1\","+"\"house_type\":\"1\","+"\"lat\":23.0051667,"+"\"lng\":72.5832459,"+"\"number_of_floor\":\"2\","+"\"zipcode\":\"380022\","+"\"ground_floor_type\":\"1\","+"\"unit_door\":\"1\""+"},"+"\"cleaning_service\":{"+"\"home_size\":500,"+"\"pets\":["+"{"+"\"count\":1,"+"\"id\":1,"+"\"name\":\"Dog\""+"}"+"],"+"\"room_types\":["+"{"+"\"count\":1,"+"\"room_type_id\":\"5e15687963b97e19d1ef071c\""+"},"+"{"+"\"count\":2,"+"\"room_type_id\":\"614c7794bb7a207017c5e893\""+"},"+"{"+"\"count\":3,"+"\"room_type_id\":\"614c78f5cc3574736497a9a5\""+"}"+"]"+"},"+"\"custom_room_ids\":[\"614c7794bb7a207017c5e893\",\"614c78f5cc3574736497a9a5\"]"+""+"}").post("/api/event/add_home_details_for_event_order");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}