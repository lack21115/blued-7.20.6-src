package com.opos.mobad.a;

import android.content.Context;
import com.opos.mobad.model.e.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/a/e.class */
public class e {
    public static final com.opos.mobad.n.a a(Context context, a.C0707a c0707a) {
        if (c0707a == null) {
            return null;
        }
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), c0707a.f26483c.b(), c0707a.b.P(), null);
        com.opos.mobad.n.a aVar = a2;
        if (a2 == null) {
            int i = 0;
            int d = c0707a.f26483c.d();
            if (d == 2) {
                i = 2;
            } else if (d == 3) {
                i = 1;
            } else if (d == 6) {
                i = 3;
            } else if (d == 7) {
                i = 4;
            } else if (d == 8) {
                i = 53;
            }
            aVar = com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), i, c0707a.b.P(), null);
        }
        com.opos.mobad.a.a.a aVar2 = null;
        if (aVar != null) {
            aVar2 = new com.opos.mobad.a.a.a(context.getApplicationContext(), aVar);
        }
        return aVar2;
    }
}
