package mggdevit.secjwt.util;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import mggdevit.secjwt.entity.ERole;
import mggdevit.secjwt.entity.Role;
import mggdevit.secjwt.repo.RoleRepository;

@Component
public class DataLoader {

	private final RoleRepository roleRepository;

	public DataLoader(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@PostConstruct
	private void loadData() {
		ArrayList<Role> alRole = new ArrayList<>();
		alRole.add(new Role(ERole.ROLE_ADMIN));
		alRole.add(new Role(ERole.ROLE_MODERATOR));
		alRole.add(new Role(ERole.ROLE_USER));
		roleRepository.saveAll(alRole);
	}
}
