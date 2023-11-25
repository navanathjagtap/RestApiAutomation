package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	//method created for getting URL
	//run on local cmd --> mvn test 
	static ResourceBundle getURL() {
		
	ResourceBundle routes = ResourceBundle.getBundle("routes");//local properties path or name
		return routes;
		
	}
	//get request
	public static Response readUser(String userName) {
		String get_url = getURL().getString("get_url");
		Response response = given()
				.pathParam("username",userName)
				.when()
				.get(get_url);
		return response;
	}
	
	//post request
	
	public static Response CreateUser(User payload) {
		String post_url = getURL().getString("post_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_url);
		return response;
	}
	
	//update user request
	
	public static Response updateUser(String userName, User payload) {
		String update_url = getURL().getString("update_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				.when()
				.put(update_url);
		return response;
	}
	
	//delete request
	public static Response deleteUser(String userName) {
		String delete_url = getURL().getString("delete_url");
		Response response = given()
				.pathParam("username",userName)
				.when()
				.get(delete_url);
		return response;
	}

}
