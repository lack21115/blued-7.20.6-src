package com.huawei.hms.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.b;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kk.class */
public class kk {
    public static int Code = 0;
    private static final String V = "AdRequester";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kk$a.class */
    public static class a<T> implements RemoteCallResultCallback<T> {
        private RemoteCallResultCallback<T> Code;
        private Context V;

        a(Context context, RemoteCallResultCallback<T> remoteCallResultCallback) {
            this.Code = remoteCallResultCallback;
            this.V = context.getApplicationContext();
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<T> callResult) {
            if (callResult.getCode() == 201) {
                try {
                    fk.Code(this.V).I(new JSONObject(callResult.getMsg()).optInt(com.huawei.openalliance.ad.constant.at.f22945c, 0));
                    return;
                } catch (JSONException e) {
                    ge.I(kk.V, "parse ad config JSONException");
                    return;
                }
            }
            RemoteCallResultCallback<T> remoteCallResultCallback = this.Code;
            if (remoteCallResultCallback != null) {
                remoteCallResultCallback.onRemoteCallResult(str, callResult);
            }
        }
    }

    private static Boolean Code(Boolean bool) {
        return bool != null ? bool : Boolean.valueOf(com.huawei.openalliance.ad.utils.q.V());
    }

    public static void Code() {
        Code = 0;
    }

    private static void Code(final Context context, final AdSlotParam adSlotParam) {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.kk.1
            @Override // java.lang.Runnable
            public void run() {
                List<String> Code2;
                String jSONObject;
                AdSlotParam adSlotParam2 = AdSlotParam.this;
                if (adSlotParam2 == null || (Code2 = adSlotParam2.Code()) == null || Code2.size() <= 0) {
                    return;
                }
                if (System.currentTimeMillis() - fk.Code(context).j() > kk.V(context)) {
                    try {
                        if (!com.huawei.openalliance.ad.utils.v.I() && !com.huawei.openalliance.ad.utils.v.F(context)) {
                            jSONObject = Code2.get(0);
                            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.p.Code, jSONObject, new RemoteCallResultCallback<AppConfigRsp>() { // from class: com.huawei.hms.ads.kk.1.1
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<AppConfigRsp> callResult) {
                                    if (callResult.getData() != null) {
                                        AppConfigRsp data = callResult.getData();
                                        if (data.Code() == 206) {
                                            fk.Code(context).Code(System.currentTimeMillis());
                                        } else {
                                            fk.Code(context).Code(data);
                                        }
                                    }
                                }
                            }, AppConfigRsp.class);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(com.huawei.openalliance.ad.constant.at.ac, Code2.get(0));
                        jSONObject2.put("sdk_type", c.d(context));
                        jSONObject2.put(com.huawei.openalliance.ad.constant.at.Code, f.Code());
                        jSONObject2.put(com.huawei.openalliance.ad.constant.at.aq, fk.Code(context).ak());
                        jSONObject2.put(com.huawei.openalliance.ad.constant.at.V, com.huawei.openalliance.ad.utils.z.V(kk.V()));
                        jSONObject = jSONObject2.toString();
                        com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.p.Code, jSONObject, new RemoteCallResultCallback<AppConfigRsp>() { // from class: com.huawei.hms.ads.kk.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<AppConfigRsp> callResult) {
                                if (callResult.getData() != null) {
                                    AppConfigRsp data = callResult.getData();
                                    if (data.Code() == 206) {
                                        fk.Code(context).Code(System.currentTimeMillis());
                                    } else {
                                        fk.Code(context).Code(data);
                                    }
                                }
                            }
                        }, AppConfigRsp.class);
                    } catch (Throwable th) {
                        ge.I(kk.V, "requestConfig err: %s", th.getClass().getSimpleName());
                    }
                }
            }
        });
    }

    public static <T> void Code(Context context, String str, AdSlotParam adSlotParam, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        Context applicationContext = context.getApplicationContext();
        JSONObject jSONObject = new JSONObject();
        a aVar = new a(applicationContext, remoteCallResultCallback);
        try {
            adSlotParam.Code(fk.Code(applicationContext).r());
            adSlotParam.V(fk.Code(applicationContext).g());
            adSlotParam.D(HiAd.Code(context).I());
            adSlotParam.a(c.d(context));
            adSlotParam.Z(f.Code());
            RequestOptions B = adSlotParam.B();
            RequestOptions requestOptions = B;
            if (B == null) {
                requestOptions = new RequestOptions();
                adSlotParam.Code(requestOptions);
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
            if (TextUtils.isEmpty(requestOptions.getConsent())) {
                requestOptions.Code(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.t.cb, ""));
            }
            requestOptions.V(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.t.cc, ""));
            requestOptions.I(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.t.cd, ""));
            Location Code2 = com.huawei.openalliance.ad.utils.ac.Code(applicationContext, requestOptions, adSlotParam.Z() != null ? adSlotParam.Z().Code() : null);
            adSlotParam.Code(Code2);
            b S = Code2.S();
            adSlotParam.C(Integer.valueOf(S.Code()));
            adSlotParam.S(Integer.valueOf(S.V()));
            adSlotParam.F(Integer.valueOf(S.I()));
            if (!Code(applicationContext, applicationContext.getPackageName())) {
                adSlotParam.Code((App) null);
            }
            if (dt.Code(context).V()) {
                adSlotParam.I(com.huawei.openalliance.ad.utils.a.Code(context));
            }
            if (fk.Code(context).ae() && !TextUtils.equals(str, com.huawei.openalliance.ad.constant.t.ce)) {
                adSlotParam.B(kl.Code(context).Code());
            }
            requestOptions.Code(Code(requestOptions.D()));
            jSONObject.put(com.huawei.openalliance.ad.constant.at.I, com.huawei.openalliance.ad.utils.z.V(adSlotParam));
            jSONObject.put("content", str2);
            jSONObject.put(com.huawei.openalliance.ad.constant.at.K, System.currentTimeMillis());
            com.huawei.openalliance.ad.ipc.g.V(applicationContext).Code(str, jSONObject.toString(), aVar, cls);
        } catch (JSONException e) {
            ge.I(V, "requestAd JSONException");
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg("requestAd JSONException");
            aVar.onRemoteCallResult(str, callResult);
        }
        Code(applicationContext, adSlotParam);
    }

    private static boolean Code(Context context, String str) {
        return com.huawei.openalliance.ad.constant.cj.Code(str, com.huawei.openalliance.ad.utils.e.B(context, str));
    }

    private static List<String> I() {
        try {
            if (f.V() != null) {
                return f.V().Code((Bundle) null);
            }
            return null;
        } catch (Throwable th) {
            ge.V(V, "get blackTptIdList err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    private static boolean I(Context context) {
        return !TextUtils.isEmpty(fk.Code(context).u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long V(Context context) {
        int i;
        fk Code2 = fk.Code(context);
        if (Z(context) && (i = Code) <= 10) {
            Code = i + 1;
            return 0L;
        }
        long i2 = Code2.i();
        if (I(context)) {
            i2 = Code2.v();
        }
        return i2 * 60000;
    }

    static /* synthetic */ List V() {
        return I();
    }

    private static boolean Z(Context context) {
        return HiAd.Code(context).Z();
    }
}
