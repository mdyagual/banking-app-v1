package ec.com.banking.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long transactionId;
    private LocalDate transactionDate;
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal initialBalance;
    private BigDecimal availableBalance;
    private Long accountId;
}
