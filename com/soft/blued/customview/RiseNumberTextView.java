package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Process;
import android.util.AttributeSet;
import android.widget.TextView;
import com.igexin.push.config.c;
import com.soft.blued.utils.StringUtils;
import java.text.DecimalFormat;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RiseNumberTextView.class */
public class RiseNumberTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f14806a = {9, 99, 999, 9999, Process.LAST_ISOLATED_UID, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private float f14807c;
    private float d;
    private float e;
    private long f;
    private int g;
    private DecimalFormat h;
    private EndListener i;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RiseNumberTextView$EndListener.class */
    public interface EndListener {
        void a();
    }

    public RiseNumberTextView(Context context) {
        super(context);
        this.b = 0;
        this.f = c.j;
        this.g = 2;
        this.h = new DecimalFormat("##0.00");
        this.i = null;
    }

    public RiseNumberTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f = c.j;
        this.g = 2;
        this.h = new DecimalFormat("##0.00");
        this.i = null;
    }

    public RiseNumberTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.f = c.j;
        this.g = 2;
        this.h = new DecimalFormat("##0.00");
        this.i = null;
    }

    private void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.d, this.f14807c);
        ofFloat.setDuration(this.f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.RiseNumberTextView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RiseNumberTextView.this.e = Float.valueOf(valueAnimator.getAnimatedValue().toString()).floatValue();
                RiseNumberTextView riseNumberTextView = RiseNumberTextView.this;
                riseNumberTextView.setText(riseNumberTextView.h.format(Float.parseFloat(valueAnimator.getAnimatedValue().toString())));
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    RiseNumberTextView.this.b = 0;
                    if (RiseNumberTextView.this.i != null) {
                        RiseNumberTextView.this.i.a();
                    }
                }
            }
        });
        ofFloat.start();
    }

    private void d() {
        ValueAnimator ofInt = ValueAnimator.ofInt((int) this.d, (int) this.f14807c);
        ofInt.setDuration(this.f);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.RiseNumberTextView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RiseNumberTextView.this.e = Float.valueOf(valueAnimator.getAnimatedValue().toString()).floatValue();
                RiseNumberTextView.this.setText(StringUtils.a(valueAnimator.getAnimatedValue().toString()));
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    RiseNumberTextView.this.b = 0;
                    if (RiseNumberTextView.this.i != null) {
                        RiseNumberTextView.this.i.a();
                    }
                }
            }
        });
        ofInt.start();
    }

    public void a(float f, float f2) {
        this.f14807c = f;
        this.d = f2;
        this.g = 2;
    }

    public void a(int i, int i2) {
        this.f14807c = i;
        this.d = i2;
        this.g = 1;
    }

    public boolean a() {
        return this.b == 1;
    }

    public void b() {
        if (a()) {
            return;
        }
        this.b = 1;
        if (this.g == 1) {
            d();
        } else {
            c();
        }
    }

    public float getNowNumber() {
        return this.e;
    }

    public void setDecimals(String str) {
        this.h = new DecimalFormat(str);
    }

    public void setDuration(long j) {
        this.f = j;
    }

    public void setOnEndListener(EndListener endListener) {
        this.i = endListener;
    }

    public void setText(float f) {
        setText(this.h.format(f));
    }
}
