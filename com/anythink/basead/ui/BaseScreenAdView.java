package com.anythink.basead.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.a.b.g;
import com.anythink.basead.c;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.basead.c.i;
import com.anythink.basead.c.j;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.basead.ui.EndCardView;
import com.anythink.basead.ui.MraidEndCardView;
import com.anythink.basead.ui.PanelView;
import com.anythink.basead.ui.PlayerView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.bytedance.applog.tracker.Tracker;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseScreenAdView.class */
public abstract class BaseScreenAdView extends BaseAdView {
    public static final int FORMAT_INTERSTITIAL = 3;
    public static final int FORMAT_REWARD_VIDEO = 1;
    public static final String TAG = BaseScreenAdView.class.getSimpleName();
    public static final int TYPE_FULL_SCREEN = 0;
    public static final int TYPE_HALF_SCREEN = 1;
    protected b A;
    int B;
    protected int C;
    protected int D;
    protected b.InterfaceC0039b E;
    protected boolean F;
    protected int G;
    protected CountDownView H;
    protected CloseImageView I;
    protected ViewGroup J;
    protected MuteImageView K;
    protected int L;
    protected boolean M;
    protected float N;
    protected int O;
    protected int P;
    protected int Q;
    protected BaseShakeView R;
    protected BaseShakeView S;
    final long T;
    final long U;
    Runnable V;
    ConcurrentHashMap<Integer, Boolean> W;
    protected int a;
    protected int aa;
    protected int ab;
    protected int ac;
    protected int ad;
    private boolean ae;
    private boolean af;
    private long ag;
    private long ah;
    private long ai;
    private long aj;
    private c ak;
    private boolean al;
    private boolean am;
    private boolean an;
    protected int t;
    protected boolean u;
    protected boolean v;
    protected RelativeLayout w;
    protected PlayerView x;
    protected PanelView y;
    protected BaseEndCardView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.BaseScreenAdView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseScreenAdView$2.class */
    public final class AnonymousClass2 implements c.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.c.a
        public final void a() {
            BaseScreenAdView.c(BaseScreenAdView.this);
        }

