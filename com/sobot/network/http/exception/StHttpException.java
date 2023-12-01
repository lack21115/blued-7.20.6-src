package com.sobot.network.http.exception;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/exception/StHttpException.class */
public class StHttpException extends RuntimeException {
    private static final long serialVersionUID = 8773734741709178425L;
    private int code;
    private String message;

    public StHttpException(String str) {
        super(str);
    }

    public static StHttpException COMMON(String str) {
        return new StHttpException(str);
    }

    public static StHttpException NET_ERROR() {
        return new StHttpException("network error! http response code is 404 or 5xx!");
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
