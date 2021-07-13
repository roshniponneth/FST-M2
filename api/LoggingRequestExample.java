package Example;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class LoggingRequestExample {
	
	// Declare request specification
		RequestSpecification requestSpec;

	@Test
	public void loggingRequestHeaders() {
	    Response response = given()
	        .log().headers() // Log only request headers
	        .spec(requestSpec) // Use requestSpec
	        .pathParam("petId", "77232") // Set path parameter
	        .get("/{petId}"); // Send GET request
	}
	@Test
	public void loggingRequestBody() {
	    String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";

	    Response response = given()
	        .log().body() // Log request body
	        .spec(requestSpec) // Use requestSpec
	        .contentType(ContentType.JSON) // Set headers
	        .body(reqBody) // Add request body
	        .when().post(); // Send POST request
	  	}
	
	
}
