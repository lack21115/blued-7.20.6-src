package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.blued.android.framework.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetGuideShadeView.class */
public final class LivePlanetGuideShadeView extends View {
    private final Context a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final float t;
    private float u;
    private Paint v;
    private Paint w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetGuideShadeView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = DensityUtils.a(getContext(), 10.0f);
        this.v = new Paint();
        this.w = new Paint();
        this.v.setAntiAlias(true);
        this.v.setDither(true);
        this.v.setARGB(204, 0, 0, 0);
        this.v.setStyle(Paint.Style.FILL);
        this.w.setAntiAlias(true);
        this.w.setDither(true);
        this.w.setARGB(255, 0, 0, 0);
        this.w.setStyle(Paint.Style.FILL);
        this.w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
    }

    private final void a(int i, int i2) {
        this.b = i;
        this.c = i2;
        invalidate();
    }

    private final void a(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.b, this.c);
        if (canvas == null) {
            return;
        }
        canvas.drawRect(rectF, this.v);
    }

    private final void b(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.l;
        float f = i3;
        float f2 = i3 - this.d;
        float f3 = 1;
        float f4 = this.u;
        float f5 = f - (f2 * (f3 - f4));
        float f6 = this.m - ((i - this.e) * (f3 - f4));
        int i4 = this.n;
        RectF rectF = new RectF(f5, f6, (i4 - ((i4 - this.f) * (f3 - f4))) + f5, (this.o - ((i2 - this.g) * (f3 - f4))) + f6);
        if (canvas == null) {
            return;
        }
        float f7 = this.t;
        canvas.drawRoundRect(rectF, f7, f7, this.w);
    }

    private final void c(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.p;
        float f = i3;
        float f2 = i3 - this.h;
        float f3 = 1;
        float f4 = this.u;
        float f5 = f - (f2 * (f3 - f4));
        float f6 = this.q - ((i - this.i) * (f3 - f4));
        int i4 = this.r;
        RectF rectF = new RectF(f5, f6, (i4 - ((i4 - this.j) * (f3 - f4))) + f5, (this.s - ((i2 - this.k) * (f3 - f4))) + f6);
        if (canvas == null) {
            return;
        }
        float f7 = this.t;
        canvas.drawRoundRect(rectF, f7, f7, this.w);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.p = i5;
        this.q = i6;
        this.r = i7;
        this.s = i8;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", 0.0f, 1.0f);
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.start();
    }

    public final void a(int i, int i2, int i3, int i4, long j, long j2) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", 0.0f, 1.0f);
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.start();
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.p = i;
        this.q = i2;
        this.r = i3;
        this.s = i4;
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public final Paint getCutoutPaint() {
        return this.w;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final float getProgress() {
        return this.u;
    }

    public final Paint getShadePaint() {
        return this.v;
    }

    public final int getTargetH() {
        return this.o;
    }

    public final int getTargetH_2() {
        return this.s;
    }

    public final int getTargetW() {
        return this.n;
    }

    public final int getTargetW_2() {
        return this.r;
    }

    public final int getTargetX() {
        return this.l;
    }

    public final int getTargetX_2() {
        return this.p;
    }

    public final int getTargetY() {
        return this.m;
    }

    public final int getTargetY_2() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        if (this.p <= 0 || this.q <= 0) {
            return;
        }
        c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
    }

    public final void setCutoutPaint(Paint paint) {
        Intrinsics.e(paint, "<set-?>");
        this.w = paint;
    }

    public final void setProgress(float f) {
        this.u = f;
        invalidate();
    }

    public final void setShadePaint(Paint paint) {
        Intrinsics.e(paint, "<set-?>");
        this.v = paint;
    }

    public final void setTargetH(int i) {
        this.o = i;
    }

    public final void setTargetH_2(int i) {
        this.s = i;
    }

    public final void setTargetW(int i) {
        this.n = i;
    }

    public final void setTargetW_2(int i) {
        this.r = i;
    }

    public final void setTargetX(int i) {
        this.l = i;
    }

    public final void setTargetX_2(int i) {
        this.p = i;
    }

    public final void setTargetY(int i) {
        this.m = i;
    }

    public final void setTargetY_2(int i) {
        this.q = i;
    }
}
