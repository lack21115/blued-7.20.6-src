package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/BezierRadarHeader.class */
public class BezierRadarHeader extends InternalAbstract implements RefreshHeader {

    /* renamed from: a  reason: collision with root package name */
    protected int f27980a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f27981c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected Path g;
    protected Paint h;
    protected int i;
    protected int j;
    protected int k;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected int p;
    protected float q;
    protected float r;
    protected float s;
    protected Animator t;
    protected RectF u;

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/BezierRadarHeader$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27982a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f27982a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f27982a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/BezierRadarHeader$AnimatorUpdater.class */
    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        byte f27983a;

        AnimatorUpdater(byte b) {
            this.f27983a = b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b = this.f27983a;
            if (b == 0) {
                BezierRadarHeader.this.s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b) {
                if (BezierRadarHeader.this.e) {
                    valueAnimator.cancel();
                    return;
                } else {
                    BezierRadarHeader.this.j = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
                }
            } else if (2 == b) {
                BezierRadarHeader.this.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b) {
                BezierRadarHeader.this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b) {
                BezierRadarHeader.this.p = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.k = -1;
        this.p = 0;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.u = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.x = SpinnerStyle.Scale;
        DensityUtil densityUtil = new DensityUtil();
        this.g = new Path();
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.n = densityUtil.b(7.0f);
        this.q = densityUtil.b(20.0f);
        this.r = densityUtil.b(7.0f);
        this.h.setStrokeWidth(densityUtil.b(3.0f));
        setMinimumHeight(densityUtil.b(100.0f));
        if (isInEditMode()) {
            this.i = 1000;
            this.s = 1.0f;
            this.p = 270;
        } else {
            this.s = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f);
        b(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
        a(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.d = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
        this.f27981c = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        Animator animator = this.t;
        if (animator != null) {
            animator.removeAllListeners();
            this.t.end();
            this.t = null;
        }
        int width = getWidth();
        int height = getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (float) Math.sqrt((width * width) + (height * height)));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new AnimatorUpdater((byte) 3));
        ofFloat.start();
        return 400;
    }

    public BezierRadarHeader a(int i) {
        this.b = i;
        this.f27981c = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(float f, int i, int i2) {
        this.k = i;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    protected void a(Canvas canvas, int i) {
        this.g.reset();
        this.g.lineTo(0.0f, this.i);
        Path path = this.g;
        int i2 = this.k;
        if (i2 < 0) {
            i2 = i / 2;
        }
        int i3 = this.i;
        float f = this.j + i3;
        float f2 = i;
        path.quadTo(i2, f, f2, i3);
        this.g.lineTo(f2, 0.0f);
        this.h.setColor(this.b);
        canvas.drawPath(this.g, this.h);
    }

    protected void a(Canvas canvas, int i, int i2) {
        float f;
        float f2 = 0.0f;
        if (this.l <= 0.0f) {
            return;
        }
        this.h.setColor(this.f27980a);
        float a2 = DensityUtil.a(i2);
        float f3 = i / 7;
        float f4 = this.m;
        float f5 = f4 > 1.0f ? ((f4 - 1.0f) * f3) / f4 : 0.0f;
        float f6 = i2;
        float f7 = this.m;
        if (f7 > 1.0f) {
            f2 = (((f7 - 1.0f) * f6) / 2.0f) / f7;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 7) {
                this.h.setAlpha(255);
                return;
            }
            this.h.setAlpha((int) (this.l * (1.0f - ((Math.abs(f) / 7.0f) * 2.0f)) * 255.0f * (1.0d - (1.0d / Math.pow((a2 / 800.0d) + 1.0d, 15.0d)))));
            float f8 = this.n * (1.0f - (1.0f / ((a2 / 10.0f) + 1.0f)));
            canvas.drawCircle(((i / 2) - (f8 / 2.0f)) + (((i4 + 1.0f) - 4.0f) * ((f3 * f4) - f5)), (f6 - f2) / 2.0f, f8, this.h);
            i3 = i4 + 1;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.f27982a[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.l = 1.0f;
            this.s = 0.0f;
            this.o = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(boolean z, float f, int i, int i2, int i3) {
        if (z || this.e) {
            this.e = true;
            this.i = Math.min(i2, i);
            this.j = (int) (Math.max(0, i - i2) * 1.9f);
            this.m = f;
        }
    }

    public BezierRadarHeader b(int i) {
        this.f27980a = i;
        this.d = true;
        return this;
    }

    protected void b(Canvas canvas, int i, int i2) {
        if (this.t != null || isInEditMode()) {
            float f = this.q;
            float f2 = this.s;
            float f3 = f * f2;
            float f4 = this.r;
            this.h.setColor(this.f27980a);
            this.h.setStyle(Paint.Style.FILL);
            float f5 = i / 2;
            float f6 = i2 / 2;
            canvas.drawCircle(f5, f6, f3, this.h);
            this.h.setStyle(Paint.Style.STROKE);
            float f7 = (f4 * f2) + f3;
            canvas.drawCircle(f5, f6, f7, this.h);
            this.h.setColor((this.b & 16777215) | 1426063360);
            this.h.setStyle(Paint.Style.FILL);
            this.u.set(f5 - f3, f6 - f3, f5 + f3, f3 + f6);
            canvas.drawArc(this.u, 270.0f, this.p, true, this.h);
            this.h.setStyle(Paint.Style.STROKE);
            this.u.set(f5 - f7, f6 - f7, f5 + f7, f6 + f7);
            canvas.drawArc(this.u, 270.0f, this.p, false, this.h);
            this.h.setStyle(Paint.Style.FILL);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void b(RefreshLayout refreshLayout, int i, int i2) {
        this.i = i;
        this.e = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new AnimatorUpdater((byte) 4));
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new AnimatorUpdater((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat2.addUpdateListener(new AnimatorUpdater((byte) 0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i3 = this.j;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, 0, -((int) (i3 * 0.8f)), 0, -((int) (i3 * 0.4f)), 0);
        ofInt2.addUpdateListener(new AnimatorUpdater((byte) 1));
        ofInt2.setInterpolator(decelerateInterpolator);
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.t = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean b() {
        return this.f;
    }

    protected void c(Canvas canvas, int i, int i2) {
        if (this.o > 0.0f) {
            this.h.setColor(this.f27980a);
            canvas.drawCircle(i / 2, i2 / 2, this.o, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        a(canvas, width);
        a(canvas, width, height);
        b(canvas, width, height);
        c(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.t;
        if (animator != null) {
            animator.removeAllListeners();
            this.t.end();
            this.t = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.f27981c) {
            a(iArr[0]);
            this.f27981c = false;
        }
        if (iArr.length <= 1 || this.d) {
            return;
        }
        b(iArr[1]);
        this.d = false;
    }
}
