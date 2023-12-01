package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import com.alipay.security.mobile.module.a.a;
import com.huawei.openalliance.ad.constant.ao;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/face/TMNTokenClient.class */
public class TMNTokenClient {

    /* renamed from: a  reason: collision with root package name */
    private static TMNTokenClient f4566a;
    private Context b;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/face/TMNTokenClient$InitResultListener.class */
    public interface InitResultListener {
        void onResult(String str, int i);
    }

    private TMNTokenClient(Context context) {
        this.b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f4566a == null) {
            synchronized (TMNTokenClient.class) {
                try {
                    if (f4566a == null) {
                        f4566a = new TMNTokenClient(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4566a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.a(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.a(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.g, UtdidWrapper.getUtdid(this.b));
        hashMap.put("tid", "");
        hashMap.put(ao.q, "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put(TextToSpeech.Engine.KEY_PARAM_SESSION_ID, str3);
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int a2 = new com.alipay.apmobilesecuritysdk.a.a(TMNTokenClient.this.b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (a2 != 0) {
                    initResultListener2.onResult("", a2);
                    return;
                }
                initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(TMNTokenClient.this.b, str), 0);
            }
        });
    }
}
