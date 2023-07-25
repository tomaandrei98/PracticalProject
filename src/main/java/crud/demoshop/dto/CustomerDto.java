package crud.demoshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private List<OrderDto> ordersDto;

    public CustomerDto(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
