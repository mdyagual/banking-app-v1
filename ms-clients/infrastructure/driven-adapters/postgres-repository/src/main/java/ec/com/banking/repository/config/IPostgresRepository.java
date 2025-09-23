package ec.com.banking.repository.config;

import ec.com.banking.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostgresRepository extends JpaRepository<ClientEntity, Long> {
    boolean existsByIdNumber(String idNumber);
}
