package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioSystem;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshContentWrapper;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.scwang.smartrefresh.layout.util.DelayedRunnable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.SmartUtil;
import com.scwang.smartrefresh.layout.util.ViscousFluidInterpolator;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout.class */
public class SmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
    protected static DefaultRefreshFooterCreator aG;
    protected static DefaultRefreshHeaderCreator aH;
    protected static DefaultRefreshInitializer aI;
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected boolean O;
    protected boolean P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    protected boolean T;
    protected boolean U;
    protected OnRefreshListener V;
    protected OnLoadMoreListener W;

    /* renamed from: a  reason: collision with root package name */
    protected int f27937a;
    protected long aA;
    protected int aB;
    protected int aC;
    protected boolean aD;
    protected boolean aE;
    protected boolean aF;
    protected boolean aJ;
    protected MotionEvent aK;
    protected Runnable aL;
    protected ValueAnimator aM;
    protected OnMultiPurposeListener aa;
    protected ScrollBoundaryDecider ab;
    protected int ac;
    protected boolean ad;
    protected int[] ae;
    protected NestedScrollingChildHelper af;
    protected NestedScrollingParentHelper ag;
    protected int ah;
    protected DimensionStatus ai;
    protected int aj;
    protected DimensionStatus ak;
    protected int al;
    protected int am;
    protected float an;
    protected float ao;
    protected float ap;
    protected float aq;

    /* renamed from: ar  reason: collision with root package name */
    protected RefreshInternal f27938ar;
    protected RefreshInternal as;
    protected RefreshContent at;
    protected Paint au;
    protected Handler av;
    protected RefreshKernel aw;
    protected List<DelayedRunnable> ax;
    protected RefreshState ay;
    protected RefreshState az;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected int f27939c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected float h;
    protected float i;
    protected float j;
    protected float k;
    protected float l;
    protected char m;
    protected boolean n;
    protected boolean o;
    protected int p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected Scroller w;
    protected VelocityTracker x;
    protected Interpolator y;
    protected int[] z;

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$10  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$10.class */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27941a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d1 -> B:81:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d5 -> B:95:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d9 -> B:91:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00dd -> B:103:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e1 -> B:99:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e5 -> B:77:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e9 -> B:73:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ed -> B:85:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f1 -> B:79:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00f5 -> B:93:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f9 -> B:89:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00fd -> B:101:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0101 -> B:97:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0105 -> B:75:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0109 -> B:71:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x010d -> B:83:0x00c4). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f27941a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f27941a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f27941a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f27941a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f27941a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f27941a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f27941a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f27941a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f27941a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f27941a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f27941a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f27941a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f27941a[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f27941a[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f27941a[RefreshState.TwoLevelReleased.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f27941a[RefreshState.TwoLevelFinish.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f27941a[RefreshState.TwoLevel.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$7  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$7.class */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f27947a;
        final /* synthetic */ boolean b;

        AnonymousClass7(boolean z, boolean z2) {
            this.f27947a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (SmartRefreshLayout.this.ay != RefreshState.Loading || SmartRefreshLayout.this.as == null || SmartRefreshLayout.this.at == null) {
                if (this.b) {
                    SmartRefreshLayout.this.i(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout.this.a(RefreshState.LoadFinish);
            int a2 = SmartRefreshLayout.this.as.a(SmartRefreshLayout.this, this.f27947a);
            if (SmartRefreshLayout.this.aa != null && (SmartRefreshLayout.this.as instanceof RefreshFooter)) {
                SmartRefreshLayout.this.aa.a((RefreshFooter) SmartRefreshLayout.this.as, this.f27947a);
            }
            if (a2 < Integer.MAX_VALUE) {
                if (!this.b || !SmartRefreshLayout.this.G || SmartRefreshLayout.this.b >= 0 || !SmartRefreshLayout.this.at.d()) {
                    z = false;
                }
                final int max = SmartRefreshLayout.this.b - (z ? Math.max(SmartRefreshLayout.this.b, -SmartRefreshLayout.this.aj) : 0);
                if (SmartRefreshLayout.this.n || SmartRefreshLayout.this.ad) {
                    if (SmartRefreshLayout.this.n) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.i = smartRefreshLayout.k;
                        SmartRefreshLayout.this.n = false;
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.d = smartRefreshLayout2.b - max;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    float f = max;
                    SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout3.j, SmartRefreshLayout.this.k + f + (SmartRefreshLayout.this.f27937a * 2), 0));
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout4.j, SmartRefreshLayout.this.k + f, 0));
                    if (SmartRefreshLayout.this.ad) {
                        SmartRefreshLayout.this.ac = 0;
                    }
                }
                SmartRefreshLayout.this.postDelayed(new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ValueAnimator valueAnimator;
                        ValueAnimator.AnimatorUpdateListener a3 = (!SmartRefreshLayout.this.M || max >= 0) ? null : SmartRefreshLayout.this.at.a(SmartRefreshLayout.this.b);
                        if (a3 != null) {
                            a3.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                        }
                        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.7.1.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                SmartRefreshLayout.this.aF = false;
                                if (AnonymousClass7.this.b) {
                                    SmartRefreshLayout.this.i(true);
                                }
                                if (SmartRefreshLayout.this.ay == RefreshState.LoadFinish) {
                                    SmartRefreshLayout.this.a(RefreshState.None);
                                }
                            }
                        };
                        if (SmartRefreshLayout.this.b > 0) {
                            valueAnimator = SmartRefreshLayout.this.aw.a(0);
                        } else {
                            if (a3 != null || SmartRefreshLayout.this.b == 0) {
                                if (SmartRefreshLayout.this.aM != null) {
                                    SmartRefreshLayout.this.aM.cancel();
                                    SmartRefreshLayout.this.aM = null;
                                }
                                SmartRefreshLayout.this.aw.a(0, false);
                                SmartRefreshLayout.this.c();
                            } else if (!AnonymousClass7.this.b || !SmartRefreshLayout.this.G) {
                                valueAnimator = SmartRefreshLayout.this.aw.a(0);
                            } else if (SmartRefreshLayout.this.b >= (-SmartRefreshLayout.this.aj)) {
                                SmartRefreshLayout.this.a(RefreshState.None);
                            } else {
                                valueAnimator = SmartRefreshLayout.this.aw.a(-SmartRefreshLayout.this.aj);
                            }
                            valueAnimator = null;
                        }
                        if (valueAnimator != null) {
                            valueAnimator.addListener(animatorListenerAdapter);
                        } else {
                            animatorListenerAdapter.onAnimationEnd(null);
                        }
                    }
                }, SmartRefreshLayout.this.b < 0 ? a2 : 0L);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$9  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$9.class */
    class AnonymousClass9 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f27955a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f27956c;
        final /* synthetic */ SmartRefreshLayout d;

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.aM != null) {
                this.d.aM.cancel();
            }
            SmartRefreshLayout smartRefreshLayout = this.d;
            smartRefreshLayout.aM = ValueAnimator.ofInt(smartRefreshLayout.b, -((int) (this.d.aj * this.f27955a)));
            this.d.aM.setDuration(this.b);
            this.d.aM.setInterpolator(new DecelerateInterpolator());
            this.d.aM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.9.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AnonymousClass9.this.d.aw.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                }
            });
            this.d.aM.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.9.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnonymousClass9.this.d.aM = null;
                    if (AnonymousClass9.this.f27956c) {
                        if (AnonymousClass9.this.d.ay == RefreshState.ReleaseToLoad) {
                            AnonymousClass9.this.d.aw.a(RefreshState.PullUpToLoad);
                        }
                    } else if (AnonymousClass9.this.d.ay != RefreshState.ReleaseToLoad) {
                        AnonymousClass9.this.d.aw.a(RefreshState.ReleaseToLoad);
                    }
                    if (!AnonymousClass9.this.d.K) {
                        AnonymousClass9.this.d.d();
                        return;
                    }
                    AnonymousClass9.this.d.K = false;
                    AnonymousClass9.this.d.d();
                    AnonymousClass9.this.d.K = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    SmartRefreshLayout smartRefreshLayout2 = AnonymousClass9.this.d;
                    AnonymousClass9.this.d.j = smartRefreshLayout2.getMeasuredWidth() / 2;
                    AnonymousClass9.this.d.aw.a(RefreshState.PullUpToLoad);
                }
            });
            this.d.aM.start();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$BounceRunnable.class */
    public class BounceRunnable implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        int f27960c;
        float f;

        /* renamed from: a  reason: collision with root package name */
        int f27959a = 0;
        int b = 10;
        float e = 0.0f;
        long d = AnimationUtils.currentAnimationTimeMillis();

        BounceRunnable(float f, int i) {
            this.f = f;
            this.f27960c = i;
            SmartRefreshLayout.this.postDelayed(this, this.b);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            if (SmartRefreshLayout.this.aL != this || SmartRefreshLayout.this.ay.w) {
                return;
            }
            if (Math.abs(SmartRefreshLayout.this.b) < Math.abs(this.f27960c)) {
                double d = this.f;
                this.f27959a = this.f27959a + 1;
                this.f = (float) (d * Math.pow(0.949999988079071d, i * 2));
            } else if (this.f27960c != 0) {
                double d2 = this.f;
                this.f27959a = this.f27959a + 1;
                this.f = (float) (d2 * Math.pow(0.44999998807907104d, i3 * 2));
            } else {
                double d3 = this.f;
                this.f27959a = this.f27959a + 1;
                this.f = (float) (d3 * Math.pow(0.8500000238418579d, i2 * 2));
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.f * ((((float) (currentAnimationTimeMillis - this.d)) * 1.0f) / 1000.0f);
            if (Math.abs(f) >= 1.0f) {
                this.d = currentAnimationTimeMillis;
                float f2 = this.e + f;
                this.e = f2;
                SmartRefreshLayout.this.b(f2);
                SmartRefreshLayout.this.postDelayed(this, this.b);
                return;
            }
            SmartRefreshLayout.this.aL = null;
            if (Math.abs(SmartRefreshLayout.this.b) >= Math.abs(this.f27960c)) {
                int min = Math.min(Math.max((int) DensityUtil.a(Math.abs(SmartRefreshLayout.this.b - this.f27960c)), 30), 100);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.a(this.f27960c, 0, smartRefreshLayout.y, min * 10);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$FlingRunnable.class */
    public class FlingRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f27961a;
        float d;
        int b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f27962c = 10;
        float e = 0.98f;
        long f = 0;
        long g = AnimationUtils.currentAnimationTimeMillis();

        FlingRunnable(float f) {
            this.d = f;
            this.f27961a = SmartRefreshLayout.this.b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
            if (r0.a(r0.B) != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
            if (r0.a(r0.B) != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
            if (r7.h.b >= (-r7.h.aj)) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00ae, code lost:
            if (r7.h.b > r7.h.ah) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable a() {
            /*
                Method dump skipped, instructions count: 374
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.FlingRunnable.a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SmartRefreshLayout.this.aL != this || SmartRefreshLayout.this.ay.w) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = this.g;
            float pow = (float) (this.d * Math.pow(this.e, (currentAnimationTimeMillis - this.f) / (1000 / this.f27962c)));
            this.d = pow;
            float f = pow * ((((float) (currentAnimationTimeMillis - j)) * 1.0f) / 1000.0f);
            if (Math.abs(f) <= 1.0f) {
                SmartRefreshLayout.this.aL = null;
                return;
            }
            this.g = currentAnimationTimeMillis;
            this.f27961a = (int) (this.f27961a + f);
            if (SmartRefreshLayout.this.b * this.f27961a > 0) {
                SmartRefreshLayout.this.aw.a(this.f27961a, true);
                SmartRefreshLayout.this.postDelayed(this, this.f27962c);
                return;
            }
            SmartRefreshLayout.this.aL = null;
            SmartRefreshLayout.this.aw.a(0, true);
            SmartUtil.a(SmartRefreshLayout.this.at.b(), (int) (-this.d));
            if (!SmartRefreshLayout.this.aF || f <= 0.0f) {
                return;
            }
            SmartRefreshLayout.this.aF = false;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f27963a;
        public SpinnerStyle b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f27963a = 0;
            this.b = null;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f27963a = 0;
            this.b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f27963a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f27963a);
            if (obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.b = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f27963a = 0;
            this.b = null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/SmartRefreshLayout$RefreshKernelImpl.class */
    public class RefreshKernelImpl implements RefreshKernel {
        public RefreshKernelImpl() {
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public ValueAnimator a(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.a(i, 0, smartRefreshLayout.y, SmartRefreshLayout.this.f);
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel a(int i, boolean z) {
            if (SmartRefreshLayout.this.b != i || ((SmartRefreshLayout.this.f27938ar != null && SmartRefreshLayout.this.f27938ar.b()) || (SmartRefreshLayout.this.as != null && SmartRefreshLayout.this.as.b()))) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout.b;
                SmartRefreshLayout.this.b = i;
                if (z && (SmartRefreshLayout.this.az.u || SmartRefreshLayout.this.az.v)) {
                    if (SmartRefreshLayout.this.b > SmartRefreshLayout.this.ah * SmartRefreshLayout.this.ap) {
                        if (SmartRefreshLayout.this.ay != RefreshState.ReleaseToTwoLevel) {
                            SmartRefreshLayout.this.aw.a(RefreshState.ReleaseToRefresh);
                        }
                    } else if ((-SmartRefreshLayout.this.b) > SmartRefreshLayout.this.aj * SmartRefreshLayout.this.aq && !SmartRefreshLayout.this.R) {
                        SmartRefreshLayout.this.aw.a(RefreshState.ReleaseToLoad);
                    } else if (SmartRefreshLayout.this.b < 0 && !SmartRefreshLayout.this.R) {
                        SmartRefreshLayout.this.aw.a(RefreshState.PullUpToLoad);
                    } else if (SmartRefreshLayout.this.b > 0) {
                        SmartRefreshLayout.this.aw.a(RefreshState.PullDownToRefresh);
                    }
                }
                if (SmartRefreshLayout.this.at != null) {
                    Integer num = null;
                    if (i >= 0) {
                        num = null;
                        if (SmartRefreshLayout.this.f27938ar != null) {
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            if (smartRefreshLayout2.a(smartRefreshLayout2.E, SmartRefreshLayout.this.f27938ar)) {
                                num = Integer.valueOf(i);
                            } else {
                                num = null;
                                if (i2 < 0) {
                                    num = 0;
                                }
                            }
                        }
                    }
                    Integer num2 = num;
                    if (i <= 0) {
                        num2 = num;
                        if (SmartRefreshLayout.this.as != null) {
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            if (smartRefreshLayout3.a(smartRefreshLayout3.F, SmartRefreshLayout.this.as)) {
                                num2 = Integer.valueOf(i);
                            } else {
                                num2 = num;
                                if (i2 > 0) {
                                    num2 = 0;
                                }
                            }
                        }
                    }
                    if (num2 != null) {
                        SmartRefreshLayout.this.at.a(num2.intValue(), SmartRefreshLayout.this.r, SmartRefreshLayout.this.s);
                        boolean z2 = (SmartRefreshLayout.this.C && SmartRefreshLayout.this.f27938ar != null && SmartRefreshLayout.this.f27938ar.getSpinnerStyle() == SpinnerStyle.FixedBehind) || SmartRefreshLayout.this.aB != 0;
                        boolean z3 = (SmartRefreshLayout.this.D && SmartRefreshLayout.this.as != null && SmartRefreshLayout.this.as.getSpinnerStyle() == SpinnerStyle.FixedBehind) || SmartRefreshLayout.this.aC != 0;
                        if ((z2 && (num2.intValue() >= 0 || i2 > 0)) || (z3 && (num2.intValue() <= 0 || i2 < 0))) {
                            smartRefreshLayout.invalidate();
                        }
                    }
                }
                if ((i >= 0 || i2 > 0) && SmartRefreshLayout.this.f27938ar != null) {
                    int max = Math.max(i, 0);
                    int i3 = SmartRefreshLayout.this.ah;
                    int i4 = (int) (SmartRefreshLayout.this.ah * SmartRefreshLayout.this.an);
                    float f = (max * 1.0f) / (SmartRefreshLayout.this.ah == 0 ? 1 : SmartRefreshLayout.this.ah);
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.a(smartRefreshLayout4.A) || (SmartRefreshLayout.this.ay == RefreshState.RefreshFinish && !z)) {
                        if (i2 != SmartRefreshLayout.this.b) {
                            if (SmartRefreshLayout.this.f27938ar.getSpinnerStyle() == SpinnerStyle.Translate) {
                                SmartRefreshLayout.this.f27938ar.getView().setTranslationY(SmartRefreshLayout.this.b);
                                if (SmartRefreshLayout.this.aB != 0 && SmartRefreshLayout.this.au != null) {
                                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                                    if (!smartRefreshLayout5.a(smartRefreshLayout5.E, SmartRefreshLayout.this.f27938ar)) {
                                        smartRefreshLayout.invalidate();
                                    }
                                }
                            } else if (SmartRefreshLayout.this.f27938ar.getSpinnerStyle() == SpinnerStyle.Scale) {
                                SmartRefreshLayout.this.f27938ar.getView().requestLayout();
                            }
                            SmartRefreshLayout.this.f27938ar.a(z, f, max, i3, i4);
                        }
                        if (z && SmartRefreshLayout.this.f27938ar.b()) {
                            int i5 = (int) SmartRefreshLayout.this.j;
                            int width = smartRefreshLayout.getWidth();
                            SmartRefreshLayout.this.f27938ar.a(SmartRefreshLayout.this.j / (width == 0 ? 1 : width), i5, width);
                        }
                    }
                    if (i2 != SmartRefreshLayout.this.b && SmartRefreshLayout.this.aa != null && (SmartRefreshLayout.this.f27938ar instanceof RefreshHeader)) {
                        SmartRefreshLayout.this.aa.a((RefreshHeader) SmartRefreshLayout.this.f27938ar, z, f, max, i3, i4);
                    }
                }
                if ((i <= 0 || i2 < 0) && SmartRefreshLayout.this.as != null) {
                    int i6 = -Math.min(i, 0);
                    int i7 = SmartRefreshLayout.this.aj;
                    int i8 = (int) (SmartRefreshLayout.this.aj * SmartRefreshLayout.this.ao);
                    float f2 = (i6 * 1.0f) / (SmartRefreshLayout.this.aj == 0 ? 1 : SmartRefreshLayout.this.aj);
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.a(smartRefreshLayout6.B) || (SmartRefreshLayout.this.ay == RefreshState.LoadFinish && !z)) {
                        if (i2 != SmartRefreshLayout.this.b) {
                            if (SmartRefreshLayout.this.as.getSpinnerStyle() == SpinnerStyle.Translate) {
                                SmartRefreshLayout.this.as.getView().setTranslationY(SmartRefreshLayout.this.b);
                                if (SmartRefreshLayout.this.aC != 0 && SmartRefreshLayout.this.au != null) {
                                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                    if (!smartRefreshLayout7.a(smartRefreshLayout7.F, SmartRefreshLayout.this.as)) {
                                        smartRefreshLayout.invalidate();
                                    }
                                }
                            } else if (SmartRefreshLayout.this.as.getSpinnerStyle() == SpinnerStyle.Scale) {
                                SmartRefreshLayout.this.as.getView().requestLayout();
                            }
                            SmartRefreshLayout.this.as.a(z, f2, i6, i7, i8);
                        }
                        if (z && SmartRefreshLayout.this.as.b()) {
                            int i9 = (int) SmartRefreshLayout.this.j;
                            int width2 = smartRefreshLayout.getWidth();
                            SmartRefreshLayout.this.as.a(SmartRefreshLayout.this.j / (width2 == 0 ? 1 : width2), i9, width2);
                        }
                    }
                    if (i2 != SmartRefreshLayout.this.b && SmartRefreshLayout.this.aa != null && (SmartRefreshLayout.this.as instanceof RefreshFooter)) {
                        SmartRefreshLayout.this.aa.a((RefreshFooter) SmartRefreshLayout.this.as, z, f2, i6, i7, i8);
                    }
                }
                return this;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel a(RefreshInternal refreshInternal, int i) {
            if (SmartRefreshLayout.this.au == null && i != 0) {
                SmartRefreshLayout.this.au = new Paint();
            }
            if (refreshInternal.equals(SmartRefreshLayout.this.f27938ar)) {
                SmartRefreshLayout.this.aB = i;
                return this;
            }
            if (refreshInternal.equals(SmartRefreshLayout.this.as)) {
                SmartRefreshLayout.this.aC = i;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel a(RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.f27938ar)) {
                SmartRefreshLayout.this.aD = z;
                return this;
            }
            if (refreshInternal.equals(SmartRefreshLayout.this.as)) {
                SmartRefreshLayout.this.aE = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel a(RefreshState refreshState) {
            switch (AnonymousClass10.f27941a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout.this.c();
                    return null;
                case 2:
                    if (!SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.a(smartRefreshLayout.A)) {
                            SmartRefreshLayout.this.a(RefreshState.PullDownToRefresh);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.a(smartRefreshLayout2.B) || SmartRefreshLayout.this.ay.v || SmartRefreshLayout.this.ay.w || (SmartRefreshLayout.this.R && SmartRefreshLayout.this.G)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                        return null;
                    }
                    SmartRefreshLayout.this.a(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    if (!SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        if (smartRefreshLayout3.a(smartRefreshLayout3.A)) {
                            SmartRefreshLayout.this.a(RefreshState.PullDownCanceled);
                            SmartRefreshLayout.this.c();
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout4.a(smartRefreshLayout4.B) || SmartRefreshLayout.this.ay.v || (SmartRefreshLayout.this.R && SmartRefreshLayout.this.G)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.a(RefreshState.PullUpCanceled);
                    SmartRefreshLayout.this.c();
                    return null;
                case 6:
                    if (!SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.a(smartRefreshLayout5.A)) {
                            SmartRefreshLayout.this.a(RefreshState.ReleaseToRefresh);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout6.a(smartRefreshLayout6.B) || SmartRefreshLayout.this.ay.v || SmartRefreshLayout.this.ay.w || (SmartRefreshLayout.this.R && SmartRefreshLayout.this.G)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                        return null;
                    }
                    SmartRefreshLayout.this.a(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    if (!SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (smartRefreshLayout7.a(smartRefreshLayout7.A)) {
                            SmartRefreshLayout.this.a(RefreshState.ReleaseToTwoLevel);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    if (!SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.a(smartRefreshLayout8.A)) {
                            SmartRefreshLayout.this.a(RefreshState.RefreshReleased);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    if (!SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        if (smartRefreshLayout9.a(smartRefreshLayout9.B)) {
                            SmartRefreshLayout.this.a(RefreshState.LoadReleased);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.b();
                    return null;
                case 12:
                    SmartRefreshLayout.this.a();
                    return null;
                case 13:
                    if (SmartRefreshLayout.this.ay == RefreshState.Refreshing) {
                        SmartRefreshLayout.this.a(RefreshState.RefreshFinish);
                        return null;
                    }
                    return null;
                case 14:
                    if (SmartRefreshLayout.this.ay == RefreshState.Loading) {
                        SmartRefreshLayout.this.a(RefreshState.LoadFinish);
                        return null;
                    }
                    return null;
                case 15:
                    SmartRefreshLayout.this.a(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    SmartRefreshLayout.this.a(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    SmartRefreshLayout.this.a(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel a(boolean z) {
            if (!z) {
                if (a(0) == null) {
                    SmartRefreshLayout.this.a(RefreshState.None);
                }
                return this;
            }
            AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.RefreshKernelImpl.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout.this.aw.a(RefreshState.TwoLevel);
                }
            };
            ValueAnimator a2 = a(SmartRefreshLayout.this.getMeasuredHeight());
            if (a2 == null || a2 != SmartRefreshLayout.this.aM) {
                animatorListenerAdapter.onAnimationEnd(null);
                return this;
            }
            a2.setDuration(SmartRefreshLayout.this.e);
            a2.addListener(animatorListenerAdapter);
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshLayout a() {
            return SmartRefreshLayout.this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel b() {
            if (SmartRefreshLayout.this.ay == RefreshState.TwoLevel) {
                SmartRefreshLayout.this.aw.a(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.b == 0) {
                    a(0, false);
                    SmartRefreshLayout.this.a(RefreshState.None);
                    return this;
                }
                a(0).setDuration(SmartRefreshLayout.this.e);
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel b(int i) {
            SmartRefreshLayout.this.e = i;
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 250;
        this.f = 250;
        this.l = 0.5f;
        this.m = 'n';
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.ae = new int[2];
        this.af = new NestedScrollingChildHelper(this);
        this.ag = new NestedScrollingParentHelper(this);
        this.ai = DimensionStatus.DefaultUnNotify;
        this.ak = DimensionStatus.DefaultUnNotify;
        this.an = 2.5f;
        this.ao = 2.5f;
        this.ap = 1.0f;
        this.aq = 1.0f;
        this.aw = new RefreshKernelImpl();
        this.ay = RefreshState.None;
        this.az = RefreshState.None;
        this.aA = 0L;
        this.aB = 0;
        this.aC = 0;
        this.aF = false;
        this.aJ = false;
        this.aK = null;
        super.setClipToPadding(false);
        DensityUtil densityUtil = new DensityUtil();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.w = new Scroller(context);
        this.x = VelocityTracker.obtain();
        this.g = context.getResources().getDisplayMetrics().heightPixels;
        this.y = new ViscousFluidInterpolator();
        this.f27937a = viewConfiguration.getScaledTouchSlop();
        this.t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.aj = densityUtil.b(60.0f);
        this.ah = densityUtil.b(100.0f);
        this.af.setNestedScrollingEnabled(true);
        DefaultRefreshInitializer defaultRefreshInitializer = aI;
        if (defaultRefreshInitializer != null) {
            defaultRefreshInitializer.a(context, this);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        this.af.setNestedScrollingEnabled(obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.af.isNestedScrollingEnabled()));
        this.l = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.l);
        this.an = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.an);
        this.ao = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.ao);
        this.ap = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.ap);
        this.aq = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.aq);
        this.A = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.A);
        this.f = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.B);
        this.ah = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.ah);
        this.aj = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.aj);
        this.al = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.al);
        this.am = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.am);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.P);
        this.Q = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.Q);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.E);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.F);
        this.H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.H);
        this.K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.K);
        this.I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.I);
        this.L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.L);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.M);
        this.N = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.N);
        this.O = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.O);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.G);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, this.G);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.C);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.D);
        this.J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.J);
        this.p = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.p);
        this.q = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.q);
        this.r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.r);
        this.s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.s);
        this.S = this.S || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.T = this.T || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.U = this.U || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.ai = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? DimensionStatus.XmlLayoutUnNotify : this.ai;
        this.ak = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? DimensionStatus.XmlLayoutUnNotify : this.ak;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.z = new int[]{color2, color};
            } else {
                this.z = new int[]{color2};
            }
        } else if (color != 0) {
            this.z = new int[]{0, color};
        }
        if (this.L && !obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag)) {
            this.J = true;
        }
        if (this.J && !this.S && !this.B) {
            this.B = true;
        }
        obtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        aG = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        aH = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshInitializer(DefaultRefreshInitializer defaultRefreshInitializer) {
        aI = defaultRefreshInitializer;
    }

    protected ValueAnimator a(int i, int i2, Interpolator interpolator, int i3) {
        if (this.b != i) {
            ValueAnimator valueAnimator = this.aM;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.aL = null;
            ValueAnimator ofInt = ValueAnimator.ofInt(this.b, i);
            this.aM = ofInt;
            ofInt.setDuration(i3);
            this.aM.setInterpolator(interpolator);
            this.aM.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout.this.aM = null;
                    if (SmartRefreshLayout.this.b == 0 && SmartRefreshLayout.this.ay != RefreshState.None && !SmartRefreshLayout.this.ay.v) {
                        SmartRefreshLayout.this.a(RefreshState.None);
                    } else if (SmartRefreshLayout.this.ay != SmartRefreshLayout.this.az) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.setViceState(smartRefreshLayout.ay);
                    }
                }
            });
            this.aM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SmartRefreshLayout.this.aw.a(((Integer) valueAnimator2.getAnimatedValue()).intValue(), false);
                }
            });
            this.aM.setStartDelay(i2);
            this.aM.start();
            return this.aM;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public SmartRefreshLayout a(int i, final boolean z) {
        if (this.ay == RefreshState.Refreshing && z) {
            f();
        }
        postDelayed(new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.6
            @Override // java.lang.Runnable
            public void run() {
                if (SmartRefreshLayout.this.ay != RefreshState.Refreshing || SmartRefreshLayout.this.f27938ar == null || SmartRefreshLayout.this.at == null) {
                    return;
                }
                SmartRefreshLayout.this.a(RefreshState.RefreshFinish);
                int a2 = SmartRefreshLayout.this.f27938ar.a(SmartRefreshLayout.this, z);
                if (SmartRefreshLayout.this.aa != null && (SmartRefreshLayout.this.f27938ar instanceof RefreshHeader)) {
                    SmartRefreshLayout.this.aa.a((RefreshHeader) SmartRefreshLayout.this.f27938ar, z);
                }
                if (a2 < Integer.MAX_VALUE) {
                    if (SmartRefreshLayout.this.n || SmartRefreshLayout.this.ad) {
                        if (SmartRefreshLayout.this.n) {
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            smartRefreshLayout.i = smartRefreshLayout.k;
                            SmartRefreshLayout.this.d = 0;
                            SmartRefreshLayout.this.n = false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout2.j, (SmartRefreshLayout.this.k + SmartRefreshLayout.this.b) - (SmartRefreshLayout.this.f27937a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout3.j, SmartRefreshLayout.this.k + SmartRefreshLayout.this.b, 0));
                        if (SmartRefreshLayout.this.ad) {
                            SmartRefreshLayout.this.ac = 0;
                        }
                    }
                    if (SmartRefreshLayout.this.b <= 0) {
                        if (SmartRefreshLayout.this.b < 0) {
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            smartRefreshLayout4.a(0, a2, smartRefreshLayout4.y, SmartRefreshLayout.this.f);
                            return;
                        }
                        SmartRefreshLayout.this.aw.a(0, false);
                        SmartRefreshLayout.this.c();
                        return;
                    }
                    ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    ValueAnimator a3 = smartRefreshLayout5.a(0, a2, smartRefreshLayout5.y, SmartRefreshLayout.this.f);
                    if (SmartRefreshLayout.this.N) {
                        animatorUpdateListener = SmartRefreshLayout.this.at.a(SmartRefreshLayout.this.b);
                    }
                    if (a3 == null || animatorUpdateListener == null) {
                        return;
                    }
                    a3.addUpdateListener(animatorUpdateListener);
                }
            }
        }, i <= 0 ? 1L : i);
        return this;
    }

    public SmartRefreshLayout a(int i, boolean z, boolean z2) {
        postDelayed(new AnonymousClass7(z, z2), i <= 0 ? 1L : i);
        return this;
    }

    public SmartRefreshLayout a(RefreshFooter refreshFooter) {
        return a(refreshFooter, -1, -2);
    }

    public SmartRefreshLayout a(RefreshFooter refreshFooter, int i, int i2) {
        RefreshInternal refreshInternal = this.as;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.as = refreshFooter;
        this.aC = 0;
        this.aE = false;
        this.ak = this.ak.a();
        this.B = !this.S || this.B;
        if (this.as.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            super.addView(this.as.getView(), 0, new LayoutParams(i, i2));
            return this;
        }
        super.addView(this.as.getView(), i, i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: a */
    public SmartRefreshLayout b(RefreshHeader refreshHeader) {
        return a(refreshHeader, -1, -2);
    }

    public SmartRefreshLayout a(RefreshHeader refreshHeader, int i, int i2) {
        RefreshInternal refreshInternal = this.f27938ar;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.f27938ar = refreshHeader;
        this.aB = 0;
        this.aD = false;
        this.ai = this.ai.a();
        if (this.f27938ar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            super.addView(this.f27938ar.getView(), 0, new LayoutParams(i, i2));
            return this;
        }
        super.addView(this.f27938ar.getView(), i, i2);
        return this;
    }

    public SmartRefreshLayout a(OnLoadMoreListener onLoadMoreListener) {
        this.W = onLoadMoreListener;
        this.B = this.B || !(this.S || onLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: a */
    public SmartRefreshLayout b(OnMultiPurposeListener onMultiPurposeListener) {
        this.aa = onMultiPurposeListener;
        return this;
    }

    public SmartRefreshLayout a(OnRefreshListener onRefreshListener) {
        this.V = onRefreshListener;
        return this;
    }

    public SmartRefreshLayout a(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.V = onRefreshLoadMoreListener;
        this.W = onRefreshLoadMoreListener;
        this.B = this.B || !(this.S || onRefreshLoadMoreListener == null);
        return this;
    }

    public SmartRefreshLayout a(int... iArr) {
        RefreshInternal refreshInternal = this.f27938ar;
        if (refreshInternal != null) {
            refreshInternal.setPrimaryColors(iArr);
        }
        RefreshInternal refreshInternal2 = this.as;
        if (refreshInternal2 != null) {
            refreshInternal2.setPrimaryColors(iArr);
        }
        this.z = iArr;
        return this;
    }

    protected void a() {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.setStateDirectLoading(true);
            }
        };
        a(RefreshState.LoadReleased);
        ValueAnimator a2 = this.aw.a(-this.aj);
        if (a2 != null) {
            a2.addListener(animatorListenerAdapter);
        }
        RefreshInternal refreshInternal = this.as;
        if (refreshInternal != null) {
            int i = this.aj;
            refreshInternal.b(this, i, (int) (this.ao * i));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.aa;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.as;
            if (refreshInternal2 instanceof RefreshFooter) {
                RefreshFooter refreshFooter = (RefreshFooter) refreshInternal2;
                int i2 = this.aj;
                onMultiPurposeListener.a(refreshFooter, i2, (int) (this.ao * i2));
            }
        }
        if (a2 == null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
    }

    protected void a(float f) {
        if (this.aM == null) {
            if (f > 0.0f && (this.ay == RefreshState.Refreshing || this.ay == RefreshState.TwoLevel)) {
                this.aL = new BounceRunnable(f, this.ah);
            } else if (f < 0.0f && (this.ay == RefreshState.Loading || ((this.G && this.R && a(this.B)) || (this.K && !this.R && a(this.B) && this.ay != RefreshState.Refreshing)))) {
                this.aL = new BounceRunnable(f, -this.aj);
            } else if (this.b == 0 && this.I) {
                this.aL = new BounceRunnable(f, 0);
            }
        }
    }

    protected void a(RefreshState refreshState) {
        RefreshState refreshState2 = this.ay;
        if (refreshState2 == refreshState) {
            if (this.az != refreshState2) {
                this.az = refreshState2;
                return;
            }
            return;
        }
        this.ay = refreshState;
        this.az = refreshState;
        RefreshInternal refreshInternal = this.f27938ar;
        RefreshInternal refreshInternal2 = this.as;
        OnMultiPurposeListener onMultiPurposeListener = this.aa;
        if (refreshInternal != null) {
            refreshInternal.a(this, refreshState2, refreshState);
        }
        if (refreshInternal2 != null) {
            refreshInternal2.a(this, refreshState2, refreshState);
        }
        if (onMultiPurposeListener != null) {
            onMultiPurposeListener.a(this, refreshState2, refreshState);
        }
    }

    protected boolean a(int i) {
        if (i == 0) {
            if (this.aM != null) {
                if (this.ay.w || this.ay == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (this.ay == RefreshState.PullDownCanceled) {
                    this.aw.a(RefreshState.PullDownToRefresh);
                } else if (this.ay == RefreshState.PullUpCanceled) {
                    this.aw.a(RefreshState.PullUpToLoad);
                }
                this.aM.cancel();
                this.aM = null;
            }
            this.aL = null;
        }
        return this.aM != null;
    }

    public boolean a(int i, final int i2, final float f, final boolean z) {
        if (this.ay == RefreshState.None && a(this.A)) {
            Runnable runnable = new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.8
                @Override // java.lang.Runnable
                public void run() {
                    if (SmartRefreshLayout.this.aM != null) {
                        SmartRefreshLayout.this.aM.cancel();
                    }
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.aM = ValueAnimator.ofInt(smartRefreshLayout.b, (int) (SmartRefreshLayout.this.ah * f));
                    SmartRefreshLayout.this.aM.setDuration(i2);
                    SmartRefreshLayout.this.aM.setInterpolator(new DecelerateInterpolator());
                    SmartRefreshLayout.this.aM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SmartRefreshLayout.this.aw.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                        }
                    });
                    SmartRefreshLayout.this.aM.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.8.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            SmartRefreshLayout.this.aM = null;
                            if (z) {
                                if (SmartRefreshLayout.this.ay == RefreshState.ReleaseToRefresh) {
                                    SmartRefreshLayout.this.aw.a(RefreshState.PullDownToRefresh);
                                }
                            } else if (SmartRefreshLayout.this.ay != RefreshState.ReleaseToRefresh) {
                                SmartRefreshLayout.this.aw.a(RefreshState.ReleaseToRefresh);
                            }
                            SmartRefreshLayout.this.d();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            SmartRefreshLayout.this.j = smartRefreshLayout2.getMeasuredWidth() / 2;
                            SmartRefreshLayout.this.aw.a(RefreshState.PullDownToRefresh);
                        }
                    });
                    SmartRefreshLayout.this.aM.start();
                }
            };
            if (i > 0) {
                postDelayed(runnable, i);
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    protected boolean a(Float f) {
        float floatValue = f == null ? this.v : f.floatValue();
        if (Math.abs(floatValue) > this.t) {
            if (this.b * floatValue < 0.0f) {
                if (this.ay == RefreshState.Refreshing || this.ay == RefreshState.Loading || (this.b < 0 && this.R)) {
                    this.aL = new FlingRunnable(floatValue).a();
                    return true;
                } else if (this.ay.x) {
                    return true;
                }
            }
            if (floatValue >= 0.0f || ((!this.I || !this.B) && ((this.ay != RefreshState.Loading || this.b < 0) && (!this.K || !a(this.B))))) {
                if (floatValue <= 0.0f) {
                    return false;
                }
                if ((!this.I || !this.A) && (this.ay != RefreshState.Refreshing || this.b > 0)) {
                    return false;
                }
            }
            this.aJ = false;
            this.w.fling(0, 0, 0, (int) (-floatValue), 0, 0, AudioSystem.DEVICE_IN_COMMUNICATION, Integer.MAX_VALUE);
            this.w.computeScrollOffset();
            invalidate();
            return false;
        }
        return false;
    }

    protected boolean a(boolean z) {
        return z && !this.L;
    }

    protected boolean a(boolean z, RefreshInternal refreshInternal) {
        return z || this.L || refreshInternal == null || refreshInternal.getSpinnerStyle() == SpinnerStyle.FixedBehind;
    }

    public SmartRefreshLayout b(int i) {
        return a(i, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: b */
    public SmartRefreshLayout l(boolean z) {
        this.S = true;
        this.B = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: b */
    public SmartRefreshLayout c(int... iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                a(iArr2);
                return this;
            }
            iArr2[i2] = SmartUtil.a(getContext(), iArr[i2]);
            i = i2 + 1;
        }
    }

    protected void b() {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.aA = System.currentTimeMillis();
                SmartRefreshLayout.this.a(RefreshState.Refreshing);
                if (SmartRefreshLayout.this.V != null) {
                    SmartRefreshLayout.this.V.onRefresh(SmartRefreshLayout.this);
                } else if (SmartRefreshLayout.this.aa == null) {
                    SmartRefreshLayout.this.b(3000);
                }
                if (SmartRefreshLayout.this.f27938ar != null) {
                    RefreshInternal refreshInternal = SmartRefreshLayout.this.f27938ar;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    refreshInternal.a(smartRefreshLayout, smartRefreshLayout.ah, (int) (SmartRefreshLayout.this.an * SmartRefreshLayout.this.ah));
                }
                if (SmartRefreshLayout.this.aa == null || !(SmartRefreshLayout.this.f27938ar instanceof RefreshHeader)) {
                    return;
                }
                SmartRefreshLayout.this.aa.onRefresh(SmartRefreshLayout.this);
                SmartRefreshLayout.this.aa.b((RefreshHeader) SmartRefreshLayout.this.f27938ar, SmartRefreshLayout.this.ah, (int) (SmartRefreshLayout.this.an * SmartRefreshLayout.this.ah));
            }
        };
        a(RefreshState.RefreshReleased);
        ValueAnimator a2 = this.aw.a(this.ah);
        if (a2 != null) {
            a2.addListener(animatorListenerAdapter);
        }
        RefreshInternal refreshInternal = this.f27938ar;
        if (refreshInternal != null) {
            int i = this.ah;
            refreshInternal.b(this, i, (int) (this.an * i));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.aa;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.f27938ar;
            if (refreshInternal2 instanceof RefreshHeader) {
                RefreshHeader refreshHeader = (RefreshHeader) refreshInternal2;
                int i2 = this.ah;
                onMultiPurposeListener.a(refreshHeader, i2, (int) (this.an * i2));
            }
        }
        if (a2 == null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
    }

    protected void b(float f) {
        if (this.ad && !this.O && f < 0.0f && !this.at.d()) {
            f = 0.0f;
        }
        if (this.ay == RefreshState.TwoLevel && f > 0.0f) {
            this.aw.a(Math.min((int) f, getMeasuredHeight()), true);
        } else if (this.ay == RefreshState.Refreshing && f >= 0.0f) {
            int i = this.ah;
            if (f < i) {
                this.aw.a((int) f, true);
            } else {
                double d = (this.an - 1.0f) * i;
                int max = Math.max((this.g * 4) / 3, getHeight());
                int i2 = this.ah;
                double d2 = max - i2;
                double max2 = Math.max(0.0f, (f - i2) * this.l);
                double d3 = -max2;
                double d4 = d2;
                if (d2 == 0.0d) {
                    d4 = 1.0d;
                }
                this.aw.a(((int) Math.min(d * (1.0d - Math.pow(100.0d, d3 / d4)), max2)) + this.ah, true);
            }
        } else if (f < 0.0f && (this.ay == RefreshState.Loading || ((this.G && this.R && a(this.B)) || (this.K && !this.R && a(this.B))))) {
            int i3 = this.aj;
            if (f > (-i3)) {
                this.aw.a((int) f, true);
            } else {
                double d5 = (this.ao - 1.0f) * i3;
                int max3 = Math.max((this.g * 4) / 3, getHeight());
                int i4 = this.aj;
                double d6 = max3 - i4;
                double d7 = -Math.min(0.0f, (i4 + f) * this.l);
                double d8 = -d7;
                double d9 = d6;
                if (d6 == 0.0d) {
                    d9 = 1.0d;
                }
                this.aw.a(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d9)), d7))) - this.aj, true);
            }
        } else if (f >= 0.0f) {
            double d10 = this.an * this.ah;
            double max4 = Math.max(this.g / 2, getHeight());
            double max5 = Math.max(0.0f, this.l * f);
            double d11 = -max5;
            double d12 = max4;
            if (max4 == 0.0d) {
                d12 = 1.0d;
            }
            this.aw.a((int) Math.min(d10 * (1.0d - Math.pow(100.0d, d11 / d12)), max5), true);
        } else {
            double d13 = this.ao * this.aj;
            double max6 = Math.max(this.g / 2, getHeight());
            double d14 = -Math.min(0.0f, this.l * f);
            double d15 = -d14;
            double d16 = max6;
            if (max6 == 0.0d) {
                d16 = 1.0d;
            }
            this.aw.a((int) (-Math.min(d13 * (1.0d - Math.pow(100.0d, d15 / d16)), d14)), true);
        }
        if (!this.K || this.R || !a(this.B) || f >= 0.0f || this.ay == RefreshState.Refreshing || this.ay == RefreshState.Loading || this.ay == RefreshState.LoadFinish) {
            return;
        }
        if (this.Q) {
            this.aL = null;
            this.aw.a(-this.aj);
        }
        setStateDirectLoading(false);
        postDelayed(new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (SmartRefreshLayout.this.W != null) {
                    SmartRefreshLayout.this.W.onLoadMore(SmartRefreshLayout.this);
                } else if (SmartRefreshLayout.this.aa == null) {
                    SmartRefreshLayout.this.c(2000);
                }
                OnMultiPurposeListener onMultiPurposeListener = SmartRefreshLayout.this.aa;
                if (onMultiPurposeListener != null) {
                    onMultiPurposeListener.onLoadMore(SmartRefreshLayout.this);
                }
            }
        }, this.f);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: c */
    public SmartRefreshLayout f(float f) {
        if (this.ak.a(DimensionStatus.CodeExact)) {
            this.aj = DensityUtil.a(f);
            this.ak = DimensionStatus.CodeExactUnNotify;
            RefreshInternal refreshInternal = this.as;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    public SmartRefreshLayout c(int i) {
        return a(i, true, false);
    }

    public SmartRefreshLayout c(boolean z) {
        this.A = z;
        return this;
    }

    protected void c() {
        if (this.ay != RefreshState.None && this.b == 0) {
            a(RefreshState.None);
        }
        if (this.b != 0) {
            this.aw.a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.w.getCurrY();
        if (this.w.computeScrollOffset()) {
            int finalY = this.w.getFinalY();
            if ((finalY >= 0 || !this.A || !this.at.c()) && (finalY <= 0 || !this.B || !this.at.d())) {
                this.aJ = true;
                invalidate();
                return;
            }
            if (this.aJ) {
                a(Build.VERSION.SDK_INT >= 14 ? finalY > 0 ? -this.w.getCurrVelocity() : this.w.getCurrVelocity() : ((this.w.getCurrY() - finalY) * 1.0f) / Math.max(this.w.getDuration() - this.w.timePassed(), 1));
            }
            this.w.forceFinished(true);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: d */
    public SmartRefreshLayout e(float f) {
        this.an = f;
        RefreshInternal refreshInternal = this.f27938ar;
        if (refreshInternal == null || this.av == null) {
            this.ai = this.ai.a();
            return this;
        }
        RefreshKernel refreshKernel = this.aw;
        int i = this.ah;
        refreshInternal.a(refreshKernel, i, (int) (f * i));
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: d */
    public SmartRefreshLayout k(boolean z) {
        this.K = z;
        return this;
    }

    protected void d() {
        if (this.ay == RefreshState.TwoLevel) {
            if (this.v <= -1000 || this.b <= getMeasuredHeight() / 2) {
                if (this.n) {
                    this.aw.b();
                    return;
                }
                return;
            }
            ValueAnimator a2 = this.aw.a(getMeasuredHeight());
            if (a2 != null) {
                a2.setDuration(this.e);
            }
        } else if (this.ay == RefreshState.Loading || (this.G && this.R && this.b < 0 && a(this.B))) {
            int i = this.b;
            int i2 = this.aj;
            if (i < (-i2)) {
                this.aw.a(-i2);
            } else if (i > 0) {
                this.aw.a(0);
            }
        } else if (this.ay == RefreshState.Refreshing) {
            int i3 = this.b;
            int i4 = this.ah;
            if (i3 > i4) {
                this.aw.a(i4);
            } else if (i3 < 0) {
                this.aw.a(0);
            }
        } else if (this.ay == RefreshState.PullDownToRefresh) {
            this.aw.a(RefreshState.PullDownCanceled);
        } else if (this.ay == RefreshState.PullUpToLoad) {
            this.aw.a(RefreshState.PullUpCanceled);
        } else if (this.ay == RefreshState.ReleaseToRefresh) {
            this.aw.a(RefreshState.Refreshing);
        } else if (this.ay == RefreshState.ReleaseToLoad) {
            this.aw.a(RefreshState.Loading);
        } else if (this.ay == RefreshState.ReleaseToTwoLevel) {
            this.aw.a(RefreshState.TwoLevelReleased);
        } else if (this.ay == RefreshState.RefreshReleased) {
            if (this.aM == null) {
                this.aw.a(this.ah);
            }
        } else if (this.ay == RefreshState.LoadReleased) {
            if (this.aM == null) {
                this.aw.a(-this.aj);
            }
        } else if (this.b != 0) {
            this.aw.a(0);
        }
    }

    @Deprecated
    public boolean d(int i) {
        int i2 = this.f;
        float f = this.an / 2.0f;
        int i3 = this.ah;
        float f2 = i3;
        int i4 = i3;
        if (i3 == 0) {
            i4 = 1;
        }
        return a(i, i2, (((f + 0.5f) * f2) * 1.0f) / i4, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0216, code lost:
        if (r0 != 3) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03db, code lost:
        if (r9.f27939c > 0) goto L174;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 1601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        RefreshContent refreshContent = this.at;
        View a2 = refreshContent != null ? refreshContent.a() : null;
        RefreshInternal refreshInternal = this.f27938ar;
        if (refreshInternal != null && refreshInternal.getView() == view) {
            if (!a(this.A)) {
                return true;
            }
            if (!this.H && isInEditMode()) {
                return true;
            }
            if (a2 != null) {
                int max = Math.max(a2.getTop() + a2.getPaddingTop() + this.b, view.getTop());
                int i = this.aB;
                int i2 = max;
                if (i != 0) {
                    Paint paint = this.au;
                    i2 = max;
                    if (paint != null) {
                        paint.setColor(i);
                        if (this.f27938ar.getSpinnerStyle() == SpinnerStyle.Scale) {
                            max = view.getBottom();
                        } else if (this.f27938ar.getSpinnerStyle() == SpinnerStyle.Translate) {
                            max = view.getBottom() + this.b;
                        }
                        canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), max, this.au);
                        i2 = max;
                    }
                }
                if (this.C && this.f27938ar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), i2);
                    boolean drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        RefreshInternal refreshInternal2 = this.as;
        if (refreshInternal2 != null && refreshInternal2.getView() == view) {
            if (!a(this.B)) {
                return true;
            }
            if (!this.H && isInEditMode()) {
                return true;
            }
            if (a2 != null) {
                int min = Math.min((a2.getBottom() - a2.getPaddingBottom()) + this.b, view.getBottom());
                int i3 = this.aC;
                int i4 = min;
                if (i3 != 0) {
                    Paint paint2 = this.au;
                    i4 = min;
                    if (paint2 != null) {
                        paint2.setColor(i3);
                        if (this.as.getSpinnerStyle() == SpinnerStyle.Scale) {
                            min = view.getTop();
                        } else if (this.as.getSpinnerStyle() == SpinnerStyle.Translate) {
                            min = view.getTop() + this.b;
                        }
                        canvas.drawRect(view.getLeft(), min, view.getRight(), view.getBottom(), this.au);
                        i4 = min;
                    }
                }
                if (this.D && this.as.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), i4, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public SmartRefreshLayout e(boolean z) {
        this.I = z;
        return this;
    }

    public SmartRefreshLayout f(boolean z) {
        this.L = z;
        return this;
    }

    public RefreshLayout f() {
        this.R = false;
        RefreshInternal refreshInternal = this.as;
        if ((refreshInternal instanceof RefreshFooter) && !((RefreshFooter) refreshInternal).a(false)) {
            PrintStream printStream = System.out;
            printStream.println("Footer:" + this.as + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)");
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /* renamed from: g */
    public SmartRefreshLayout j() {
        return b(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.aA))), 300));
    }

    public SmartRefreshLayout g(boolean z) {
        this.J = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public SmartRefreshLayout getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.ag.getNestedScrollAxes();
    }

    public RefreshFooter getRefreshFooter() {
        RefreshInternal refreshInternal = this.as;
        if (refreshInternal instanceof RefreshFooter) {
            return (RefreshFooter) refreshInternal;
        }
        return null;
    }

    public RefreshHeader getRefreshHeader() {
        RefreshInternal refreshInternal = this.f27938ar;
        if (refreshInternal instanceof RefreshHeader) {
            return (RefreshHeader) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshState getState() {
        return this.ay;
    }

    public SmartRefreshLayout h() {
        return c(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.aA))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout h(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    @Deprecated
    public SmartRefreshLayout i(boolean z) {
        if (this.ay == RefreshState.Loading && z) {
            h();
        }
        this.R = z;
        RefreshInternal refreshInternal = this.as;
        if ((refreshInternal instanceof RefreshFooter) && !((RefreshFooter) refreshInternal).a(z)) {
            PrintStream printStream = System.out;
            printStream.println("Footer:" + this.as + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)");
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean i() {
        int i = this.av == null ? 400 : 0;
        int i2 = this.f;
        float f = this.an / 2.0f;
        int i3 = this.ah;
        float f2 = i3;
        int i4 = i3;
        if (i3 == 0) {
            i4 = 1;
        }
        return a(i, i2, (((f + 0.5f) * f2) * 1.0f) / i4, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.af.isNestedScrollingEnabled();
    }

    public SmartRefreshLayout j(boolean z) {
        return a(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.aA))), 300) : 0, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        RefreshInternal refreshInternal;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.av == null) {
                this.av = new Handler();
            }
            List<DelayedRunnable> list = this.ax;
            if (list != null) {
                for (DelayedRunnable delayedRunnable : list) {
                    this.av.postDelayed(delayedRunnable, delayedRunnable.f27997a);
                }
                this.ax.clear();
                this.ax = null;
            }
            if (this.f27938ar == null) {
                DefaultRefreshHeaderCreator defaultRefreshHeaderCreator = aH;
                if (defaultRefreshHeaderCreator != null) {
                    b(defaultRefreshHeaderCreator.createRefreshHeader(getContext(), this));
                } else {
                    b(new BezierRadarHeader(getContext()));
                }
            }
            if (this.as == null) {
                DefaultRefreshFooterCreator defaultRefreshFooterCreator = aG;
                if (defaultRefreshFooterCreator != null) {
                    a(defaultRefreshFooterCreator.createRefreshFooter(getContext(), this));
                } else {
                    boolean z = this.B;
                    a(new BallPulseFooter(getContext()));
                    this.B = z;
                }
            } else {
                this.B = this.B || !this.S;
            }
            if (this.at == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i2);
                    RefreshInternal refreshInternal2 = this.f27938ar;
                    if ((refreshInternal2 == null || childAt != refreshInternal2.getView()) && ((refreshInternal = this.as) == null || childAt != refreshInternal.getView())) {
                        this.at = new RefreshContentWrapper(childAt);
                    }
                    i = i2 + 1;
                }
            }
            if (this.at == null) {
                int a2 = DensityUtil.a(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                RefreshContentWrapper refreshContentWrapper = new RefreshContentWrapper(textView);
                this.at = refreshContentWrapper;
                refreshContentWrapper.a().setPadding(a2, a2, a2, a2);
            }
            int i3 = this.p;
            View findViewById = i3 > 0 ? findViewById(i3) : null;
            int i4 = this.q;
            View findViewById2 = i4 > 0 ? findViewById(i4) : null;
            this.at.a(this.ab);
            this.at.a(this.O);
            this.at.a(this.aw, findViewById, findViewById2);
            if (this.b != 0) {
                a(RefreshState.None);
                RefreshContent refreshContent = this.at;
                this.b = 0;
                refreshContent.a(0, this.r, this.s);
            }
        }
        int[] iArr = this.z;
        if (iArr != null) {
            RefreshInternal refreshInternal3 = this.f27938ar;
            if (refreshInternal3 != null) {
                refreshInternal3.setPrimaryColors(iArr);
            }
            RefreshInternal refreshInternal4 = this.as;
            if (refreshInternal4 != null) {
                refreshInternal4.setPrimaryColors(this.z);
            }
        }
        RefreshContent refreshContent2 = this.at;
        if (refreshContent2 != null) {
            super.bringChildToFront(refreshContent2.a());
        }
        RefreshInternal refreshInternal5 = this.f27938ar;
        if (refreshInternal5 != null && refreshInternal5.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
            super.bringChildToFront(this.f27938ar.getView());
        }
        RefreshInternal refreshInternal6 = this.as;
        if (refreshInternal6 == null || refreshInternal6.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            return;
        }
        super.bringChildToFront(this.as.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aw.a(0, true);
        a(RefreshState.None);
        Handler handler = this.av;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.av = null;
        }
        List<DelayedRunnable> list = this.ax;
        if (list != null) {
            list.clear();
            this.ax = null;
        }
        this.S = true;
        this.aL = null;
        ValueAnimator valueAnimator = this.aM;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.aM.removeAllUpdateListeners();
            this.aM.cancel();
            this.aM = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0164 A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFinishInflate() {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= childCount) {
                return;
            }
            View childAt = super.getChildAt(i8);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                RefreshContent refreshContent = this.at;
                if (refreshContent != null && refreshContent.a() == childAt) {
                    boolean z2 = isInEditMode() && this.H && a(this.A) && this.f27938ar != null;
                    View a2 = this.at.a();
                    LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
                    int i9 = layoutParams.leftMargin + paddingLeft;
                    int i10 = layoutParams.topMargin + paddingTop;
                    int measuredWidth = a2.getMeasuredWidth();
                    int measuredHeight = a2.getMeasuredHeight() + i10;
                    int i11 = i10;
                    int i12 = measuredHeight;
                    if (z2) {
                        i11 = i10;
                        i12 = measuredHeight;
                        if (a(this.E, this.f27938ar)) {
                            int i13 = this.ah;
                            i11 = i10 + i13;
                            i12 = measuredHeight + i13;
                        }
                    }
                    a2.layout(i9, i11, measuredWidth + i9, i12);
                }
                RefreshInternal refreshInternal = this.f27938ar;
                if (refreshInternal != null && refreshInternal.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.H && a(this.A);
                    View view = this.f27938ar.getView();
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    int i14 = layoutParams2.leftMargin;
                    int i15 = layoutParams2.topMargin + this.al;
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight() + i15;
                    int i16 = i15;
                    int i17 = measuredHeight2;
                    if (!z3) {
                        i16 = i15;
                        i17 = measuredHeight2;
                        if (this.f27938ar.getSpinnerStyle() == SpinnerStyle.Translate) {
                            int i18 = this.ah;
                            i16 = i15 - i18;
                            i17 = measuredHeight2 - i18;
                        }
                    }
                    view.layout(i14, i16, measuredWidth2 + i14, i17);
                }
                RefreshInternal refreshInternal2 = this.as;
                if (refreshInternal2 != null && refreshInternal2.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.H && a(this.B);
                    View view2 = this.as.getView();
                    LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                    SpinnerStyle spinnerStyle = this.as.getSpinnerStyle();
                    int i19 = layoutParams3.leftMargin;
                    int measuredHeight3 = (layoutParams3.topMargin + getMeasuredHeight()) - this.am;
                    if (spinnerStyle == SpinnerStyle.MatchLayout) {
                        i6 = layoutParams3.topMargin - this.am;
                    } else {
                        if (z4 || spinnerStyle == SpinnerStyle.FixedFront || spinnerStyle == SpinnerStyle.FixedBehind) {
                            i5 = this.aj;
                        } else {
                            i6 = measuredHeight3;
                            if (spinnerStyle == SpinnerStyle.Scale) {
                                i6 = measuredHeight3;
                                if (this.b < 0) {
                                    i5 = Math.max(a(this.B) ? -this.b : 0, 0);
                                }
                            }
                        }
                        i6 = measuredHeight3 - i5;
                    }
                    view2.layout(i19, i6, view2.getMeasuredWidth() + i19, view2.getMeasuredHeight() + i6);
                }
            }
            i7 = i8 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0130, code lost:
        if (r6.ai.m == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0337, code lost:
        if (r6.ak.m == false) goto L81;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 1449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return this.af.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return (this.aF && f2 > 0.0f) || a(Float.valueOf(-f2)) || this.af.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3;
        int i4 = this.ac;
        if (i2 * i4 > 0) {
            if (Math.abs(i2) > Math.abs(this.ac)) {
                i3 = this.ac;
                this.ac = 0;
            } else {
                this.ac -= i2;
                i3 = i2;
            }
            b(this.ac);
        } else {
            i3 = 0;
            if (i2 > 0) {
                i3 = 0;
                if (this.aF) {
                    int i5 = i4 - i2;
                    this.ac = i5;
                    b(i5);
                    i3 = i2;
                }
            }
        }
        this.af.dispatchNestedPreScroll(i, i2 - i3, iArr, null);
        iArr[1] = iArr[1] + i3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.af.dispatchNestedScroll(i, i2, i3, i4, this.ae);
        int i5 = i4 + this.ae[1];
        if (i5 != 0 && ((i5 < 0 && this.A) || (i5 > 0 && this.B))) {
            if (this.az == RefreshState.None || this.az.v) {
                this.aw.a(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
            }
            int i6 = this.ac - i5;
            this.ac = i6;
            b(i6);
        }
        if (!this.aF || i2 >= 0) {
            return;
        }
        this.aF = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.ag.onNestedScrollAccepted(view, view2, i);
        this.af.startNestedScroll(i & 2);
        this.ac = this.b;
        this.ad = true;
        a(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z = true;
        if (isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) {
            if (!this.A) {
                if (this.B) {
                    return true;
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.ag.onStopNestedScroll(view);
        this.ad = false;
        this.ac = 0;
        d();
        this.af.stopNestedScroll();
    }

    @Override // android.view.View
    public boolean post(Runnable runnable) {
        Handler handler = this.av;
        if (handler == null) {
            List<DelayedRunnable> list = this.ax;
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
            }
            this.ax = arrayList;
            arrayList.add(new DelayedRunnable(runnable, 0L));
            return false;
        }
        return handler.post(new DelayedRunnable(runnable, 0L));
    }

    @Override // android.view.View
    public boolean postDelayed(Runnable runnable, long j) {
        if (j == 0) {
            new DelayedRunnable(runnable, 0L).run();
            return true;
        }
        Handler handler = this.av;
        if (handler == null) {
            List<DelayedRunnable> list = this.ax;
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
            }
            this.ax = arrayList;
            arrayList.add(new DelayedRunnable(runnable, j));
            return false;
        }
        return handler.postDelayed(new DelayedRunnable(runnable, 0L), j);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.af.setNestedScrollingEnabled(z);
    }

    protected void setStateDirectLoading(boolean z) {
        if (this.ay != RefreshState.Loading) {
            this.aA = System.currentTimeMillis();
            this.aF = true;
            a(RefreshState.Loading);
            OnLoadMoreListener onLoadMoreListener = this.W;
            if (onLoadMoreListener != null) {
                if (z) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.aa == null) {
                c(2000);
            }
            RefreshInternal refreshInternal = this.as;
            if (refreshInternal != null) {
                int i = this.aj;
                refreshInternal.a(this, i, (int) (this.ao * i));
            }
            OnMultiPurposeListener onMultiPurposeListener = this.aa;
            if (onMultiPurposeListener == null || !(this.as instanceof RefreshFooter)) {
                return;
            }
            if (onMultiPurposeListener != null && z) {
                onMultiPurposeListener.onLoadMore(this);
            }
            OnMultiPurposeListener onMultiPurposeListener2 = this.aa;
            RefreshFooter refreshFooter = (RefreshFooter) this.as;
            int i2 = this.aj;
            onMultiPurposeListener2.b(refreshFooter, i2, (int) (this.ao * i2));
        }
    }

    protected void setViceState(RefreshState refreshState) {
        if (this.ay.u && this.ay.r != refreshState.r) {
            a(RefreshState.None);
        }
        if (this.az != refreshState) {
            this.az = refreshState;
        }
    }
}
