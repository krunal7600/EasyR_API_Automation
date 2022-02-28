package Custom_Room;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_POST_AddDefaultHome extends BaseClass {

    @Test
    public void POSTAddDefaultHome()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{"+"\"address_details\":{"+"\"address\":\"Gujarat 380007, India\","+"\"apartment_number\":\"\","+"\"city\":\"Ahmedabad\","+"\"floor\":\"11th\","+"\"house_floor\":\"1\","+"\"house_type\":\"1\","+"\"lat\":23.0051667,"+"\"lng\":72.5832459,"+"\"number_of_floor\":\"2\","+"\"zipcode\":\"380022\","+"\"ground_floor_type\":\"1\","+"\"unit_door\":\"1\""+"},"+"\"cleaning_service\":{"+"\"home_size\":100,"+"\"pets\":["+"{"+"\"count\":1,"+"\"id\": 1,"+"\"name\":\"Dog\""+"}"+"],"+"\"room_types\":["+"{"+"\"count\":1,"+"\"room_type_id\":\"5e15687963b97e19d1ef071c\""+"},"+"{"+"\"count\":1,"+"\"room_type_id\":\"614da8dc068321514de40345\""+"}"+"]"+"},"+"\"window_service\":{"+"\"house_type\":\"\","+"\"windows\":["+"{"+"\"_id\":\"5f6dedb0c4ccf17792001866\","+"\"count\": 2,"+"\"is_double\":true,"+"\"is_single\":true,"+"\"is_storm\":true,"+"\"is_wood\":true"+"},"+"{"+"\"_id\":\"5f6dee02c4ccf17792001867\","+"\"count\":1,"+"\"is_double\":true,"+"\"is_single\":true,"+"\"is_storm\":true,"+"\"is_wood\":true"+"},"+"{"+"\"_id\":\"5f6def1bc4ccf1779200186a\","+"\"count\":1,"+"\"is_double\":false,"+"\"is_single\":false,"+"\"is_storm\":false,"+"\"is_wood\":false"+"},"+"{"+"\"_id\":\"5f6df8961df8e131e9d0ff95\","+"\"count\":1,"+"\"is_double\":false,"+"\"is_single\":false,"+"\"is_storm\":true,"+"\"is_wood\":true"+"}"+"]"+"},"+"\"custom_room_ids\":[\"614da8dc068321514de40345\"]"+"}").post("/api/add_home_details");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}