package Custom_Addon;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC011_POST_AcceptCustomAddon_ByUser extends BaseClass {

    @Test
    public void POSTAcceptCustomAddon_ByUser()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        String price = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_price"));
        String total_custom_addon_admin_commission = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_admin_commission"));
        String total_custom_addon_amount = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_amount"));
        String saturday_weekend_charges = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_saturday_weekend_charges"));
        String sunday_weekend_charges = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_sunday_weekend_charges"));
        String total_custom_addon_vat = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_vat"));
        String total_order_amount = new String(prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_order_amount"));

        Integer Price = new Integer(price);
        Integer Total_Custom_Addon_Admin_Commission = new Integer(total_custom_addon_admin_commission);
        Float Total_Custom_Addon_Amount = new Float(total_custom_addon_amount);
        Integer Saturday_Weekend_Charges = new Integer(saturday_weekend_charges);
        Integer Sunday_Weekend_Charges = new Integer(sunday_weekend_charges);
        Float Total_Custom_Addon_Vat = new Float(total_custom_addon_vat);
        Float Total_Order_Amount = new Float(total_order_amount);

        System.out.println(Price);
        System.out.println(Total_Custom_Addon_Admin_Commission);
        System.out.println(Total_Custom_Addon_Amount);
        System.out.println(Saturday_Weekend_Charges);
        System.out.println(Sunday_Weekend_Charges);
        System.out.println(Total_Custom_Addon_Vat);
        System.out.println(Total_Order_Amount);

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        Response response = httpRequest.given().header("Content-Type","application/json").header("Authorization",prop.getProperty("Login_Customer_Access_Token")).body("{\"accepted_custom_addon_details\":[{\"custom_addon_manager_request_id\":\""+prop.getProperty("custom_addon_manager_request_data_id")+"\",\"price\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_price")+"}],\"company_id\":\""+prop.getProperty("login_customer_favourite_providers2")+"\",\"manager_id\":\""+prop.getProperty("Provider_Accepted_Custom_Addon_Order_manager_id")+"\",\"order_id\":\""+prop.getProperty("Service_Request_order_id")+"\",\"total_custom_addon_admin_commission\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_admin_commission")+",\"total_custom_addon_amount\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_amount")+",\"total_custom_addon_saturday_charges\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_saturday_weekend_charges")+",\"total_custom_addon_sunday_charges\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_sunday_weekend_charges")+",\"total_custom_addon_vat\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_custom_addon_vat")+",\"total_order_amount\":"+prop.getProperty("Provider_Accepted_Custom_Addon_Order_total_order_amount")+"}").post("/api/custom_addon/accept_custom_addon_by_user");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
    }
}
