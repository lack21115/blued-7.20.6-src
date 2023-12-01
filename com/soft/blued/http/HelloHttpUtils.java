package com.soft.blued.http;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import java.util.Date;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/HelloHttpUtils.class */
public class HelloHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    private static long f15969a;

    public static void a() {
        Map a2 = BluedHttpTools.a();
        a2.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        HttpManager.b(BluedHttpUrl.q() + "/users/call", (HttpResponseHandler) null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, boolean z, String str, boolean z2) {
        long time = new Date().getTime();
        if (time - f15969a < 1000) {
            return;
        }
        f15969a = time;
        String str2 = BluedHttpUrl.q() + "/users/call/open";
        Map a2 = BluedHttpTools.a();
        a2.put("is_quietly", z ? "1" : "0");
        a2.put("from", str);
        if (z2) {
            a2.put("count", "2");
        }
        HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }
}
