package ec.com.banking.web.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public CustomErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
