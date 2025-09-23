package ec.com.banking.repository.config;

import ec.com.banking.repository.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
