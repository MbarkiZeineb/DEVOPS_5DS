package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.services.Iservices.IStockService;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StockServiceImpl implements IStockService {
    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new NullPointerException("Stock not found"));
    }

    @Override
    public List<Stock> retrieveAllStock() {

        return stockRepository.findAll();
    }
    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return  stockRepository.save(stock);
    }

}