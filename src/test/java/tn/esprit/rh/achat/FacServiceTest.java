package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.repositories.FactureRepository;

public class FacServiceTest {
	@Mock
	FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;
    
    Facture f1 = new Facture(13L, (float)1200, (float)1400,  false);
    Facture f2 = new Facture(14L, (float)1300, (float)1500,  true);

    List<Facture> listFactures = new ArrayList<Facture>() {
        {
        	 add(f1);
	         add(new Facture(15L, (float)1800, (float)1400,  true));
	         add(new Facture(16L, (float)1600, (float)1400,  false));
        }
    };
    

    @Test
   public void testretrieveAllFactures() {
        System.out.println("retrieveAllFactures");
        Mockito.when(factureRepository.findAll()).thenReturn(listFactures);
        List<Facture> factureList3 = factureService.retrieveAllFactures();
        assertEquals(3, factureList3.size());
        //assertEquals(operateur1.,55L);
    }

   public void retrieveFacture() {
        System.out.println("retrieveFactures");
        Mockito.when(factureRepository.findById(13L)).thenReturn(Optional.of(f1));
        Facture facture1 = factureService.retrieveFacture(13L);
        assertNotNull(facture1);
    }
    @Test
   public void testaddFacture(){
        System.out.println("testaddOperateur");
        Mockito.when(factureRepository.save(f1)).thenReturn(f1);
        Facture facture1 = factureService.addFacture(f1);
        assertNotNull(facture1);
        Mockito.verify(factureRepository, times(1)).save(Mockito.any(Facture.class));
    }


}
