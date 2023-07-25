package crud.demoshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private List<OrderDto> ordersDto;

    public ProductDto(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

//    public List<OrderDto> getOrdersDto() {
//        if (ordersDto == null) {
//            ordersDto = new ArrayList<>();
//        }
//
//        return ordersDto;
//    }
}
