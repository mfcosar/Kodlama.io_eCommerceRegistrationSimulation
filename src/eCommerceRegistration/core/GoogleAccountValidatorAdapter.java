package eCommerceRegistration.core;

import eCommerceRegistration.GoogleAccountManager.GoogleAccountValidator;
import eCommerceRegistration.entities.concretes.User;

public class GoogleAccountValidatorAdapter implements ExternalAccountValidateService{
		
	// DI injection da olabilirdi.
	public GoogleAccountValidatorAdapter() {
		
	}

	@Override
	public boolean CheckIfValidUser(User user) {
		GoogleAccountValidator googleAccountValidator = new GoogleAccountValidator();
		
		if (googleAccountValidator.CheckIfGoogleAccount(user))
			return true;
		else 
			return false;
	}

}
