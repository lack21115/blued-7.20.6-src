package com.soft.blued.customview.capricorn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/capricorn/ArcLayout.class */
public class ArcLayout extends ViewGroup {
    private static int f = 100;

    /* renamed from: a  reason: collision with root package name */
    private int f28563a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28564c;
    private float d;
    private float e;
    private int g;
    private boolean h;
    private View i;
    private OnExpandListener j;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/capricorn/ArcLayout$OnExpandListener.class */
    public interface OnExpandListener {
        void a(boolean z);
    }

    public ArcLayout(Context context) {
        super(context);
        this.b = 5;
        this.f28564c = 10;
        this.d = 270.0f;
        this.e = 360.0f;
        this.h = false;
    }

    public ArcLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 5;
        this.f28564c = 10;
        this.d = 270.0f;
        this.e = 360.0f;
        this.h = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ArcLayout, 0, 0);
            this.d = obtainStyledAttributes.getFloat(1, 270.0f);
            this.e = obtainStyledAttributes.getFloat(2, 360.0f);
            this.f28563a = Math.max(obtainStyledAttributes.getDimensionPixelSize(0, 0), 0);
            f = DensityUtils.a(context, 100.0f);
            obtainStyledAttributes.recycle();
        }
    }

    private static int a(float f2, int i, int i2, int i3, int i4) {
        if (i < 2) {
            return i4;
        }
        return Math.max((int) (((i2 + i3) / 2) / Math.sin(Math.toRadians((f2 / (i - 1)) / 2.0f))), i4);
    }

    private static int a(boolean z, int i, int i2) {
        return z ? (i - 1) - i2 : i2;
    }

    private static long a(int i, boolean z, int i2, float f2, long j, Interpolator interpolator) {
        float f3 = f2 * ((float) j);
        long a2 = a(z, i, i2) * f3;
        float f4 = f3 * i;
        return interpolator.getInterpolation(((float) a2) / f4) * f4;
    }

    private static Rect a(int i, int i2, int i3, float f2, int i4) {
        double d = i3;
        double d2 = f2;
        double cos = i + (Math.cos(Math.toRadians(d2)) * d);
        double sin = i2 + (d * Math.sin(Math.toRadians(d2)));
        double d3 = i4 / 2;
        return new Rect((int) (cos - d3), (int) (sin - d3), (int) (cos + d3), (int) (sin + d3));
    }

    private static Animation a(float f2, float f3, float f4, float f5, long j, long j2, Interpolator interpolator) {
        RotateAndTranslateAnimation rotateAndTranslateAnimation = new RotateAndTranslateAnimation(0.0f, f3, 0.0f, f5, 0.0f, 0.0f);
        rotateAndTranslateAnimation.setStartOffset(j);
        rotateAndTranslateAnimation.setDuration(j2);
        rotateAndTranslateAnimation.setInterpolator(interpolator);
        rotateAndTranslateAnimation.setFillAfter(true);
        return rotateAndTranslateAnimation;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r11, int r12, long r13) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.capricorn.ArcLayout.a(android.view.View, int, long):void");
    }

    private static Animation b(float f2, float f3, float f4, float f5, long j, long j2, Interpolator interpolator) {
        long j3 = j2 / 2;
        RotateAndTranslateAnimation rotateAndTranslateAnimation = new RotateAndTranslateAnimation(0.0f, f3, 0.0f, f5, 0.0f, 0.0f);
        rotateAndTranslateAnimation.setStartOffset(j + j3);
        rotateAndTranslateAnimation.setDuration(j2 - j3);
        rotateAndTranslateAnimation.setInterpolator(interpolator);
        rotateAndTranslateAnimation.setFillAfter(true);
        return rotateAndTranslateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                this.h = !this.h;
                requestLayout();
                return;
            }
            getChildAt(i2).clearAnimation();
            i = i2 + 1;
        }
    }

    public void a(float f2, float f3) {
        if (this.d == f2 && this.e == f3) {
            return;
        }
        this.d = f2;
        this.e = f3;
        requestLayout();
    }

    public void a(OnExpandListener onExpandListener, View view) {
        this.j = onExpandListener;
        this.i = view;
    }

    public void a(boolean z) {
        OnExpandListener onExpandListener = this.j;
        if (onExpandListener != null && z) {
            onExpandListener.a(!a());
            this.i.setSelected(!a());
        }
        if (z) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                a(getChildAt(i2), i2, 200L);
                i = i2 + 1;
            }
        }
        if (!z) {
            this.h = !this.h;
            requestLayout();
        }
        invalidate();
    }

    public boolean a() {
        return this.h;
    }

    public void b(boolean z) {
        if (!z) {
            OnExpandListener onExpandListener = this.j;
            if (onExpandListener != null) {
                onExpandListener.a(!a());
                this.i.setSelected(!a());
                invalidate();
                return;
            }
            return;
        }
        this.h = !this.h;
        OnExpandListener onExpandListener2 = this.j;
        if (onExpandListener2 != null) {
            onExpandListener2.a(a());
            this.i.setSelected(a());
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                requestLayout();
                invalidate();
                return;
            }
            getChildAt(i2).clearAnimation();
            i = i2 + 1;
        }
    }

    public int getChildSize() {
        return this.f28563a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int i5 = this.h ? this.g : 0;
        int childCount = getChildCount();
        float f2 = this.e;
        float f3 = this.d;
        float f4 = (f2 - f3) / (childCount - 1);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= childCount) {
                return;
            }
            Rect a2 = a(width, height, i5, f3, this.f28563a);
            f3 += f4;
            if (childCount != 2 || !this.h) {
                getChildAt(i7).layout(a2.left, a2.top, a2.right, a2.bottom);
            } else if (i7 == 0) {
                getChildAt(i7).layout(a2.left, a2.top - 50, a2.right, a2.bottom);
            } else {
                getChildAt(i7).layout(a2.left - 50, a2.top, a2.right, a2.bottom);
            }
            getChildAt(i7).setVisibility(this.h ? 0 : 4);
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int a2 = a(Math.abs(this.e - this.d), getChildCount(), this.f28563a, this.b, f);
        this.g = a2;
        int i3 = (a2 * 2) + this.f28563a + this.b + (this.f28564c * 2);
        setMeasuredDimension(i3, i3);
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= childCount) {
                return;
            }
            getChildAt(i5).measure(View.MeasureSpec.makeMeasureSpec(this.f28563a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f28563a, 1073741824));
            i4 = i5 + 1;
        }
    }

    public void setChildSize(int i) {
        if (this.f28563a == i || i < 0) {
            return;
        }
        this.f28563a = i;
        requestLayout();
    }
}
