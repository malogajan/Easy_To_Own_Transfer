import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Find_Exisiting_IMEI {

        // ✅ Test 1: Valid warehouse code - Expecting item details
        @Test(priority = 0)
        void GetExistingIMEI() {

            // 🟡 Send GET request to the API with a valid Existing IMEI
            Response response = given()
                    .header("Content-Type", "application/json")
                    //.header("Authorization", "Bearer " + token) // Uncomment if auth is needed
                    //.body(requestBody) // Only used if POST method
                    .when()
                    .get("http://10.0.0.26:7019/api/EasyToOwnProcurement/FindExistingIMEI?primaryIMEINumber=54849848484848456");

            // 🧾 Print basic response details
            System.out.println("Status Code : " + response.getStatusCode());
            System.out.println("Response : " + response.getBody().asString());
            System.out.println("Body : " + response.getBody());
            System.out.println("Time taken : " + response.getTime());
            System.out.println("header : " + response.getHeader("content-type"));

            // 📦 Validate the response
            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("content-type");

            // ✅ Check that the response is JSON and status code is 200
            if (contentType != null && contentType.contains("json")) {
                int statuscode = response.statusCode();
                Assert.assertEquals(statuscode, 200, "❌ Status code is not 200");

                // 🔍 Validate that response contains expected field
                Assert.assertTrue(responseBody.contains("success"), "❌ Response does not contain 'itemCode'");
                System.out.println("success found in response: " + responseBody);
            } else {
                System.out.println("❌ Unexpected response content type or structure: " + response.statusCode());
            }
        }

        // ❌ Test 2: Invalid Existing IMEI - Expecting error message
        @Test(priority = 1)
        void Get_Invalid_Existing_IMEI() {

            // 🟡 Send GET request with an INVALID Existing IMEI
            Response response = given()
                    .header("Content-Type", "application/json")
                    //.header("Authorization", "Bearer " + token) // Uncomment if required
                    .when()
                    .get("http://10.0.0.26:7019/api/EasyToOwnProcurement/FindExistingIMEI?primaryIMEINumber=54849848484848456hhhh");

            // 🧾 Print the full response
            System.out.println("Status Code : " + response.getStatusCode());
            System.out.println("Response : " + response.getBody().asString());
            System.out.println("Body : " + response.getBody());
            System.out.println("Time taken : " + response.getTime());
            System.out.println("header : " + response.getHeader("content-type"));

            // 📦 Extract and verify the response
            String responseBody = response.getBody().asString();
            String contentType = response.getHeader("content-type");

            // ❗ Validate that API correctly handles bad warehouse codes
            if (contentType != null && contentType.contains("json")) {
                int statuscode = response.statusCode();
                Assert.assertEquals(statuscode, 404, "❌ Expected 404 for invalid warehouse code");

                // ✅ Ensure error message field is present in response
                Assert.assertTrue(responseBody.contains("errorMessages"), "❌ 'errorMessages' not found in response");
                System.out.println("Error message returned: " + responseBody);
            } else {
                System.out.println("❌ Unexpected response format: " + response.statusCode());
            }
        }
    }
