package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class CategorieProduit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorieProduit;
	//@NonNull
    private String codeProduit;
	//@NonNull
    private String libelleCategorie;
    @OneToMany(mappedBy="categorieProduit",cascade=CascadeType.ALL)
	//@NonNull
    private List<Produit> produits;

    
}
