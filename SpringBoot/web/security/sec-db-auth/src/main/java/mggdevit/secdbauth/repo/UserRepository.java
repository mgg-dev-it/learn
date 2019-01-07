package mggdevit.secdbauth.repo;

import org.springframework.data.repository.CrudRepository;

import mggdevit.secdbauth.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
