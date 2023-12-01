package com.huawei.openalliance.ad.views;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.fl;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.constant.bc;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/ScanningRelativeLayout.class */
public class ScanningRelativeLayout extends AutoScaleSizeRelativeLayout {
    private int B;
    private int C;
    private Paint D;
    private Bitmap F;
    private Paint L;
    private Bitmap S;

    /* renamed from: a  reason: collision with root package name */
    private float f9430a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f9431c;
    private ValueAnimator d;
    private PorterDuffXfermode e;

    public ScanningRelativeLayout(Context context) {
        super(context);
        B();
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningRelativeLayout);
        this.B = obtainStyledAttributes.getResourceId(R.styleable.ScanningRelativeLayout_layoutScanImage, R.drawable.hiad_scan);
        this.C = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ScanningRelativeLayout_layoutRadius, 36);
        obtainStyledAttributes.recycle();
        B();
    }

    private void B() {
        ge.V("ScanningRelativeLayout", "init");
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.B);
            this.F = decodeResource;
            float f = -decodeResource.getWidth();
            this.b = f;
            this.f9430a = f;
            Paint paint = new Paint(1);
            this.L = paint;
            paint.setDither(true);
            this.L.setFilterBitmap(true);
            Paint paint2 = new Paint(1);
            this.D = paint2;
            paint2.setDither(true);
            this.D.setStyle(Paint.Style.FILL);
            this.D.setColor(-1);
            this.D.setFilterBitmap(true);
            this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } catch (Throwable th) {
            ge.I("ScanningRelativeLayout", "init exception: %s", th.getClass().getSimpleName());
        }
    }

    private void C() {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        try {
            this.S = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.S).drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), v.V(getContext(), this.C), v.V(getContext(), this.C), this.D);
        } catch (Throwable th) {
            ge.I("ScanningRelativeLayout", "createBitMapException: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, this.b), Keyframe.ofFloat(1.0f, this.f9431c)));
            this.d = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new fl(0.2f, 0.0f, 0.2f, 1.0f));
            this.d.setDuration(com.igexin.push.config.c.j);
            this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ScanningRelativeLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ScanningRelativeLayout.this.f9430a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ScanningRelativeLayout.this.postInvalidate();
                }
            });
        } catch (Throwable th) {
            ge.I("ScanningRelativeLayout", "init animator exception: %s", th.getClass().getSimpleName());
        }
    }

    public void Code() {
        ge.V("ScanningRelativeLayout", bc.b.Code);
        try {
            if (this.d == null) {
                S();
            } else if (this.d.isRunning()) {
                this.d.cancel();
            }
        } catch (Throwable th) {
            ge.I("ScanningRelativeLayout", "prepare scan exception: %s", th.getClass().getSimpleName());
        }
    }

    public void I() {
        ge.V("ScanningRelativeLayout", "stop");
        try {
            if (this.d != null && this.d.isRunning()) {
                this.d.cancel();
            }
        } catch (Throwable th) {
            ge.I("ScanningRelativeLayout", "cancel animation exception: %s", th.getClass().getSimpleName());
        }
        this.f9430a = this.b;
        postInvalidate();
    }

    public void V() {
        ge.V("ScanningRelativeLayout", "start");
        post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningRelativeLayout.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanningRelativeLayout.this.d == null) {
                        ScanningRelativeLayout.this.S();
                    } else if (ScanningRelativeLayout.this.d.isRunning()) {
                        ScanningRelativeLayout.this.d.cancel();
                    }
                    ScanningRelativeLayout.this.d.start();
                } catch (Throwable th) {
                    ge.I("ScanningRelativeLayout", "start scan exception: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.S == null) {
            return;
        }
        try {
            canvas.drawBitmap(this.F, this.f9430a, 0.0f, this.L);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.L, 31);
            this.L.setXfermode(this.e);
            canvas.drawBitmap(this.S, 0.0f, 0.0f, this.L);
            this.L.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            ge.I("ScanningRelativeLayout", "dispatchDraw exception: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.d.cancel();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C();
        this.f9431c = i;
    }

    public void setRadius(int i) {
        this.C = i;
        setRectCornerRadius(v.V(getContext(), i));
    }
}
