package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jt.class */
public class jt extends ji<lo> implements kg<lo> {
    public jt(Context context, lo loVar) {
        Code((jt) loVar);
        this.V = context;
    }

    @Override // com.huawei.hms.ads.ji
    protected String B() {
        return "PlacementVideoViewPresenter_" + hashCode();
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(com.huawei.openalliance.ad.inter.data.p pVar) {
        this.Code = pVar != null ? pVar.l() : null;
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(final com.huawei.openalliance.ad.inter.data.r rVar) {
        if (rVar == null) {
            return;
        }
        ge.V(B(), "checkVideoHash");
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.jt.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                final boolean I = rVar.I();
                String Z = rVar.Z();
                if (TextUtils.isEmpty(Z) || !Z.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.at.z, rVar.Z());
                            com.huawei.openalliance.ad.ipc.g.V(jt.this.V).Code(com.huawei.openalliance.ad.constant.p.h, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jt.1.2
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
                                        return;
                                    }
                                    ge.V(jt.this.B(), "got video cached url");
                                    rVar.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.jt.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ge.Code(jt.this.B(), "video path: %s", rVar.e());
                                    ((lo) jt.this.I()).Code(rVar, I);
                                }
                            };
                        } catch (JSONException e) {
                            ge.Code(jt.this.B(), "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.jt.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ge.Code(jt.this.B(), "video path: %s", rVar.e());
                                    ((lo) jt.this.I()).Code(rVar, I);
                                }
                            };
                        }
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jt.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ge.Code(jt.this.B(), "video path: %s", rVar.e());
                                ((lo) jt.this.I()).Code(rVar, I);
                            }
                        });
                        throw th;
                    }
                } else {
                    runnable = new Runnable() { // from class: com.huawei.hms.ads.jt.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ge.V(jt.this.B(), "video is cached.");
                            ((lo) jt.this.I()).Code(rVar, I);
                        }
                    };
                }
                com.huawei.openalliance.ad.utils.ba.Code(runnable);
                if (2 == rVar.c() || rVar.I()) {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jt.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ((lo) jt.this.I()).Code(rVar, true);
                        }
                    });
                }
            }
        });
    }
}
