package br.unifor.pin5.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
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

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObraRepository obraRepository;
	
	@Autowired
	private PatrocinadorRepository patrocinadorRepository;
	
	
	
	@PostConstruct
	public void init() {
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("slash"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		
		Obra obra1 = new Obra();
		obra1.setDescription("Casas populares");
		obra1.setObjective("contrução de 200 casas populares");
		obra1.setCity("Maracanaú");
		obra1.setState("CE");
		obra1.setMoney( new BigDecimal(30000));
		obra1.setPublishedDate( new Date() );
		obra1.setFinalDate( new Date() );
		obra1.setUser(userAdmin);
	    obraRepository.save(obra1);
		
       	Patrocinador pat1 = new Patrocinador();
       	pat1.setObra(obra1);
       	pat1.setNome("Banco do Brasil");
       	patrocinadorRepository.save(pat1);
       	
       	Patrocinador pat2 = new Patrocinador();
       	pat2.setObra(obra1);
       	pat2.setNome("Caixa economica");
       	patrocinadorRepository.save(pat2);
       	
       	
		
		
	}
}
