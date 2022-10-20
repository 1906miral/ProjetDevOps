package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
public class DetailFacture implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetailFacture;
	//@NonNull
	private int qteCommandee;
	//@NonNull
	private float prixTotalDetail;
	//@NonNull
	private int pourcentageRemise;
	//@NonNull
	private float montantRemise;
	//@NonNull
	@ManyToOne
	@JsonIgnore
	private Facture facture;
	//@NonNull
	@ManyToOne
	//@JsonIgnore
	private Produit produit;


	

}
