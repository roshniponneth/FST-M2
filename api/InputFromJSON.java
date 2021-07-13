package Example;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class InputFromJSON {
	// Set base URL
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
	
	@Test
	public void addNewPet() throws FileNotFoundException {
	    // Import JSON file
	    FileInputStream inputJSON = new FileInputStream("input.json");
	    // Read JSON file as String
	    String reqBody = inputJSON.toString();

	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .body(reqBody) // Pass request body from file
	        .when().post(ROOT_URI); // Send POST request

	    // Print response
	    String body = response.getBody().asPrettyString();
	    System.out.println(body);
	}
}
