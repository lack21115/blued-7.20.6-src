package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/t.class */
public class t {
    private static final String Code = "HarmonyUtils";
    private static final int V = 1048576;

    private static boolean Code(int i) {
        return (i & 1048576) != 0;
    }

    public static boolean Code(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Code(new n().Code(e.S(context.getApplicationContext(), str), context));
        } catch (Throwable th) {
            ge.I(Code, "isHarmonyApp exception");
            return false;
        }
    }
}
