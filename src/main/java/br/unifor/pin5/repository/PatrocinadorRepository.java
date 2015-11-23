package br.unifor.pin5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.pin5.entity.Obra;
import br.unifor.pin5.entity.Patrocinador;

public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Integer> {

   List<Patrocinador> findByObra(Obra obra);
	
}
