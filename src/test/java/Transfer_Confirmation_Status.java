import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Transfer_Confirmation_Status {
    @Test(priority = 0)
        //Run|Debug
    void GetTransferConfirmation () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=1&codeTo=Q215756");

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

            Assert.assertTrue(responseBody.contains("receiptNo"));
            System.out.println("receiptNo:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 1)
        //Run|Debug
    void GetTransferConfirmationStatus_with_Invalid_ReceiptNo () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=FF&qtySum=1&codeTo=Q215756");

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

            Assert.assertTrue(responseBody.contains("The value 'FF' is not valid"));
            System.out.println("The value 'FF' is not valid:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 2)
        //Run|Debug
    void GetTransferConfirmationStatus_with_Blank_ReceiptNo () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?codeTo=Q215756");

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
    void GetTransferConfirmationStatus_with_Invalid_QTYSUM() {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?codeTo=Q215756");

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
    void GetTransferConfirmationStatus_with_Blank_QTYSUM() {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7");

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
    void GetTransferConfirmationStatus_with_Less_QTYSUM() {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=-1F&codeTo=Q215756");

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
    void GetTransferConfirmationStatus_with_More_QTYSUM() {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=100&codeTo=Q215756");

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

            Assert.assertTrue(responseBody.contains("receiptNo"));
            System.out.println("receiptNo:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 7)
        //Run|Debug
    void GetTransferConfirmationStatus_with_Invalid_CodeTo() {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=1&codeTo=Q2157F56");

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

            Assert.assertTrue(responseBody.contains("receiptNo"));
            System.out.println("receiptNo:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 8)
        //Run|Debug
    void GetTransferConfirmationStatus_with_Blank_CodeTo() {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=1");

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
    @Test(priority = 9)
        //Run|Debug
    void GetTransferConfirmationStatus_with_isWarehouseTransfer_false () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=1&codeTo=Q215756&isWarehouseTransfer=false");

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

            Assert.assertTrue(responseBody.contains("receiptNo"));
            System.out.println("receiptNo:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
    @Test(priority = 10)
        //Run|Debug
    void GetTransferConfirmationStatus_with_isWarehouseTransfer_true () {

        //String requestBody = "";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                //body(requestBody).
                        when().
                get("http://10.111.111.139:7019/api/EasyToOwnTransfer/GetTransferConfirmationStatus?receiptNo=7&qtySum=1&codeTo=Q215756&isWarehouseTransfer=true");

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

            Assert.assertTrue(responseBody.contains("receiptNo"));
            System.out.println("receiptNo:" + responseBody);
        } else {
            System.out.println("Unexpected response code : " + response.statusCode());

        }
    }
}