package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/CustomDurationScroller.class */
public class CustomDurationScroller extends Scroller {

    /* renamed from: a  reason: collision with root package name */
    private double f14252a;

    public CustomDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f14252a = 1.0d;
    }

    public void a(double d) {
        this.f14252a = d;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (i5 * this.f14252a));
    }
}
