package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/guide/install/ClipImageView.class */
public class ClipImageView extends ImageView {
    private RectF b;
    private float[] h;
    private Paint hj;
    private boolean mb;
    private Path ox;

    public ClipImageView(Context context) {
        super(context);
        this.mb = true;
        mb(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mb = true;
        mb(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mb = true;
        mb(context);
    }

    protected void mb(Context context) {
        this.ox = new Path();
        this.b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mb) {
            this.ox.reset();
            this.b.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.h;
            if (fArr != null) {
                this.ox.addRoundRect(this.b, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.ox);
            Paint paint = this.hj;
            if (paint != null) {
                canvas.drawPath(this.ox, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.hj = paint;
        paint.setStyle(Paint.Style.FILL);
        this.hj.setColor(i);
    }

    public void setClip(boolean z) {
        this.mb = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.h = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }
}
