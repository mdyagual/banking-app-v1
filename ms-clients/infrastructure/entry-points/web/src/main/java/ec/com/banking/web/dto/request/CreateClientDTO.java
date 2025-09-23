package ec.com.banking.web.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientDTO {
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]{2,20}$", message = "Name must only contain letters and spaces")
    @NotBlank(message = "Name must not be empty")
    private String name;

    @Pattern(regexp = "M|F", message = "Genre must be M or F")
    @NotBlank(message = "Genre must not be empty")
    private String genre;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private Integer age;

    @NotBlank(message = "ID Number must not be empty")
    @Size(max = 10, message = "ID Number must 10 characters long")
    @Pattern(regexp = "^[0-9]+$", message = "ID Number must only contain numbers")
    private String idNumber;

    @NotBlank(message = "Address must not be empty")
    private String address;

    @NotBlank(message = "Phone must not be empty")
    @Pattern(regexp = "^[0-9]+$", message = "Phone must only contain numbers")
    @Size(max = 10, message = "Phone must be 10 characters long")
    private String phone;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;

}
