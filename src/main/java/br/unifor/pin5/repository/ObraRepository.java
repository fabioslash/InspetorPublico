package br.unifor.pin5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.pin5.entity.Obra;
import br.unifor.pin5.entity.User;

public interface ObraRepository extends JpaRepository<Obra, Integer>{

	
	List<Obra> findByUser(User user);

}
