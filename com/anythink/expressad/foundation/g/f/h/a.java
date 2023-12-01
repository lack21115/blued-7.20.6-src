package com.anythink.expressad.foundation.g.f.h;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.f.d.c;
import com.anythink.expressad.foundation.g.f.d.d;
import com.anythink.expressad.foundation.g.f.d.g;
import com.anythink.expressad.foundation.g.f.e;
import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.l;
import com.anythink.expressad.foundation.g.f.m;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.out.k;
import java.io.File;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/h/a.class */
public class a {
    private static final String b = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected Context f7913a;

    public a(Context context) {
        if (context == null) {
            this.f7913a = com.anythink.expressad.foundation.b.a.b().d();
        } else {
            this.f7913a = context.getApplicationContext();
        }
    }

    private void a(int i, String str, b bVar, e eVar) {
        String str2 = bVar.b().get("sign");
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        bVar.a("ts", String.valueOf(currentTimeMillis));
        bVar.a("st", p.a(str3 + currentTimeMillis));
        b(i, str, bVar, new com.anythink.expressad.foundation.g.f.b(), eVar);
    }

    private void a(int i, String str, b bVar, l lVar, e eVar) {
        b bVar2 = bVar;
        if (bVar == null) {
            try {
                bVar2 = new b();
            } catch (Exception e) {
                o.a(b, e.getMessage());
            }
        }
        b bVar3 = bVar2;
        a(str, bVar2);
        b bVar4 = bVar2;
        String str2 = bVar2.b().get("sign");
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        b bVar5 = bVar2;
        bVar2.a("ts", String.valueOf(currentTimeMillis));
        b bVar6 = bVar2;
        StringBuilder sb = new StringBuilder();
        b bVar7 = bVar2;
        sb.append(str3);
        b bVar8 = bVar2;
        sb.append(currentTimeMillis);
        bVar = bVar2;
        bVar2.a("st", p.a(sb.toString()));
        bVar = bVar2;
        String str4 = str + "?" + bVar.toString();
        i iVar = null;
        if (i == 0) {
            iVar = new g(0, str4, null, eVar);
        } else if (i == 1) {
            iVar = new d(0, str4, null, eVar);
        } else if (i == 2) {
            iVar = new c(0, str4, null, eVar);
        }
        if (iVar != null) {
            iVar.a(lVar);
            m.a(iVar);
        }
    }

    public static void a(File file, String str, e eVar) {
        m.a().a(file, str, eVar);
    }

    private void b(int i, String str, b bVar, e eVar) {
        b(i, str, bVar, new com.anythink.expressad.foundation.g.f.b(), eVar);
    }

    private void b(int i, String str, b bVar, l lVar, e eVar) {
        i gVar;
        b bVar2 = bVar;
        if (bVar == null) {
            try {
                bVar2 = new b();
            } catch (Exception e) {
                o.a(b, e.getMessage());
            }
        }
        bVar = bVar2;
        a(str, bVar2);
        bVar = bVar2;
        if (i == 0) {
            gVar = new g(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", "application/x-www-form-urlencoded");
        } else if (i == 1) {
            gVar = new d(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", "application/x-www-form-urlencoded");
        } else if (i != 2) {
            gVar = null;
        } else {
            gVar = new c(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        if (gVar != null) {
            gVar.a(lVar);
            m.a(gVar);
        }
    }

    public void a(String str, b bVar) {
        if (bVar != null) {
            bVar.a("open", com.anythink.expressad.foundation.g.a.cy);
            StringBuilder sb = new StringBuilder();
            com.anythink.expressad.foundation.g.f.a.a();
            sb.append(com.anythink.expressad.foundation.g.f.a.b());
            bVar.a("band_width", sb.toString());
            String str2 = bVar.b().get("unit_id");
            if (str2 != null) {
                String a2 = k.a().a(str2, str);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                bVar.a("ch_info", a2);
            }
        }
    }

    public final void a(String str, b bVar, e eVar) {
        com.anythink.expressad.foundation.g.f.b bVar2 = new com.anythink.expressad.foundation.g.f.b();
        b bVar3 = bVar;
        if (bVar == null) {
            try {
                bVar3 = new b();
            } catch (Exception e) {
                o.a(b, e.getMessage());
            }
        }
        b bVar4 = bVar3;
        a(str, bVar3);
        b bVar5 = bVar3;
        String str2 = bVar3.b().get("sign");
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        b bVar6 = bVar3;
        bVar3.a("ts", String.valueOf(currentTimeMillis));
        b bVar7 = bVar3;
        StringBuilder sb = new StringBuilder();
        b bVar8 = bVar3;
        sb.append(str3);
        b bVar9 = bVar3;
        sb.append(currentTimeMillis);
        bVar = bVar3;
        bVar3.a("st", p.a(sb.toString()));
        bVar = bVar3;
        g gVar = new g(0, str + "?" + bVar.toString(), null, eVar);
        gVar.a((l) bVar2);
        m.a(gVar);
    }
}
