package tn.esprit.spring.services;

import java.util.Date;

public interface IProduitService {
     void assignProduitToStock(Long idProd,Long idStock);
     //float getRevenuBrutProd(Long idProd,Date startDate,Date endDate);
    
}
