package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.DetailFournisseur;
@Repository
public interface DetailFournisseurRepository extends CrudRepository<DetailFournisseur,Long>{

}
