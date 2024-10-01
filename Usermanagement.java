package main.rapl.api.payload;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rapL.API.Commanlibs;
import com.rapL.API.UsermanagementAPI;
import com.rapL.API.loginData;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Usermanagement {
	private static final Logger LOGGER = LoggerFactory.getLogger(Usermanagement.class);

	private static Response request;
	private static String userID;
	private static List<String> responseMessages = new ArrayList<>();

	 private static String createEmailID(String baseEmail, int counter) {
	        return baseEmail + counter + "@gmail.com";
	    }

	
	
	
	private static String forUserCreation(String testingEmail) {
		
		int emailCounter = Commanlibs.readCounterFromCSV();
	    String email = createEmailID(testingEmail, emailCounter);
	    Commanlibs.writeCounterToCSV(emailCounter+1);

	
		return "{\n  \"first_name\": \""+loginData.randomFirstname()+"\",\n  \"last_name\": \"\",\n  \"email\": \""+email+"\",\n  "
				+ "\"role\": \"USER\",\n  \"send_invitation\": false,\n  \"mobile_number\": \""+loginData.randomMobilenum()+"\",\n  \"language\": \"EN\",\n"
				+ "  \"custom_profile_fields\": [\n    {\n      \"property_id\": 313,\n      \"property\": \"gender\",\n     "
				+ " \"label\": \"Gender\",\n\"is_mandatory\": false,\n\"component_type\": \"DESCRIPTIVE\",\n      "
				+ "\"allowed_values\": [],\n\"value\": \"Male\"\n    },\n{\n\"property_id\": 317,\n      \"property\": \"age\",\n "
				+ "     \"label\": \"Age\",\n\"is_mandatory\": false,\n\"component_type\": \"DESCRIPTIVE\",\n      "
				+ "\"allowed_values\": [],\n\"value\": \"24\"\n    },\n{\n\"property_id\": 321,\n\"property\": \"do-you-know-about-rapl\",\n"
				+ "\"label\": \"Do you know about Rapl\",\n\"is_mandatory\": false,\n\"component_type\": \"DROPDOWN\",\n\"allowed_values\": [\n"
				+ "\"Yes\",\n        \"nooo\"\n      ],\n      \"value\": \"Yes\"\n    }\n  ],\n  \"auth_type\": \"DEFAULT\",\n  \"nodes\": [],\n"
				+ "\"bundle_ids\": [\n  2038\n ]\n}";
	}
	
	
	public static String createUser(String testingEmail) throws Exception {
		String token = Commanlibs.fetchToken();
		String payload = forUserCreation(testingEmail);
		RestAssured.baseURI = UsermanagementAPI.userCreation();
		request = given().header("Content-type", "application/json").header("Authorization", "Bearer " + token)
				.body(payload).post().then().extract().response();
		String userID = request.jsonPath().getString("user_id");
		setuserID(userID);
		LOGGER.info("UserCreation");
		responseMessages.add("User created Successfully with status code :" + request.getStatusCode());
		return request.asString();
	}

	public static void setuserID(String userIDvalue) {
		userID = userIDvalue;

	}

	public static String getuserID() {
		return userID;
	}




	public static List<String> getAllResponseMessages() {
		return new ArrayList<>(responseMessages);

	}
	
}
