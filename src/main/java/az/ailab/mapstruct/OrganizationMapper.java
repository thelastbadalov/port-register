package az.ailab.mapstruct;

import az.ailab.dto.OrganizationRegisterRequestDto;
import az.ailab.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrganizationMapper {
    Organization mapToEntity(OrganizationRegisterRequestDto organizationRegisterRequestDto);
}
