package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
public class SecteurActivite implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idSecteurActivite;
	//@NonNull
	private String codeFournisseur;
	//@NonNull
	private String libelleSecteurActivite;
	@ManyToMany
    @JsonIgnore
	//@NonNull
	private List<Fournisseur> fournisseurs;

   
}
