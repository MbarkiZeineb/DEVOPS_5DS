package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.IStockService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class StockController {

    IStockService stockService;

    @ResponseBody
    @PostMapping("/add-stock")
    Stock addStock(@RequestBody Stock stock)
    {
        return stockService.addStock(stock);
    }

    @GetMapping("/stock/{id}")
    Stock retrieveStock(@PathVariable Long id)
    {
        return stockService.retrieveStock(id);
    }

    @ResponseBody
    @GetMapping("/retrieve-all-stock")
    List<Stock> retrieveAllStock()
    {
        return stockService.retrieveAllStock();
    }

    @PutMapping("/stock")
    public Stock modifyStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }

}