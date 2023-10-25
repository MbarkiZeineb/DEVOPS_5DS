package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IStockService;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
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