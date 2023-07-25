package crud.demoshop.service.impl;

import crud.demoshop.dto.ProductDto;
import crud.demoshop.exception.ProductNotFoundException;
import crud.demoshop.model.Order;
import crud.demoshop.model.Product;
import crud.demoshop.repository.ProductRepository;
import crud.demoshop.service.OrderService;
import crud.demoshop.service.ProductService;
import crud.demoshop.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id " + id));
        return EntityDtoConverter.toDto(product);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
//        List<Order> orders = productDto.getOrdersDto()
//                .stream()
//                .map(EntityDtoConverter::toEntity)
//                .toList();
        Product product = EntityDtoConverter.toEntity(productDto);
//        product.setOrders(orders);

        Product savedProduct = productRepository.save(product);
        return EntityDtoConverter.toDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id " + id));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());

        Product updatedProduct = productRepository.save(product);

        return EntityDtoConverter.toDto(updatedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id " + id));

        productRepository.deleteById(id);
    }
}
