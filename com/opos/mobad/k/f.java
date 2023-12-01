package com.opos.mobad.k;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.n.d.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/f.class */
public class f {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.opos.mobad.ad.e.e f26293a;
        public final a.C0707a b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f26294c;
        private final com.opos.mobad.ad.e.d d;

        private a(com.opos.mobad.ad.e.d dVar, com.opos.mobad.ad.e.e eVar, a.C0707a c0707a) {
            this.f26294c = false;
            this.d = dVar;
            this.f26293a = eVar;
            this.b = c0707a;
        }

        public long a() {
            a.C0707a c0707a = this.b;
            if (c0707a == null) {
                return 0L;
            }
            return c0707a.b.o();
        }

        public com.opos.mobad.ad.e.d b() {
            if (!c() || d()) {
                return null;
            }
            return this.d;
        }

        public boolean c() {
            a.C0707a c0707a = this.b;
            if (c0707a == null) {
                return true;
            }
            return c0707a.f26483c.a();
        }

        public boolean d() {
            a.C0707a c0707a = this.b;
            if (c0707a == null) {
                return false;
            }
            int d = c0707a.f26483c.d();
            return d == 11 || d == 5;
        }

        public String toString() {
            return "SplashVo{bottomArea=" + this.d + ", customSkipView=" + this.f26293a + ", adHelperData=" + this.b + '}';
        }
    }

    public static a a(com.opos.mobad.ad.e.f fVar, a.C0707a c0707a) {
        a aVar = null;
        if (fVar != null) {
            if (c0707a == null) {
                return null;
            }
            aVar = new a(fVar.e, fVar.g, c0707a);
        }
        return aVar;
    }

    public static h a(Context context, a aVar, com.opos.mobad.n.d dVar, com.opos.mobad.n.c cVar) {
        if (aVar == null) {
            return null;
        }
        MaterialFileData b = b(aVar);
        String a2 = b != null ? com.opos.cmn.d.d.a(context, b.a()) : "";
        h a3 = com.opos.mobad.model.a.a(context, aVar.b.b, aVar.b.f26483c, false, false, com.opos.mobad.service.f.b().m().a(), com.opos.mobad.service.f.b().m().b());
        a3.a(aVar.a(), aVar.a()).e(a2, b != null ? b.b() : "").a(dVar).a(cVar).d(d(aVar)).f(e(aVar));
        return a3;
    }

    public static boolean a(a aVar) {
        AdData adData;
        return (!c(aVar) || (adData = aVar.b.f26482a) == null || !adData.b() || aVar.f26293a == null || aVar.f26293a.a() == null) ? false : true;
    }

    public static MaterialFileData b(a aVar) {
        if (c(aVar)) {
            return aVar.b.d;
        }
        return null;
    }

    public static boolean c(a aVar) {
        return (aVar == null || aVar.b == null) ? false : true;
    }

    private static String d(a aVar) {
        return !TextUtils.isEmpty(aVar.b.f26483c.Y()) ? aVar.b.f26483c.Y() : "点击跳转详情页或第三方应用";
    }

    private static int e(a aVar) {
        int E = aVar.b.b.E();
        if (!aVar.c() || aVar.d()) {
            E = 0;
        }
        if (E != 1) {
            return E != 2 ? 0 : 2;
        }
        return 1;
    }
}
