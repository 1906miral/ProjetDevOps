package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;


import java.util.List;


@RestController
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {
   
	@Autowired
	IProduitService produitService;
//default constructor
        public ProduitRestController() {
	
	}

	@GetMapping("/retrieve-all-produits")
      @CrossOrigin(origins = "http://192.168.1.149:4200")
	@ResponseBody
	public List<Produit> getProduits() {
		
		return produitService.retrieveAllProduits();
	}


	@GetMapping("/retrieve-produit/{produit-id}")
      @CrossOrigin(origins = "http://192.168.1.149:4200")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	
	@PostMapping("/add-produit")
      @CrossOrigin(origins = "http://192.168.1.149:4200")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p) {
		
		return produitService.addProduit(p);
	}


	@DeleteMapping("/remove-produit/{produit-id}")
      @CrossOrigin(origins = "http://192.168.1.149:4200")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	@PutMapping("/modify-produit")
      @CrossOrigin(origins = "http://192.168.1.149:4200")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit p) {
		return produitService.updateProduit(p);
	}



}
