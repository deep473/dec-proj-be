package salesSavvy.service;

import salesSavvy.entity.Users;

public interface UsersService {

	String addUser(Users user);
	
	Users getUser(String username);

}
