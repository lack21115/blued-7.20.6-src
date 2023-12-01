package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/widget/TextProgressBar.class */
public class TextProgressBar extends ProgressBar {
    private boolean NB;
    private int NC;
    private int ND;
    private Drawable NE;
    private int NF;
    private Rect NG;
    private int[] NH;
    private int NI;
    private int NJ;
    private boolean NK;
    private String Nv;
    private LinearGradient Nw;
    private Matrix Nx;
    private boolean Ny;
    private boolean Nz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(k.wrapContextIfNeed(context), attributeSet);
        this.Nz = false;
        this.NB = true;
        this.NG = new Rect();
        oV();
    }

    private void oV() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.kwai.a.a(getContext(), 12.0f));
        this.NF = com.kwad.sdk.c.kwai.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.NI = -1;
        this.NJ = -117146;
    }

    private void setProgressText(int i) {
        int max = (int) (((i * 1.0f) / getMax()) * 100.0f);
        this.Nv = String.valueOf(max) + "%";
    }

    public final void f(String str, int i) {
        this.Nv = str;
        this.Ny = true;
        setProgress(i);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        synchronized (this) {
            if (this.Nz) {
                canvas.save();
                canvas.rotate(90.0f);
                canvas.translate(0.0f, -getWidth());
                super.onDraw(canvas);
                canvas.restore();
            } else {
                super.onDraw(canvas);
            }
            if (!TextUtils.isEmpty(this.Nv)) {
                this.mPaint.getTextBounds(this.Nv, 0, this.Nv.length(), this.NG);
            }
            int height = (getHeight() / 2) - this.NG.centerY();
            if (this.NE != null) {
                int intrinsicWidth = this.NE.getIntrinsicWidth();
                int intrinsicHeight = this.NE.getIntrinsicHeight();
                int width2 = (((getWidth() - this.NG.width()) - intrinsicWidth) - this.NF) / 2;
                Drawable drawable = this.NE;
                int height2 = (getHeight() - intrinsicHeight) / 2;
                int i = intrinsicWidth + width2;
                drawable.setBounds(width2, height2, i, (getHeight() + intrinsicHeight) / 2);
                this.NE.draw(canvas);
                width = i + this.NF;
            } else {
                width = (getWidth() / 2) - this.NG.centerX();
            }
            if (this.NH != null) {
                float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
                float f = width;
                if (progress >= f) {
                    if (this.Nw == null) {
                        this.Nw = new LinearGradient(f, 0.0f, width + this.NG.width(), 0.0f, this.NH, (float[]) null, Shader.TileMode.CLAMP);
                        Matrix matrix = new Matrix();
                        this.Nx = matrix;
                        this.Nw.setLocalMatrix(matrix);
                    }
                    this.mPaint.setShader(this.Nw);
                    this.Nx.setScale(((progress - f) * 1.0f) / this.NG.width(), 1.0f, f, 0.0f);
                    this.Nw.setLocalMatrix(this.Nx);
                } else {
                    this.mPaint.setShader(null);
                }
                canvas.drawText(this.Nv, f, height, this.mPaint);
                return;
            }
            if (!isIndeterminate() && !this.NK) {
                this.mPaint.setColor(this.NI);
                if (this.Nv != null) {
                    canvas.drawText(this.Nv, width, height, this.mPaint);
                }
                return;
            }
            float width3 = (getWidth() * getProgress()) / getMax();
            int save = canvas.save();
            this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
            canvas.clipRect(this.mRectF);
            this.mPaint.setColor(this.NJ);
            if (this.Nv != null) {
                canvas.drawText(this.Nv, width, height, this.mPaint);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            this.mRectF.set(0.0f, 0.0f, width3, getHeight());
            canvas.clipRect(this.mRectF);
            this.mPaint.setColor(this.NI);
            if (this.Nv != null) {
                canvas.drawText(this.Nv, width, height, this.mPaint);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int i, int i2) {
        synchronized (this) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i3 = i;
            int i4 = i2;
            if (layoutParams != null) {
                i3 = i;
                i4 = i2;
                if (!TextUtils.isEmpty(this.Nv)) {
                    Rect rect = new Rect();
                    this.mPaint.getTextBounds(this.Nv, 0, this.Nv.length(), rect);
                    if (layoutParams.width == -2) {
                        layoutParams.width = rect.width() + this.NC + this.ND;
                        i = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    }
                    i3 = i;
                    i4 = i2;
                    if (layoutParams.height == -2) {
                        layoutParams.height = rect.height();
                        i4 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                        i3 = i;
                    }
                }
            }
            if (!this.Nz) {
                super.onMeasure(i3, i4);
                return;
            }
            super.onMeasure(i4, i3);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.Nz) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.NE = drawable;
    }

    public void setDrawablePadding(int i) {
        this.NF = i;
    }

    public void setHasProgress(boolean z) {
        this.NB = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.NC = i;
        this.ND = i3;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.NB) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i) {
        this.NK = false;
        this.NI = i;
        postInvalidate();
    }

    public final void setTextColor(int i, int i2) {
        this.NK = true;
        this.NI = i;
        this.NJ = i2;
        postInvalidate();
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.Nz = z;
    }
}
