package com.blued.android.module.live_china.view;

import android.animation.Animator;
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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePushGuideShadeView.class */
public final class LivePushGuideShadeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14880a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14881c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final float l;
    private boolean m;
    private float n;
    private Paint o;
    private Paint p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePushGuideShadeView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.f14880a = mContext;
        this.l = DensityUtils.a(getContext(), 6.0f);
        this.o = new Paint();
        this.p = new Paint();
        this.o.setAntiAlias(true);
        this.o.setDither(true);
        this.o.setARGB(255, 0, 0, 0);
        this.o.setStyle(Paint.Style.FILL);
        this.p.setAntiAlias(true);
        this.p.setDither(true);
        this.p.setARGB(255, 0, 0, 0);
        this.p.setStyle(Paint.Style.FILL);
        this.p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
    }

    private final void a(int i, int i2) {
        this.b = i;
        this.f14881c = i2;
        invalidate();
    }

    private final void a(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.b, this.f14881c);
        if (canvas == null) {
            return;
        }
        canvas.drawRect(rectF, this.o);
    }

    private final void b(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.h;
        float f = i3;
        float f2 = i3 - this.d;
        float f3 = 1;
        float f4 = this.n;
        float f5 = f - (f2 * (f3 - f4));
        float f6 = this.i - ((i - this.e) * (f3 - f4));
        int i4 = this.j;
        RectF rectF = new RectF(f5, f6, (i4 - ((i4 - this.f) * (f3 - f4))) + f5, (this.k - ((i2 - this.g) * (f3 - f4))) + f6);
        if (canvas == null) {
            return;
        }
        float f7 = this.l;
        canvas.drawRoundRect(rectF, f7, f7, this.p);
    }

    public final void a(final int i, final int i2, final int i3, final int i4) {
        int i5;
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        if (this.d == 0 && this.e == 0 && this.f == 0 && this.g == 0) {
            this.d = (Math.min(i3, i4) / 2) + i;
            this.e = (Math.min(i3, i4) / 2) + i2;
            i5 = 800;
        } else {
            i5 = 1300;
        }
        ObjectAnimator anim = ObjectAnimator.ofFloat(this, "progress", 0.0f, 1.0f);
        anim.setDuration(i5);
        anim.setInterpolator(new DecelerateInterpolator(2.5f));
        Intrinsics.c(anim, "anim");
        anim.addListener(new Animator.AnimatorListener(i, i2, i3, i4, this) { // from class: com.blued.android.module.live_china.view.LivePushGuideShadeView$gotoTarget$$inlined$addListener$default$1
            final /* synthetic */ int b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f14883c;
            final /* synthetic */ int d;
            final /* synthetic */ int e;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.e(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.e(animator, "animator");
                LivePushGuideShadeView.this.d = this.b;
                LivePushGuideShadeView.this.e = this.f14883c;
                LivePushGuideShadeView.this.f = this.d;
                LivePushGuideShadeView.this.g = this.e;
                LivePushGuideShadeView.this.setAnimIng(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.e(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.e(animator, "animator");
                LivePushGuideShadeView.this.setAnimIng(true);
            }
        });
        anim.start();
    }

    public final boolean a() {
        return this.m;
    }

    public final Paint getCutoutPaint() {
        return this.p;
    }

    public final Context getMContext() {
        return this.f14880a;
    }

    public final float getProgress() {
        return this.n;
    }

    public final Paint getShadePaint() {
        return this.o;
    }

    public final int getTargetH() {
        return this.k;
    }

    public final int getTargetW() {
        return this.j;
    }

    public final int getTargetX() {
        return this.h;
    }

    public final int getTargetY() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j > 0 || this.k > 0) {
            a(canvas);
            b(canvas);
        }
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

    public final void setAnimIng(boolean z) {
        this.m = z;
    }

    public final void setCutoutPaint(Paint paint) {
        Intrinsics.e(paint, "<set-?>");
        this.p = paint;
    }

    public final void setProgress(float f) {
        this.n = f;
        invalidate();
    }

    public final void setShadePaint(Paint paint) {
        Intrinsics.e(paint, "<set-?>");
        this.o = paint;
    }

    public final void setTargetH(int i) {
        this.k = i;
    }

    public final void setTargetW(int i) {
        this.j = i;
    }

    public final void setTargetX(int i) {
        this.h = i;
    }

    public final void setTargetY(int i) {
        this.i = i;
    }
}
