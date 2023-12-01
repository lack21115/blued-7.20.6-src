package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/al.class */
public class al extends af {
    private static final String B = "anchorViewX";
    private static final String C = "anchorViewY";
    private static final int D = -1;
    private static final String F = "anchorHeight";
    private static final String S = "anchorWidth";
    private static final String Z = "JsbStartComplianceActivity";

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/al$a.class */
    public static class a implements ab {
        private Context Code;
        private RemoteCallResultCallback<String> I;
        private String V;
        private String Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = context;
            this.V = str;
            this.I = remoteCallResultCallback;
            this.Z = str2;
        }

        @Override // com.huawei.hms.ads.ab
        public void Code(AdContentData adContentData) {
            if (adContentData == null || aa.Code(adContentData.aG())) {
                ge.I(al.Z, "content is null or compliance is null.");
            }
            try {
                JSONObject jSONObject = new JSONObject(this.V);
                int optInt = jSONObject.optInt(al.B, -1);
                int optInt2 = jSONObject.optInt(al.C, -1);
                if (-1 == optInt || -1 == optInt2) {
                    ge.I(al.Z, "invalid anchor loc");
                }
                int optInt3 = jSONObject.optInt(al.S, -1);
                int optInt4 = jSONObject.optInt(al.F, -1);
                if (-1 == optInt3 || -1 == optInt4) {
                    ge.I(al.Z, "invalid anchor size");
                }
                if (ge.Code()) {
                    ge.Code(al.Z, "parse param complete, anchor loc (%s, %s), anchor size (%s, %s)", Integer.valueOf(optInt), Integer.valueOf(optInt2), Integer.valueOf(optInt3), Integer.valueOf(optInt4));
                }
                ComplianceActivity.Code(new b(this.I, this.Z));
                ComplianceActivity.Code(this.Code, new int[]{optInt, optInt2}, new int[]{optInt3, optInt4}, adContentData, true);
            } catch (Throwable th) {
                ge.I(al.Z, "parse param ex: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/al$b.class */
    static class b implements com.huawei.openalliance.ad.activity.b {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.activity.b
        public void Code() {
            ge.V(al.Z, "onActivityShow");
            af.Code(this.V, this.Code, 1000, 5001, false);
        }

        @Override // com.huawei.openalliance.ad.activity.b
        public void V() {
            ge.V(al.Z, "onActivityFinish");
            af.Code(this.V, this.Code, 1000, 5002, false);
            ComplianceActivity.S();
        }
    }

    public al() {
        super(ai.x);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Code(context, str, true, (ab) new a(context, str, remoteCallResultCallback, this.Code));
        } catch (Throwable th) {
            ge.I(Z, "execute ex: %s", th.getClass().getSimpleName());
        }
    }
}
