package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.framework.utils.DensityUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/VerticalTextView.class */
public class VerticalTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    protected TextPaint f28535a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f28536c;
    private Paint d;
    private Path e;
    private float f;
    private int g;
    private boolean h;

    public VerticalTextView(Context context) {
        this(context, null);
    }

    public VerticalTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28536c = "左滑看更多";
        this.f = 0.0f;
        this.h = true;
        TextPaint textPaint = new TextPaint(1);
        this.f28535a = textPaint;
        textPaint.setAntiAlias(true);
        this.b = DensityUtils.a(context, 4.0f);
        this.g = DensityUtils.a(context, 8.0f);
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(Color.parseColor("#F3F4F4"));
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setStrokeWidth(1.0f);
        this.e = new Path();
    }

    public void a(float f, float f2) {
        this.f = f;
        float f3 = (f2 / 2.0f) - this.g;
        if (f >= f3) {
            this.f = f3;
        } else {
            this.f = f3 + ((f - f3) / 2.0f);
        }
        invalidate();
    }

    public boolean getIsDrawShadow() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        if (this.h) {
            this.e.reset();
            this.e.moveTo(getWidth(), 0.0f);
            this.e.quadTo(this.f, getHeight() / 2, getWidth(), getHeight());
            canvas.drawPath(this.e, this.d);
        }
        this.f28535a.setTextSize(getTextSize());
        this.f28535a.setColor(getCurrentTextColor());
        this.f28535a.setTypeface(getTypeface());
        CharSequence charSequence = this.f28536c;
        if (charSequence != null && !charSequence.toString().trim().equals("") && getLayout() != null) {
            Rect rect = new Rect();
            this.f28535a.getTextBounds(charSequence.toString(), 0, charSequence.length(), rect);
            float lineLeft = getLayout().getLineLeft(0) + getPaddingLeft();
            float f = lineLeft;
            if (getCompoundDrawables()[0] != null) {
                Rect bounds = getCompoundDrawables()[0].getBounds();
                f = lineLeft + (bounds.right - bounds.left);
            }
            float compoundDrawablePadding = getCompoundDrawablePadding();
            float baseline = getBaseline();
            float length = ((charSequence.length() - 1) * ((rect.bottom - rect.top) + this.b)) / 2;
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                canvas.drawText(String.valueOf(charSequence.charAt(i2)), f + compoundDrawablePadding, (i2 * i) + (baseline - length), this.f28535a);
            }
        }
        super.onDraw(canvas);
    }

    public void setDrawShadow(boolean z) {
        this.h = z;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f28536c = charSequence;
        super.setText("", bufferType);
    }

    public void setVerticalText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f28536c = charSequence;
        invalidate();
    }
}
