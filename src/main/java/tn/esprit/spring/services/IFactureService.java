package tn.esprit.spring.services;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Facture;
public interface IFactureService {
	void assignOperateurToFacture(Long idOperateur, Long idFacture);
	Facture addFacture(Facture f, Long idFournisseur);
	List<Facture> getFacturesByFournisseur(Long idFournisseur);
    float pourcentageRecouvrement(Date startDate,Date endDate);
}
