package com.soft.blued.customview.adapttextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.blued.android.core.utils.skin.BluedSkinUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/adapttextview/TextSizeRaeSeekBar.class */
public class TextSizeRaeSeekBar extends AppCompatSeekBar {

    /* renamed from: a  reason: collision with root package name */
    private String[] f14859a;
    private int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f14860c;
    private final Paint d;
    private float e;
    private float f;
    private int g;
    private final Rect h;

    public TextSizeRaeSeekBar(Context context) {
        this(context, null);
    }

    public TextSizeRaeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextSizeRaeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14860c = new TextPaint(1);
        this.d = new TextPaint(1);
        this.e = 18.0f;
        this.f = 15.0f;
        this.g = 10;
        this.h = new Rect();
        a();
    }

    private int a(float f) {
        return FontAdjustTextHelper.a(getContext(), f);
    }

    private void a() {
        this.f14859a = FontAdjustTextHelper.c();
        int[] d = FontAdjustTextHelper.d();
        this.b = d;
        setMax(d.length - 1);
        this.f14860c.setColor(BluedSkinUtils.a(getContext(), 2131100624));
        this.d.setColor(BluedSkinUtils.a(getContext(), 2131102254));
    }

    public int a(Paint paint, String str) {
        float[] fArr;
        int i = 0;
        if (str != null) {
            i = 0;
            if (str.length() > 0) {
                int length = str.length();
                paint.getTextWidths(str, new float[length]);
                i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    i += (int) Math.ceil(fArr[i2]);
                }
            }
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        int max = getMax();
        int width = getWidth();
        int height = getHeight() / 2;
        this.h.left = getPaddingLeft();
        this.h.right = width - getPaddingRight();
        this.h.top = height - a(1.0f);
        Rect rect = this.h;
        rect.bottom = rect.top + a(1.5f);
        int width2 = this.h.width();
        canvas.drawRect(this.h, this.f14860c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > max) {
                super.onDraw(canvas);
                return;
            }
            int paddingLeft = getPaddingLeft() + ((width2 * i2) / max);
            canvas.drawCircle(paddingLeft, height, FontAdjustTextHelper.a(getContext(), 3.0f), this.f14860c);
            String[] strArr = this.f14859a;
            String str = strArr[i2 % strArr.length];
            this.d.setTextSize(a(this.b[i2]));
            this.d.getTextBounds(str, 0, str.length(), this.h);
            float a2 = paddingLeft - (a(this.d, this.f14859a[i2]) / 2);
            int[] iArr = this.b;
            canvas.drawText(str, a2, a(iArr[iArr.length - 1]), this.d);
            i = i2 + 1;
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        synchronized (this) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), mode), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + (a(this.b[this.b.length - 1]) * 2) + (a(this.f) * 2), mode2));
        }
    }
}
