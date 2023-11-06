package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.StockRepository;
import org.junit.runner.RunWith;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StockServiceImplTest {
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void testRetrieveStock(){
        Stock stock= new Stock(1L,"stock num1");
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1= stockService.retrieveStock(stock.getIdStock());
        Assertions.assertNotNull(stock1);
    }
    @Test
    @Order(1)
    void testRetrieveAllStock() {
        Stock stock = new Stock(1L, "title1");

        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        stockList.add(new Stock(2L, "title2"));
        when(stockRepository.findAll()).thenReturn(stockList);

        List<Stock> result = stockService.retrieveAllStock();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("title1", result.get(0).getTitle());
        Assertions.assertEquals("title2", result.get(1).getTitle());
       }
//Junit
    @Test
    void testAddStock() {
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);
        Stock result = stockService.addStock(stock);
        Assertions.assertEquals(stock, result);
        verify(stockRepository, times(1)).save(stock);
    }
    /*
    @Test
    void testDeleteStock() {
        doNothing().when(stockRepository).deleteById((Long) any());
        stockService.deleteStock(1L);
        verify(stockRepository).deleteById((Long) any());
    }
    */

    //Junit
    @Test
    void testDeleteStock() {
        Long stockId = 1L;

        stockService.deleteStock(stockId);

        verify(stockRepository, times(1)).deleteById(stockId);
    }
    @Test
    void testUpdateStock() {
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock result = stockService.updateStock(stock);

        Assertions.assertEquals(stock, result);
        verify(stockRepository, times(1)).save(stock);
    }

/*
    @Test
    void retrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0,stocks.size());
    }
    */
}