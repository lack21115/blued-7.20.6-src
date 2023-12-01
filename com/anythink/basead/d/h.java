package com.anythink.basead.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.basead.a.a;
import com.anythink.basead.a.c;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.MediaAdView;
import com.anythink.basead.ui.MraidMediaView;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.z;
import com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup;
import com.anythink.expressad.out.o;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    Context f5969a;
    com.anythink.basead.e.a b;

    /* renamed from: c  reason: collision with root package name */
    com.anythink.core.common.k.a.c f5970c;
    com.anythink.basead.a.c d;
    View e;
    volatile boolean f;
    aa g;
    j h;
    boolean i;
    String j;
    com.anythink.expressad.advanced.d.c k;
    BaseMediaAdView l;
    int n;
    int o;
    com.anythink.basead.a.a p;
    OwnNativeAdView q;
    private final String r = getClass().getSimpleName();
    View.OnClickListener m = new View.OnClickListener() { // from class: com.anythink.basead.d.h.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            h.this.a(view, 1);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/h$a.class */
    static final class a implements BaseMediaAdView.a {

        /* renamed from: a  reason: collision with root package name */
        private final BaseMediaAdView.a f5978a;

        public a(BaseMediaAdView.a aVar) {
            this.f5978a = aVar;
        }

        @Override // com.anythink.basead.ui.BaseMediaAdView.a
        public final void onClickCloseView() {
            BaseMediaAdView.a aVar = this.f5978a;
            if (aVar != null) {
                aVar.onClickCloseView();
            }
        }
    }

    public h(Context context, aa aaVar, j jVar, com.anythink.core.common.a.g gVar) {
        this.f5969a = context.getApplicationContext();
        this.g = aaVar;
        this.h = jVar;
        if (gVar instanceof com.anythink.expressad.advanced.d.c) {
            com.anythink.expressad.advanced.d.c cVar = (com.anythink.expressad.advanced.d.c) gVar;
            this.k = cVar;
            cVar.a(new o() { // from class: com.anythink.basead.d.h.3
                @Override // com.anythink.expressad.out.o
                public final void a() {
                }

                @Override // com.anythink.expressad.out.o
                public final void a(com.anythink.expressad.foundation.d.c cVar2) {
                    Context g = n.a().g();
                    if (h.this.d == null) {
                        h hVar = h.this;
                        hVar.d = new com.anythink.basead.a.c(g, hVar.h, h.this.g);
                        h.this.d.a(new c.b() { // from class: com.anythink.basead.d.h.3.1
                            @Override // com.anythink.basead.a.c.b
                            public final void a() {
                                if (h.this.b != null) {
                                    h.this.b.onAdClick(1);
                                }
                            }

                            @Override // com.anythink.basead.a.c.b
                            public final void a(boolean z) {
                                if (h.this.b != null) {
                                    h.this.b.onDeeplinkCallback(z);
                                }
                            }

                            @Override // com.anythink.basead.a.c.b
                            public final void b() {
                            }
                        });
                    }
                    com.anythink.basead.d.a.b.a(h.this.d.b(), cVar2);
                    ATOutNativeAdvancedViewGroup c2 = h.this.k != null ? h.this.k.c() : null;
                    com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(h.this.h.d, "");
                    if (c2 != null) {
                        iVar.f = c2.getHeight();
                        iVar.e = c2.getWidth();
                    }
                    iVar.g = new com.anythink.basead.c.a();
                    h.this.d.a(iVar);
                }

                @Override // com.anythink.expressad.out.o
                public final void a(String str) {
                }

                @Override // com.anythink.expressad.out.o
                public final void b() {
                    if (h.this.b != null) {
                        h.this.b.onAdShow();
                    }
                }

                @Override // com.anythink.expressad.out.o
                public final void c() {
                }

                @Override // com.anythink.expressad.out.o
                public final void d() {
                }

                @Override // com.anythink.expressad.out.o
                public final void e() {
                }

                @Override // com.anythink.expressad.out.o
                public final void f() {
                    if (h.this.b != null) {
                        h.this.b.onAdClosed();
                    }
                }
            });
        }
    }

    private static int a(int i) {
        Random random = new Random();
        if (i > 0) {
            double d = i;
            int i2 = (int) (0.1d * d);
            return random.nextInt((((int) (d * 0.9d)) - i2) + 1) + i2;
        }
        return 0;
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if (!(view instanceof ViewGroup)) {
            view.setOnClickListener(onClickListener);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i2), onClickListener);
            i = i2 + 1;
        }
    }

    private void a(View view, View[] viewArr) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), viewArr);
            }
        } else if (((view instanceof Button) || (view instanceof TextView)) && TextUtils.equals(((TextView) view).getText().toString(), this.g.w())) {
            viewArr[0] = view;
        }
    }

    private void a(OwnNativeAdView[] ownNativeAdViewArr, View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof OwnNativeAdView) {
                ownNativeAdViewArr[0] = (OwnNativeAdView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(ownNativeAdViewArr, viewGroup.getChildAt(i));
            }
        }
    }

    private View b(Context context, boolean z, boolean z2, BaseMediaAdView.a aVar) {
        a aVar2 = new a(aVar);
        OwnNativeAdView ownNativeAdView = new OwnNativeAdView(this.f5969a);
        if (z) {
            this.q = ownNativeAdView;
            MraidMediaView mraidMediaView = new MraidMediaView(context, this.g, this.h, z2, aVar2);
            this.l = mraidMediaView;
            mraidMediaView.setMraidWebViewListener(new MraidMediaView.a() { // from class: com.anythink.basead.d.h.4
                @Override // com.anythink.basead.ui.MraidMediaView.a
                public final void a() {
                    if (h.this.q != null) {
                        h hVar = h.this;
                        hVar.b(hVar.q);
                    }
                }

                @Override // com.anythink.basead.ui.MraidMediaView.a
                public final void a(String str) {
                    if (h.this.g != null) {
                        h.this.g.v(str);
                    }
                    h hVar = h.this;
                    hVar.a(hVar.l, 1);
                }
            });
        } else {
            this.l = new MediaAdView(context, this.g, this.h, z2, aVar2);
        }
        this.l.init(this.n, this.o);
        ownNativeAdView.addView(this.l, new FrameLayout.LayoutParams(this.l.getMediaViewWidth(), this.l.getMediaViewHeight()));
        if (z) {
            q();
            return ownNativeAdView;
        }
        a(ownNativeAdView, this.l.getClickViews());
        return ownNativeAdView;
    }

    private static com.anythink.basead.c.a c(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int a2 = a(width);
        int a3 = a(height);
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.f5890a = i + a2;
        aVar.b = i2 + a3;
        aVar.e = a2;
        aVar.f = a3;
        aVar.f5891c = aVar.f5890a + ((int) (Math.random() * 15.0d));
        aVar.d = aVar.b + ((int) (Math.random() * 15.0d));
        aVar.g = aVar.f5891c - i;
        aVar.h = aVar.d - i2;
        return aVar;
    }

    private boolean d(View view) {
        OwnNativeAdView[] ownNativeAdViewArr = new OwnNativeAdView[1];
        a(ownNativeAdViewArr, view);
        if (ownNativeAdViewArr[0] == null) {
            Log.i("anythink", "Register View don't contain OwnNativeAdView.");
            return false;
        } else if (ownNativeAdViewArr[0].getChildCount() == 0) {
            Log.i("anythink", "OwnNativeAdView View don't contain any child views.");
            return false;
        } else {
            this.q = ownNativeAdViewArr[0];
            q();
            return true;
        }
    }

    private void m() {
        com.anythink.basead.a.a aVar = this.p;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void n() {
        com.anythink.basead.a.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.i && this.g.g()) {
            BaseMediaAdView baseMediaAdView = this.l;
            if (baseMediaAdView instanceof MraidMediaView) {
                ((MraidMediaView) baseMediaAdView).fireAudioVolumeChange(this.i);
            }
        }
        if (this.g instanceof z) {
            com.anythink.basead.d.c.c.a().a(this.f5969a, com.anythink.basead.d.c.c.a(this.h.b, this.h.f6664c), this.g, this.h.m);
        }
        com.anythink.expressad.advanced.d.c cVar = this.k;
        View c2 = cVar != null ? cVar.c() : this.q;
        if (this.g.g()) {
            c2 = this.l;
        }
        if (c2 != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.h.d, "");
            iVar.f = c2.getHeight();
            iVar.e = c2.getWidth();
            com.anythink.basead.a.b.a(8, this.g, iVar);
            com.anythink.basead.e.a aVar = this.b;
            if (aVar != null) {
                aVar.onAdShow();
            }
        }
        m();
    }

    private View p() {
        View monitorClickView;
        BaseMediaAdView baseMediaAdView = this.l;
        if (baseMediaAdView == null || (monitorClickView = baseMediaAdView.getMonitorClickView()) == null) {
            View[] viewArr = new View[1];
            a(this.q, viewArr);
            return viewArr[0] != null ? viewArr[0] : this.q;
        }
        return monitorClickView;
    }

    private void q() {
        j jVar = this.h;
        if (jVar == null || jVar.m == null || this.h.m.F() != 2) {
            return;
        }
        final View p = p();
        this.p = new com.anythink.basead.a.a(p, this.h, new a.InterfaceC0066a() { // from class: com.anythink.basead.d.h.6
            @Override // com.anythink.basead.a.a.InterfaceC0066a
            public final void a(int i) {
                h.this.a(p, 2);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final View a(Context context, boolean z, boolean z2, BaseMediaAdView.a aVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final com.anythink.core.common.e.i a() {
        return this.g;
    }

    public final void a(int i, int i2) {
        this.n = i;
        this.o = i2;
        com.anythink.expressad.advanced.d.c cVar = this.k;
        if (cVar != null) {
            cVar.a(i2, i);
        }
    }

    public final void a(View view) {
        if (d(view)) {
            aa aaVar = this.g;
            if (aaVar != null && !aaVar.g()) {
                b(view);
            }
            a(view, this.m);
        }
    }

    final void a(View view, final int i) {
        com.anythink.basead.c.a adClickRecord;
        if (this.q != null) {
            n();
            o();
            if (this.d == null) {
                this.d = new com.anythink.basead.a.c(n.a().g(), this.h, this.g);
            }
            if (this.d.a()) {
                return;
            }
            this.d.a(new c.b() { // from class: com.anythink.basead.d.h.2
                @Override // com.anythink.basead.a.c.b
                public final void a() {
                    if (h.this.l != null) {
                        h.this.l.notifyClick();
                    }
                    if (h.this.b != null) {
                        h.this.b.onAdClick(i);
                    }
                }

                @Override // com.anythink.basead.a.c.b
                public final void a(boolean z) {
                    if (h.this.b != null) {
                        h.this.b.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.a.c.b
                public final void b() {
                }
            });
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.h.d, "");
            iVar.f = this.q.getHeight();
            iVar.e = this.q.getWidth();
            if (i != 2) {
                adClickRecord = this.q.getAdClickRecord();
            } else if (view == null) {
                adClickRecord = null;
            } else {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                int width = view.getWidth();
                int height = view.getHeight();
                int a2 = a(width);
                int a3 = a(height);
                adClickRecord = new com.anythink.basead.c.a();
                adClickRecord.f5890a = i2 + a2;
                adClickRecord.b = i3 + a3;
                adClickRecord.e = a2;
                adClickRecord.f = a3;
                adClickRecord.f5891c = adClickRecord.f5890a + ((int) (Math.random() * 15.0d));
                adClickRecord.d = adClickRecord.b + ((int) (Math.random() * 15.0d));
                adClickRecord.g = adClickRecord.f5891c - i2;
                adClickRecord.h = adClickRecord.d - i3;
            }
            iVar.g = adClickRecord;
            this.d.a(iVar);
        }
    }

    public final void a(View view, List<View> list) {
        if (d(view)) {
            aa aaVar = this.g;
            if (aaVar != null && !aaVar.g()) {
                b(view);
            }
            if (list == null) {
                view.setOnClickListener(this.m);
                return;
            }
            for (View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(this.m);
                }
            }
        }
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.b = aVar;
    }

    public final void a(String str) {
        this.j = str;
        if (this.k != null) {
            if (TextUtils.isEmpty(str)) {
                this.k.c(3);
                return;
            }
            String str2 = this.j;
            boolean z = true;
            switch (str2.hashCode()) {
                case 49:
                    if (str2.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
                case 50:
                    if (str2.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 51:
                    if (str2.equals("3")) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (!z) {
                this.k.c(3);
            } else if (z) {
                this.k.c(1);
            } else if (!z) {
            } else {
                this.k.c(2);
            }
        }
    }

    public final void a(boolean z) {
        this.i = z;
        com.anythink.expressad.advanced.d.c cVar = this.k;
        if (cVar != null) {
            cVar.b(z ? 1 : 2);
        }
    }

    public final boolean a(boolean z, boolean z2) {
        if (this.g.n() != 67) {
            return false;
        }
        return this.g.a(z, z2);
    }

    public final String b() {
        aa aaVar = this.g;
        return aaVar != null ? aaVar.r() : "";
    }

    public final void b(View view) {
        this.e = view;
        com.anythink.core.common.k.a.a aVar = new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.d.h.5
            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final void recordImpression(View view2) {
                h.this.o();
            }
        };
        if (this.f5970c == null) {
            view.getContext();
            this.f5970c = new com.anythink.core.common.k.a.c(this.h.m.R() <= 0 ? 100 : this.h.m.R());
        }
        this.f5970c.a(view, aVar);
    }

    public final String c() {
        aa aaVar = this.g;
        return aaVar != null ? aaVar.s() : "";
    }

    public final String d() {
        aa aaVar = this.g;
        return aaVar != null ? aaVar.w() : "";
    }

    public final String e() {
        aa aaVar = this.g;
        return aaVar != null ? aaVar.t() : "";
    }

    public final String f() {
        aa aaVar = this.g;
        return aaVar != null ? aaVar.u() : "";
    }

    public final String g() {
        aa aaVar = this.g;
        return aaVar != null ? aaVar.v() : "";
    }

    public final boolean h() {
        return this.k != null;
    }

    public final void i() {
        com.anythink.core.common.k.a.c cVar = this.f5970c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void j() {
        i();
        n();
        this.e = null;
        this.q = null;
        this.b = null;
        try {
            if (this.k != null) {
                this.k.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.anythink.basead.a.c cVar = this.d;
        if (cVar != null) {
            cVar.d();
            this.d = null;
        }
        com.anythink.core.common.k.a.c cVar2 = this.f5970c;
        if (cVar2 != null) {
            cVar2.b();
            this.f5970c = null;
        }
        BaseMediaAdView baseMediaAdView = this.l;
        if (baseMediaAdView != null) {
            baseMediaAdView.destroy();
        }
    }

    public final void k() {
        com.anythink.expressad.advanced.d.c cVar = this.k;
        if (cVar != null) {
            cVar.d(3);
        }
    }

    public final void l() {
        com.anythink.expressad.advanced.d.c cVar = this.k;
        if (cVar != null) {
            cVar.e(3);
        }
    }
}
