package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RoundRectLayout.class */
public class RoundRectLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Path f14821a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f14822c;
    private int d;
    private float e;
    private int f;

    public RoundRectLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.f = 1;
        a(attributeSet, i);
    }

    private void a() {
        if (getWidth() == this.f14822c && getHeight() == this.d && this.e == this.b) {
            return;
        }
        this.f14822c = getWidth();
        this.d = getHeight();
        this.e = this.b;
        this.f14821a.reset();
        int i = this.f;
        if (i == 1) {
            Path path = this.f14821a;
            RectF rectF = new RectF(0.0f, 0.0f, this.f14822c, this.d);
            float f = this.b;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } else if (i == 2) {
            Path path2 = this.f14821a;
            RectF rectF2 = new RectF(0.0f, 0.0f, this.f14822c, this.d);
            float f2 = this.b;
            path2.addRoundRect(rectF2, new float[]{f2, f2, 0.0f, 0.0f, 0.0f, 0.0f, f2, f2}, Path.Direction.CW);
        } else if (i == 3) {
            Path path3 = this.f14821a;
            RectF rectF3 = new RectF(0.0f, 0.0f, this.f14822c, this.d);
            float f3 = this.b;
            path3.addRoundRect(rectF3, new float[]{f3, f3, f3, f3, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        } else if (i == 4) {
            Path path4 = this.f14821a;
            RectF rectF4 = new RectF(0.0f, 0.0f, this.f14822c, this.d);
            float f4 = this.b;
            path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, f4, f4, f4, f4, 0.0f, 0.0f}, Path.Direction.CW);
        } else if (i != 5) {
        } else {
            Path path5 = this.f14821a;
            RectF rectF5 = new RectF(0.0f, 0.0f, this.f14822c, this.d);
            float f5 = this.b;
            path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, f5, f5, f5, f5}, Path.Direction.CW);
        }
    }

    private void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShapeTextView, i, 0);
        this.b = obtainStyledAttributes.getDimension(7, 0.0f);
        obtainStyledAttributes.recycle();
        Path path = new Path();
        this.f14821a = path;
        path.setFillType(Path.FillType.EVEN_ODD);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f == 0) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        a();
        canvas.clipPath(this.f14821a);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    public void setCornerRadius(int i) {
        this.b = i;
    }

    public void setRoundMode(int i) {
        this.f = i;
    }
}
