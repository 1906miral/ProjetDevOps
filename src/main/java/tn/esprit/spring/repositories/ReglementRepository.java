package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Reglement;
@Repository
public interface ReglementRepository extends CrudRepository<Reglement,Long>{
   List<Reglement> findByFacture(Facture f);
	@Query("select sum(r.montantPaye) from Reglement r where r.dateReglement between :startDate and :endDate and r.facture.archivee=false ")
	float getChiffreAffaireEntreDeuxDate(@Param("startDate")Date startDate,@Param("endDate")Date  endDate);
}
