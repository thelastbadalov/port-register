package az.ailab.mapstruct;

import az.ailab.dto.OrganizationRegisterRequestDto;
import az.ailab.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrganizationMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "active", expression = "java(true)")
    Organization mapToEntity(OrganizationRegisterRequestDto organizationRegisterRequestDto);
}
