package eCommerceRegistration.dataAccess.abstracts;

import java.util.List;

import eCommerceRegistration.entities.concretes.EmailVerification;

public interface EmailVerificationDao {

	void add(EmailVerification emailVerification);
	void update(EmailVerification emailVerification);
	void delete(EmailVerification emailVerification);
	List<EmailVerification> getAll();
	EmailVerification getOne(int userId);
}
