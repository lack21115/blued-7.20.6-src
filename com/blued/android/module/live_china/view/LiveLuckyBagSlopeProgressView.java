package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.ColorUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveLuckyBagSlopeProgressView.class */
public final class LiveLuckyBagSlopeProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f14500a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14501c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private float k;
    private float l;
    private Paint m;
    private final DecelerateInterpolator n;
    private final AccelerateInterpolator o;
    private final AccelerateInterpolator p;
    private Bitmap q;
    private Bitmap r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLuckyBagSlopeProgressView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.f14501c = 1000;
        this.k = 100.0f;
        this.n = new DecelerateInterpolator(1.5f);
        this.o = new AccelerateInterpolator(0.5f);
        this.p = new AccelerateInterpolator(1.5f);
        this.b = 0;
        this.e = Color.parseColor("#FF5DB9");
        this.f = Color.parseColor("#C32EDC");
        this.g = Color.parseColor("#FB65FF");
        this.h = Color.parseColor("#8800FF");
        this.i = Color.parseColor("#AB4CFF");
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_top);
        Intrinsics.c(decodeResource, "decodeResource(resources…e_lucky_bag_progress_top)");
        this.q = a(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_bottom);
        Intrinsics.c(decodeResource2, "decodeResource(\n        …ress_bottom\n            )");
        this.r = a(decodeResource2);
        setRotationY(180.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLuckyBagSlopeProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.f14501c = 1000;
        this.k = 100.0f;
        this.n = new DecelerateInterpolator(1.5f);
        this.o = new AccelerateInterpolator(0.5f);
        this.p = new AccelerateInterpolator(1.5f);
        this.b = 0;
        this.e = Color.parseColor("#FF5DB9");
        this.f = Color.parseColor("#C32EDC");
        this.g = Color.parseColor("#FB65FF");
        this.h = Color.parseColor("#8800FF");
        this.i = Color.parseColor("#AB4CFF");
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_top);
        Intrinsics.c(decodeResource, "decodeResource(resources…e_lucky_bag_progress_top)");
        this.q = a(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_bottom);
        Intrinsics.c(decodeResource2, "decodeResource(\n        …ress_bottom\n            )");
        this.r = a(decodeResource2);
        setRotationY(180.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLuckyBagSlopeProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f14501c = 1000;
        this.k = 100.0f;
        this.n = new DecelerateInterpolator(1.5f);
        this.o = new AccelerateInterpolator(0.5f);
        this.p = new AccelerateInterpolator(1.5f);
        this.b = 0;
        this.e = Color.parseColor("#FF5DB9");
        this.f = Color.parseColor("#C32EDC");
        this.g = Color.parseColor("#FB65FF");
        this.h = Color.parseColor("#8800FF");
        this.i = Color.parseColor("#AB4CFF");
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_top);
        Intrinsics.c(decodeResource, "decodeResource(resources…e_lucky_bag_progress_top)");
        this.q = a(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_bottom);
        Intrinsics.c(decodeResource2, "decodeResource(\n        …ress_bottom\n            )");
        this.r = a(decodeResource2);
        setRotationY(180.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLuckyBagSlopeProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.e(context, "context");
        this.f14501c = 1000;
        this.k = 100.0f;
        this.n = new DecelerateInterpolator(1.5f);
        this.o = new AccelerateInterpolator(0.5f);
        this.p = new AccelerateInterpolator(1.5f);
        this.b = 0;
        this.e = Color.parseColor("#FF5DB9");
        this.f = Color.parseColor("#C32EDC");
        this.g = Color.parseColor("#FB65FF");
        this.h = Color.parseColor("#8800FF");
        this.i = Color.parseColor("#AB4CFF");
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_top);
        Intrinsics.c(decodeResource, "decodeResource(resources…e_lucky_bag_progress_top)");
        this.q = a(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.live_lucky_bag_progress_bottom);
        Intrinsics.c(decodeResource2, "decodeResource(\n        …ress_bottom\n            )");
        this.r = a(decodeResource2);
        setRotationY(180.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagSlopeProgressView this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        this$0.d = ((Float) animatedValue).floatValue();
    }

    public final Bitmap a(Bitmap bitmap) {
        Intrinsics.e(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        canvas.drawBitmap(createBitmap2, new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight()), new Rect(0, 0, width, height), (Paint) null);
        return createBitmap;
    }

    public final void a(float f) {
        float min = Math.min(Math.max(0.0f, f), 1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(this.o);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveLuckyBagSlopeProgressView$WKKiFrMVVDEO0yikUUXaviudRdc
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveLuckyBagSlopeProgressView.a(LiveLuckyBagSlopeProgressView.this, valueAnimator);
            }
        });
        ofFloat.start();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "progress", this.b, (int) (this.f14501c * min));
        ofInt.setDuration(500L);
        ofInt.setInterpolator(this.n);
        ofInt.start();
    }

    public final float getLightProgress() {
        return this.d;
    }

    public final float getLine() {
        return this.l;
    }

    public final int getMaxProgress() {
        return this.f14501c;
    }

    public final int getProgress() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.r;
        if (bitmap != null) {
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            int i = this.f14500a;
            canvas.drawBitmap(bitmap, rect, new Rect(0, 0, i, i), (Paint) null);
        }
        if (this.m == null) {
            Paint paint = new Paint();
            this.m = paint;
            Intrinsics.a(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.m;
            Intrinsics.a(paint2);
            paint2.setDither(true);
            Paint paint3 = this.m;
            Intrinsics.a(paint3);
            paint3.setStyle(Paint.Style.STROKE);
            Paint paint4 = this.m;
            Intrinsics.a(paint4);
            paint4.setStrokeCap(Paint.Cap.ROUND);
            Paint paint5 = this.m;
            Intrinsics.a(paint5);
            paint5.setStrokeWidth(this.l);
        }
        float f = this.b / this.f14501c;
        float f2 = 360;
        float f3 = this.j;
        float f4 = this.l;
        float f5 = 2;
        float f6 = (f4 / f5) + f3;
        float f7 = f3 + (f4 / f5);
        float f8 = this.k;
        RectF rectF = new RectF(f6, f7, f6 + f8, f8 + f7);
        int i2 = this.e;
        int a2 = ColorUtil.a(this.f, this.g, this.d);
        int a3 = ColorUtil.a(this.h, this.i, this.d);
        float f9 = -97.0f;
        float f10 = 0.9f;
        if (f > 0.9d) {
            float f11 = 1;
            float interpolation = this.p.getInterpolation(f11 - ((f11 - f) * 10));
            f10 = 0.9f - (0.15f * interpolation);
            f9 = (-97.0f) + (20 * interpolation);
        }
        float min = Math.min(f, f10);
        float f12 = min / f5;
        int i3 = this.f14500a;
        SweepGradient sweepGradient = new SweepGradient(i3 / 2.0f, i3 / 2.0f, new int[]{i2, a2, a3, a3, i2}, new float[]{0.0f, f12, min, f10, 1.0f});
        Matrix matrix = new Matrix();
        int i4 = this.f14500a;
        matrix.setRotate(f9, i4 / 2.0f, i4 / 2.0f);
        sweepGradient.setLocalMatrix(matrix);
        Paint paint6 = this.m;
        Intrinsics.a(paint6);
        paint6.setShader(sweepGradient);
        Paint paint7 = this.m;
        Intrinsics.a(paint7);
        canvas.drawArc(rectF, -90.0f, f2 * f, false, paint7);
        Bitmap bitmap2 = this.q;
        if (bitmap2 == null) {
            return;
        }
        Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        int i5 = this.f14500a;
        canvas.drawBitmap(bitmap2, rect2, new Rect(0, 0, i5, i5), (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.f14500a = min;
        float f = min * 0.0546875f;
        this.j = f;
        float f2 = min;
        float f3 = 2;
        float f4 = (f2 - (f * f3)) * 0.17f;
        this.l = f4;
        this.k = (min - (f * f3)) - f4;
    }

    public final void setLightProgress(float f) {
        this.d = f;
    }

    public final void setLine(float f) {
        this.l = f;
    }

    public final void setMaxProgress(int i) {
        this.f14501c = i;
    }

    public final void setProgress(float f) {
        setProgress((int) (f * this.f14501c));
        invalidate();
    }

    public final void setProgress(int i) {
        this.b = Math.min(Math.max(0, i), this.f14501c);
        invalidate();
    }
}
