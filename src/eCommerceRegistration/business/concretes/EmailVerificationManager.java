package eCommerceRegistration.business.concretes;

import java.util.List;

import eCommerceRegistration.business.abstracts.EmailVerificationService;
import eCommerceRegistration.dataAccess.abstracts.EmailVerificationDao;
import eCommerceRegistration.entities.concretes.EmailVerification;
import eCommerceRegistration.entities.concretes.User;

public class EmailVerificationManager implements EmailVerificationService{

	private EmailVerificationDao _emailVerificationDao;
	
	
	
	public EmailVerificationManager(EmailVerificationDao _emailVerificationDao) {
		super();
		this._emailVerificationDao = _emailVerificationDao;
	}

	@Override
	public void add( int userId) {
		EmailVerification emailVerification = new EmailVerification();
		
		int sizeOfList = _emailVerificationDao.getAll().size();
		
		emailVerification.setId(sizeOfList + 1);
		emailVerification.setCode("verification randomcode123456");
		emailVerification.setUserId(userId);
		emailVerification.setVerified(false);
		_emailVerificationDao.add(emailVerification);
		
	}

	@Override
	public void update(EmailVerification emailVerification) {
		_emailVerificationDao.update(emailVerification);
		
	}

	@Override
	public void delete(EmailVerification emailVerification) {
		_emailVerificationDao.delete(emailVerification);
		
	}

	@Override
	public List<EmailVerification> getAll() {
		return  _emailVerificationDao.getAll();
	}

	@Override
	public void sendConfirmationEmail(User user) {
		
		System.out.println("Lütfen kaydınızı tamamlamak için " + user.getEmail()+ " adresine gönderilen onaylama linkine tıklayınız: " + user.getFirstName() );
		
	}

	@Override
	public void setVerification( EmailVerification emailVerification) {
		
		emailVerification.setVerified(true);
		
	}

	@Override
	public EmailVerification getOne(int userId) {
		
		return _emailVerificationDao.getOne(userId);
	}

}
