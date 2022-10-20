package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CategorieProduit;

@Repository
public interface CategorieProduitRepository extends CrudRepository<CategorieProduit,Long>{

}
