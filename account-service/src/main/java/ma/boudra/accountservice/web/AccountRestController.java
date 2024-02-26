package ma.boudra.accountservice.web;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.boudra.accountservice.clients.CustomerRestClient;
import ma.boudra.accountservice.entities.Account;
import ma.boudra.accountservice.model.Customer;
import ma.boudra.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("")
public class AccountRestController {

    private AccountRepository accountRepository;

    private CustomerRestClient customerRestClient;


    @GetMapping("/accounts")
    public List<Account> accountList(){

        List<Account> accountList= accountRepository.findAll();
        accountList.forEach(account -> account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId())));

        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public  Account accountById(@PathVariable String id) {
      Account account= accountRepository.findById(id).get();
      Customer customer= customerRestClient.findCustomerById(account.getCustomerId());
      account.setCustomer(customer);
        return account;
    }






}
