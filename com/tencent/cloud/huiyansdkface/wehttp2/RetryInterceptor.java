package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/RetryInterceptor.class */
public class RetryInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final RetryStrategy f36106a = new RetryStrategy() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor.1
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor.RetryStrategy
        public boolean needRetry(Request request, Response response, int i) {
            return !response.isSuccessful();
        }
    };
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private RetryStrategy f36107c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/RetryInterceptor$RetryStrategy.class */
    public interface RetryStrategy {
        boolean needRetry(Request request, Response response, int i);
    }

    public RetryInterceptor(int i, RetryStrategy retryStrategy) {
        this.b = 3;
        this.b = i;
        this.f36107c = retryStrategy;
    }

    private boolean a(Request request, Response response, int i) {
        RetryStrategy retryStrategy = this.f36107c;
        return retryStrategy != null ? retryStrategy.needRetry(request, response, i) : f36106a.needRetry(request, response, i);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        int i = 0;
        while (a(request, proceed, i) && i < this.b) {
            i++;
            proceed = chain.proceed(request);
        }
        return proceed;
    }

    public RetryInterceptor setMaxRetryCount(int i) {
        this.b = i;
        return this;
    }

    public RetryInterceptor setRetryStrategy(RetryStrategy retryStrategy) {
        this.f36107c = retryStrategy;
        return this;
    }
}
