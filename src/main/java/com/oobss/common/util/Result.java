package com.oobss.common.util;

/**
 * Created by clarkzhao on 2017/12/29.
 *
 * @author clarkzhao
 * @date 2017/12/29
 */
public class Result {
    public static final Integer SUCCESS = 1;
    public static final Integer ERROR = 0;

    private Integer retCode;
    private String errMsg;
    private Object data;

    public Result() {
        this.retCode = SUCCESS;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "retCode:" + retCode +
                ", errMsg:'" + errMsg + '\'' +
                ", data:" + data +
                '}';
    }
}
