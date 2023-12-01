package com.anythink.core.common.j;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.i;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ah;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.f;
import com.anythink.core.common.e.m;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.k.g;
import com.anythink.core.common.o;
import com.anythink.core.common.q;
import com.anythink.core.common.r;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/j/a.class */
public class a extends o<f> {
    private static volatile a f;

    private a(Context context) {
        super(context);
    }

    static /* synthetic */ f a(a aVar, int i, ah ahVar, ai aiVar, long j) {
        if (i == 13) {
            m N = aiVar != null ? aiVar.N() : null;
            if (N != null) {
                N.a(aiVar);
            }
        }
        if (i == 4) {
            m N2 = aiVar != null ? aiVar.N() : null;
            if (N2 != null) {
                N2.a(true, N2.getSortPrice(), true);
            }
            if (ahVar instanceof e) {
                aVar.a((e) ahVar, aiVar);
            }
        }
        com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        f fVar = new f();
        fVar.f6657a = i;
        fVar.b = ahVar;
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        fVar.f6658c = j;
        r.a(n.a().g()).a(i, fVar, b);
        if (a(i, ahVar, b)) {
            return null;
        }
        if (4 == i && (ahVar instanceof e)) {
            q.a();
            q.a((e) ahVar);
        }
        return fVar;
    }

