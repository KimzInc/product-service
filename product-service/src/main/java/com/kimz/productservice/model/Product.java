package com.kimz.productservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;

@Document(value="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    private String Id;
    private String name;
    private String description;
    private BigDecimal price;
}
