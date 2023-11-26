package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//for logs 

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User userPayload;
	public Logger logger; // for logs'
	@BeforeClass
	public void setupData() {
		userPayload = new User();
		faker = new Faker();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setFirstName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
				logger= LogManager.getLogger(this.getClass());
				
				logger.debug("debugging.....");
	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("********** Creating user  ***************");
		Response response = UserEndPoints.CreateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User is creatged  ***************");
	}

	@Test(priority = 2)
	public void testGetUser() {
		logger.info("********** Reading User Info ***************");
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User info  is displayed ***************");
	}

	@Test(priority = 3)
	public void testUpdateUser() {
		// update all data using payload
		logger.info("********** Updating User ***************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setFirstName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);

		Response afterUpadteResponse = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(afterUpadteResponse.getStatusCode(), 200);
		logger.info("********** User updated ***************");
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("**********   Deleting User  ***************");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********** User deleted ***************");
	}

}
