package ec.com.banking.web;

import ec.com.banking.web.dto.response.StatementReportDTO;
import ec.com.banking.web.handler.StatementHandler;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/reports")
public class StatementController {
    private final StatementHandler statementHandler;

    public StatementController(StatementHandler statementHandler) {
        this.statementHandler = statementHandler;
    }

    @GetMapping
    public ResponseEntity<List<StatementReportDTO>> getStatementReports(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        List<StatementReportDTO> reports = statementHandler.findStatementReport(startDate, endDate);
        return ResponseEntity.ok(reports);
    }
}
