package com.soft.blued.customview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.common.view.RotateLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView.class */
public class PullToRefreshListView extends ListView implements AbsListView.OnScrollListener {
    private int A;
    private Context B;
    private View C;
    private View D;
    private TextView E;
    private View F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private float K;
    private View L;
    private ArrayList<View> M;
    private int N;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private long S;
    private List<View> T;
    private boolean U;
    private View V;
    private FrameLayout W;

    /* renamed from: a  reason: collision with root package name */
    int f14790a;
    private CustomOnScrollListner aa;
    public Map<String, AnimationSet> b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14791c;
    public final String d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private int l;
    private long m;
    private boolean n;
    private int o;
    private Interpolator p;
    private SmoothScrollRunnable q;
    private OnRefreshListener r;
    private OnLoadMoreListener s;
    private RotateLayout t;
    private boolean u;
    private boolean v;
    private IOnTouchChangedListener w;
    private PauseOnScrollListener x;
    private boolean y;
    private int z;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView$CustomOnScrollListner.class */
    public interface CustomOnScrollListner {
        void a(AbsListView absListView, int i);

        void a(AbsListView absListView, int i, int i2, int i3);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView$IOnTouchChangedListener.class */
    public interface IOnTouchChangedListener {
        void a(boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView$OnLoadMoreListener.class */
    public interface OnLoadMoreListener<V extends View> {
        void a(PullToRefreshListView pullToRefreshListView);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView$OnRefreshListener.class */
    public interface OnRefreshListener<V extends View> {
        void a(PullToRefreshListView pullToRefreshListView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView$OnSmoothScrollFinishedListener.class */
    public interface OnSmoothScrollFinishedListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PullToRefreshListView$SmoothScrollRunnable.class */
    public final class SmoothScrollRunnable implements Runnable {
        private final Interpolator b;

        /* renamed from: c  reason: collision with root package name */
        private final int f14797c;
        private final int d;
        private final long e;
        private OnSmoothScrollFinishedListener f;
        private boolean g = true;
        private long h = -1;
        private int i = -1;

        public SmoothScrollRunnable(int i, int i2, long j, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
            this.d = i;
            this.f14797c = i2;
            this.b = PullToRefreshListView.this.p;
            this.e = j;
            this.f = onSmoothScrollFinishedListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h == -1) {
                this.h = System.currentTimeMillis();
            } else {
                int round = this.d - Math.round((this.d - this.f14797c) * this.b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.h) * 1000) / this.e, 1000L), 0L)) / 1000.0f));
                this.i = round;
                PullToRefreshListView.this.a(round);
            }
            if (this.g && this.f14797c != this.i) {
                ViewCompat.postOnAnimation(PullToRefreshListView.this, this);
                return;
            }
            OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = this.f;
            if (onSmoothScrollFinishedListener != null) {
                onSmoothScrollFinishedListener.a();
            }
        }
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = false;
        this.o = 0;
        this.u = false;
        this.v = false;
        this.f14790a = -1;
        this.y = false;
        this.z = 0;
        this.f14791c = "Positive Animation";
        this.d = "Negative Animation";
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.N = 0;
        this.O = true;
        this.P = true;
        this.U = false;
        this.x = new PauseOnScrollListener(false, true);
        a();
    }

    private MotionEvent a(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), SystemClock.uptimeMillis(), 3, motionEvent.getX(), motionEvent.getY(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        int i = (int) f;
        this.V.setPadding(0, i - this.o, 0, 0);
        if (this.W != null) {
            setHeaderBackgoundPulling(i - this.o);
        }
        List<View> list = this.T;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i2 = this.V.getPaddingTop() == 0 ? 0 : 4;
        for (int i3 = 0; i3 < this.T.size(); i3++) {
            if (this.T.get(i3) != null) {
                this.T.get(i3).setVisibility(i2);
            }
        }
    }

    private void a(final View view) {
        if (((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin != 0) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(this.N, 0);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.PullToRefreshListView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, intValue, layoutParams.rightMargin, layoutParams.bottomMargin);
                    view.setLayoutParams(layoutParams);
                }
            });
            ofInt.start();
        }
    }

    private void b(final View view) {
        if (((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin == 0) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(0, this.N);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.PullToRefreshListView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, intValue, layoutParams.rightMargin, layoutParams.bottomMargin);
                    view.setLayoutParams(layoutParams);
                }
            });
            ofInt.start();
        }
    }

    private void c() {
        ArrayList<View> arrayList = this.M;
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.M.size()) {
                    break;
                }
                a(this.M.get(i2));
                i = i2 + 1;
            }
        }
        this.O = true;
    }

    private void d() {
        ArrayList<View> arrayList = this.M;
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.M.size()) {
                    break;
                }
                b(this.M.get(i2));
                i = i2 + 1;
            }
        }
        this.O = false;
    }

    private void e() {
        this.u = true;
        this.t.b();
        int paddingTop = this.V.getPaddingTop();
        int i = this.o;
        SmoothScrollRunnable smoothScrollRunnable = new SmoothScrollRunnable(paddingTop + i, i, 300L, new OnSmoothScrollFinishedListener() { // from class: com.soft.blued.customview.PullToRefreshListView.4
            @Override // com.soft.blued.customview.PullToRefreshListView.OnSmoothScrollFinishedListener
            public void a() {
                if (PullToRefreshListView.this.r != null) {
                    PullToRefreshListView.this.r.a(PullToRefreshListView.this);
                }
            }
        });
        this.q = smoothScrollRunnable;
        postDelayed(smoothScrollRunnable, 20L);
    }

    private boolean f() {
        View childAt;
        return getFirstVisiblePosition() <= 1 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getTop();
    }

    private void setHeaderBackgoundPulling(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.z + i, this.A + i);
        layoutParams.setMargins((-i) / 2, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        FrameLayout frameLayout = this.W;
        if (frameLayout != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    private void setHeaderBgMarginTop(int i) {
        FrameLayout frameLayout = this.W;
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.W.setLayoutParams(layoutParams);
        }
    }

    void a() {
        getInstance().setOnScrollListener(this);
    }

    public boolean a(AbsListView absListView, int i, int i2) {
        int i3 = this.H;
        boolean z = true;
        if (i == i3) {
            boolean z2 = this.I <= i2;
            this.I = i2;
            return z2;
        }
        if (i <= i3) {
            z = false;
        }
        this.H = i;
        this.I = i2;
        return z;
    }

    public void b() {
        if (this.u) {
            this.u = false;
        }
        this.t.e();
        if (this.v) {
            this.v = false;
        }
        SmoothScrollRunnable smoothScrollRunnable = new SmoothScrollRunnable(this.V.getPaddingTop() + this.o, 0, 300L, new OnSmoothScrollFinishedListener() { // from class: com.soft.blued.customview.PullToRefreshListView.3
            @Override // com.soft.blued.customview.PullToRefreshListView.OnSmoothScrollFinishedListener
            public void a() {
            }
        });
        this.q = smoothScrollRunnable;
        if (this.y) {
            postDelayed(smoothScrollRunnable, 20L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public PullToRefreshListView getInstance() {
        return this;
    }

    public View getPullHeaderView() {
        return this.V;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.U) {
            return false;
        }
        try {
            if (motionEvent.getAction() == 0) {
                float y = motionEvent.getY();
                this.h = y;
                this.f = y;
                float x = motionEvent.getX();
                this.g = x;
                this.e = x;
            }
        } catch (Exception e) {
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ListAdapter listAdapter;
        View view;
        this.x.onScroll(absListView, i, i2, i3);
        if (i + i2 == i3 && i3 > 0) {
            boolean z = this.u;
        }
        if (absListView.getChildAt(0) != null) {
            int top = absListView.getChildAt(0).getTop();
            long currentTimeMillis = System.currentTimeMillis() - this.m;
            if (i != 0 || top != 0) {
                int i4 = this.l;
                if (i4 < i) {
                    if (this.O) {
                        d();
                    }
                } else if (i4 == i) {
                    float f = top;
                    int abs = (int) Math.abs(this.k - f);
                    if (this.k >= f || currentTimeMillis == 0 || (abs * 1000) / currentTimeMillis <= 2000) {
                        if (this.k > f && abs > 10 && this.O) {
                            d();
                        }
                    } else if (!this.O) {
                        c();
                    }
                }
            } else if (!this.O) {
                c();
            }
            float abs2 = Math.abs(top);
            this.J = a(absListView, i, (int) abs2);
            if (i == 0) {
                if (this.W != null) {
                    setHeaderBgMarginTop(top);
                }
                if (this.C != null) {
                    float a2 = DensityUtils.a(this.B, 100.0f);
                    float f2 = a2;
                    if (abs2 >= a2) {
                        f2 = abs2;
                    }
                    setOverHeaderAlpha(abs2 / f2);
                }
            } else if (this.W != null) {
                setHeaderBgMarginTop(-this.A);
            }
            if (this.b != null && (view = this.F) != null) {
                if (this.G == 0 && abs2 >= this.K && this.J) {
                    this.G = 1;
                    view.setVisibility(0);
                    this.F.clearAnimation();
                    this.F.startAnimation(this.b.get("Positive Animation"));
                }
                if (this.G == 1 && abs2 <= this.K && !this.J && i == 0) {
                    this.G = 0;
                    this.F.clearAnimation();
                    this.F.startAnimation(this.b.get("Negative Animation"));
                }
            }
            this.l = i;
            this.k = top;
            this.m = System.currentTimeMillis();
        }
        if (this.P && !this.u && !this.v && this.s != null && (listAdapter = (ListAdapter) absListView.getAdapter()) != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            long j = this.S;
            if (j == 0) {
                this.S = currentTimeMillis2;
            } else if (i > this.Q) {
                double d = currentTimeMillis2 - j;
                int lastVisiblePosition = absListView.getLastVisiblePosition();
                this.R = lastVisiblePosition;
                this.Q = i;
                this.S = currentTimeMillis2;
                if (d <= 30.0d) {
                    int count = listAdapter.getCount();
                    int count2 = listAdapter.getCount();
                    if (lastVisiblePosition >= (count < 15 ? (count2 - i) / 2 : count2 - 14)) {
                        this.v = true;
                        this.s.a(getInstance());
                    }
                } else if (d <= 220.0d) {
                    int count3 = listAdapter.getCount();
                    int count4 = listAdapter.getCount();
                    if (lastVisiblePosition >= (count3 < 15 ? (count4 - i) / 2 : count4 - 12)) {
                        this.v = true;
                        this.s.a(getInstance());
                    }
                } else {
                    int count5 = listAdapter.getCount();
                    int count6 = listAdapter.getCount();
                    if (lastVisiblePosition >= (count5 < 15 ? ((count6 - i) * 2) / 3 : count6 - 10)) {
                        this.v = true;
                        this.s.a(getInstance());
                    }
                }
            }
        }
        CustomOnScrollListner customOnScrollListner = this.aa;
        if (customOnScrollListner != null) {
            customOnScrollListner.a(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        OnLoadMoreListener onLoadMoreListener;
        this.x.onScrollStateChanged(absListView, i);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.u && !this.v && (onLoadMoreListener = this.s) != null) {
            this.v = true;
            onLoadMoreListener.a(getInstance());
        }
        CustomOnScrollListner customOnScrollListner = this.aa;
        if (customOnScrollListner != null) {
            customOnScrollListner.a(absListView, i);
        }
        if (i == 1) {
            this.S = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != 3) goto L10;
     */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.PullToRefreshListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCoverTransparent(View view) {
        this.L = view;
    }

    public void setCustomerOnScrollListner(CustomOnScrollListner customOnScrollListner) {
        this.aa = customOnScrollListner;
    }

    public void setIfDisallowIntercept(Boolean bool) {
        this.U = bool.booleanValue();
    }

    public final void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.s = onLoadMoreListener;
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.r = onRefreshListener;
    }

    public void setOnTouchChangedListener(IOnTouchChangedListener iOnTouchChangedListener) {
        this.w = iOnTouchChangedListener;
    }

    public void setOverHeaderAlpha(float f) {
        if (this.C != null) {
            if (Build.VERSION.SDK_INT < 11) {
                this.C.getBackground().setAlpha((int) (f * 255.0f));
            } else {
                this.C.setAlpha(f);
            }
            if (f <= 0.1d) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
        }
        String hexString = Integer.toHexString((int) (f * 255.0f));
        String str = hexString;
        if (hexString.length() == 1) {
            str = "0" + hexString;
        }
        String str2 = "#" + str + "000000";
        String str3 = "#" + str + "e1e1e1";
        TextView textView = this.E;
        if (textView != null) {
            textView.setTextColor(Color.parseColor(str2));
        }
        View view = this.D;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor(str3));
        }
    }

    public void setPullHeaderView(View view) {
        this.V = view;
        addHeaderView(view);
        if (this.o == 0) {
            this.o = view.getHeight();
        }
        a(0.0f);
        if (this.p == null) {
            this.p = new DecelerateInterpolator();
        }
    }

    public void setPullHeaderViewHeight(int i) {
        this.o = i;
        if (this.V != null) {
            a(0.0f);
        }
    }

    public void setRotateLayout(RotateLayout rotateLayout) {
        this.t = rotateLayout;
    }

    public void setViewNeedToHideWhilePull(List<View> list) {
        ArrayList arrayList = new ArrayList();
        this.T = arrayList;
        arrayList.addAll(list);
    }
}
