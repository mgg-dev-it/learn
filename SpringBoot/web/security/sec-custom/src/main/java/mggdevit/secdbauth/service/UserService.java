package mggdevit.secdbauth.service;

import mggdevit.secdbauth.entity.User;

public interface UserService {

	public User findByEmail(String email);
	
}
