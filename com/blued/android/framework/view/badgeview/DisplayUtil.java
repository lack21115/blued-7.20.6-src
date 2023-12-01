package com.blued.android.framework.view.badgeview;

import android.content.Context;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/DisplayUtil.class */
public class DisplayUtil {
    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
