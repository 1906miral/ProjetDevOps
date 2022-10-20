package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="Fournisseur")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fournisseur implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idFournisseur")
    private Long idFournisseur;
 
    private String codeFournisseur;
   
    private String libelleFournisseur;
  
    @Enumerated(EnumType.STRING)
    private CategorieFournisseur categorieFournisseur;
    @OneToOne
    private DetailFournisseur detailFournisseur;
    @JsonIgnore
    @OneToMany(mappedBy="fournisseur",cascade=CascadeType.ALL)
    private List<Facture> factures;
    @JsonIgnore
    @ManyToMany(mappedBy="fournisseurs",cascade=CascadeType.ALL)
    private List<SecteurActivite> secteurActivites;

	

    
}
