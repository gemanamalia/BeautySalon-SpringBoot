package com.unibuc.beautysalon.mapper;
import com.unibuc.beautysalon.dto.SimpleProductDto;
import com.unibuc.beautysalon.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    // product -> dto
    public SimpleProductDto ProducrToSimpleProductDto(Product product) {
        return new SimpleProductDto(product.getId(), product.getName(), product.getPrice());
    }

}
