package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator;
import com.blued.android.framework.ui.xpop.enums.LayoutStatus;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/PopupDrawerLayout.class */
public class PopupDrawerLayout extends FrameLayout {
    LayoutStatus a;
    ViewDragHelper b;
    View c;
    View d;
    public PopupPosition e;
    ShadowBgAnimator f;
    public boolean g;
    float h;
    public boolean i;
    public boolean j;
    float k;
    boolean l;
    boolean m;
    float n;
    float o;
    boolean p;
    boolean q;
    ViewDragHelper.Callback r;
    public boolean s;
    private OnCloseListener t;

    /* renamed from: com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/PopupDrawerLayout$2.class */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ PopupDrawerLayout a;

        @Override // java.lang.Runnable
        public void run() {
            this.a.b.smoothSlideViewTo(this.a.d, this.a.e == PopupPosition.Left ? 0 : this.a.d.getLeft() - this.a.d.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(this.a);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/PopupDrawerLayout$OnCloseListener.class */
    public interface OnCloseListener {
        void a();

        void a(int i, float f, boolean z);

        void b();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.e = PopupPosition.Left;
        this.f = new ShadowBgAnimator();
        this.g = false;
        this.h = 0.0f;
        this.i = true;
        this.j = true;
        this.l = false;
        this.m = false;
        ViewDragHelper.Callback callback = new ViewDragHelper.Callback() { // from class: com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout.1
            private void a(int i2, int i3) {
                if (PopupDrawerLayout.this.e == PopupPosition.Left) {
                    PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                    popupDrawerLayout.h = ((popupDrawerLayout.d.getMeasuredWidth() + i2) * 1.0f) / PopupDrawerLayout.this.d.getMeasuredWidth();
                    if (i2 == (-PopupDrawerLayout.this.d.getMeasuredWidth()) && PopupDrawerLayout.this.t != null && PopupDrawerLayout.this.a != LayoutStatus.Close) {
                        PopupDrawerLayout.this.a = LayoutStatus.Close;
                        PopupDrawerLayout.this.t.a();
                    }
                } else if (PopupDrawerLayout.this.e == PopupPosition.Right) {
                    PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                    popupDrawerLayout2.h = ((popupDrawerLayout2.getMeasuredWidth() - i2) * 1.0f) / PopupDrawerLayout.this.d.getMeasuredWidth();
                    if (i2 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.t != null && PopupDrawerLayout.this.a != LayoutStatus.Close) {
                        PopupDrawerLayout.this.a = LayoutStatus.Close;
                        PopupDrawerLayout.this.t.a();
                    }
                }
                if (PopupDrawerLayout.this.i) {
                    PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                    popupDrawerLayout3.setBackgroundColor(popupDrawerLayout3.f.a(PopupDrawerLayout.this.h));
                }
                if (PopupDrawerLayout.this.t != null) {
                    PopupDrawerLayout.this.t.a(i2, PopupDrawerLayout.this.h, i3 < 0);
                    if (PopupDrawerLayout.this.h != 1.0f || PopupDrawerLayout.this.a == LayoutStatus.Open) {
                        return;
                    }
                    PopupDrawerLayout.this.a = LayoutStatus.Open;
                    PopupDrawerLayout.this.t.b();
                }
            }

            public int clampViewPositionHorizontal(View view, int i2, int i3) {
                return view == PopupDrawerLayout.this.c ? i2 : PopupDrawerLayout.this.a(i2);
            }

            public int getViewHorizontalDragRange(View view) {
                return 1;
            }

            public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
                super.onViewPositionChanged(view, i2, i3, i4, i5);
                if (view != PopupDrawerLayout.this.c) {
                    a(i2, i4);
                    return;
                }
                PopupDrawerLayout.this.c.layout(0, 0, PopupDrawerLayout.this.c.getMeasuredWidth(), PopupDrawerLayout.this.c.getMeasuredHeight());
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                int a = popupDrawerLayout.a(popupDrawerLayout.d.getLeft() + i4);
                PopupDrawerLayout.this.d.layout(a, PopupDrawerLayout.this.d.getTop(), PopupDrawerLayout.this.d.getMeasuredWidth() + a, PopupDrawerLayout.this.d.getBottom());
                a(a, i4);
            }

            public void onViewReleased(View view, float f, float f2) {
                int measuredWidth;
                int measuredWidth2;
                super.onViewReleased(view, f, f2);
                if (view == PopupDrawerLayout.this.c && f == 0.0f) {
                    PopupDrawerLayout.this.a();
                } else if (view == PopupDrawerLayout.this.d && PopupDrawerLayout.this.p && !PopupDrawerLayout.this.q && f < -500.0f) {
                    PopupDrawerLayout.this.a();
                } else {
                    if (PopupDrawerLayout.this.e == PopupPosition.Left) {
                        if (f < -1000.0f) {
                            measuredWidth2 = PopupDrawerLayout.this.d.getMeasuredWidth();
                        } else {
                            if (PopupDrawerLayout.this.d.getLeft() < (-PopupDrawerLayout.this.d.getMeasuredWidth()) / 2) {
                                measuredWidth2 = PopupDrawerLayout.this.d.getMeasuredWidth();
                            } else {
                                measuredWidth = 0;
                            }
                        }
                        measuredWidth = -measuredWidth2;
                    } else if (f > 1000.0f) {
                        measuredWidth = PopupDrawerLayout.this.getMeasuredWidth();
                    } else {
                        measuredWidth = view.getLeft() < PopupDrawerLayout.this.getMeasuredWidth() - (PopupDrawerLayout.this.d.getMeasuredWidth() / 2) ? PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.d.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth();
                    }
                    PopupDrawerLayout.this.b.smoothSlideViewTo(PopupDrawerLayout.this.d, measuredWidth, view.getTop());
                    ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
                }
            }

            public boolean tryCaptureView(View view, int i2) {
                return (PopupDrawerLayout.this.b.continueSettling(true) || PopupDrawerLayout.this.a == LayoutStatus.Close) ? false : true;
            }
        };
        this.r = callback;
        this.s = true;
        this.b = ViewDragHelper.create(this, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        int i2;
        if (this.e == PopupPosition.Left) {
            int i3 = i;
            if (i < (-this.d.getMeasuredWidth())) {
                i3 = -this.d.getMeasuredWidth();
            }
            i2 = i3;
            if (i3 > 0) {
                return 0;
            }
        } else {
            i2 = i;
            if (this.e == PopupPosition.Right) {
                int i4 = i;
                if (i < getMeasuredWidth() - this.d.getMeasuredWidth()) {
                    i4 = getMeasuredWidth() - this.d.getMeasuredWidth();
                }
                i2 = i4;
                if (i4 > getMeasuredWidth()) {
                    i2 = getMeasuredWidth();
                }
            }
        }
        return i2;
    }

    private boolean a(ViewGroup viewGroup, float f, float f2) {
        return a(viewGroup, f, f2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
        if (r0.canScrollHorizontally(1) != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.view.ViewGroup r11, float r12, float r13, int r14) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout.a(android.view.ViewGroup, float, float, int):boolean");
    }

    public void a() {
        if (this.s) {
            post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    PopupDrawerLayout.this.b.abort();
                    PopupDrawerLayout.this.b.smoothSlideViewTo(PopupDrawerLayout.this.d, PopupDrawerLayout.this.e == PopupPosition.Left ? -PopupDrawerLayout.this.d.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth(), 0);
                    ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
                }
            });
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k = getTranslationY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a = null;
        this.l = false;
        this.h = 0.0f;
        setTranslationY(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = getChildAt(0);
        this.d = getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            if (this.b.continueSettling(true) || this.a == LayoutStatus.Close) {
                return true;
            }
            this.p = motionEvent.getX() < this.n;
            this.n = motionEvent.getX();
            this.o = motionEvent.getY();
            this.q = a(this, motionEvent.getX(), motionEvent.getY(), 1);
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.n = 0.0f;
                this.o = 0.0f;
            }
            boolean shouldInterceptTouchEvent = this.b.shouldInterceptTouchEvent(motionEvent);
            this.m = shouldInterceptTouchEvent;
            return (!this.p || this.q) ? !a(this, motionEvent.getX(), motionEvent.getY()) ? this.m : super.onInterceptTouchEvent(motionEvent) : shouldInterceptTouchEvent;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.c.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (this.l) {
            View view = this.d;
            view.layout(view.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getMeasuredHeight());
            return;
        }
        if (this.e == PopupPosition.Left) {
            View view2 = this.d;
            view2.layout(-view2.getMeasuredWidth(), 0, 0, getMeasuredHeight());
        } else {
            this.d.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.d.getMeasuredWidth(), getMeasuredHeight());
        }
        this.l = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            if (this.b.continueSettling(true)) {
                return true;
            }
            this.b.processTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDrawerPosition(PopupPosition popupPosition) {
        this.e = popupPosition;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.t = onCloseListener;
    }
}
