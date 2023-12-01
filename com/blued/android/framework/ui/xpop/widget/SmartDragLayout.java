package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator;
import com.blued.android.framework.ui.xpop.enums.LayoutStatus;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/SmartDragLayout.class */
public class SmartDragLayout extends FrameLayout implements NestedScrollingParent {
    OverScroller a;
    VelocityTracker b;
    ShadowBgAnimator c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    LayoutStatus i;
    int j;
    int k;
    int l;
    float m;
    float n;
    boolean o;
    private View p;
    private OnCloseListener q;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/SmartDragLayout$OnCloseListener.class */
    public interface OnCloseListener {
        void a();

        void a(int i, float f, boolean z);

        void b();
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ShadowBgAnimator();
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = false;
        this.h = false;
        this.i = LayoutStatus.Close;
        if (this.d) {
            this.a = new OverScroller(context);
        }
    }

    private void c() {
        int scrollY;
        if (this.d) {
            int scrollY2 = (getScrollY() > (this.o ? this.j - this.k : (this.j - this.k) * 2) / 3 ? this.j : this.k) - getScrollY();
            if (this.h) {
                int i = this.j / 3;
                float f = i;
                float f2 = 2.5f * f;
                if (getScrollY() > f2) {
                    i = this.j;
                    scrollY = getScrollY();
                } else if (getScrollY() <= f2 && getScrollY() > f * 1.5f) {
                    i *= 2;
                    scrollY = getScrollY();
                } else if (getScrollY() > i) {
                    scrollY = getScrollY();
                } else {
                    i = this.k;
                    scrollY = getScrollY();
                }
                scrollY2 = i - scrollY;
            }
            this.a.startScroll(getScrollX(), getScrollY(), 0, scrollY2, XPopup.b());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.widget.SmartDragLayout.1
            @Override // java.lang.Runnable
            public void run() {
                int scrollY = SmartDragLayout.this.j - SmartDragLayout.this.getScrollY();
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                int i = scrollY;
                if (smartDragLayout.d) {
                    i = scrollY;
                    if (SmartDragLayout.this.h) {
                        i = scrollY / 3;
                    }
                }
                smartDragLayout.a(i, true);
                SmartDragLayout.this.i = LayoutStatus.Opening;
            }
        });
    }

    public void a(final int i, final boolean z) {
        post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.widget.SmartDragLayout.3
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout.this.a.startScroll(SmartDragLayout.this.getScrollX(), SmartDragLayout.this.getScrollY(), 0, i, (int) (z ? XPopup.b() : XPopup.b() * 0.8f));
                ViewCompat.postInvalidateOnAnimation(SmartDragLayout.this);
            }
        });
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b() {
        this.g = true;
        post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.widget.SmartDragLayout.2
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout.this.a.abortAnimation();
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                smartDragLayout.a(smartDragLayout.k - SmartDragLayout.this.getScrollY(), false);
                SmartDragLayout.this.i = LayoutStatus.Closing;
            }
        });
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void c(boolean z) {
        this.e = z;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.a.computeScrollOffset()) {
            scrollTo(this.a.getCurrX(), this.a.getCurrY());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void d(boolean z) {
        this.f = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.g = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o = false;
        this.g = false;
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j = this.p.getMeasuredHeight();
        this.k = 0;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.p.getMeasuredWidth() / 2);
        if (this.d) {
            this.p.layout(measuredWidth, getMeasuredHeight(), this.p.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.j);
            if (this.i == LayoutStatus.Open) {
                if (this.h) {
                    scrollTo(getScrollX(), getScrollY() - (this.l - this.j));
                } else {
                    scrollTo(getScrollX(), getScrollY() - (this.l - this.j));
                }
            }
        } else {
            this.p.layout(measuredWidth, getMeasuredHeight() - this.p.getMeasuredHeight(), this.p.getMeasuredWidth() + measuredWidth, getMeasuredHeight());
        }
        this.l = this.j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!(getScrollY() > this.k && getScrollY() < this.j) || f2 >= -1500.0f || this.h) {
            return false;
        }
        b();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            int scrollY = getScrollY() + i2;
            if (scrollY < this.j) {
                iArr[1] = i2;
            }
            scrollTo(getScrollX(), scrollY);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY() + i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.a.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return i == 2 && this.d;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        c();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        if (this.d && this.a.computeScrollOffset()) {
            this.m = 0.0f;
            this.n = 0.0f;
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.d) {
                VelocityTracker velocityTracker3 = this.b;
                if (velocityTracker3 != null) {
                    velocityTracker3.clear();
                }
                this.b = VelocityTracker.obtain();
            }
            this.m = motionEvent.getX();
            this.n = motionEvent.getY();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                if (!this.d || (velocityTracker2 = this.b) == null) {
                    return true;
                }
                velocityTracker2.addMovement(motionEvent);
                this.b.computeCurrentVelocity(1000);
                scrollTo(getScrollX(), getScrollY() - ((int) (motionEvent.getY() - this.n)));
                this.n = motionEvent.getY();
                return true;
            } else if (action != 3) {
                return true;
            }
        }
        Rect rect = new Rect();
        this.p.getGlobalVisibleRect(rect);
        if (!XPopupUtils.a(motionEvent.getRawX(), motionEvent.getRawY(), rect) && this.e && ((float) Math.sqrt(Math.pow(motionEvent.getX() - this.m, 2.0d) + Math.pow(motionEvent.getY() - this.n, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
            performClick();
        }
        if (!this.d || (velocityTracker = this.b) == null) {
            return true;
        }
        if (velocityTracker.getYVelocity() <= 1500.0f || this.h) {
            c();
        } else {
            b();
        }
        this.b = null;
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.p = view;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        int i3 = this.j;
        int i4 = i2;
        if (i2 > i3) {
            i4 = i3;
        }
        int i5 = this.k;
        int i6 = i4;
        if (i4 < i5) {
            i6 = i5;
        }
        int i7 = this.k;
        float f = ((i6 - i7) * 1.0f) / (this.j - i7);
        this.o = i6 > getScrollY();
        if (this.f) {
            setBackgroundColor(this.c.a(f));
        }
        if (this.q != null) {
            if (this.g && f == 0.0f && this.i != LayoutStatus.Close) {
                this.i = LayoutStatus.Close;
                this.q.a();
            } else if (f == 1.0f && this.i != LayoutStatus.Open) {
                this.i = LayoutStatus.Open;
                this.q.b();
            }
            this.q.a(i6, f, this.o);
        }
        super.scrollTo(i, i6);
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.q = onCloseListener;
    }
}
