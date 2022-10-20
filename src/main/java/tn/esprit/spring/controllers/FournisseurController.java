package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.services.IFournisseurService;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    @Autowired
    IFournisseurService fournisseurService;
	// http://localhost:8080/SpringMVC/fournisseur/retrieve-all
	@GetMapping("/retrieve-all")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
	List<Fournisseur> listFournisseurs = fournisseurService.retrieveAll();
	return listFournisseurs;
	}
	
	// http://localhost:8080/SpringMVC/fournisseur/retrieve/8
	@GetMapping("/retrieve/{fournisseur-id}")
	@ResponseBody
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
	return fournisseurService.retrieveById(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/add
	@PostMapping("/add")
	@ResponseBody
	public Fournisseur addFournisseur(@RequestBody Fournisseur f)
	{
		Fournisseur fournisseur = fournisseurService.add(f);
	return fournisseur;
	}
	
	// http://localhost:8080/SpringMVC/fournisseur/remove/{fournisseur-id}
	@DeleteMapping("/remove/{fournisseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.delete(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/modify
	@PutMapping("/modify")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur f) {
	return fournisseurService.update(f);
	}
	// http://localhost:8089/SpringMVC/fournisseur/assignSecteurActiviteToFournisseur/1/1
	 @PutMapping("/assignSecteurActiviteToFournisseur/{idFournisseur}/{idSecteur}")
	 @ResponseBody
	 public void assignSecteurActiviteToFournisseur(@PathVariable("idFournisseur")Long idFournisseur, @PathVariable("idSecteur")Long idSecteur) {
		fournisseurService.assignSecteurActiviteToFournisseur(idFournisseur,idSecteur);
		
	}

}
