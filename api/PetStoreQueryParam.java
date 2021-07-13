package Example;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class PetStoreQueryParam {
	// Specify the base URL to the RESTful web service
	  final static String  baseURI = "https://petstore.swagger.io/v2/pet/findByStatus";
    @Test
    public void petGetRequest() {
    	Response response  =
		  given().contentType(ContentType.JSON)
		    .when().queryParam("status", "pending")
		    .get(baseURI);
		  
  }
  
  }

