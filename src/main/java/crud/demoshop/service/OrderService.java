package crud.demoshop.service;

import crud.demoshop.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long id);

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto updateOrder(OrderDto orderDto, Long id);

    void deleteCustomerById(Long id);
}
