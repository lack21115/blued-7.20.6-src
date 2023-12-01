package com.blued.android.core.utils.swipeback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.blued.blued_core.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/swipeback/SwipeBackLayout.class */
public class SwipeBackLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f9744a = {1, 2, 8, 11};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private float f9745c;
    private boolean d;
    private View e;
    private ViewDragHelper f;
    private float g;
    private int h;
    private int i;
    private List<SwipeListener> j;
    private Drawable k;
    private Drawable l;
    private Drawable m;
    private float n;
    private boolean o;
    private Rect p;
    private int q;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/swipeback/SwipeBackLayout$SwipeListener.class */
    public interface SwipeListener {
        void a();

        void a(int i);

        void a(int i, float f);

        void a(int i, int i2, float f, float f2, float f3);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/swipeback/SwipeBackLayout$SwipeListenerEx.class */
    public interface SwipeListenerEx extends SwipeListener {
        void b();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/swipeback/SwipeBackLayout$ViewDragCallback.class */
    class ViewDragCallback extends ViewDragHelper.Callback {
        private boolean b;

        private ViewDragCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int i3 = 0;
            if ((SwipeBackLayout.this.q & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i, 0));
            }
            if ((SwipeBackLayout.this.q & 2) != 0) {
                i3 = Math.min(0, Math.max(i, -view.getWidth()));
            }
            return i3;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            int i3 = 0;
            if ((SwipeBackLayout.this.q & 8) != 0) {
                i3 = Math.min(0, Math.max(i, -view.getHeight()));
            }
            return i3;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SwipeBackLayout.this.b & 3;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SwipeBackLayout.this.b & 8;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            if (SwipeBackLayout.this.j == null || SwipeBackLayout.this.j.isEmpty()) {
                return;
            }
            for (SwipeListener swipeListener : SwipeBackLayout.this.j) {
                swipeListener.a(i, SwipeBackLayout.this.g);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            if ((SwipeBackLayout.this.q & 1) != 0) {
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                swipeBackLayout.g = Math.abs(i / (swipeBackLayout.e.getWidth() + SwipeBackLayout.this.k.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.q & 2) != 0) {
                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                swipeBackLayout2.g = Math.abs(i / (swipeBackLayout2.e.getWidth() + SwipeBackLayout.this.l.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.q & 8) != 0) {
                SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                swipeBackLayout3.g = Math.abs(i2 / (swipeBackLayout3.e.getHeight() + SwipeBackLayout.this.m.getIntrinsicHeight()));
            }
            SwipeBackLayout.this.h = i;
            SwipeBackLayout.this.i = i2;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.g < SwipeBackLayout.this.f9745c && !this.b) {
                this.b = true;
            }
            if (SwipeBackLayout.this.j != null && !SwipeBackLayout.this.j.isEmpty()) {
                for (SwipeListener swipeListener : SwipeBackLayout.this.j) {
                    swipeListener.a(SwipeBackLayout.this.f.getViewDragState(), SwipeBackLayout.this.g);
                }
            }
            if (SwipeBackLayout.this.j != null && !SwipeBackLayout.this.j.isEmpty() && SwipeBackLayout.this.f.getViewDragState() == 1 && SwipeBackLayout.this.g >= SwipeBackLayout.this.f9745c && this.b) {
                this.b = false;
                for (SwipeListener swipeListener2 : SwipeBackLayout.this.j) {
                    swipeListener2.a();
                }
            }
            if (SwipeBackLayout.this.g < 1.0f || SwipeBackLayout.this.j == null || SwipeBackLayout.this.j.isEmpty()) {
                return;
            }
            for (SwipeListener swipeListener3 : SwipeBackLayout.this.j) {
                if (swipeListener3 instanceof SwipeListenerEx) {
                    ((SwipeListenerEx) swipeListener3).b();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
            if (r7.f9746a.g > r7.f9746a.f9745c) goto L43;
         */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.utils.swipeback.SwipeBackLayout.ViewDragCallback.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            boolean checkTouchSlop;
            boolean z;
            boolean isEdgeTouched = SwipeBackLayout.this.f.isEdgeTouched(SwipeBackLayout.this.b, i);
            if (isEdgeTouched) {
                if (SwipeBackLayout.this.f.isEdgeTouched(1, i)) {
                    SwipeBackLayout.this.q = 1;
                } else if (SwipeBackLayout.this.f.isEdgeTouched(2, i)) {
                    SwipeBackLayout.this.q = 2;
                } else if (SwipeBackLayout.this.f.isEdgeTouched(8, i)) {
                    SwipeBackLayout.this.q = 8;
                }
                if (SwipeBackLayout.this.j != null && !SwipeBackLayout.this.j.isEmpty()) {
                    for (SwipeListener swipeListener : SwipeBackLayout.this.j) {
                        swipeListener.a(SwipeBackLayout.this.q);
                    }
                }
                this.b = true;
            }
            if (SwipeBackLayout.this.b == 1 || SwipeBackLayout.this.b == 2) {
                checkTouchSlop = SwipeBackLayout.this.f.checkTouchSlop(2, i);
            } else if (SwipeBackLayout.this.b != 8) {
                z = SwipeBackLayout.this.b == 11;
                return isEdgeTouched & z;
            } else {
                checkTouchSlop = SwipeBackLayout.this.f.checkTouchSlop(1, i);
            }
            z = true ^ checkTouchSlop;
            return isEdgeTouched & z;
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f9745c = 0.3f;
        this.d = true;
        this.p = new Rect();
        this.f = ViewDragHelper.create(this, 2.0f, new ViewDragCallback());
        setEdgeTrackingEnabled(1);
        a(R.drawable.blued_swipeback_shadow, 1);
        this.f.setMinVelocity(getResources().getDisplayMetrics().density * 100.0f);
    }

    private void a(Canvas canvas, View view) {
        Rect rect = this.p;
        view.getHitRect(rect);
        int i = this.b;
        if ((i & 1) != 0) {
            this.k.setBounds(rect.left - this.k.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.k.setAlpha((int) (this.n * 255.0f));
            this.k.draw(canvas);
        } else if ((i & 2) != 0) {
            this.l.setBounds(rect.right, rect.top, rect.right + this.l.getIntrinsicWidth(), rect.bottom);
            this.l.setAlpha((int) (this.n * 255.0f));
            this.l.draw(canvas);
        } else if ((i & 8) != 0) {
            this.m.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.m.getIntrinsicHeight());
            this.m.setAlpha((int) (this.n * 255.0f));
            this.m.draw(canvas);
        }
    }

    public void a(int i, int i2) {
        a(getResources().getDrawable(i), i2);
    }

    public void a(Drawable drawable, int i) {
        if ((i & 1) != 0) {
            this.k = drawable;
        } else if ((i & 2) != 0) {
            this.l = drawable;
        } else if ((i & 8) != 0) {
            this.m = drawable;
        }
        invalidate();
    }

    public void a(SwipeListener swipeListener) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(swipeListener);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.n = 1.0f - this.g;
        if (this.f.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view == this.e;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.n > 0.0f && z && this.f.getViewDragState() != 0) {
            a(canvas, view);
        }
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            try {
                return this.f.shouldInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.o = true;
        View view = this.e;
        if (view != null) {
            int i5 = this.h;
            view.layout(i5, this.i, view.getMeasuredWidth() + i5, this.i + this.e.getMeasuredHeight());
        }
        this.o = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            try {
                this.f.processTouchEvent(motionEvent);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.o) {
            return;
        }
        super.requestLayout();
    }

    public void setContentView(View view) {
        this.e = view;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.b = i;
        this.q = i;
        this.f.setEdgeTrackingEnabled(i);
    }

    public void setEnableGesture(boolean z) {
        this.d = z;
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.f9745c = f;
    }

    @Deprecated
    public void setSwipeListener(SwipeListener swipeListener) {
        a(swipeListener);
    }
}
