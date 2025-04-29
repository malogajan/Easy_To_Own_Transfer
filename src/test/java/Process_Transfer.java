import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Process_Transfer {
    @Test(priority = 0)
        //Run|Debug
    void RemoveScannedBoxDetail () {

        String requestBody = "{\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"takeOn\": 0,\n" +
                "  \"userId\": 49,\n" +
                "  \"comment\": \"string\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/ProcessTransfer");

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

            Assert.assertTrue(responseBody.contains("whsCodeFrom"));
            System.out.println("whsCodeFrom:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 1)
        //Run|Debug
    void ProcessTransfer_with_Empty_whsCodeFrom () {

        String requestBody = "{\n" +
                "  \"whsCodeFrom\": \"\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"takeOn\": 0,\n" +
                "  \"userId\": 49,\n" +
                "  \"comment\": \"string\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/ProcessTransfer");

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

            Assert.assertTrue(responseBody.contains("errorMessages"));
            System.out.println("errorMessages:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 2)
        //Run|Debug
    void ProcessTransfer_with_Empty_whsCodeTo () {

        String requestBody = "{\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"\",\n" +
                "  \"takeOn\": 0,\n" +
                "  \"userId\": 49,\n" +
                "  \"comment\": \"string\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/ProcessTransfer");

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

            Assert.assertTrue(responseBody.contains("errorMessages"));
            System.out.println("errorMessages:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 3)
        //Run|Debug
    void ProcessTransfer_with_Empty_UserId () {

        String requestBody = "{\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"takeOn\": 0,\n" +
                "  \"userId\": ,\n" +
                "  \"comment\": \"string\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/ProcessTransfer");

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

            Assert.assertTrue(responseBody.contains("errors"));
            System.out.println("errors:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
}
