package com.tencent.map.tools.net.exception;

import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/exception/NetErrorException.class */
public class NetErrorException extends IOException {
    public int errorCode;
    public int statusCode;

    public NetErrorException() {
    }

    public NetErrorException(String str) {
        super(str);
    }

    public NetErrorException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
