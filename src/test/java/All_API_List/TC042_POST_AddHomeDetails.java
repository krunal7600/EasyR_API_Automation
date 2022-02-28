package All_API_List;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC042_POST_AddHomeDetails extends BaseClass {

    @Test
    public void POSTAddHomeDetails()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","text/plain").header("Content-Type","application/json").header("language_code","en").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).header("login_as_provider","false").body("{\"address_details\":{\"address\":\"C-17, Ravi Nagar School Rd, Bhagyoday Society, Vibhavari Society, Juhapura, Ahmedabad, Gujarat 380051, India\",\"apartment_number\":\"\",\"city\":\"Ahmedabad\",\"floor\":\"5\",\"ground_floor_type\":\"1\",\"house_floor\":\"1\",\"house_type\":\"2\",\"lat\":23.0037523,\"lng\":72.532217,\"number_of_floor\":\"1\",\"unit_door\":\"test\",\"zipcode\":\"380051\"},\"cleaning_service\":{\"home_size\":100,\"pets\":[{\"count\":2,\"id\":1,\"name\":\"Dog\"}],\"room_types\":[{\"count\":1,\"room_type_id\":\"5e15687963b97e19d1ef071c\"},{\"count\":1,\"room_type_id\":\"5e1568c163b97e19d1ef071d\"},{\"count\":1,\"room_type_id\":\"5e1568f163b97e19d1ef071f\"},{\"count\":1,\"room_type_id\":\"5e4f9a033e699b0019c2f6bb\"}]},\"window_service\":{\"house_type\":\"\",\"windows\":[{\"_id\":\"5f6dedb0c4ccf17792001866\",\"count\":2,\"is_double\":true,\"is_single\":true,\"is_storm\":true,\"is_wood\":true},{\"_id\":\"5f6dee02c4ccf17792001867\",\"count\":1,\"is_double\":true,\"is_single\":true,\"is_storm\":true,\"is_wood\":true},{\"_id\":\"5f6def1bc4ccf1779200186a\",\"count\":1,\"is_double\":false,\"is_single\":false,\"is_storm\":false,\"is_wood\":false},{\"_id\":\"5f6df110c4ccf1779200189a\",\"count\":1,\"is_double\":false,\"is_single\":false,\"is_storm\":true,\"is_wood\":false},{\"_id\":\"5f6df8961df8e131e9d0ff95\",\"count\":1,\"is_double\":false,\"is_single\":false,\"is_storm\":true,\"is_wood\":true},{\"_id\":\"5f6df92e1df8e131e9d0ff9b\",\"count\":1,\"is_double\":false,\"is_single\":false,\"is_storm\":false,\"is_wood\":false}]}}").post("/api/add_home_details");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
