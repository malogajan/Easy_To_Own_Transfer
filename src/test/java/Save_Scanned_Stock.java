import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Save_Scanned_Stock {
        @Test(priority = 0)
        void Save_Scanned_Stock() {
            // Send the Post request
            String requestBody = "{\n" +
                    "  \"itemName\": \"Phone\",\n" +
                    "  \"serial\": \"7878879890098\",\n" +
                    "  \"primaryIMEINumber\": \"P75468464\",\n" +
                    "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                    "  \"additionalSerial\": \"4546846840090\",\n" +
                    "  \"receiveStockSummaryId\": 5,\n" +
                    "  \"deviceMakeId\": 6,\n" +
                    "  \"deviceModelId\": 1,\n" +
                    "  \"scanUserId\": 49\n" +
                    "}";  // Set the request body if needed
            Response response = given().
                    header("Content-Type", "application/json").
                    // If needed, uncomment the Authorization header.
                    // header("Authorization", "Bearer " + token).
                    body(requestBody). // Uncomment if body is needed
                            when().
                    post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

            // Log the response details for debugging purposes
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response: " + response.getBody().asString());
            System.out.println("Time Taken: " + response.getTime());
            System.out.println("Content-Type: " + response.getHeader("Content-Type"));

            // Parse the response
            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("Content-Type");

            // Check if the response content type is JSON
            if (contentType != null && contentType.contains("json")) {
                int statusCode = response.statusCode();

                // Assert the status code is 200 for a successful response
                Assert.assertEquals(statusCode, 200, "Expected status code 200 for successful response");

                // Assert that the response body contains 'startDate'
                Assert.assertTrue(responseBody.contains("success"), "'success' should be present in the response body");
                System.out.println("success found in response: " + responseBody);
            } else {
                // Log and fail the test if the response is not JSON
                System.out.println("Unexpected response content type: " + contentType);
                Assert.fail("Expected JSON response but received: " + contentType);
            }
            // Optionally assert that response time is under a certain limit
            Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
        }

        @Test(priority = 1)
        void Save_Scanned_Stock_with_Invalid_Item_Name() {
            // Send the Post request
            String requestBody = "{\n" +
                    "  \"itemName\": \"@@@$--------#!$%%%%%----%2323\",\n" +
                    "  \"serial\": \"787887989898\",\n" +
                    "  \"primaryIMEINumber\": \"P75468464\",\n" +
                    "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                    "  \"additionalSerial\": \"4546846840090\",\n" +
                    "  \"receiveStockSummaryId\": 5,\n" +
                    "  \"deviceMakeId\": 6,\n" +
                    "  \"deviceModelId\": 1,\n" +
                    "  \"scanUserId\": 49\n" +
                    "}";  // Set the request body if needed
            Response response = given().
                    header("Content-Type", "application/json").
                    // If needed, uncomment the Authorization header.
                    // header("Authorization", "Bearer " + token).
                            body(requestBody). // Uncomment if body is needed
                            when().
                    post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

            // Log the response details for debugging purposes
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response: " + response.getBody().asString());
            System.out.println("Time Taken: " + response.getTime());
            System.out.println("Content-Type: " + response.getHeader("Content-Type"));

            // Parse the response
            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("Content-Type");

            // Check if the response content type is JSON
            if (contentType != null && contentType.contains("json")) {
                int statusCode = response.statusCode();

                // Assert the status code is 200 for a successful response
                Assert.assertEquals(statusCode, 400, "Expected status code 400 in response");

                // Assert that error messages are present in the response body
                Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
                System.out.println("Error Messages: " + responseBody);
            } else {
                // Log and fail the test if the response is not JSON
                System.out.println("Unexpected response content type: " + contentType);
                Assert.fail("Expected JSON response but received: " + contentType);
            }
            // Optionally assert that response time is under a certain limit
            Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
        }
    @Test(priority = 2)
    void Save_Scanned_Stock_with_empty_Item_Name() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"\",\n" +
                "  \"serial\": \"787887989898\",\n" +
                "  \"primaryIMEINumber\": \"P75468464\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 200 for a successful response
            Assert.assertEquals(statusCode, 400, "Expected status code 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 3)
    void Save_Scanned_Stock_with_Invalid_serial() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"\",\n" +
                "  \"serial\": \"7878989898DDD@@SSS@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@SS\",\n" +
                "  \"primaryIMEINumber\": \"P75468464\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 200 for a successful response
            Assert.assertEquals(statusCode, 400, "Expected status code 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 4)
    void Save_Scanned_Stock_with_empty_serial() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"P75468464\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 5)
    void Save_Scanned_Stock_with_Invalid_primary_IMEI_Number() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"P7546846@@@@@4\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 5)
    void Save_Scanned_Stock_with_empty_primary_IMEI_Number() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 200 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 6)
    void Save_Scanned_Stock_with_empty_Device_Make_Id() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": ,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 for a in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errors"), "Expected errorMessages in response body");
            System.out.println("errors Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 7)
    void Save_Scanned_Stock_with_Invalid_Device_Make_Id() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": tyt,\n" +
                "  \"deviceMakeId\": tyt,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errors"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 8)
    void Save_Scanned_Stock_with_Invalid_Device_Mode_Id() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": rtrt,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errors"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 9)
    void Save_Scanned_Stock_with_empty_Device_Mode_Id() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": ,\n" +
                "  \"scanUserId\": 49\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errors"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 10)
    void Save_Scanned_Stock_with_Invalid_Scan_User_Id() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": 5,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": 1,\n" +
                "  \"scanUserId\": rtrtr\n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errors"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
    @Test(priority = 11)
    void Save_Scanned_Stock_with_empty_Scan_User_Id() {
        // Send the Post request
        String requestBody = "{\n" +
                "  \"itemName\": \"Phone\",\n" +
                "  \"serial\": \"\",\n" +
                "  \"primaryIMEINumber\": \"\",\n" +
                "  \"secondaryIMEINumber\": \"S546584684\",\n" +
                "  \"additionalSerial\": \"4546846840090\",\n" +
                "  \"receiveStockSummaryId\": tyt,\n" +
                "  \"deviceMakeId\": 6,\n" +
                "  \"deviceModelId\": rtrt,\n" +
                "  \"scanUserId\": \n" +
                "}";  // Set the request body if needed
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        body(requestBody). // Uncomment if body is needed
                        when().
                post("http://10.0.0.26:7019/api/EasyToOwnScanning/SaveScannedStock");

        // Log the response details for debugging purposes
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Content-Type: " + response.getHeader("Content-Type"));

        // Parse the response
        String responseBody = response.getBody().asString();
        String contentType = response.getHeader("Content-Type");

        // Check if the response content type is JSON
        if (contentType != null && contentType.contains("json")) {
            int statusCode = response.statusCode();

            // Assert the status code is 400 in response
            Assert.assertEquals(statusCode, 400, "Expected status code is 400 in response");

            // Assert that error messages are present in the response body
            Assert.assertTrue(responseBody.contains("errors"), "Expected errorMessages in response body");
            System.out.println("Error Messages: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
        // Optionally assert that response time is under a certain limit
        Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
    }
}
