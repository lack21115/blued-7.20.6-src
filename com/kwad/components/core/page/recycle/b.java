package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/b.class */
public class b extends g {
    private Rect Mo;
    private int Mp;
    private int Mq;
    private boolean Mr;
    private int Ms;
    private a Mt;
    private boolean Mu;
    private boolean Mv;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/b$a.class */
    public interface a {
        boolean oJ();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ms = Integer.MIN_VALUE;
        this.Mv = false;
    }

    private void a(int i, int i2, int i3) {
        while (true) {
            if (this.Ms == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Ms = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i >= findFirstVisibleItemPosition && i <= findLastVisibleItemPosition) {
                int i4 = i - findFirstVisibleItemPosition;
                if (getChildCount() > i4) {
                    View childAt = getChildAt(i4);
                    int[] iArr2 = new int[2];
                    childAt.getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.Ms) - i3);
                    return;
                }
                return;
            } else if (i > findLastVisibleItemPosition) {
                scrollBy(0, i2);
                a(i, i2, i3);
                return;
            } else {
                scrollBy(0, -i2);
            }
        }
    }

    private void oH() {
        Rect rect = this.Mo;
        if (rect == null) {
            this.Mo = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                this.Mo.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
            i = i2 + 1;
        }
    }

    private void oI() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).oM();
        }
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        a(i, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        oI();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Mp != 0) {
            oH();
            Rect rect = this.Mo;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Mo);
                canvas.drawColor(this.Mp);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Mu) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Mv) {
            stopScroll();
        }
        a aVar = this.Mt;
        if (aVar == null || !aVar.oJ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.Mq;
        int i4 = i2;
        if (i3 > 0) {
            i4 = i2;
            if (i3 < size) {
                i4 = View.MeasureSpec.makeMeasureSpec(this.Mq, View.MeasureSpec.getMode(i2));
            }
        }
        super.onMeasure(i, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Mu) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.Mr) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.Mu = z;
    }

    public void setDownStop(boolean z) {
        this.Mv = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Mt = aVar;
    }

    public void setUnderneathColor(int i) {
        this.Mp = i;
        oH();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.Mr = z;
    }
}
