package com.huawei.openalliance.ad.jsb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ac;
import com.huawei.hms.ads.af;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.fm;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/jsb/JsbInterstitialProxy.class */
public class JsbInterstitialProxy extends af {
    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String V = ah.V(str);
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(V)) {
            ge.Z("JsbInterstitialProxy", "param is invalid, please check it!");
            af.Code(remoteCallResultCallback, V, -1, null, true);
            return;
        }
        ac Code = fm.Code().Code(V);
        if (Code != null) {
            if (ah.Code().Code(V, Code(context))) {
                Code.Code((Activity) Code(context));
            }
            Code.Code(this.V);
        }
        f.Code(new ah.a(context, Code, V, str, remoteCallResultCallback));
    }
}