    public static a a(Context context) {
        if (f == null) {
            synchronized (a.class) {
                try {
                    if (f == null) {
                        f = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private static void a(int i, ai aiVar) {
        if (i == 13) {
            m N = aiVar != null ? aiVar.N() : null;
            if (N != null) {
                N.a(aiVar);
            }
        }
    }

    private void a(e eVar, ai aiVar) {
        List<String> w;
        List<ai> G;
        com.anythink.core.common.e.b a2;
        m N;
        String W = eVar.W();
        com.anythink.core.c.d a3 = com.anythink.core.c.e.a(this.e).a(W);
        if (a3 == null || (w = a3.w()) == null || w.size() == 0 || (G = a3.G()) == null || G.size() == 0) {
            return;
        }
        for (ai aiVar2 : G) {
            try {
                if (w.contains(String.valueOf(aiVar2.c())) && (a2 = com.anythink.core.common.a.a().a(W, aiVar2)) != null && (N = a2.e().getUnitGroupInfo().N()) != null) {
                    N.a(false, g.a(aiVar), aiVar.j());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static boolean a(int i, ah ahVar, com.anythink.core.c.a aVar) {
        String ak = aVar.ak();
        if (!TextUtils.isEmpty(ak) && (ahVar instanceof e)) {
            try {
                JSONArray jSONArray = new JSONArray(ak);
                int length = jSONArray.length();
                int H = ((e) ahVar).H();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    } else if (TextUtils.equals(String.valueOf(H), jSONArray.optString(i3))) {
                        return true;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            } catch (Throwable th) {
            }
        }
        Map<String, String> ai = aVar.ai();
        if (ai == null || !ai.containsKey(String.valueOf(i))) {
            return false;
        }
        String str = ai.get(String.valueOf(i));
        return !TextUtils.isEmpty(str) && str.contains(ahVar.Y());
    }

    private f b(int i, ah ahVar, ai aiVar, long j) {
        if (i == 13) {
            m N = aiVar != null ? aiVar.N() : null;
            if (N != null) {
                N.a(aiVar);
            }
        }
        if (i == 4) {
            m N2 = aiVar != null ? aiVar.N() : null;
            if (N2 != null) {
                N2.a(true, N2.getSortPrice(), true);
            }
            if (ahVar instanceof e) {
                a((e) ahVar, aiVar);
            }
        }
        com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        f fVar = new f();
        fVar.f6657a = i;
        fVar.b = ahVar;
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        fVar.f6658c = j;
        r.a(n.a().g()).a(i, fVar, b);
        if (a(i, ahVar, b)) {
            return null;
        }
        if (4 == i && (ahVar instanceof e)) {
            q.a();
            q.a((e) ahVar);
        }
        return fVar;
    }

    private void b(int i, ah ahVar, ai aiVar) {
        if (i == 4) {
            m N = aiVar != null ? aiVar.N() : null;
            if (N != null) {
                N.a(true, N.getSortPrice(), true);
            }
            if (ahVar instanceof e) {
                a((e) ahVar, aiVar);
            }
        }
    }

    static /* synthetic */ boolean b(int i, ah ahVar) {
        Map<String, String> a2;
        if (ahVar instanceof e) {
            e eVar = (e) ahVar;
            if (eVar.H() == 67) {
                return true;
            }
            if (eVar.H() == 0 || TextUtils.isEmpty(ahVar.Y()) || (a2 = com.anythink.core.c.b.a(n.a().g()).b(n.a().p()).a(i)) == null) {
                return false;
            }
            if (a2.containsKey("0")) {
                String str = a2.get("0");
                return !TextUtils.isEmpty(str) && str.contains(ahVar.Y());
            } else if (a2.containsKey(String.valueOf(eVar.H()))) {
                String str2 = a2.get(String.valueOf(eVar.H()));
                return !TextUtils.isEmpty(str2) && str2.contains(ahVar.Y());
            } else {
                return false;
            }
        }
        return false;
    }

    private static boolean c(int i, ah ahVar) {
        Map<String, String> a2;
        if (ahVar instanceof e) {
            e eVar = (e) ahVar;
            if (eVar.H() == 67) {
                return true;
            }
            if (eVar.H() == 0 || TextUtils.isEmpty(ahVar.Y()) || (a2 = com.anythink.core.c.b.a(n.a().g()).b(n.a().p()).a(i)) == null) {
                return false;
            }
            if (a2.containsKey("0")) {
                String str = a2.get("0");
                return !TextUtils.isEmpty(str) && str.contains(ahVar.Y());
            } else if (a2.containsKey(String.valueOf(eVar.H()))) {
                String str2 = a2.get(String.valueOf(eVar.H()));
                return !TextUtils.isEmpty(str2) && str2.contains(ahVar.Y());
            } else {
                return false;
            }
        }
        return false;
    }

    private static void d(int i, ah ahVar) {
        if (4 == i && (ahVar instanceof e)) {
            q.a();
            q.a((e) ahVar);
        }
    }

    private static void e(int i, ah ahVar) {
        if (ahVar instanceof e) {
            if (i == 4) {
                ((e) ahVar).c();
            } else if (i == 6) {
                ((e) ahVar).d();
            } else if (i != 21) {
            } else {
                n.a().M();
            }
        }
    }

    public final void a(int i, ah ahVar) {
        synchronized (this) {
            a(i, ahVar, null, -1L);
        }
    }

    public final void a(int i, ah ahVar, ai aiVar) {
        synchronized (this) {
            a(i, ahVar, aiVar, -1L);
        }
    }

    public final void a(final int i, final ah ahVar, final ai aiVar, final long j) {
        synchronized (this) {
            if (ahVar instanceof e) {
                if (i == 4) {
                    ((e) ahVar).c();
                } else if (i == 6) {
                    ((e) ahVar).d();
                } else if (i == 21) {
                    n.a().M();
                }
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if ((ahVar instanceof e) && n.a().H()) {
                        i.a().a(i, (e) ahVar);
                    }
                    f a2 = a.a(a.this, i, ahVar, aiVar, j);
                    if (a2 == null) {
                        return;
                    }
                    a.super.a((a) a2, a.b(i, ahVar));
                }
            });
        }
    }

    @Override // com.anythink.core.common.o
    public final void a(List<f> list) {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        if (b == null) {
            new com.anythink.core.common.g.m(this.e, 0, list).a(0, (com.anythink.core.common.g.i) null);
            return;
        }
        int u = b.u();
        if (u == 1) {
            com.anythink.core.common.g.a.e eVar = new com.anythink.core.common.g.a.e(list);
            eVar.a(1, b.t());
            eVar.a((c.a) null);
        } else if (u != 2) {
            new com.anythink.core.common.g.m(this.e, b.u(), list).a(0, (com.anythink.core.common.g.i) null);
        } else {
            new com.anythink.core.common.g.m(this.e, b.u(), list).a(0, (com.anythink.core.common.g.i) null);
            com.anythink.core.common.g.a.e eVar2 = new com.anythink.core.common.g.a.e(list);
            eVar2.a(2, b.t());
            eVar2.a((c.a) null);
        }
    }
}
