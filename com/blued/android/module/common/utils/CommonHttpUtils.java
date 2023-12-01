package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.user.model.UserInfo;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/CommonHttpUtils.class */
public class CommonHttpUtils {
    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, Map<String, String> map, IRequestHost iRequestHost) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpManager.a(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(map).h();
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = str;
        if (str.contains("__CONN_TYPE__")) {
            str2 = str.replace("__CONN_TYPE__", NetworkUtils.d());
        }
        if (UserInfo.getInstance().isLogin()) {
            HttpManager.a(str2, null).b(BluedHttpTools.a(true)).h();
        } else {
            HttpManager.a(str2, null).b(BluedHttpTools.a(false)).h();
        }
    }

    public static void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            a(strArr[i2]);
            i = i2 + 1;
        }
    }
}
