package com.sobot.network.http;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/SobotInternetPermissionExceptionInterceptor.class */
public class SobotInternetPermissionExceptionInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        try {
            return chain.proceed(chain.request());
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException(th);
        }
    }
}
