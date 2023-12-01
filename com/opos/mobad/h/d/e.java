package com.opos.mobad.h.d;

import android.content.Context;
import com.opos.mobad.model.e.a;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/d/e.class */
public class e {
    public static final com.opos.mobad.n.a a(Context context, a.C0537a c0537a, a.InterfaceC0538a interfaceC0538a) {
        if (c0537a == null) {
            return null;
        }
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), c0537a.f12795c.b(), c0537a.b.P(), interfaceC0538a);
        b bVar = a2;
        if (a2 == null) {
            int d = c0537a.f12795c.d();
            if (d == 6) {
                d dVar = new d(context, interfaceC0538a);
                dVar.e(c0537a.b);
                bVar = dVar;
            } else if (d == 7) {
                c cVar = new c(context, interfaceC0538a);
                cVar.e(c0537a.b);
                bVar = cVar;
            } else if (d != 8) {
                int ae = c0537a.f12795c.ae();
                if (ae == 60 || ae == 63) {
                    return com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), 85, c0537a.b.P(), interfaceC0538a);
                }
                bVar = a2;
            } else {
                b bVar2 = new b(context, interfaceC0538a);
                bVar2.e(c0537a.b);
                bVar = bVar2;
            }
        }
        return bVar;
    }
}
