package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z9.class */
public class z9 {
    public static int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
