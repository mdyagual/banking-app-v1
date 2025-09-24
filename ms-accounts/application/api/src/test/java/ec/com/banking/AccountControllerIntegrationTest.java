package ec.com.banking;


import ec.com.banking.web.AccountController;
import ec.com.banking.web.dto.response.AccountDTO;
import ec.com.banking.web.handler.AccountHandler;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AccountController.class)
@Import(AccountControllerIntegrationTest.TestConfig.class)
public class AccountControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountHandler accountHandler;


    @Test
    void shouldReturnAllAccounts() throws Exception {
        AccountDTO acc1 = new AccountDTO(1L, "123", "SAVINGS", new BigDecimal(100), true, 10L, new ArrayList<>());
        AccountDTO acc2 = new AccountDTO(2L, "456", "SAVINGS", new BigDecimal(300), true, 20L, new ArrayList<>());

        Mockito.when(accountHandler.findAll()).thenReturn(List.of(acc1, acc2));

        mockMvc.perform(get("/v1/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].accountId").value(1L))
                .andExpect(jsonPath("$[0].accountNumber").value("123"))
                .andExpect(jsonPath("$[1].accountId").value(2L));
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public AccountHandler accountHandler() {
            return Mockito.mock(AccountHandler.class);
        }
    }




}
