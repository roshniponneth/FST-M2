package Project;

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

public class GitHub_RestAssured_Project {

	
	// Declare request specification
			RequestSpecification requestSpec;
			String sshKey;
			int sshKeyId;
		
			@BeforeClass
			public void setUp() {
			    // Create request specification
			    requestSpec = new RequestSpecBuilder()
			        .setContentType(ContentType.JSON)
			        .addHeader("Authorization", "token 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")
			        .setBaseUri("https://api.github.com")
			        .build();
			    sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCqh4fpMmZ2ogBuzmcR8YLL1foQB7Ha6+5amJUfVwvkX/54pXp6LS4nzseovOwP059H8Br8wTHBXOeMOereSSDe4mIDjkSjBqrteJhWFRHaKFzgdbReePNi5dnd1oYRn5WdS5ZT7rga/2dUjaIBdVORBc10jLRxykhyc8SJB6Fm1Mn10nEBL/7WCXnjCe6upNwknHbM3aUgQp6Ac4Qd5hZuPMO57aW4C8hvDO1XvtSlRQOx1tQ3KFYO8NSFK2rjFBvuxIpMuniocYoVhQqr2KaKKvtOjck7e9AYeIkb33ATY5szxV6WRwiwarDtRNviPSbZws5VgRZWjpUkOFlui0KL ";
			}
		
			  @Test(priority=1)
			    public void postsshkey() {
				  String reqBody = "{\"title\": \"TestAPIKey\", \"key\": \"" + sshKey + "\"}";
				  Response response = given().spec(requestSpec)
						  	.body(reqBody)
						  	.when().post("/user/keys");
				  // Print response				  	
				  String body = response.getBody().asPrettyString();				  	
				  System.out.println(body);
				  // Assertion with response specification
				  sshKeyId = response.then().extract().path("id");
				  response.then().statusCode(201);
			    }
			  
			  @Test(priority=2)
			    public void getsshkey() {
				  
				  Response response = given().spec(requestSpec)
						  	.when().get("/user/keys");
				  // Print response				  	
				  String body = response.getBody().asPrettyString();				  	
				  System.out.println(body);
				  
				  // Assertion with response specification				  	
				  response.then().statusCode(200);
			    }
			  
			  @Test(priority=3)
			    public void deletesshkey() {
				  
				  Response response = given().spec(requestSpec)
						  .when().pathParam("keyId", "54546672") // Set path parameter
						  	.delete("/user/keys/{keyId}");
				 
				  // Print response				  	
				  String body = response.getBody().asPrettyString();				  	
				  System.out.println(body);
				  
				  // Assertion with response specification				  	
				  response.then().statusCode(204);
			    }
			  
			  
}
