package tn.esprit.devops_project.services;

<<<<<<< Updated upstream
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
=======
import org.junit.Test;
import org.junit.jupiter.api.*;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
    }

@Test
void deleteStock() {
    doNothing().when(stockRepository).deleteById((Long) any());
    stockService.deleteStock(1L);
    verify(stockRepository).deleteById((Long) any());
>>>>>>> Stashed changes
}
/*
    @Test
    void retrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0,stocks.size());
    }
    */
<<<<<<< Updated upstream

=======
    /*
    @Test
    public void addStock() {
        Stock stock = new Stock(2L, "Stock à ajouter");
        Stock savedStock = stockService.addStock(stock);
        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        Assertions.assertNotNull(savedStock.getTitle());
        stockService.deleteStock(savedStock.getIdStock());
    }
*/
>>>>>>> Stashed changes
}