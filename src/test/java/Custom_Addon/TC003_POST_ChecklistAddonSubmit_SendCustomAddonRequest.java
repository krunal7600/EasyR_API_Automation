package Custom_Addon;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_POST_ChecklistAddonSubmit_SendCustomAddonRequest extends BaseClass {

    @Test
    public void POSTChecklistAddonSubmit_SendCustomAddonRequest()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

//        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\",\"rooms\":[{\"add_on\":[],\"checklists\":[],\"room_id\":\""+prop.getProperty("WholeHouse_id")+"\"},{\"add_on\":[{\"_id\":\""+prop.getProperty("Kitchen_addons_news[1]._id")+"\",\"count\":1},{\"_id\":\""+prop.getProperty("Add_Custom_Addon_Id")+"\",\"count\":1,\"is_custom\":true}],\"checklists\":[{\"checklist_id\":\""+prop.getProperty("Kitchen_Checklist_id1")+"\",\"count\":1,\"images\":[],\"note\":\"\",\"sub_fields\":[\""+prop.getProperty("Kitchen_Checklist_id1")+"\",\""+prop.getProperty("Kitchen_Checklist_id2")+"\",\""+prop.getProperty("Kitchen_Checklist_id3")+"\",\""+prop.getProperty("Kitchen_Checklist_id4")+"\",\""+prop.getProperty("Kitchen_Checklist_id5")+"\",\""+prop.getProperty("Kitchen_Checklist_id6")+"\",\""+prop.getProperty("Kitchen_Checklist_id7")+"\",\""+prop.getProperty("Kitchen_Checklist_id8")+"\",\""+prop.getProperty("Kitchen_Checklist_id9")+"\",\""+prop.getProperty("Kitchen_Checklist_id10")+"\"]}],\"room_id\":\""+prop.getProperty("Kitchen_id")+"\"}],\"selected_custom_addon_ids\":[\""+prop.getProperty("Add_Custom_Addon_Id")+"\"]}").post("/api/service/checklist_addons/submit");
//        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\",\"rooms\":[{\"add_on\":[],\"checklists\":[],\"room_id\":\""+prop.getProperty("WholeHouse_id")+"\"},{\"add_on\":[{\"_id\":\""+prop.getProperty("Add_Custom_Addon_Id")+"\",\"count\":1,\"is_custom\":true}],\"checklists\":[{\"checklist_id\":\""+prop.getProperty("Kitchen_Checklist_id1")+"\",\"count\":1,\"images\":[],\"note\":\"\",\"sub_fields\":[\""+prop.getProperty("Kitchen_Checklist_id1")+"\",\""+prop.getProperty("Kitchen_Checklist_id2")+"\",\""+prop.getProperty("Kitchen_Checklist_id3")+"\",\""+prop.getProperty("Kitchen_Checklist_id4")+"\",\""+prop.getProperty("Kitchen_Checklist_id5")+"\",\""+prop.getProperty("Kitchen_Checklist_id6")+"\",\""+prop.getProperty("Kitchen_Checklist_id7")+"\",\""+prop.getProperty("Kitchen_Checklist_id8")+"\",\""+prop.getProperty("Kitchen_Checklist_id9")+"\",\""+prop.getProperty("Kitchen_Checklist_id10")+"\"]}],\"room_id\":\""+prop.getProperty("login_customer_room_type_id1")+"\"}],\"selected_custom_addon_ids\":[\""+prop.getProperty("Add_Custom_Addon_Id")+"\"]}").post("/api/service/checklist_addons/submit");
        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\",\"rooms\":[{\"add_on\":[],\"checklists\":[],\"room_id\":\""+prop.getProperty("WholeHouse_id")+"\"},{\"add_on\":[{\"_id\":\""+prop.getProperty("Add_Custom_Addon_Id")+"\",\"count\":1,\"is_custom\":true}],\"checklists\":[{\"checklist_id\":\""+prop.getProperty("Kitchen_Checklist_id1")+"\",\"count\":1,\"images\":[],\"note\":\"\",\"sub_fields\":[\""+prop.getProperty("Kitchen_Checklist_id1")+"\",\""+prop.getProperty("Kitchen_Checklist_id2")+"\",\""+prop.getProperty("Kitchen_Checklist_id3")+"\",\""+prop.getProperty("Kitchen_Checklist_id4")+"\",\""+prop.getProperty("Kitchen_Checklist_id5")+"\",\""+prop.getProperty("Kitchen_Checklist_id6")+"\",\""+prop.getProperty("Kitchen_Checklist_id7")+"\",\""+prop.getProperty("Kitchen_Checklist_id8")+"\",\""+prop.getProperty("Kitchen_Checklist_id9")+"\",\""+prop.getProperty("Kitchen_Checklist_id10")+"\"]}],\"room_id\":\""+prop.getProperty("login_customer_room_type_id1")+"\"}],\"selected_custom_addon_ids\":[\""+prop.getProperty("Add_Custom_Addon_Id")+"\"]}").post("/api/service/checklist_addons/submit");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
