package com.wangankeji.datax.common.excption;

import com.wangankeji.datax.common.util.WAErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * author xiao
 * 2018/3/5
 * 用于抛出自定义的配置文件模块的异常
 */
public class WADataXExcption extends RuntimeException{

    /**
     * 使用自定义的错误码
     */
    private WAErrorCode waErrorCode;

    /**
     * 将错误信息传给运行异常使用处理
     * @param waErrorCode 错误码信息
     * @param errorMessage 异常错误信息
     */
    public WADataXExcption(WAErrorCode waErrorCode,String errorMessage){
        super(waErrorCode.toString()+" - "+errorMessage);
        this.waErrorCode = waErrorCode;
    }

    private WADataXExcption(WAErrorCode waErrorCode,String errorMessage,Throwable cause){
        super(waErrorCode.toString()+" - "+getMessage(errorMessage)+" - "+getMessage(cause),cause);

        this.waErrorCode = waErrorCode;
    }

    /**
     * 作为自定义的WAExcption的错误异常信息的处理
     * @param waErrorCode 网安的错误码
     * @param message 传入的错误信息
     * @return 返回标准化异常处理
     */
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

    /**
     * 返回错误码
     * @return 当前的WAErrorCode
     */
    public WAErrorCode getWACode() {
        return this.waErrorCode;
    }

    /**
     *
     * @param obj 传入对象参数
     * @return 返回obj的字符串
     */
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
