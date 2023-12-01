package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;
import com.igexin.push.core.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/af.class */
public abstract class af implements ac {
    private static final String Z = "JsbBaseCommand";
    private final byte[] B;
    private WeakReference<Activity> C;
    protected String Code;
    protected String I;
    protected String V;

    public af() {
        this.B = new byte[0];
    }

    public af(String str) {
        this.B = new byte[0];
        this.Code = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, String str) {
        if (adContentData != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!TextUtils.isEmpty(jSONObject.optString(com.huawei.openalliance.ad.constant.ao.C))) {
                    adContentData.V(jSONObject.optString(com.huawei.openalliance.ad.constant.ao.C));
                }
                if (TextUtils.isEmpty(jSONObject.optString(com.huawei.openalliance.ad.constant.ao.S))) {
                    return;
                }
                adContentData.F(jSONObject.optString(com.huawei.openalliance.ad.constant.ao.S));
            } catch (Throwable th) {
                ge.I(Z, "update content failed");
            }
        }
    }

    public static void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i, JsbCallBackData jsbCallBackData) {
        if (remoteCallResultCallback != null) {
            CallResult<String> callResult = new CallResult<>();
            callResult.setCode(i);
            try {
                callResult.setData(com.huawei.openalliance.ad.utils.z.Code(jsbCallBackData));
            } catch (Throwable th) {
                ge.I(Z, "onCallResult " + th.getClass().getSimpleName());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    public static <T> void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i, T t, boolean z) {
        Code(remoteCallResultCallback, str, i, new JsbCallBackData(t, z, null));
    }

    public Integer B(String str) {
        try {
            int optInt = new JSONObject(str).optInt("source", -111111);
            if (optInt != -111111) {
                return Integer.valueOf(optInt);
            }
            return null;
        } catch (Throwable th) {
            ge.Code(Z, "getDownloadSource error");
            return null;
        }
    }

    public com.huawei.openalliance.ad.inter.data.m C(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Integer valueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.at.aj, -111111));
            Integer valueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.at.ak, -111111));
            String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.at.al, "");
            Integer num = valueOf;
            if (valueOf.intValue() == -111111) {
                num = null;
            }
            Integer num2 = valueOf2;
            if (valueOf2.intValue() == -111111) {
                num2 = null;
            }
            String str2 = optString;
            if (!com.huawei.openalliance.ad.utils.au.D(optString)) {
                str2 = null;
            }
            return new com.huawei.openalliance.ad.inter.data.m(num, num2, str2);
        } catch (Throwable th) {
            ge.Code(Z, "getClickInfo error");
            return null;
        }
    }

    @Override // com.huawei.hms.ads.ac
    public Context Code(Context context) {
        synchronized (this.B) {
            if (this.C == null || this.C.get() == null) {
                return context;
            }
            return this.C.get();
        }
    }

    @Override // com.huawei.hms.ads.ac
    public f.a Code() {
        return f.a.IO;
    }

    @Override // com.huawei.hms.ads.ac
    public Object Code(Context context, String str) {
        ge.I(Z, "direct call is not implemented!");
        throw new IllegalStateException("direct call is not implemented!");
    }

    @Override // com.huawei.hms.ads.ac
    public void Code(Activity activity) {
        synchronized (this.B) {
            if (this.C == null || this.C.get() == null) {
                this.C = new WeakReference<>(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(Context context, String str, ab abVar) {
        Code(context, str, false, abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(Context context, final String str, boolean z, final ab abVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject.put("content_id", jSONObject2.optString(com.huawei.openalliance.ad.constant.ao.u));
            jSONObject.put("unique_id", jSONObject2.optString("adId"));
            jSONObject.put(com.huawei.openalliance.ad.constant.ao.I, z);
            jSONObject.put(com.huawei.openalliance.ad.constant.ao.Z, this.V);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.p.s, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.af.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    if (callResult.getCode() != 200) {
                        ge.I(af.Z, "request ad content, retCode: %s", Integer.valueOf(callResult.getCode()));
                        abVar.Code(null);
                        return;
                    }
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.z.V(callResult.getData(), AdContentData.class, new Class[0]);
                    af.this.Code(adContentData, str);
                    if (adContentData == null) {
                        ge.I(af.Z, "request ad content is null");
                    }
                    abVar.Code(adContentData);
                }
            }, String.class);
        } catch (Throwable th) {
            ge.I(Z, "request ad content error");
        }
    }

    protected void Code(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z) {
        Code(remoteCallResultCallback, this.Code, 1011, "", z);
    }

    @Override // com.huawei.hms.ads.ac
    public void Code(String str) {
        this.V = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Code(AdContentData adContentData) {
        if (adContentData == null) {
            return false;
        }
        boolean z = false;
        if (adContentData.ar()) {
            z = false;
            if (km.Z(adContentData.r())) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z) {
        Code(remoteCallResultCallback, this.Code, 1000, b.x, z);
    }

    @Override // com.huawei.hms.ads.ac
    public void V(String str) {
        this.I = str;
    }

    @Override // com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.I(Z, "async execute is not implemented!");
        throw new IllegalStateException("async execute is not implemented!");
    }
}
