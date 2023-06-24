package az.ailab.mapstruct;

import az.ailab.dto.OrganizationAddressRegisterRequestDto;
import az.ailab.model.OrganizationAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrganizationAddressMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "active", expression = "java(true)")
    OrganizationAddress mapToEntity(OrganizationAddressRegisterRequestDto requestDto);

}
