package com.opos.mobad.f.a.a;

import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private List<e.a> f12368a;
    private HashMap<Integer, e.a> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(List<e.a> list) {
        this.f12368a = list;
        for (e.a aVar : this.f12368a) {
            this.b.put(Integer.valueOf(aVar.f13613a), aVar);
        }
    }

    private static final int a(int i) {
        if (i <= 0) {
            return 1;
        }
        int i2 = i;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i2 < 10) {
                return i4 * 1;
            }
            if (i2 < 100) {
                return i4 * 10;
            }
            if (i2 < 1000) {
                return i4 * 100;
            }
            if (i2 < 10000) {
                return i4 * 1000;
            }
            i2 /= 10000;
            i3 = i4 * 10000;
        }
    }

    public e.a a(int i, com.opos.cmn.i.e<e.a, Boolean> eVar) {
        e.a aVar;
        String str;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            aVar = null;
            if (i2 >= 100) {
                str = "rank max";
                break;
            }
            int a2 = (int) (a(i3) / Math.pow(10.0d, i5 - 1));
            if (a2 <= 0) {
                str = "rank select but filter <= 0";
                break;
            }
            i3 %= a2;
            if (i3 <= 0) {
                str = "rank select but rank <= 0";
                break;
            }
            int a3 = i3 / a(i3);
            e.a aVar2 = this.b.get(Integer.valueOf(a3));
            if (aVar2 != null) {
                com.opos.cmn.an.f.a.b("delegator", "select but entity null:" + a3);
                aVar = aVar2;
                if (eVar.a(aVar2).booleanValue()) {
                    break;
                }
            }
            i2++;
            i4 = i5 + 1;
        }
        com.opos.cmn.an.f.a.b("delegator", str);
        return aVar;
    }

    public void a() {
    }
}
