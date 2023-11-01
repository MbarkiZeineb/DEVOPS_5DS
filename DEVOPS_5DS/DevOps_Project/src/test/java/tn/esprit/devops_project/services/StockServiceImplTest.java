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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StockServiceImplTest {
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;

    @Test
    @Order(1)
    void retrieveAllStock(){
        Stock stock= new Stock(1L,"stock num1");
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1= stockService.retrieveStock(stock.getIdStock());
        Assertions.assertNotNull(stock1);
    }
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
@Test
void deleteStock() {
    doNothing().when(stockRepository).deleteById((Long) any());
    stockService.deleteStock(1L);
    verify(stockRepository).deleteById((Long) any());
}


/*
    @Test
    void retrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0,stocks.size());
    }
    */
}