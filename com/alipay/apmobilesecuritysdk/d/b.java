package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import com.alipay.apmobilesecuritysdk.e.h;
import com.huawei.openalliance.ad.constant.ao;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/d/b.class */
public final class b {
    public static Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            try {
                hashMap = new HashMap();
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                String a3 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, ao.q, "");
                String a5 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                String a6 = com.alipay.security.mobile.module.a.a.a(map, "appKeyClient", "");
                String a7 = com.alipay.security.mobile.module.a.a.a(map, "tmxSessionId", "");
                String f = h.f(context);
                String a8 = com.alipay.security.mobile.module.a.a.a(map, TextToSpeech.Engine.KEY_PARAM_SESSION_ID, "");
                hashMap.put("AC1", a2);
                hashMap.put("AC2", a3);
                hashMap.put("AC3", "");
                hashMap.put("AC4", f);
                hashMap.put("AC5", a4);
                hashMap.put("AC6", a7);
                hashMap.put("AC7", "");
                hashMap.put("AC8", a5);
                hashMap.put("AC9", a6);
                if (com.alipay.security.mobile.module.a.a.b(a8)) {
                    hashMap.put("AC10", a8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashMap;
    }
}
