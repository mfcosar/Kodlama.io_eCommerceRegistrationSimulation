package eCommerceRegistration.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceRegistration.dataAccess.abstracts.EmailVerificationDao;
import eCommerceRegistration.entities.concretes.EmailVerification;

public class HibernateEmailVerificationDao implements EmailVerificationDao{
	List<EmailVerification> emailVerifications = new ArrayList<EmailVerification>();

	@Override
	public void add(EmailVerification emailVerification) {
		
		
		emailVerifications.add(emailVerification);
		
	}

	@Override
	public void update(EmailVerification emailVerification) {
		emailVerifications.set(emailVerification.getId(), emailVerification);
		
	}

	@Override
	public void delete(EmailVerification emailVerification) {
		emailVerifications.remove(emailVerification);
		
	}

	@Override
	public List<EmailVerification> getAll() {
		
		return emailVerifications;
	}

	@Override
	public EmailVerification getOne(int userId) {
		
		for (EmailVerification x: emailVerifications) {
			if (x.getUserId() == userId)
				return x;
		}
		return null;
	}

}
