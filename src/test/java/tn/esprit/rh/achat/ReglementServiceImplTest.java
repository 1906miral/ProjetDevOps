package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
@SpringBootTest

class ReglementServiceImplTest {

    @Mock
    ReglementRepository rr;

    @InjectMocks
    ReglementServiceImpl reglementService;



    @Test
    void retrieveAllReglementsTest () {

        List<Reglement> list = new ArrayList<Reglement>() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add(new Reglement( 1L, 20, 10, true, null, null));
                add(new Reglement( 2L, 50, 50, false, null, null));

            }};

        when(reglementService.retrieveAllReglements()).thenReturn(list);
        List<Reglement> reglementList = reglementService.retrieveAllReglements();
        assertEquals(2, reglementList.size());
        log.info("retrieve all ==>"+ reglementList.toString());
    }


    @Test
    void addReglementTest (){

        Reglement R =new Reglement( 1L, 20, 10, true, null, null);
        R.setIdReglement(1L);


        reglementService.addReglement(R);
        verify(rr, times(1)).save(R);
        System.out.println(R);
        log.info("add ==>"+ R.toString());
    }


    @Test
    void retrieveReglementTest (){

        Reglement r =new Reglement( 1L, 20, 10, true, null, null);

        when(rr.findById(1L)).thenReturn(Optional.of(r));
        Reglement reglement= reglementService.retrieveReglement(1L);
        Assertions.assertNotNull(reglement);
        log.info("get ==>"+ reglement.toString());
    }



}