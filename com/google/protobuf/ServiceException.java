package com.google.protobuf;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/ServiceException.class */
public class ServiceException extends Exception {
    private static final long serialVersionUID = -1219262335729891920L;

    public ServiceException(String str) {
        super(str);
    }

    public ServiceException(String str, Throwable th) {
        super(str, th);
    }

    public ServiceException(Throwable th) {
        super(th);
    }
}
