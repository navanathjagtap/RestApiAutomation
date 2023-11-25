package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import api.utilities.*;
import io.restassured.response.Response;

public class DDTests2 {
	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass =DataProviders.class )
	public void testPostUser(String userId , String username , String fname , String Iname , String useremail,String pwd ,String phone) {
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(Iname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints2.CreateUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
	}

}
