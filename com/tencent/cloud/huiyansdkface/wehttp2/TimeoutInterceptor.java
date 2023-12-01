package com.tencent.cloud.huiyansdkface.wehttp2;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/TimeoutInterceptor.class */
public class TimeoutInterceptor implements Interceptor {
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header("__wehttp__connect_timeout__");
        String header2 = request.header("__wehttp__read_timeout__");
        String header3 = request.header("__wehttp__write_timeout__");
        Interceptor.Chain chain2 = chain;
        if (!TextUtils.isEmpty(header)) {
            chain2 = chain.withConnectTimeout(Integer.valueOf(header).intValue(), TimeUnit.MILLISECONDS);
        }
        Interceptor.Chain chain3 = chain2;
        if (!TextUtils.isEmpty(header2)) {
            chain3 = chain2.withReadTimeout(Integer.valueOf(header2).intValue(), TimeUnit.MILLISECONDS);
        }
        Interceptor.Chain chain4 = chain3;
        if (!TextUtils.isEmpty(header3)) {
            chain4 = chain3.withWriteTimeout(Integer.valueOf(header3).intValue(), TimeUnit.MILLISECONDS);
        }
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.removeHeader("__wehttp__connect_timeout__");
        newBuilder.removeHeader("__wehttp__read_timeout__");
        newBuilder.removeHeader("__wehttp__write_timeout__");
        return chain4.proceed(newBuilder.build());
    }
}
