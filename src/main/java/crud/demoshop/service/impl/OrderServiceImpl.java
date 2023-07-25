package crud.demoshop.service.impl;

import crud.demoshop.dto.OrderDto;
import crud.demoshop.exception.OrderNotFoundException;
import crud.demoshop.model.Order;
import crud.demoshop.model.Product;
import crud.demoshop.repository.OrderRepository;
import crud.demoshop.service.OrderService;
import crud.demoshop.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order not found with id " + id));
        return EntityDtoConverter.toDto(order);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
//        List<Product> products = orderDto.getProductsDto()
//                .stream()
//                .map(EntityDtoConverter::toEntity)
//                .toList();
        Order order = EntityDtoConverter.toEntity(orderDto);
//        order.setProducts(products);

        Order savedOrder = orderRepository.save(order);
        return EntityDtoConverter.toDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order not found with id " + id));
        order.setName(orderDto.getName());
        order.setOrderNo(orderDto.getOrderNo());
        order.setCreatedDate(LocalDate.now());
        order.setQuantity(orderDto.getQuantity());
        order.setStatus(orderDto.getStatus());

        Order updatedOrder = orderRepository.save(order);

        return EntityDtoConverter.toDto(updatedOrder);
    }

    @Override
    public void deleteCustomerById(Long id) {
        orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order not found with id " + id));

        orderRepository.deleteById(id);
    }
}