        @Override // com.anythink.basead.c.a
        public final void b() {
            BaseScreenAdView.this.r();
            BaseScreenAdView.this.ak.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.BaseScreenAdView$7  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseScreenAdView$7.class */
    public final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            BaseScreenAdView.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.BaseScreenAdView$8  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseScreenAdView$8.class */
    public final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            BaseScreenAdView.f(BaseScreenAdView.this);
        }
    }

    public BaseScreenAdView(Context context) {
        super(context);
        this.G = 0;
        this.al = false;
        this.T = 3000L;
        this.U = 500L;
        this.am = false;
        this.an = false;
        this.V = new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenAdView.super.h();
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseScreenAdView(android.content.Context r7, com.anythink.core.common.e.j r8, com.anythink.core.common.e.i r9, java.lang.String r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.BaseScreenAdView.<init>(android.content.Context, com.anythink.core.common.e.j, com.anythink.core.common.e.i, java.lang.String, int, int):void");
    }

    private void K() {
        if (n() && !this.c.m.V() && this.z == null) {
            this.z = b(true);
        }
    }

    private void L() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = displayMetrics.widthPixels;
        this.D = displayMetrics.heightPixels;
    }

    private void M() {
        if (this.z == null) {
            this.z = b(false);
        }
        H();
    }

    private void N() {
        int q = q();
        this.Q = q;
        final boolean c = c(q);
        EndCardView endCardView = new EndCardView(getContext(), this.d, this.c);
        endCardView.setSize(this.C, this.D);
        endCardView.init(false, false, new EndCardView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.16
            @Override // com.anythink.basead.ui.EndCardView.a
            public final void a() {
                String str = BaseScreenAdView.TAG;
                BaseScreenAdView.this.b(1);
            }

            @Override // com.anythink.basead.ui.EndCardView.a
            public final void b() {
                BaseScreenAdView.this.I();
                if (c) {
                    BaseScreenAdView.this.E();
                }
            }
        });
        this.z = endCardView;
        H();
        PanelView panelView = this.y;
        if (panelView != null && panelView.getVisibility() == 0) {
            if (this.y.getCTAButton() == null || this.y.getCTAButton().getVisibility() != 0) {
                this.s = this.y;
            } else {
                this.s = this.y.getCTAButton();
            }
        }
        endCardView.load();
    }

    private void O() {
        s();
        if (this.ak == null) {
            this.ak = new c();
        }
        this.ak.a(getContext(), this.d, this.c, new AnonymousClass2());
    }

    private void P() {
        this.ae = true;
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void Q() {
        if (this.A == null) {
            this.A = new b(this.w);
        }
        this.A.b();
    }

    private void R() {
        b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void S() {
        com.anythink.basead.a.b.a(1, this.d, i());
        b.InterfaceC0039b interfaceC0039b = this.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.b();
        }
    }

    private void T() {
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setVisibility(4);
        }
    }

    private void U() {
        CloseImageView closeImageView = this.I;
        if (closeImageView != null) {
            this.N = a(closeImageView, this.c.m.h());
            this.I.setVisibility(8);
            this.I.setOnClickListener(new AnonymousClass7());
        }
    }

    private void V() {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.J.setOnClickListener(new AnonymousClass8());
        }
    }

    private void W() {
        ViewGroup viewGroup;
        if (this.ae || (viewGroup = this.J) == null || viewGroup.isShown()) {
            return;
        }
        this.J.setVisibility(0);
    }

    private static int a(k kVar) {
        int B;
        if (kVar == null || (B = (int) (kVar.B() / 100.0f)) == 0) {
            return 0;
        }
        Random random = new Random();
        if (random.nextInt(100) > B) {
            return 0;
        }
        int C = kVar.C();
        int D = kVar.D();
        if (D <= 0) {
            return 0;
        }
        if (C == D) {
            return C;
        }
        try {
            return random.nextInt(D - C) + C;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    static /* synthetic */ void a(BaseScreenAdView baseScreenAdView, int i) {
        ac X;
        Map<Integer, String[]> y;
        if (!(baseScreenAdView.d instanceof aa) || (X = ((aa) baseScreenAdView.d).X()) == null || (y = X.y()) == null || y.size() <= 0) {
            return;
        }
        if (baseScreenAdView.W == null) {
            baseScreenAdView.W = new ConcurrentHashMap<>();
        }
        int i2 = i / 1000;
        for (Integer num : y.keySet()) {
            if (baseScreenAdView.W.get(num) == null || !baseScreenAdView.W.get(num).booleanValue()) {
                if (i2 >= num.intValue()) {
                    baseScreenAdView.W.put(num, Boolean.TRUE);
                    i i3 = baseScreenAdView.i();
                    i3.h.i = num.intValue();
                    com.anythink.basead.a.b.a(32, baseScreenAdView.d, i3);
                }
            }
        }
    }

    private BaseEndCardView b(boolean z) {
        MraidEndCardView mraidEndCardView = new MraidEndCardView(getContext(), this.d, this.c);
        mraidEndCardView.setEndCardListener(new MraidEndCardView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.15
            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void a() {
                if (3 == BaseScreenAdView.this.a) {
                    if (BaseScreenAdView.this.d.C() == 1 && BaseScreenAdView.this.d.E()) {
                        return;
                    }
                    BaseScreenAdView.this.h();
                }
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void a(String str) {
                String str2 = BaseScreenAdView.TAG;
                BaseScreenAdView.this.d.v(str);
                BaseScreenAdView.this.b(1);
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void b() {
                BaseScreenAdView.this.I();
            }
        });
        mraidEndCardView.init(z);
        return mraidEndCardView;
    }

    static /* synthetic */ void b(BaseScreenAdView baseScreenAdView) {
        com.anythink.basead.a.b.a(1, baseScreenAdView.d, baseScreenAdView.i());
        b.InterfaceC0039b interfaceC0039b = baseScreenAdView.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.b();
        }
    }

    static /* synthetic */ void b(BaseScreenAdView baseScreenAdView, int i) {
        long j = baseScreenAdView.ai;
        if (j >= 0 && i > j) {
            baseScreenAdView.F();
        } else if (baseScreenAdView.F) {
            long j2 = baseScreenAdView.ag;
            if (j2 < 0 || i < j2) {
                return;
            }
            baseScreenAdView.E();
        }
    }

    static /* synthetic */ void c(BaseScreenAdView baseScreenAdView) {
        baseScreenAdView.ae = true;
        ViewGroup viewGroup = baseScreenAdView.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    static /* synthetic */ void c(BaseScreenAdView baseScreenAdView, int i) {
        if (baseScreenAdView.F && baseScreenAdView.ag == -1) {
            long j = baseScreenAdView.ah;
            if (j != 0) {
                long j2 = i;
                baseScreenAdView.ag = j2;
                if (j > 0) {
                    baseScreenAdView.ai = j2 + j;
                }
                baseScreenAdView.E();
            }
        }
    }

    private void e(int i) {
        ac X;
        Map<Integer, String[]> y;
        if (!(this.d instanceof aa) || (X = ((aa) this.d).X()) == null || (y = X.y()) == null || y.size() <= 0) {
            return;
        }
        if (this.W == null) {
            this.W = new ConcurrentHashMap<>();
        }
        int i2 = i / 1000;
        for (Integer num : y.keySet()) {
            if (this.W.get(num) == null || !this.W.get(num).booleanValue()) {
                if (i2 >= num.intValue()) {
                    this.W.put(num, Boolean.TRUE);
                    i i3 = i();
                    i3.h.i = num.intValue();
                    com.anythink.basead.a.b.a(32, this.d, i3);
                }
            }
        }
    }

    static /* synthetic */ void e(BaseScreenAdView baseScreenAdView) {
        b bVar = baseScreenAdView.A;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void f(int i) {
        long j = this.ai;
        if (j >= 0 && i > j) {
            F();
        } else if (this.F) {
            long j2 = this.ag;
            if (j2 < 0 || i < j2) {
                return;
            }
            E();
        }
    }

    static /* synthetic */ void f(BaseScreenAdView baseScreenAdView) {
        baseScreenAdView.s();
        if (baseScreenAdView.ak == null) {
            baseScreenAdView.ak = new c();
        }
        baseScreenAdView.ak.a(baseScreenAdView.getContext(), baseScreenAdView.d, baseScreenAdView.c, new AnonymousClass2());
    }

    private void g(int i) {
        if (this.F && this.ag == -1) {
            long j = this.ah;
            if (j != 0) {
                long j2 = i;
                this.ag = j2;
                if (j > 0) {
                    this.ai = j2 + j;
                }
                E();
            }
        }
    }

    protected abstract void A();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B() {
        PlayerView playerView = this.x;
        if (playerView == null || !playerView.isPlaying()) {
            return;
        }
        this.x.stop();
        this.x.removeAllViews();
        i i = i();
        i.g = j();
        com.anythink.basead.a.b.a(16, this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C() {
        i i = i();
        i.g = j();
        com.anythink.basead.a.b.a(7, this.d, i);
        b.InterfaceC0039b interfaceC0039b = this.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        CountDownView countDownView = this.H;
        if (countDownView != null && !countDownView.isShown()) {
            this.H.setVisibility(0);
        }
        MuteImageView muteImageView = this.K;
        if (muteImageView == null || muteImageView.isShown()) {
            return;
        }
        this.K.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E() {
        if (this.y.getVisibility() != 0) {
            this.y.setVisibility(0);
        }
    }

    protected void F() {
        if (this.y.getVisibility() != 8) {
            this.y.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        ViewGroup viewGroup;
        CloseImageView closeImageView = this.I;
        if (closeImageView != null && !closeImageView.isShown()) {
            this.I.setVisibility(0);
            this.I.setClickAreaScaleFactor(this.N);
        }
        if (this.ae || (viewGroup = this.J) == null || viewGroup.isShown()) {
            return;
        }
        this.J.setVisibility(0);
    }

    protected abstract void H();

    protected abstract void I();

    protected abstract void J();

    @Override // com.anythink.basead.ui.BaseAdView
    protected void a() {
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(int i) {
        b.InterfaceC0039b interfaceC0039b = this.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(e eVar) {
        b.InterfaceC0039b interfaceC0039b = this.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.a(eVar);
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(final BaseShakeView baseShakeView, final BaseShakeView baseShakeView2) {
        if (this.al) {
            return;
        }
        this.al = true;
        if (baseShakeView == null || !m()) {
            return;
        }
        baseShakeView.setVisibility(0);
        baseShakeView.postDelayed(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseScreenAdView.this.u) {
                    return;
                }
                try {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.2f);
                    ofFloat.setDuration(500L);
                    ofFloat.setRepeatCount(1);
                    ofFloat.setRepeatMode(2);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (baseShakeView.getVisibility() == 0) {
                                baseShakeView.setAlpha(floatValue);
                            }
                            if (baseShakeView2 == null || baseShakeView2.getVisibility() != 0) {
                                return;
                            }
                            baseShakeView2.setAlpha(floatValue);
                        }
                    });
                    ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.BaseScreenAdView.4.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationRepeat(Animator animator) {
                            super.onAnimationRepeat(animator);
                            baseShakeView.setVisibility(8);
                            if (baseShakeView2 == null || BaseScreenAdView.this.u) {
                                return;
                            }
                            baseShakeView2.setAlpha(0.2f);
                            baseShakeView2.setVisibility(0);
                        }
                    });
                    ofFloat.start();
                } catch (Throwable th) {
                    baseShakeView.setVisibility(8);
                    if (baseShakeView2 == null || BaseScreenAdView.this.u) {
                        return;
                    }
                    baseShakeView2.setVisibility(0);
                }
            }
        }, 3000L);
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(boolean z) {
        b.InterfaceC0039b interfaceC0039b = this.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.w = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_rl_root", "id"));
        this.x = (PlayerView) findViewById(h.a(getContext(), "myoffer_player_view_id", "id"));
        this.y = (PanelView) findViewById(h.a(getContext(), "myoffer_banner_view_id", "id"));
        this.H = (CountDownView) findViewById(h.a(getContext(), "myoffer_count_down_view_id", "id"));
        this.K = (MuteImageView) findViewById(h.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.I = (CloseImageView) findViewById(h.a(getContext(), "myoffer_btn_close_id", "id"));
        this.J = (ViewGroup) findViewById(h.a(getContext(), "myoffer_feedback_ll_id", "id"));
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setVisibility(4);
        }
        z();
        CloseImageView closeImageView = this.I;
        if (closeImageView != null) {
            this.N = a(closeImageView, this.c.m.h());
            this.I.setVisibility(8);
            this.I.setOnClickListener(new AnonymousClass7());
        }
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.J.setOnClickListener(new AnonymousClass8());
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public void b(int i) {
        this.an = true;
        this.N = a(this.I, this.c.m.g());
        if (this.af || this.d == null) {
            return;
        }
        super.b(i);
    }

    protected void c() {
        this.x.setListener(new PlayerView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.9
            @Override // com.anythink.basead.ui.PlayerView.a
            public final void a() {
                String str = BaseScreenAdView.TAG;
                BaseScreenAdView.this.D();
                BaseScreenAdView.this.aj = System.currentTimeMillis();
                BaseScreenAdView.this.h();
                BaseScreenAdView.b(BaseScreenAdView.this);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void a(int i) {
                BaseScreenAdView.this.D();
                BaseScreenAdView.a(BaseScreenAdView.this, i);
                BaseScreenAdView.b(BaseScreenAdView.this, i);
                if (BaseScreenAdView.this.H != null && BaseScreenAdView.this.H.isShown()) {
                    BaseScreenAdView.this.H.refresh(i);
                }
                if (BaseScreenAdView.this.L >= 0 && i >= BaseScreenAdView.this.L) {
                    BaseScreenAdView.this.G();
                }
                if (i < BaseScreenAdView.this.c.m.e() || BaseScreenAdView.this.v) {
                    return;
                }
                BaseScreenAdView.this.G();
                BaseScreenAdView.this.v = true;
                if (BaseScreenAdView.this.E != null) {
                    BaseScreenAdView.this.E.d();
                }
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void a(e eVar) {
                BaseScreenAdView.this.p();
                i i = BaseScreenAdView.this.i();
                i.h = BaseScreenAdView.this.fillVideoEndRecord(false);
                com.anythink.basead.a.b.a(17, BaseScreenAdView.this.d, i);
                BaseScreenAdView.this.a(eVar);
                if (!BaseScreenAdView.this.v && BaseScreenAdView.this.c.m.f() == 1 && f.C.equals(eVar.b())) {
                    BaseScreenAdView.this.v = true;
                    if (BaseScreenAdView.this.E != null) {
                        BaseScreenAdView.this.E.d();
                    }
                }
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void b() {
                String str = BaseScreenAdView.TAG;
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void b(int i) {
                i i2 = BaseScreenAdView.this.i();
                if (i == 25) {
                    String str = BaseScreenAdView.TAG;
                    com.anythink.basead.a.b.a(2, BaseScreenAdView.this.d, i2);
                } else if (i == 50) {
                    String str2 = BaseScreenAdView.TAG;
                    com.anythink.basead.a.b.a(3, BaseScreenAdView.this.d, i2);
                } else if (i != 75) {
                } else {
                    String str3 = BaseScreenAdView.TAG;
                    com.anythink.basead.a.b.a(4, BaseScreenAdView.this.d, i2);
                }
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void c() {
                String str = BaseScreenAdView.TAG;
                i i = BaseScreenAdView.this.i();
                com.anythink.basead.a.b.a(5, BaseScreenAdView.this.d, i);
                com.anythink.basead.a.b.a(31, BaseScreenAdView.this.d, i);
                if (BaseScreenAdView.this.E != null) {
                    BaseScreenAdView.this.E.c();
                }
                if (!BaseScreenAdView.this.v) {
                    BaseScreenAdView.this.v = true;
                    if (BaseScreenAdView.this.E != null) {
                        BaseScreenAdView.this.E.d();
                    }
                }
                if (BaseScreenAdView.this.c.m.J() == 1) {
                    BaseScreenAdView.this.p();
                    BaseScreenAdView.this.l();
                    return;
                }
                BaseScreenAdView.this.l();
                if (BaseScreenAdView.this.I != null) {
                    BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                    baseScreenAdView.a(baseScreenAdView.I);
                }
                BaseScreenAdView.this.C();
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void c(int i) {
                BaseScreenAdView.this.d(i);
                com.anythink.basead.a.b.a(35, BaseScreenAdView.this.d, BaseScreenAdView.this.i());
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void d() {
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                BaseScreenAdView.c(baseScreenAdView, baseScreenAdView.x.getCurrentPosition());
                i i = BaseScreenAdView.this.i();
                i.g = BaseScreenAdView.this.j();
                com.anythink.basead.a.b.a(14, BaseScreenAdView.this.d, i);
                if (BaseScreenAdView.this.c.m == null || BaseScreenAdView.this.c.m.u() != 1) {
                    return;
                }
                BaseScreenAdView.this.b(1);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void e() {
                String str = BaseScreenAdView.TAG;
                i i = BaseScreenAdView.this.i();
                i.g = BaseScreenAdView.this.j();
                com.anythink.basead.a.b.a(12, BaseScreenAdView.this.d, i);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void f() {
                String str = BaseScreenAdView.TAG;
                i i = BaseScreenAdView.this.i();
                i.g = BaseScreenAdView.this.j();
                com.anythink.basead.a.b.a(13, BaseScreenAdView.this.d, i);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void g() {
                new com.anythink.basead.a.b.f(BaseScreenAdView.this.c.b, BaseScreenAdView.this.d, BaseScreenAdView.this.c.m).b();
            }
        });
        this.x.initMuteStatus(this.M);
        this.x.setVideoSize(this.O, this.P);
        this.x.setVideoRateConfig(this.d.k().S(), this.d.k().T());
        this.x.load(this.d.x(), false);
    }

    protected abstract boolean c(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public void d() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = displayMetrics.widthPixels;
        this.D = displayMetrics.heightPixels;
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i) {
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setDuration(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        this.E = null;
        BaseEndCardView baseEndCardView = this.z;
        if (baseEndCardView != null) {
            baseEndCardView.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void e() {
        com.anythink.basead.a.b.a(8, this.d, i());
        b.InterfaceC0039b interfaceC0039b = this.E;
        if (interfaceC0039b != null) {
            interfaceC0039b.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void f() {
        this.af = true;
        if (this.A == null) {
            this.A = new b(this.w);
        }
        this.A.b();
    }

    public j fillVideoEndRecord(boolean z) {
        j jVar = new j();
        jVar.l = this.t == 2 ? 4 : 1;
        jVar.r = 1;
        PlayerView playerView = this.x;
        jVar.a = playerView != null ? playerView.getVideoLength() / 1000 : 0;
        jVar.b = this.B / 1000;
        PlayerView playerView2 = this.x;
        jVar.c = playerView2 != null ? playerView2.getCurrentPosition() / 1000 : 0;
        jVar.d = this.B == 0 ? 1 : 0;
        jVar.o = this.B == 0 ? 1 : 2;
        PlayerView playerView3 = this.x;
        jVar.e = (playerView3 == null || playerView3.getCurrentPosition() != this.x.getVideoLength()) ? 0 : 1;
        int i = 2;
        if (z) {
            i = 0;
        }
        jVar.u = i;
        jVar.f = this.aj;
        jVar.g = System.currentTimeMillis();
        PlayerView playerView4 = this.x;
        int i2 = 0;
        if (playerView4 != null) {
            i2 = playerView4.getCurrentPosition();
        }
        jVar.h = i2;
        new StringBuilder("Video End Record:").append(jVar.toString());
        return jVar;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void g() {
        this.af = false;
        post(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.3
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenAdView.e(BaseScreenAdView.this);
            }
        });
    }

    public float getCloseButtonScaleFactor() {
        return this.N;
    }

    public boolean getHasPerformClick() {
        return this.an;
    }

    public long getHideBannerTime() {
        return this.ai;
    }

    public long getShowBannerTime() {
        return this.ag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public final void h() {
        synchronized (this) {
            if (this.c.m.R() > 0) {
                n.a().a(this.V, this.c.m.R());
            } else {
                super.h();
            }
        }
    }

    public boolean hasReward() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public final i i() {
        i iVar = new i(this.c.d, this.q);
        iVar.e = getWidth();
        iVar.f = getHeight();
        PlayerView playerView = this.x;
        if (playerView != null && playerView.hasVideo()) {
            iVar.h = fillVideoEndRecord(true);
        }
        return iVar;
    }

    public void init() {
        b();
        this.F = c(this.Q);
        if (this.u) {
            J();
            p();
            return;
        }
        int i = this.a;
        if (1 == i) {
            if (this.d.E()) {
                J();
                c();
                K();
                return;
            }
            a(f.a(f.k, f.D));
            b.InterfaceC0039b interfaceC0039b = this.E;
            if (interfaceC0039b != null) {
                interfaceC0039b.e();
            }
        } else if (3 == i) {
            if (this.d.C() == 1 && this.d.E()) {
                J();
                c();
                K();
                return;
            }
            J();
            p();
            if (n()) {
                return;
            }
            h();
        }
    }

    public boolean isShowEndCard() {
        return this.u;
    }

    public boolean isVideoMute() {
        return this.M;
    }

    public boolean needHideFeedbackButton() {
        return this.ae;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        BaseShakeView baseShakeView = this.R;
        if (baseShakeView != null) {
            baseShakeView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    BaseScreenAdView.this.b(1);
                }
            });
            this.R.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.11
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    if (BaseScreenAdView.this.x()) {
                        BaseScreenAdView.this.b(4);
                        return true;
                    }
                    return false;
                }
            }, this.c.m);
        }
        BaseShakeView baseShakeView2 = this.S;
        if (baseShakeView2 != null) {
            baseShakeView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    BaseScreenAdView.this.b(1);
                }
            });
            this.S.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.13
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    if (BaseScreenAdView.this.x()) {
                        BaseScreenAdView.this.b(4);
                        return true;
                    }
                    return false;
                }
            }, this.c.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        this.u = true;
        if (n()) {
            M();
        } else {
            N();
        }
        BaseEndCardView baseEndCardView = this.z;
        if (baseEndCardView != null) {
            baseEndCardView.postDelayed(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.14
                @Override // java.lang.Runnable
                public final void run() {
                    BaseScreenAdView.this.G();
                }
            }, a(this.c.m));
        }
        com.anythink.basead.a.b.a(6, this.d, i());
    }

    protected abstract int q();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r() {
        this.am = true;
        try {
            if ((this.ak == null || !this.ak.a()) && this.x != null && this.x.hasVideo()) {
                if (!this.x.isPlaying()) {
                    this.aj = System.currentTimeMillis();
                    int currentPosition = this.x.getCurrentPosition();
                    this.B = currentPosition;
                    if (currentPosition != 0) {
                        com.anythink.basead.a.b.a(15, this.d, i());
                    }
                }
                this.x.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        this.am = false;
        PlayerView playerView = this.x;
        if (playerView != null) {
            if (playerView.isPlaying()) {
                com.anythink.basead.a.b.a(11, this.d, i());
            }
            this.x.pause();
        }
    }

    public void setCloseButtonScaleFactor(float f) {
        this.N = f;
        CloseImageView closeImageView = this.I;
        if (closeImageView != null) {
            closeImageView.setClickAreaScaleFactor(f);
        }
    }

    public void setHasPerformClick(boolean z) {
        this.an = z;
    }

    public void setHasReward(boolean z) {
        this.v = z;
    }

    public void setHideBannerTime(long j) {
        this.ai = j;
    }

    public void setHideFeedbackButton(boolean z) {
        this.ae = z;
    }

    public void setIsShowEndCard(boolean z) {
        this.u = z;
    }

    public void setListener(b.InterfaceC0039b interfaceC0039b) {
        this.E = interfaceC0039b;
    }

    public void setShowBannerTime(long j) {
        this.ag = j;
    }

    public void setVideoMute(boolean z) {
        this.M = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        destroy();
        n.a().c(this.V);
    }

    protected void u() {
        String u = this.d.u();
        if (!TextUtils.isEmpty(u)) {
            com.anythink.basead.a.f.a();
            int[] a = com.anythink.core.common.k.b.a(com.anythink.basead.a.f.a(1, u));
            if (a != null) {
                this.ac = a[0];
                this.ad = a[1];
            }
        }
        String x = this.d.x();
        if (!TextUtils.isEmpty(x)) {
            com.anythink.basead.a.f.a();
            g.a a2 = g.a(com.anythink.basead.a.f.a(4, x));
            if (a2 != null) {
                this.aa = a2.a;
                this.ab = a2.b;
            }
        } else if (!TextUtils.isEmpty(u)) {
            this.aa = this.ac;
            this.ab = this.ad;
        }
        StringBuilder sb = new StringBuilder("mMaterialWidth: ");
        sb.append(this.aa);
        sb.append(", mMaterialHeight: ");
        sb.append(this.ab);
    }

    protected void v() {
        PanelView panelView = this.y;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.y.init(this.d, this.c, this.t, m(), new PanelView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.5
                @Override // com.anythink.basead.ui.PanelView.a
                public final void a() {
                    BaseScreenAdView.this.b(1);
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final boolean b() {
                    if (BaseScreenAdView.this.x()) {
                        BaseScreenAdView.this.b(4);
                        return true;
                    }
                    return false;
                }
            });
        }
        w();
    }

    protected abstract void w();

    protected final boolean x() {
        c cVar = this.ak;
        return (cVar == null || !cVar.a()) && this.am;
    }

    protected void y() {
    }

    protected void z() {
        MuteImageView muteImageView = this.K;
        if (muteImageView == null) {
            return;
        }
        if (this.M) {
            muteImageView.setMute(true);
        } else {
            muteImageView.setMute(false);
        }
        this.K.setVisibility(4);
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (BaseScreenAdView.this.x == null || BaseScreenAdView.this.K == null) {
                    return;
                }
                if (!BaseScreenAdView.this.x.isMute()) {
                    BaseScreenAdView.this.M = true;
                    BaseScreenAdView.this.K.setMute(true);
                    BaseScreenAdView.this.x.setMute(true);
                    return;
                }
                BaseScreenAdView.this.M = false;
                BaseScreenAdView.this.K.setMute(false);
                BaseScreenAdView.this.x.setMute(false);
            }
        });
    }
}
