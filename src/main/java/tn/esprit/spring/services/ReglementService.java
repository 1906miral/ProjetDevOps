package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Reglement;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.repositories.ReglementRepository;

@Service
public class ReglementService implements IReglementService{
    @Autowired
	ReglementRepository reglementRepository;
    @Autowired
    FactureRepository factureRepository;

	@Override
	public List<Reglement> retrieveReglementByFacture(Long idFacture) {
		Facture facture=factureRepository.findById(idFacture).orElse(null);
		return reglementRepository.findByFacture(facture);
	}

	@Override
	public Reglement addReglement(Reglement r, Long idFacture) {
		Facture facture=factureRepository.findById(idFacture).orElse(null);
		r.setFacture(facture);
		Reglement reglement=reglementRepository.save(r);
		return reglement;
	}



	

}
