package com.cmic.gen.sdk.tencent.e;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/g.class */
public class g {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
