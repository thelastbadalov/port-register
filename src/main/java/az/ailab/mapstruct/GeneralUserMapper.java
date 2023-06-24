package az.ailab.mapstruct;

import az.ailab.dto.GeneralUserRegistrationRequestDto;
import az.ailab.model.GeneralUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GeneralUserMapper {
    GeneralUserRegistrationRequestDto mapToDto(GeneralUser generalUser);
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "active", expression = "java(true)")
    GeneralUser mapToEntity(GeneralUserRegistrationRequestDto generalUserRegistrationRequestDto);
}
