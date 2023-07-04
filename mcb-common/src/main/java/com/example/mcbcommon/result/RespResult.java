package com.example.mcbcommon.result;

/**
 * @author chunbo.ma.o
 * @since 2023/6/2
 */
public class RespResult<T> {
    private static final String SUCCESS_CODE;
    private String resultCode;
    private String resultDesc;
    private T resultData;

    public boolean isSuccess() {
        return ResultCodeEnum.SUCCESS.getCode().equals(this.resultCode);
    }

    public RespResult() {
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
    }

    public RespResult(String resultCode, String resultDesc) {
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

    public RespResult(String resultCode, String resultDesc, T resultData) {
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        this.resultData = resultData;
    }

    public RespResult(ResultCode resultCode) {
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultCode = resultCode.getCode();
        this.resultDesc = resultCode.getMessage();
    }

    public RespResult(ResultCode resultCode, T resultData) {
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultCode = resultCode.getCode();
        this.resultDesc = resultCode.getMessage();
        this.resultData = resultData;
    }

    public static <T> RespResult<T> success(T data) {
        return new RespResult<>(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> RespResult<T> success() {
        return new RespResult<>(ResultCodeEnum.SUCCESS);
    }

    public static <T> RespResult<T> error() {
        return new RespResult<>(ResultCodeEnum.ERROR);
    }

    public static <T> RespResult<T> error(String resultDesc) {
        RespResult<T> result = new RespResult<>();
        result.setResultCode(ResultCodeEnum.ERROR.getCode());
        result.setResultDesc(resultDesc);
        return result;
    }

    public static <T> RespResult<T> errorParameter() {
        return new RespResult<>(ResultCodeEnum.PARAMETER_ERROR);
    }

    public static <T> RespResult<T> errorParameter(String resultDesc) {
        RespResult<T> result = new RespResult<>();
        result.setResultCode(ResultCodeEnum.PARAMETER_ERROR.getCode());
        result.setResultDesc(resultDesc);
        return result;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public T getResultData() {
        return this.resultData;
    }

    public RespResult<T> setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public RespResult<T> setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
        return this;
    }

    public RespResult<T> setResultData(T resultData) {
        this.resultData = resultData;
        return this;
    }


    protected boolean canEqual(Object other) {
        return other instanceof RespResult;
    }

    static {
        SUCCESS_CODE = ResultCodeEnum.SUCCESS.getCode();
    }
}
