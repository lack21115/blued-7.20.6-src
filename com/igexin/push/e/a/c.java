package com.igexin.push.e.a;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.GtHttpClient;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.LoggerInterceptor;
import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor;
import com.getui.gtc.base.util.NetworkUtil;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a/c.class */
public class c {
    private static String b = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static GtHttpClient f23595a = new GtHttpClient.Builder().addInterceptor(new LoggerInterceptor(com.igexin.c.a.c.a.a().f23251a)).addInterceptor(new Interceptor() { // from class: com.igexin.push.e.a.c.1
        @Override // com.getui.gtc.base.http.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            if (GtcProvider.context() == null || NetworkUtil.isNetWorkAvailable(GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new IllegalStateException("network is not available");
        }
    }).build();

    public static void a(String str, byte[] bArr, Call.Callback callback) {
        try {
            f23595a.newCall(new Request.Builder().url(str).method("POST").cryptInterceptor(new GtRASCryptoInterceptor(com.igexin.push.a.j, com.igexin.push.a.k)).body(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), bArr)).build()).enqueue(callback);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
