package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.a.e;
import com.anythink.basead.c.f;
import com.anythink.basead.ui.PanelView;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.m;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.i.c;
import com.anythink.core.common.k.h;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ThirdPartyFullScreenAdView.class */
public class ThirdPartyFullScreenAdView extends BaseScreenAdView {
    public static final String TAG = ThirdPartyFullScreenAdView.class.getSimpleName();
    View ae;
    Timer af;
    private BaseAd ag;
    private final com.anythink.core.common.i.a ah;
    private final com.anythink.core.common.i.b ai;

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenAdView$5 */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ThirdPartyFullScreenAdView$5.class */
    public final class AnonymousClass5 extends TimerTask {
        AnonymousClass5() {
            ThirdPartyFullScreenAdView.this = r4;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ThirdPartyFullScreenAdView thirdPartyFullScreenAdView = ThirdPartyFullScreenAdView.this;
            ThirdPartyFullScreenAdView.a(thirdPartyFullScreenAdView, (int) thirdPartyFullScreenAdView.ag.getVideoProgress());
        }
    }

    public ThirdPartyFullScreenAdView(Context context) {
        super(context);
        this.ah = c.a();
        this.ai = new com.anythink.core.common.i.b() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.1
            {
                ThirdPartyFullScreenAdView.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyFullScreenAdView.this.G();
            }
        };
    }

    public ThirdPartyFullScreenAdView(Context context, j jVar, i iVar, String str, int i, int i2, BaseAd baseAd) {
        super(context, jVar, iVar, str, i, i2);
        this.ah = c.a();
        this.ai = new com.anythink.core.common.i.b() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.1
            {
                ThirdPartyFullScreenAdView.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyFullScreenAdView.this.G();
            }
        };
        this.ag = baseAd;
        this.ae = baseAd.getAdMediaView(new Object[0]);
        setId(h.a(getContext(), "myoffer_thirdparty_full_screen_view_id", "id"));
        this.G = 0;
    }

    private void K() {
        if (this.L < 0) {
            return;
        }
        if (this.L > 0) {
            this.ah.a(this.ai, this.L, true);
        } else {
            G();
        }
    }

    private void L() {
        ArrayList arrayList = new ArrayList();
        int x = this.c.m.x();
        if (x == 0) {
            arrayList.addAll(this.y.getClickViews());
            arrayList.add(this.y);
            if (this.z != null) {
                arrayList.add(this.z);
            }
        } else if (x != 1) {
            if (x == 2) {
                arrayList.addAll(this.y.getClickViews());
                arrayList.add(this.y);
            }
        } else if (this.y.getCTAButton() != null) {
            arrayList.add(this.y.getCTAButton());
        }
        this.ag.registerListener(this, arrayList, null);
    }

    private void M() {
        if (this.af == null) {
            Timer timer = new Timer();
            this.af = timer;
            timer.schedule(new AnonymousClass5(), 0L, 300L);
        }
    }

    private void N() {
        Timer timer = this.af;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void O() {
        Timer timer = this.af;
        if (timer != null) {
            timer.cancel();
            this.af = null;
        }
        this.ah.a(this.ai);
    }

    static /* synthetic */ void a(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView) {
        if (thirdPartyFullScreenAdView.af == null) {
            Timer timer = new Timer();
            thirdPartyFullScreenAdView.af = timer;
            timer.schedule(new AnonymousClass5(), 0L, 300L);
        }
    }

    static /* synthetic */ void a(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView, int i) {
        thirdPartyFullScreenAdView.post(new $$Lambda$ThirdPartyFullScreenAdView$Z9BoyxfxmqC3acOchTpBa3KEJA(thirdPartyFullScreenAdView, i));
    }

    static /* synthetic */ void b(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView) {
        Timer timer = thirdPartyFullScreenAdView.af;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void e(int i) {
        post(new $$Lambda$ThirdPartyFullScreenAdView$Z9BoyxfxmqC3acOchTpBa3KEJA(this, i));
    }

    public /* synthetic */ void f(int i) {
        int i2 = i * 1000;
        if (this.H != null && this.H.isShown()) {
            this.H.refresh(i2);
        }
        if (this.L < 0 || i2 < this.L) {
            return;
        }
        G();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void A() {
        super.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenAdView
    public final void G() {
        super.G();
        this.ah.a(this.ai);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void H() {
        View shakeView;
        if (this.w == null || this.z == null) {
            return;
        }
        this.z.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (c(this.Q)) {
            int i = this.Q;
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        int i2 = (int) (this.D * 0.5f);
                        this.z.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.D - i2));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = this.C;
                            layoutParams.height = i2;
                            this.y.setLayoutParams(layoutParams);
                            this.y.removeAllViews();
                            this.y.setLayoutType(this.Q);
                        }
                    } else if (i != 6) {
                        if (i == 8 && (shakeView = this.y.getShakeView()) != null) {
                            shakeView.setVisibility(8);
                        }
                    }
                }
                int a = h.a(getContext(), 300.0f);
                this.z.setLayoutParams(new RelativeLayout.LayoutParams(this.C - a, -1));
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a;
                    layoutParams2.height = -1;
                    this.y.setLayoutParams(layoutParams2);
                    this.y.removeAllViews();
                    this.y.setLayoutType(this.Q);
                }
            } else {
                this.w.setBackgroundColor(-1);
                int i3 = (int) (this.D * 0.5f);
                int a2 = TextUtils.isEmpty(this.d.t()) ? this.D - i3 : (this.D - i3) + h.a(getContext(), 50.0f);
                this.z.setLayoutParams(new RelativeLayout.LayoutParams(-1, i3));
                this.z.setNeedArc(true);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.C;
                    layoutParams3.height = a2;
                    this.y.setLayoutParams(layoutParams3);
                    this.y.removeAllViews();
                    this.y.setLayoutType(this.Q);
                }
            }
        }
        this.w.addView(this.z, 1);
        L();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void I() {
        View view = this.ae;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.ae.getParent()).removeView(this.ae);
        }
        if (this.H != null) {
            this.H.setVisibility(8);
        }
        if (this.K != null) {
            this.K.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void J() {
        this.O = this.C;
        this.P = this.D;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_thirdparty_full_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void c() {
        if (this.ae != null) {
            this.w.addView(this.ae, 0, new RelativeLayout.LayoutParams(-1, -1));
            d(((int) this.ag.getVideoDuration()) * 1000);
            D();
            L();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final boolean c(int i) {
        return (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) ? e.a(this.d) : i == 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        Timer timer = this.af;
        if (timer != null) {
            timer.cancel();
            this.af = null;
        }
        this.ah.a(this.ai);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    public void init() {
        b();
        this.F = c(this.Q);
        this.ag.setNativeEventListener(new m() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.2
            {
                ThirdPartyFullScreenAdView.this = this;
            }

            @Override // com.anythink.core.common.b.m
            public final void a(String str, String str2) {
                ThirdPartyFullScreenAdView.this.p();
                ThirdPartyFullScreenAdView.this.a(f.a(str, str2));
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdClicked(View view) {
                if (ThirdPartyFullScreenAdView.this.E != null) {
                    ThirdPartyFullScreenAdView.this.E.a(1);
                }
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdDislikeButtonClick() {
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdImpressed() {
                if (ThirdPartyFullScreenAdView.this.E != null) {
                    ThirdPartyFullScreenAdView.this.E.a();
                }
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoEnd() {
                ThirdPartyFullScreenAdView.b(ThirdPartyFullScreenAdView.this);
                ThirdPartyFullScreenAdView.this.G();
                if (ThirdPartyFullScreenAdView.this.E != null) {
                    ThirdPartyFullScreenAdView.this.E.c();
                }
                ThirdPartyFullScreenAdView.this.p();
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoProgress(int i) {
                ThirdPartyFullScreenAdView.b(ThirdPartyFullScreenAdView.this);
                ThirdPartyFullScreenAdView.a(ThirdPartyFullScreenAdView.this, i);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoStart() {
                ThirdPartyFullScreenAdView.a(ThirdPartyFullScreenAdView.this);
                if (ThirdPartyFullScreenAdView.this.E != null) {
                    ThirdPartyFullScreenAdView.this.E.b();
                }
            }

            @Override // com.anythink.core.common.b.l
            public final void onDeeplinkCallback(boolean z) {
            }

            @Override // com.anythink.core.common.b.l
            public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }
        });
        if (!this.u) {
            if (1 == this.a || 3 != this.a) {
                return;
            }
            if (TextUtils.equals(this.ag.getAdType(), "1") && this.ae != null) {
                J();
                c();
                if (this.L >= 0) {
                    if (this.L > 0) {
                        this.ah.a(this.ai, this.L, true);
                        return;
                    } else {
                        G();
                        return;
                    }
                }
                return;
            }
        }
        J();
        p();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final int q() {
        return this.Q == 8 ? this.Q : this.C < this.D ? this.ac >= this.ad ? 1 : 5 : this.ac < this.ad ? 2 : 6;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void u() {
        String u = this.d.u();
        if (TextUtils.isEmpty(u)) {
            return;
        }
        com.anythink.basead.a.f.a();
        int[] a = com.anythink.core.common.k.b.a(com.anythink.basead.a.f.a(2, u));
        if (a != null) {
            this.ac = a[0];
            this.ad = a[1];
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void v() {
        if (this.y != null) {
            this.y.setVisibility(4);
            this.y.init(this.d, this.c, this.t, false, new PanelView.a() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.3
                {
                    ThirdPartyFullScreenAdView.this = this;
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final void a() {
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final boolean b() {
                    return false;
                }
            });
        }
        w();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void w() {
        if (this.y != null) {
            if (e.a(this.d)) {
                this.Q = 0;
            } else {
                this.Q = 8;
            }
            this.y.setLayoutType(this.Q);
            if (this.Q == 8 && this.c.m.x() == 0) {
                this.y.getCTAButton().setVisibility(8);
            }
            this.y.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void z() {
        if (this.K == null) {
            return;
        }
        if (this.M) {
            this.K.setMute(true);
        } else {
            this.K.setMute(false);
        }
        this.K.setVisibility(4);
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.4
            {
                ThirdPartyFullScreenAdView.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (ThirdPartyFullScreenAdView.this.ae == null || ThirdPartyFullScreenAdView.this.K == null || ThirdPartyFullScreenAdView.this.ag == null) {
                    return;
                }
                ThirdPartyFullScreenAdView thirdPartyFullScreenAdView = ThirdPartyFullScreenAdView.this;
                thirdPartyFullScreenAdView.M = !thirdPartyFullScreenAdView.M;
                ThirdPartyFullScreenAdView.this.K.setMute(ThirdPartyFullScreenAdView.this.M);
                ThirdPartyFullScreenAdView.this.ag.setVideoMute(ThirdPartyFullScreenAdView.this.M);
            }
        });
    }
}
