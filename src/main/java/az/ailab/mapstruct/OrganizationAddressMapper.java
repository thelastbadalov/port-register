package az.ailab.mapstruct;

import az.ailab.dto.OrganizationAddressRegisterRequestDto;
import az.ailab.model.OrganizationAddress;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrganizationAddressMapper {

    OrganizationAddress mapToEntity(OrganizationAddressRegisterRequestDto requestDto);

}
