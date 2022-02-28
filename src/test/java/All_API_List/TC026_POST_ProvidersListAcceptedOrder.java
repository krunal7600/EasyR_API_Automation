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

public class TC026_POST_ProvidersListAcceptedOrder extends BaseClass {

    @Test
    public void POSTProvidersListAcceptedOrder()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("order_id",prop.getProperty("Service_Request_order_id"));

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpRequest.header("login_as_provider","false");

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/api/service/providers_list_accepted_order");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : "+response.jsonPath().getJsonObject("message"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set The Properties Value In personal.Properties File
            prop.setProperty("Provider_Accepted_Order_Id", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list[0]._id")));
            prop.setProperty("Provider_Accepted_Order_Full_Name", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.full_name")));
            prop.setProperty("Provider_Accepted_Order_Email", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.email")));
            prop.setProperty("Provider_Accepted_Order_User_Type", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list.user_type")));
            prop.setProperty("Provider_Accepted_Order_Employee_Count", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list.employee_count")));
            prop.setProperty("Provider_Accepted_Order_Provided_Services", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.provided_services")));
            prop.setProperty("Provider_Accepted_Order_Company_Id", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.company_id")));
            prop.setProperty("Provider_Accepted_Order_Total_Records", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.total_records")));
            prop.setProperty("cvr_number", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.cvr_number")));
            prop.setProperty("service_rate", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.service_rate")));
            prop.setProperty("total_custom_addon_amount", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].total_custom_addon_amount")));
            prop.setProperty("total_order_amount", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].total_order_amount")));


            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");

            //Save properties to project root folder
            prop.store(output,"save");
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
