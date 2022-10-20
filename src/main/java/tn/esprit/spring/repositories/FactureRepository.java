package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Fournisseur;
@Repository
public interface FactureRepository extends CrudRepository<Facture,Long>{ 
    //@Query("SELECT f from Facture f where f.fournisseur=:fournisseur and f.archivee=false")
    //List<Facture> getFactureByFournisseur(@Param("fournisseur")Fournisseur fournisseur);
    List<Facture> findByFournisseur(Fournisseur fournisseur);
    @Query("SELECT sum(f.montantFacture) From Facture f where f.dateCreationFacture between :startDate and :endDate")
    float getTotalFacturesEntreDeuxDates(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}
