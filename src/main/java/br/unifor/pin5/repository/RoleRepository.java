package br.unifor.pin5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.pin5.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
