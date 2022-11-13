package tn.esprit.rh.achat.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Produit implements Serializable {

	public Produit() {
	
	}
	public Produit(Long idProduit, String codeProduit, String libelleProduit, float prix, Date dateCreation,
			Date dateDerniereModification, Stock stock, Set<DetailFacture> detailFacture,
			CategorieProduit categorieProduit) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prix = prix;
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
		this.stock = stock;
		this.detailFacture = detailFacture;
		this.categorieProduit = categorieProduit;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModification;
	@ManyToOne
	@JsonIgnore
	private Stock stock;
	@OneToMany(mappedBy = "produit")
	@JsonIgnore
	private Set<DetailFacture> detailFacture;
	@ManyToOne
	@JsonIgnore
	private CategorieProduit categorieProduit;



	


	

}
