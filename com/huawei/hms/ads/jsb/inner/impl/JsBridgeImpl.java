package com.huawei.hms.ads.jsb.inner.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ac;
import com.huawei.hms.ads.af;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.f;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/inner/impl/JsBridgeImpl.class */
public class JsBridgeImpl {
    private static final String Code = "JsBridgeImpl";

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/inner/impl/JsBridgeImpl$a.class */
    static class a<T> implements Runnable {
        private ac B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = acVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsBridgeImpl.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (acVar == null) {
            String str3 = "api for " + str + " is not found";
            ge.V(Code, "call " + str3);
            af.Code(remoteCallResultCallback, str, 1011, str3, true);
            return;
        }
        ge.V(Code, "call method: " + str);
        if (ge.Code()) {
            ge.Code(Code, "param: %s", bc.Code(str2));
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("content");
            acVar.Code(jSONObject.optString("url"));
            acVar.V(jSONObject.optString("cid"));
            acVar.execute(context, optString, remoteCallResultCallback);
        } catch (Throwable th) {
            ge.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            af.Code(remoteCallResultCallback, str, 1011, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
            ge.Code(3, th);
        }
    }

    public static void initConfig(Context context, JsbConfig jsbConfig) {
        com.huawei.hms.ads.jsb.a.Code(context).Code(jsbConfig);
    }

    public static String invoke(Context context, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        int i = 1011;
        if (context != null) {
            try {
            } catch (Throwable th) {
                ge.I(Code, "call method : " + th.getClass().getSimpleName());
                str3 = "call " + str + " " + th.getClass().getSimpleName() + ":" + th.getMessage();
            }
            if (!TextUtils.isEmpty(str2)) {
                ac Code2 = ah.Code().Code(str);
                if (Code2 != null) {
                    ge.V(Code, "call api: " + str);
                    str3 = Code2.Code(context.getApplicationContext(), new JSONObject(str2).optString("content"));
                    i = 1000;
                } else {
                    str3 = null;
                }
                try {
                    jSONObject.put("code", i);
                    jSONObject.put("data", str3);
                } catch (Throwable th2) {
                    ge.I(Code, "call method : " + th2.getClass().getSimpleName());
                }
                return jSONObject.toString();
            }
        }
        ge.Z(Code, "param is invalid, please check it!");
        jSONObject.put("msg", "invalid params");
        jSONObject.put("code", 1011);
        return jSONObject.toString();
    }

    public static void invoke(Context context, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback, Class<String> cls) {
        if (context == null || TextUtils.isEmpty(str2)) {
            ge.Z(Code, "param is invalid, please check it!");
            af.Code(remoteCallResultCallback, str, 1001, null, true);
            return;
        }
        ac Code2 = ah.Code().Code(str);
        f.a aVar = f.a.IO;
        if (Code2 != null) {
            f.a Code3 = Code2.Code();
            aVar = Code3;
            if (ah.Code().Code(str, context)) {
                Code2.Code((Activity) context);
                aVar = Code3;
            }
        }
        f.Code(new a(context.getApplicationContext(), Code2, str, str2, remoteCallResultCallback), aVar, false);
    }
}
