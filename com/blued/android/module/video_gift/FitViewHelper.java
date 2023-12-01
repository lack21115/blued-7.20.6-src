package com.blued.android.module.video_gift;

import android.graphics.Point;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/FitViewHelper.class */
public class FitViewHelper {
    private int b;
    private int c;
    private int d;
    private int e;
    private float a = 0.5625f;
    private ScaleType f = ScaleType.CENTER_CROP;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/FitViewHelper$ScaleType.class */
    public enum ScaleType {
        FIT_CENTER,
        FIT_WIDTH,
        FIT_HEIGHT,
        CENTER_CROP,
        CENTER_INSIDE
    }

    private Point b(int i, int i2) {
        float f;
        float f2;
        float f3;
        int i3 = this.b;
        int i4 = i;
        int i5 = i2;
        if (i3 != 0) {
            int i6 = this.c;
            i4 = i;
            i5 = i2;
            if (i6 != 0) {
                i4 = i3;
                i5 = i6;
            }
        }
        if (i4 > i5 * this.a) {
            i4 = (int) ((f2 * f3) + 0.5d);
        } else {
            i5 = (int) ((f / f3) + 0.5d);
        }
        return new Point(i4, i5);
    }

    private Point c(int i, int i2) {
        int i3;
        int i4 = this.b;
        if (i4 != 0 && this.c != 0) {
            i3 = (int) ((i4 / this.a) + 0.5d);
            i = i4;
        } else if (i == 0 || i2 == 0) {
            i = 0;
            i3 = 0;
        } else {
            i3 = (int) ((i / this.a) + 0.5d);
        }
        return new Point(i, i3);
    }

    private Point d(int i, int i2) {
        int i3;
        int i4;
        if (this.b != 0 && (i4 = this.c) != 0) {
            i3 = (int) ((i4 * this.a) + 0.5d);
            i2 = i4;
        } else if (i == 0 || i2 == 0) {
            i2 = 0;
            i3 = 0;
        } else {
            i3 = (int) ((i2 * this.a) + 0.5d);
        }
        return new Point(i3, i2);
    }

    private Point e(int i, int i2) {
        float f;
        float f2;
        float f3;
        int i3;
        float f4;
        int i4 = this.b;
        if (i4 != 0 && (i3 = this.c) != 0) {
            if (this.a > (i4 * 1.0f) / i3) {
                i = (int) ((i3 * f4) + 0.5d);
                i2 = i3;
            } else {
                i2 = (int) ((i4 / f4) + 0.5d);
                i = i4;
            }
        } else if (i == 0 || i2 == 0) {
            i = 0;
            i2 = 0;
        } else {
            if (this.a > (1.0f * i) / i2) {
                i = (int) ((f3 * f) + 0.5d);
            } else {
                i2 = (int) ((f2 / f) + 0.5d);
            }
        }
        return new Point(i, i2);
    }

    public int a() {
        return this.d;
    }

    public void a(ScaleType scaleType) {
        this.f = scaleType;
    }

    public boolean a(float f, int i, int i2) {
        if (f <= 0.0d || i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (this.a == f && this.b == i && this.c == i2) {
            return false;
        }
        this.a = f;
        this.b = i;
        this.c = i2;
        return a(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, int i2) {
        boolean z = false;
        if (this.f == ScaleType.CENTER_INSIDE) {
            this.d = i;
            this.e = i2;
            return false;
        }
        Point b = this.f == ScaleType.FIT_CENTER ? b(i, i2) : this.f == ScaleType.FIT_WIDTH ? c(i, i2) : this.f == ScaleType.FIT_HEIGHT ? d(i, i2) : e(i, i2);
        if (b.x != this.d || b.y != this.e) {
            z = true;
        }
        this.d = b.x;
        this.e = b.y;
        return z;
    }

    public int b() {
        return this.e;
    }
}
