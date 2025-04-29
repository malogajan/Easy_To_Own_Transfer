import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Find_Max_Id {

        // ✅ Test 1: Valid warehouse code - Expecting item details
        @Test(priority = 0)
        void Get_FindMax_Id () {

            // 🟡 Send GET request to the API with a valid Max Id
            Response response = given()
                    .header("Content-Type", "application/json")
                    //.header("Authorization", "Bearer " + token) // Uncomment if auth is needed
                    //.body(requestBody) // Only used if POST method
                    .when()
                    .get("http://10.111.111.139:7019/api/EasyToOwnProcurement/FindMaxId");

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
                Assert.assertTrue(responseBody.contains("maxId"), "❌ Response does not contain 'itemCode'");
                System.out.println("maxId found in response: " + responseBody);
            } else {
                System.out.println("❌ Unexpected response content type or structure: " + response.statusCode());
            }
        }
}
