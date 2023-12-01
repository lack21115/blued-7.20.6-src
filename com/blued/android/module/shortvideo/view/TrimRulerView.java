package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/TrimRulerView.class */
public class TrimRulerView extends View {
    private final String[] a;
    private Paint b;
    private float c;
    private float d;
    private int e;

    public TrimRulerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new String[]{"00:00", "00:15", "00:30", "00:45", "01:00"};
        this.e = 0;
        a(attributeSet, 0);
    }

    public TrimRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new String[]{"00:00", "00:15", "00:30", "00:45", "01:00"};
        this.e = 0;
        a(attributeSet, i);
    }

    private void a(AttributeSet attributeSet, int i) {
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(Color.parseColor("#ffffff"));
        this.b.setStrokeWidth(3.0f);
        this.b.setTextSize(TypedValue.applyDimension(2, 11.0f, getResources().getDisplayMetrics()));
        this.b.setAntiAlias(true);
        Rect rect = new Rect();
        Paint paint2 = this.b;
        String[] strArr = this.a;
        paint2.getTextBounds(strArr[0], 0, strArr[0].length(), rect);
        this.c = rect.width();
        this.d = rect.height();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.e * 2)) / 60.0f;
        float paddingLeft = getPaddingLeft() + this.e;
        int i = 0;
        for (int i2 = 0; i2 < 61; i2++) {
            if (i2 % 15 == 0) {
                canvas.drawLine(paddingLeft, 0.0f, paddingLeft, 12.0f, this.b);
                canvas.drawText(this.a[i], paddingLeft - (this.c * 0.5f), this.d + 14.0f, this.b);
                i++;
            } else {
                canvas.drawLine(paddingLeft, 0.0f, paddingLeft, 6.0f, this.b);
            }
            paddingLeft += measuredWidth;
        }
    }

    public void setOffset(int i) {
        this.e = i;
    }
}
