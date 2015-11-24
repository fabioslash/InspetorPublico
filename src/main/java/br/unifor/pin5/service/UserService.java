package br.unifor.pin5.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.unifor.pin5.entity.Obra;
import br.unifor.pin5.entity.Patrocinador;
import br.unifor.pin5.entity.Role;
import br.unifor.pin5.entity.User;
import br.unifor.pin5.repository.ObraRepository;
import br.unifor.pin5.repository.PatrocinadorRepository;
import br.unifor.pin5.repository.RoleRepository;
import br.unifor.pin5.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ObraRepository obraRepository;

	@Autowired
	private PatrocinadorRepository patrocinadorRepository;

	public List<User> findAll() {

		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	public void save(User user) {
		// user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.delete(id);
	}
	
	public User findOneWithObras(String name) {
		 User user = userRepository.findByName(name); 
		return findOneWithObras(user.getId());
	}

	@Transactional
	public User findOneWithObras(int id) {
		User user = findOne(id);
		List<Obra> obras = obraRepository.findByUser(user);
		for (Obra obra : obras) {
			List<Patrocinador> patrocinadores = patrocinadorRepository.findByObra(obra);
			obra.setPatrocinadores(patrocinadores);
		}
		user.setObras(obras);

		return user;
	}

	public User findOne(String username) {
		return userRepository.findByName(username);
	}

}
