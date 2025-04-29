import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Save_Receive_Stock_Summary {
        @Test(priority = 0)
        void Save_Receive_Stock_Summary() {

            // Send the Post request
            Response response = given().
                    header("Content-Type", "application/json").
                    // If needed, uncomment the Authorization header.
                    // header("Authorization", "Bearer " + token).
                            when().
                    post("http://10.111.111.139:7019/api/EasyToOwnReceiveStock/SaveReceiveStockSummary");

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
                Assert.assertTrue(responseBody.contains("recieved"), "'recieved' should be present in the response body");
                System.out.println("recieved by found in response: " + responseBody);
            } else {
                // Log and fail the test if the response is not JSON
                System.out.println("Unexpected response content type: " + contentType);
                Assert.fail("Expected JSON response but received: " + contentType);
            }
        }

        @Test(priority = 1)
        void Post_Save_Receive_Stock_Summary_with_Invalid_recieved_by_field() {

            // Assuming authorization is required
            String requestBody = "";  // Set the request body if needed

            // Send post request
            Response response = given().
                    header("Content-Type", "application/json").
                    //header("Authorization", "Bearer " + token). // Uncomment if authorization is needed
                    //body(requestBody). // Uncomment if body is needed
                            when().
                    post("http://10.111.111.139:7019/api/EasyToOwnReceiveStock/SaveReceiveStockSummary");

            // Print response details
            System.out.println("Status Code : " + response.getStatusCode());
            System.out.println("Response : " + response.getBody().asString());
            System.out.println("Body : " + response.getBody());
            System.out.println("Time taken : " + response.getTime());
            System.out.println("Header : " + response.getHeader("content-type"));

            // Get the response body and content type
            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("content-type");

            if (contentType != null && contentType.contains("json")) {
                int statusCode = response.statusCode();

                // Assert the expected status code
                Assert.assertEquals(statusCode, 404, "Expected status code 404, but got " + statusCode);

                // Assert the error message is present in the response body
                Assert.assertTrue(responseBody.contains("errorMessages"), "Error message not found in response");

                System.out.println("Error Messages: " + responseBody);
            } else {
                System.out.println("Unexpected response code: " + response.statusCode());
            }

            // Optionally assert that response time is under a certain limit
            Assert.assertTrue(response.getTime() < 2000, "Response time exceeded limit");
        }
        @Test(priority = 2)
        void Post_Save_Receive_Stock_Summary_with_Invalid_recieved_by_field_empty_recieved_date() {
            // Send the request
            String requestBody = "";  // Set the request body if needed
            Response response = given().
                    header("Content-Type", "application/json").
                    // If needed, uncomment the Authorization header.
                    // header("Authorization", "Bearer " + token).
                            when().
                    post("http://10.111.111.139:7019/api/EasyToOwnReceiveStock/SaveReceiveStockSummary");

            // Log status code, body, and response time for debugging purposes
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response: " + response.getBody().asString());
            System.out.println("Time Taken: " + response.getTime());
            System.out.println("Content-Type: " + response.getHeader("Content-Type"));

            // Parse response body and content type
            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("Content-Type");

            // Verify the content type and response code
            if (contentType != null && contentType.contains("json")) {
                int statusCode = response.statusCode();

                // Assert the expected status code for an invalid date format
                Assert.assertEquals(statusCode, 400, "Expected status code 400 for invalid start date format");

                // Assert that error messages are present in the response body
                Assert.assertTrue(responseBody.contains("errorMessages"), "Expected errorMessages in response body");
                System.out.println("Error Messages: " + responseBody);
            } else {
                System.out.println("Unexpected response type: " + contentType);
                Assert.fail("Expected JSON response but received: " + contentType);
            }
        }
    }
