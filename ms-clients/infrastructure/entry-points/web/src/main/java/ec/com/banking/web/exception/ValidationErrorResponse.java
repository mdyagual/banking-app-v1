package ec.com.banking.web.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse {
    private int status;
    private Map<String, String> errors;
    private LocalDate timestamp;

    public ValidationErrorResponse(int status, Map<String, String> errors) {
        this.status = status;
        this.errors = errors;
        this.timestamp = LocalDate.now();
    }
}
