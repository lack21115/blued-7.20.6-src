package com.getui.gtc.base.http;

import com.getui.gtc.base.http.Interceptor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/RealInterceptorChain.class */
public class RealInterceptorChain implements Interceptor.Chain {
    private final HttpURLConnection connection;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request request;

    public RealInterceptorChain(List<Interceptor> list, HttpURLConnection httpURLConnection, int i, Request request) {
        this.interceptors = list;
        this.connection = httpURLConnection;
        this.index = i;
        this.request = request;
    }

    @Override // com.getui.gtc.base.http.Interceptor.Chain
    public HttpURLConnection connection() {
        return this.connection;
    }

    @Override // com.getui.gtc.base.http.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        return proceed(request, this.connection);
    }

    public Response proceed(Request request, HttpURLConnection httpURLConnection) throws IOException {
        if (this.index < this.interceptors.size()) {
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, httpURLConnection, this.index + 1, request);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(realInterceptorChain);
            if (intercept == null) {
                throw new NullPointerException("interceptor " + interceptor + " returned null");
            } else if (intercept.body() != null) {
                return intercept;
            } else {
                throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
            }
        }
        throw new AssertionError();
    }

    @Override // com.getui.gtc.base.http.Interceptor.Chain
    public Request request() {
        return this.request;
    }
}
