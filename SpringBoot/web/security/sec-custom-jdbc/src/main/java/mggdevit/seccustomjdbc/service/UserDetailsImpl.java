package mggdevit.seccustomjdbc.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import mggdevit.seccustomjdbc.entity.Role;
import mggdevit.seccustomjdbc.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 3185970362329652822L;

	private User user;

	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
			//System.out.println("role: " + role.getRole());
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		//System.out.println("email: ");
		//System.out.println(user.getEmail() );
		return user.getEmail();
		//return user.getFullName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
