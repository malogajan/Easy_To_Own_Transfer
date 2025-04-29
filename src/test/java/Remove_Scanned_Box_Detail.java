import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Remove_Scanned_Box_Detail {
    @Test(priority = 0)
        //Run|Debug
    void RemoveScannedBoxDetail () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"Q215756\",\n" +
                "  \"serial\": \"526548453658\",\n" +
                "  \"primaryIMEINumber\": \"526548453658\",\n" +
                "  \"secondaryIMEINumber\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/RemoveScannedBoxDetail");

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

            Assert.assertTrue(responseBody.contains("Messages"));
            System.out.println("Messages:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 1)
        //Run|Debug
    void RemoveScannedBoxDetail_with_Invalid_Serial_Number () {

            String requestBody = "{\n" +
                    "  \"whsCode\": \"Q215756\",\n" +
                    "  \"serial\": \"52654845365DDDD8\",\n" +
                    "  \"primaryIMEINumber\": \"526548453658\",\n" +
                    "  \"secondaryIMEINumber\": \"526548453658\"\n" +
                    "}";
            Response response = given().
                    header("Content-Type", "application/json").
                    //header("Authorization", "Bearer " + token).
                            body(requestBody).
                    when().
                    post("http://10.111.111.139:7019/api/EasyToOwnTransfer/RemoveScannedBoxDetail");

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

                Assert.assertTrue(responseBody.contains("errorMessages"));
                System.out.println("errorMessages:" + responseBody);
            } else {
                System.out.println("Unexpected response code : " + response.statusCode());
            }
        }
    @Test(priority = 2)
        //Run|Debug
    void RemoveScannedBoxDetail_with_Blank_Serial_Number () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"Q215756\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"526548453658\",\n" +
                "  \"secondaryIMEINumber\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/RemoveScannedBoxDetail");

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
    void RemoveScannedBoxDetail_with_Blank_WHS_Code () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"\",\n" +
                "  \"serial\": \"526548453658\",\n" +
                "  \"primaryIMEINumber\": \"526548453658\",\n" +
                "  \"secondaryIMEINumber\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/RemoveScannedBoxDetail");

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
    @Test(priority = 4)
        //Run|Debug
    void RemoveScannedBoxDetail_with_Invalid_WHS_Code () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"\",\n" +
                "  \"serial\": \"526548453658\",\n" +
                "  \"primaryIMEINumber\": \"526548453658\",\n" +
                "  \"secondaryIMEINumber\": \"526548453658\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/RemoveScannedBoxDetail");

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
                post("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetScannedBoxDetail");

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
