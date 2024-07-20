package eCommerceRegistration.business.abstracts;

import java.util.List;

import eCommerceRegistration.entities.concretes.User;

public interface UserService {
	
	void registerUser(User user);
	void registerWithExternalAccount(User user);
	void completeRegistration(User user, String email);
	void update(User user);
	void delete(User user);
	User getUser(int id);
	List<User> getAllUsers();
	void signIn(String email, String password);
	void signOut(User user);

}
