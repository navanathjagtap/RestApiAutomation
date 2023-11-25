package api.endpoints;

public class Routes {
	
//	post = https://petstore.swagger.io/v2/user/createWithList
//	put = https://petstore.swagger.io/v2/user/navnath
// get = https://petstore.swagger.io/v2/user/navnath
// delete = 	https://petstore.swagger.io/v2/user/navnath
	
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User module creation
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
}
