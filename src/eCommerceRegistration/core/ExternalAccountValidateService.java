package eCommerceRegistration.core;

import eCommerceRegistration.entities.concretes.User;

public interface ExternalAccountValidateService {
	
	boolean CheckIfValidUser(User user);

}
