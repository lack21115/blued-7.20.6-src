package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.fl;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/ScanningView.class */
public class ScanningView extends View {
    private Bitmap B;
    private Bitmap C;
    private PorterDuffXfermode D;
    private Paint F;
    private int I;
    private float L;
    private Paint S;

    /* renamed from: a  reason: collision with root package name */
    private float f9432a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator f9433c;
    private Animator.AnimatorListener d;

    public ScanningView(Context context) {
        super(context);
        Z();
    }

    public ScanningView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Z();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningView);
        this.I = obtainStyledAttributes.getResourceId(R.styleable.ScanningView_lightImage, R.drawable.hiad_arrow_scan);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f9432a, this.b);
        this.f9433c = ofFloat;
        ofFloat.setInterpolator(new fl(0.33f, 0.0f, 0.67f, 1.0f));
        this.f9433c.setDuration(2500L);
        this.f9433c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ScanningView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanningView.this.L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanningView.this.postInvalidate();
            }
        });
        this.f9433c.addListener(new AnimatorListenerAdapter() { // from class: com.huawei.openalliance.ad.views.ScanningView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.d != null) {
                    ScanningView.this.d.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.d != null) {
                    ScanningView.this.d.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ScanningView.this.setVisibility(0);
                if (ScanningView.this.d != null) {
                    ScanningView.this.d.onAnimationStart(animator);
                }
            }
        });
    }

    private void I() {
        this.C = BitmapFactory.decodeResource(getResources(), this.I);
    }

    private void Z() {
        Paint paint = new Paint(1);
        this.S = paint;
        paint.setDither(true);
        this.S.setFilterBitmap(true);
        Paint paint2 = new Paint(1);
        this.F = paint2;
        paint2.setDither(true);
        this.F.setStyle(Paint.Style.FILL);
        this.F.setColor(-1);
        this.F.setFilterBitmap(true);
        this.D = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public void Code() {
        if (this.B == null) {
            ge.V("ScanningView", "start, mSrcBitmap is null");
        } else {
            post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ScanningView.this.f9433c == null) {
                        ScanningView.this.B();
                    } else if (ScanningView.this.f9433c.isRunning()) {
                        ScanningView.this.f9433c.cancel();
                    }
                    ScanningView.this.f9433c.start();
                }
            });
        }
    }

    public void V() {
        ValueAnimator valueAnimator = this.f9433c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f9433c.cancel();
        }
        this.L = this.f9432a;
        postInvalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.B == null) {
            return;
        }
        try {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.S, 31);
            canvas.drawBitmap(this.C, 0.0f, this.L, this.S);
            this.S.setXfermode(this.D);
            canvas.drawBitmap(this.B, 0.0f, 0.0f, this.S);
            this.S.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            ge.I("ScanningView", "draw exception: %s", th.getClass().getSimpleName());
        }
        super.draw(canvas);
    }

    public Bitmap getSrcBitmap() {
        return this.B;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        I();
        float f = i2;
        this.f9432a = f;
        this.L = f;
        this.b = -i2;
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.d = animatorListener;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.B = bitmap;
    }
}
