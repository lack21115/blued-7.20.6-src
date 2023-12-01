package com.blued.android.module.live.base.view.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/ImageViewState.class */
public class ImageViewState implements Serializable {
    private final float a;
    private final float b;
    private final float c;
    private final int d;

    public ImageViewState(float f, PointF pointF, int i) {
        this.a = f;
        this.b = pointF.x;
        this.c = pointF.y;
        this.d = i;
    }

    public float a() {
        return this.a;
    }

    public PointF b() {
        return new PointF(this.b, this.c);
    }

    public int c() {
        return this.d;
    }
}
