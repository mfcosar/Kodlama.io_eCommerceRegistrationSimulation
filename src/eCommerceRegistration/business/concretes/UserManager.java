package eCommerceRegistration.business.concretes;

import java.util.List;

import eCommerceRegistration.business.abstracts.UserInfoCheckService;
import eCommerceRegistration.business.abstracts.UserService;
import eCommerceRegistration.core.ExternalAccountValidateService;
import eCommerceRegistration.dataAccess.abstracts.UserDao;
import eCommerceRegistration.entities.concretes.User;

public class UserManager implements UserService{

	private UserInfoCheckService _userInfoCheckService;
	private UserDao _userDao;
	private ExternalAccountValidateService _externalAccountValidateService;
	
	
	public UserManager(UserInfoCheckService userInfoCheckService, UserDao userDao, ExternalAccountValidateService externalAccountValidateService) {
		this._userInfoCheckService = userInfoCheckService;
		this._userDao = userDao;
		this._externalAccountValidateService = externalAccountValidateService;
		
	}
	
	@Override
	public void registerUser(User user) {
		
		if (_userInfoCheckService.isValidUser(user, _userDao.getAll()) && (! user.isEmailConfirmed())) {
			_userInfoCheckService.sendConfirmationEmail(user, user.getEmail());
		}
		
		else if (user.isEmailConfirmed()) {
			_userDao.add(user);
			System.out.println("Kullanıcı sisteme eklendi: " + user.getFirstName());
		}
		
	}

	@Override
	public void completeRegistration(User user, String email) {
		_userInfoCheckService.completeRegistration(user, email);
		registerUser(user);
		
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
	public void signOut(User user) {
		System.out.println("Kullanıcı sistemden çıktı : " + user.getFirstName());
	}

	@Override
	public void registerWithExternalAccount(User user) {
		
		if (_externalAccountValidateService.CheckIfValidUser(user)) {
			user.setEmailConfirmed(true);
			registerUser(user);
			System.out.println("External account ile sisteme kayıt edildi: " + user.getFirstName() );
		}
		else System.out.println("External account ile sisteme kayıt edilemedi. Lütfen bilgilerinizi kontrol ediniz: " + user.getFirstName() );
		
	}

}
