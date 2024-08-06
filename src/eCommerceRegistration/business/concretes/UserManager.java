package eCommerceRegistration.business.concretes;

import java.util.List;

import eCommerceRegistration.business.abstracts.EmailVerificationService;
import eCommerceRegistration.business.abstracts.UserInfoCheckService;
import eCommerceRegistration.business.abstracts.UserService;
import eCommerceRegistration.core.ExternalAccountValidateService;
import eCommerceRegistration.dataAccess.abstracts.UserDao;
import eCommerceRegistration.entities.concretes.EmailVerification;
import eCommerceRegistration.entities.concretes.User;

public class UserManager implements UserService{

	private UserInfoCheckService _userInfoCheckService;
	private UserDao _userDao;
	private ExternalAccountValidateService _externalAccountValidateService;
	private EmailVerificationService _emailVerificationService;
	
	
	public UserManager(UserInfoCheckService userInfoCheckService, UserDao userDao, ExternalAccountValidateService externalAccountValidateService, EmailVerificationService emailVerificationService) {
		this._userInfoCheckService = userInfoCheckService;
		this._userDao = userDao;
		this._externalAccountValidateService = externalAccountValidateService;
		this._emailVerificationService = emailVerificationService;
		
	}
	
	@Override
	public void registerUser(User user) {
		
		_emailVerificationService.add(user.getId());
		
		if (_userInfoCheckService.isValidUser(user, _userDao.getAll()) && (! _emailVerificationService.getOne(user.getId()).isVerified())) {
			_emailVerificationService.sendConfirmationEmail(user);
		}
		
		else if (_emailVerificationService.getOne(user.getId()).isVerified()) {
			_userDao.add(user);
			System.out.println("Kullanıcı sisteme eklendi: " + user.getFirstName());
		}
		
	}
	

	@Override
	public void completeRegistration(User user, String email) {
		
		EmailVerification emailVerification = _emailVerificationService.getOne(user.getId());
		_emailVerificationService.setVerification(emailVerification);
		registerUser(user);
		
		System.out.println("Kullanıcının sisteme kaydı tamamlandı : " + user.getFirstName());
	}

	@Override
	public void update(User user) {
		_userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		_userDao.delete(user);
		
	}

	@Override
	public User getUser(int id) {
		return _userDao.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return _userDao.getAll();
	}

	@Override
	public void signIn(String email, String password) {
		// if email and password is correct then signIn
		
		for (User x: _userDao.getAll()) {
			if ((x.getEmail().equals(email)) && (x.getPassword().equals(password))) {
				System.out.println("Kullanıcı sisteme girdi : " + x.getFirstName());
				return;
			}
		}

	}
	
	@Override
	public void signInWithExternalAccount(User user) {
		// if email and password is correct then signIn
		
		if (_externalAccountValidateService.CheckIfValidUser(user)) {
			System.out.println("Dış servis hesabı ile sisteme girildi: " + user.getFirstName() );
		}
		else System.out.println("Dış servis hesabı ile sisteme girilemedi. Lütfen bilgilerinizi kontrol ediniz: " + user.getFirstName() );

	}

	@Override
	public void signOut(User user) {
		System.out.println("Kullanıcı sistemden çıktı : " + user.getFirstName());
	}

	@Override
	public void registerWithExternalAccount(User user) {
		
		if (_externalAccountValidateService.CheckIfValidUser(user)) {
			System.out.println("Dış servis hesabı ile sisteme kayıt edildi: " + user.getFirstName() );
			registerUser(user);
			
		}
		else System.out.println("Dış servis hesabı ile sisteme kayıt edilemedi. Lütfen bilgilerinizi kontrol ediniz: " + user.getFirstName() );
		
	}

}
