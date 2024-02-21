package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.entity.Product;
import com.unibuc.beautysalon.repository.ProductRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;
    @BeforeEach
    public void setUp() {
        testProduct = new Product();
        testProduct.setId(1L);
        testProduct.setName("Test Product");
        testProduct.setPrice(123);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = Arrays.asList(new Product("Product 1", 50), new Product("Product 2", 100));
        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
    }

    @Test
    void testGetProductsByName() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", 10));
        when(productRepository.findByName("Product 1")).thenReturn(productList);

        List<Product> result = productService.getProductsByName("Product 1");

        assertEquals(1, result.size());
    }

    @Test
    void testSaveProduct() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);

        Product productToSave = new Product(null, "New Product", 30.0);
        Product savedProduct = new Product(1L, "New Product", 30.0);
        when(productRepository.save(productToSave)).thenReturn(savedProduct);

        Product result = productService.saveProduct(productToSave);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Product", result.getName());
        assertEquals(30.0, result.getPrice());
    }

    @Test
    void testDeleteProduct() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}

