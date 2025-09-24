package ec.com.banking.web.handler;

import ec.com.banking.model.StatementReport;
import ec.com.banking.usecase.transaction.GetStatementReportUseCase;
import ec.com.banking.web.dto.response.StatementReportDTO;
import ec.com.banking.web.mapper.IStatementReportMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class StatementHandler {
    private final GetStatementReportUseCase getStatementReportUseCase;
    private final IStatementReportMapper mapper;

    public StatementHandler(GetStatementReportUseCase getStatementReportUseCase, IStatementReportMapper mapper) {
        this.getStatementReportUseCase = getStatementReportUseCase;
        this.mapper = mapper;
    }

    public List<StatementReportDTO> findStatementReport(LocalDateTime startDate, LocalDateTime endDate){
        return getStatementReportUseCase.execute(startDate,endDate).stream()
                .map(mapper::toDTO)
                .toList();
    }
}
