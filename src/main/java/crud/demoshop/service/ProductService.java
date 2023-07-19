package crud.demoshop.service;

import crud.demoshop.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, Long id);

    void deleteProductById(Long id);
}
