package ec.com.banking.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientDTO {
    private Long clientId;
    private String name;
    private String genre;
    private Integer age;
    private String idNumber;
    private String address;
    private String phone;
    private String password;
    private Boolean status;
}
