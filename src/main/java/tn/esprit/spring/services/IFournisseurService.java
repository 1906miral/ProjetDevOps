package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Fournisseur;

public interface IFournisseurService {
	List<Fournisseur> retrieveAll();
	Fournisseur add (Fournisseur f);
	void delete (Long id);
	Fournisseur update(Fournisseur f);
	Fournisseur retrieveById (Long id);
	void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId);
}
