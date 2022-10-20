package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Operateur;
@Repository
public interface OperateurRepository extends CrudRepository<Operateur,Long>{

}
