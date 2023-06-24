package az.ailab.mapstruct;

import az.ailab.dto.GeneralUserRegistrationRequestDto;
import az.ailab.model.GeneralUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GeneralUserMapper {

    GeneralUserRegistrationRequestDto mapToDto(GeneralUser generalUser);
    GeneralUser mapToEntity(GeneralUserRegistrationRequestDto generalUserRegistrationRequestDto);
}
