package crud.demoshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public OrderDto(String name, int orderNo, int quantity, String status, LocalDate createdDate, CustomerDto customerDto) {
        this.name = name;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.status = status;
        this.createdDate = createdDate;
        this.customerDto = customerDto;
    }

//    public List<ProductDto> getProductsDto() {
//        if (productsDto == null) {
//            productsDto = new ArrayList<>();
//        }
//
//        return productsDto;
//    }
}
