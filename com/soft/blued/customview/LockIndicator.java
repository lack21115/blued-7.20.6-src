package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LockIndicator.class */
public class LockIndicator extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f14756a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14757c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Paint h;
    private Drawable i;
    private Drawable j;
    private String k;

    public LockIndicator(Context context) {
        super(context);
        this.f14756a = 3;
        this.b = 3;
        this.f14757c = 60;
        this.d = 60;
        this.e = 5;
        this.f = 5;
        this.g = 3;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public LockIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f14756a = 3;
        this.b = 3;
        this.f14757c = 60;
        this.d = 60;
        this.e = 5;
        this.f = 5;
        this.g = 3;
        this.h = null;
        this.i = null;
        this.j = null;
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setStrokeWidth(this.g);
        this.h.setStyle(Paint.Style.STROKE);
        this.i = getResources().getDrawable(R.drawable.circle_small_empty_gray);
        Drawable drawable = getResources().getDrawable(R.drawable.circle_small_solid_blue);
        this.j = drawable;
        if (drawable != null) {
            this.f14757c = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.j.getIntrinsicHeight();
            this.d = intrinsicHeight;
            int i = this.f14757c;
            this.e = i / 4;
            this.f = intrinsicHeight / 4;
            this.j.setBounds(0, 0, i, intrinsicHeight);
            this.i.setBounds(0, 0, this.f14757c, this.d);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.j == null || this.i == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f14756a) {
                return;
            }
            int i3 = 0;
            while (i3 < this.b) {
                this.h.setColor(-16777216);
                int i4 = this.d;
                int i5 = this.f;
                int i6 = this.f14757c;
                int i7 = this.e;
                canvas.save();
                canvas.translate((i4 * i3) + (i5 * i3), (i6 * i2) + (i7 * i2));
                int i8 = this.b;
                i3++;
                if (TextUtils.isEmpty(this.k)) {
                    this.i.draw(canvas);
                } else if (this.k.indexOf(String.valueOf((i8 * i2) + i3)) == -1) {
                    this.i.draw(canvas);
                } else {
                    this.j.draw(canvas);
                }
                canvas.restore();
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.j != null) {
            int i3 = this.b;
            int i4 = this.d;
            int i5 = this.f;
            int i6 = this.f14756a;
            setMeasuredDimension((i4 * i3) + (i5 * (i3 - 1)), (this.f14757c * i6) + (this.e * (i6 - 1)));
        }
    }

    public void setPath(String str) {
        this.k = str;
        invalidate();
    }
}
