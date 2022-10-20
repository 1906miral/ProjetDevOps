package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class DetailFournisseur implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idDetailFournisseur;
    @Temporal(TemporalType.DATE)
    //@NonNull
    private Date dateDebutCollaboration;
    //@NonNull
    private String adresse;
    //@NonNull
    private String matricule;
    //@NonNull
    @OneToOne(mappedBy="detailFournisseur",cascade=CascadeType.ALL)
    private Fournisseur fournisseur;

   
}
