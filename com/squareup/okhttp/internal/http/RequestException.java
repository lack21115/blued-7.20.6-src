package com.squareup.okhttp.internal.http;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/http/RequestException.class */
public final class RequestException extends Exception {
    public RequestException(IOException iOException) {
        super(iOException);
    }

    @Override // java.lang.Throwable
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
