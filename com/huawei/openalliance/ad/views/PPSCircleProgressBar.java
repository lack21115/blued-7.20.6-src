package com.huawei.openalliance.ad.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSCircleProgressBar.class */
public class PPSCircleProgressBar extends View {
    private static final int B = 2;
    private static final int C = 100;
    private static final String Code = "PPSCircleProgressBar";
    private static final String F = "...";
    private static final int I = 18;
    private static final int S = 1000;
    private static final int V = 10;
    private final byte[] D;
    private int L;

    /* renamed from: a  reason: collision with root package name */
    private float f23017a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f23018c;
    private int d;
    private float e;
    private float f;
    private int g;
    private float h;
    private int i;
    private Paint j;
    private String k;
    private Rect l;
    private int m;
    private ValueAnimator n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSCircleProgressBar$a.class */
    public enum a {
        LEFT(0, 180.0f),
        TOP(1, 270.0f),
        RIGHT(2, 0.0f),
        BOTTOM(3, 90.0f);
        
        private final int B;
        private final float C;

        a(int i, float f) {
            this.B = i;
            this.C = f;
        }

        public static float I(int i) {
            a V = V(i);
            if (V == null) {
                return 0.0f;
            }
            return V.V();
        }

        public static a V(int i) {
            a[] values = values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return RIGHT;
                }
                a aVar = values[i3];
                if (aVar.Code(i)) {
                    return aVar;
                }
                i2 = i3 + 1;
            }
        }

        public int Code() {
            return this.B;
        }

        public boolean Code(int i) {
            return this.B == i;
        }

        public float V() {
            return this.C;
        }
    }

    public PPSCircleProgressBar(Context context) {
        this(context, null);
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new byte[0];
        Code(context, attributeSet);
        Code();
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        Code(context, attributeSet);
        Code();
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet);
        Code(context, attributeSet);
        Code();
    }

    private float Code(CharSequence charSequence, float f) {
        int i;
        int paddingSize = getPaddingSize();
        int progressBarSize = getProgressBarSize();
        int Code2 = v.Code(getContext(), f);
        while (true) {
            i = Code2;
            if (i <= 10 || Code(charSequence, i, paddingSize, progressBarSize)) {
                break;
            }
            Code2 = i - 1;
        }
        if (i <= 10 && !Code(charSequence, i, paddingSize, progressBarSize)) {
            this.k = (String) Code(this.k, this.l.width() + getPaddingSize(), getProgressBarSize());
            this.j.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.l);
        }
        float Z = v.Z(getContext(), i);
        Code(Z);
        return Z;
    }

    private CharSequence Code(CharSequence charSequence, int i, int i2) {
        int length = getCurrentText().length();
        int ceil = (int) Math.ceil(((i - i2) / this.l.width()) * length);
        int ceil2 = (int) Math.ceil((this.m * length) / this.l.width());
        int i3 = length - ceil;
        if (i3 - ceil2 > 0) {
            return charSequence.toString().substring(0, length - (ceil + ceil2)) + F;
        }
        String str = charSequence;
        if (i3 > 0) {
            str = charSequence.toString().substring(0, i3);
        }
        return str;
    }

    private void Code() {
        Code(this.e);
    }

    private void Code(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Rect rect = new Rect();
        paint.getTextBounds(F, 0, 3, rect);
        this.m = rect.width();
    }

    private void Code(Context context, AttributeSet attributeSet) {
        Resources resources;
        synchronized (this.D) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.hiad_circle);
                try {
                    try {
                        resources = getResources();
                    } catch (UnsupportedOperationException e) {
                        ge.I(Code, "initButtonAttr UnsupportedOperationException");
                    } catch (Throwable th) {
                        ge.I(Code, "initButtonAttr error: " + th.getClass().getSimpleName());
                    }
                } catch (RuntimeException e2) {
                    ge.I(Code, "initButtonAttr RuntimeException");
                }
                if (resources == null) {
                    ge.I(Code, "init attr, resource is null");
                    obtainStyledAttributes.recycle();
                    return;
                }
                this.L = obtainStyledAttributes.getColor(R.styleable.hiad_circle_progress_outerColor, resources.getColor(R.color.hiad_circle_outer));
                this.f23017a = obtainStyledAttributes.getDimension(R.styleable.hiad_circle_progress_outerRadius, resources.getDimension(R.dimen.hiad_24_dp));
                this.b = obtainStyledAttributes.getColor(R.styleable.hiad_circle_progress_innerColor, resources.getColor(R.color.hiad_circle_inner));
                this.d = obtainStyledAttributes.getColor(R.styleable.hiad_circle_progress_textColor, resources.getColor(R.color.hiad_circle_text));
                this.f23018c = obtainStyledAttributes.getColor(R.styleable.hiad_circle_progress_fillColor, resources.getColor(R.color.hiad_circle_fill));
                this.e = obtainStyledAttributes.getDimension(R.styleable.hiad_circle_progress_textSize, v.Z(context, 18.0f));
                this.f = obtainStyledAttributes.getDimension(R.styleable.hiad_circle_progress_progressWidth, v.V(context, 2.0f));
                this.h = obtainStyledAttributes.getFloat(R.styleable.hiad_circle_progress_progress, 0.0f);
                this.g = obtainStyledAttributes.getInt(R.styleable.hiad_circle_progress_maxProgress, 100);
                this.i = obtainStyledAttributes.getInt(R.styleable.hiad_circle_progress_startPoint, a.BOTTOM.Code());
                obtainStyledAttributes.recycle();
                this.j = new Paint();
            }
        }
    }

    private boolean Code(CharSequence charSequence, int i, int i2, int i3) {
        float Z = v.Z(getContext(), i);
        if (i3 < 0) {
            return true;
        }
        this.j.setTextSize(Z);
        this.j.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.l);
        return this.l.width() + i2 <= i3;
    }

    private void I(float f) {
        synchronized (this.D) {
            ValueAnimator ofFloat = ObjectAnimator.ofFloat(this.h, f);
            this.n = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSCircleProgressBar.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PPSCircleProgressBar.this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PPSCircleProgressBar.this.postInvalidate();
                }
            });
            this.n.setDuration(1000L);
            this.n.setInterpolator(new LinearInterpolator());
            this.n.start();
        }
    }

    private void V(float f) {
        synchronized (this.D) {
            I(f);
        }
    }

    private int getPaddingSize() {
        int paddingStart = getPaddingStart();
        int i = paddingStart;
        if (paddingStart <= 0) {
            i = getPaddingLeft();
        }
        int paddingEnd = getPaddingEnd();
        int i2 = paddingEnd;
        if (paddingEnd <= 0) {
            i2 = getPaddingRight();
        }
        return i + i2;
    }

    private int getProgressBarSize() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        int i = width;
        if (width <= 0) {
            i = layoutParams.width;
        }
        return i;
    }

    public void Code(float f, String str) {
        setCurrentText(str);
        setProgress(f);
    }

    public String getCurrentText() {
        String str;
        synchronized (this.D) {
            str = TextUtils.isEmpty(this.k) ? "" : this.k;
        }
        return str;
    }

    public int getInnerColor() {
        int i;
        synchronized (this.D) {
            i = this.b;
        }
        return i;
    }

    public int getMaxProgress() {
        int i;
        synchronized (this.D) {
            i = this.g;
        }
        return i;
    }

    public int getOuterColor() {
        int i;
        synchronized (this.D) {
            i = this.L;
        }
        return i;
    }

    public float getOuterRadius() {
        float f;
        synchronized (this.D) {
            f = this.f23017a;
        }
        return f;
    }

    public float getProgress() {
        float f;
        synchronized (this.D) {
            f = this.h;
        }
        return f;
    }

    public float getProgressWidth() {
        float f;
        synchronized (this.D) {
            f = this.f;
        }
        return f;
    }

    public int getStartPoint() {
        int i;
        synchronized (this.D) {
            i = this.i;
        }
        return i;
    }

    public int getTextColor() {
        int i;
        synchronized (this.D) {
            i = this.d;
        }
        return i;
    }

    public float getTextSize() {
        float f;
        synchronized (this.D) {
            f = this.e;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.D) {
            try {
                super.onDraw(canvas);
                int width = getWidth() / 2;
                this.j.setColor(this.f23018c);
                this.j.setStyle(Paint.Style.FILL);
                this.j.setAntiAlias(true);
                float f = width;
                canvas.drawCircle(f, f, this.f23017a, this.j);
                this.j.setColor(this.b);
                this.j.setStyle(Paint.Style.STROKE);
                this.j.setStrokeWidth(this.f);
                this.j.setAntiAlias(true);
                canvas.drawCircle(f, f, this.f23017a, this.j);
                this.j.setColor(this.L);
                canvas.drawArc(new RectF(f - this.f23017a, f - this.f23017a, this.f23017a + f, f + this.f23017a), a.I(this.i), (this.h / this.g) * 360.0f, false, this.j);
                this.l = new Rect();
                this.j.setColor(this.d);
                this.j.setStyle(Paint.Style.FILL);
                this.j.setTextSize(Code(this.k, this.e));
                this.j.setStrokeWidth(0.0f);
                String currentText = getCurrentText();
                this.k = currentText;
                this.j.getTextBounds(currentText, 0, currentText.length(), this.l);
                this.j.setTextAlign(Paint.Align.LEFT);
                Paint.FontMetricsInt fontMetricsInt = this.j.getFontMetricsInt();
                canvas.drawText(this.k, (getMeasuredWidth() / 2) - (this.l.width() / 2), (((getMeasuredHeight() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) - fontMetricsInt.top, this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        synchronized (this.D) {
            try {
                setMeasuredDimension(View.MeasureSpec.getMode(i) == 1073741824 ? View.MeasureSpec.getSize(i) : (int) ((this.f23017a * 2.0f) + this.f), View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.getSize(i2) : (int) ((this.f23017a * 2.0f) + this.f));
            }
        }
    }

    public void setCurrentText(String str) {
        synchronized (this.D) {
            this.k = str;
        }
    }

    public void setInnerColor(int i) {
        synchronized (this.D) {
            this.b = i;
        }
    }

    public void setMaxProgress(int i) {
        synchronized (this.D) {
            this.g = i;
        }
    }

    public void setOuterColor(int i) {
        synchronized (this.D) {
            this.L = i;
        }
    }

    public void setOuterRadius(float f) {
        synchronized (this.D) {
            this.f23017a = f;
        }
    }

    public void setProgress(float f) {
        synchronized (this.D) {
            float f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
            float f3 = f2;
            if (f2 > this.g) {
                f3 = this.g;
            }
            V(f3);
        }
    }

    public void setProgressWidth(float f) {
        synchronized (this.D) {
            this.f = f;
        }
    }

    public void setStartPoint(int i) {
        synchronized (this.D) {
            this.i = i;
        }
    }

    public void setTextColor(int i) {
        synchronized (this.D) {
            this.d = i;
        }
    }

    public void setTextSize(float f) {
        synchronized (this.D) {
            this.e = f;
        }
    }
}
