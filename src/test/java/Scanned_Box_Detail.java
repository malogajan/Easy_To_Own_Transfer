import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scanned_Box_Detail {
    @Test(priority = 0)
        //Run|Debug
    void GetScannedBoxDetail () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"526548453658\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                body(requestBody).
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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

            Assert.assertTrue(responseBody.contains("itemCode"));
            System.out.println("itemCode:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 1)
        //Run|Debug
    void GetScannedBoxDetail_with_Invalid_Serial_Number () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"526548FFW453658\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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
    void GetScannedBoxDetail_with_Blank_Serial_Number () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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
    void GetScannedBoxDetail_with_Serial_Number_More_than_10_Digits () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"52654845365812345678909887766544\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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

            Assert.assertTrue(responseBody.contains("itemCode"));
            System.out.println("itemCode:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 4)
        //Run|Debug
    void GetScannedBoxDetail_with_Serial_Number_Less_than_10_Digits () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"526548\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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

            Assert.assertTrue(responseBody.contains("itemCode"));
            System.out.println("itemCode:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 5)
        //Run|Debug
    void GetScannedBoxDetail_with_Blank_WHS_Code_From () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"526548453658\",\n" +
                "  \"whsCodeFrom\": \"\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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
    @Test(priority = 6)
        //Run|Debug
    void GetScannedBoxDetail_with_Blank_User_ID () {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"526548453658\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": ,\n" +
                "  \"boxType\": \"serial\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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
    @Test(priority = 7)
        //Run|Debug
    void GetScannedBoxDetail_with_Blank_Box_Type() {

        String requestBody = "{\n" +
                "  \"serialNumber\": \"526548453658\",\n" +
                "  \"whsCodeFrom\": \"04\",\n" +
                "  \"whsCodeTo\": \"Q215756\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"userId\": 49,\n" +
                "  \"boxType\": \"\",\n" +
                "  \"comment\": \"Test\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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
