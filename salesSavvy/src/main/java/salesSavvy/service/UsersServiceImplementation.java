package salesSavvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
