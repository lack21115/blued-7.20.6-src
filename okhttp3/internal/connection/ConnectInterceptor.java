package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/ConnectInterceptor.class */
public final class ConnectInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f43868a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f43868a = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        StreamAllocation a2 = realInterceptorChain.a();
        return realInterceptorChain.a(request, a2, a2.a(this.f43868a, chain, !request.method().equals("GET")), a2.c());
    }
}
