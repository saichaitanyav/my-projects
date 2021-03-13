package com.myretail.project.productservice;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.pentalog.pentabar.movieservice.feign.ReviewsFeignClient;
import ro.pentalog.pentabar.movieservice.model.MovieDTO;
import ro.pentalog.pentabar.movieservice.model.MovieReview;
import ro.pentalog.pentabar.movieservice.repository.Movie;
import ro.pentalog.pentabar.movieservice.repository.MovieRepository;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final PriceFeignClient priceFeignClient;

    public ProductController(ProductRepository productRepository, PriceFeignClient priceFeignClient) {
        this.productRepository = productRepository;
        this.priceFeignClient = priceFeignClient;
    }

    @GetMapping("/{productID}")
    public ResponseEntity<productDTO> getProduct(@PathVariable("productID") Long movieId) {
        Product product = productRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        CollectionModel<ProductPrice> productPrice = reviewsFeignClient.getProductPrice(productId);
        return ResponseEntity.ok(new productDTO(product, productPrice.getContent()));
    }
}
