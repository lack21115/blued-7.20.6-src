package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/util/DensityUtil.class */
public class DensityUtil {

    /* renamed from: a  reason: collision with root package name */
    public float f27998a = Resources.getSystem().getDisplayMetrics().density;

    public static float a(int i) {
        return i / Resources.getSystem().getDisplayMetrics().density;
    }

    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public int b(float f) {
        return (int) ((f * this.f27998a) + 0.5f);
    }
}
