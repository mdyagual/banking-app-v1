package ec.com.banking.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.banking.web.dto.request.CreateTransactionDTO;
import ec.com.banking.web.dto.response.TransactionDTO;
import ec.com.banking.web.handler.TransactionHandler;
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
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TransactionHandler transactionHandler;

    @InjectMocks
    private TransactionController transactionController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldReturnAllTransactions() throws Exception {
        TransactionDTO t1 = new TransactionDTO(1L, LocalDate.now().minusDays(3), "D", new BigDecimal(500), new BigDecimal(1000), new BigDecimal(500),2L);
        TransactionDTO t2 = new TransactionDTO(2L, LocalDate.now().minusDays(5), "C", new BigDecimal(500), new BigDecimal(1000), new BigDecimal(1500),2L);

        Mockito.when(transactionHandler.findAll()).thenReturn(List.of(t1, t2));

        mockMvc.perform(get("/v1/transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].transactionId").value(1L))
                .andExpect(jsonPath("$[1].transactionId").value(2L));
    }

    @Test
    void shouldReturnTransactionById() throws Exception {
        TransactionDTO t = new TransactionDTO(1L, LocalDate.now().minusDays(3), "D", new BigDecimal(500), new BigDecimal(1000), new BigDecimal(500),2L);

        Mockito.when(transactionHandler.findById(1L)).thenReturn(t);

        mockMvc.perform(get("/v1/transactions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(1L))
                .andExpect(jsonPath("$.amount").value(500));
    }

    @Test
    void shouldSaveTransaction() throws Exception {
        CreateTransactionDTO createDto = new CreateTransactionDTO(2L, "C",  new BigDecimal(500));
        TransactionDTO savedDto = new TransactionDTO(1L, LocalDate.now().minusDays(3), "C", new BigDecimal(500), new BigDecimal(1000), new BigDecimal(1500),2L);

        Mockito.when(transactionHandler.save(Mockito.any(CreateTransactionDTO.class))).thenReturn(savedDto);

        mockMvc.perform(post("/v1/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(1L))
                .andExpect(jsonPath("$.amount").value(500));

        Mockito.verify(transactionHandler, Mockito.times(1)).save(Mockito.any(CreateTransactionDTO.class));
    }
}
