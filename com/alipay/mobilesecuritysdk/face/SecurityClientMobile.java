package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.cons.b;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/mobilesecuritysdk/face/SecurityClientMobile.class */
public class SecurityClientMobile {
    public static String GetApdid(Context context, Map<String, String> map) {
        String a;
        synchronized (SecurityClientMobile.class) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(b.g, a.a(map, b.g, ""));
                hashMap.put("tid", a.a(map, "tid", ""));
                hashMap.put("userId", a.a(map, "userId", ""));
                APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
                a = com.alipay.apmobilesecuritysdk.a.a.a(context);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }
}
