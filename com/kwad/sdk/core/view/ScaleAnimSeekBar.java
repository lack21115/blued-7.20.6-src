package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/view/ScaleAnimSeekBar.class */
public class ScaleAnimSeekBar extends View {
    private int aoA;
    private int aoB;
    private int aoC;
    private int aoD;
    private int aoE;
    private int aoF;
    private boolean aoG;
    private int aoH;
    private int aoI;
    private int aoJ;
    private int aoK;
    private int aoL;
    private int aoM;
    private int aoN;
    private GradientDrawable aoO;
    private GradientDrawable aoP;
    private GradientDrawable aoQ;
    private Rect aoR;
    private Rect aoS;
    private Rect aoT;
    private Rect aoU;
    private Drawable aoV;
    private boolean aoW;
    private boolean aoX;
    private boolean aoY;
    private boolean aoZ;
    private Paint aox;
    private int aoy;
    private int aoz;
    private boolean apa;
    private WeakReference<a> apb;
    private boolean apc;
    private boolean apd;
    private ValueAnimator ape;
    private ValueAnimator apf;
    private ValueAnimator apg;
    private float aph;
    private float api;
    private float apj;
    private float apk;
    private int apl;
    private boolean apm;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/view/ScaleAnimSeekBar$a.class */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void rz();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoD = 100;
        this.aoG = false;
        this.aoV = null;
        this.aoW = false;
        this.aoX = false;
        this.aoY = false;
        this.aoZ = true;
        this.apc = true;
        this.apd = false;
        this.aph = 1.0f;
        this.api = 1.34f;
        this.apj = 1.0f;
        this.apk = 2.0f;
        init(context, attributeSet);
    }

    private void a(int i, boolean z, boolean z2) {
        int i2;
        int i3;
        a onSeekBarChangedListener;
        int i4 = this.aoC;
        if (i > i4) {
            int i5 = this.aoD;
            i2 = i;
            if (i >= i5) {
                i3 = i5;
            }
            h(z, i2);
            onSeekBarChangedListener = getOnSeekBarChangedListener();
            if (onSeekBarChangedListener != null && this.aoK != this.aoJ) {
                this.aoY = z2;
                onSeekBarChangedListener.a(this, z2);
                this.aoY = false;
            }
            this.aoK = this.aoJ;
        }
        i3 = i4;
        i2 = i3;
        h(z, i2);
        onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null) {
            this.aoY = z2;
            onSeekBarChangedListener.a(this, z2);
            this.aoY = false;
        }
        this.aoK = this.aoJ;
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        rect2.top = (int) (rect.top * this.apj);
        rect2.bottom = (int) (rect.bottom * this.apj);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aoE * this.apj);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void aZ(boolean z) {
        if (this.apc) {
            boolean z2 = z;
            ba(z2);
            bb(z2);
        }
    }

    private float bD(int i) {
        int i2 = this.aoH;
        float f = i2;
        int i3 = this.aoC;
        return ((f * (i - i3)) / (this.aoD - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bE(int i) {
        int i2 = this.aoH;
        return i > i2 / 2 ? this.aoD : i < (-i2) / 2 ? this.aoC : Math.round(((i + (i2 / 2.0f)) * (this.aoD - this.aoC)) / i2) + this.aoC;
    }

    private void ba(boolean z) {
        float f = this.aph;
        float f2 = z ? this.api : 1.0f;
        ValueAnimator valueAnimator = this.ape;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.ape = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.ape.setInterpolator(new LinearInterpolator());
            this.ape.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aph = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.ape.setFloatValues(f, f2);
        this.ape.start();
    }

    private void bb(boolean z) {
        float f = this.apj;
        float f2 = z ? this.apk : 1.0f;
        ValueAnimator valueAnimator = this.apf;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.apf = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.apf.setInterpolator(new LinearInterpolator());
            this.apf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.apj = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.apf.setFloatValues(f, f2);
        this.apf.start();
    }

    private void bd(Context context) {
        this.apc = true;
        this.apl = com.kwad.sdk.c.kwai.a.a(context, 10.0f);
        this.aoB = com.kwad.sdk.c.kwai.a.a(context, 3.0f);
        this.aoI = com.kwad.sdk.c.kwai.a.a(context, 20.0f);
        this.aoV = null;
        this.apd = false;
        this.aoF = com.kwad.sdk.c.kwai.a.a(context, 0.3f);
        this.aoE = com.kwad.sdk.c.kwai.a.a(context, 1.0f);
        this.aoy = 654311423;
        this.aoz = -1;
        this.aoA = 1090519039;
        this.aoC = 0;
        this.aoD = 100;
        this.aoG = false;
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aoV;
        if (drawable != null) {
            drawable.setBounds(this.aoU);
            this.aoV.draw(canvas);
        } else {
            this.aox.setColor(this.aoz);
            canvas.drawCircle(this.aoU.centerX(), this.aoU.centerY(), (this.aoU.width() * this.aph) / 2.0f, this.aox);
        }
        canvas.restore();
    }

    private boolean d(float f, float f2) {
        return this.aoU.left < this.aoU.right && this.aoU.top < this.aoU.bottom && f >= (((float) this.aoU.left) * this.aph) - ((float) this.aoI) && f <= (((float) this.aoU.right) * this.aph) + ((float) this.aoI) && f2 >= (((float) this.aoU.top) * this.aph) - ((float) this.aoI) && f2 <= (((float) this.aoU.bottom) * this.aph) + ((float) this.aoI);
    }

    private boolean e(float f, float f2) {
        return this.aoR.left < this.aoR.right && this.aoR.top < this.aoR.bottom && f >= (((float) this.aoR.left) * this.apj) - ((float) this.aoI) && f <= (((float) this.aoR.right) * this.apj) + ((float) this.aoI) && f2 >= (((float) this.aoR.top) * this.apj) - ((float) this.aoI) && f2 <= (((float) this.aoR.bottom) * this.apj) + ((float) this.aoI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f) {
        this.aoU.left = (int) (f - this.aoB);
        this.aoU.right = (int) (this.aoB + f);
        this.aoS.right = (int) f;
        invalidate();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.apb;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private float h(float f) {
        float f2 = this.aoH / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    private void h(boolean z, int i) {
        if (!z) {
            this.aoJ = i;
            g(h(bD(i)));
            return;
        }
        float h = h(bD(this.aoJ));
        float h2 = h(bD(i));
        ValueAnimator valueAnimator = this.apg;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.apg = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.apg.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f) {
                    float f2 = f - 1.0f;
                    return (f2 * f2 * f2) + 1.0f;
                }
            });
            this.apg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.aoJ = scaleAnimSeekBar.bE((int) floatValue);
                    ScaleAnimSeekBar.this.g(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.apg.setFloatValues(h, h2);
        this.apg.start();
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bd(context);
        }
        Paint paint = new Paint();
        this.aox = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aox.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aoO = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aoO.setColor(this.aoy);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aoP = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aoP.setColor(this.aoz);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aoQ = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aoQ.setColor(this.aoA);
        this.aoR = new Rect();
        this.aoS = new Rect();
        this.aoU = new Rect();
        this.aoT = new Rect();
        this.aoJ = this.aoC;
    }

    private void s(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.aoH = this.apc ? (int) (i - ((this.apl * 2) * (this.api - this.aph))) : i - (this.apl * 2);
        this.aoR.top = -this.aoF;
        Rect rect = this.aoR;
        rect.bottom = -rect.top;
        this.aoR.left = (this.aoG ? -i : -this.aoH) / 2;
        this.aoR.right = this.aoG ? i / 2 : this.aoH / 2;
        this.aoS.top = -this.aoF;
        Rect rect2 = this.aoS;
        rect2.bottom = -rect2.top;
        this.aoS.left = (this.aoG ? -i : -this.aoH) / 2;
        this.aoS.right = (-this.aoH) / 2;
        this.aoT.top = -this.aoF;
        this.aoT.bottom = -this.aoS.top;
        Rect rect3 = this.aoT;
        if (!this.aoG) {
            i = this.aoH;
        }
        rect3.left = (-i) / 2;
        this.aoT.right = (-this.aoH) / 2;
        this.aoU.top = -this.aoB;
        this.aoU.bottom = this.aoB;
        this.aoU.left = ((-this.aoH) / 2) - this.aoB;
        this.aoU.right = ((-this.aoH) / 2) + this.aoB;
        setThumbDrawable(this.aoV);
        setProgress(this.aoJ);
        setSecondaryProgress(this.aoL);
    }

    public final void aY(boolean z) {
        this.apm = z;
        aZ(z);
    }

    public int getMaxProgress() {
        return this.aoD;
    }

    public int getProgress() {
        return this.aoJ;
    }

    public int getProgressLength() {
        return this.aoH;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aoB * this.api));
    }

    public int getSecondaryProgress() {
        return this.aoL;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aoN / 2, this.aoM / 2);
        a(canvas, this.aoR, this.aoO);
        a(canvas, this.aoT, this.aoQ);
        a(canvas, this.aoS, this.aoP);
        if (this.apm) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = getWidth();
        }
        this.aoN = size;
        if (mode2 == 1073741824) {
            this.aoM = size2;
        } else {
            this.aoM = getHeight();
        }
        s(this.aoN, this.aoM);
        setMeasuredDimension(this.aoN, this.aoM);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.aoN / 2);
        float y = motionEvent.getY() - (this.aoM / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return true;
                }
                if (this.aoW || this.aoX) {
                    a(bE((int) x), false, true);
                    return true;
                }
                return true;
            }
            this.apa = false;
            if (this.aoX || this.aoW) {
                this.aoX = false;
                this.aoW = false;
                a(bE((int) x), this.apd, true);
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.a(this);
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
                return true;
            }
            return true;
        } else if (this.aoZ) {
            if (d(x, y)) {
                aZ(true);
                this.aoW = true;
                this.apa = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.rz();
                }
                if (parent == null) {
                    return true;
                }
            } else if (!e(x, y)) {
                return true;
            } else {
                aZ(true);
                this.aoX = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.rz();
                }
                if (parent == null) {
                    return true;
                }
            }
            parent.requestDisallowInterceptTouchEvent(true);
            return true;
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    public void setMaxProgress(int i) {
        this.aoD = i;
    }

    public void setMinProgress(int i) {
        this.aoC = i;
        if (this.aoJ < i) {
            this.aoJ = i;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.apb = new WeakReference<>(aVar);
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(int i) {
        this.aoy = i;
        this.aoO.setColor(i);
    }

    public void setProgressColor(int i) {
        this.aoz = i;
        this.aoP.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2;
        int i3;
        int i4 = this.aoC;
        if (i > i4) {
            int i5 = this.aoD;
            i2 = i;
            if (i >= i5) {
                i3 = i5;
            }
            this.aoL = i2;
            this.aoT.right = (int) h(bD(i2));
            invalidate();
        }
        i3 = i4;
        i2 = i3;
        this.aoL = i2;
        this.aoT.right = (int) h(bD(i2));
        invalidate();
    }

    public void setSecondaryProgressColor(int i) {
        this.aoA = i;
        this.aoQ.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aoV = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aoZ = z;
    }

    public void setThumbScale(float f) {
        this.aph = f;
    }

    public void setThumbTouchOffset(int i) {
        this.aoI = i;
        invalidate();
    }
}
