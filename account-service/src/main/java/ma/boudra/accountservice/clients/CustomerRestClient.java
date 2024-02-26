package ma.boudra.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.boudra.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {



    @GetMapping("/customers/{id}")

   @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable  Long id);

    @GetMapping("/customers")
   @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultAllCustomer")
    List<Customer> allCustomers();


    default Customer getDefaultCustomer(Long id , Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("not available");
        customer.setLastName("not available");
        customer.setEmail("not available");
        return customer;

    }

    default List<Customer> getDefaultAllCustomer(Exception exception){
       return List.of();
    }

}
