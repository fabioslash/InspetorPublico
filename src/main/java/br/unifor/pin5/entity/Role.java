package br.unifor.pin5.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4836730511985104909L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	

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

	
	
	
}
