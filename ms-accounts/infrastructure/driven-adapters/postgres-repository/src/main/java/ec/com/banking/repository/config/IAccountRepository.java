package ec.com.banking.repository.config;

import ec.com.banking.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {
}
