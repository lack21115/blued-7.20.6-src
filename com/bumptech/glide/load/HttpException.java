package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/HttpException.class */
public final class HttpException extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private final int f7093a;

    public HttpException(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    public HttpException(String str, int i, Throwable th) {
        super(str, th);
        this.f7093a = i;
    }
}
