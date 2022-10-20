package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.services.IFactureService;

@RestController
//@RequestMapping("/facture")
public class FactureController {

	@Autowired 
	IFactureService factureService;
	// http://localhost:8089/SpringMVC/assignOperateurToFacture/1/1
	 @PutMapping(value="/assignOperateurToFacture/{idFacture}/{idOperateur}")
	 @ResponseBody
	public void assignOperateurToFacture(@PathVariable("idOperateur")Long idOperateur, @PathVariable("idFacture")Long idFacture){
		factureService.assignOperateurToFacture(idOperateur, idFacture);
	}
	 @PostMapping(value="/addFacture/{idFournisseur}")
	 @ResponseBody
	 public Facture addFacture(@RequestBody Facture f,@PathVariable("idFournisseur")Long idFournisseur){
	 Facture facture=factureService.addFacture(f, idFournisseur);
	 return facture;
	}
	 @GetMapping("/getFactureByFournisseur/{idFournisseur}")
	 @ResponseBody
	 public List<Facture> getFacturesByFournisseur(@PathVariable("idFournisseur")Long idFournisseur){
		 return factureService.getFacturesByFournisseur(idFournisseur);
	 }
	 @GetMapping(value="/pourcentageRecouvrement/{startDate}/{endDate}")
	 public float pourcentageRecouvrement(
			 @PathVariable(name="startDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date startDate,
			 @PathVariable(name="startDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date endDate){
		 //try{
			 return factureService.pourcentageRecouvrement(startDate, endDate);
		 //}
		 //catch (Exception e) {
			//return 0;
		//}
	 }

}
