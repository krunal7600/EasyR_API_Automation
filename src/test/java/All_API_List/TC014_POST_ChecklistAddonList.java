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

public class TC014_POST_ChecklistAddonList extends BaseClass {

    @Test
    public void POSTChecklistAddonList()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("address_id",prop.getProperty("login_customer_default_home_address_id"));
        requestParams.put("order_id",prop.getProperty("Service_Request_order_id"));

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/service/checklist_addons/list");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        //Get Response Value from JSON Array for Particular field value
        System.out.println("Success Message : " + response.jsonPath().getJsonObject("message"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            // set the properties value
            prop.setProperty("WholeHouse_id",response.jsonPath().<String>getJsonObject("data.list[0]._id"));
            prop.setProperty("WholeHouse_room_type_name",response.jsonPath().<String>getJsonObject("data.list[0].room_type_name"));
            prop.setProperty("WholeHouse_addons[0]._id",response.jsonPath().<String>getJsonObject("data.list[0].checklists[0].addons[0]._id"));
            prop.setProperty("WholeHouse_addons[0].sub_service_id",response.jsonPath().<String>getJsonObject("data.list[0].checklists[0].addons[0].sub_service_id"));
            prop.setProperty("WholeHouse_addons[0].title",response.jsonPath().<String>getJsonObject("data.list[0].checklists[0].addons[0].title"));
            prop.setProperty("WholeHouse_addons[1]._id",response.jsonPath().<String>getJsonObject("data.list[0].checklists[0].addons[1]._id"));
            prop.setProperty("WholeHouse_addons[1].title",response.jsonPath().<String>getJsonObject("data.list[0].checklists[0].addons[1].title"));
            prop.setProperty("WholeHouse_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[0].addons_new[0]._id"));
            prop.setProperty("WholeHouse_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[0].addons_new[0].title"));

