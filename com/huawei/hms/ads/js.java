package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/js.class */
public class js extends hg<lk> implements kf<lk> {
    private Context I;

    public js(Context context, lk lkVar) {
        Code((js) lkVar);
        this.I = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, com.huawei.openalliance.ad.inter.data.r rVar) {
        if (str == null) {
            Code((com.huawei.openalliance.ad.inter.data.r) null);
            return;
        }
        rVar.V(str);
        Code(rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final com.huawei.openalliance.ad.inter.data.r rVar) {
        if (rVar == null) {
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(rVar.e());
        sourceParam.Code(52428800L);
        sourceParam.V(rVar.C());
        sourceParam.V(rVar.I());
        sourceParam.I(true);
        com.huawei.openalliance.ad.utils.y.Code(this.I, sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.js.3
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                ge.I("PlacementImageViewPresenter", "placement image load failed");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.js.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        js.this.I().Code(null, null);
                    }
                });
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, final Drawable drawable) {
                com.huawei.openalliance.ad.inter.data.r rVar2 = rVar;
                if (rVar2 == null || !TextUtils.equals(str, rVar2.e())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.js.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        js.this.I().Code(rVar, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(final com.huawei.openalliance.ad.inter.data.p pVar) {
        final com.huawei.openalliance.ad.inter.data.r S;
        if (pVar == null || (S = pVar.S()) == null) {
            return;
        }
        String Z = S.Z();
        if (Z == null) {
            Code((com.huawei.openalliance.ad.inter.data.r) null);
        } else if (Z.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
            Code(Z, S);
        } else {
            com.huawei.openalliance.ad.utils.f.V(new Runnable() { // from class: com.huawei.hms.ads.js.2
                @Override // java.lang.Runnable
                public void run() {
                    SourceParam sourceParam = new SourceParam();
                    sourceParam.I(S.Z());
                    sourceParam.V(S.C());
                    sourceParam.Code(com.huawei.openalliance.ad.constant.t.j);
                    sourceParam.V(S.L() == 0);
                    sourceParam.I(true);
                    Integer c2 = com.huawei.openalliance.ad.utils.am.Code(js.this.I).c();
                    if (c2 != null) {
                        sourceParam.V(c2.intValue());
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("content_id", pVar.D());
                        jSONObject.put("content", com.huawei.openalliance.ad.utils.z.V(sourceParam));
                        com.huawei.openalliance.ad.ipc.g.V(js.this.I).Code(com.huawei.openalliance.ad.constant.p.L, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.js.2.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                js.this.Code(callResult.getData(), S);
                            }
                        }, String.class);
                    } catch (JSONException e) {
                        ge.I("PlacementImageViewPresenter", "loadImageInfo jsonex");
                    }
                }
            });
        }
    }

    public void Code(final com.huawei.openalliance.ad.inter.data.r rVar) {
        if (rVar == null) {
            I().Code(null, null);
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.js.1
                @Override // java.lang.Runnable
                public void run() {
                    if (rVar.I()) {
                        js.this.V(rVar);
                    }
                }
            });
        }
    }
}
