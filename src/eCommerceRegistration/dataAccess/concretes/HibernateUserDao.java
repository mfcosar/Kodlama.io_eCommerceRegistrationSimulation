package eCommerceRegistration.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceRegistration.dataAccess.abstracts.UserDao;
import eCommerceRegistration.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Hibernate ile eklendi: "+ user.getFirstName());
	}

	@Override
	public void update(User user) {
		users.set(user.getId(), user);
		System.out.println("Hibernate ile güncellendi: "+ user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Hibernate ile silindi: "+ user.getFirstName());
		
	}

	@Override
	public List<User> getAll() {
		//System.out.println("Hibernate ile listelendi ");
		return users;
	}

	@Override
	public User getUser(int id) {
		for (User x: users) {
			if (x.getId() == id)
				return x;
		}
		return null;
	}

}
