package com.opos.mobad.h.d;

import android.content.Context;
import com.opos.mobad.model.e.a;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/d/e.class */
public class e {
    public static final com.opos.mobad.n.a a(Context context, a.C0707a c0707a, a.InterfaceC0708a interfaceC0708a) {
        if (c0707a == null) {
            return null;
        }
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), c0707a.f26483c.b(), c0707a.b.P(), interfaceC0708a);
        b bVar = a2;
        if (a2 == null) {
            int d = c0707a.f26483c.d();
            if (d == 6) {
                d dVar = new d(context, interfaceC0708a);
                dVar.e(c0707a.b);
                bVar = dVar;
            } else if (d == 7) {
                c cVar = new c(context, interfaceC0708a);
                cVar.e(c0707a.b);
                bVar = cVar;
            } else if (d != 8) {
                int ae = c0707a.f26483c.ae();
                if (ae == 60 || ae == 63) {
                    return com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), 85, c0707a.b.P(), interfaceC0708a);
                }
                bVar = a2;
            } else {
                b bVar2 = new b(context, interfaceC0708a);
                bVar2.e(c0707a.b);
                bVar = bVar2;
            }
        }
        return bVar;
    }
}
