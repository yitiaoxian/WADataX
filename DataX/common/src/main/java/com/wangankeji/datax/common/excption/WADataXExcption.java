package com.wangankeji.datax.common.excption;

import com.wangankeji.datax.common.util.WAErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * author xiao
 * 2018/3/5
 * 用于抛出网安的配置文件模块的异常
 */
public class WADataXExcption extends RuntimeException{

    private WAErrorCode waErrorCode;

    public WADataXExcption(WAErrorCode waErrorCode,String errorMessage){
        super(waErrorCode.toString()+" - "+errorMessage);
        this.waErrorCode = waErrorCode;
    }

    private WADataXExcption(WAErrorCode waErrorCode,String errorMessage,Throwable cause){
        super(waErrorCode.toString()+" - "+getMessage(errorMessage)+" - "+getMessage(cause),cause);

        this.waErrorCode = waErrorCode;
    }

    public static WADataXExcption WAErrorExcptionInfo(WAErrorCode waErrorCode,String message){
        return new WADataXExcption(waErrorCode,message);
    }

    public static WADataXExcption WAErrorExcptionInfo(WAErrorCode waErrorCode,String message,Throwable cause){
        if(cause instanceof WADataXExcption){
            return (WADataXExcption) cause;
        }
        return new WADataXExcption(waErrorCode,message,cause);
    }

    public static WADataXExcption WAErrorExcptionInfo(WAErrorCode waErrorCode,Throwable cause){
        if(cause instanceof WADataXExcption){
            return (WADataXExcption) cause;
        }
        return new WADataXExcption(waErrorCode,getMessage(cause),cause);
    }

    public WAErrorCode getWACode() {
        return this.waErrorCode;
    }
    private static String getMessage(Object obj) {
        if (obj == null) {
            return "";
        }

        if (obj instanceof Throwable) {
            StringWriter str = new StringWriter();
            PrintWriter pw = new PrintWriter(str);
            ((Throwable) obj).printStackTrace(pw);
            return str.toString();
            // return ((Throwable) obj).getMessage();
        } else {
            return obj.toString();
        }
    }
}
