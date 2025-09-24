package ec.com.banking.repository.mapper;

import ec.com.banking.model.StatementReport;
import ec.com.banking.repository.dto.StatementReportDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "RepositoryStatementMapperImpl")
public interface IStatementReportMapper {
    StatementReport toDomain(StatementReportDTO statementReportDTO);

    StatementReportDTO toDTO(StatementReport statementReport);
}
