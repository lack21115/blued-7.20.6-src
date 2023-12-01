package com.tencent.turingface.sdk.mfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/pZo7n.class */
public final class pZo7n {

    /* renamed from: a  reason: collision with root package name */
    public static final kwCJn<pZo7n> f39975a = new spXPg();
    public Map<String, ShGzN> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, SkEpO> f39976c = new HashMap();
    public JD1Ej d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/pZo7n$ShGzN.class */
    public final class ShGzN implements yMdp8 {

        /* renamed from: a  reason: collision with root package name */
        public int f39977a;

        /* renamed from: c  reason: collision with root package name */
        public long f39978c;
        public String e;
        public long b = -1;
        public List<wmqhz> d = new ArrayList();
        public boolean f = false;
        public boolean g = false;

        public ShGzN(String str, int i) {
            this.f39977a = i;
            this.e = str;
        }

        public final void a() {
            this.b = -1L;
            this.f39978c = 0L;
            this.d.clear();
            this.f = false;
            this.g = false;
        }

        @Override // com.tencent.turingface.sdk.mfa.yMdp8
        public final void a(QmgHg qmgHg) {
            wmqhz wmqhzVar;
            if (this.e.equals(qmgHg.m)) {
                boolean z = false;
                this.f = qmgHg.g <= 0;
                this.g = qmgHg.h == 0;
                int i = qmgHg.f;
                if (i == 0) {
                    a();
                    this.b = System.currentTimeMillis();
                    this.d.add(new wmqhz(0, qmgHg.i, qmgHg.j, qmgHg.k, qmgHg.l));
                } else if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return;
                        }
                        a();
                        return;
                    }
                    if (this.b != -1) {
                        z = true;
                    }
                    if (z) {
                        wmqhzVar = new wmqhz(2, qmgHg.i, qmgHg.j, qmgHg.k, qmgHg.l);
                    } else {
                        a();
                        wmqhzVar = new wmqhz(0, qmgHg.i, qmgHg.j, qmgHg.k, qmgHg.l);
                        this.b = System.currentTimeMillis();
                    }
                    this.d.add(wmqhzVar);
                } else {
                    this.f39978c = System.currentTimeMillis() - this.b;
                    this.d.add(new wmqhz(1, qmgHg.i, qmgHg.j, qmgHg.k, qmgHg.l));
                    pZo7n pzo7n = pZo7n.this;
                    List<wmqhz> list = this.d;
                    pzo7n.getClass();
                    ArrayList arrayList = new ArrayList();
                    if (list.size() <= 8) {
                        arrayList.addAll(list);
                    } else {
                        wmqhz wmqhzVar2 = list.get(0);
                        wmqhz wmqhzVar3 = list.get(list.size() - 1);
                        list.remove(wmqhzVar2);
                        list.remove(wmqhzVar3);
                        int ceil = (int) Math.ceil(list.size() / 6);
                        arrayList.add(wmqhzVar2);
                        int i2 = 1;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= list.size()) {
                                break;
                            }
                            arrayList.add(list.get(i3));
                            i2 = i3 + ceil;
                        }
                        arrayList.add(wmqhzVar3);
                    }
                    pZo7n pzo7n2 = pZo7n.this;
                    long j = this.b;
                    long j2 = this.f39978c;
                    pzo7n2.getClass();
                    OCkqn oCkqn = new OCkqn();
                    oCkqn.f39899c = (int) j2;
                    oCkqn.b = j;
                    ArrayList<XnM3A> arrayList2 = new ArrayList<>();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        wmqhz wmqhzVar4 = (wmqhz) it.next();
                        XnM3A xnM3A = new XnM3A();
                        int i4 = wmqhzVar4.f39980a;
                        if (i4 == 0) {
                            xnM3A.f39928a = 1;
                        } else if (i4 == 1) {
                            xnM3A.f39928a = 3;
                        } else if (i4 == 2) {
                            xnM3A.f39928a = 2;
                        } else if (i4 != 3) {
                            xnM3A.f39928a = 0;
                        } else {
                            xnM3A.f39928a = 4;
                        }
                        xnM3A.b = wmqhzVar4.b;
                        xnM3A.f39929c = wmqhzVar4.f39981c;
                        xnM3A.d = wmqhzVar4.d;
                        xnM3A.e = wmqhzVar4.e;
                        arrayList2.add(xnM3A);
                    }
                    oCkqn.d = arrayList2;
                    boolean z2 = this.f;
                    if (z2 || this.g) {
                        if (z2) {
                            oCkqn.e |= 1;
                        }
                        if (this.g) {
                            oCkqn.e |= 2;
                        }
                        pZo7n.a(pZo7n.this, this.e, this.f39977a, 2, oCkqn);
                    } else {
                        pZo7n.a(pZo7n.this, this.e, this.f39977a, 1, oCkqn);
                    }
                    a();
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/pZo7n$SkEpO.class */
    public final class SkEpO implements Ww1Z6 {

        /* renamed from: a  reason: collision with root package name */
        public int f39979a;

        public SkEpO(int i) {
            this.f39979a = i;
        }

        @Override // com.tencent.turingface.sdk.mfa.Ww1Z6
        public final void a(String str) {
            pZo7n.a(pZo7n.this, str, this.f39979a, 3, null);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/pZo7n$spXPg.class */
    public final class spXPg extends kwCJn<pZo7n> {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/pZo7n$wmqhz.class */
    public final class wmqhz {

        /* renamed from: a  reason: collision with root package name */
        public final int f39980a;
        public final float b;

        /* renamed from: c  reason: collision with root package name */
        public final float f39981c;
        public final float d;
        public final float e;

        public wmqhz(int i, float f, float f2, float f3, float f4) {
            this.f39980a = i;
            this.b = f;
            this.f39981c = f2;
            this.d = f3;
            this.e = f4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static pZo7n a() {
        pZo7n pzo7n;
        kwCJn<pZo7n> kwcjn = f39975a;
        pZo7n pzo7n2 = kwcjn.f39969a;
        pZo7n pzo7n3 = pzo7n2;
        if (pzo7n2 == null) {
            synchronized (kwcjn) {
                pZo7n pzo7n4 = kwcjn.f39969a;
                pzo7n = pzo7n4;
                if (pzo7n4 == null) {
                    T pzo7n5 = new pZo7n();
                    kwcjn.f39969a = pzo7n5;
                    pzo7n = pzo7n5;
                }
            }
            pzo7n3 = pzo7n;
        }
        return pzo7n3;
    }

    public static void a(pZo7n pzo7n, String str, int i, int i2, OCkqn oCkqn) {
        JD1Ej jD1Ej = pzo7n.d;
        if (jD1Ej != null) {
            jD1Ej.a(str, i, i2, oCkqn);
        }
    }

    public final void a(String str) {
        gELYz.f39957c.remove(this.b.get(str));
        this.b.remove(str);
        gELYz.d.remove(this.f39976c.get(str));
        this.f39976c.remove(str);
    }

    public final void a(String str, int i, JD1Ej jD1Ej) {
        this.d = jD1Ej;
        if (this.b.get(str) == null) {
            ShGzN shGzN = new ShGzN(str, i);
            this.b.put(str, shGzN);
            gELYz.f39957c.add(shGzN);
        }
        if (this.f39976c.get(str) == null) {
            SkEpO skEpO = new SkEpO(i);
            this.f39976c.put(str, skEpO);
            gELYz.d.add(skEpO);
        }
    }
}
