package mggdevit.seccustom.repo;

import org.springframework.data.repository.CrudRepository;

import mggdevit.seccustom.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
