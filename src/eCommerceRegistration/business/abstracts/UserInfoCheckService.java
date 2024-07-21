package eCommerceRegistration.business.abstracts;

import java.util.List;

import eCommerceRegistration.entities.concretes.User;

public interface UserInfoCheckService {
	
	boolean checkFirstName(String firstName);
	boolean checkLastName(String lastName);
	boolean checkEmail(String email);
	boolean checkPassword(String password);
	boolean isValidUser(User user,  List<User> users);
	


}
