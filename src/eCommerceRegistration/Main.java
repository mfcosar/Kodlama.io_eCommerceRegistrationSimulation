package eCommerceRegistration;

import eCommerceRegistration.business.concretes.UserInfoCheckManager;
import eCommerceRegistration.business.concretes.UserManager;
import eCommerceRegistration.core.GoogleAccountValidatorAdapter;
import eCommerceRegistration.dataAccess.concretes.HibernateUserDao;
import eCommerceRegistration.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager(new UserInfoCheckManager(), new HibernateUserDao(), 
				new GoogleAccountValidatorAdapter());
		
		User user1 = new User(1, "Ayşe", "Demircan", "aysedemircan@birmail.com", "password123");
		User user2 = new User(2, "Fatma", "Demircan", "aysedemircan@birmail.com", "password123");
		User user3 =  new User(3, "Ahmed", "Demircan", "ahmetdemircan@birmail.com", "password123");
		
		userManager.registerUser(user1);
		userManager.completeRegistration(user1, user1.getEmail()); // gönderilen emaile tıklandı simulasyonu
		
		userManager.signIn(user1.getEmail(), user1.getPassword());
		userManager.signOut(user1);
		
		userManager.registerUser(user2); // aynı email! uyarısı veriyor
		
		userManager.registerWithExternalAccount(user3);
		userManager.signIn(user3.getEmail(), user3.getPassword());
		userManager.signOut(user3);
		

		
		
	}

}
