package ec.com.banking.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementReportDTO {
    private LocalDateTime transactionDate;
    private String clientName;
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private BigDecimal transactionAmount;
    private BigDecimal availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;
}
