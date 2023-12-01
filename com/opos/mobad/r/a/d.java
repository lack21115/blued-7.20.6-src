package com.opos.mobad.r.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/r/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final com.opos.mobad.n.j.a f27259a = new com.opos.mobad.n.j.a() { // from class: com.opos.mobad.r.a.d.1
        @Override // com.opos.mobad.n.j.a
        public com.opos.mobad.c.c.a a(Context context) {
            return new b(context, null);
        }
    };
    private static final com.opos.mobad.n.j.a b = new com.opos.mobad.n.j.a() { // from class: com.opos.mobad.r.a.d.2
        @Override // com.opos.mobad.n.j.a
        public com.opos.mobad.c.c.a a(Context context) {
            return new a(context, null);
        }
    };

    public static final com.opos.mobad.c.c.a a(Context context, int i, com.opos.mobad.c.c.b bVar) {
        return 1 == i ? new b(context, bVar) : new a(context, bVar);
    }

    public static final com.opos.mobad.n.j.a a(int i) {
        return 1 == i ? f27259a : b;
    }
}
