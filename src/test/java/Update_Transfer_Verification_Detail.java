import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Update_Transfer_Verification_Detail {
    @Test(priority = 0)
        //Run|Debug
    void UpdateTransferVerificationDetail () {

        String requestBody = "{\n" +
                "  \"receiptId\": 7,\n" +
                "  \"serialNo\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateTransferVerificationDetail");

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
    void UpdateTransferVerificationDetail_with_Invalid_ReceiptId () {

        String requestBody = "{\n" +
                "  \"receiptId\": 788,\n" +
                "  \"serialNo\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateTransferVerificationDetail");

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

            Assert.assertTrue(responseBody.contains("null"));
            System.out.println("null:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 2)
        //Run|Debug
    void UpdateTransferVerificationDetail_with_Blank_ReceiptId () {

        String requestBody = "{\n" +
                "  \"receiptId\": ,\n" +
                "  \"serialNo\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateTransferVerificationDetail");

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
    @Test(priority = 3)
        //Run|Debug
    void UpdateTransferVerificationDetail_with_Blank_SerialNo () {

        String requestBody = "{\n" +
                "  \"receiptId\": 7,\n" +
                "  \"serialNo\": \"\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateTransferVerificationDetail");

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
}
