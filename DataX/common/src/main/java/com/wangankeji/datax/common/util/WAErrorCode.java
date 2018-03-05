package com.wangankeji.datax.common.util;

/**
 * author xiao
 * 2018/3/5
 * 异常错误码的接口
 */
public interface WAErrorCode {
    /***
     * 获取wangankeji错误码
     * 错误码编号
     */
    String getWACode();

    /**
     * 获取错误码的描述信息
     * @return string WADescription
     */
    String getWADescription();

    String toString();

}
