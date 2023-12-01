package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.player.media.observer.ScaleChangeObserver;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ViewDragHelperLayout.class */
public class ViewDragHelperLayout extends LinearLayout implements ScaleChangeObserver.IScaleChangeObserver {
    private ViewDragHelper a;
    private View b;
    private View c;
    private int d;
    private Point e;
    private Point f;
    private OnLayoutStateListener g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ViewDragHelperLayout$OnLayoutStateListener.class */
    public interface OnLayoutStateListener {
        void a();

        void a(int i);

        void b();

        void c();

        void d();
    }

    public ViewDragHelperLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Point();
        this.f = new Point();
        this.m = true;
        this.d = getResources().getDisplayMetrics().heightPixels;
        this.a = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.blued.android.module.live_china.view.ViewDragHelperLayout.1
            public int clampViewPositionVertical(View view, int i, int i2) {
                return i;
            }

            public int getViewVerticalDragRange(View view) {
                return ViewDragHelperLayout.this.getMeasuredHeight() - view.getMeasuredWidth();
            }

            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                Logger.a("drb", "onViewDragStateChanged = ", Integer.valueOf(i));
                if (i == 0 && ViewDragHelperLayout.this.g != null) {
                    if (!ViewDragHelperLayout.this.h) {
                        ViewDragHelperLayout.this.g.b();
                        return;
                    }
                    Logger.a("drb", "whereFromOut = ", Integer.valueOf(ViewDragHelperLayout.this.i));
                    int i2 = ViewDragHelperLayout.this.i;
                    if (i2 == 1) {
                        ViewDragHelperLayout.this.g.c();
                        ViewDragHelperLayout.this.g.a();
                    } else if (i2 != 2) {
                        ViewDragHelperLayout.this.g.a();
                    } else {
                        ViewDragHelperLayout.this.g.d();
                        ViewDragHelperLayout.this.g.a();
                    }
                }
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                ViewDragHelperLayout.this.l = i2;
                Logger.a("drb", "mMainLeft = ", Integer.valueOf(ViewDragHelperLayout.this.l));
                int abs = (int) (((Math.abs(i2) * 1.0f) / ViewDragHelperLayout.this.d) * 1.0f * 255.0f);
                if (ViewDragHelperLayout.this.g != null) {
                    ViewDragHelperLayout.this.g.a(-(abs - 255));
                }
            }

            public void onViewReleased(View view, float f, float f2) {
                boolean z = true;
                if (view.getTop() <= 0) {
                    int i = (-view.getTop()) > (((-f2) > 2000.0f ? 1 : ((-f2) == 2000.0f ? 0 : -1)) > 0 ? 0 : (int) (((double) ViewDragHelperLayout.this.d) * 0.4d)) ? -ViewDragHelperLayout.this.d : ViewDragHelperLayout.this.e.y != 0 ? ViewDragHelperLayout.this.e.y : ViewDragHelperLayout.this.f.y != 0 ? ViewDragHelperLayout.this.f.y : ViewDragHelperLayout.this.e.y;
                    ViewDragHelperLayout.this.a.settleCapturedViewAt(view.getLeft(), i);
                    ViewDragHelperLayout.this.invalidate();
                    if (ViewDragHelperLayout.this.e.y != 0) {
                        ViewDragHelperLayout viewDragHelperLayout = ViewDragHelperLayout.this;
                        if (i == viewDragHelperLayout.e.y) {
                            z = false;
                        }
                        viewDragHelperLayout.h = z;
                    } else if (ViewDragHelperLayout.this.f.y != 0) {
                        ViewDragHelperLayout viewDragHelperLayout2 = ViewDragHelperLayout.this;
                        viewDragHelperLayout2.h = i != viewDragHelperLayout2.f.y;
                    } else {
                        ViewDragHelperLayout viewDragHelperLayout3 = ViewDragHelperLayout.this;
                        viewDragHelperLayout3.h = i != viewDragHelperLayout3.e.y;
                    }
                    ViewDragHelperLayout.this.i = 2;
                    return;
                }
                int i2 = view.getTop() > ((f2 > 2000.0f ? 1 : (f2 == 2000.0f ? 0 : -1)) > 0 ? 0 : (int) (((double) ViewDragHelperLayout.this.d) * 0.6d)) ? ViewDragHelperLayout.this.d : ViewDragHelperLayout.this.e.y != 0 ? ViewDragHelperLayout.this.e.y : ViewDragHelperLayout.this.f.y != 0 ? ViewDragHelperLayout.this.f.y : ViewDragHelperLayout.this.e.y;
                ViewDragHelperLayout.this.a.settleCapturedViewAt(view.getLeft(), i2);
                ViewDragHelperLayout.this.invalidate();
                if (ViewDragHelperLayout.this.e.y != 0) {
                    ViewDragHelperLayout viewDragHelperLayout4 = ViewDragHelperLayout.this;
                    boolean z2 = false;
                    if (i2 != viewDragHelperLayout4.e.y) {
                        z2 = true;
                    }
                    viewDragHelperLayout4.h = z2;
                } else if (ViewDragHelperLayout.this.f.y != 0) {
                    ViewDragHelperLayout viewDragHelperLayout5 = ViewDragHelperLayout.this;
                    boolean z3 = false;
                    if (i2 != viewDragHelperLayout5.f.y) {
                        z3 = true;
                    }
                    viewDragHelperLayout5.h = z3;
                } else {
                    ViewDragHelperLayout viewDragHelperLayout6 = ViewDragHelperLayout.this;
                    boolean z4 = false;
                    if (i2 != viewDragHelperLayout6.e.y) {
                        z4 = true;
                    }
                    viewDragHelperLayout6.h = z4;
                }
                ViewDragHelperLayout.this.i = 1;
            }

            public boolean tryCaptureView(View view, int i) {
                return ViewDragHelperLayout.this.m;
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.a.continueSettling(true)) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScaleChangeObserver.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ScaleChangeObserver.a().b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = getChildAt(0);
        this.c = getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean shouldInterceptTouchEvent = this.a.shouldInterceptTouchEvent(motionEvent);
        Logger.a("drb", "onInterceptTouchEvent = ", Integer.valueOf(motionEvent.getAction()), "-- isIntercept = ", Boolean.valueOf(shouldInterceptTouchEvent));
        return shouldInterceptTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e.x = this.b.getLeft();
        this.e.y = this.b.getTop();
        View view = this.c;
        if (view != null) {
            this.f.x = view.getLeft();
            this.f.y = this.c.getTop();
        }
        int i5 = this.l;
        if (i5 >= 0) {
            this.b.layout(0, i5, this.j, this.k + i5);
        } else {
            this.b.layout(0, i5, this.j, this.k - (-i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Logger.a("drb", "onTouchEvent = ", Integer.valueOf(motionEvent.getAction()));
        this.a.processTouchEvent(motionEvent);
        return true;
    }

    public void setOnLayoutStateListener(OnLayoutStateListener onLayoutStateListener) {
        this.g = onLayoutStateListener;
    }

    public void setScrollDisable(boolean z) {
        this.m = z;
    }
}
