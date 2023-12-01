package com.sobot.network.http.exception;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/exception/StException.class */
public class StException extends Exception {
    private static final long serialVersionUID = -8641198158155821498L;

    public StException(String str) {
        super(str);
    }

    public static StException BREAKPOINT_EXPIRED() {
        return new StException("breakpoint file has expired!");
    }

    public static StException BREAKPOINT_NOT_EXIST() {
        return new StException("breakpoint file does not exist!");
    }

    public static StException UNKNOWN() {
        return new StException("unknown exception!");
    }
}
