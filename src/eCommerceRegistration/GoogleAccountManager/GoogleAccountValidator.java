package eCommerceRegistration.GoogleAccountManager;

import eCommerceRegistration.entities.concretes.User;

public class GoogleAccountValidator {
	
	public boolean CheckIfGoogleAccount(User user) {

		System.out.println("Google account sahibi: " + user.getFirstName());
		return true;
	}

}
