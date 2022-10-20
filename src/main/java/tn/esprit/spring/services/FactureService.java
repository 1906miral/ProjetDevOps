package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repositories.DetailFactureRepository;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.repositories.FournisseurRepository;
import tn.esprit.spring.repositories.OperateurRepository;
import tn.esprit.spring.repositories.ProduitRepository;
import tn.esprit.spring.repositories.ReglementRepository;
@Service
public class FactureService implements IFactureService{
   
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	OperateurRepository operateurRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;
	@Autowired
	ReglementRepository reglementRepository;
	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
	Facture facture=factureRepository.findById(idFacture)
.orElse(null);	
	Operateur operateur=operateurRepository.findById(idOperateur).orElse(null);
	facture.setOperateur(operateur);
	factureRepository.save(facture);
	
	}

	@Override
	@Transactional
	public Facture addFacture(Facture f, Long idFournisseur) {
		Fournisseur fournisseur=fournisseurRepository.findById(idFournisseur).orElse(null);
		f.setFournisseur(fournisseur);
		f.setDateCreationFacture(new Date());
		f.setArchivee(false);
		List<DetailFacture> detailsFacture=f.getDetailFactures();
		Facture facture=addDetailsFacture(f,detailsFacture);
		return factureRepository.save(f);
		
	}
	private Facture addDetailsFacture(Facture f,List<DetailFacture> detailsFacture){
		float montantFacture=0;
		float montantRemise=0;
		for(DetailFacture detail : detailsFacture){
			Produit produit=produitRepository.findById(detail.getProduit().getIdProduit()).orElse(null);
			float prixTotalDetail=detail.getQteCommandee() * produit.getPrix();
			float montantRemiseDetail=(prixTotalDetail * detail.getPourcentageRemise()) / 100;
			float prixTotalDetailRemise=prixTotalDetail - montantRemiseDetail;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotalDetail(prixTotalDetailRemise);
			montantFacture=montantFacture + prixTotalDetailRemise;
			montantRemise=montantRemise + montantRemiseDetail;
			detail.setProduit(produit);
			detail.setFacture(f);
			detailFactureRepository.save(detail);
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return f;
	}
	@Override
	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
	   Fournisseur fournisseur=fournisseurRepository.findById(idFournisseur).orElse(null);
       //return factureRepository.getFactureByFournisseur(fournisseur);
	   return factureRepository.findByFournisseur(fournisseur);
	}

	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		float totalFactureEntreDeuxDates=factureRepository.getTotalFacturesEntreDeuxDates(startDate, endDate);
		float totalRecouvrementEntreDeuxDates=reglementRepository.getChiffreAffaireEntreDeuxDate(startDate,endDate);
		float pourcentage=(totalFactureEntreDeuxDates/totalRecouvrementEntreDeuxDates)*100;
		return pourcentage;
	}


}
