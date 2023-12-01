package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/d.class */
public class d {
    private static final String Code = "AdSourceUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/d$a.class */
    public static class a implements RemoteCallResultCallback<String> {
        private final WeakReference<Context> Code;

        public a(Context context) {
            this.Code = new WeakReference<>(context);
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            Context context = this.Code.get();
            if (context == null || TextUtils.isEmpty(data) || !data.startsWith(bm.CONTENT.toString())) {
                return;
            }
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.I(data);
            y.Code(context, sourceParam, (aj) null);
        }
    }

    public static void Code(Context context, AdContentData adContentData) {
        AdSource Code2;
        if (adContentData != null) {
            try {
                if (adContentData.Z() == null || adContentData.Z().i() == null || (Code2 = AdSource.Code(adContentData.Z().i())) == null || Code2.V() == null) {
                    return;
                }
                ge.V(Code, "preloadDspLogo");
                String V = Code2.V();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.at.z, V);
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.p.h, jSONObject.toString(), new a(context), String.class);
            } catch (Throwable th) {
                ge.I(Code, "preloadDspLogo error");
            }
        }
    }
}
