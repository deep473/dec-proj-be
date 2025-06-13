package salesSavvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesSavvy.dto.LoginData;
import salesSavvy.entity.Users;
import salesSavvy.repository.UsersRepository;

@Service
public class UsersServiceImplementation 
					implements UsersService {
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		if(getUser(user.getUsername()) == null) {
			repo.save(user);
			return "success";
		}
		else
			return "fail";
	}
	@Override
	public Users getUser(String username) {
			return repo.findByUsername(username);
	}
	@Override
	public String validate(LoginData data) {
		Users user = getUser(data.getUsername());
		if(user == null)
			return "fail";
		else {
			if(data.getPassword().equals(user.getPassword())) {
				if(user.getRole().equals("admin"))
					return "admin";
				else
					return "customer";
			}
			else
				return "fail";
		}
	}
}
