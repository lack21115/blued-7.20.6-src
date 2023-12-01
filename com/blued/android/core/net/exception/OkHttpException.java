package com.blued.android.core.net.exception;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/exception/OkHttpException.class */
public class OkHttpException extends RuntimeException {
    private Exception a;

    public OkHttpException(Exception exc) {
        this.a = exc;
    }
}
