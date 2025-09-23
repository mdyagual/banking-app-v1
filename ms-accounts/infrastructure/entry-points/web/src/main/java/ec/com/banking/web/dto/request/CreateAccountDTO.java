package ec.com.banking.web.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDTO {
    @NotNull(message = "Account number is required")
    @Size(max = 10, message = "ID Number must 10 characters long")
    private String accountNumber;

    @Pattern(regexp = "AS|AC", message = "Account type must be 'Savings' (AS) or 'Checking' (AC)")
    @NotBlank(message = "Account type is required")
    private String accountType;

    @NotNull(message = "Online balance is required")
    @Positive(message = "Online balance must be positive")
    @Min(value = 20, message = "Online balance must be at least 20")
    private BigDecimal onlineBalance;

    @NotNull(message = "Client ID is required")
    private Long clientId;
}
