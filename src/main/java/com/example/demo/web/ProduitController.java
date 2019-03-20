package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository proRepository;
	
	//Retourner des vues avec l'url spécifier 
	//Model c'est un objet qui stocke les informations traitées par le controlleur
	
	@RequestMapping(value="/Produits")
	public String Produits(Model model, 
			@RequestParam(name="page", defaultValue="0") int p, 
			@RequestParam (name="size", defaultValue="4")int s, 
			@RequestParam (name="motCle", defaultValue="")String mc) {
		
		Page<Produit> listPro=proRepository.chercherProMC("%"+mc+"%", new PageRequest(p,s));
		model.addAttribute("ListPro",listPro.getContent());
		int[] pages= new int[listPro.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle", mc);
		return "Produits"; //page Produits.html
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam(name="id")Long id, int page) {
		proRepository.deleteById(id);
		return "redirect:/Produits?page="+page;
	}
	
}
