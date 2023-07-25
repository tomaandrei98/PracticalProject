package crud.demoshop.controller;

import crud.demoshop.dto.OrderDto;
import crud.demoshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.saveOrder(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Order created successfully.")
                .body(savedOrder);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();

        return ResponseEntity.ok(orders);
    }

}
