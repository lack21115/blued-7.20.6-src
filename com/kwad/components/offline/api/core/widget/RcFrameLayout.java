package com.kwad.components.offline.api.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.core.utils.TkViewRCHelper;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/widget/RcFrameLayout.class */
public class RcFrameLayout extends FrameLayout {
    private float mRatio;
    private TkViewRCHelper mViewRCHelper;
    private boolean widthBasedRatio;

    public RcFrameLayout(Context context) {
        super(context);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    private float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    private void init(Context context, AttributeSet attributeSet) {
        TkViewRCHelper tkViewRCHelper = new TkViewRCHelper();
        this.mViewRCHelper = tkViewRCHelper;
        tkViewRCHelper.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    protected boolean enableFirstVisible() {
        return true;
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i4 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
                i3 = i;
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.mRatio), 1073741824);
                i4 = i2;
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    public void setRadius(float f, float f2, float f3, float f4) {
        this.mViewRCHelper.setRadius(getRadius(f, f2, f3, f4));
        postInvalidate();
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }
}
