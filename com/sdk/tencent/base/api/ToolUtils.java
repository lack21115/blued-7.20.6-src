package com.sdk.tencent.base.api;

import android.content.Context;
import com.sdk.tencent.base.framework.utils.app.AppUtils;
import com.sdk.tencent.p.b;
import com.sdk.tencent.q.a;
import com.sdk.tencent.q.d;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/api/ToolUtils.class */
public class ToolUtils {
    public static String AES_Decrypt(String str, String str2) {
        return a.a(str, str2, a.f28072c);
    }

    public static String Base64_Decrypt(String str) {
        return d.a(str);
    }

    public static String RsaDecrypt(String str, String str2) {
        return b.a(str, str2);
    }

    public static void clearCache(Context context) {
        com.sdk.tencent.n.b.b(com.sdk.tencent.b.a.f28016a, "cache clear", com.sdk.tencent.b.a.b);
        com.sdk.tencent.j.a.a(context, "accessCode");
    }

    public static String getAppMd5(Context context) {
        return AppUtils.getAppMd5(context);
    }
}
