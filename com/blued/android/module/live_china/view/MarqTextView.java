package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.framework.view.badgeview.DisplayUtil;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqTextView.class */
public class MarqTextView extends AppCompatTextView {
    Runnable a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private float g;
    private float h;
    private boolean i;
    private float j;

    public MarqTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.a = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$MarqTextView$k1_6OC-cZ0lktL-11mPwxTqBjYw
            @Override // java.lang.Runnable
            public final void run() {
                MarqTextView.this.c();
            }
        };
    }

    public MarqTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.a = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$MarqTextView$k1_6OC-cZ0lktL-11mPwxTqBjYw
            @Override // java.lang.Runnable
            public final void run() {
                MarqTextView.this.c();
            }
        };
    }

    private void a() {
        if (this.i) {
            return;
        }
        this.i = true;
        removeCallbacks(this.a);
        postDelayed(this.a, 500L);
    }

    private void b() {
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        float measureText = paint.measureText(getText().toString());
        this.b = measureText;
        this.c = measureText / getText().length();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.d = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        this.e = Math.abs(fontMetrics.descent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (this.i) {
            invalidate();
            postDelayed(this.a, 25L);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        removeCallbacks(this.a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.b <= 0.0f || this.c == 0.0f) {
            b();
        }
        float measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - DisplayUtil.a(getContext(), 6.0f);
        if (this.b < measuredWidth || this.c == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        int gravity = getGravity();
        this.f = gravity;
        float measuredHeight = (gravity == 80 ? getMeasuredHeight() - getPaddingBottom() : (gravity == 17 || gravity == 16) ? (((getMeasuredHeight() - getPaddingBottom()) / 2) + (getPaddingTop() / 2)) + (this.d / 2.0f) : this.d) - this.e;
        this.j = measuredWidth / 80.0f;
        canvas.clipRect(getPaddingLeft(), 0, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight());
        canvas.save();
        canvas.drawText(getText().toString(), this.g, measuredHeight, getPaint());
        canvas.restore();
        this.h = this.g + this.b + (this.j * 2.0f);
        canvas.save();
        canvas.drawText(getText().toString(), this.h, measuredHeight, getPaint());
        canvas.restore();
        float f = this.g;
        float f2 = this.b;
        if (f + f2 < 0.0f) {
            float f3 = this.h;
            this.g = f3;
            this.h = f3 + f2;
        }
        this.g -= this.j;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        b();
        a();
    }

    public void setText(String str) {
        super.setText(str);
        b();
        a();
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        b();
        a();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        b();
    }
}
