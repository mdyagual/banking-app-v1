package ec.com.banking.web;

import ec.com.banking.web.dto.request.CreateAccountDTO;
import ec.com.banking.web.dto.response.AccountDTO;
import ec.com.banking.web.handler.AccountHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Mock
    private AccountHandler accountHandler;

    @InjectMocks
    private AccountController accountController;

    @Test
    void shouldReturnAllAccounts() {
        AccountDTO acc1 = new AccountDTO(1L, "123", "SAVINGS", new BigDecimal(100.0), true, 10L, new ArrayList<>() );
        AccountDTO acc2 = new AccountDTO(2L, "456", "CHECKING", new BigDecimal(200.0), true, 20L, new ArrayList<>());

        Mockito.when(accountHandler.findAll()).thenReturn(List.of(acc1, acc2));

        ResponseEntity<List<AccountDTO>> response = accountController.findAll();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("123", response.getBody().get(0).getAccountNumber());

        Mockito.verify(accountHandler).findAll();
    }

    @Test
    void shouldReturnAccountById() {
        AccountDTO acc = new AccountDTO(1L, "123", "SAVINGS", new BigDecimal(100.0), true, 10L, new ArrayList<>() );
        Mockito.when(accountHandler.findById(1L)).thenReturn(acc);

        ResponseEntity<AccountDTO> response = accountController.findById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("123", response.getBody().getAccountNumber());
        Mockito.verify(accountHandler).findById(1L);
    }

    @Test
    void shouldSaveAccount() {
        CreateAccountDTO createDto = new CreateAccountDTO("999", "SAVINGS", new BigDecimal(500.0), 30L);
        AccountDTO savedDto = new AccountDTO(1L, "999", "SAVINGS", new BigDecimal(500.0), true, 30L, new ArrayList<>());

        Mockito.when(accountHandler.save(createDto)).thenReturn(savedDto);

        ResponseEntity<AccountDTO> response = accountController.save(createDto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("999", response.getBody().getAccountNumber());
        Mockito.verify(accountHandler).save(createDto);
    }
}
