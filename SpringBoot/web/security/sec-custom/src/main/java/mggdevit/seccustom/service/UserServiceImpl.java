package mggdevit.seccustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mggdevit.seccustom.entity.User;
import mggdevit.seccustom.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println("User keresés");
		User user = findByEmail(username);
		if( user == null ){
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}


}
