package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.ProduitDTO;
import tn.esprit.rh.achat.services.IProduitService;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	@Autowired
	IProduitService produitService;
	private ProduitDTO convertToDto(Produit p) {
	    ProduitDTO prodDto = modelMapper().map(p, ProduitDTO.class);
	    return prodDto;
	}
	private Produit convertToEntity(ProduitDTO prodDto) throws ParseException {
	    Produit p = modelMapper().map(prodDto, Produit.class);
	    return p;
	}
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<ProduitDTO> getProduits() {
		List<Produit> list = produitService.retrieveAllProduits();
		return list.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public ProduitDTO retrieveRayon(@PathVariable("produit-id") Long produitId) {
		Produit p=produitService.retrieveProduit(produitId);
		return convertToDto(p);
	}

	/* Ajouter en produit tout en lui affectant la catégorie produit et le stock associés */
	// http://localhost:8089/SpringMVC/produit/add-produit/{idCategorieProduit}/{idStock}
	@PostMapping("/add-produit")
	@ResponseBody
	public ProduitDTO addProduit(@RequestBody Produit p) {
		Produit produit = produitService.addProduit(p);
		return convertToDto(produit);
	}

	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/modify-produit/{idCategorieProduit}/{idStock}
	@PutMapping("/modify-produit")
	@ResponseBody
	public ProduitDTO modifyProduit(@RequestBody Produit p) {
		Produit p1=produitService.updateProduit(p);
		return convertToDto(p1);
	}

	/*
	 * Si le responsable magasin souhaite modifier le stock du produit il peut
	 * le faire en l'affectant au stock en question
	 */
	// http://localhost:8089/SpringMVC/produit/assignProduitToStock/1/5
	/*@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}*/

	/*
	 * Revenu Brut d'un produit (qte * prix unitaire de toutes les lignes du
	 * detailFacture du produit envoyé en paramètre )
	 */
	// http://localhost:8089/SpringMVC/produit/getRevenuBrutProduit/1/{startDate}/{endDate}
/*	@GetMapping(value = "/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}")
	public float getRevenuBrutProduit(@PathVariable("idProduit") Long idProduit,
			@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

		return produitService.getRevenuBrutProduit(idProduit, startDate, endDate);
	}*/

}
