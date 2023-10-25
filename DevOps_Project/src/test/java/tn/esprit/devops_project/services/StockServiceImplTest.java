package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import org.junit.runner.RunWith;


import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StockServiceImplTest {
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;

  // Stock stock= new Stock((long) 1,"stock num1");
   /*
   List<Stock> stockList = new ArrayList<Stock>();
    {
        stockList.add(new Stock(1,"stock num1"));
        stockList.add(new Stock(2,"stock num3"));
    };
    */



    // sh yefhem eli mafamesh lisaison avec la base
/*
    @Test
    void addStock() {

}
*/
    @Test
    @Order(1)
    void retrieveStock(){
        Stock stock= new Stock((long) 1,"stock num1");
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1= stockService.retrieveStock(stock.getIdStock());
        Assertions.assertNotNull(stock1);
}
/*
    @Test
    void retrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0,stocks.size());
    }
    */

}