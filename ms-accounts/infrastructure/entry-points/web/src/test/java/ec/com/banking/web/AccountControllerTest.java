package ec.com.banking.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.banking.web.dto.request.CreateAccountDTO;
import ec.com.banking.web.dto.response.AccountDTO;
import ec.com.banking.web.handler.AccountHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AccountHandler accountHandler;

    @InjectMocks
    private AccountController accountController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldReturnAllAccounts() throws Exception {
        AccountDTO acc1 = new AccountDTO(1L, "123", "SAVINGS", new BigDecimal(100.0), true, 10L, new ArrayList<>());
        AccountDTO acc2 = new AccountDTO(2L, "456", "CHECKING", new BigDecimal(200.0), true, 20L, new ArrayList<>());

        Mockito.when(accountHandler.findAll()).thenReturn(List.of(acc1, acc2));

        mockMvc.perform(get("/v1/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].accountNumber").value("123"))
                .andExpect(jsonPath("$[1].accountNumber").value("456"));

        Mockito.verify(accountHandler, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnAccountById() throws Exception {
        AccountDTO acc = new AccountDTO(1L, "123", "SAVINGS", new BigDecimal(100.0), true, 10L, new ArrayList<>());
        Mockito.when(accountHandler.findById(1L)).thenReturn(acc);

        mockMvc.perform(get("/v1/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("123"));

        Mockito.verify(accountHandler, Mockito.times(1)).findById(1L);
    }

    @Test
    void shouldSaveAccount() throws Exception {
        CreateAccountDTO createDto = new CreateAccountDTO("9999", "AS", new BigDecimal(500.0), 30L);
        AccountDTO savedDto = new AccountDTO(1L, "9999", "AS", new BigDecimal(500.0), true, 30L, new ArrayList<>());

        Mockito.when(accountHandler.save(Mockito.any(CreateAccountDTO.class))).thenReturn(savedDto);

        mockMvc.perform(post("/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("9999"));

        Mockito.verify(accountHandler, Mockito.times(1)).save(Mockito.any(CreateAccountDTO.class));
    }
}
