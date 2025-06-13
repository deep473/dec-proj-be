package salesSavvy.service;

import salesSavvy.dto.LoginData;
import salesSavvy.entity.Users;

public interface UsersService {

	String addUser(Users user);
	
	Users getUser(String username);

	String validate(LoginData data);

}
