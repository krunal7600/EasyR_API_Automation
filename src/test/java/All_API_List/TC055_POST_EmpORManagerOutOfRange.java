package All_API_List;

import BaseClass.BaseClass;
import org.testng.annotations.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TC055_POST_EmpORManagerOutOfRange extends BaseClass {

    @Test
    public void POSTEmpORManagerOutOfRanges() throws IOException {
        //Specify base URI
//        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
//        RequestSpecification httpRequest = RestAssured.given();

        String urlParameters  = "order_id=61c2e954e6709221a3fcd9c8 & out_of_range_user_id=615d3084e186405758464934";
        byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int postDataLength = postData.length;
        String request = "http://202.131.117.92:7065/v7/api/order/emp_or_manager_out_of_range";
        URL url = new URL( request );
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
        httpURLConnection.setRequestProperty("charset", "utf-8");
        httpURLConnection.setRequestProperty("Authorization",prop.getProperty("Login_Customer_Access_Token"));
        httpURLConnection.setUseCaches(false);
        try(DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream())) {
            wr.write( postData );
        }



        //Request and sending a parameters for POST Request
//        JSONObject requestParams = new JSONObject();
//
//        requestParams.put("order_id","61c2e954e6709221a3fcd9c8");
//        requestParams.put("out_of_range_user_id","615d3084e186405758464934");
//
//        httpRequest.urlEncodingEnabled(true);
//        httpRequest.header("charset","utf-8");
//        httpRequest.header("Content-Type","application/x-www-form-urlencoded");
//        httpRequest.header("Accept-Encoding","gzip, deflate, br");
//        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));
//        httpRequest.accept("*/*");
//
//        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request
//
//        //Response object
//        Response response = httpRequest.request(Method.POST,"/api/order/emp_or_manager_out_of_range");
//
//        //Print Response in Console Window
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body is:" +responseBody);
//
//        //Status Code Verification
//        int statusCode = response.getStatusCode();
//        System.out.println("Status Code is:" + statusCode);
//        Assert.assertEquals(statusCode,200);
    }
}
