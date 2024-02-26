package ma.boudra.accountservice;

import ma.boudra.accountservice.clients.CustomerRestClient;
import ma.boudra.accountservice.entities.Account;
import ma.boudra.accountservice.enums.AccountType;
import ma.boudra.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){

	return args ->{
		customerRestClient.allCustomers().forEach(c->{
			Account account = Account.builder()
					. accountId (UUID. randomUUID() . toString() )
					. createdAt(LocalDate.now())
						.balance(Math.random()*232334)
					.currency("MAD")
					. type (AccountType. CURRENT_ACCOUNT)
					. customerId(c.getId())
					. build();
			Account account1 = Account.builder()
					. accountId (UUID. randomUUID() . toString() )
					. createdAt(LocalDate.now())
					.balance(Math.random()*23223)
					.currency("MAD")
					. type (AccountType. SAVING_ACCOUNT)
					.customerId(c.getId())
					.build();

			accountRepository.save(account1);
			accountRepository.save(account);
		});
	};

	}



}
