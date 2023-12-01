package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/page/widget/RoundAngleImageView.class */
public class RoundAngleImageView extends ImageView {
    private float[] ahO;
    private Path mPath;
    private RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.ahO;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.ahO;
        float f = fArr2[0];
        float f2 = fArr2[3];
        float f3 = fArr2[1];
        float f4 = fArr2[7];
        this.mPath.rewind();
        float f5 = measuredWidth;
        if (f5 >= f + f2) {
            float f6 = measuredHeight;
            if (f6 > f3 + f4) {
                this.mRectF.set(0.0f, 0.0f, f5, f6);
                this.mPath.addRoundRect(this.mRectF, this.ahO, Path.Direction.CW);
                canvas.clipPath(this.mPath);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.ahO = new float[8];
        int i = 0;
        while (true) {
            int i2 = i;
            float[] fArr = this.ahO;
            if (i2 >= fArr.length) {
                return;
            }
            fArr[i2] = f;
            i = i2 + 1;
        }
    }

    public void setRadius(float[] fArr) {
        this.ahO = new float[8];
        int i = 0;
        while (true) {
            int i2 = i;
            float[] fArr2 = this.ahO;
            if (i2 >= fArr2.length) {
                return;
            }
            fArr2[i2] = fArr[i2];
            i = i2 + 1;
        }
    }
}
