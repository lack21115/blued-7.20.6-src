package com.blued.android.framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SlideView.class */
public class SlideView extends HorizontalScrollView {
    private LinearLayout a;
    private View b;
    private OnSlideListener c;
    private int d;
    private int e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SlideView$OnSlideListener.class */
    public interface OnSlideListener {
        void a(View view, int i);
    }

    public SlideView(Context context) {
        super(context);
    }

    public SlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b() {
        LinearLayout linearLayout = this.a;
        if (linearLayout != null) {
            this.d = 0;
            int childCount = linearLayout.getChildCount();
            if (childCount <= 1) {
                this.d = 0;
                return;
            }
            this.b = this.a.getChildAt(0);
            for (int i = 1; i < childCount; i++) {
                this.d += this.a.getChildAt(i).getMeasuredWidth();
            }
        }
    }

    public void a() {
        if (getScrollX() != 0) {
            smoothScrollTo(0, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        if (this.a == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int scrollX = getScrollX();
        int action = motionEvent.getAction();
        int i = 2;
        if (action != 0) {
            if (action == 1) {
                double d = scrollX;
                int i2 = this.d;
                if (d - (i2 * 0.5d) > 0.0d) {
                    this.e = 2;
                } else {
                    this.e = 0;
                    i2 = 0;
                }
                smoothScrollTo(i2, 0);
                OnSlideListener onSlideListener = this.c;
                if (onSlideListener != null) {
                    if (i2 == 0) {
                        i = 0;
                    }
                    onSlideListener.a(this, i);
                }
            }
        } else if (this.c != null && this.e == 2 && (view = this.b) != null && x < view.getWidth() - this.d) {
            this.c.a(this, 1);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.a = (LinearLayout) getChildAt(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }

    public void setOnSlideListener(OnSlideListener onSlideListener) {
        this.c = onSlideListener;
    }
}
