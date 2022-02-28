package Custom_Room;

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

public class TC005_POST_StandardAddonList extends BaseClass {

    @Test
    public void POSTStandardAddonList()
    {
        //Specify base URI
        RestAssured.baseURI = prop.getProperty("URL") + prop.getProperty("Version");

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request and sending a parameters for POST Request
        JSONObject requestParams = new JSONObject();

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("language_code","en");
        httpRequest.header("Authorization",prop.getProperty("Login_Customer_Access_Token"));

        httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.GET,"/api/custom_room/get_standard_addon");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        System.out.println("Success Message : " + response.jsonPath().getJsonObject("message"));

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./personal.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set The Properties Value In personal.Properties File
            prop.setProperty("Custom_Room_Standard_Addon_1_Id",response.jsonPath().<String>getJsonObject("data[0]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_2_Id",response.jsonPath().<String>getJsonObject("data[1]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_3_Id",response.jsonPath().<String>getJsonObject("data[2]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_4_Id",response.jsonPath().<String>getJsonObject("data[3]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_5_Id",response.jsonPath().<String>getJsonObject("data[4]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_6_Id",response.jsonPath().<String>getJsonObject("data[5]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_7_Id",response.jsonPath().<String>getJsonObject("data[6]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_8_Id",response.jsonPath().<String>getJsonObject("data[7]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_9_Id",response.jsonPath().<String>getJsonObject("data[8]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_10_Id",response.jsonPath().<String>getJsonObject("data[9]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_11_Id",response.jsonPath().<String>getJsonObject("data[10]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_12_Id",response.jsonPath().<String>getJsonObject("data[11]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_13_Id",response.jsonPath().<String>getJsonObject("data[12]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_14_Id",response.jsonPath().<String>getJsonObject("data[13]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_15_Id",response.jsonPath().<String>getJsonObject("data[14]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_16_Id",response.jsonPath().<String>getJsonObject("data[15]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_17_Id",response.jsonPath().<String>getJsonObject("data[16]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_18_Id",response.jsonPath().<String>getJsonObject("data[17]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_19_Id",response.jsonPath().<String>getJsonObject("data[18]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_20_Id",response.jsonPath().<String>getJsonObject("data[19]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_21_Id",response.jsonPath().<String>getJsonObject("data[20]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_22_Id",response.jsonPath().<String>getJsonObject("data[21]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_23_Id",response.jsonPath().<String>getJsonObject("data[22]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_24_Id",response.jsonPath().<String>getJsonObject("data[23]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_25_Id",response.jsonPath().<String>getJsonObject("data[24]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_26_Id",response.jsonPath().<String>getJsonObject("data[25]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_27_Id",response.jsonPath().<String>getJsonObject("data[26]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_28_Id",response.jsonPath().<String>getJsonObject("data[27]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_29_Id",response.jsonPath().<String>getJsonObject("data[28]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_30_Id",response.jsonPath().<String>getJsonObject("data[29]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_31_Id",response.jsonPath().<String>getJsonObject("data[30]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_32_Id",response.jsonPath().<String>getJsonObject("data[31]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_33_Id",response.jsonPath().<String>getJsonObject("data[32]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_34_Id",response.jsonPath().<String>getJsonObject("data[33]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_35_Id",response.jsonPath().<String>getJsonObject("data[34]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_36_Id",response.jsonPath().<String>getJsonObject("data[35]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_37_Id",response.jsonPath().<String>getJsonObject("data[36]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_38_Id",response.jsonPath().<String>getJsonObject("data[37]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_39_Id",response.jsonPath().<String>getJsonObject("data[38]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_40_Id",response.jsonPath().<String>getJsonObject("data[39]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_41_Id",response.jsonPath().<String>getJsonObject("data[40]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_42_Id",response.jsonPath().<String>getJsonObject("data[41]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_43_Id",response.jsonPath().<String>getJsonObject("data[42]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_44_Id",response.jsonPath().<String>getJsonObject("data[43]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_45_Id",response.jsonPath().<String>getJsonObject("data[44]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_46_Id",response.jsonPath().<String>getJsonObject("data[45]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_47_Id",response.jsonPath().<String>getJsonObject("data[46]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_48_Id",response.jsonPath().<String>getJsonObject("data[47]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_49_Id",response.jsonPath().<String>getJsonObject("data[48]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_50_Id",response.jsonPath().<String>getJsonObject("data[49]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_51_Id",response.jsonPath().<String>getJsonObject("data[50]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_52_Id",response.jsonPath().<String>getJsonObject("data[51]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_53_Id",response.jsonPath().<String>getJsonObject("data[52]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_54_Id",response.jsonPath().<String>getJsonObject("data[53]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_55_Id",response.jsonPath().<String>getJsonObject("data[54]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_56_Id",response.jsonPath().<String>getJsonObject("data[55]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_57_Id",response.jsonPath().<String>getJsonObject("data[56]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_58_Id",response.jsonPath().<String>getJsonObject("data[57]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_59_Id",response.jsonPath().<String>getJsonObject("data[58]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_60_Id",response.jsonPath().<String>getJsonObject("data[59]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_61_Id",response.jsonPath().<String>getJsonObject("data[60]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_62_Id",response.jsonPath().<String>getJsonObject("data[61]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_63_Id",response.jsonPath().<String>getJsonObject("data[62]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_64_Id",response.jsonPath().<String>getJsonObject("data[63]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_65_Id",response.jsonPath().<String>getJsonObject("data[64]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_66_Id",response.jsonPath().<String>getJsonObject("data[65]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_67_Id",response.jsonPath().<String>getJsonObject("data[66]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_68_Id",response.jsonPath().<String>getJsonObject("data[67]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_69_Id",response.jsonPath().<String>getJsonObject("data[68]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_70_Id",response.jsonPath().<String>getJsonObject("data[69]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_71_Id",response.jsonPath().<String>getJsonObject("data[70]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_72_Id",response.jsonPath().<String>getJsonObject("data[71]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_73_Id",response.jsonPath().<String>getJsonObject("data[72]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_74_Id",response.jsonPath().<String>getJsonObject("data[73]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_75_Id",response.jsonPath().<String>getJsonObject("data[74]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_76_Id",response.jsonPath().<String>getJsonObject("data[75]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_77_Id",response.jsonPath().<String>getJsonObject("data[76]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_78_Id",response.jsonPath().<String>getJsonObject("data[77]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_79_Id",response.jsonPath().<String>getJsonObject("data[78]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_80_Id",response.jsonPath().<String>getJsonObject("data[79]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_81_Id",response.jsonPath().<String>getJsonObject("data[80]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_82_Id",response.jsonPath().<String>getJsonObject("data[81]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_83_Id",response.jsonPath().<String>getJsonObject("data[82]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_84_Id",response.jsonPath().<String>getJsonObject("data[83]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_85_Id",response.jsonPath().<String>getJsonObject("data[84]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_86_Id",response.jsonPath().<String>getJsonObject("data[85]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_87_Id",response.jsonPath().<String>getJsonObject("data[86]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_88_Id",response.jsonPath().<String>getJsonObject("data[87]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_89_Id",response.jsonPath().<String>getJsonObject("data[88]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_90_Id",response.jsonPath().<String>getJsonObject("data[89]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_91_Id",response.jsonPath().<String>getJsonObject("data[90]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_92_Id",response.jsonPath().<String>getJsonObject("data[91]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_93_Id",response.jsonPath().<String>getJsonObject("data[92]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_94_Id",response.jsonPath().<String>getJsonObject("data[93]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_95_Id",response.jsonPath().<String>getJsonObject("data[94]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_96_Id",response.jsonPath().<String>getJsonObject("data[95]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_97_Id",response.jsonPath().<String>getJsonObject("data[96]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_98_Id",response.jsonPath().<String>getJsonObject("data[97]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_99_Id",response.jsonPath().<String>getJsonObject("data[98]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_100_Id",response.jsonPath().<String>getJsonObject("data[99]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_101_Id",response.jsonPath().<String>getJsonObject("data[100]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_102_Id",response.jsonPath().<String>getJsonObject("data[101]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_103_Id",response.jsonPath().<String>getJsonObject("data[102]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_104_Id",response.jsonPath().<String>getJsonObject("data[103]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_105_Id",response.jsonPath().<String>getJsonObject("data[104]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_106_Id",response.jsonPath().<String>getJsonObject("data[105]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_107_Id",response.jsonPath().<String>getJsonObject("data[106]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_108_Id",response.jsonPath().<String>getJsonObject("data[107]._id"));
            prop.setProperty("Custom_Room_Standard_Addon_109_Id",response.jsonPath().<String>getJsonObject("data[108]._id"));

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
