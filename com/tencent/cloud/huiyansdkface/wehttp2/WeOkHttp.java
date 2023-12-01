package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sobot.network.http.SobotOkHttpUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeOkHttp.class */
public class WeOkHttp {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f22444a = new Handler(Looper.getMainLooper());
    private WeConfig b;

    public WeOkHttp() {
        this.b = new WeConfig();
    }

    public WeOkHttp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("savedConfigName is empty");
        }
        this.b = new WeConfig(context, str);
    }

    public WeOkHttp(WeConfigLoader weConfigLoader) {
        this.b = new WeConfig(weConfigLoader);
    }

    public WeOkHttp(String str) {
        this(null, str);
    }

    private void a(Object obj, List<Call> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            Call call = list.get(i2);
            if (obj != null && obj.equals(call.request().tag())) {
                call.cancel();
            }
            i = i2 + 1;
        }
    }

    public static void runUi(Runnable runnable) {
        if (runnable != null) {
            f22444a.post(runnable);
        }
    }

    public void cancel(Object obj) {
        if (obj == null) {
            client().dispatcher().cancelAll();
            return;
        }
        a(obj, this.b.client().dispatcher().runningCalls());
        a(obj, this.b.client().dispatcher().queuedCalls());
    }

    public OkHttpClient client() {
        return this.b.client();
    }

    public WeConfig config() {
        if (this.b == null) {
            this.b = new WeConfig();
        }
        return this.b;
    }

    public BodyReq delete(String str) {
        return new BodyReq(this, "DELETE", str);
    }

    public SimpleReq get(String str) {
        return new SimpleReq(this, "GET", str);
    }

    public SimpleReq head(String str) {
        return new SimpleReq(this, "HEAD", str);
    }

    @Deprecated
    public WeConfig init() {
        return config();
    }

    public BodyReq patch(String str) {
        return new BodyReq(this, SobotOkHttpUtils.METHOD.PATCH, str);
    }

    public BodyReq post(String str) {
        return new BodyReq(this, "POST", str);
    }

    public BodyReq put(String str) {
        return new BodyReq(this, "PUT", str);
    }
}
