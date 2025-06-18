package salesSavvy.service;

import java.util.Optional;

import salesSavvy.dto.LoginData;
import salesSavvy.entity.Users;

public interface UsersService {

	String addUser(Users user);
	
	Optional<Users> getUser(String username);

	String validate(LoginData data);

}
