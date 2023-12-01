package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.r.n;
import com.kwad.sdk.utils.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/DetailWebRecycleView.class */
public class DetailWebRecycleView extends b {
    private int MA;
    private boolean MB;
    a MC;
    private Runnable MD;
    private n ME;
    private int Mw;
    private boolean Mx;
    private boolean My;
    private int Mz;
    private int mA;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/DetailWebRecycleView$a.class */
    public interface a {
        boolean oK();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Mw = 1000;
        this.Mx = false;
        this.My = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object d = s.d(DetailWebRecycleView.this, "mGapWorker");
                    if (d != null) {
                        s.a(d, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Mw));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                }
            }
        };
        this.MD = runnable;
        this.ME = new n(runnable);
        this.mA = context instanceof Activity ? com.kwad.sdk.c.kwai.a.d((Activity) context) : com.kwad.sdk.c.kwai.a.getScreenHeight(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.ME, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.ME);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.MC;
        if (aVar == null || !aVar.oK()) {
            this.MA = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.Mz - this.MA) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.MA = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.Mz) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.MA = computeVerticalScrollOffset;
        if ((i2 > 0 && computeVerticalScrollOffset < this.Mz) && !this.MB && this.MA < this.mA) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.MA > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom();
                int paddingBottom = getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 - paddingBottom && position == getLayoutManager().getItemCount() - 1) {
                    this.MB = true;
                    return;
                }
            }
            this.MB = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.My) {
            this.My = false;
        } else if (this.Mx) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Mx = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.My = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.MC = aVar;
    }

    public void setTopViewHeight(int i) {
        this.Mz = i;
    }
}
