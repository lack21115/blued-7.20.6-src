package com.opos.mobad.n.c;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/o.class */
public class o extends Scroller {

    /* renamed from: a  reason: collision with root package name */
    private int f26625a;

    public o(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f26625a = 1000;
    }

    public void a(int i) {
        this.f26625a = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f26625a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f26625a);
    }
}
