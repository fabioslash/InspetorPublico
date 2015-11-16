package br.unifor.pin5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.pin5.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);


}
