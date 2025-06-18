package salesSavvy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesSavvy.dto.LoginData;
import salesSavvy.entity.Users;
import salesSavvy.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {

    @Autowired
    private UsersRepository repo;

    @Override
    public String addUser(Users user) {
        Optional<Users> existing = getUser(user.getUsername());
        if (!existing.isPresent()) {
            repo.save(user);
            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public Optional<Users> getUser(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public String validate(LoginData data) {
        Optional<Users> userOpt = getUser(data.getUsername());
        if (!userOpt.isPresent()) {
            return "fail";
        }

        Users user = userOpt.get();
        if (!data.getPassword().equals(user.getPassword())) {
            return "fail";
        }

        if ("admin".equals(user.getRole())) {
            return "admin";
        } else {
            return "customer";
        }
    }
}
