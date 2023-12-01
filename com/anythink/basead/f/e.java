package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.a.a;
import com.anythink.basead.a.c;
import com.anythink.basead.c.i;
import com.anythink.core.common.e.j;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/e.class */
public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    com.anythink.basead.e.a f5995a;
    com.anythink.core.common.k.a.c k;
    com.anythink.basead.a.c l;
    View m;
    volatile boolean n;
    View.OnClickListener o;
    com.anythink.basead.a.a p;
    boolean q;
    private final String r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.f.e$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/e$2.class */
    public final class AnonymousClass2 implements c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5997a;

        AnonymousClass2(int i) {
            this.f5997a = i;
        }

        @Override // com.anythink.basead.a.c.b
        public final void a() {
            if (e.this.f5995a != null) {
                e.this.f5995a.onAdClick(this.f5997a);
            }
        }

        @Override // com.anythink.basead.a.c.b
        public final void a(boolean z) {
            if (e.this.f5995a != null) {
                e.this.f5995a.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.a.c.b
        public final void b() {
        }
    }

    /* renamed from: com.anythink.basead.f.e$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/e$3.class */
    final class AnonymousClass3 implements a.InterfaceC0066a {
        AnonymousClass3() {
        }

        @Override // com.anythink.basead.a.a.InterfaceC0066a
        public final void a(int i) {
            e.a(e.this, 2);
        }
    }

    public e(Context context, j jVar, String str, boolean z) {
        super(context, jVar, str, z);
        this.r = getClass().getSimpleName();
        this.o = new View.OnClickListener() { // from class: com.anythink.basead.f.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                e.a(e.this, 1);
            }
        };
        this.q = false;
    }

    private void a(int i) {
        o();
        p();
        if (this.l == null) {
            this.l = new com.anythink.basead.a.c(this.f5991c, this.d, this.g);
        }
        if (this.l.a()) {
            return;
        }
        this.l.a(new AnonymousClass2(i));
        this.l.a(new i(this.d.d, ""));
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

    static /* synthetic */ void a(e eVar, int i) {
        eVar.o();
        eVar.p();
        if (eVar.l == null) {
            eVar.l = new com.anythink.basead.a.c(eVar.f5991c, eVar.d, eVar.g);
        }
        if (eVar.l.a()) {
            return;
        }
        eVar.l.a(new AnonymousClass2(i));
        eVar.l.a(new i(eVar.d.d, ""));
    }

    private void b(View view) {
        if (this.d.m.F() != 2 || view == null || this.q) {
            return;
        }
        this.q = true;
        this.p = new com.anythink.basead.a.a(view, this.d, new AnonymousClass3());
    }

    private void c(View view) {
        this.m = view;
        com.anythink.core.common.k.a.a aVar = new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.f.e.4
            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final void recordImpression(View view2) {
                e.this.p();
            }
        };
        if (this.k == null) {
            view.getContext();
            this.k = new com.anythink.core.common.k.a.c();
        }
        this.k.a(view, aVar);
    }

    public static View k() {
        return null;
    }

    private void n() {
        com.anythink.basead.a.a aVar = this.p;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void o() {
        com.anythink.basead.a.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.n) {
            return;
        }
        this.n = true;
        com.anythink.basead.f.a.b.a(this.f5991c).a(this.g);
        com.anythink.basead.a.b.a(8, this.g, new i(this.d.d, ""));
        com.anythink.basead.e.a aVar = this.f5995a;
        if (aVar != null) {
            aVar.onAdShow();
        }
        n();
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public final void a(View view) {
        c(view);
        a(view, this.o);
    }

    public final void a(View view, List<View> list) {
        if (this.d.m.F() == 2 && view != null && !this.q) {
            this.q = true;
            this.p = new com.anythink.basead.a.a(view, this.d, new AnonymousClass3());
        }
        c(view);
        if (list == null) {
            view.setOnClickListener(this.o);
            return;
        }
        for (View view2 : list) {
            if (view2 != null) {
                view2.setOnClickListener(this.o);
            }
        }
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.f5995a = aVar;
    }

    public final String b() {
        return this.g != null ? this.g.r() : "";
    }

    public final String f() {
        return this.g != null ? this.g.s() : "";
    }

    public final String g() {
        return this.g != null ? this.g.w() : "";
    }

    public final String h() {
        return this.g != null ? this.g.t() : "";
    }

    public final String i() {
        return this.g != null ? this.g.u() : "";
    }

    public final String j() {
        return this.g != null ? this.g.v() : "";
    }

    public final void l() {
        com.anythink.core.common.k.a.c cVar = this.k;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void m() {
        l();
        o();
        this.f5995a = null;
        com.anythink.basead.a.c cVar = this.l;
        if (cVar != null) {
            cVar.d();
            this.l = null;
        }
        this.k = null;
    }
}
