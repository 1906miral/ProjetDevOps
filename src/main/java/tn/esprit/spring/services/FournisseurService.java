package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.repositories.FournisseurRepository;
import tn.esprit.spring.repositories.SecteurActiviteRepository;

@Service
@Slf4j
public class FournisseurService implements IFournisseurService{
    @Autowired
    FournisseurRepository fournisseurRepository;
	@Autowired 
	SecteurActiviteRepository secteurActiviteRepository;

	@Override
	public List<Fournisseur> retrieveAll() {
		List<Fournisseur> fournisseurs=(List<Fournisseur>) fournisseurRepository.findAll();
		return fournisseurs;
	}

	@Override
	public Fournisseur add(Fournisseur f) {
		return fournisseurRepository.save(f);
		 }

	@Override
	public void delete(Long id) {
		fournisseurRepository.deleteById(id);
		
	}

	@Override
	public Fournisseur update(Fournisseur f) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur retrieveById(Long id) {
		return fournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
		Fournisseur fournisseur=fournisseurRepository.findById(fournisseurId).orElse(null);
		SecteurActivite secteurActivite=secteurActiviteRepository.findById(secteurActiviteId).orElse(null);
        secteurActivite.getFournisseurs().add(fournisseur);
		//fournisseur.getSecteurActivites().add(secteurActivite);
        secteurActiviteRepository.save(secteurActivite);
		//fournisseurRepository.save(fournisseur);
	}


}
