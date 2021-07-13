package Example;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleGETExample {
			// Base URL
		String ROOT_URI = "https://petstore.swagger.io/v2/pet/";

		// Test case using a DataProvider
		@Test(dataProvider = "petIdProvider")
		public void simple_get_test(String id) {
		    Response response = 
		        given().contentType(ContentType.JSON) // Set headers
		        .when().get(ROOT_URI + id); // Send GET request

		    // Print response
		    System.out.println(response.asPrettyString());
		    // Assertions
		    response.then().body("status", equalTo("alive"));
		}

		@DataProvider
		public Object[][] petIdProvider() {
		    // Setting parameters to pass to test case
		    Object[][] testData = new Object[][] { { "77232" }, { "77233" } };
		    return testData;
		}
		
}