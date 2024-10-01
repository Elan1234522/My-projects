package main.rapl.apiRequest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rapL.API.Commanlibs;
import com.rapL.API.ReadProperties;

import main.rapl.api.payload.Usermanagement;


public class RapLuser {

	private  static ReadProperties data;
	@BeforeTest
	public void setup() throws Exception {
		data = new ReadProperties();
		Commanlibs.fetchToken();
		System.out.println("Token stored");
	}
	@Test
	public void newUser() throws Exception {
		new Usermanagement();
		Usermanagement.createUser(data.gettestingMail());
	}

	@AfterTest
	public void displayResponses() {
	System.out.println("----- All Responses -----");
	for (String message : Usermanagement.getAllResponseMessages()) {
		System.out.println(message);
	}
 }
}
