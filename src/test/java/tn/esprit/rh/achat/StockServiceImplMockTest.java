package tn.esprit.rh.achat;


import tn.esprit.rh.achat.entities.Stock;

import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMockTest {

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    Stock stock = new Stock("stock 1 test",10,100);
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(new Stock("stock 2 test",20,200));
            add(new Stock("stock 3 test",30,300));
        }
    };

    @Test
    @Order(1)
    public void testRetrieveStock() {
        log.info("========> In Mock Test 1 testAddStock");
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = stockService.retrieveStock(Long.valueOf("1"));
        Assertions.assertNotNull(stock1);
    }



}
