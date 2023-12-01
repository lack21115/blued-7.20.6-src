package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jq.class */
public class jq extends jn<li> implements kc {

    /* renamed from: com.huawei.hms.ads.jq$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jq$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.at.z, this.Code);
                com.huawei.openalliance.ad.ipc.g.V(jq.this.V).Code(com.huawei.openalliance.ad.constant.p.h, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jq.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        final String data = callResult.getData();
                        if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
                            return;
                        }
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jq.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((li) jq.this.I()).Code(data);
                            }
                        });
                    }
                }, String.class);
            } catch (JSONException e) {
                ge.Code("PPSVideoViewPresenter", "check video cache jsonEx");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jq.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((li) jq.this.I()).Code(AnonymousClass1.this.Code);
                    }
                });
            }
        }
    }

    public jq(Context context, li liVar) {
        super(context, liVar);
    }

    @Override // com.huawei.hms.ads.kc
    public void C() {
        ko.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ac.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kc
    public void Code(long j, long j2, long j3, long j4) {
        ko.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ac.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.kc
    public void Code(boolean z) {
        AdEventReport Code = ko.Code(this.Code);
        Code.V(z);
        com.huawei.openalliance.ad.ipc.g.V(this.V).Code(com.huawei.openalliance.ad.constant.p.i, com.huawei.openalliance.ad.utils.z.V(Code), null, null);
    }

    @Override // com.huawei.hms.ads.jn
    protected void V(String str) {
        ((li) I()).B();
        ge.V("PPSVideoViewPresenter", "onMaterialLoaded - begin to load video");
        if (TextUtils.isEmpty(str) || !str.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString())) {
            ge.V("PPSVideoViewPresenter", "check if video cached.");
            com.huawei.openalliance.ad.utils.f.I(new AnonymousClass1(str));
            return;
        }
        ge.V("PPSVideoViewPresenter", "video is cached.");
        ((li) I()).Code(str);
    }
}
