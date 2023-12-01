package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jm.class */
public class jm extends ji<la> implements jz<la> {
    public jm(Context context, la laVar) {
        Code((jm) laVar);
        this.V = context;
    }

    private void V(final com.huawei.openalliance.ad.inter.data.k kVar) {
        if (kVar == null) {
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        String str = null;
        if (this.Code != null) {
            str = this.Code.S();
        }
        com.huawei.openalliance.ad.utils.y.Code(this.V, sourceParam, str, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.jm.2
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                ge.I("NativeVideoP", "cover image load fail");
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str2, final Drawable drawable) {
                com.huawei.openalliance.ad.inter.data.k kVar2 = kVar;
                if (kVar2 == null || !TextUtils.equals(str2, kVar2.Z())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jm.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((la) jm.this.I()).Code(kVar, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.ji
    protected String B() {
        return "NativeVideoP";
    }

    @Override // com.huawei.hms.ads.jz
    public void Code(com.huawei.openalliance.ad.inter.data.k kVar) {
        if (kVar == null) {
            return;
        }
        V(kVar);
    }

    @Override // com.huawei.hms.ads.jz
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Code = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.jz
    public void Code(final com.huawei.openalliance.ad.inter.data.v vVar) {
        if (vVar == null) {
            return;
        }
        final boolean Code = vVar.Code();
        String V = vVar.V();
        if (TextUtils.isEmpty(V) || !V.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
            ge.V("NativeVideoP", "check if video cached.");
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.jm.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.at.z, vVar.V());
                            com.huawei.openalliance.ad.ipc.g.V(jm.this.V).Code(com.huawei.openalliance.ad.constant.p.h, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jm.1.1
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
                                        return;
                                    }
                                    vVar.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.jm.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ge.Code("NativeVideoP", "video path: %s", vVar.V());
                                    ((la) jm.this.I()).Code(vVar, Code);
                                }
                            };
                        } catch (JSONException e) {
                            ge.Code("NativeVideoP", "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.jm.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ge.Code("NativeVideoP", "video path: %s", vVar.V());
                                    ((la) jm.this.I()).Code(vVar, Code);
                                }
                            };
                        }
                        com.huawei.openalliance.ad.utils.ba.Code(runnable);
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jm.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ge.Code("NativeVideoP", "video path: %s", vVar.V());
                                ((la) jm.this.I()).Code(vVar, Code);
                            }
                        });
                        throw th;
                    }
                }
            });
            return;
        }
        ge.V("NativeVideoP", "video is cached.");
        ((la) I()).Code(vVar, Code);
    }

    @Override // com.huawei.hms.ads.jz
    public void Code(boolean z) {
        ko.Code(this.V, this.Code, z);
    }
}
