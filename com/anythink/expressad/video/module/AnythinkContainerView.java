package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView;
import com.anythink.expressad.video.module.a.a;
import com.anythink.expressad.video.module.a.a.g;
import com.anythink.expressad.video.module.a.a.i;
import com.anythink.expressad.video.module.a.a.k;
import com.anythink.expressad.video.module.a.a.l;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.video.signal.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkContainerView.class */
public class AnythinkContainerView extends AnythinkBaseView implements e, h {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private b Q;
    private AnyThinkOrderCampView R;
    private boolean S;
    private boolean T;
    private List<c> U;
    private AnythinkPlayableView n;
    private AnythinkClickCTAView o;
    private AnythinkClickMiniCardView p;
    private AnythinkNativeEndCardView q;
    private AnythinkH5EndCardView r;
    private AnythinkVideoEndCoverView s;
    private AnythinkVastEndCardView t;
    private AnythinkLandingPageView u;
    private AnythinkAlertWebview v;
    private String w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkContainerView$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkContainerView$4.class */
    public final class AnonymousClass4 extends i {
        AnonymousClass4(a aVar) {
            super(aVar);
        }

        @Override // com.anythink.expressad.video.module.a.a.i, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i, Object obj) {
            super.a(i, obj);
            if (i == 100) {
                AnythinkContainerView.this.webviewshow();
                AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                anythinkContainerView.onConfigurationChanged(anythinkContainerView.getResources().getConfiguration());
            }
        }
    }

    public AnythinkContainerView(Context context) {
        super(context);
        this.y = 1;
        this.z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.I = false;
        this.J = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    public AnythinkContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.I = false;
        this.J = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    private void a(Configuration configuration, AnythinkBaseView... anythinkBaseViewArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return;
            }
            AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i2];
            if (anythinkBaseView != null && (anythinkBaseView instanceof AnythinkClickMiniCardView)) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            } else if (anythinkBaseView != null && anythinkBaseView.getVisibility() == 0 && anythinkBaseView.getParent() != null && !isLast()) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            }
            i = i2 + 1;
        }
    }

    private static void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private void a(a aVar, AnythinkBaseView... anythinkBaseViewArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return;
            }
            AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i2];
            if (anythinkBaseView != null) {
                if (anythinkBaseView instanceof AnythinkClickMiniCardView) {
                    anythinkBaseView.setNotifyListener(new g(this.p, aVar));
                } else {
                    anythinkBaseView.setNotifyListener(new i(aVar));
                }
            }
            i = i2 + 1;
        }
    }

    private void a(b bVar) {
        if (this.n == null) {
            this.n = new AnythinkPlayableView(this.f8440a);
        }
        this.n.setCloseDelayShowTime(this.z);
        this.n.setPlayCloseBtnTm(this.A);
        this.n.setCampaign(this.b);
        this.n.setNotifyListener(new AnonymousClass4(this.e));
        this.n.preLoadData(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        this.Q = bVar;
        if (this.b != null) {
            Integer num2 = num;
            if (num == null) {
                num2 = Integer.valueOf(this.b.F());
            }
            if (!isLast()) {
                p();
            }
            int intValue = num2.intValue();
            if (intValue != 1) {
                if (intValue == 3) {
                    if (this.t == null) {
                        this.t = new AnythinkVastEndCardView(this.f8440a);
                    }
                    this.t.setCampaign(this.b);
                    this.t.setNotifyListener(new l(this.e));
                    this.t.preLoadData(bVar);
                } else if (intValue == 4) {
                    if (this.u == null) {
                        this.u = new AnythinkLandingPageView(this.f8440a);
                    }
                    this.u.setCampaign(this.b);
                    this.u.setNotifyListener(new i(this.e));
                } else if (intValue != 5) {
                    if (this.y != 2) {
                        int c2 = (this.b == null || this.b.M() == null) ? 0 : this.b.M().c();
                        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
                        if (anythinkNativeEndCardView == null && anythinkNativeEndCardView == null) {
                            if (this.b.j()) {
                                q();
                            } else {
                                AnythinkNativeEndCardView anythinkNativeEndCardView2 = new AnythinkNativeEndCardView(this.f8440a, null, false, -1, this.b.f() == 2, c2, this.b.as());
                                this.q = anythinkNativeEndCardView2;
                                anythinkNativeEndCardView2.setCampaign(this.b);
                            }
                        }
                        this.q.setLayout();
                        this.q.setCampaign(this.b);
                        this.q.setUnitId(this.w);
                        this.q.setCloseBtnDelay(this.z);
                        this.q.setNotifyListener(new i(this.e));
                        this.q.preLoadData(bVar);
                        this.q.setNotchPadding(this.K, this.L, this.M, this.N);
                        return;
                    }
                    boolean j = this.b.j();
                    boolean f = t.f(this.b.I());
                    if ((this.b == null || !j || f) && this.b.f() != 2) {
                        if (this.r == null) {
                            this.r = new AnythinkH5EndCardView(this.f8440a);
                        }
                        if (this.b.k() == 5 && this.e != null && (this.e instanceof k)) {
                            ((k) this.e).a(this.b);
                        }
                        this.r.setCampaign(this.b);
                        this.r.setCloseDelayShowTime(this.z);
                        this.r.setNotifyListener(new i(this.e));
                        this.r.setUnitId(this.w);
                        this.r.setNotchValue(this.P, this.K, this.L, this.M, this.N);
                        this.r.preLoadData(bVar);
                        o.a(AnythinkBaseView.TAG, "preload H5Endcard");
                        if (this.D) {
                            return;
                        }
                        o.a(AnythinkBaseView.TAG, "showTransparent = " + this.D + " addview");
                        addView(this.r);
                    }
                }
            }
        }
    }

    private void a(AnythinkH5EndCardView... anythinkH5EndCardViewArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return;
            }
            AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i2];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0 && anythinkH5EndCardView.getParent() != null && !isLast()) {
                anythinkH5EndCardView.webviewshow();
            }
            i = i2 + 1;
        }
    }

    private boolean a() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1;
    }

    private void b() {
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    private void b(int i) {
        if (i != -3) {
            if (i != -2) {
                if (this.o == null) {
                    this.o = new AnythinkClickCTAView(this.f8440a);
                }
                this.o.setCampaign(this.b);
                this.o.setUnitId(this.w);
                this.o.setNotifyListener(new i(this.e));
                this.o.preLoadData(this.Q);
            } else if (this.b == null || this.b.F() != 2) {
            } else {
                if (this.p == null) {
                    this.p = new AnythinkClickMiniCardView(this.f8440a);
                }
                this.p.setCampaign(this.b);
                AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
                anythinkClickMiniCardView.setNotifyListener(new g(anythinkClickMiniCardView, this.e));
                this.p.preLoadData(this.Q);
                setMatchParent();
                m();
                p();
            }
        }
    }

    private void b(b bVar) {
        this.Q = bVar;
        if (this.s == null) {
            AnythinkVideoEndCoverView anythinkVideoEndCoverView = new AnythinkVideoEndCoverView(this.f8440a);
            this.s = anythinkVideoEndCoverView;
            anythinkVideoEndCoverView.setCampaign(this.b);
            this.s.setNotifyListener(new i(this.e));
            this.s.preLoadData(bVar);
        }
    }

    private void b(AnythinkH5EndCardView... anythinkH5EndCardViewArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return;
            }
            AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i2];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0) {
                anythinkH5EndCardView.orientation(getResources().getConfiguration());
            }
            i = i2 + 1;
        }
    }

    private void e() {
        if (this.b != null) {
            boolean j = this.b.j();
            boolean f = t.f(this.b.I());
            if (j && !f) {
                i();
                return;
            }
        }
        if (this.y != 2 || this.I) {
            i();
        } else {
            h();
        }
    }

    private void f() {
        if (this.t == null) {
            a(this.Q, (Integer) 3);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        addView(this.t, layoutParams);
        this.t.notifyShowListener();
    }

    private void g() {
        if (this.u == null) {
            a(this.Q, (Integer) 4);
        }
        this.u.setUnitId(this.w);
        this.u.preLoadData(this.Q);
        addView(this.u);
    }

    private void h() {
        if (this.r == null) {
            a(this.Q, (Integer) 2);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView == null || !anythinkH5EndCardView.isLoadSuccess()) {
            i();
            AnythinkH5EndCardView anythinkH5EndCardView2 = this.r;
            if (anythinkH5EndCardView2 != null) {
                anythinkH5EndCardView2.reportRenderResult("timeout", 3);
                this.r.setError(true);
            }
        } else {
            this.I = true;
            addView(this.r);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.r.excuteTask();
            this.r.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        AnythinkH5EndCardView anythinkH5EndCardView3 = this.r;
        if (anythinkH5EndCardView3 != null) {
            anythinkH5EndCardView3.setUnitId(this.w);
        }
    }

    private void i() {
        this.y = 1;
        if (this.q == null) {
            a(this.Q, (Integer) 2);
        }
        addView(this.q);
        onConfigurationChanged(getResources().getConfiguration());
        this.q.notifyShowListener();
        this.T = true;
        bringToFront();
    }

    private void j() {
        AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.s;
        if (anythinkVideoEndCoverView == null) {
            b bVar = this.Q;
            this.Q = bVar;
            if (anythinkVideoEndCoverView == null) {
                AnythinkVideoEndCoverView anythinkVideoEndCoverView2 = new AnythinkVideoEndCoverView(this.f8440a);
                this.s = anythinkVideoEndCoverView2;
                anythinkVideoEndCoverView2.setCampaign(this.b);
                this.s.setNotifyListener(new i(this.e));
                this.s.preLoadData(bVar);
            }
        }
        addView(this.s);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    private void k() {
        if (this.n == null) {
            preLoadData(this.Q);
        }
        addView(this.n);
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.setUnitId(this.w);
            if (this.b != null && this.b.H() && this.b.J() == 2) {
                this.n.setCloseVisible(0);
            }
            this.n.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
    }

    private void l() {
        if (this.o == null) {
            b(-1);
        }
        if (this.o != null) {
            if (this.b == null || !this.b.j()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                addView(this.o, 0, layoutParams);
            }
        }
    }

    private void m() {
        if (this.p == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.D && this.F) {
            this.F = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.p, layoutParams);
    }

    private void n() {
        if (this.v == null) {
            o();
        }
        AnythinkAlertWebview anythinkAlertWebview = this.v;
        if (anythinkAlertWebview != null && anythinkAlertWebview.getParent() != null) {
            removeView(this.v);
        }
        addView(this.v);
    }

    private void o() {
        if (this.v == null) {
            AnythinkAlertWebview anythinkAlertWebview = new AnythinkAlertWebview(this.f8440a);
            this.v = anythinkAlertWebview;
            anythinkAlertWebview.setUnitId(this.w);
            this.v.setCampaign(this.b);
        }
        this.v.preLoadData(this.Q);
    }

    private void p() {
        this.C = false;
        this.T = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof AnythinkContainerView) {
                    i++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void q() {
        /*
            r11 = this;
            r0 = r11
            com.anythink.expressad.foundation.d.c r0 = r0.b
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r11
            com.anythink.expressad.foundation.d.c r0 = r0.b
            java.lang.String r0 = r0.I()
            r14 = r0
            r0 = r14
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2f
            r0 = r14
            java.lang.String r1 = "ecid"
            java.lang.String r0 = com.anythink.expressad.foundation.h.x.a(r0, r1)     // Catch: java.lang.Throwable -> L25
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L25
            r12 = r0
            goto L33
        L25:
            r14 = move-exception
            java.lang.String r0 = "AnythinkBaseView"
            r1 = r14
            java.lang.String r1 = r1.getMessage()
            com.anythink.expressad.foundation.h.o.d(r0, r1)
        L2f:
            r0 = 404(0x194, float:5.66E-43)
            r12 = r0
        L33:
            r0 = r11
            android.content.Context r0 = r0.f8440a
            r14 = r0
            r0 = r11
            com.anythink.expressad.foundation.d.c r0 = r0.b
            int r0 = r0.f()
            r1 = 2
            if (r0 != r1) goto L48
            r0 = 1
            r13 = r0
            goto L4a
        L48:
            r0 = 0
            r13 = r0
        L4a:
            r0 = r11
            com.anythink.expressad.video.module.AnythinkNativeEndCardView r1 = new com.anythink.expressad.video.module.AnythinkNativeEndCardView
            r2 = r1
            r3 = r14
            r4 = 0
            r5 = 1
            r6 = r12
            r7 = r13
            r8 = r11
            int r8 = r8.l
            r9 = r11
            com.anythink.expressad.foundation.d.c r9 = r9.b
            int r9 = r9.as()
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r0.q = r1
            r0 = r11
            com.anythink.expressad.foundation.d.c r0 = r0.b
            int r0 = r0.k()
            r1 = 5
            if (r0 != r1) goto L9b
            r0 = r11
            com.anythink.expressad.video.module.a.a r0 = r0.e
            if (r0 == 0) goto L8f
            r0 = r11
            com.anythink.expressad.video.module.a.a r0 = r0.e
            boolean r0 = r0 instanceof com.anythink.expressad.video.module.a.a.k
            if (r0 == 0) goto L8f
            r0 = r11
            com.anythink.expressad.video.module.a.a r0 = r0.e
            com.anythink.expressad.video.module.a.a.k r0 = (com.anythink.expressad.video.module.a.a.k) r0
            r1 = r11
            com.anythink.expressad.foundation.d.c r1 = r1.b
            r0.a(r1)
        L8f:
            r0 = r11
            com.anythink.expressad.video.module.AnythinkNativeEndCardView r0 = r0.q
            r1 = r11
            com.anythink.expressad.foundation.d.c r1 = r1.b
            r0.setCampaign(r1)
            return
        L9b:
            r0 = r11
            com.anythink.expressad.video.module.AnythinkNativeEndCardView r0 = r0.q
            r1 = r11
            com.anythink.expressad.foundation.d.c r1 = r1.b
            r0.setCampaign(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkContainerView.q():void");
    }

    public void addOrderViewData(List<c> list) {
        if (list == null) {
            return;
        }
        this.U = list;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view == null) {
            o.d(AnythinkBaseView.TAG, "view is null");
            return;
        }
        a(view);
        super.addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            o.d(AnythinkBaseView.TAG, "view is null");
            return;
        }
        a(view);
        super.addView(view, layoutParams);
    }

    public boolean canBackPress() {
        boolean z = false;
        if (this.q != null) {
            return false;
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            return anythinkH5EndCardView.canBackPress();
        }
        AnythinkLandingPageView anythinkLandingPageView = this.u;
        if (anythinkLandingPageView != null) {
            return anythinkLandingPageView.canBackPress();
        }
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            z = anythinkPlayableView.canBackPress();
        }
        return z;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void configurationChanged(int i, int i2, int i3) {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView == null || anythinkClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.p.resizeMiniCard(i, i2);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean endCardShowing() {
        return this.B;
    }

    public boolean endcardIsPlayable() {
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        return anythinkH5EndCardView != null && anythinkH5EndCardView.isPlayable();
    }

    public AnythinkH5EndCardView getH5EndCardView() {
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        AnythinkPlayableView anythinkPlayableView = anythinkH5EndCardView;
        if (anythinkH5EndCardView == null) {
            anythinkPlayableView = this.n;
        }
        return anythinkPlayableView;
    }

    public c getReSetCampaign() {
        int i;
        if (this.b.j() && TextUtils.isEmpty(this.b.I())) {
            int size = this.U.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = 0;
                if (i3 < size) {
                    if (this.U.get(i3) != null && this.U.get(i3).aZ() == this.b.aZ()) {
                        i = i3 - 1;
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    break;
                }
            }
            if (i < 0 || i >= size || this.U.get(i) == null) {
                return null;
            }
            return this.U.get(i);
        }
        return null;
    }

    public boolean getShowingTransparent() {
        return this.D;
    }

    public String getUnitID() {
        return this.w;
    }

    public int getVideoInteractiveType() {
        return this.x;
    }

    public int getVideoSkipTime() {
        return this.H;
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.handlerPlayableException(str);
            if (!this.I) {
                return;
            }
        }
        e();
    }

    @Override // com.anythink.expressad.video.signal.e
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.S && !this.T) {
            p();
            this.S = false;
        }
        AnythinkAlertWebview anythinkAlertWebview = this.v;
        if (anythinkAlertWebview == null || anythinkAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.v);
        AnythinkClickCTAView anythinkClickCTAView = this.o;
        if (anythinkClickCTAView == null || anythinkClickCTAView.getParent() == null) {
            return;
        }
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        setVisibility(0);
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(c cVar) {
        this.e.a(105, cVar);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        boolean z = false;
        if (viewGroup != null) {
            z = false;
            if (viewGroup.indexOfChild(this) == 0) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void ivRewardAdsWithoutVideo(String str) {
        this.e.a(103, str);
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardLoaded() {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        return anythinkClickMiniCardView != null && anythinkClickMiniCardView.isLoadSuccess();
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardShowing() {
        return this.C;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i) {
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.notifyCloseBtn(i);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.notifyCloseBtn(i);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AnythinkPlayableView anythinkPlayableView = this.n;
        AnythinkClickCTAView anythinkClickCTAView = this.o;
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        AnythinkVastEndCardView anythinkVastEndCardView = this.t;
        AnythinkLandingPageView anythinkLandingPageView = this.u;
        AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.s;
        for (int i = 0; i < 8; i++) {
            AnythinkBaseView anythinkBaseView = new AnythinkBaseView[]{anythinkPlayableView, anythinkClickCTAView, anythinkClickMiniCardView, anythinkNativeEndCardView, anythinkH5EndCardView, anythinkVastEndCardView, anythinkLandingPageView, anythinkVideoEndCoverView}[i];
            if (anythinkBaseView != null && (anythinkBaseView instanceof AnythinkClickMiniCardView)) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            } else if (anythinkBaseView != null && anythinkBaseView.getVisibility() == 0 && anythinkBaseView.getParent() != null && !isLast()) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.q != null || this.t != null) {
            this.e.a(104, "");
        } else if (this.u != null) {
            this.e.a(103, "");
        } else {
            AnythinkH5EndCardView anythinkH5EndCardView = this.r;
            if (anythinkH5EndCardView != null) {
                anythinkH5EndCardView.onBackPress();
            }
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.C) {
            this.e.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.onBackPress();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        AnythinkPlayableView anythinkPlayableView = this.n;
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        AnythinkAlertWebview anythinkAlertWebview = this.v;
        for (int i = 0; i < 4; i++) {
            AnythinkH5EndCardView anythinkH5EndCardView2 = new AnythinkH5EndCardView[]{anythinkPlayableView, anythinkClickMiniCardView, anythinkH5EndCardView, anythinkAlertWebview}[i];
            if (anythinkH5EndCardView2 != null && anythinkH5EndCardView2.getVisibility() == 0) {
                anythinkH5EndCardView2.orientation(getResources().getConfiguration());
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(final b bVar) {
        this.Q = bVar;
        if (this.b != null) {
            if (this.b.J() == 2) {
                if (this.n == null) {
                    this.n = new AnythinkPlayableView(this.f8440a);
                }
                this.n.setCloseDelayShowTime(this.z);
                this.n.setPlayCloseBtnTm(this.A);
                this.n.setCampaign(this.b);
                this.n.setNotifyListener(new AnonymousClass4(this.e));
                this.n.preLoadData(bVar);
            } else {
                b(this.x);
                if (this.b.j()) {
                    try {
                        a(bVar, Integer.valueOf(this.b.F()));
                    } catch (Throwable th) {
                        o.d(AnythinkBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkContainerView.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                                anythinkContainerView.a(bVar, Integer.valueOf(anythinkContainerView.b.F()));
                            }
                        });
                    }
                    t.f(this.b.I());
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkContainerView.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                            anythinkContainerView.a(bVar, Integer.valueOf(anythinkContainerView.b.F()));
                        }
                    }, getVideoSkipTime());
                }
            }
            o();
        }
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void readyStatus(int i) {
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.readyStatus(i);
        }
    }

    public void release() {
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.release();
            this.r = null;
        }
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.release();
        }
        AnythinkLandingPageView anythinkLandingPageView = this.u;
        if (anythinkLandingPageView != null) {
            anythinkLandingPageView.release();
        }
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.clearMoreOfferBitmap();
            this.q.release();
        }
        if (this.e != null) {
            this.e = null;
        }
    }

    @Override // com.anythink.expressad.video.signal.e
    public void resizeMiniCard(int i, int i2, int i3) {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.resizeMiniCard(i, i2);
            this.p.setRadius(i3);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            m();
        }
    }

    public void setAnythinkClickMiniCardViewTransparent() {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.setAnythinkClickMiniCardViewTransparent();
            this.p.setAnythinkClickMiniCardViewClickable(false);
        }
    }

    public void setCloseDelayTime(int i) {
        this.z = i;
    }

    public void setEndscreenType(int i) {
        this.y = i;
    }

    public void setJSFactory(b bVar) {
        this.Q = bVar;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        o.d(AnythinkBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i)));
        this.O = i;
        this.K = i2;
        this.L = i3;
        this.M = i4;
        this.N = i5;
        this.P = com.anythink.expressad.foundation.h.h.a(i, i2, i3, i4, i5);
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setNotchPadding(i2, i3, i4, i5);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null && anythinkH5EndCardView.s != null) {
            this.r.setNotchValue(this.P, i2, i3, i4, i5);
            j.a();
            j.a((WebView) this.r.s, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null && anythinkPlayableView.s != null) {
            this.n.setNotchValue(this.P, i2, i3, i4, i5);
            j.a();
            j.a((WebView) this.n.s, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        AnyThinkOrderCampView anyThinkOrderCampView = this.R;
        if (anyThinkOrderCampView != null) {
            anyThinkOrderCampView.setNotchPadding(i2, i3, i4, i5);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void setNotifyListener(a aVar) {
        super.setNotifyListener(aVar);
        AnythinkPlayableView anythinkPlayableView = this.n;
        AnythinkClickCTAView anythinkClickCTAView = this.o;
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        AnythinkVastEndCardView anythinkVastEndCardView = this.t;
        AnythinkLandingPageView anythinkLandingPageView = this.u;
        AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.s;
        for (int i = 0; i < 8; i++) {
            AnythinkBaseView anythinkBaseView = new AnythinkBaseView[]{anythinkPlayableView, anythinkClickCTAView, anythinkClickMiniCardView, anythinkNativeEndCardView, anythinkH5EndCardView, anythinkVastEndCardView, anythinkLandingPageView, anythinkVideoEndCoverView}[i];
            if (anythinkBaseView != null) {
                if (anythinkBaseView instanceof AnythinkClickMiniCardView) {
                    anythinkBaseView.setNotifyListener(new g(this.p, aVar));
                } else {
                    anythinkBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i) {
        this.A = i;
    }

    public void setRewardStatus(boolean z) {
        this.J = z;
    }

    public void setShowingTransparent(boolean z) {
        this.D = z;
    }

    public void setUnitID(String str) {
        this.w = str;
    }

    public void setVideoInteractiveType(int i) {
        if (this.b == null || !this.b.j()) {
            this.x = i;
            return;
        }
        int a2 = com.anythink.expressad.video.dynview.i.c.a(this.b);
        if (a2 == 100) {
            this.x = i;
        } else {
            this.x = a2;
        }
    }

    public void setVideoSkipTime(int i) {
        this.H = i;
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean showAlertWebView() {
        AnythinkAlertWebview anythinkAlertWebview = this.v;
        if (anythinkAlertWebview == null || !anythinkAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1) && !this.T) {
            removeAllViews();
            bringToFront();
            this.S = true;
        }
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView == null || anythinkClickMiniCardView.getParent() == null) {
            if (this.v == null) {
                o();
            }
            AnythinkAlertWebview anythinkAlertWebview2 = this.v;
            if (anythinkAlertWebview2 != null && anythinkAlertWebview2.getParent() != null) {
                removeView(this.v);
            }
            addView(this.v);
            setBackgroundColor(0);
            this.v.webviewshow();
            return true;
        }
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showEndcard(int i) {
        if (this.b != null) {
            if (i == 1) {
                this.e.a(104, "");
            } else if (i == 100) {
                if (this.b.J() == 2) {
                    this.E = true;
                }
                a(this.n);
                setMatchParent();
                i();
                o.a(AnythinkBaseView.TAG, "showEndcard addNativeEndcard");
            } else if (i == 3) {
                removeAllViews();
                setMatchParent();
                if (this.t == null) {
                    a(this.Q, (Integer) 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.t, layoutParams);
                this.t.notifyShowListener();
                this.T = true;
                bringToFront();
            } else if (i == 4) {
                this.e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.u == null) {
                    a(this.Q, (Integer) 4);
                }
                this.u.setUnitId(this.w);
                this.u.preLoadData(this.Q);
                addView(this.u);
                this.T = true;
                bringToFront();
            } else if (i != 5) {
                removeAllViews();
                setMatchParent();
                this.T = true;
                bringToFront();
                e();
                this.e.a(117, "");
            } else {
                this.e.a(106, "");
            }
        }
        this.B = true;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.setMiniCardLocation(i, i2, i3, i4);
            this.p.setRadius(i5);
            this.p.setCloseVisible(8);
            this.p.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            m();
            if (this.G) {
                return;
            }
            this.G = true;
            this.e.a(109, "");
            this.e.a(117, "");
        }
    }

    public void showOrderCampView() {
        AnyThinkOrderCampView anyThinkOrderCampView = new AnyThinkOrderCampView(this.f8440a);
        this.R = anyThinkOrderCampView;
        anyThinkOrderCampView.setCampaignExes(this.U);
        if (this.e != null && (this.e instanceof k)) {
            ((k) this.e).a(this.U);
        }
        this.R.setNotifyListener(new i(this.e));
        this.R.setRewarded(this.J);
        this.R.setNotchPadding(this.K, this.L, this.M, this.N);
        this.R.setCampOrderViewBuildCallback(new com.anythink.expressad.video.dynview.f.b() { // from class: com.anythink.expressad.video.module.AnythinkContainerView.3
            @Override // com.anythink.expressad.video.dynview.f.b
            public final void a() {
                if (AnythinkContainerView.this.e != null) {
                    AnythinkContainerView.this.e.a(117, "");
                }
            }

            @Override // com.anythink.expressad.video.dynview.f.b
            public final void b() {
                if (AnythinkContainerView.this.b.f() == 2) {
                    AnythinkContainerView.this.showVideoEndCover();
                    return;
                }
                AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                anythinkContainerView.showEndcard(anythinkContainerView.b.F());
            }
        });
        this.R.createView(this);
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showPlayableView() {
        if (this.b == null || this.E) {
            return;
        }
        removeAllViews();
        setMatchParent();
        if (this.n == null) {
            preLoadData(this.Q);
        }
        addView(this.n);
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.setUnitId(this.w);
            if (this.b != null && this.b.H() && this.b.J() == 2) {
                this.n.setCloseVisible(0);
            }
            this.n.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        this.T = true;
        bringToFront();
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoClickView(int i) {
        if (this.b != null) {
            if (i == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                p();
            } else if (i == 1) {
                if (this.B) {
                    return;
                }
                AnythinkH5EndCardView anythinkH5EndCardView = this.r;
                if (anythinkH5EndCardView != null && anythinkH5EndCardView.getParent() != null) {
                    removeView(this.r);
                }
                AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
                if (anythinkClickMiniCardView != null && anythinkClickMiniCardView.getParent() != null) {
                    removeView(this.p);
                }
                AnythinkClickCTAView anythinkClickCTAView = this.o;
                if (anythinkClickCTAView == null || anythinkClickCTAView.getParent() == null) {
                    try {
                        if (this.b != null && this.b.J() == 1) {
                            this.T = true;
                            if (this.o == null) {
                                b(-1);
                            }
                            if (this.o != null && (this.b == null || !this.b.j())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.o, 0, layoutParams);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                }
            } else if (i != 2) {
            } else {
                AnythinkClickCTAView anythinkClickCTAView2 = this.o;
                if (anythinkClickCTAView2 != null && anythinkClickCTAView2.getParent() != null) {
                    removeView(this.o);
                }
                AnythinkAlertWebview anythinkAlertWebview = this.v;
                if (anythinkAlertWebview == null || anythinkAlertWebview.getParent() == null) {
                    AnythinkClickMiniCardView anythinkClickMiniCardView2 = this.p;
                    if (anythinkClickMiniCardView2 == null || anythinkClickMiniCardView2.getParent() == null) {
                        try {
                            if (this.b != null && this.b.J() == 1) {
                                setMatchParent();
                                m();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!miniCardLoaded()) {
                        p();
                        return;
                    }
                    AnythinkH5EndCardView anythinkH5EndCardView2 = this.r;
                    if (anythinkH5EndCardView2 != null && anythinkH5EndCardView2.getParent() != null) {
                        removeView(this.r);
                    }
                    this.e.a(112, "");
                    if (this.b != null && !this.b.aw()) {
                        this.b.ax();
                        com.anythink.expressad.video.module.b.a.e(this.f8440a, this.b);
                    }
                    if (this.D) {
                        this.e.a(115, "");
                    } else {
                        this.T = true;
                        bringToFront();
                        webviewshow();
                        onConfigurationChanged(getResources().getConfiguration());
                    }
                    this.C = true;
                }
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.s;
        if (anythinkVideoEndCoverView == null) {
            b bVar = this.Q;
            this.Q = bVar;
            if (anythinkVideoEndCoverView == null) {
                AnythinkVideoEndCoverView anythinkVideoEndCoverView2 = new AnythinkVideoEndCoverView(this.f8440a);
                this.s = anythinkVideoEndCoverView2;
                anythinkVideoEndCoverView2.setCampaign(this.b);
                this.s.setNotifyListener(new i(this.e));
                this.s.preLoadData(bVar);
            }
        }
        addView(this.s);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i) {
        AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.toggleCloseBtn(i);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.toggleCloseBtn(i);
        }
    }

    public void triggerCloseBtn(String str) {
        if (this.b != null) {
            this.e.a(122, "");
            this.e.a(104, "");
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
        AnythinkPlayableView anythinkPlayableView = this.n;
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        AnythinkAlertWebview anythinkAlertWebview = this.v;
        for (int i = 0; i < 4; i++) {
            AnythinkH5EndCardView anythinkH5EndCardView2 = new AnythinkH5EndCardView[]{anythinkPlayableView, anythinkClickMiniCardView, anythinkH5EndCardView, anythinkAlertWebview}[i];
            if (anythinkH5EndCardView2 != null && anythinkH5EndCardView2.getVisibility() == 0 && anythinkH5EndCardView2.getParent() != null && !isLast()) {
                anythinkH5EndCardView2.webviewshow();
            }
        }
    }
}
