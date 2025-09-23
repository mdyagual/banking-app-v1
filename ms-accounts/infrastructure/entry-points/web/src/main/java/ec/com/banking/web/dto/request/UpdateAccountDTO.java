package ec.com.banking.web.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountDTO {
    @NotNull(message = "Account ID is required")
    private Long accountId;

    @NotNull(message = "Online balance is required")
    @Positive(message = "Online balance must be positive")
    private BigDecimal onlineBalance;

    @NotNull(message = "Status is required")
    private Boolean status;
}
