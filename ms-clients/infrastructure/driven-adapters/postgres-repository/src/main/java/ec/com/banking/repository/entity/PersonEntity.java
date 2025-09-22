package ec.com.banking.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonEntity {
    protected String name;
    protected String genre;
    protected Integer age;
    protected String idNumber;
    protected String address;
    protected String phone;


}
