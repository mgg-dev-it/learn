package mggdevit.seccustomjdbc.service;

import mggdevit.seccustomjdbc.entity.User;

public interface UserService {

	public User findByEmail(String email);
	
}
