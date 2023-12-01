package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/JustifyTextView.class */
public class JustifyTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private float f32299a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f32300c;
    private List<String> d;
    private List<Integer> e;
    private Align f;
    private boolean g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private boolean m;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/JustifyTextView$Align.class */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_CENTER,
        ALIGN_RIGHT
    }

    public JustifyTextView(Context context) {
        super(context);
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
    }

    public JustifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843287, 16843288});
        this.i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getFloat(1, 1.0f);
        this.l = getPaddingBottom();
        obtainStyledAttributes.recycle();
    }

    public JustifyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
    }

    private void a(Paint paint, String str) {
        StringBuilder sb;
        int i;
        if (str.length() == 0) {
            this.d.add("\n");
            return;
        }
        int measureText = (int) (this.f32300c / paint.measureText("中"));
        int i2 = measureText + 1;
        int i3 = 0;
        StringBuilder sb2 = new StringBuilder(str.substring(0, Math.min(i2, str.length())));
        while (true) {
            sb = sb2;
            if (i2 >= str.length()) {
                break;
            }
            if (paint.measureText(str.substring(i3, i2 + 1)) > this.f32300c) {
                this.d.add(sb2.toString());
                sb = new StringBuilder();
                if (str.length() - i2 <= measureText) {
                    this.d.add(str.substring(i2));
                    break;
                }
                int i4 = i2 + measureText;
                sb.append(str.substring(i2, i4));
                i = i4 - 1;
                sb2 = sb;
                i3 = i2;
            } else {
                sb2.append(str.charAt(i2));
                i = i2;
            }
            i2 = i + 1;
        }
        if (sb.length() > 0) {
            this.d.add(sb.toString());
        }
        this.e.add(Integer.valueOf(this.d.size() - 1));
    }

    private void a(String str, float f, int i) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(0, f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.k = textView.getLineCount();
        this.j = textView.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.f32300c = getMeasuredWidth();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        float f2 = textSize;
        if ((getGravity() & 4096) == 0) {
            f2 = textSize + ((this.f32299a - textSize) / 2.0f);
        }
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        this.f32300c = (this.f32300c - paddingLeft) - getPaddingRight();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return;
            }
            float f3 = i2;
            float f4 = this.f32299a;
            String str = this.d.get(i2);
            float f5 = paddingLeft;
            float measureText = this.f32300c - paint.measureText(str);
            float length = measureText / (str.length() - 1);
            float f6 = f5;
            if (this.e.contains(Integer.valueOf(i2))) {
                if (this.f == Align.ALIGN_CENTER) {
                    f = measureText / 2.0f;
                } else {
                    f6 = f5;
                    length = 0.0f;
                    if (this.f == Align.ALIGN_RIGHT) {
                        f = measureText;
                    }
                }
                f6 = f5 + f;
                length = 0.0f;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < str.length()) {
                    float measureText2 = paint.measureText(str.substring(0, i4));
                    int i5 = i4 + 1;
                    canvas.drawText(str.substring(i4, i5), measureText2 + (i4 * length) + f6, paddingTop + (f4 * f3) + f2 + (this.b * f3), paint);
                    i3 = i5;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.g) {
            return;
        }
        this.f32300c = getMeasuredWidth();
        String charSequence = getText().toString();
        TextPaint paint = getPaint();
        this.d.clear();
        this.e.clear();
        String[] split = charSequence.split("\\n");
        int length = split.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                a(charSequence, paint.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
                float f = (this.j * 1.0f) / this.k;
                this.f32299a = f;
                float f2 = ((this.h - 1.0f) * f) + this.i;
                this.b = f2;
                this.m = true;
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.l + ((int) ((f2 + f) * (this.d.size() - this.k))));
                this.g = false;
                return;
            }
            a(paint, split[i6]);
            i5 = i6 + 1;
        }
    }

    public void setAlign(Align align) {
        this.f = align;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (!this.m) {
            this.l = i4;
        }
        this.m = false;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.g = true;
        super.setText(charSequence, bufferType);
    }
}
