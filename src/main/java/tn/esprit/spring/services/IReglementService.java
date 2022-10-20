package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Reglement;


public interface IReglementService {
	List<Reglement> retrieveReglementByFacture(Long idFacture);
	Reglement addReglement(Reglement r, Long idFacture);
    
}
