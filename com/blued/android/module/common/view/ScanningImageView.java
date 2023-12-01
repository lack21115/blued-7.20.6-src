package com.blued.android.module.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ScanningImageView.class */
public class ScanningImageView extends ImageView {
    boolean a;
    private long b;
    private int c;
    private Bitmap d;
    private Bitmap e;
    private Paint f;
    private Paint g;
    private PorterDuffXfermode h;
    private float i;
    private float j;
    private float k;
    private ValueAnimator l;
    private OnEventCallBack m;
    private View n;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ScanningImageView$OnEventCallBack.class */
    public interface OnEventCallBack extends Animator.AnimatorListener {
        void a();
    }

    public ScanningImageView(Context context) {
        super(context);
        this.b = 1000L;
        this.c = -1;
        this.a = false;
        c();
    }

    public ScanningImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 1000L;
        this.c = -1;
        this.a = false;
        c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningImageView);
        this.c = obtainStyledAttributes.getColor(R.styleable.ScanningImageView_lightColor, -1);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        this.g.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{Color.parseColor("#00000000"), Color.parseColor("#afffffff"), Color.parseColor("#00000000")}, new float[]{0.4f, 0.5f, 0.6f}, Shader.TileMode.CLAMP));
        this.e = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(this.e).drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.g);
    }

    private void c() {
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setDither(true);
        this.f.setFilterBitmap(true);
        Paint paint2 = new Paint(1);
        this.g = paint2;
        paint2.setDither(true);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setColor(-1);
        this.g.setFilterBitmap(true);
        this.h = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.j, this.k);
        this.l = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.l.setDuration(this.b);
        this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.ScanningImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanningImageView.this.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanningImageView.this.postInvalidate();
            }
        });
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.common.view.ScanningImageView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ScanningImageView.this.setVisibility(8);
                if (ScanningImageView.this.m != null) {
                    ScanningImageView.this.m.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ScanningImageView.this.setVisibility(8);
                if (ScanningImageView.this.m != null) {
                    ScanningImageView.this.m.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ScanningImageView.this.a = true;
                ScanningImageView.this.setVisibility(0);
                if (ScanningImageView.this.m != null) {
                    ScanningImageView.this.m.onAnimationStart(animator);
                }
            }
        });
    }

    public void a() {
        if (this.d == null) {
            return;
        }
        post(new Runnable() { // from class: com.blued.android.module.common.view.ScanningImageView.3
            @Override // java.lang.Runnable
            public void run() {
                if (ScanningImageView.this.l == null) {
                    ScanningImageView.this.d();
                } else if (ScanningImageView.this.l.isRunning()) {
                    ScanningImageView.this.l.cancel();
                }
                ScanningImageView.this.l.setDuration(ScanningImageView.this.b);
                ScanningImageView.this.l.start();
            }
        });
    }

    public Bitmap getSrcBitmap() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        OnEventCallBack onEventCallBack;
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.a && (onEventCallBack = this.m) != null) {
            onEventCallBack.a();
            this.a = false;
        }
        try {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f, 31);
            canvas.drawBitmap(this.e, this.i, 0.0f, this.f);
            if (this.d != null) {
                this.f.setXfermode(this.h);
                canvas.drawBitmap(this.d, 0.0f, 0.0f, this.f);
                this.f.setXfermode(null);
            }
            canvas.restoreToCount(saveLayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
        float f = -i;
        this.j = f;
        this.i = f;
        this.k = i;
    }

    public void setAnimatorListener(OnEventCallBack onEventCallBack) {
        this.m = onEventCallBack;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.d = bitmap;
    }

    public void setView(View view) {
        this.n = view;
    }
}
