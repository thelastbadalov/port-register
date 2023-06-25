package az.ailab.constants;

import lombok.Getter;

@Getter
public enum AddressTypeEnum {

    BILL("Billing"),
    BUSN("Business"),
    HOME("Home"),
    LEGL("Legal"),
    MAIL("Mailing"),
    OTH("Other");
    private final String name;

    AddressTypeEnum(String name) {
        this.name = name;
    }
}
