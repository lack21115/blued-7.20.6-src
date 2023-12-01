package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/HorizontalScrollView.class */
public class HorizontalScrollView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f14744a;
    private VerticalTextView b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14745c;
    private float d;
    private int e;
    private float f;
    private float g;
    private boolean h;
    private int i;
    private ValueAnimator j;
    private OnReleaseListener k;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/HorizontalScrollView$OnReleaseListener.class */
    public interface OnReleaseListener {
        void a();
    }

    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14745c = true;
        this.d = 0.0f;
        this.e = 0;
        this.h = false;
        this.i = 0;
        this.e = -DensityUtils.a(context, 32.0f);
    }

    private void setHintTextTranslationX(float f) {
        VerticalTextView verticalTextView;
        if (!this.f14745c || (verticalTextView = this.b) == null) {
            return;
        }
        float f2 = this.d + f;
        this.d = f2;
        int i = this.e;
        if (f2 <= i) {
            f2 = i;
            verticalTextView.setVerticalText("更多");
        } else {
            verticalTextView.setVerticalText("更多");
        }
        this.b.a(f2, this.e);
        this.b.setTranslationX(f2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view instanceof RecyclerView) {
            this.f14744a = (RecyclerView) view;
        } else if (view instanceof VerticalTextView) {
            this.b = (VerticalTextView) view;
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r0 != 3) goto L14;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.HorizontalScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean getShowMore() {
        return this.f14745c;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        VerticalTextView verticalTextView = this.b;
        if (verticalTextView != null) {
            int i5 = -verticalTextView.getWidth();
            this.e = i5;
            int i6 = i5;
            if (i5 == 0) {
                i6 = -DensityUtils.a(getContext(), 32.0f);
            }
            this.e = i6;
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setOnReleaseListener(OnReleaseListener onReleaseListener) {
        this.k = onReleaseListener;
    }

    public void setShowMore(boolean z) {
        this.f14745c = z;
    }
}
