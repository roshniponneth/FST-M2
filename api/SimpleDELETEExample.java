package Example;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleDELETEExample {

	// Set Base URL
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

	@Test
	public void AddNewPet() {
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .when().delete(ROOT_URI + "/77232"); // Send DELETE request
	    
	    // Assert DELETE operation
	    /*
	    * A better way to assert the delete operation is to
	    * try to GET pet with id 77232
	    */
	    response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .when().get(ROOT_URI + "/77232"); // Send GET request
	    
	    // Print response
	    System.out.println(response.getBody().asPrettyString());
	    // Assertion
	    response.then().body("message", equalTo("Pet not found"));
	    
	}
}
