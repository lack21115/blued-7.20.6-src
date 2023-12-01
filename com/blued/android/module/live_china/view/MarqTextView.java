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

    /* renamed from: a  reason: collision with root package name */
    Runnable f14963a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f14964c;
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
        this.f14963a = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$MarqTextView$k1_6OC-cZ0lktL-11mPwxTqBjYw
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
        this.f14963a = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$MarqTextView$k1_6OC-cZ0lktL-11mPwxTqBjYw
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
        removeCallbacks(this.f14963a);
        postDelayed(this.f14963a, 500L);
    }

    private void b() {
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        float measureText = paint.measureText(getText().toString());
        this.b = measureText;
        this.f14964c = measureText / getText().length();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.d = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        this.e = Math.abs(fontMetrics.descent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (this.i) {
            invalidate();
            postDelayed(this.f14963a, 25L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        removeCallbacks(this.f14963a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.b <= 0.0f || this.f14964c == 0.0f) {
            b();
        }
        float measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - DisplayUtil.a(getContext(), 6.0f);
        if (this.b < measuredWidth || this.f14964c == 0.0f) {
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

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        b();
        a();
    }

    public void setText(String str) {
        super.setText((CharSequence) str);
        b();
        a();
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        b();
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        b();
    }
}
