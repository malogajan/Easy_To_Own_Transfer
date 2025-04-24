import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_Receive_Stock_Summary_Header_By_Count {
    @Test(priority = 0)
    void GetReceiveStockSummaryHeaderByCount() {

        // Send the GET request
        Response response = given().
                header("Content-Type", "application/json").
                // If needed, uncomment the Authorization header.
                // header("Authorization", "Bearer " + token).
                        when().
                get("http://10.0.0.26:7019/api/EasyToOwnReceiveStock/GetDeviceReceiveStockUsers");

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
            Assert.assertTrue(responseBody.contains("id"), "'startDate' should be present in the response body");
            System.out.println("id found in response: " + responseBody);
        } else {
            // Log and fail the test if the response is not JSON
            System.out.println("Unexpected response content type: " + contentType);
            Assert.fail("Expected JSON response but received: " + contentType);
        }
    }
}

