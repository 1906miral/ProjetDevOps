package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.SecteurActivite;
@Repository
public interface SecteurActiviteRepository extends CrudRepository<SecteurActivite,Long>{

}
