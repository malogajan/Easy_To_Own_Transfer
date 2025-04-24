import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Dashboard_Summary {
    @Test(priority = 0)
        //Run|Debug
    void GetDashboardSummary () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetDashboardSummary?defaultDate=2025%2F03%2F17");

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

            Assert.assertTrue(responseBody.contains("defaultDate"));
            System.out.println("defaultDate:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 1)
        //Run|Debug
    void GetDashboardSummary_with_Invalid_Date_Format () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetDashboardSummary?defaultDate=20025%2F03%2F17");

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

            Assert.assertTrue(responseBody.contains("defaultDate"));
            System.out.println("defaultDate:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 2)
        //Run|Debug
    void GetDashboardSummary_with_Past_Date_Format () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetDashboardSummary?defaultDate=2000%2F03%2F17");

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

            Assert.assertTrue(responseBody.contains("defaultDate"));
            System.out.println("defaultDate:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 3)
        //Run|Debug
    void GetDashboardSummary_with_Future_Date_Format () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetDashboardSummary?defaultDate=2060%2F03%2F17");

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

            Assert.assertTrue(responseBody.contains("defaultDate"));
            System.out.println("defaultDate:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 4)
        //Run|Debug
    void GetDashboardSummary_with_Blank_Date_Format () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetDashboardSummary");

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

            Assert.assertTrue(responseBody.contains("defaultDate"));
            System.out.println("defaultDate:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
}




