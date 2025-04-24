import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Device_Makes {
        @Test(priority = 1)
        //Run|Debug
        void GetDeviceMakes () {

            //String requestBody = "";
            Response response = given().
                    header("Content-Type", "application/json").
                    //header("Authorization", "Bearer " + token).
                    //body(requestBody).
                            when().
                    get("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetDeviceMakes");

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
    }