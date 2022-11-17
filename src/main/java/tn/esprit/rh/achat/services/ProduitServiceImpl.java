package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Produit;

import tn.esprit.rh.achat.repositories.ProduitRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;


	@Override
	public List<Produit> retrieveAllProduits() {
		 	
            return  produitRepository.findAll();

	}

	@Transactional
	public Produit addProduit(Produit p) {
		return produitRepository.save(p);
		
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
		return produitRepository.findById(produitId).orElse(null);


	}




}