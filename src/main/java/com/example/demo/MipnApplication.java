package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.CategorieRepository;
import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

@SpringBootApplication
public class MipnApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MipnApplication.class, args);
		ProduitRepository proDao= ctx.getBean(ProduitRepository.class);
		CategorieRepository catDao=ctx.getBean(CategorieRepository.class);
		
		Produit p1=new Produit("Asus" ,800, 5);
		Categorie c1=new Categorie("Laptop");
		p1.setCategorie(c1);
		catDao.save(c1);
		proDao.save(p1);
		
		System.out.println("Hello World!");
	}

}

