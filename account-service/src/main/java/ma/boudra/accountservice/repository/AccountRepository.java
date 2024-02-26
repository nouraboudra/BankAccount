package ma.boudra.accountservice.repository;

import ma.boudra.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
