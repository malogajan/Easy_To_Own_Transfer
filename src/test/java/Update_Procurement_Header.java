import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Update_Procurement_Header {
    @Test(priority = 0)
        //Run|Debug
    void Post_Update_Procurement_Header () {

        String requestBody = "{\n" +
                "  \"vendorCode\": \"TMSP\",\n" +
                "  \"productCode\": \"T2322\",\n" +
                "  \"procuredQuantity\": \"11\",\n" +
                "  \"unitPrice\": 250.00,\n" +
                "  \"docNum\": 34,\n" +
                "  \"userId\": \"49\",\n" +
                "  \"stockStageId\": 6,\n" +
                "  \"invoiceNo\": \"Si998\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnProcurement/UpdateProcurementHeader");

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

            Assert.assertTrue(responseBody.contains("Success"));
            System.out.println("Success:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());
        }
    }
    @Test(priority = 1)
        //Run|Debug
    void Update_Procurement_Header_without_InvoiceNo () {

        String requestBody = "{\n" +
                "  \"vendorCode\": \"TMSP\",\n" +
                "  \"productCode\": \"T2322\",\n" +
                "  \"procuredQuantity\": \"11\",\n" +
                "  \"unitPrice\": 250.00,\n" +
                "  \"docNum\": 34,\n" +
                "  \"userId\": \"49\",\n" +
                "  \"stockStageId\": 6,\n" +
                "  \"invoiceNo\": \"\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnProcurement/UpdateProcurementHeader");

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
    void Update_Procurement_Header_without_VendorCode () {

        String requestBody = "{\n" +
                "  \"vendorCode\": \"\",\n" +
                "  \"productCode\": \"T2322\",\n" +
                "  \"procuredQuantity\": \"11\",\n" +
                "  \"unitPrice\": 250.00,\n" +
                "  \"docNum\": 34,\n" +
                "  \"userId\": \"49\",\n" +
                "  \"stockStageId\": 6,\n" +
                "  \"invoiceNo\": \"Si998\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnProcurement/UpdateProcurementHeader");

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
    void Update_Procurement_Header_without_UserId () {

        String requestBody = "{\n" +
                "  \"vendorCode\": \"TMSP\",\n" +
                "  \"productCode\": \"T2322@@#$%^^\",\n" +
                "  \"procuredQuantity\": \"11\",\n" +
                "  \"unitPrice\": 250.00,\n" +
                "  \"docNum\": 34,\n" +
                "  \"userId\": \"\",\n" +
                "  \"stockStageId\": 6,\n" +
                "  \"invoiceNo\": \"Si998\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnProcurement/UpdateProcurementHeader");

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
    void Update_Procurement_Header_without_StockStageId () {

        String requestBody = "{\n" +
                "  \"vendorCode\": \"TMSP\",\n" +
                "  \"productCode\": \"T2322\",\n" +
                "  \"procuredQuantity\": \"11\",\n" +
                "  \"unitPrice\": 250.00,\n" +
                "  \"docNum\": 34,\n" +
                "  \"userId\": \"49\",\n" +
                "  \"stockStageId\": \"\",\n" +
                "  \"invoiceNo\": \"Si998\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnProcurement/UpdateProcurementHeader");

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
    @Test(priority = 5)
        //Run|Debug
    void Update_Procurement_Header_with_Invalid_ProcuredQuantity () {

        String requestBody = "{\n" +
                "  \"vendorCode\": \"TMSP\",\n" +
                "  \"productCode\": \"T2322\",\n" +
                "  \"procuredQuantity\": \"11@FRR\",\n" +
                "  \"unitPrice\": 250.00,\n" +
                "  \"docNum\": 34,\n" +
                "  \"userId\": \"49\",\n" +
                "  \"stockStageId\": 6,\n" +
                "  \"invoiceNo\": \"Si998\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.111.111.139:7019/api/EasyToOwnProcurement/UpdateProcurementHeader");

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
