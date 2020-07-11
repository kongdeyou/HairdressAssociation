package cn.cuit.HairdressAssociation.model;

public enum  ErrorCode {

    FAILED("-1","failed"),
    EMPTY("0","empty"),
    SUCCESS("1","success"),
    USELESS("2","useless");


    private String code;
    private String desc;


    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
