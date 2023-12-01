package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/g.class */
public final class g {
    private static f a(Context context) {
        return Build.VERSION.SDK_INT < 21 ? new h() : (w.a() && i.a(context)) ? new i() : new j();
    }
}
