package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/KSFrameLayout.class */
public class KSFrameLayout extends FrameLayout implements e, i {
    private static final String TAG = "KSFrameLayout";
    private final AtomicBoolean mIsViewDetached;
    private View mPvView;
    private float mRatio;
    private final ac.a mTouchCoords;
    private g mViewPvHelper;
    private h mViewRCHelper;
    private i mViewVisibleListener;
    private boolean widthBasedRatio;

    public KSFrameLayout(Context context) {
        super(context);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        init(context, null);
    }

    public KSFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(Context context, View view) {
        super(context);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        this.widthBasedRatio = true;
        this.mPvView = view;
        init(context, null);
    }

    private View getPvView() {
        View view = this.mPvView;
        return view == null ? this : view;
    }

    private float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(getPvView(), this);
        this.mViewPvHelper = gVar;
        gVar.bJ(enableFirstVisible());
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    private void viewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i(TAG, "onViewAttached");
            onViewAttached();
        }
    }

    private void viewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i(TAG, "onViewDetached");
        onViewDetached();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchCoords.u(getWidth(), getHeight());
            this.mTouchCoords.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.mTouchCoords.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
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

    @Override // com.kwad.sdk.widget.e
    public ac.a getTouchCoords() {
        return this.mTouchCoords;
    }

    public float getVisiblePercent() {
        return this.mViewPvHelper.getVisiblePercent();
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        viewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        viewDetached();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        viewAttached();
    }

    public void onFirstVisible(View view) {
        i iVar = this.mViewVisibleListener;
        if (iVar != null) {
            iVar.onFirstVisible(view);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
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
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mViewPvHelper.b(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewPvHelper.FB();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        viewDetached();
    }

    public void onViewAttached() {
        this.mViewPvHelper.onAttachedToWindow();
    }

    public void onViewDetached() {
        this.mViewPvHelper.onDetachedFromWindow();
    }

    public void resetPvAfterDataChange() {
        this.mViewPvHelper.resetPvAfterDataChange();
    }

    public void setAllCorner(boolean z) {
        this.mViewRCHelper.getCornerConf().setAllCorner(z);
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

    public void setViewVisibleListener(i iVar) {
        this.mViewVisibleListener = iVar;
    }

    public void setVisiblePercent(float f) {
        this.mViewPvHelper.setVisiblePercent(f);
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }
}
