package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.anythink.basead.c.e;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.basead.ui.BaseSplashAdView;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.u;
import com.bytedance.applog.tracker.Tracker;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseSplashAdView.class */
public abstract class BaseSplashAdView extends BaseAdView {
    protected TextView A;
    protected CloseFrameLayout B;
    protected String C;
    protected Timer D;
    protected boolean E;
    protected com.anythink.basead.e.a F;
    protected b G;
    final long H;
    protected BaseShakeView I;
    GuideToClickView J;
    protected final View.OnClickListener K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    private f.b a;
    private long t;

    /* renamed from: com.anythink.basead.ui.BaseSplashAdView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseSplashAdView$2.class */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (BaseSplashAdView.this.c.m.p() == 0 || BaseSplashAdView.this.N) {
                BaseSplashAdView.this.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.BaseSplashAdView$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseSplashAdView$3.class */
    public final class AnonymousClass3 extends TimerTask {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (BaseSplashAdView.this.t <= 0) {
                BaseSplashAdView.e(BaseSplashAdView.this);
            } else {
                BaseSplashAdView baseSplashAdView = BaseSplashAdView.this;
                baseSplashAdView.a(baseSplashAdView.t);
            }
            BaseSplashAdView.this.t -= 1000;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            BaseSplashAdView baseSplashAdView = BaseSplashAdView.this;
            if (u.a(baseSplashAdView, baseSplashAdView.a)) {
                BaseSplashAdView.this.post(new Runnable() { // from class: com.anythink.basead.ui.-$$Lambda$BaseSplashAdView$3$g5QDjz7a3LvOuZp9rawwPnrQZow
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseSplashAdView.AnonymousClass3.this.a();
                    }
                });
            }
        }
    }

    public BaseSplashAdView(Context context) {
        super(context);
        this.C = "Skip";
        this.H = 1000L;
        this.t = 5000L;
        this.K = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                BaseSplashAdView.super.b(1);
            }
        };
        this.L = false;
        this.M = false;
        this.N = false;
    }

    public BaseSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar);
        this.C = "Skip";
        this.H = 1000L;
        this.t = 5000L;
        this.K = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                BaseSplashAdView.super.b(1);
            }
        };
        this.L = false;
        this.M = false;
        this.N = false;
        this.a = new f.b();
        this.F = aVar;
        this.C = getResources().getString(h.a(getContext(), "myoffer_splash_skip_text", "string"));
        this.A = (TextView) findViewById(h.a(getContext(), "myoffer_splash_skip", "id"));
        this.B = (CloseFrameLayout) findViewById(h.a(getContext(), "myoffer_splash_skip_area", "id"));
        this.t = this.c.m.n();
        a(this.B, this.c.m.h());
        this.E = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.c.m.p() != 0) {
            TextView textView = this.A;
            textView.setText((j / 1000) + " s");
            return;
        }
        TextView textView2 = this.A;
        textView2.setText((j / 1000) + "s | " + this.C);
    }

    private void b() {
        if (this.M) {
            return;
        }
        this.M = true;
        if (this.O) {
            return;
        }
        this.B.setVisibility(0);
        this.B.setOnClickListener(new AnonymousClass2());
        this.N = false;
        Timer timer = new Timer();
        this.D = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.t);
        this.t -= 1000;
    }

    private void c() {
        this.B.setVisibility(0);
        this.B.setOnClickListener(new AnonymousClass2());
        this.N = false;
        Timer timer = new Timer();
        this.D = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.t);
        this.t -= 1000;
    }

    static /* synthetic */ void e(BaseSplashAdView baseSplashAdView) {
        baseSplashAdView.s();
        baseSplashAdView.A.setText(baseSplashAdView.C);
        baseSplashAdView.N = true;
    }

    private void o() {
        s();
        this.A.setText(this.C);
        this.N = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
        }
        this.D = null;
        if (this.E) {
            return;
        }
        this.E = true;
        if (!this.L) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, "SplashView not showing on screen."));
        }
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected void a(int i) {
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdClick(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(e eVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onShowFailed(eVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(boolean z) {
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        this.F = null;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void e() {
        this.L = true;
        com.anythink.basead.a.b.a(8, this.d, i());
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdShow();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void f() {
        if (this.d instanceof aa) {
            if (this.G == null) {
                this.G = new b(this);
            }
            post(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashAdView.4
                @Override // java.lang.Runnable
                public final void run() {
                    BaseSplashAdView.this.G.b();
                }
            });
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void g() {
        if (!(this.d instanceof aa) || this.G == null) {
            return;
        }
        post(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashAdView.5
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashAdView.this.G.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.M) {
            return;
        }
        this.M = true;
        if (this.O) {
            return;
        }
        this.B.setVisibility(0);
        this.B.setOnClickListener(new AnonymousClass2());
        this.N = false;
        Timer timer = new Timer();
        this.D = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.t);
        this.t -= 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        int size = this.r.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View view = this.r.get(i2);
            if (view != null) {
                view.setOnClickListener(this.K);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        if (m()) {
            BaseShakeView baseShakeView = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_view", "id"));
            this.I = baseShakeView;
            baseShakeView.setVisibility(0);
            this.I.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.BaseSplashAdView.6
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    if (BaseSplashAdView.this.E) {
                        return false;
                    }
                    BaseSplashAdView.this.b(4);
                    return true;
                }
            }, this.c.m);
            this.r.add(this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r() {
        GuideToClickView guideToClickView;
        this.J = (GuideToClickView) findViewById(h.a(getContext(), "myoffer_guide_to_click_view", "id"));
        if (this.c.m.i() != 1 || (guideToClickView = this.J) == null) {
            return;
        }
        guideToClickView.setVisibility(0);
        this.r.add(this.J);
    }

    public void setDontCountDown(boolean z) {
        CloseFrameLayout closeFrameLayout;
        this.O = z;
        if (!z || (closeFrameLayout = this.B) == null) {
            return;
        }
        closeFrameLayout.setVisibility(8);
    }
}
