package ec.com.banking.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private BigDecimal onlineBalance;
    private Boolean status;
    private Long clientId;
    private List<Long> transactions;
}
