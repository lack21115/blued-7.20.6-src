package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/KSLinearLayout.class */
public class KSLinearLayout extends LinearLayout implements i {
    private final AtomicBoolean mIsViewDetached;
    private float mRatio;
    private final ac.a mTouchCoords;
    private g mViewPvHelper;
    private h mViewRCHelper;
    private i mViewVisibleListener;

    public KSLinearLayout(Context context) {
        super(context);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        init(context, null);
    }

    public KSLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        init(context, attributeSet);
    }

    public KSLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.mTouchCoords = new ac.a();
        init(context, attributeSet);
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
        g gVar = new g(this, this);
        this.mViewPvHelper = gVar;
        gVar.bJ(true);
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    private void onViewAttached() {
        this.mViewPvHelper.onAttachedToWindow();
    }

    private void onViewDetached() {
        this.mViewPvHelper.onDetachedFromWindow();
    }

    private void viewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i("KSLinearLayout", "onViewAttached");
            onViewAttached();
        }
    }

    private void viewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i("KSLinearLayout", "onViewDetached");
        onViewDetached();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
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

    public ac.a getTouchCoords() {
        return this.mTouchCoords;
    }

    public float getVisiblePercent() {
        return this.mViewPvHelper.getVisiblePercent();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        viewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        viewDetached();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        viewAttached();
    }

    @Override // com.kwad.sdk.widget.i
    public void onFirstVisible(View view) {
        i iVar = this.mViewVisibleListener;
        if (iVar != null) {
            iVar.onFirstVisible(view);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
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

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
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
}
