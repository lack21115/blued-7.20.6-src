package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a/d.class */
final class d extends b {
    private long b;

    public d() {
        super(null);
        this.b = com.anythink.expressad.exoplayer.b.b;
    }

    private static Object a(m mVar, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i != 11) {
                                    return null;
                                }
                                return i(mVar);
                            }
                            return f(mVar);
                        }
                        return h(mVar);
                    }
                    return g(mVar);
                }
                return e(mVar);
            }
            return c(mVar);
        }
        return d(mVar);
    }

    private static int b(m mVar) {
        return mVar.g();
    }

    private static Boolean c(m mVar) {
        boolean z = true;
        if (mVar.g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double d(m mVar) {
        return Double.valueOf(Double.longBitsToDouble(mVar.q()));
    }

    private static String e(m mVar) {
        int h = mVar.h();
        int d = mVar.d();
        mVar.d(h);
        return new String(mVar.f25496a, d, h);
    }

    private static ArrayList<Object> f(m mVar) {
        int u = mVar.u();
        ArrayList<Object> arrayList = new ArrayList<>(u);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= u) {
                return arrayList;
            }
            arrayList.add(a(mVar, b(mVar)));
            i = i2 + 1;
        }
    }

    private static HashMap<String, Object> g(m mVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String e = e(mVar);
            int b = b(mVar);
            if (b == 9) {
                return hashMap;
            }
            hashMap.put(e, a(mVar, b));
        }
    }

    private static HashMap<String, Object> h(m mVar) {
        int u = mVar.u();
        HashMap<String, Object> hashMap = new HashMap<>(u);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= u) {
                return hashMap;
            }
            hashMap.put(e(mVar), a(mVar, b(mVar)));
            i = i2 + 1;
        }
    }

    private static Date i(m mVar) {
        Date date = new Date((long) d(mVar).doubleValue());
        mVar.d(2);
        return date;
    }

    public long a() {
        return this.b;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(m mVar) {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(m mVar, long j) {
        if (b(mVar) != 2) {
            throw new o();
        }
        if ("onMetaData".equals(e(mVar)) && b(mVar) == 8) {
            HashMap<String, Object> h = h(mVar);
            if (h.containsKey("duration")) {
                double doubleValue = ((Double) h.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }
}
