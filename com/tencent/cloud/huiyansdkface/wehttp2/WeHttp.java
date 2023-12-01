package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeHttp.class */
public class WeHttp {

    /* renamed from: a  reason: collision with root package name */
    private static WeOkHttp f36129a = new WeOkHttp("WeHttp");

    public static void cancel(Object obj) {
        f36129a.cancel(obj);
    }

    public static OkHttpClient client() {
        return f36129a.client();
    }

    public static WeConfig config() {
        return f36129a.config();
    }

    public static BodyReq delete(String str) {
        return f36129a.delete(str);
    }

    public static SimpleReq get(String str) {
        return f36129a.get(str);
    }

    public static SimpleReq head(String str) {
        return f36129a.head(str);
    }

    public static WeConfig init() {
        return f36129a.init();
    }

    public static WeConfig init(Context context, boolean z, String str, String... strArr) {
        if (context != null) {
            config().clientConfig().connectTimeout(20L, TimeUnit.SECONDS).readTimeout(20L, TimeUnit.SECONDS);
            config().addPin4Host(HttpUrl.parse(str).host(), strArr).log(z ? WeLog.Level.BODY : WeLog.Level.NONE).cookieWebView(context.getApplicationContext()).adapter(new WeTypeAdapter()).baseUrl(str);
            return config();
        }
        throw new IllegalArgumentException("ctx must not be null");
    }

    public static BodyReq patch(String str) {
        return f36129a.patch(str);
    }

    public static BodyReq post(String str) {
        return f36129a.post(str);
    }

    public static BodyReq put(String str) {
        return f36129a.put(str);
    }
}
