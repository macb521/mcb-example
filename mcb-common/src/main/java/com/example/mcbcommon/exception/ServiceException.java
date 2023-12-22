package com.example.mcbcommon.exception;

import com.example.mcbcommon.result.ResultCode;
import com.example.mcbcommon.result.ResultCodeEnum;

/**
 * @author chunbo.ma.o
 * @since 2023/11/27
 */
public  class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String code;

    public ServiceException() {
        super(ResultCodeEnum.ERROR.getMessage());
        this.code = ResultCodeEnum.ERROR.getCode();
    }

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public ServiceException(ResultCode resultCode, String appendMessage) {
        super(resultCode.getMessage() + "," + appendMessage);
        this.code = resultCode.getCode();
    }

    public ServiceException(ResultCode resultCode, Throwable e) {
        super(resultCode.getMessage() + "," + e.getMessage(), e);
        this.code = resultCode.getCode();
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message) {
        super(message);
        this.code = ResultCodeEnum.ERROR.getCode();
    }

    public ServiceException(String message, Throwable e) {
        super(message, e);
        this.code = ResultCodeEnum.ERROR.getCode();
    }

    public ServiceException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ServiceException error(String message) {
        return new ServiceException(ResultCodeEnum.ERROR, message);
    }

    public static ServiceException errorParameter(String message) {
        return new ServiceException(ResultCodeEnum.PARAMETER_ERROR, message);
    }
}
