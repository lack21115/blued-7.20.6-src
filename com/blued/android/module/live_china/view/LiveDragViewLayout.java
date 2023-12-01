package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.Logger;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveDragViewLayout.class */
public class LiveDragViewLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewDragHelper f14459a;
    private Point b;

    /* renamed from: c  reason: collision with root package name */
    private View f14460c;
    private int d;
    private OnLayoutStateListener e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private RecyclerView k;
    private View l;
    private View m;
    private ViewDragHelperLayout n;
    private View o;
    private boolean p;
    private boolean q;
    private boolean r;
    private ViewDragHelper.Callback s;
    private int t;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveDragViewLayout$OnLayoutStateListener.class */
    public interface OnLayoutStateListener {
        void a();

        void a(int i);

        void b();

        void c();
    }

    public LiveDragViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = true;
        this.r = false;
        this.s = new ViewDragHelper.Callback() { // from class: com.blued.android.module.live_china.view.LiveDragViewLayout.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                if (LiveDragViewLayout.this.q) {
                    if (LiveDragViewLayout.this.p) {
                        if (LiveDragViewLayout.this.j + i2 > LiveDragViewLayout.this.t) {
                            return LiveDragViewLayout.this.t;
                        }
                        if ((-LiveDragViewLayout.this.j) + (-i2) > LiveDragViewLayout.this.t) {
                            return -LiveDragViewLayout.this.t;
                        }
                    }
                    return i;
                }
                return 0;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                LiveDragViewLayout.this.a(view);
                return LiveDragViewLayout.this.getMeasuredHeight();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                super.onViewDragStateChanged(i);
                Logger.a("drb", "onViewDragStateChanged = ", Integer.valueOf(i));
                if (i == 0 && LiveDragViewLayout.this.e != null) {
                    if (!LiveDragViewLayout.this.f) {
                        LiveDragViewLayout.this.e.a();
                        return;
                    }
                    Logger.a("drb", "whereFromOut = ", Integer.valueOf(LiveDragViewLayout.this.g));
                    int i2 = LiveDragViewLayout.this.g;
                    if (i2 == 1) {
                        LiveDragViewLayout.this.e.b();
                    } else if (i2 != 2) {
                    } else {
                        LiveDragViewLayout.this.e.c();
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                LiveDragViewLayout.this.j = i2;
                if (LiveDragViewLayout.this.p) {
                    if (LiveDragViewLayout.this.j > LiveDragViewLayout.this.t) {
                        LiveDragViewLayout liveDragViewLayout = LiveDragViewLayout.this;
                        liveDragViewLayout.j = liveDragViewLayout.t;
                    } else if ((-LiveDragViewLayout.this.j) > LiveDragViewLayout.this.t) {
                        LiveDragViewLayout liveDragViewLayout2 = LiveDragViewLayout.this;
                        liveDragViewLayout2.j = -liveDragViewLayout2.t;
                    }
                }
                int abs = (int) (((Math.abs(i2) * 1.0f) / LiveDragViewLayout.this.d) * 1.0f * 255.0f);
                if (LiveDragViewLayout.this.e != null) {
                    LiveDragViewLayout.this.e.a(-(abs - 255));
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                boolean z = true;
                if (view.getTop() <= 0) {
                    int i = (-view.getTop()) > ((LiveDragViewLayout.this.p || ((-f2) > 5000.0f ? 1 : ((-f2) == 5000.0f ? 0 : -1)) <= 0) ? (int) (((double) LiveDragViewLayout.this.d) * 0.5d) : 0) ? -LiveDragViewLayout.this.d : LiveDragViewLayout.this.b.y != 0 ? LiveDragViewLayout.this.b.y : LiveDragViewLayout.this.b.y;
                    LiveDragViewLayout.this.f14459a.settleCapturedViewAt(view.getLeft(), i);
                    LiveDragViewLayout.this.invalidate();
                    if (LiveDragViewLayout.this.b.y != 0) {
                        LiveDragViewLayout liveDragViewLayout = LiveDragViewLayout.this;
                        if (i == liveDragViewLayout.b.y) {
                            z = false;
                        }
                        liveDragViewLayout.f = z;
                    } else {
                        LiveDragViewLayout liveDragViewLayout2 = LiveDragViewLayout.this;
                        liveDragViewLayout2.f = i != liveDragViewLayout2.b.y;
                    }
                    LiveDragViewLayout.this.g = 2;
                    return;
                }
                int i2 = view.getTop() > ((LiveDragViewLayout.this.p || (f2 > 5000.0f ? 1 : (f2 == 5000.0f ? 0 : -1)) <= 0) ? (int) (((double) LiveDragViewLayout.this.d) * 0.5d) : 0) ? LiveDragViewLayout.this.d : LiveDragViewLayout.this.b.y != 0 ? LiveDragViewLayout.this.b.y : LiveDragViewLayout.this.b.y;
                Logger.a("pk", "settleTop = " + i2);
                LiveDragViewLayout.this.f14459a.settleCapturedViewAt(view.getLeft(), i2);
                LiveDragViewLayout.this.invalidate();
                if (LiveDragViewLayout.this.b.y != 0) {
                    LiveDragViewLayout liveDragViewLayout3 = LiveDragViewLayout.this;
                    boolean z2 = false;
                    if (i2 != liveDragViewLayout3.b.y) {
                        z2 = true;
                    }
                    liveDragViewLayout3.f = z2;
                } else {
                    LiveDragViewLayout liveDragViewLayout4 = LiveDragViewLayout.this;
                    boolean z3 = false;
                    if (i2 != liveDragViewLayout4.b.y) {
                        z3 = true;
                    }
                    liveDragViewLayout4.f = z3;
                }
                LiveDragViewLayout.this.g = 1;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                LiveDragViewLayout.this.a(view);
                return LiveDragViewLayout.this.r;
            }
        };
        a();
    }

    private void a() {
        this.f14459a = ViewDragHelper.create(this, 1.0f, this.s);
        this.d = getResources().getDisplayMetrics().heightPixels;
        this.b = new Point();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.k != null || view == null) {
            return;
        }
        this.k = (RecyclerView) view.findViewById(R.id.live_msg_content_pullrefresh);
        this.l = view.findViewById(R.id.live_make_friend_list_view);
        this.m = view.findViewById(R.id.live_activity_web_view);
        this.o = view.findViewById(R.id.live_defined_rank_layout_id);
    }

    private boolean a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    public void a(boolean z) {
        this.r = z;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f14459a.continueSettling(true)) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f14460c = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int rawX;
        int rawY;
        try {
            rawX = (int) motionEvent.getRawX();
            rawY = (int) motionEvent.getRawY();
        } catch (Exception e) {
        }
        if (this.k == null || !a(this.k, rawX, rawY)) {
            if (this.o == null || !a(this.o, rawX, rawY)) {
                if (this.n == null || this.n.getVisibility() != 0) {
                    if (this.l == null || this.l.getVisibility() != 0) {
                        if (this.m != null) {
                            if (this.m.getVisibility() == 0) {
                                return false;
                            }
                        }
                        return this.f14459a.shouldInterceptTouchEvent(motionEvent);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.x = this.f14460c.getLeft();
        this.b.y = this.f14460c.getTop();
        int i5 = this.j;
        if (i5 >= 0) {
            this.f14460c.layout(0, i5, this.h, this.i + i5);
        } else {
            this.f14460c.layout(0, i5, this.h, this.i - (-i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.i = measuredHeight;
        this.t = (int) (measuredHeight * 0.1f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f14459a.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragEnable(boolean z) {
        this.q = z;
    }

    public void setGestureLayout(ViewDragHelperLayout viewDragHelperLayout) {
        this.n = viewDragHelperLayout;
    }

    public void setOnLayoutStateListener(OnLayoutStateListener onLayoutStateListener) {
        this.e = onLayoutStateListener;
    }

    public void setRTCModel(boolean z) {
        this.p = z;
    }
}
