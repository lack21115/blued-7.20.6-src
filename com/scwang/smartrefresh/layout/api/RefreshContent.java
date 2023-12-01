package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/api/RefreshContent.class */
public interface RefreshContent {
    ValueAnimator.AnimatorUpdateListener a(int i);

    View a();

    void a(int i, int i2, int i3);

    void a(MotionEvent motionEvent);

    void a(RefreshKernel refreshKernel, View view, View view2);

    void a(ScrollBoundaryDecider scrollBoundaryDecider);

    void a(boolean z);

    View b();

    boolean c();

    boolean d();
}
