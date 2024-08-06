package eCommerceRegistration.entities.concretes;

import java.util.Date;

public class EmailVerification {
	private int id;
	private int userId;
	private String code;
	private boolean isVerified;
	private Date verficationDate;
	
	public EmailVerification() {
		super();
	}

	
	public EmailVerification(int id, int userId, String code, boolean isVerified, Date verficationDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.code = code;
		this.isVerified = isVerified;
		this.verficationDate = verficationDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public boolean isVerified() {
		return isVerified;
	}


	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}


	public Date getVerficationDate() {
		return verficationDate;
	}


	public void setVerficationDate(Date verficationDate) {
		this.verficationDate = verficationDate;
	}
}
