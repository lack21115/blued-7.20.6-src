package com.blued.android.framework.view;

import android.view.View;
import android.widget.AbsListView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/OnDistanceScrollListener.class */
public class OnDistanceScrollListener implements AbsListView.OnScrollListener {
    private ScrollDistanceListener a;
    private boolean b = false;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/OnDistanceScrollListener$ScrollDistanceListener.class */
    public interface ScrollDistanceListener {
        void a(int i, int i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4;
        if (i3 != 0) {
            int i5 = 0;
            if (absListView.getChildAt(0) == null) {
                return;
            }
            View childAt = absListView.getChildAt(0);
            if (!this.b) {
                this.c = absListView.getFirstVisiblePosition();
                this.e = childAt.getTop();
                this.f = childAt.getBottom();
                this.d = childAt.getHeight();
                this.b = true;
                this.g = 0;
            }
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int height = childAt.getHeight();
            int i6 = this.e;
            if (i6 != top) {
                int i7 = this.c;
                if (i > i7) {
                    int i8 = i6 + this.d;
                    this.e = i8;
                    i5 = top - i8;
                } else {
                    if (i < i7) {
                        i4 = this.f - this.d;
                        this.f = i4;
                    } else {
                        i4 = this.f;
                    }
                    i5 = bottom - i4;
                }
            }
            int i9 = this.g + i5;
            this.g = i9;
            ScrollDistanceListener scrollDistanceListener = this.a;
            if (scrollDistanceListener != null) {
                scrollDistanceListener.a(i5, i9);
            }
            this.e = top;
            this.f = bottom;
            this.d = height;
            this.c = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0 && i == 0) {
            this.b = false;
        }
    }
}
