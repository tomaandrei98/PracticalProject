package crud.demoshop.service.impl;

import crud.demoshop.dto.CustomerDto;
import crud.demoshop.exception.CustomerNotFoundException;
import crud.demoshop.model.Customer;
import crud.demoshop.repository.CustomerRepository;
import crud.demoshop.service.CustomerService;
import crud.demoshop.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found with id " + id));
        return EntityDtoConverter.toDto(customer);
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = EntityDtoConverter.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return EntityDtoConverter.toDto(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found with id " + id));
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());

        Customer updatedCustomer = customerRepository.save(customer);
        return EntityDtoConverter.toDto(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found with id " + id));

        customerRepository.deleteById(id);
    }
}
