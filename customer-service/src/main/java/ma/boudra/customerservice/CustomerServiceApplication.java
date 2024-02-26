package ma.boudra.customerservice;

import ma.boudra.customerservice.entities.Customer;
import ma.boudra.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandeLineRunner(CustomerRepository customerRepository){
		return args ->{

			List<Customer> customerList=List.of(
					Customer.builder()
							. firstName ("noura")
							.lastName("noura")
							.email("ndd@dfff.com")
							. build(),
					Customer. builder()
							. firstName ("boudzss")
							.lastName("noura")
							.email("ndd@dfffreff.com")
							.build()
			);
			customerRepository.saveAll(customerList);



		};


	}






}
