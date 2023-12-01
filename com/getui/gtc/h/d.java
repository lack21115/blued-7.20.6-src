package com.getui.gtc.h;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.GtHttpClient;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.LoggerInterceptor;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.util.NetworkUtil;
import com.getui.gtc.i.c.a;
import java.io.IOException;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/h/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static GtHttpClient f22027a = new GtHttpClient.Builder().addInterceptor(new LoggerInterceptor(a.C0352a.f22034a.f22033a)).addInterceptor(new Interceptor() { // from class: com.getui.gtc.h.d.1
        @Override // com.getui.gtc.base.http.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            if (NetworkUtil.isNetWorkAvailable(GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new IllegalStateException("network is not available");
        }
    }).build();
}
