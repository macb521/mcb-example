package com.example.mcbcommon.result;

/**
 * @author chunbo.ma.o
 * @since 2023/6/2
 */
public enum ResultCodeEnum implements ResultCode{

    SUCCESS("WL-0000", "Success"),
    LOGIN_FAIL("WL-0001", "login fail"),
    NOT_LOGIN("WL-0002", "need login"),
    PARAMETER_ERROR("WL-0003", "Illegal arguments"),
    ERROR("WL-0004", "System Exception"),
    NO_MATCHING_RESULTS("WL-0005", "No matching results"),
    DUPLICATE_KEY("WL-0006", "Duplicate key"),
    UPDATE_FAILED("WL-0007", "Update failed"),
    PERMISSION_DENY("WL-0008", "have no permission"),
    SIGN_FAIL("WL-0009", "sign fail"),
    NO_USER_IN_SYSTEM("WL-0010", "user not exist in system"),
    LOGIN_CLOSED("WL-0011", "this method to login is closed"),
    NO_USER_INFO("WL-0012", "can not get user info by sso"),
    ORDER_NO_HAS_EXIST("WL-0013", "orderNo has exist"),
    SESSION_EXPIRED("WL-0014", "session expired"),
    NO_ACCESS_LOGIN("WL-0015", "no access to login"),
    DATA_PERMISSION_DENY("WL-1000", "have no data access permission"),
    THIRD_PARTY_ERROR("WL-2000", "third party api call fail");

    private final String code;
    private final String message;

    private ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }
    @Override

    public String getMessage() {
        return this.message;
    }

}
