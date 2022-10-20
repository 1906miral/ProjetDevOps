package tn.esprit.spring.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.ProduitRepository;
import tn.esprit.spring.repositories.StockRepository;
@Service
public class ProduitService implements IProduitService{
@Autowired
 ProduitRepository produitRepository;
@Autowired
StockRepository stockRepository;
	@Override
	public void assignProduitToStock(Long idProd, Long idStock) {
		Produit produit=produitRepository.findById(idProd).orElse(null);
		Stock stock=stockRepository.findById(idStock).orElse(null);
		produit.setStock(stock);
		produitRepository.save(produit);
		
	}
/*	@Override
	public float getRevenuBrutProd(Long idProd, Date startDate, Date endDate) {
		float revenu=0;
		Produit produit=produitRepository.findById(idProd).orElse(null);
		revenu=produit.getStock().getQte()
		return revenu;
	}*/


	

}
