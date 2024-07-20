package eCommerceRegistration.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceRegistration.business.abstracts.UserInfoCheckService;
import eCommerceRegistration.entities.concretes.User;

public class UserInfoCheckManager implements UserInfoCheckService{
	
	@Override
	public boolean checkFirstName(String firstName) {

		if (firstName.length() == 0) {
			System.out.println("İsim alanı zorunludur. Lütfen isminizi giriniz!");
			return false;}
		else if (firstName.length() < 2) {
			System.out.println("İsim en az 2 karakterden oluşmalıdır. Lütfen isminizi giriniz!");
			return false;}
		else
			return true;
	}

	@Override
	public boolean checkLastName(String lastName) {
		if (lastName.length() == 0) {
			System.out.println("Soyad alanı zorunludur. Lütfen soyadınızı giriniz!");
			return false;}
		else if (lastName.length() < 2) {
			System.out.println("Soyad en az 2 karakterden oluşmalıdır. Lütfen soyadınızı giriniz!");
			return false;}
		else
			return true;
	}

	@Override
	public boolean checkEmail(String email) {
		if (email.length() == 0) {
			System.out.println("Email alanı zorunludur. Lütfen emailinizi giriniz!");
			return false;}
		else if (!checkEmailRegex(email)) {
			System.out.println("Emailiniz geçerli değil. Lütfen geçerli bir email giriniz!");
			return false;}
		else
			return true;
	}
	
	private boolean checkEmailRegex(String email) {
		
		Pattern p = Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$"); 
		//\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b
		Matcher m = p.matcher(email);
		if (m.find())
			return true;
		else 
			return false;
	}
	// unique email kontrol nerde yapılmalı?
	
	public boolean isUniqueEmail(String email, List<User> users) {
		
		for (User x: users) {
			if (x.getEmail().equals(email))
				System.out.println("Bu email sisteme kayıtlı. Lütfen başka bir email giriniz");
				return false;
		}
		
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		if (password.length() == 0) {
			System.out.println("Şifre alanı zorunludur. Lütfen şifrenizi giriniz!");
			return false;}
		else if (password.length() < 6 ) {
			System.out.println("Şifre en az 6 karakter olmalıdır!");
			return false;}
		else
			return true;
	}

	@Override
	public void sendConfirmationEmail(User user, String email) {
		System.out.println("Lütfen kaydınızı tamamlamak için " + email+ " adresine gönderilen onaylama linkine tıklayınız: " + user.getFirstName() );
	}
	
	
	@Override
	public boolean isValidUser(User user, List<User> users) {
		
		if (checkFirstName(user.getFirstName()) && checkLastName(user.getLastName()) && checkEmail(user.getEmail()) &&
				isUniqueEmail(user.getEmail(), users) && checkPassword(user.getPassword()) )
			return true;
		
		else 
			return false;
	}

	@Override
	public void completeRegistration(User user, String email) {
		user.setEmailConfirmed(true);
		
	}

}
