package com.jungly.gridpasswordview;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/Util.class */
public class Util {
    public static int a(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5d);
    }
}
