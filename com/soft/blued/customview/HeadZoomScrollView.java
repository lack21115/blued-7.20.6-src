package com.soft.blued.customview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.NestedScrollView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/HeadZoomScrollView.class */
public class HeadZoomScrollView extends NestedScrollView {

    /* renamed from: a  reason: collision with root package name */
    private float f14738a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14739c;
    private boolean d;
    private View e;
    private float f;
    private float g;
    private float h;
    private Interpolator i;
    private boolean j;
    private boolean k;
    private OnScrollListener l;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/HeadZoomScrollView$OnScrollListener.class */
    public interface OnScrollListener {
        void a(int i, int i2, int i3, int i4);

        void a(int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams);
    }

    public HeadZoomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14738a = 0.0f;
        this.b = 0;
        this.f14739c = 0;
        this.d = false;
        this.f = 0.4f;
        this.g = 1.5f;
        this.h = 1.2f;
        this.j = false;
        this.k = true;
    }

    public HeadZoomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14738a = 0.0f;
        this.b = 0;
        this.f14739c = 0;
        this.d = false;
        this.f = 0.4f;
        this.g = 1.5f;
        this.h = 1.2f;
        this.j = false;
        this.k = true;
    }

    private void a() {
        float measuredWidth = this.e.getMeasuredWidth() - this.b;
        ValueAnimator duration = ObjectAnimator.ofFloat(measuredWidth, 0.0f).setDuration(this.h * measuredWidth);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.HeadZoomScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HeadZoomScrollView.this.setZoom(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        Interpolator interpolator = this.i;
        if (interpolator != null && measuredWidth > 150.0f) {
            duration.setInterpolator(interpolator);
        }
        this.j = false;
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoom(float f) {
        int i;
        if (((float) ((i + f) / (this.b * 1.0d))) > this.g) {
            if (this.k) {
                this.d = false;
                a();
            }
            this.j = false;
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        int i2 = this.b;
        layoutParams.width = (int) Math.max(i2 + f, i2);
        float f2 = this.f14739c;
        int i3 = this.b;
        layoutParams.height = (int) (f2 * ((i3 + f) / i3));
        int i4 = (-(layoutParams.width - this.b)) / 2;
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(i4, 0, i4, 0);
        this.e.setLayoutParams(layoutParams);
        OnScrollListener onScrollListener = this.l;
        if (onScrollListener != null) {
            onScrollListener.a(layoutParams.width, layoutParams.height, this.b, this.f14739c, layoutParams);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOverScrollMode(2);
        if (getChildAt(0) != null && (getChildAt(0) instanceof ViewGroup) && this.e == null) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(0);
            if (viewGroup.getChildCount() > 0) {
                this.e = viewGroup.getChildAt(0);
            }
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.j = true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.l;
        if (onScrollListener != null) {
            onScrollListener.a(i, i2, i3, i4);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b <= 0 || this.f14739c <= 0) {
            this.b = this.e.getMeasuredWidth();
            this.f14739c = this.e.getMeasuredHeight();
        }
        if (this.e == null || this.b <= 0 || this.f14739c <= 0) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.j = true;
            } else if (action != 1) {
                if (action == 2 && this.j) {
                    if (!this.d) {
                        if (getScrollY() == 0) {
                            this.f14738a = motionEvent.getY();
                        }
                    }
                    int y = (int) ((motionEvent.getY() - this.f14738a) * this.f);
                    if (y >= 0) {
                        this.d = true;
                        setZoom(y);
                        return true;
                    }
                }
            } else if (this.j) {
                this.d = false;
                a();
            }
        } catch (Exception e) {
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.i = interpolator;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.l = onScrollListener;
    }

    public void setOverBack(boolean z) {
        this.k = z;
    }

    public void setReplyRatio(float f) {
        this.h = f;
    }

    public void setScaleRatio(float f) {
        this.f = f;
    }

    public void setScaleTimes(float f) {
        this.g = f;
    }

    public void setZoomView(View view) {
        this.e = view;
    }
}
