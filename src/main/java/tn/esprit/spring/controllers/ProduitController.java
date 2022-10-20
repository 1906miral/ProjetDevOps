package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.IProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    IProduitService produitService;
    // http://localhost:8089/SpringMVC/produit/assignProduitStock/1/5
    @PutMapping("/assignProduitStock/{idProduit}/{idStock}")
    @ResponseBody
    public void assignProduitToStock(@PathVariable("idProduit")Long idProd,@PathVariable("idStock")Long idStock){
    	produitService.assignProduitToStock(idProd, idStock);
    }

}
