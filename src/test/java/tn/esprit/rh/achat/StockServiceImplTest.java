package tn.esprit.rh.achat;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.services.IStockService;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceImplTest {

	@Autowired
	IStockService stockService;
	@Test
	@Order(1)
	public void testAddStock() {
		log.info("========> In Test 1 testAddStock");
		List<Stock> stocks = stockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
	}
	@Test
	@Order(2)
	public void testAddStockOptimized() {
		log.info("========> In Test 2 testAddStockOptimized");
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
	}
	@Test
	@Order(3)
	public void testDeleteStock() {
		log.info("========> In Test 3 testDeleteStock");
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}

}
