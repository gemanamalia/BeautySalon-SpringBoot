package com.unibuc.beautysalon.controller;

import com.unibuc.beautysalon.dto.SimpleProductDto;
import com.unibuc.beautysalon.entity.Product;
import com.unibuc.beautysalon.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
@Api(value = "/products", tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value="Create a product",
            notes="Creates a products based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The product was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<Product> addSimpleProduct(@RequestBody SimpleProductDto simpleProductDto) {
        Product product = new Product();
        product.setId(simpleProductDto.getId());
        product.setName(simpleProductDto.getName());
        product.setPrice(simpleProductDto.getPrice());

        Product savedProduct = productService.saveProduct(product);
//        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        return ResponseEntity
                .created(URI.create("/products/"+savedProduct.getId()))
                .body(savedProduct);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
        List<Product> products = productService.getProductsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{productId}/name")
    public ResponseEntity<Product> updateProductName(@PathVariable Long productId, @RequestBody String newName) {
        Product updatedProduct = productService.updateProductName(productId, newName);
        return ResponseEntity.ok(updatedProduct);
    }
}
