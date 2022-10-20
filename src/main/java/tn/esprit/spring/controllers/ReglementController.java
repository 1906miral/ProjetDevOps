package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Reglement;
import tn.esprit.spring.services.IReglementService;

@RestController
public class ReglementController {

@Autowired
IReglementService reglementService;
@GetMapping(value="/retrieveReglementByFacture/{idFacture}")
public List<Reglement> getReglementByFacture(@PathVariable("idFacture")Long idFacture){
	return reglementService.retrieveReglementByFacture(idFacture);
}
@PostMapping(value="/addReglement/{idFacture}")
@ResponseBody
public Reglement addReglement(Reglement r,@PathVariable("idFacture")Long idFacture){
return reglementService.addReglement(r, idFacture);
}

}
