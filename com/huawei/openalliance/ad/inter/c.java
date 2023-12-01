package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kp;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/c.class */
public class c extends BroadcastReceiver {
    private Context C;
    private fk S;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.C = applicationContext;
        this.S = fk.Code(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdContentData Code(JSONObject jSONObject) {
        AdContentData adContentData;
        AdContentData adContentData2;
        try {
            String optString = jSONObject.optString("contentRecord");
            AdContentData adContentData3 = (AdContentData) z.V(optString, AdContentData.class, new Class[0]);
            try {
                if (ge.Code()) {
                    ge.Code("ExLinkedSplashReceiver", " adContent content=%s", bc.Code(optString));
                }
                adContentData2 = adContentData3;
                if (adContentData3 != null) {
                    V(jSONObject);
                    return adContentData3;
                }
            } catch (Throwable th) {
                adContentData = adContentData3;
                th = th;
                ge.I("ExLinkedSplashReceiver", "handleResponse exception: %s", th.getClass().getSimpleName());
                adContentData2 = adContentData;
                return adContentData2;
            }
        } catch (Throwable th2) {
            th = th2;
            adContentData = null;
        }
        return adContentData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        com.huawei.openalliance.ad.ipc.d.Code(this.C).Code("showSplash", null, null, null);
    }

    private void V(JSONObject jSONObject) {
        int optInt = jSONObject.optInt(at.H);
        String optString = jSONObject.optString(at.G);
        if (ge.Code()) {
            ge.Code("ExLinkedSplashReceiver", "splashSkipArea=%s", Integer.valueOf(optInt));
            ge.Code("ExLinkedSplashReceiver", "globalSwitch=%s", bc.Code(optString));
        }
        fk fkVar = this.S;
        if (fkVar != null) {
            fkVar.C(optInt);
            this.S.I(optString);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Log.d("ExLinkedSplashReceiver", "onReceive.");
        if (intent == null) {
            return;
        }
        try {
            if (t.bj.equals(intent.getAction())) {
                ge.V("ExLinkedSplashReceiver", "receiver exlinkedsplash action");
                Long valueOf = Long.valueOf(intent.getLongExtra("exsplash_slogan_start_time", 0L));
                int intExtra = intent.getIntExtra("exsplash_slogan_show_time", 0);
                String stringExtra = intent.getStringExtra("linked_content_id");
                int intExtra2 = intent.getIntExtra("exsplash_redundancy_time", 0);
                ge.Code("ExLinkedSplashReceiver", "ExLinkedSplashReceiver, startTime: %s, showTime: %s, contentId: %s", valueOf, Integer.valueOf(intExtra), stringExtra);
                context.removeStickyBroadcast(intent);
                if (this.S != null) {
                    this.S.V(valueOf.longValue());
                    this.S.Z(intExtra);
                    this.S.V(stringExtra);
                    this.S.B(intExtra2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_id", stringExtra);
                jSONObject.put("package_name", this.C.getPackageName());
                jSONObject.put(at.E, false);
                com.huawei.openalliance.ad.ipc.d.Code(context).Code("reqLinkedVideo", jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.c.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            ge.I("ExLinkedSplashReceiver", "call reqExLinked failed");
                            c.this.Code();
                            return;
                        }
                        ge.V("ExLinkedSplashReceiver", "reqExLinkedVideo success");
                        try {
                            final AdContentData Code = c.this.Code(new JSONObject(callResult.getData()));
                            if (Code != null) {
                                Code.B(true);
                                final l Code2 = kp.Code(Code);
                                Code2.Code(true);
                                final com.huawei.openalliance.ad.inter.listeners.e C = g.Code(context).C();
                                if (C != null) {
                                    com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.c.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String str2;
                                            String str3;
                                            boolean Code3 = C.Code(Code2);
                                            ge.V("ExLinkedSplashReceiver", "onReceive, isCanDisplay: %s", Boolean.valueOf(Code3));
                                            if (Code3) {
                                                return;
                                            }
                                            ge.I("ExLinkedSplashReceiver", "isCanDisplay false, start show normal splash. ");
                                            c.this.Code();
                                            l lVar = Code2;
                                            if (lVar != null) {
                                                String D = lVar.D();
                                                str3 = Code2.m();
                                                str2 = D;
                                            } else {
                                                str2 = null;
                                                str3 = null;
                                            }
                                            eh.Code(context, str3, str2, 0L, Code, "82");
                                        }
                                    });
                                    return;
                                }
                                ge.I("ExLinkedSplashReceiver", "exSplashCallback is null");
                            } else {
                                ge.I("ExLinkedSplashReceiver", "content is null");
                            }
                            c.this.Code();
                        } catch (JSONException e) {
                            ge.I("ExLinkedSplashReceiver", "reqLinkedVideo onRemoteCallResult JSONException ");
                        }
                    }
                }, String.class);
            }
        } catch (JSONException e) {
            ge.I("ExLinkedSplashReceiver", "reqExLinkedVideo JSONException");
            Code();
        } catch (Throwable th) {
            ge.I("ExLinkedSplashReceiver", "reqLinkedVideo exception: %s", th.getClass().getSimpleName());
        }
    }
}
