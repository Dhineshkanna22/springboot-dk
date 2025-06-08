package net.javaguides.springboot_app.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot_app.Model.Product;
import net.javaguides.springboot_app.Service.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductControl {
    @Autowired
    private ProductService service;

    @GetMapping("/products/default")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content (no products found)
        }
        return new ResponseEntity<>(products, HttpStatus.OK); // 200 OK (products found)
    }


    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product product = service.getProductById(prodId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK); // Product found
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Product not found
        }
    }
    
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product prod = service.addProduct(product, imageFile);
            return new ResponseEntity<>(prod, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {
    Product updated = service.updateProduct(id, product, imageFile);
    if (updated != null) {
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
    return new ResponseEntity<>("Not Updated", HttpStatus.BAD_REQUEST);
}


    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product prod = service.getProductById(id);
        if(prod != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Deleted", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/search/")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> prod = service.searchProduct(keyword);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }
}
