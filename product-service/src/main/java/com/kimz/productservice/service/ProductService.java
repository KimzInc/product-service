package com.kimz.productservice.service;

import com.kimz.productservice.Dto.ProductRequest;
import com.kimz.productservice.Dto.ProductResponse;
import com.kimz.productservice.model.Product;
import com.kimz.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

private final ProductRepository repository;

    public void createProduct(ProductRequest productRequest) {
    Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

    repository.save(product);
    log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
       List<Product> products = repository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .Id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
