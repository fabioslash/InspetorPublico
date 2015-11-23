package br.unifor.pin5.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patrocinador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1238720556318592938L;


	@Id
	@GeneratedValue
	private Integer id;

	
	private String nome;


	
	@ManyToOne
	@JoinColumn(name = "obra_id")
	private Obra obra;
	
	
	public Obra getObra() {
		return obra;
	}


	public void setObra(Obra obra) {
		this.obra = obra;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	
	
	
	
		
	
}
