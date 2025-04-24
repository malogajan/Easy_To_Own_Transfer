import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateEasy_To_Own_Way_BillNumber {
    @Test(priority = 0)
        //Run|Debug
    void UpdateEasyToOwnWayBillNumber () {

        String requestBody = "{\n" +
                "  \"dispatchId\": 14,\n" +
                "  \"docNo\": 7,\n" +
                "  \"transferType\": \"E2O Transfer\",\n" +
                "  \"wayBillNumber\": \"13546\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnDispatch/UpdateEasyToOwnWayBillNumber");

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

            Assert.assertTrue(responseBody.contains("success"));
            System.out.println("success:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 1)
        //Run|Debug
    void UpdateEasyToOwnWayBillNumber_with_Invalid_Dispatch_Id () {

        String requestBody = "{\n" +
                "  \"dispatchId\": 1,\n" +
                "  \"docNo\": 7,\n" +
                "  \"transferType\": \"E2O Transfer\",\n" +
                "  \"wayBillNumber\": \"13546\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnDispatch/UpdateEasyToOwnWayBillNumber");

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
    void UpdateEasyToOwnWayBillNumber_with_Empty_Dispatch_Id () {

        String requestBody = "{\n" +
                "  \"dispatchId\": ,\n" +
                "  \"docNo\": 7,\n" +
                "  \"transferType\": \"E2O Transfer\",\n" +
                "  \"wayBillNumber\": \"13546\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnDispatch/UpdateEasyToOwnWayBillNumber");

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
    void UpdateEasyToOwnWayBillNumber_with_Empty_DocNo () {

        String requestBody = "{\n" +
                "  \"dispatchId\": 1,\n" +
                "  \"docNo\": ,\n" +
                "  \"transferType\": \"E2O Transfer\",\n" +
                "  \"wayBillNumber\": \"13546\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnDispatch/UpdateEasyToOwnWayBillNumber");

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
    @Test(priority = 4)
        //Run|Debug
    void UpdateEasyToOwnWayBillNumber_with_Invalid_transferType () {

        String requestBody = "{\n" +
                "  \"dispatchId\": 1,\n" +
                "  \"docNo\": 7,\n" +
                "  \"transferType\": \"E2O\",\n" +
                "  \"wayBillNumber\": \"13546\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnDispatch/UpdateEasyToOwnWayBillNumber");

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
    @Test(priority = 5)
        //Run|Debug
    void UpdateEasyToOwnWayBillNumber_with_Empty_waybill_number () {

        String requestBody = "{\n" +
                "  \"dispatchId\": 14,\n" +
                "  \"docNo\": 7,\n" +
                "  \"transferType\": \"E2O Transfer\",\n" +
                "  \"wayBillNumber\": \"13546F//////\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnDispatch/UpdateEasyToOwnWayBillNumber");

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
