package tn.esprit.spring;

import java.util.ArrayList;

import java.util.List;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.services.FournisseurService;
import tn.esprit.spring.entities.CategorieFournisseur;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.entities.Facture;
@EnableScheduling
@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

}
