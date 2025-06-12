package salesSavvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import salesSavvy.entity.Users;

public interface UsersRepository 
		extends JpaRepository<Users, Long>{

	Users findByUsername(String username);

}
