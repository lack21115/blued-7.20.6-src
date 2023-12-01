package com.opos.mobad.service.h;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.e.c;
import com.opos.cmn.i.f;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ah;
import com.opos.mobad.b.a.g;
import com.opos.mobad.b.a.k;
import com.opos.mobad.b.a.l;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.o;
import com.opos.mobad.b.a.p;
import com.opos.mobad.b.a.u;
import com.opos.mobad.b.a.w;
import com.opos.mobad.service.f.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/h/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ab f13689a;
    private static n b;

    public static final m a(Context context) {
        l b2 = new l.a().a(com.opos.mobad.service.e.a.a().m()).b(com.opos.mobad.service.e.a.a().e()).c(com.opos.cmn.f.a.a(context)).g(com.opos.mobad.service.e.a.a().n()).h(com.opos.mobad.service.e.a.a().g()).i(com.opos.mobad.service.e.a.a().h()).j(com.opos.mobad.service.e.a.a().i()).k(f.a(context)).b();
        o b3 = new o.a().a(Float.valueOf(com.opos.cmn.an.h.f.a.f(context))).a(Integer.valueOf(com.opos.cmn.an.h.f.a.c(context))).b(Integer.valueOf(com.opos.cmn.an.h.f.a.b(context))).b();
        double[] c2 = c.a().c();
        return new m.a().a(b2).a(f()).a(b3).a(new p.a().a(new k.a().b(String.valueOf(c2[0])).a(String.valueOf(c2[1])).a(Long.valueOf(System.currentTimeMillis())).b()).a(c(context)).a(a(com.opos.mobad.service.f.a.a().t())).a(Integer.valueOf(com.opos.cmn.an.h.f.a.i(context))).b()).a(com.opos.cmn.an.b.c.a()).b(c()).c(com.opos.cmn.an.b.a.a(context)).d(com.opos.mobad.service.e.a.a().b()).e(com.opos.mobad.service.e.a.a().c()).a(Boolean.valueOf(com.opos.cmn.an.f.a.b(context))).b();
    }

    private static final p.c a(String str) {
        p.c cVar = p.c.UNKNOWN_OPERATOR;
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != -1429363305) {
            if (hashCode != -1068855134) {
                if (hashCode == -840542575 && str.equals("unicom")) {
                    z = true;
                }
            } else if (str.equals("mobile")) {
                z = false;
            }
        } else if (str.equals("telecom")) {
            z = true;
        }
        return z ? !z ? !z ? cVar : p.c.CHINA_UNICOM : p.c.CHINA_TELECOM : p.c.CHINA_MOBILE;
    }

    public static final u a() {
        return new u.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().c())).a(com.opos.mobad.service.f.a.a().d()).b(com.opos.mobad.service.f.a.a().b()).a(Long.valueOf(com.opos.mobad.service.f.a.a().s())).b();
    }

    public static final ah b() {
        return new ah.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().e())).a(com.opos.mobad.service.f.a.a().f()).b(com.opos.mobad.service.f.a.a().g()).b();
    }

    public static final w b(Context context) {
        a.d n = com.opos.mobad.service.f.a.a().n();
        return new w.a().a(n.b).a(Integer.valueOf(n.f13675a)).b();
    }

    private static final p.b c(Context context) {
        boolean z;
        p.b bVar = p.b.CONNECTION_UNKNOWN;
        String h = com.opos.cmn.an.h.c.a.h(context);
        int hashCode = h.hashCode();
        if (hashCode == 1653) {
            if (h.equals("2g")) {
                z = false;
            }
            z = true;
        } else if (hashCode == 1684) {
            if (h.equals("3g")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 1715) {
            if (hashCode == 3649301 && h.equals("wifi")) {
                z = true;
            }
            z = true;
        } else {
            if (h.equals("4g")) {
                z = true;
            }
            z = true;
        }
        return z ? !z ? !z ? !z ? bVar : p.b.WIFI : p.b.CELL_4G : p.b.CELL_3G : p.b.CELL_2G;
    }

    public static final String c() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return "";
        }
    }

    public static final ab d() {
        if (f13689a == null) {
            f13689a = new ab.a().a(Integer.valueOf(com.opos.mobad.service.f.a.a().o())).a(com.opos.mobad.service.f.a.a().p()).b(Integer.valueOf(com.opos.mobad.service.f.a.a().q())).c(Integer.valueOf(com.opos.cmn.f.a.a())).b();
        }
        return f13689a;
    }

    public static final g e() {
        return new g.a().a(com.opos.mobad.service.f.a.a().l()).b(com.opos.mobad.service.f.a.a().k()).c(com.opos.mobad.service.f.a.a().m()).b();
    }

    private static final n f() {
        if (b == null) {
            b = new n.a().a(com.opos.mobad.service.f.a.a().h()).c(com.opos.mobad.service.f.a.a().j()).b(com.opos.mobad.service.f.a.a().i()).b();
        }
        return b;
    }
}
