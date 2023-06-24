package az.ailab.controller;

import az.ailab.dto.GenericResponse;
import az.ailab.service.AddressTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/address/type")
public class AddressTypeController {

    private final AddressTypeService addressTypeService;


}
