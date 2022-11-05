package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
@SpringBootTest(classes=ProfuitServiceTest.class)
@ExtendWith(MockitoExtension.class)
public class ProfuitServiceTest {
     @Mock
     ProduitRepository produitRepo;
     @InjectMocks
     ProduitServiceImpl produitService;
     Produit p1=new Produit(12L,"123","prod1",(float)1200, new Date(2022,11,03),new Date(2022,11,02),null,null,null);
     Produit p2=new Produit(13L,"123","prod2",(float)1200, new Date(2022,11,03),new Date(2022,11,02),null,null,null);
     List<Produit> listProduit=new ArrayList<Produit>(){
    	 {
    		 add(p1);
    		 add(p2);
    		 
    	 }
     };
     @Test
     public void retrieveProduitsTest(){
    	 System.out.println("retrieveProduitTest");
    	 Mockito.when(produitRepo.findById(12L)).thenReturn(Optional.of(p1));
    	 Produit prod1 = produitService.retrieveProduit(12L);
	     assertNotNull(prod1);
    	 
     }
     @Test
 	   public void retrieveAllProduitsTest() {
    	    long taille=produitRepo.count();
 	        System.out.println("retrieveAllProduitsTest");
 	        Mockito.when(produitRepo.findAll()).thenReturn(listProduit);
 	        List<Produit> listprod = produitService.retrieveAllProduits();
 	        assertEquals(taille, listprod.size());
 	        
 	    }
     @Test
 	   public void addProduitTest(){
 	        System.out.println("addProduitTest");
 	        Mockito.when(produitRepo.save(p1)).thenReturn(p1);
 	        Produit produit1 = produitService.addProduit(p1);
 	        assertNotNull(produit1);
 	        Mockito.verify(produitRepo).save(Mockito.any(Produit.class));
 	    }
     @Test
	   public void updateProduitTest(){
	        System.out.println("updateProduitTest");
	        p1.setLibelleProduit("prod1Updated");
	        Mockito.when(produitRepo.save(p1)).thenReturn(p1);
	        Produit produit1 = produitService.updateProduit(p1);
	        assertNotNull(produit1);
	        Mockito.verify(produitRepo).save(Mockito.any(Produit.class));
	    }



 	    @Test
 	   public void deleteProduitTest(){
 	        System.out.println("deleteProduitTest");
 	        produitService.deleteProduit(13L);;
 	        Mockito.verify(produitRepo).delete(p2);
 	    }
     

}
