package com.ksad.download.a;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/a/a.class */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException(e);
        }
    }
}
