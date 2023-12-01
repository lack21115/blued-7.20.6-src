package com.blued.android.module.common.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedDurationScroller.class */
public class BluedDurationScroller extends Scroller {
    private double a;

    public BluedDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.a = 1.0d;
    }

    public void a(double d) {
        this.a = d;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (i5 * this.a));
    }
}
