package BaseClass;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass{

    BaseClass baseClass ;
    String URL;
    String versionURL;
    String loginCustomerAccessToken;
    String loginPartnerAccessToken;
    String loginEmployeeAccessToken;
    String url;

    public Properties prop;

    @BeforeClass
    public void setup()
    {
        try
        {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"./config.properties");
            FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir")+"./personal.properties");
            prop.load(ip);
            prop.load(ip1);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        baseClass = new BaseClass();
        URL = prop.getProperty("URL");
        versionURL = prop.getProperty("Version");
        loginCustomerAccessToken = prop.getProperty("Login_Customer_Access_Token");
        loginPartnerAccessToken = prop.getProperty("Login_Partner_Access_Token");
        loginEmployeeAccessToken = prop.getProperty("Login_Employee_Access_Token");

        //http://202.131.117.92:7065/v7

        url = URL + versionURL;


    }

}
