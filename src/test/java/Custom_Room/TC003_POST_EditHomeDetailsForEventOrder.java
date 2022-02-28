package Custom_Room;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_POST_EditHomeDetailsForEventOrder extends BaseClass {

    @Test
    public void POSTEditHomeDetailsForEventOrder()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{"+"\"address_details\":{"+"\"address\":\"Ahmedabad, Gujarat 380007, India\","+"\"apartment_number\":\"4\","+"\"city\":\"Ahmedabad\","+"\"floor\":\"11th\","+"\"house_floor\":\"1\","+"\"house_type\":\"1\","+"\"lat\":50.0051667,"+"\"lng\":75.5832459,"+"\"number_of_floor\":\"5\","+"\"zipcode\":\"380007\","+"\"ground_floor_type\":\"1\","+"\"unit_door\":\"1\""+"},"+"\"cleaning_service\":{"+"\"home_size\":100,"+"\"pets\":["+"{"+"\"count\":1,"+"\"id\":1,"+"\"name\":\"Dog\""+"}"+"],"+"\"room_types\":["+"{"+"\"count\":1,"+"\"room_type_id\":\"5e15687963b97e19d1ef071c\""+"}"+"]"+"},"+"\"window_service\":{"+"\"house_type\":\"\","+"\"windows\":["+"{"+"\"_id\":\"5f6dedb0c4ccf17792001866\","+"\"count\": 2,"+"\"is_double\": true,"+"\"is_single\": true,"+"\"is_storm\": true,"+"\"is_wood\": true"+"},"+"{"+"\"_id\":\"5f6dee02c4ccf17792001867\","+"\"count\": 1,"+"\"is_double\": true,"+"\"is_single\":true,"+"\"is_storm\":true,"+"\"is_wood\":true"+"},"+"{"+"\"_id\":\"5f6def1bc4ccf1779200186a\","+"\"count\": 1,"+"\"is_double\": false,"+"\"is_single\": false,"+"\"is_storm\":false,"+"\"is_wood\":false"+"},"+"{"+"\"_id\":\"5f6df8961df8e131e9d0ff95\","+"\"count\":1,"+"\"is_double\":false,"+"\"is_single\":false,"+"\"is_storm\":true,"+"\"is_wood\":true"+"}"+"]"+"},"+"\"event_home_details_id\":\"614db54c14af3f61f120e199\","+"\"custom_room_ids\":[\"614d7bef3ba028309c4dd146\",\"614c78f5cc3574736497a9a5\"]"+""+"}").post("/api/event/edit_home_details_for_event_order");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
