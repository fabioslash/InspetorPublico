package br.unifor.pin5.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import br.unifor.pin5.annotation.UniqueUsername;

@Entity
public class User{

	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min= 3, message = "Nome precisa ter mais de 3 caracteres!")
	@Column(unique = true)
	@UniqueUsername(message = "Usuário já existe")
	private String name;

	@Size(min = 1, message = "Email inválido")
	@Email(message = "Email inválido")
	private String email;

	@Size(min = 5, message = "Senha deve ter no mínimo 5 caracteres!")
	private String password;
	
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	
	@OneToMany(mappedBy = "user")
	private List<Obra> obras;

	
	
	

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
