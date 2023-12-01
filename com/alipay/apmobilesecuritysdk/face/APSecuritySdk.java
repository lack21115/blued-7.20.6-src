package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/face/APSecuritySdk.class */
public class APSecuritySdk {
    private static APSecuritySdk a;
    private static Object c = new Object();
    private Context b;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener.class */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult.class */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    private APSecuritySdk(Context context) {
        this.b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (a == null) {
            synchronized (c) {
                if (a == null) {
                    a = new APSecuritySdk(context);
                }
            }
        }
        return a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String a2 = a.a(this.b, "");
        if (com.alipay.security.mobile.module.a.a.a(a2)) {
            initToken(0, new HashMap(), null);
        }
        return a2;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.201910161639";
    }

    public TokenResult getTokenResult() {
        TokenResult tokenResult;
        synchronized (this) {
            tokenResult = new TokenResult();
            try {
                tokenResult.apdidToken = a.a(this.b, "");
                tokenResult.clientKey = h.f(this.b);
                tokenResult.apdid = a.a(this.b);
                tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.b);
                if (com.alipay.security.mobile.module.a.a.a(tokenResult.apdid) || com.alipay.security.mobile.module.a.a.a(tokenResult.apdidToken) || com.alipay.security.mobile.module.a.a.a(tokenResult.clientKey)) {
                    initToken(0, new HashMap(), null);
                }
            } catch (Throwable th) {
            }
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i);
        String b = h.b(this.b);
        String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.security.mobile.module.a.a.b(b) && !com.alipay.security.mobile.module.a.a.a(b, c2)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.b);
            d.a(this.b);
            g.a(this.b);
            i.h();
        }
        if (!com.alipay.security.mobile.module.a.a.a(b, c2)) {
            h.c(this.b, c2);
        }
        String a2 = com.alipay.security.mobile.module.a.a.a(map, b.g, "");
        String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
        String a4 = com.alipay.security.mobile.module.a.a.a(map, "userId", "");
        String str = a2;
        if (com.alipay.security.mobile.module.a.a.a(a2)) {
            str = UtdidWrapper.getUtdid(this.b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.g, str);
        hashMap.put("tid", a3);
        hashMap.put("userId", a4);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
