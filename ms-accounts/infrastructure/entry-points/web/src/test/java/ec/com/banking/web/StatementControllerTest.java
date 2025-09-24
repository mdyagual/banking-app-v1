package ec.com.banking.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.banking.web.dto.response.StatementReportDTO;
import ec.com.banking.web.handler.StatementHandler;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StatementControllerTest {
    private MockMvc mockMvc;

    @Mock
    private StatementHandler statementHandler;

    @InjectMocks
    private StatementController statementController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(statementController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldReturnStatementReports() throws Exception {
        LocalDate startDate = LocalDate.of(2025, 9, 1);
        LocalDate endDate = LocalDate.of(2025, 9, 20);

        StatementReportDTO report1 = new StatementReportDTO(LocalDate.now().minusDays(2), "Mishell Yagual", "24563", "AS", new BigDecimal(1000), new BigDecimal(500), new BigDecimal(500),"DEBIT",true);
        StatementReportDTO report2 = new StatementReportDTO(LocalDate.now().minusDays(5), "Erick Burgos", "24663", "AC", new BigDecimal(2000), new BigDecimal(1000), new BigDecimal(3000),"CREDIT",true);

        Mockito.when(statementHandler.findStatementReport(startDate, endDate))
                .thenReturn(List.of(report1, report2));

        mockMvc.perform(get("/v1/reports")
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].clientName").value("Mishell Yagual"))
                .andExpect(jsonPath("$[1].clientName").value("Erick Burgos"));

        Mockito.verify(statementHandler, Mockito.times(1))
                .findStatementReport(startDate, endDate);
    }
}
