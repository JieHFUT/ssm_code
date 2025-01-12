package com.jiehfut.hssmwebmvcpractice.common;

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
}
