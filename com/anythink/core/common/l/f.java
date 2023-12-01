package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.al;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.r;
import com.anythink.core.common.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/l/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6849a = com.anythink.core.common.h.class.getSimpleName();
    final int b;

    /* renamed from: c  reason: collision with root package name */
    int f6850c;
    int d;
    long e;
    al m;
    List<ai> n;
    private List<ai> o;
    volatile int i = 0;
    volatile int j = 0;
    volatile int k = 0;
    volatile int l = 0;
    List<ai> f = Collections.synchronizedList(new ArrayList(5));
    List<ai> g = Collections.synchronizedList(new ArrayList(5));
    List<ai> h = Collections.synchronizedList(new ArrayList(2));

    public f(g gVar) {
        this.f6850c = 1;
        this.f.addAll(gVar.d);
        if (this.n == null) {
            this.n = Collections.synchronizedList(new ArrayList());
        }
        this.n.clear();
        this.n.addAll(gVar.d);
        this.b = gVar.f6852c.am();
        this.f6850c = gVar.f6852c.k();
        this.d = gVar.f6852c.aa();
        this.e = gVar.f6852c.m();
        List<ai> b = b(gVar.d);
        if (b != null) {
            this.f.removeAll(b);
            this.h.addAll(b);
        }
        this.o = Collections.synchronizedList(new ArrayList(3));
        this.m = gVar.g;
    }

    public static String a(List<ai> list) {
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return str;
            }
            String str2 = str;
            if (i2 > 0) {
                str2 = str + ",";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i2).c());
            str = str2 + sb.toString();
            i = i2 + 1;
        }
    }

    public static void a(Context context, String str) {
        x.a(context).a(str);
    }

    public static void a(Context context, String str, String str2, ai aiVar, ai aiVar2) {
        al.a aVar;
        al.a aVar2;
        if (aiVar != null) {
            aVar2 = new al.a(aiVar);
            aVar = null;
        } else if (aiVar2 != null) {
            aVar = new al.a(aiVar2);
            aVar2 = null;
        } else {
            aVar = null;
            aVar2 = null;
        }
        x.a(context).a(str, str2, aVar2, aVar);
    }

    private void a(ai aiVar, int i, ai aiVar2) {
        m N;
        m N2;
        if (aiVar.j() && (N2 = aiVar.N()) != null) {
            if (aiVar2 != null) {
                N2.q = com.anythink.core.common.k.g.a(aiVar2);
            } else {
                N2.q = com.anythink.core.common.k.g.a(aiVar);
            }
        }
        if (i > 0) {
            ai aiVar3 = this.n.get(i - 1);
            if (!aiVar3.j() || (N = aiVar3.N()) == null) {
                return;
            }
            N.q = com.anythink.core.common.k.g.a(aiVar);
        }
    }

    public static void a(ai aiVar, com.anythink.core.common.e.e eVar, ai aiVar2, boolean z) {
        m N;
        if (aiVar2 == null || (N = aiVar.N()) == null) {
            return;
        }
        double a2 = com.anythink.core.common.k.g.a(aiVar2);
        r rVar = new r();
        rVar.f6674a = 2;
        rVar.b = a2;
        rVar.e = eVar;
        rVar.f6675c = aiVar2;
        rVar.d = aiVar;
        N.a(rVar, z);
    }

    private void a(List<ai> list, List<ai> list2) {
        int af;
        int size = list2.size();
        int size2 = this.o.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ai aiVar = list2.get(i2);
            if (aiVar.j() && (af = aiVar.af()) > 0 && af <= size2 && com.anythink.core.common.k.g.a(aiVar) < com.anythink.core.common.k.g.a(this.o.get(af - 1))) {
                list.add(aiVar);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r0 != 7) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.anythink.core.common.e.ai r3, com.anythink.core.common.l.h r4) {
        /*
            r0 = r3
            int r0 = r0.Z()
            r1 = 1
            if (r0 != r1) goto Ld
            r0 = 1
            r6 = r0
            goto Lf
        Ld:
            r0 = 0
            r6 = r0
        Lf:
            r0 = r6
            if (r0 == 0) goto L50
            r0 = r3
            int r0 = r0.l()
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L42
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L42
            r0 = r5
            r1 = 6
            if (r0 == r1) goto L31
            r0 = r5
            r1 = 7
            if (r0 == r1) goto L42
            goto L50
        L31:
            r0 = r4
            boolean r0 = r0.g
            if (r0 == 0) goto L3a
            r0 = 0
            return r0
        L3a:
            r0 = r4
            r1 = 1
            r0.g = r1
            goto L50
        L42:
            r0 = r4
            boolean r0 = r0.f
            if (r0 == 0) goto L4b
            r0 = 0
            return r0
        L4b:
            r0 = r4
            r1 = 1
            r0.f = r1
        L50:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.l.f.a(com.anythink.core.common.e.ai, com.anythink.core.common.l.h):boolean");
    }

    private static List<ai> b(List<ai> list) {
        ArrayList arrayList = null;
        for (ai aiVar : list) {
            if (aiVar.l() == 8) {
                ArrayList arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList(4);
                }
                arrayList2.add(aiVar);
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    private double i() {
        return a(false);
    }

    private double j() {
        return a(true);
    }

    public final double a(boolean z) {
        synchronized (this.o) {
            int size = this.o.size();
            if (size == 0) {
                return 0.0d;
            }
            int i = this.b - 1;
            int i2 = size - 1;
            if (!z || i2 >= i) {
                return com.anythink.core.common.k.g.a(this.o.get(Math.min(i, i2)));
            }
            return 0.0d;
        }
    }

    public final List<ai> a() {
        return this.f;
    }

    public final void a(int i) {
        if (this.f6850c == 2 && i == 1) {
            this.l--;
        }
    }

    public final void a(int i, int i2) {
        this.i += i;
        if (i2 != 2) {
            this.j += i;
        } else {
            this.k += i;
        }
    }

    public final void a(ai aiVar) {
        synchronized (this.n) {
            if (this.n != null) {
                if (this.n.size() == 0) {
                    this.n.add(aiVar);
                    a(aiVar, 0, null);
                    return;
                }
                for (int i = 0; i < this.n.size(); i++) {
                    ai aiVar2 = this.n.get(i);
                    if (com.anythink.core.common.k.g.a(aiVar) > com.anythink.core.common.k.g.a(aiVar2)) {
                        this.n.add(i, aiVar);
                        a(aiVar, i, aiVar2);
                        return;
                    }
                }
                this.n.add(aiVar);
                a(aiVar, this.n.size() - 1, null);
            }
        }
    }

    public final void a(com.anythink.core.common.e.e eVar, ai aiVar) {
        ArrayList<ai> arrayList = new ArrayList(5);
        synchronized (this.o) {
            a(arrayList, this.o);
        }
        synchronized (this.g) {
            a(arrayList, this.g);
        }
        for (ai aiVar2 : arrayList) {
            a(aiVar2, eVar, aiVar, false);
        }
    }

    public final List<ai> b() {
        return this.g;
    }

    public final List<ai> b(int i) {
        List<ai> list = i != 2 ? this.f : this.h;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            if (list.size() == 0) {
                return arrayList;
            }
            boolean z = false;
            ai aiVar = list.get(0);
            if (i == 2) {
                arrayList.add(aiVar);
            } else {
                boolean z2 = com.anythink.core.common.k.g.a(aiVar) > a(true);
                int i2 = this.f6850c;
                if (i2 == 1) {
                    if (this.j < this.d) {
                        z = true;
                    }
                    if (z && z2) {
                        arrayList.add(aiVar);
                    } else {
                        StringBuilder sb = new StringBuilder("getNextRequestList, isLessThenMaxRequestNum: ");
                        sb.append(z);
                        sb.append(", isExceedCachePrice");
                        sb.append(z2);
                    }
                } else if (i2 == 2) {
                    if (this.l == 0 && z2) {
                        double a2 = com.anythink.core.common.k.g.a(aiVar);
                        int size = list.size();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= size) {
                                break;
                            }
                            ai aiVar2 = list.get(i4);
                            if (com.anythink.core.common.k.g.a(aiVar2) == a2) {
                                arrayList.add(aiVar2);
                            }
                            i3 = i4 + 1;
                        }
                        this.l = arrayList.size();
                        new StringBuilder("getNextRequestList: same price, need request num: ").append(this.l);
                    } else {
                        new StringBuilder("getNextRequestList: The number of ad sources with the same price that did not return results: ").append(this.l);
                    }
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
        return arrayList;
    }

    public final void b(ai aiVar) {
        synchronized (this.o) {
            if (this.o.size() == 0) {
                this.o.add(aiVar);
            } else {
                double a2 = com.anythink.core.common.k.g.a(aiVar);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.o.size()) {
                        break;
                    } else if (a2 > com.anythink.core.common.k.g.a(this.o.get(i2))) {
                        this.o.add(i2, aiVar);
                        break;
                    } else if (i2 == this.o.size() - 1) {
                        this.o.add(aiVar);
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }
    }

    public final List<ai> c() {
        return this.h;
    }

    public final boolean c(ai aiVar) {
        double d;
        double a2 = com.anythink.core.common.k.g.a(aiVar);
        double a3 = a(true);
        synchronized (this.g) {
            Iterator<ai> it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    d = 0.0d;
                    break;
                }
                ai next = it.next();
                d = com.anythink.core.common.k.g.a(next);
                if (next.j() && d > com.anythink.core.common.k.g.a(aiVar)) {
                    break;
                }
            }
        }
        return a2 > Math.max(a3, d);
    }

    public final int d() {
        return this.i;
    }

    public final int e() {
        return this.j;
    }

    public final int f() {
        return this.k;
    }

    public final al g() {
        return this.m;
    }

    public final List<ai> h() {
        ArrayList b;
        int i = this.f6850c;
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            int min = Math.min(this.d, this.f.size());
            int i2 = 0;
            while (true) {
                int i3 = i2;
                b = arrayList;
                if (i3 >= min) {
                    break;
                }
                arrayList.add(this.f.get(i3));
                i2 = i3 + 1;
            }
        } else {
            b = i == 2 ? b(1) : null;
        }
        StringBuilder sb = new StringBuilder("startToRequestMediationAd: mRequestNumType: ");
        sb.append(this.f6850c);
        sb.append(", needRequestNum: ");
        int i4 = 0;
        if (b != null) {
            i4 = b.size();
        }
        sb.append(i4);
        sb.append(", validCacheNum: ");
        sb.append(this.b);
        sb.append(", mWaitingFillTime: ");
        sb.append(this.e);
        if (b.size() > 0) {
            this.f.removeAll(b);
        }
        return b;
    }
}
