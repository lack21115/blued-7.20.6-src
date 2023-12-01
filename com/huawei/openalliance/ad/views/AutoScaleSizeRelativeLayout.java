package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.base.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/AutoScaleSizeRelativeLayout.class */
public class AutoScaleSizeRelativeLayout extends RelativeLayout {
    private Path B;
    private boolean C;
    private Float Code;
    private float I;
    private final RectF V;

    public AutoScaleSizeRelativeLayout(Context context) {
        super(context);
        this.V = new RectF();
        this.I = 0.0f;
        this.C = true;
        Code(context, (AttributeSet) null);
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = new RectF();
        this.I = 0.0f;
        this.C = true;
        Code(context, attributeSet);
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = new RectF();
        this.I = 0.0f;
        this.C = true;
        Code(context, attributeSet);
    }

    private int Code(int i, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        float f2 = (i * 1.0f) / f;
        return Z() ? (int) Math.ceil(f2) : (int) f2;
    }

    private void Code() {
        this.B.reset();
        Path path = this.B;
        RectF rectF = this.V;
        float f = this.I;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.I = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.B = new Path();
    }

    private int V(int i, float f) {
        float f2 = f * i;
        return Z() ? (int) Math.ceil(f2) : (int) f2;
    }

    protected boolean Z() {
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.I > 0.01f) {
            canvas.clipPath(this.B);
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.V.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Code();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int Code;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.C && layoutParams != null && layoutParams.width == -1 && layoutParams.height == -1) {
            super.onMeasure(i, i2);
            return;
        }
        Float f = this.Code;
        int i3 = i;
        int i4 = i2;
        if (f != null) {
            i3 = i;
            i4 = i2;
            if (f.floatValue() > 0.01f) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                if (View.MeasureSpec.getMode(i2) != 1073741824 && (size <= 0 || size2 <= 0)) {
                    Code = Code(size, this.Code.floatValue());
                } else if ((size * 1.0f) / size2 > this.Code.floatValue()) {
                    size = V(size2, this.Code.floatValue());
                    Code = size2;
                } else {
                    Code = Code(size, this.Code.floatValue());
                }
                i3 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec(Code, 1073741824);
            }
        }
        super.onMeasure(i3, i4);
    }

    public void setRatio(Float f) {
        this.Code = f;
    }

    public void setRectCornerRadius(float f) {
        this.I = f;
        Code();
        postInvalidate();
    }

    public void setUseRatioInMatchParentMode(boolean z) {
        this.C = z;
    }
}
