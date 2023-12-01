package com.scwang.smartrefresh.layout.footer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/footer/BallPulseFooter.class */
public class BallPulseFooter extends InternalAbstract implements RefreshFooter {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f14284a;
    protected boolean b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f14285c;
    protected int d;
    protected int e;
    protected float f;
    protected float[] g;
    protected boolean h;
    protected ArrayList<ValueAnimator> i;
    protected Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> j;

    public BallPulseFooter(Context context) {
        this(context, null);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -1118482;
        this.e = -1615546;
        this.g = new float[]{1.0f, 1.0f, 1.0f};
        this.h = false;
        this.j = new HashMap();
        setMinimumHeight(DensityUtil.a(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        Paint paint = new Paint();
        this.f14285c = paint;
        paint.setColor(-1);
        this.f14285c.setStyle(Paint.Style.FILL);
        this.f14285c.setAntiAlias(true);
        this.x = SpinnerStyle.Translate;
        this.x = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.x.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlNormalColor)) {
            a(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlNormalColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlAnimatingColor)) {
            b(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAnimatingColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.f = DensityUtil.a(4.0f);
        this.i = new ArrayList<>();
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setTarget(Integer.valueOf(i2));
            ofFloat.setStartDelay(new int[]{120, 240, 360}[i2]);
            final int i3 = i2;
            this.j.put(ofFloat, new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.layout.footer.BallPulseFooter.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseFooter.this.g[i3] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.postInvalidate();
                }
            });
            this.i.add(ofFloat);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        ArrayList<ValueAnimator> arrayList = this.i;
        if (arrayList != null && this.h) {
            this.h = false;
            this.g = new float[]{1.0f, 1.0f, 1.0f};
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
        this.f14285c.setColor(this.d);
        return 0;
    }

    public BallPulseFooter a(int i) {
        this.d = i;
        this.f14284a = true;
        if (!this.h) {
            this.f14285c.setColor(i);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshLayout refreshLayout, int i, int i2) {
        if (this.h) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.i.size()) {
                this.h = true;
                this.f14285c.setColor(this.e);
                return;
            }
            ValueAnimator valueAnimator = this.i.get(i4);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.j.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
            i3 = i4 + 1;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean a(boolean z) {
        return false;
    }

    public BallPulseFooter b(int i) {
        this.e = i;
        this.b = true;
        if (this.h) {
            this.f14285c.setColor(i);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float min = Math.min(width, height);
        float f = this.f;
        float f2 = (min - (f * 2.0f)) / 6.0f;
        float f3 = width / 2;
        float f4 = 2.0f * f2;
        float f5 = height / 2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                super.dispatchDraw(canvas);
                return;
            }
            canvas.save();
            float f6 = i2;
            canvas.translate((f4 * f6) + (f3 - (f + f4)) + (this.f * f6), f5);
            float[] fArr = this.g;
            canvas.scale(fArr[i2], fArr[i2]);
            canvas.drawCircle(0.0f, 0.0f, f2, this.f14285c);
            canvas.restore();
            i = i2 + 1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.i == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i.size()) {
                return;
            }
            this.i.get(i2).cancel();
            this.i.get(i2).removeAllListeners();
            this.i.get(i2).removeAllUpdateListeners();
            i = i2 + 1;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (!this.b && iArr.length > 1) {
            b(iArr[0]);
            this.b = false;
        }
        if (this.f14284a) {
            return;
        }
        if (iArr.length > 1) {
            a(iArr[1]);
        } else if (iArr.length > 0) {
            a(ColorUtils.compositeColors(-1711276033, iArr[0]));
        }
        this.f14284a = false;
    }
}
