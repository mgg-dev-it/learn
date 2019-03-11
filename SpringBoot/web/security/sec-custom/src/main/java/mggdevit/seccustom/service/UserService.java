package mggdevit.seccustom.service;

import mggdevit.seccustom.entity.User;

public interface UserService {

	public User findByEmail(String email);
	
}
