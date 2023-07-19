package crud.demoshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String name;
    private int orderNo;
    private int quantity;
    private String status;
    private LocalDate createdDate;
    private CustomerDto customerDto;
    private List<ProductDto> productsDto;

    public OrderDto(Long id, String name, int orderNo, int quantity, String status, LocalDate createdDate, CustomerDto customerDto) {
        this.id = id;
        this.name = name;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.status = status;
        this.createdDate = createdDate;
        this.customerDto = customerDto;
    }
}
