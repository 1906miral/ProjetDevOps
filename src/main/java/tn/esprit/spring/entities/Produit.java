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
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	//@NonNull
    private String codeProduit;
	//@NonNull
    private String libelleProduit;
	//@NonNull
    private float prix;
    @Temporal(TemporalType.DATE)
    //@NonNull
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    //@NonNull
    private Date dateDerniereModification;
    @OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
    //@NonNull
   // @JsonIgnore
    private List<DetailFacture> detailFactures;
    @ManyToOne
    //@NonNull
    private Stock stock;
    @ManyToOne
    //@NonNull
    private CategorieProduit categorieProduit;

    
}
