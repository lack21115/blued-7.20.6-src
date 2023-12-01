package com.opos.mobad.f.a.a;

import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, e.a> f12359a = new HashMap<>();

    public j(List<e.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e.a aVar : list) {
            this.f12359a.put(Integer.valueOf(aVar.f13613a), aVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
        if (r0 != 6) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T extends com.opos.mobad.ad.b> void a(int r6, java.util.Map<java.lang.Integer, T> r7) {
        /*
            r5 = this;
            r0 = r7
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
        Lc:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lf0
            r0 = r7
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r10 = r0
            r0 = r10
            if (r0 == 0) goto Lc
            r0 = r10
            java.lang.Object r0 = r0.getValue()
            com.opos.mobad.ad.b r0 = (com.opos.mobad.ad.b) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto Lc
            r0 = r6
            r1 = r10
            java.lang.Object r1 = r1.getKey()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r0 != r1) goto L7a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            java.lang.String r1 = "notify win "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            r1 = r10
            java.lang.Object r1 = r1.getKey()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "delegator"
            r1 = r12
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r11
            r1 = 0
            r0.b(r1)
            goto Lc
        L7a:
            r0 = 4
            r8 = r0
            r0 = r11
            int r0 = r0.d()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Laa
            r0 = r9
            r1 = 1
            if (r0 == r1) goto La5
            r0 = r9
            r1 = 2
            if (r0 == r1) goto La0
            r0 = r9
            r1 = 6
            if (r0 == r1) goto La5
            goto Lac
        La0:
            r0 = 1
            r8 = r0
            goto Lac
        La5:
            r0 = 2
            r8 = r0
            goto Lac
        Laa:
            r0 = 3
            r8 = r0
        Lac:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            java.lang.String r1 = "notify loss "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            r1 = r10
            java.lang.Object r1 = r1.getKey()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r12
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "delegator"
            r1 = r12
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r11
            r1 = r8
            r2 = 0
            r3 = 0
            r0.a(r1, r2, r3)
            goto Lc
        Lf0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.a.j.a(int, java.util.Map):void");
    }

    public <T extends com.opos.mobad.ad.b> e.a a(Map<Integer, T> map) {
        T value;
        Iterator<Map.Entry<Integer, T>> it = map.entrySet().iterator();
        int i = 0;
        int i2 = -1;
        while (true) {
            e.a aVar = null;
            if (!it.hasNext()) {
                com.opos.cmn.an.f.a.b("delegator", "biding result:" + i2);
                if (i2 != -1) {
                    a(i2, map);
                    aVar = this.f12359a.get(Integer.valueOf(i2));
                }
                return aVar;
            }
            Map.Entry<Integer, T> next = it.next();
            if (next != null && (value = next.getValue()) != null && value.e()) {
                int f = value.f();
                int i3 = f;
                if (f <= 0) {
                    com.opos.cmn.an.f.a.b("delegator", "bidding channel:" + next.getKey() + "real fail, use default");
                    e.a aVar2 = this.f12359a.get(next.getKey());
                    i3 = f;
                    if (aVar2 != null) {
                        i3 = aVar2.g;
                    }
                }
                if (i3 <= 0) {
                    com.opos.cmn.an.f.a.b("delegator", "biding with fail result");
                    return null;
                } else if (i > i3) {
                    com.opos.cmn.an.f.a.b("delegator", "biding fail by compare:" + next.getKey());
                } else if (i != i3) {
                    i2 = next.getKey().intValue();
                    i = i3;
                } else if (next.getKey().intValue() == 1) {
                    i2 = next.getKey().intValue();
                }
            }
        }
    }
}
