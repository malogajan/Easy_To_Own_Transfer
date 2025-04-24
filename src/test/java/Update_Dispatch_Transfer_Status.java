import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Update_Dispatch_Transfer_Status {
    @Test(priority = 0)
        //Run|Debug
    void UpdateDispatchTransferStatus () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7,\n" +
                "  \"dispatchStatusId\": 2,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": 49,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    void UpdateDispatchTransferStatus_with_Invalid_Receipt_Number () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7008,\n" +
                "  \"dispatchStatusId\": 2,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": 49,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    void UpdateDispatchTransferStatus_with_Empty_Receipt_Number () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": ,\n" +
                "  \"dispatchStatusId\": 2,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": 49,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    void UpdateDispatchTransferStatus_with_Empty_DispatchStatus_Id () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7,\n" +
                "  \"dispatchStatusId\": ,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": 49,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    void UpdateDispatchTransferStatus_with_Invalid_DispatchStatus_Id () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7,\n" +
                "  \"dispatchStatusId\": 2g67,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": 49,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    void UpdateDispatchTransferStatus_with_Empty_Dispatch_by_User () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7,\n" +
                "  \"dispatchStatusId\": 2,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": ,\n" +
                "  \"userId\": 49,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    @Test(priority = 6)
        //Run|Debug
    void UpdateDispatchTransferStatus_with_Empty_User_Id () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7,\n" +
                "  \"dispatchStatusId\": 2,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": ,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
    void UpdateDispatchTransferStatus_with_Invalid_User_Id () {

        String requestBody = "{\n" +
                "  \"isDispatched\": true,\n" +
                "  \"isDelivered\": true,\n" +
                "  \"receiptNumber\": 7,\n" +
                "  \"dispatchStatusId\": 2,\n" +
                "  \"wayBillNumber\": \"\",\n" +
                "  \"deliveryDate\": \"2025/03/18 10:44:06\",\n" +
                "  \"expectedDeliveryDate\": \"2025/03/17 10:44:06\",\n" +
                "  \"deliveryNote\": \"string\",\n" +
                "  \"comments\": \"string\",\n" +
                "  \"dispatchedByUser\": 49,\n" +
                "  \"userId\": 49F,\n" +
                "  \"deliveredByUser\": 49\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                put("http://10.0.0.26:7019/api/EasyToOwnTransfer/UpdateDispatchTransferStatus");

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
