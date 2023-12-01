package com.blued.android.module.yy_china.view.ban;

import android.content.Context;
import android.widget.Scroller;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABannerScroller.class */
public class BGABannerScroller extends Scroller {

    /* renamed from: a  reason: collision with root package name */
    private int f18613a;

    public BGABannerScroller(Context context, int i) {
        super(context);
        this.f18613a = 1000;
        this.f18613a = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f18613a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f18613a);
    }
}
