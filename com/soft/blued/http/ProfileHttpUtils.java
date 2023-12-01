package com.soft.blued.http;

import android.content.Context;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/ProfileHttpUtils.class */
public class ProfileHttpUtils {
    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        try {
            if (!NetworkUtils.c()) {
                return;
            }
        } catch (Exception e) {
        }
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/setting", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        if (StringUtils.d(str)) {
            return;
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("photo", str);
        a2.put("pid", str2);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/photos?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/photos/private?page=" + i + "&size=" + i2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/setting", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("is_open_private_photos", str2);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/setting?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, Map<String, String> map) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/setting?http_method_override=PUT", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("pid", str);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/photos?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/photos/private/clean", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/photos/private/" + str2 + "?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/avatar/check", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/photos/dilatation?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }
}
