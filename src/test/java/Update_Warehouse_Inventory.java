import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Update_Warehouse_Inventory {
    @Test(priority = 0)
        //Run|Debug
    void Update_Warehouse_Inventory () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"04\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"procuredQuantity\": 200,\n" +
                "  \"processType\": \"add\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnProcurement/UpdateWarehouseInventory");

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
    void Update_Warehouse_Inventory_without_whsCode () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"procuredQuantity\": 20,\n" +
                "  \"processType\": \"add\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnProcurement/UpdateWarehouseInventory");

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
    void Update_Warehouse_Inventory_without_ProductCode () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"04\",\n" +
                "  \"productCode\": \"\",\n" +
                "  \"procuredQuantity\": 20,\n" +
                "  \"processType\": \"add\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnProcurement/UpdateWarehouseInventory");

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
    void Update_Warehouse_Inventory_with_ProcuredQuantity () {

        String requestBody = "{\n" +
                "  \"whsCode\": \"04\",\n" +
                "  \"productCode\": \"SSA01BK\",\n" +
                "  \"procuredQuantity\": ,\n" +
                "  \"processType\": \"add\"\n" +
                "}";
        Response response = given().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer " + token).
                        body(requestBody).
                when().
                post("http://10.0.0.26:7019/api/EasyToOwnProcurement/UpdateWarehouseInventory");

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
        void Update_Warehouse_Inventory_with_ProcessType_Subract () {

            String requestBody = "{\n" +
                    "  \"whsCode\": \"04\",\n" +
                    "  \"productCode\": \"SSA01BK\",\n" +
                    "  \"procuredQuantity\":20 ,\n" +
                    "  \"processType\": \"subtract\"\n" +
                    "}";
            Response response = given().
                    header("Content-Type", "application/json").
                    //header("Authorization", "Bearer " + token).
                            body(requestBody).
                    when().
                    post("http://10.0.0.26:7019/api/EasyToOwnProcurement/UpdateWarehouseInventory");

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
    }
