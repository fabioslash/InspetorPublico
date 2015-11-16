package br.unifor.pin5.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.unifor.pin5.entity.Role;
import br.unifor.pin5.entity.User;
import br.unifor.pin5.repository.RoleRepository;
import br.unifor.pin5.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	

	public List<User> findAll() {

		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}


	public void save(User user) {
		//user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER") );
		user.setRoles(roles);

		
		userRepository.save(user);
	}



	public void delete(int id) {
		userRepository.delete(id);
	}



}
