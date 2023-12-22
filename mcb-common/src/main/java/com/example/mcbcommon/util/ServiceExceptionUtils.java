package com.example.mcbcommon.util;

import com.example.mcbcommon.exception.ServiceException;
import com.example.mcbcommon.result.ResultCode;

/**
 * @author chunbo.ma.o
 * @since 2023/11/27
 */
public class ServiceExceptionUtils {

    public static void isTrue(boolean expression, String errorMsgTemplate) throws ServiceException {
        if (!expression) {
            throw new ServiceException(errorMsgTemplate);
        }
    }

    public static void isFalse(boolean expression, String errorMsgTemplate) throws ServiceException {
        if (expression) {
            throw new ServiceException(errorMsgTemplate);
        }
    }

    public static void isNull(Object object, String errorMsgTemplate) throws ServiceException {
        if (object != null) {
            throw new ServiceException(errorMsgTemplate);
        }
    }

    public static <T> T notNull(T object, String errorMsgTemplate) throws ServiceException {
        if (object == null) {
            throw new ServiceException(errorMsgTemplate);
        } else {
            return object;
        }
    }

    public static void create(String messageKey) throws ServiceException {
        throw new ServiceException(messageKey);
    }


    public static void create(String code, String message) throws ServiceException {
        throw new ServiceException(code, message);
    }

    public static void create(ResultCode resultCode) throws ServiceException {
        throw new ServiceException(resultCode);
    }
}
