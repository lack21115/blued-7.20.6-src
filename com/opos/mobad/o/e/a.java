package com.opos.mobad.o.e;

import android.content.Context;
import com.opos.mobad.n.e.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/e/a.class */
public class a {
    public static int a(int i) {
        return com.opos.mobad.service.c.b.a().c(i);
    }

    public static com.opos.mobad.n.a a(Context context, int i, int i2) {
        if (a(i) == 0) {
            return i2 == 1 ? new h(context, i) : new com.opos.mobad.n.e.a(context, i);
        }
        return null;
    }
}
