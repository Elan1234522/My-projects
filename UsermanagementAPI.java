package com.rapL.API;

public class UsermanagementAPI {
	static {
		domain = ReadProperties.getOrg("ORG");
	}
	private static String domain;
	
	public static String userCreation() {
		String create = "https://" + domain + ".raplqa.com/api/admin/users/onboard";
		return create;
	}
}
