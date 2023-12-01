package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ap.class */
public class ap extends af {
    private static final String Z = "CmdBaseDownload";

    public ap(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IAppDownloadManager V(Context context, String str) {
        IAppDownloadManager Code = com.huawei.hms.ads.jsb.a.Code(context).Code();
        Code.Code(B(str));
        if (com.huawei.openalliance.ad.utils.v.B(context)) {
            Code.Code(true);
        }
        return Code;
    }
}
