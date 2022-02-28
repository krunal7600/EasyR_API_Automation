package Custom_Addon;

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

public class TC009_POST_ProvidersListAcceptedOrder extends BaseClass {

    @Test
    public void POSTProvidersListAcceptedOrder()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

//        requestParams.put("order_id","620b39352e53fe7187ac39ef");
        requestParams.put("order_id",prop.getProperty("Service_Request_order_id"));

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));

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

        System.out.println("Provider_Accepted_Custom_Addon_Order_Id"+ response.jsonPath().getJsonObject("data.list[0]._id"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_Full_Name"+ response.jsonPath().getJsonObject("data.list[0].full_name"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_Email"+ response.jsonPath().getJsonObject("data.list[0].email"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_User_Type"+ response.jsonPath().getJsonObject("data.list[0].user_type"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_Employee_Count"+ response.jsonPath().getJsonObject("data.list[0].employee_count"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_Provided_Services"+ response.jsonPath().getJsonObject("data.list[0].provided_services"));
        System.out.println("Custom_Addon_CVR_Number"+ response.jsonPath().getJsonObject("data.list[0].cvr_number"));
        System.out.println("Custom_Addon_Service_Rate"+ response.jsonPath().getJsonObject("data.list[0].service_rate"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_Company_Id"+ response.jsonPath().getJsonObject("data.list[0].company_id"));

        System.out.println("custom_addon_manager_request_data_id"+ response.jsonPath().getJsonObject("data.list[0].custom_addon_manager_request_data[0]._id"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_addon_id"+ response.jsonPath().getJsonObject("data.list[0].custom_addon_manager_request_data[0].addon_id"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_manager_id"+ response.jsonPath().getJsonObject("data.list[0].custom_addon_manager_request_data[0].manager_id"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_price"+ response.jsonPath().getJsonObject("data.list[0].custom_addon_manager_request_data[0].price"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_count"+ response.jsonPath().getJsonObject("data.list[0].custom_addon_manager_request_data[0].count"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_addon_title"+ response.jsonPath().getJsonObject("data.list[0].custom_addon_manager_request_data[0].addon_title"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_total_custom_addon_amount"+ response.jsonPath().getJsonObject("data.list[0].total_custom_addon_amount"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_dayOfWeek"+ response.jsonPath().getJsonObject("data.list[0].dayOfWeek"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_saturday_weekend_charges"+ response.jsonPath().getJsonObject("data.list[0].saturday_weekend_charges"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_sunday_weekend_charges"+ response.jsonPath().getJsonObject("data.list[0].sunday_weekend_charges"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_total_custom_addon_admin_commission"+ response.jsonPath().getJsonObject("data.list[0].total_custom_addon_admin_commission"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_total_custom_addon_vat"+ response.jsonPath().getJsonObject("data.list[0].total_custom_addon_vat"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_total_order_amount"+ response.jsonPath().getJsonObject("data.list[0].total_order_amount"));
        System.out.println("Provider_Accepted_Custom_Addon_Order_total_records"+ response.jsonPath().getJsonObject("data.total_records"));


//        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
//        {
//            Properties prop = new Properties();
//            prop.load(ip);
//
//            //Set The Properties Value In personal.Properties File
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_Id", response.jsonPath().<String>getJsonObject("data.list[0]._id"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_Full_Name", response.jsonPath().<String>getJsonObject("data.list[0].full_name"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_Email", response.jsonPath().<String>getJsonObject("data.list.email"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_User_Type", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list.user_type")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_Employee_Count", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list.employee_count")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_Provided_Services", String.valueOf(response.jsonPath().<StringArray>getJsonObject("data.list.provided_services")));
//            prop.setProperty("Custom_Addon_CVR_Number", response.jsonPath().<String>getJsonObject("data.list.cvr_number"));
//            prop.setProperty("Custom_Addon_Service_Rate", String.valueOf(response.jsonPath().<Float>getJsonObject("data.list.service_rate")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_Company_Id", response.jsonPath().<String>getJsonObject("data.list.company_id"));
//
//            prop.setProperty("custom_addon_manager_request_data_id", response.jsonPath().<String>getJsonObject("data.list[0].custom_addon_manager_request_data[0]._id"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_addon_id", response.jsonPath().<String>getJsonObject("data.list[0].custom_addon_manager_request_data[0].addon_id"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_manager_id", response.jsonPath().<String>getJsonObject("data.list[0].custom_addon_manager_request_data[0].manager_id"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_price", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].custom_addon_manager_request_data[0].price")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_count", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].custom_addon_manager_request_data[0].count")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_addon_title", response.jsonPath().<String>getJsonObject("data.list[0].custom_addon_manager_request_data[0].addon_title"));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_amount", String.valueOf(response.jsonPath().<Float>getJsonObject("data.list[0].total_custom_addon_amount")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_dayOfWeek", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].dayOfWeek")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_saturday_weekend_charges", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].saturday_weekend_charges")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_sunday_weekend_charges", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].sunday_weekend_charges")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_admin_commission", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.list[0].total_custom_addon_admin_commission")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_vat", String.valueOf(response.jsonPath().<Float>getJsonObject("data.list[0].total_custom_addon_vat")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_total_order_amount", String.valueOf(response.jsonPath().<Float>getJsonObject("data.list[0].total_order_amount")));
//            prop.setProperty("Provider_Accepted_Custom_Addon_Order_total_records", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.total_records")));
//
//
//            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./personal.properties");
//
//            //Save properties to project root folder
//            prop.store(output,"save");
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
