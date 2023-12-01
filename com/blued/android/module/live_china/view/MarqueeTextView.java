package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqueeTextView.class */
public class MarqueeTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14965a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f14966c;
    private Paint d;
    private String e;
    private long f;
    private float g;
    private int h;
    private int i;
    private callbackListener j;
    private callbackErrorListener k;
    private Runnable l;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqueeTextView$callbackErrorListener.class */
    public interface callbackErrorListener {
        void onError();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqueeTextView$callbackListener.class */
    public interface callbackListener {
        void onFinish(int i);
    }

    public MarqueeTextView(Context context) {
        super(context);
        this.b = 0.0f;
        this.f14966c = 0.0f;
        this.f14965a = false;
        this.d = null;
        this.e = "";
        this.f = 1000L;
        this.g = 2.0f;
        this.l = new Runnable() { // from class: com.blued.android.module.live_china.view.MarqueeTextView.1
            @Override // java.lang.Runnable
            public void run() {
                MarqueeTextView.this.f14965a = true;
                if (MarqueeTextView.this.j != null) {
                    MarqueeTextView.this.j.onFinish(MarqueeTextView.this.i);
                }
                if (MarqueeTextView.this.f14965a) {
                    MarqueeTextView.this.f14966c = 1.0f;
                    MarqueeTextView.c(MarqueeTextView.this);
                    MarqueeTextView.this.invalidate();
                }
            }
        };
        a(context);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.f14966c = 0.0f;
        this.f14965a = false;
        this.d = null;
        this.e = "";
        this.f = 1000L;
        this.g = 2.0f;
        this.l = new Runnable() { // from class: com.blued.android.module.live_china.view.MarqueeTextView.1
            @Override // java.lang.Runnable
            public void run() {
                MarqueeTextView.this.f14965a = true;
                if (MarqueeTextView.this.j != null) {
                    MarqueeTextView.this.j.onFinish(MarqueeTextView.this.i);
                }
                if (MarqueeTextView.this.f14965a) {
                    MarqueeTextView.this.f14966c = 1.0f;
                    MarqueeTextView.c(MarqueeTextView.this);
                    MarqueeTextView.this.invalidate();
                }
            }
        };
        a(context);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0.0f;
        this.f14966c = 0.0f;
        this.f14965a = false;
        this.d = null;
        this.e = "";
        this.f = 1000L;
        this.g = 2.0f;
        this.l = new Runnable() { // from class: com.blued.android.module.live_china.view.MarqueeTextView.1
            @Override // java.lang.Runnable
            public void run() {
                MarqueeTextView.this.f14965a = true;
                if (MarqueeTextView.this.j != null) {
                    MarqueeTextView.this.j.onFinish(MarqueeTextView.this.i);
                }
                if (MarqueeTextView.this.f14965a) {
                    MarqueeTextView.this.f14966c = 1.0f;
                    MarqueeTextView.c(MarqueeTextView.this);
                    MarqueeTextView.this.invalidate();
                }
            }
        };
        a(context);
    }

    private void a(Context context) {
        setMaxWidth(context.getResources().getDisplayMetrics().widthPixels / 2);
        TextPaint paint = getPaint();
        this.d = paint;
        paint.setColor(getTextColors().getColorForState(getDrawableState(), 0));
        String charSequence = getText().toString();
        this.e = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.b = this.d.measureText(this.e);
        this.f14965a = true;
    }

    static /* synthetic */ int c(MarqueeTextView marqueeTextView) {
        int i = marqueeTextView.i;
        marqueeTextView.i = i + 1;
        return i;
    }

    public void a() {
        if (this.f14965a) {
            return;
        }
        removeCallbacks(this.l);
        this.f14965a = true;
        this.i = 0;
        this.f14966c = 0.0f;
        invalidate();
    }

    public void b() {
        if (this.f14965a) {
            removeCallbacks(this.l);
            this.f14965a = false;
            this.i = 0;
            this.f14966c = 0.0f;
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.d.getFontMetricsInt();
        this.h = ((canvas.getHeight() - fontMetricsInt.bottom) - fontMetricsInt.top) / 2;
        if (this.b <= canvas.getWidth()) {
            canvas.drawText(this.e, 0.0f, this.h, this.d);
            callbackErrorListener callbackerrorlistener = this.k;
            if (callbackerrorlistener != null) {
                callbackerrorlistener.onError();
                return;
            }
            return;
        }
        canvas.drawText(this.e, -this.f14966c, this.h, this.d);
        if (this.f14965a) {
            float f = this.f14966c;
            if (f == 0.0f) {
                this.f14965a = false;
                postDelayed(this.l, this.f);
                return;
            }
            if (f <= (-this.g) || f >= 0.0f) {
                this.f14966c += this.g;
            } else {
                this.f14966c = 0.0f;
            }
            if (this.f14966c > this.b) {
                this.f14966c = -canvas.getWidth();
            }
            invalidate();
        }
    }

    public void setErrorListener(callbackErrorListener callbackerrorlistener) {
        this.k = callbackerrorlistener;
    }

    public void setListener(callbackListener callbacklistener) {
        this.j = callbacklistener;
    }

    public void setScrollSpeed(float f) {
        this.g = f;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.e = charSequence.toString();
        this.b = getPaint().measureText(charSequence.toString());
        this.f14966c = 0.0f;
        a();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.d.setColor(i);
        a();
    }

    public void setWaitTime(long j) {
        this.f = j;
    }
}
