package ma.boudra.accountservice.entities;



import jakarta.persistence.*;
import lombok.*;
import ma.boudra.accountservice.enums.AccountType;
import ma.boudra.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @Builder @NoArgsConstructor

public class Account {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;


    private Long customerId;

}
