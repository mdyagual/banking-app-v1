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
public class StatementReportDTO {
    private LocalDate transactionDate;
    private String clientName;
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private BigDecimal transactionAmount;
    private BigDecimal availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;
}
