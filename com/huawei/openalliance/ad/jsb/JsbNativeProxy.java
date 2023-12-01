package com.huawei.openalliance.ad.jsb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.af;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/jsb/JsbNativeProxy.class */
public class JsbNativeProxy extends af {
    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String V = ah.V(str);
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(V)) {
            f.Code(new ah.a(context, fn.Code().Code(V), V, str, remoteCallResultCallback));
            return;
        }
        ge.Z("JsbNativeProxy", "param is invalid, please check it!");
        af.Code(remoteCallResultCallback, V, -1, null, true);
    }
}
