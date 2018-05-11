package com.cjs.boot.response;

import com.cjs.boot.constants.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class RespResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public RespResult() {
    }

    public RespResult(ErrorCodeEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }

    public RespResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RespResult(T data) {
        this.code = ErrorCodeEnum.SUCCESS.getCode();
        this.msg = ErrorCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public boolean isSuccess() {
        if (code == ErrorCodeEnum.SUCCESS.getCode().intValue()) {
            return true;
        }else {
            return false;
        }
    }

    public static RespResult failure(String msg) {
        return new RespResult(ErrorCodeEnum.FAILURE.getCode(), msg);
    }

    public static RespResult success() {
        return new RespResult(ErrorCodeEnum.SUCCESS);
    }

}
