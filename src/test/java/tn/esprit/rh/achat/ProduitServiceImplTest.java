package tn.esprit.rh.achat;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {
@Mock
ProduitRepository produitRepository;
@InjectMocks
ProduitServiceImpl produitService;
Produit p1=new Produit(12L,"123","prod1",(float)1200,null,null,null,null,null);
Produit p2=new Produit(17L,"123","prod4",(float)1200,null,null,null,null,null);
List<Produit> listProduits=new ArrayList<Produit>(){
	{
		add(p1);
	add(new Produit(13L,"123","prod2",(float)1200,null,null,null,null,null));
	add(new Produit(14L,"123","prod3",(float)1200,null,null,null,null,null));
	}
	
};
@Test
@Order(1)
public void testRetrieveProduit() {
   System.out.println("Mock1 TestRetrieveProduit");
    Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p1));
    Produit produit1 = produitService.retrieveProduit(Long.valueOf("1"));
    Assertions.assertNotNull(produit1);
}
@Test
@Order(2)
public void testRetrieveAllProduit() {
   System.out.println("Mock2 TestRetrieveAllProduit");
    Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
    List<Produit> listP=produitService.retrieveAllProduits();
    assertEquals(3,listP.size());
}
@Test
@Order(3)
public void testAddProduit() {
   System.out.println("Mock3 TestAddProduit");
    Mockito.when(produitRepository.save(p1)).thenReturn(p1);
    Produit p=produitService.addProduit(p1);
    assertNotNull(p);
    Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));
}
@Test
@Order(4)
   public void testdeleteproduit(){
        System.out.println("Mock 4 TestDeleteProduit");
        produitService.deleteProduit(13L);
        Mockito.verify(produitRepository, times(0)).delete(p2);
    }
@Test
@Order(5)
public void testUpdateProduit() {
   System.out.println("Mock5 TestUpdateProduit");
    Mockito.when(produitRepository.save(p1)).thenReturn(p1);
    Produit p=produitService.updateProduit(p1);
    assertNotNull(p);
    Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));
}
}
