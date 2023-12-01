package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.module.shortvideo.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/widget/StvRoundImageView.class */
public class StvRoundImageView extends AppCompatImageView {
    private Paint a;
    private int b;
    private int c;

    public StvRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StvRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = a(10.0f);
        a(context, attributeSet, i);
        a();
    }

    private int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix imageMatrix = getImageMatrix();
        if (imageMatrix != null) {
            canvas.concat(imageMatrix);
        }
        drawable.draw(canvas);
        return createBitmap;
    }

    private void a() {
        this.a = new Paint(5);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StvRoundImageView, i, 0);
        int i2 = 0;
        if (obtainStyledAttributes.hasValue(R.styleable.StvRoundImageView_stv_round_v_type)) {
            i2 = obtainStyledAttributes.getInt(R.styleable.StvRoundImageView_stv_round_v_type, 0);
        }
        this.b = i2;
        this.c = obtainStyledAttributes.hasValue(R.styleable.StvRoundImageView_stv_round_v_radius) ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.StvRoundImageView_stv_round_v_radius, this.c) : this.c;
        obtainStyledAttributes.recycle();
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        Matrix imageMatrix = getImageMatrix();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        if (imageMatrix == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
            drawable.draw(canvas);
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 16 && getCropToPadding()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
        }
        canvas.translate(getPaddingLeft(), getPaddingTop());
        int i = this.b;
        if (i == 1) {
            this.a.setShader(new BitmapShader(a(drawable), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.a);
        } else if (i == 2) {
            this.a.setShader(new BitmapShader(a(drawable), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            int i2 = this.c;
            canvas.drawRoundRect(rectF, i2, i2, this.a);
        } else {
            if (imageMatrix != null) {
                canvas.concat(imageMatrix);
            }
            drawable.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    protected void onMeasure(int i, int i2) {
        if (this.b != 1) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
        int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
        setMeasuredDimension(min, min);
    }

    public void setShapeType(int i) {
        this.b = i;
    }
}
