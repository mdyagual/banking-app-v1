package ec.com.banking.web.mapper;

import ec.com.banking.model.StatementReport;
import ec.com.banking.web.dto.response.StatementReportDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "WebStatementMapperImpl")
public interface IStatementReportMapper {
    StatementReport toDomain(StatementReportDTO statementReportDTO);

    StatementReportDTO toDTO(StatementReport statementReport);
}
