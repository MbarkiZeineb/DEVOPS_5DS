package tn.esprit.devops_project.test;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.services.ProductServiceImpl;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Mock
    ProductRepository productRepository;
    
    /*
    @Test
    void addProduct() {
        
        Product productToAdd = new Product(3L, "New Product", 30L, 15, ProductCategory.ELECTRONICS);
        Product expectedProduct = new Product(3L, "New Product", 30L, 15, ProductCategory.ELECTRONICS);
        when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);
        Product addedProduct = productServiceImpl.addProduct(productToAdd, 1);
        assertEquals(expectedProduct, addedProduct); // Check
         
    }
    */

    @Test
    void retrieveProduct() {
        Long productIdToRetrieve = 1L;
        Product expectedProduct = new Product(productIdToRetrieve, "Retrieved Product", 30L, 15, ProductCategory.ELECTRONICS);
        when(productRepository.findById(productIdToRetrieve)).thenReturn(Optional.of(expectedProduct));
        Product retrievedProduct = productServiceImpl.retrieveProduct(productIdToRetrieve);
        Assertions.assertEquals(expectedProduct, retrievedProduct);
    }

    @Test
    void retreiveAllProduct() {
        Product product = new Product(1L, "produit1", 20L, 10, ProductCategory.ELECTRONICS);
        when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(new Product(2L, "produit2", 50L, 20, ProductCategory.BOOKS));
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productServiceImpl.retreiveAllProduct();

        // Assertions
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("produit1", result.get(0).getTitle());
        Assertions.assertEquals("produit2", result.get(1).getTitle());
    }

    @Test
    void retrieveProductByCategory() {
        ProductCategory categoryToRetrieve = ProductCategory.ELECTRONICS;
        List<Product> productsInCategory = new ArrayList<>();
        productsInCategory.add(new Product(1L, "Product1", 30L, 10, ProductCategory.ELECTRONICS));
        productsInCategory.add(new Product(2L, "Product2", 50L, 20, ProductCategory.ELECTRONICS));
        when(productRepository.findByCategory(eq(categoryToRetrieve))).thenReturn(productsInCategory);
        List<Product> retrievedProducts = productServiceImpl.retrieveProductByCategory(categoryToRetrieve);

        Assertions.assertEquals(2, retrievedProducts.size());

        retrievedProducts.forEach(product -> Assertions.assertEquals(categoryToRetrieve, product.getCategory()));
    }

    @Test
    void deleteProduct() {
        doNothing().when(productRepository).deleteById((Long) any());
        productServiceImpl.deleteProduct(2L);
        verify(productRepository).deleteById((Long) any());
    }
/*
    @Test
    void retreiveProductStock() {
    }

 */
}