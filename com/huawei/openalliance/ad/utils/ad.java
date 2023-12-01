package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ad.class */
public abstract class ad {
    private static final String Code = "LogTool";

    public static void Code(Context context, int i, String str) {
        int i2 = i;
        if (i < 4) {
            i2 = 4;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            String Code2 = ar.Code(context);
            str2 = Code2;
            if (TextUtils.isEmpty(Code2)) {
                ge.I(Code, "enable log failed, due to root path is null");
                return;
            }
        }
        ge.Code(i2, str2, "HiAd");
    }
}
