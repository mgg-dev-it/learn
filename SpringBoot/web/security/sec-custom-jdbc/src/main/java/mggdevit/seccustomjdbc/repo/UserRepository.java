package mggdevit.seccustomjdbc.repo;

import org.springframework.data.repository.CrudRepository;

import mggdevit.seccustomjdbc.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
