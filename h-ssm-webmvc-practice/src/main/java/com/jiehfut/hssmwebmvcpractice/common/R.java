package com.jiehfut.hssmwebmvcpractice.common;

import com.jiehfut.hssmwebmvcpractice.exception.BizExceptionEnume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public static R ok() {
        return new R(200, "success", null);
    }

    public static R ok(Object data) {
        return new R(200, "success", data);
    }

    public static R error(String msg, Object data) {
        return new R(-1, msg, data);
    }

    public static R error(String msg) {
        return new R(-1, msg, null);
    }

    public static R error(int code, String msg) {
        return new R(code, msg, null);
    }

    public static R error(BizExceptionEnume bizExceptionEnume, Object data) {
        return new R(bizExceptionEnume.getCode(), bizExceptionEnume.getMsg(), data);
    }
}
