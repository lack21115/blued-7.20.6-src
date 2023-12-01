package com.blued.android.module.live.base.view.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/ImageViewState.class */
public class ImageViewState implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final float f11552a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f11553c;
    private final int d;

    public ImageViewState(float f, PointF pointF, int i) {
        this.f11552a = f;
        this.b = pointF.x;
        this.f11553c = pointF.y;
        this.d = i;
    }

    public float a() {
        return this.f11552a;
    }

    public PointF b() {
        return new PointF(this.b, this.f11553c);
    }

    public int c() {
        return this.d;
    }
}
