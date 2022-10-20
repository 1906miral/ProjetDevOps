package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.StockRepository;

@Service
public class StockService implements IStockService{
    @Autowired
    StockRepository stockRepository;
	@Override
	@Scheduled(cron="0 22 * * * *")
	public String retrieveStatusStock() {
		List<Stock> liststock=(List<Stock>) stockRepository.findAll();
		String ch = null;
		for(Stock s:liststock){
			if(s.getQte()<s.getQteMin()){
			 ch="La quantité disponnible est inférieure à la quantité minimale";
			 System.out.println(ch);
			}
		}
		System.out.println(ch);
		return ch;
	}

	

}
