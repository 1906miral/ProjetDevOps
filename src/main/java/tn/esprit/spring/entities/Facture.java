package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Facture implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idFacture;
  
    private float montantRemise;
   
    private float montantFacture;
    
    @Temporal(TemporalType.DATE)
    private Date dateCreationFacture;
   
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
   
    private boolean archivee;
    @JsonIgnore
    @OneToMany(mappedBy="facture",cascade=CascadeType.ALL)
    private List<Reglement> reglements;
    @ManyToOne
    private Operateur operateur;
    @JsonIgnore
    @ManyToOne
    private Fournisseur fournisseur;
    //@JsonIgnore
    @OneToMany(mappedBy="facture",cascade=CascadeType.ALL)
    private List<DetailFacture> detailFactures;


    
}
