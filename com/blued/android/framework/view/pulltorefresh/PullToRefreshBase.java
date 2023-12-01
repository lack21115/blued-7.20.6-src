package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.framework.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase.class */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
    private static String C = "";
    private OnPullEventListener<T> A;
    private PullToRefreshBase<T>.SmoothScrollRunnable B;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    T a;
    private Context b;
    private boolean c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private State l;
    private Mode m;
    private Mode n;
    private FrameLayout o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private Interpolator u;
    private AnimationStyle v;
    private LoadingLayout w;
    private LoadingLayout x;
    private OnRefreshListener<T> y;
    private OnRefreshListener2<T> z;

    /* renamed from: com.blued.android.framework.view.pulltorefresh.PullToRefreshBase$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$3.class */
    class AnonymousClass3 implements OnSmoothScrollFinishedListener {
        final /* synthetic */ PullToRefreshBase a;

        @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnSmoothScrollFinishedListener
        public void a() {
            this.a.a(0, 200L, 225L, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.view.pulltorefresh.PullToRefreshBase$4  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c0 -> B:84:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c4 -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c8 -> B:64:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00cc -> B:76:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d0 -> B:72:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00d4 -> B:80:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d8 -> B:78:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00dc -> B:19:0x006b). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00e0 -> B:82:0x007f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e4 -> B:66:0x008a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00e8 -> B:62:0x0095). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00ec -> B:28:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00f0 -> B:70:0x00b4). Please submit an issue!!! */
        static {
            int[] iArr = new int[AnimationStyle.values().length];
            d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[State.values().length];
            c = iArr2;
            try {
                iArr2[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                c[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                c[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                c[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                c[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                c[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr3 = new int[Mode.values().length];
            b = iArr3;
            try {
                iArr3[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                b[Mode.PULL_FROM_END.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                b[Mode.PULL_FROM_START.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                b[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            int[] iArr4 = new int[Orientation.values().length];
            a = iArr4;
            try {
                iArr4[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$AnimationStyle.class */
    public enum AnimationStyle {
        ROTATE,
        FLIP;

        static AnimationStyle a() {
            return ROTATE;
        }

        static AnimationStyle a(int i) {
            return i != 1 ? ROTATE : FLIP;
        }

        LoadingLayout a(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            if (!TextUtils.isEmpty(PullToRefreshBase.C)) {
                try {
                    return (LoadingLayout) Class.forName(PullToRefreshBase.C).getConstructor(Context.class, Mode.class, Orientation.class, TypedArray.class).newInstance(context, mode, orientation, typedArray);
                } catch (Exception e) {
                    e.printStackTrace();
                    return AnonymousClass4.d[ordinal()] != 2 ? new RotateLoadingLayout(context, mode, orientation, typedArray) : new FlipLoadingLayout(context, mode, orientation, typedArray);
                }
            }
            String e2 = PullToRefreshHelper.e();
            if (TextUtils.isEmpty(e2)) {
                return AnonymousClass4.d[ordinal()] != 2 ? new RotateLoadingLayout(context, mode, orientation, typedArray) : new FlipLoadingLayout(context, mode, orientation, typedArray);
            }
            try {
                return (LoadingLayout) Class.forName(e2).getConstructor(Context.class, Mode.class, Orientation.class, TypedArray.class).newInstance(context, mode, orientation, typedArray);
            } catch (Exception e3) {
                e3.printStackTrace();
                return AnonymousClass4.d[ordinal()] != 2 ? new RotateLoadingLayout(context, mode, orientation, typedArray) : new FlipLoadingLayout(context, mode, orientation, typedArray);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$Mode.class */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode f;
        public static Mode g;
        private int h;

        static {
            Mode mode = PULL_FROM_START;
            Mode mode2 = PULL_FROM_END;
            f = mode;
            g = mode2;
        }

        Mode(int i2) {
            this.h = i2;
        }

        static Mode a() {
            return PULL_FROM_START;
        }

        static Mode a(int i2) {
            Mode[] values = values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return a();
                }
                Mode mode = values[i4];
                if (i2 == mode.e()) {
                    return mode;
                }
                i3 = i4 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean c() {
            return this == PULL_FROM_START || this == BOTH;
        }

        public boolean d() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        int e() {
            return this.h;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$OnLastItemVisibleListener.class */
    public interface OnLastItemVisibleListener {
        void a();
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$OnPullEventListener.class */
    public interface OnPullEventListener<V extends View> {
        void onPullEvent(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$OnRefreshListener.class */
    public interface OnRefreshListener<V extends View> {
        void onRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$OnRefreshListener2.class */
    public interface OnRefreshListener2<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$OnSmoothScrollFinishedListener.class */
    public interface OnSmoothScrollFinishedListener {
        void a();
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$Orientation.class */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$SmoothScrollRunnable.class */
    public final class SmoothScrollRunnable implements Runnable {
        private final Interpolator b;
        private final int c;
        private final int d;
        private final long e;
        private OnSmoothScrollFinishedListener f;
        private boolean g = true;
        private long h = -1;
        private int i = -1;

        public SmoothScrollRunnable(int i, int i2, long j, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
            this.d = i;
            this.c = i2;
            this.b = PullToRefreshBase.this.u;
            this.e = j;
            this.f = onSmoothScrollFinishedListener;
        }

        public void a() {
            this.g = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }

        public boolean b() {
            return this.g;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h == -1) {
                this.h = System.currentTimeMillis();
            } else {
                int round = this.d - Math.round((this.d - this.c) * this.b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.h) * 1000) / this.e, 1000L), 0L)) / 1000.0f));
                this.i = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (this.g && this.c != this.i) {
                ViewCompat.a(PullToRefreshBase.this, this);
                return;
            }
            this.g = false;
            OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = this.f;
            if (onSmoothScrollFinishedListener != null) {
                onSmoothScrollFinishedListener.a();
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshBase$State.class */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int g;

        State(int i) {
            this.g = i;
        }

        static State a(int i) {
            State[] values = values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return RESET;
                }
                State state = values[i3];
                if (i == state.a()) {
                    return state;
                }
                i2 = i3 + 1;
            }
        }

        int a() {
            return this.g;
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.k = false;
        this.l = State.RESET;
        this.m = Mode.a();
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.a();
        this.D = 0;
        this.F = false;
        this.G = true;
        b(context, (AttributeSet) null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = State.RESET;
        this.m = Mode.a();
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.a();
        this.D = 0;
        this.F = false;
        this.G = true;
        b(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.k = false;
        this.l = State.RESET;
        this.m = Mode.a();
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.a();
        this.D = 0;
        this.F = false;
        this.G = true;
        this.m = mode;
        b(context, (AttributeSet) null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.k = false;
        this.l = State.RESET;
        this.m = Mode.a();
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.a();
        this.D = 0;
        this.F = false;
        this.G = true;
        this.m = mode;
        this.v = animationStyle;
        b(context, (AttributeSet) null);
    }

    private final void a(int i, long j) {
        a(i, j, 0L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, long j, long j2, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.B;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.a();
        }
        int scrollY = AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()] != 1 ? getScrollY() : getScrollX();
        if (scrollY == i) {
            if (onSmoothScrollFinishedListener != null) {
                onSmoothScrollFinishedListener.a();
                return;
            }
            return;
        }
        if (this.u == null) {
            this.u = new DecelerateInterpolator();
        }
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(scrollY, i, j, onSmoothScrollFinishedListener);
        this.B = smoothScrollRunnable2;
        if (j2 > 0) {
            postDelayed(smoothScrollRunnable2, j2);
        } else {
            post(smoothScrollRunnable2);
        }
    }

    private void a(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.o = frameLayout;
        frameLayout.addView(t, -1, -1);
        a(this.o, new LinearLayout.LayoutParams(-1, -1));
    }

    private void a(MotionEvent motionEvent) {
        this.i = this.e - this.g;
        this.j = this.f - this.h;
        float x = motionEvent.getX();
        this.g = x;
        this.e = x;
        this.e = x + this.i;
        float y = motionEvent.getY();
        this.h = y;
        this.f = y;
        this.f = y + this.j;
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.b = context;
        if (AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrMode)) {
            this.m = Mode.a(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrAnimationStyle)) {
            this.v = AnimationStyle.a(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_ptrAnimationStyle, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrHeaderLoadingClass)) {
            C = obtainStyledAttributes.getString(R.styleable.PullToRefresh_ptrHeaderLoadingClass);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrMaximumPullHeight)) {
            this.E = (int) obtainStyledAttributes.getDimension(R.styleable.PullToRefresh_ptrMaximumPullHeight, 0.0f);
        }
        T a = a(context, attributeSet);
        this.a = a;
        a(context, (Context) a);
        this.w = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.x = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.a.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrAdapterViewBackground)) {
            Log.w("ptrAViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.a.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrOverScroll)) {
            this.s = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
            this.q = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        f();
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        return AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()] != 1 ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(-2, -1);
    }

    private int getMaximumPullScroll() {
        if (AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            int i = this.E;
            return i != 0 ? i : Math.round(getHeight() / 2.0f);
        }
        return Math.round(getWidth() / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        OnRefreshListener<T> onRefreshListener = this.y;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh(this);
        } else if (this.z != null) {
            if (this.n == Mode.PULL_FROM_START) {
                this.z.a(this);
            } else if (this.n == Mode.PULL_FROM_END) {
                this.z.b(this);
            }
        }
    }

    private boolean p() {
        int i = AnonymousClass4.b[this.m.ordinal()];
        if (i != 2) {
            if (i != 3) {
                boolean z = false;
                if (i != 4) {
                    return false;
                }
                if (e() || d()) {
                    z = true;
                }
                return z;
            }
            return d();
        }
        return e();
    }

    private void q() {
        float f;
        float f2;
        int round;
        int footerSize;
        if (AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f = this.h;
            f2 = this.f;
        } else {
            f = this.g;
            f2 = this.e;
        }
        if (AnonymousClass4.b[this.n.ordinal()] != 2) {
            round = Math.round(Math.min(f - f2, 0.0f) / 2.0f);
            footerSize = getHeaderSize();
        } else {
            round = Math.round(Math.max(f - f2, 0.0f) / 2.0f);
            footerSize = getFooterSize();
        }
        if (this.D != 0 || !this.F) {
            setHeaderScroll(round);
        }
        this.D = round;
        if (round == 0 || i()) {
            return;
        }
        float abs = Math.abs(round) / footerSize;
        if (AnonymousClass4.b[this.n.ordinal()] != 2) {
            this.w.onPull(abs);
        } else {
            this.x.onPull(abs);
        }
        if (this.l != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
            a(State.PULL_TO_REFRESH, new boolean[0]);
        } else if (this.l != State.PULL_TO_REFRESH || footerSize >= Math.abs(round)) {
        } else {
            a(State.RELEASE_TO_REFRESH, new boolean[0]);
        }
    }

    protected abstract T a(Context context, AttributeSet attributeSet);

    public final ILoadingLayout a(boolean z, boolean z2) {
        return b(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout a = this.v.a(context, mode, getPullToRefreshScrollDirection(), typedArray);
        a.setVisibility(4);
        C = "";
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        int i = AnonymousClass4.b[this.n.ordinal()];
        if (i == 2) {
            this.x.pullToRefresh();
        } else if (i != 3) {
        } else {
            this.w.pullToRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        a(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        a(i, getPullToRefreshScrollDuration(), 0L, onSmoothScrollFinishedListener);
    }

    protected void a(TypedArray typedArray) {
    }

    protected void a(Bundle bundle) {
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.l = state;
        int i = AnonymousClass4.c[this.l.ordinal()];
        if (i == 1) {
            c();
        } else if (i == 2) {
            a();
        } else if (i == 3) {
            b();
        } else if (i == 4 || i == 5) {
            a(zArr[0]);
        }
        OnPullEventListener<T> onPullEventListener = this.A;
        if (onPullEventListener != null) {
            onPullEventListener.onPullEvent(this, this.l, this.n);
        }
    }

    public void a(CharSequence charSequence, Mode mode) {
        a(mode.c(), mode.d()).setReleaseLabel(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if (this.m.c()) {
            this.w.refreshing();
        }
        if (this.m.d()) {
            this.x.refreshing();
        }
        if (!z) {
            o();
        } else if (!this.p) {
            a(0);
        } else {
            OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = new OnSmoothScrollFinishedListener() { // from class: com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.1
                @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnSmoothScrollFinishedListener
                public void a() {
                    PullToRefreshBase.this.o();
                }
            };
            int i = AnonymousClass4.b[this.n.ordinal()];
            if (i == 1 || i == 2) {
                a(getFooterSize(), onSmoothScrollFinishedListener);
            } else {
                a(-getHeaderSize(), onSmoothScrollFinishedListener);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        T refreshableView = getRefreshableView();
        if (!(refreshableView instanceof ViewGroup)) {
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
        ((ViewGroup) refreshableView).addView(view, i, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoadingLayoutProxy b(boolean z, boolean z2) {
        LoadingLayoutProxy loadingLayoutProxy = new LoadingLayoutProxy();
        if (z && this.m.c()) {
            loadingLayoutProxy.a(this.w);
        }
        if (z2 && this.m.d()) {
            loadingLayoutProxy.a(this.x);
        }
        return loadingLayoutProxy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        int i = AnonymousClass4.b[this.n.ordinal()];
        if (i == 2) {
            this.x.releaseToRefresh();
        } else if (i != 3) {
        } else {
            this.w.releaseToRefresh();
        }
    }

    protected void b(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.k = false;
        this.t = true;
        this.w.reset();
        this.x.reset();
        a(0);
    }

    protected abstract boolean d();

    protected abstract boolean e();

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.w.getParent()) {
            removeView(this.w);
        }
        if (this.m.c()) {
            a(this.w, 0, loadingLayoutLayoutParams);
        }
        if (this == this.x.getParent()) {
            removeView(this.x);
        }
        if (this.m.d()) {
            a(this.x, loadingLayoutLayoutParams);
        }
        m();
        this.n = this.m != Mode.BOTH ? this.m : Mode.PULL_FROM_START;
    }

    public final boolean g() {
        return this.m.b();
    }

    public final Mode getCurrentMode() {
        return this.n;
    }

    public final boolean getFilterTouchEvents() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getFooterSize() {
        return this.x.getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getHeaderSize() {
        return this.w.getContentSize();
    }

    public final ILoadingLayout getLoadingLayoutProxy() {
        return a(true, true);
    }

    public final Mode getMode() {
        return this.m;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    public final T getRefreshableView() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout getRefreshableViewWrapper() {
        return this.o;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.p;
    }

    public final State getState() {
        return this.l;
    }

    public final boolean h() {
        return Build.VERSION.SDK_INT >= 9 && this.s && OverscrollHelper.a(this.a);
    }

    public final boolean i() {
        return this.l == State.REFRESHING || this.l == State.MANUAL_REFRESHING;
    }

    public final void j() {
        if (i()) {
            a(State.RESET, new boolean[0]);
        }
    }

    public final void k() {
        setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        this.t = false;
    }

    protected final void m() {
        int i;
        int i2;
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i3 = AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()];
        if (i3 == 1) {
            if (this.m.c()) {
                this.w.setWidth(maximumPullScroll);
                i = -maximumPullScroll;
            } else {
                i = 0;
            }
            if (this.m.d()) {
                this.x.setWidth(maximumPullScroll);
                paddingRight = -maximumPullScroll;
                paddingLeft = i;
            } else {
                paddingRight = 0;
                paddingLeft = i;
            }
        } else if (i3 == 2) {
            if (this.m.c()) {
                this.w.setHeight(maximumPullScroll);
                i2 = -maximumPullScroll;
            } else {
                i2 = 0;
            }
            if (this.m.d()) {
                this.x.setHeight(maximumPullScroll);
                paddingBottom = -maximumPullScroll;
                paddingTop = i2;
            } else {
                paddingBottom = 0;
                paddingTop = i2;
            }
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (g()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.k = false;
                return false;
            } else if (action == 0 || !this.k) {
                PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.B;
                if (smoothScrollRunnable == null || !smoothScrollRunnable.b()) {
                    if (action != 0) {
                        if (action == 2) {
                            if (!this.q && i()) {
                                return true;
                            }
                            if (p()) {
                                float y = motionEvent.getY();
                                float x = motionEvent.getX();
                                if (AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                                    f = y - this.f;
                                    f2 = x - this.e;
                                } else {
                                    f = x - this.e;
                                    f2 = y - this.f;
                                }
                                float abs = Math.abs(f);
                                if (abs > this.d && (!this.r || abs > Math.abs(f2))) {
                                    if (this.m.c() && f >= 1.0f && d()) {
                                        this.f = y;
                                        this.e = x;
                                        this.k = true;
                                        if (this.m == Mode.BOTH) {
                                            this.n = Mode.PULL_FROM_START;
                                        }
                                    } else if (this.m.d() && f <= -1.0f && e()) {
                                        this.f = y;
                                        this.e = x;
                                        this.k = true;
                                        if (this.m == Mode.BOTH) {
                                            this.n = Mode.PULL_FROM_END;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (p()) {
                        float y2 = motionEvent.getY();
                        this.h = y2;
                        this.f = y2;
                        float x2 = motionEvent.getX();
                        this.g = x2;
                        this.e = x2;
                        this.k = false;
                        this.c = false;
                        this.i = 0.0f;
                        this.j = 0.0f;
                    }
                    return this.k;
                }
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setMode(Mode.a(bundle.getInt("ptr_mode", 0)));
        this.n = Mode.a(bundle.getInt("ptr_current_mode", 0));
        this.q = bundle.getBoolean("ptr_disable_scrolling", false);
        this.p = bundle.getBoolean("ptr_show_refreshing_view", true);
        super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
        State a = State.a(bundle.getInt("ptr_state", 0));
        if (a == State.REFRESHING || a == State.MANUAL_REFRESHING) {
            a(a, true);
        }
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        b(bundle);
        bundle.putInt("ptr_state", this.l.a());
        bundle.putInt("ptr_mode", this.m.e());
        bundle.putInt("ptr_current_mode", this.n.e());
        bundle.putBoolean("ptr_disable_scrolling", this.q);
        bundle.putBoolean("ptr_show_refreshing_view", this.p);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.G) {
            this.G = false;
            m();
            post(new Runnable() { // from class: com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.2
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.requestLayout();
                }
            });
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (g()) {
            if (this.q || !i()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    int action = motionEvent.getAction() & 255;
                    if (action == 0) {
                        if (p()) {
                            float y = motionEvent.getY();
                            this.h = y;
                            this.f = y;
                            float x = motionEvent.getX();
                            this.g = x;
                            this.e = x;
                            this.c = false;
                            this.i = 0.0f;
                            this.j = 0.0f;
                            return true;
                        }
                        return false;
                    }
                    if (action != 1) {
                        if (action == 2) {
                            if (this.k) {
                                if (this.c) {
                                    a(motionEvent);
                                    this.c = false;
                                }
                                this.f = motionEvent.getY() + this.j;
                                this.e = motionEvent.getX() + this.i;
                                q();
                                return true;
                            }
                            return false;
                        } else if (action != 3) {
                            if ((action == 5 || action == 6) && this.k) {
                                this.c = true;
                                return false;
                            }
                            return false;
                        }
                    }
                    this.D = 0;
                    if (this.k) {
                        this.k = false;
                        if (this.l == State.RELEASE_TO_REFRESH && (this.y != null || this.z != null)) {
                            a(State.REFRESHING, true);
                            return true;
                        } else if (!i()) {
                            a(State.RESET, new boolean[0]);
                            return true;
                        } else {
                            int i = AnonymousClass4.b[this.n.ordinal()];
                            if (i == 1 || i == 2) {
                                a(getFooterSize());
                                return true;
                            }
                            a(-getHeaderSize());
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.r = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.t) {
            if (min < 0) {
                this.w.setVisibility(0);
            } else if (min > 0) {
                this.x.setVisibility(0);
            }
        }
        int i2 = AnonymousClass4.a[getPullToRefreshScrollDirection().ordinal()];
        if (i2 == 1) {
            scrollTo(min, 0);
        } else if (i2 != 2) {
        } else {
            scrollTo(0, min);
        }
    }

    public void setIfIgnoreFirstScroll(boolean z) {
        this.F = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.m) {
            this.m = mode;
            f();
        }
    }

    public void setOnPullEventListener(OnPullEventListener<T> onPullEventListener) {
        this.A = onPullEventListener;
    }

    public final void setOnRefreshListener(OnRefreshListener2<T> onRefreshListener2) {
        this.z = onRefreshListener2;
        this.y = null;
    }

    public final void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.y = onRefreshListener;
        this.z = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.a() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.s = z;
    }

    public final void setRefreshing(boolean z) {
        if (i()) {
            return;
        }
        a(State.MANUAL_REFRESHING, z);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        a(charSequence, Mode.BOTH);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.u = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.q = z;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.p = z;
    }
}
