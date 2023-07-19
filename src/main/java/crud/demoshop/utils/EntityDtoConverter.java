package crud.demoshop.utils;

import crud.demoshop.dto.CustomerDto;
import crud.demoshop.dto.OrderDto;
import crud.demoshop.dto.ProductDto;
import crud.demoshop.model.Customer;
import crud.demoshop.model.Order;
import crud.demoshop.model.Product;
import org.modelmapper.ModelMapper;

public class EntityDtoConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Customer toEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    public static CustomerDto toDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    public static Order toEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }

    public static OrderDto toDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }

    public static Product toEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    public static ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
