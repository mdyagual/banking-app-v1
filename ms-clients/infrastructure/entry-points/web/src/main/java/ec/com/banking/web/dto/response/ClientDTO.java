package ec.com.banking.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
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