            prop.setProperty("Kitchen_id",response.jsonPath().<String>getJsonObject("data.list[1]._id"));
            prop.setProperty("Kitchen_room_type_name",response.jsonPath().<String>getJsonObject("data.list[1].room_type_name"));
            prop.setProperty("Kitchen_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Kitchen_Title1",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[0].title"));
            prop.setProperty("Kitchen_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Kitchen_Title2",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[1].title"));
            prop.setProperty("Kitchen_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Kitchen_Title3",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[2].title"));
            prop.setProperty("Kitchen_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Kitchen_Title4",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[3].title"));
            prop.setProperty("Kitchen_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Kitchen_Title5",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[4].title"));
            prop.setProperty("Kitchen_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Kitchen_Title6",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[5].title"));
            prop.setProperty("Kitchen_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Kitchen_Title7",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[6].title"));
            prop.setProperty("Kitchen_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Kitchen_Title8",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[7].title"));
            prop.setProperty("Kitchen_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Kitchen_Title9",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[8].title"));
            prop.setProperty("Kitchen_Checklist_id10",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[9].checklist_id"));
            prop.setProperty("Kitchen_Title10",response.jsonPath().<String>getJsonObject("data.list[1].checklists[0].sub_fields[9].title"));

            prop.setProperty("Kitchen_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[0]._id"));
            prop.setProperty("Kitchen_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[0].title"));
            prop.setProperty("Kitchen_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[1]._id"));
            prop.setProperty("Kitchen_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[1].title"));
            prop.setProperty("Kitchen_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[2]._id"));
            prop.setProperty("Kitchen_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[2].title"));
            prop.setProperty("Kitchen_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[3]._id"));
            prop.setProperty("Kitchen_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[3].title"));
            prop.setProperty("Kitchen_addons_news[5]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[4]._id"));
            prop.setProperty("Kitchen_addons_news[5].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[4].title"));
            prop.setProperty("Kitchen_addons_news[6]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[5]._id"));
            prop.setProperty("Kitchen_addons_news[6].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[5].title"));
            prop.setProperty("Kitchen_addons_news[7]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[6]._id"));
            prop.setProperty("Kitchen_addons_news[7].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[6].title"));
            prop.setProperty("Kitchen_addons_news[8]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[7]._id"));
            prop.setProperty("Kitchen_addons_news[8].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[7].title"));
            prop.setProperty("Kitchen_addons_news[9]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[8]._id"));
            prop.setProperty("Kitchen_addons_news[9].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[8].title"));
            prop.setProperty("Kitchen_addons_news[10]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[9]._id"));
            prop.setProperty("Kitchen_addons_news[10].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[9].title"));
            prop.setProperty("Kitchen_addons_news[11]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[10]._id"));
            prop.setProperty("Kitchen_addons_news[11].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[10].title"));
            prop.setProperty("Kitchen_addons_news[12]._id",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[11]._id"));
            prop.setProperty("Kitchen_addons_news[12].title",response.jsonPath().<String>getJsonObject("data.list[1].addons_new[11].title"));

            prop.setProperty("Bedroom_id",response.jsonPath().<String>getJsonObject("data.list[2]._id"));
            prop.setProperty("Bedroom_room_type_name",response.jsonPath().<String>getJsonObject("data.list[2].room_type_name"));
            prop.setProperty("Bedroom_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Bedroom_Title1",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[0].title"));
            prop.setProperty("Bedroom_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Bedroom_Title2",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[1].title"));
            prop.setProperty("Bedroom_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Bedroom_Title3",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[2].title"));
            prop.setProperty("Bedroom_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Bedroom_Title4",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[3].title"));
            prop.setProperty("Bedroom_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Bedroom_Title5",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[4].title"));
            prop.setProperty("Bedroom_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Bedroom_Title6",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[5].title"));
            prop.setProperty("Bedroom_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Bedroom_Title7",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[6].title"));
            prop.setProperty("Bedroom_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Bedroom_Title8",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[7].title"));
            prop.setProperty("Bedroom_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Bedroom_Title9",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[8].title"));
            prop.setProperty("Bedroom_Checklist_id10",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[9].checklist_id"));
            prop.setProperty("Bedroom_Title10",response.jsonPath().<String>getJsonObject("data.list[2].checklists[0].sub_fields[9].title"));

            prop.setProperty("Bedroom_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[0]._id"));
            prop.setProperty("Bedroom_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[0].title"));
            prop.setProperty("Bedroom_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[1]._id"));
            prop.setProperty("Bedroom_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[1].title"));
            prop.setProperty("Bedroom_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[2]._id"));
            prop.setProperty("Bedroom_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[2].title"));
            prop.setProperty("Bedroom_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[3]._id"));
            prop.setProperty("Bedroom_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[2].addons_new[3].title"));

            prop.setProperty("Bathroom_id",response.jsonPath().<String>getJsonObject("data.list[3]._id"));
            prop.setProperty("Bathroom_room_type_name",response.jsonPath().<String>getJsonObject("data.list[3].room_type_name"));
            prop.setProperty("Bathroom_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Bathroom_Title1",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[0].title"));
            prop.setProperty("Bathroom_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Bathroom_Title2",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[1].title"));
            prop.setProperty("Bathroom_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Bathroom_Title3",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[2].title"));
            prop.setProperty("Bathroom_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Bathroom_Title4",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[3].title"));
            prop.setProperty("Bathroom_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Bathroom_Title5",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[4].title"));
            prop.setProperty("Bathroom_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Bathroom_Title6",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[5].title"));
            prop.setProperty("Bathroom_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Bathroom_Title7",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[6].title"));
            prop.setProperty("Bathroom_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Bathroom_Title8",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[7].title"));
            prop.setProperty("Bathroom_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Bathroom_Title9",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[8].title"));
            prop.setProperty("Bathroom_Checklist_id10",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[9].checklist_id"));
            prop.setProperty("Bathroom_Title10",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[9].title"));
            prop.setProperty("Bathroom_Checklist_id11",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[10].checklist_id"));
            prop.setProperty("Bathroom_Title11",response.jsonPath().<String>getJsonObject("data.list[3].checklists[0].sub_fields[10].title"));

            prop.setProperty("Bathroom_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[0]._id"));
            prop.setProperty("Bathroom_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[0].title"));
            prop.setProperty("Bathroom_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[1]._id"));
            prop.setProperty("Bathroom_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[1].title"));
            prop.setProperty("Bathroom_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[2]._id"));
            prop.setProperty("Bathroom_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[2].title"));
            prop.setProperty("Bathroom_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[3]._id"));
            prop.setProperty("Bathroom_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[3].title"));
            prop.setProperty("Bathroom_addons_news[5]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[4]._id"));
            prop.setProperty("Bathroom_addons_news[5].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[4].title"));
            prop.setProperty("Bathroom_addons_news[6]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[5]._id"));
            prop.setProperty("Bathroom_addons_news[6].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[5].title"));
            prop.setProperty("Bathroom_addons_news[7]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[6]._id"));
            prop.setProperty("Bathroom_addons_news[7].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[6].title"));
            prop.setProperty("Bathroom_addons_news[8]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[7]._id"));
            prop.setProperty("Bathroom_addons_news[8].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[7].title"));
            prop.setProperty("Bathroom_addons_news[9]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[8]._id"));
            prop.setProperty("Bathroom_addons_news[9].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[8].title"));
            prop.setProperty("Bathroom_addons_news[10]._id",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[9]._id"));
            prop.setProperty("Bathroom_addons_news[10].title",response.jsonPath().<String>getJsonObject("data.list[3].addons_new[9].title"));

            prop.setProperty("Living room_id",response.jsonPath().<String>getJsonObject("data.list[4]._id"));
            prop.setProperty("Living room_room_type_name",response.jsonPath().<String>getJsonObject("data.list[4].room_type_name"));
            prop.setProperty("Living room_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Living room_Title1",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[0].title"));
            prop.setProperty("Living room_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Living room_Title2",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[1].title"));
            prop.setProperty("Living room_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Living room_Title3",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[2].title"));
            prop.setProperty("Living room_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Living room_Title4",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[3].title"));
            prop.setProperty("Living room_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Living room_Title5",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[4].title"));
            prop.setProperty("Living room_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Living room_Title6",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[5].title"));
            prop.setProperty("Living room_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Living room_Title7",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[6].title"));
            prop.setProperty("Living room_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Living room_Title8",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[7].title"));
            prop.setProperty("Living room_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Living room_Title9",response.jsonPath().<String>getJsonObject("data.list[4].checklists[0].sub_fields[8].title"));

            prop.setProperty("Living room_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[0]._id"));
            prop.setProperty("Living room_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[0].title"));
            prop.setProperty("Living room_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[1]._id"));
            prop.setProperty("Living room_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[1].title"));
            prop.setProperty("Living room_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[2]._id"));
            prop.setProperty("Living room_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[2].title"));
            prop.setProperty("Living room_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[3]._id"));
            prop.setProperty("Living room_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[4].addons_new[3].title"));

            prop.setProperty("Hallways_id",response.jsonPath().<String>getJsonObject("data.list[5]._id"));
            prop.setProperty("Hallways_room_type_name",response.jsonPath().<String>getJsonObject("data.list[5].room_type_name"));
            prop.setProperty("Hallways_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Hallways_Title1",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[0].title"));
            prop.setProperty("Hallways_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Hallways_Title2",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[1].title"));
            prop.setProperty("Hallways_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Hallways_Title3",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[2].title"));
            prop.setProperty("Hallways_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Hallways_Title4",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[3].title"));
            prop.setProperty("Hallways_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Hallways_Title5",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[4].title"));
            prop.setProperty("Hallways_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Hallways_Title6",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[5].title"));
            prop.setProperty("Hallways_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Hallways_Title7",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[6].title"));
            prop.setProperty("Hallways_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Hallways_Title8",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[7].title"));
            prop.setProperty("Hallways_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Hallways_Title9",response.jsonPath().<String>getJsonObject("data.list[5].checklists[0].sub_fields[8].title"));

            prop.setProperty("Hallways_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[0]._id"));
            prop.setProperty("Hallways_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[0].title"));
            prop.setProperty("Hallways_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[1]._id"));
            prop.setProperty("Hallways_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[1].title"));
            prop.setProperty("Hallways_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[2]._id"));
            prop.setProperty("Hallways_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[2].title"));
            prop.setProperty("Hallways_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[3]._id"));
            prop.setProperty("Hallways_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[3].title"));
            prop.setProperty("Hallways_addons_news[5]._id",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[4]._id"));
            prop.setProperty("Hallways_addons_news[5].title",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[4].title"));
            prop.setProperty("Hallways_addons_news[6]._id",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[5]._id"));
            prop.setProperty("Hallways_addons_news[6].title",response.jsonPath().<String>getJsonObject("data.list[5].addons_new[5].title"));

            prop.setProperty("Office rooms_id",response.jsonPath().<String>getJsonObject("data.list[6]._id"));
            prop.setProperty("Office rooms_room_type_name",response.jsonPath().<String>getJsonObject("data.list[6].room_type_name"));
            prop.setProperty("Office rooms_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Office rooms_Title1",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[0].title"));
            prop.setProperty("Office rooms_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Office rooms_Title2",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[1].title"));
            prop.setProperty("Office rooms_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Office rooms_Title3",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[2].title"));
            prop.setProperty("Office rooms_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Office rooms_Title4",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[3].title"));
            prop.setProperty("Office rooms_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Office rooms_Title5",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[4].title"));
            prop.setProperty("Office rooms_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Office rooms_Title6",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[5].title"));
            prop.setProperty("Office rooms_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Office rooms_Title7",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[6].title"));
            prop.setProperty("Office rooms_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Office rooms_Title8",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[7].title"));
            prop.setProperty("Office rooms_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Office rooms_Title9",response.jsonPath().<String>getJsonObject("data.list[6].checklists[0].sub_fields[8].title"));

            prop.setProperty("Office rooms_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[0]._id"));
            prop.setProperty("Office rooms_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[0].title"));
            prop.setProperty("Office rooms_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[1]._id"));
            prop.setProperty("Office rooms_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[1].title"));
            prop.setProperty("Office rooms_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[2]._id"));
            prop.setProperty("Office rooms_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[2].title"));
            prop.setProperty("Office rooms_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[3]._id"));
            prop.setProperty("Office rooms_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[6].addons_new[3].title"));

            prop.setProperty("Utility room_id",response.jsonPath().<String>getJsonObject("data.list[7]._id"));
            prop.setProperty("Utility room_room_type_name",response.jsonPath().<String>getJsonObject("data.list[7].room_type_name"));
            prop.setProperty("Utility room_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Utility room_Title1",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[0].title"));
            prop.setProperty("Utility room_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Utility room_Title2",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[1].title"));
            prop.setProperty("Utility room_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Utility room_Title3",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[2].title"));
            prop.setProperty("Utility room_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Utility room_Title4",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[3].title"));
            prop.setProperty("Utility room_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Utility room_Title5",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[4].title"));
            prop.setProperty("Utility room_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Utility room_Title6",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[5].title"));
            prop.setProperty("Utility room_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Utility room_Title7",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[6].title"));
            prop.setProperty("Utility room_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Utility room_Title8",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[7].title"));
            prop.setProperty("Utility room_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Utility room_Title9",response.jsonPath().<String>getJsonObject("data.list[7].checklists[0].sub_fields[8].title"));

            prop.setProperty("Utility room_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[0]._id"));
            prop.setProperty("Utility room_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[0].title"));
            prop.setProperty("Utility room_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[1]._id"));
            prop.setProperty("Utility room_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[1].title"));
            prop.setProperty("Utility room_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[2]._id"));
            prop.setProperty("Utility room_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[2].title"));
            prop.setProperty("Utility room_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[3]._id"));
            prop.setProperty("Utility room_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[3].title"));
            prop.setProperty("Utility room_addons_news[5]._id",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[4]._id"));
            prop.setProperty("Utility room_addons_news[5].title",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[4].title"));
            prop.setProperty("Utility room_addons_news[6]._id",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[5]._id"));
            prop.setProperty("Utility room_addons_news[6].title",response.jsonPath().<String>getJsonObject("data.list[7].addons_new[5].title"));

            prop.setProperty("Kitchen Kitchen-Dining area_id",response.jsonPath().<String>getJsonObject("data.list[8]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_room_type_name",response.jsonPath().<String>getJsonObject("data.list[8].room_type_name"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title1",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[0].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title2",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[1].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title3",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[2].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title4",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[3].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title5",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[4].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title6",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[5].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title7",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[6].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title8",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[7].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title9",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[8].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_Checklist_id10",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[9].checklist_id"));
            prop.setProperty("Kitchen Kitchen-Dining area_Title10",response.jsonPath().<String>getJsonObject("data.list[8].checklists[0].sub_fields[9].title"));

            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[0]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[0].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[1]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[1].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[2]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[2].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[3]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[3].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[5]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[4]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[5].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[4].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[6]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[5]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[6].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[5].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[7]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[6]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[7].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[6].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[8]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[7]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[8].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[7].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[9]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[8]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[9].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[8].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[10]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[9]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[10].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[9].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[11]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[10]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[11].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[10].title"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[12]._id",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[11]._id"));
            prop.setProperty("Kitchen Kitchen-Dining area_addons_news[12].title",response.jsonPath().<String>getJsonObject("data.list[8].addons_new[11].title"));

            prop.setProperty("Dining Room_id",response.jsonPath().<String>getJsonObject("data.list[9]._id"));
            prop.setProperty("Dining Room_room_type_name",response.jsonPath().<String>getJsonObject("data.list[9].room_type_name"));
            prop.setProperty("Dining Room_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Dining Room_Title1",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[0].title"));
            prop.setProperty("Dining Room_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Dining Room_Title2",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[1].title"));
            prop.setProperty("Dining Room_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Dining Room_Title3",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[2].title"));
            prop.setProperty("Dining Room_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Dining Room_Title4",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[3].title"));
            prop.setProperty("Dining Room_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Dining Room_Title5",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[4].title"));
            prop.setProperty("Dining Room_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Dining Room_Title6",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[5].title"));
            prop.setProperty("Dining Room_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Dining Room_Title7",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[6].title"));
            prop.setProperty("Dining Room_Checklist_id8",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[7].checklist_id"));
            prop.setProperty("Dining Room_Title8",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[7].title"));
            prop.setProperty("Dining Room_Checklist_id9",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[8].checklist_id"));
            prop.setProperty("Dining Room_Title9",response.jsonPath().<String>getJsonObject("data.list[9].checklists[0].sub_fields[8].title"));

            prop.setProperty("Dining Room_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[0]._id"));
            prop.setProperty("Dining Room_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[0].title"));
            prop.setProperty("Dining Room_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[1]._id"));
            prop.setProperty("Dining Room_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[1].title"));
            prop.setProperty("Dining Room_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[2]._id"));
            prop.setProperty("Dining Room_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[2].title"));
            prop.setProperty("Dining Room_addons_news[4]._id",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[3]._id"));
            prop.setProperty("Dining Room_addons_news[4].title",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[3].title"));
            prop.setProperty("Dining Room_addons_news[5]._id",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[4]._id"));
            prop.setProperty("Dining Room_addons_news[5].title",response.jsonPath().<String>getJsonObject("data.list[9].addons_new[4].title"));

            prop.setProperty("Stairs_id",response.jsonPath().<String>getJsonObject("data.list[10]._id"));
            prop.setProperty("Stairs_room_type_name",response.jsonPath().<String>getJsonObject("data.list[10].room_type_name"));
            prop.setProperty("Stairs_Checklist_id1",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[0].checklist_id"));
            prop.setProperty("Stairs_Title1",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[0].title"));
            prop.setProperty("Stairs_Checklist_id2",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[1].checklist_id"));
            prop.setProperty("Stairs_Title2",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[1].title"));
            prop.setProperty("Stairs_Checklist_id3",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[2].checklist_id"));
            prop.setProperty("Stairs_Title3",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[2].title"));
            prop.setProperty("Stairs_Checklist_id4",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[3].checklist_id"));
            prop.setProperty("Stairs_Title4",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[3].title"));
            prop.setProperty("Stairs_Checklist_id5",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[4].checklist_id"));
            prop.setProperty("Stairs_Title5",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[4].title"));
            prop.setProperty("Stairs_Checklist_id6",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[5].checklist_id"));
            prop.setProperty("Stairs_Title6",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[5].title"));
            prop.setProperty("Stairs_Checklist_id7",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[6].checklist_id"));
            prop.setProperty("Stairs_Title7",response.jsonPath().<String>getJsonObject("data.list[10].checklists[0].sub_fields[6].title"));

            prop.setProperty("Stairs_addons_news[1]._id",response.jsonPath().<String>getJsonObject("data.list[10].addons_new[0]._id"));
            prop.setProperty("Stairs_addons_news[1].title",response.jsonPath().<String>getJsonObject("data.list[10].addons_new[0].title"));
            prop.setProperty("Stairs_addons_news[2]._id",response.jsonPath().<String>getJsonObject("data.list[10].addons_new[1]._id"));
            prop.setProperty("Stairs_addons_news[2].title",response.jsonPath().<String>getJsonObject("data.list[10].addons_new[1].title"));
            prop.setProperty("Stairs_addons_news[3]._id",response.jsonPath().<String>getJsonObject("data.list[10].addons_new[2]._id"));
            prop.setProperty("Stairs_addons_news[3].title",response.jsonPath().<String>getJsonObject("data.list[10].addons_new[2].title"));


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
