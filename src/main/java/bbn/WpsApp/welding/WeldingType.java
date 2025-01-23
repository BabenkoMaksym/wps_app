package bbn.WpsApp.welding;

import lombok.Getter;

@Getter
public enum WeldingType {
    BW("BW"),

    FW("FW"),

    SS("ss"),

    BS("bs"),

    MB("mb"),

    NB("nb"),

    QQ("qq"),

    NQ("nq"),

    WM("wm"),

    NM("nm");


    private final String signature;

    WeldingType(String signature) {
        this.signature = signature;
    }
}
