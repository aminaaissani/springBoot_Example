package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@Query("Select p from Produit p where p.designation like :x")
	public Page<Produit> chercherProMC(@Param("x")String mc, Pageable pageable);
	
	@Query("Select p.prix from Produit p where p.designation like :name ")
	public double prixProduct(@Param("name")String name);
}
