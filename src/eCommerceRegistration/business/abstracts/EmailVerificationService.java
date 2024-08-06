package eCommerceRegistration.business.abstracts;

import java.util.List;

import eCommerceRegistration.entities.concretes.EmailVerification;
import eCommerceRegistration.entities.concretes.User;

public interface EmailVerificationService {
	
	void add(int userId);
	void update(EmailVerification emailVerification);
	void delete(EmailVerification emailVerification);
	List<EmailVerification> getAll();
	void sendConfirmationEmail(User user);
	void setVerification(EmailVerification emailVerification);
	EmailVerification getOne(int userId);

}
