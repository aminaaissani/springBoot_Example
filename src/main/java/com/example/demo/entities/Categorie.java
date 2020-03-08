package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection<Produit> p;
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(String name) {
		super();
		this.name = name;
	}
	
	public Categorie(String name, Collection<Produit> p) {
		super();
		this.name = name;
		this.p = p;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Produit> getP() {
		return p;
	}
	public void setP(Collection<Produit> p) {
		this.p = p;
	}
	
	
	
	

}
