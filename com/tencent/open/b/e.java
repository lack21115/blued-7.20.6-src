package com.tencent.open.b;

import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/b/e.class */
public class e {
    public static int a() {
        int i = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_HttpRetryCount");
        int i2 = i;
        if (i == 0) {
            i2 = 2;
        }
        return i2;
    }

    public static int a(String str) {
        int i = OpenConfig.getInstance(Global.getContext(), str).getInt("Common_BusinessReportFrequency");
        int i2 = i;
        if (i == 0) {
            i2 = 100;
        }
        return i2;
    }
}
