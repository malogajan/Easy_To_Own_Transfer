import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Device_Model {
    @Test(priority = 0)
        //Run|Debug
    void GetDeviceModel () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetDeviceModel?DeviceMakeId=1");

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response : " + response.getBody().asString());
        System.out.println("Body : " + response.getBody());
        System.out.println("Time taken : " + response.getTime());
        System.out.println("header : " + response.getHeader("content-type"));

        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("content-type");
        if
        (contentType != null && contentType.contains("json")) {
            int statuscode = response.statusCode();
            Assert.assertEquals(statuscode, 200);

            Assert.assertTrue(responseBody.contains("id"));
            System.out.println("id:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
        @Test(priority = 1)
        //Run|Debug
        void GetDeviceModel_with_Invalid_DeviceMakeId () {

            //String requestBody = "";
            Response response = given().
                    header("Content-Type", "application/json").
                    //header("Authorization", "Bearer " + token).
                    //body(requestBody).
                            when().
                    get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetDeviceModel?DeviceMakeId=100");

            System.out.println("Status Code : " + response.getStatusCode());
            System.out.println("Response : " + response.getBody().asString());
            System.out.println("Body : " + response.getBody());
            System.out.println("Time taken : " + response.getTime());
            System.out.println("header : " + response.getHeader("content-type"));

            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("content-type");
            if
            (contentType != null && contentType.contains("json")) {
                int statuscode = response.statusCode();
                Assert.assertEquals(statuscode, 404);

                Assert.assertTrue(responseBody.contains("NOT_FOUND"));
                System.out.println("NOT_FOUND:" + responseBody);
            } else {
                System.out.println("Unexpected response code : " + response.statusCode());

            }
        }
    @Test(priority = 2)
        //Run|Debug
    void GetDeviceModel_with_Blank_DeviceMakeId () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetDeviceModel?DeviceMakeId=");

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response : " + response.getBody().asString());
        System.out.println("Body : " + response.getBody());
        System.out.println("Time taken : " + response.getTime());
        System.out.println("header : " + response.getHeader("content-type"));

        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("content-type");
        if
        (contentType != null && contentType.contains("json")) {
            int statuscode = response.statusCode();
            Assert.assertEquals(statuscode, 400);

            Assert.assertTrue(responseBody.contains("BAD_REQUEST"));
            System.out.println("BAD_REQUEST:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
}
