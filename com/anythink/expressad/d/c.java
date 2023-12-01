package com.anythink.expressad.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/d/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7145a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7146c = 3;
    public static final int d = 3;
    private String A;
    private int B;
    private long C;
    private long D;
    private int F;
    private int G;
    private int H;
    private int N;
    private int P;
    private int Q;
    private int e;
    private int f;
    private int g;
    private String i;
    private String j;
    private List<Integer> k;
    private long l;
    private int n;
    private List<Integer> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private String t;
    private int u;
    private int x;
    private int y;
    private long z;
    private int h = 30;
    private int m = 1;
    private int v = 1;
    private int w = 5000;
    private int E = 60;
    private String I = "";
    private int J = 10;
    private int K = 60;
    private double L = 1.0d;
    private int M = 1;
    private int O = 0;

    private int A() {
        return this.H;
    }

    private int B() {
        return this.M;
    }

    private int C() {
        return this.Q;
    }

    private String D() {
        return this.t;
    }

    private int E() {
        return this.u;
    }

    private int F() {
        return this.P;
    }

    private long G() {
        return this.C;
    }

    private long H() {
        return this.D;
    }

    private String I() {
        return this.A;
    }

    private int J() {
        return this.B;
    }

    private int K() {
        return this.e;
    }

    private int L() {
        return this.f;
    }

    private int M() {
        return this.g;
    }

    private int N() {
        int i = this.h;
        if (i <= 0 || i > 100) {
            this.h = 30;
        }
        return this.h;
    }

    private static c O() {
        return new c();
    }

    private int P() {
        return this.s;
    }

    private int Q() {
        return this.v;
    }

    private int R() {
        return this.w;
    }

    private int S() {
        return this.p;
    }

    private int T() {
        return this.q;
    }

    private int U() {
        return this.r;
    }

    private String V() {
        return this.i;
    }

    private List<Integer> W() {
        return this.k;
    }

    private List<Integer> X() {
        return this.o;
    }

    private long Y() {
        return this.l;
    }

    private int Z() {
        return this.n;
    }

    private void a(double d2) {
        this.L = d2;
    }

    private void a(long j) {
        this.C = j;
    }

    private String aa() {
        return this.I;
    }

    private int ab() {
        return this.J;
    }

    private int ac() {
        return this.K;
    }

    public static c b(String str) {
        c cVar;
        c cVar2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                c cVar3 = new c();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    cVar3.i = jSONObject.optString("unitId");
                    JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= optJSONArray.length()) {
                                break;
                            }
                            arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                            i = i2 + 1;
                        }
                        cVar3.k = arrayList;
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= optJSONArray2.length()) {
                                break;
                            }
                            arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i4)));
                            i3 = i4 + 1;
                        }
                        cVar3.o = arrayList2;
                    }
                    cVar3.p = jSONObject.optInt(com.anythink.expressad.d.a.b.J);
                    cVar3.q = jSONObject.optInt("aqn");
                    cVar3.r = jSONObject.optInt("acn");
                    cVar3.s = jSONObject.optInt(com.anythink.expressad.d.a.b.R);
                    cVar3.v = jSONObject.optInt(com.anythink.expressad.d.a.b.S, 1);
                    cVar3.w = jSONObject.optInt(com.anythink.expressad.d.a.b.T, 5000);
                    cVar3.l = jSONObject.optLong("current_time");
                    cVar3.m = jSONObject.optInt("offset");
                    cVar3.z = jSONObject.optLong("dlct", com.anythink.expressad.d.a.b.P);
                    cVar3.x = jSONObject.optInt(com.anythink.expressad.d.a.b.aX, 0);
                    cVar3.y = jSONObject.optInt("dlnet", 2);
                    cVar3.A = jSONObject.optString(com.anythink.expressad.d.a.b.aL);
                    cVar3.B = jSONObject.optInt(com.anythink.expressad.d.a.b.aM);
                    cVar3.C = jSONObject.optLong(com.anythink.expressad.d.a.b.aN, 86400L);
                    cVar3.D = jSONObject.optLong(com.anythink.expressad.d.a.b.aO, 300L);
                    cVar3.c(jSONObject.optInt("ready_rate", 100));
                    cVar3.d(jSONObject.optInt("cd_rate", 0));
                    cVar3.P = jSONObject.optInt("content", 1);
                    cVar3.Q = jSONObject.optInt(com.anythink.expressad.d.a.b.bC, 0);
                    cVar3.u = jSONObject.optInt(com.anythink.expressad.d.a.b.cf, 1);
                    cVar3.t = jSONObject.optString(com.anythink.expressad.d.a.b.cd, "");
                    cVar3.e = jSONObject.optInt("playclosebtn_tm", -1);
                    cVar3.f = jSONObject.optInt("play_ctdown", 0);
                    cVar3.g = jSONObject.optInt("close_alert", 0);
                    cVar3.h = jSONObject.optInt(com.anythink.expressad.d.a.b.cr, 30);
                    cVar3.E = jSONObject.optInt(com.anythink.expressad.d.a.b.db, 60);
                    cVar3.F = jSONObject.optInt(com.anythink.expressad.d.a.b.dd, 0);
                    int optInt = jSONObject.optInt("tmorl", 1);
                    int i5 = 1;
                    if (optInt <= 2) {
                        i5 = optInt <= 0 ? 1 : optInt;
                    }
                    cVar3.M = i5;
                    cVar3.I = jSONObject.optString("placementid", "");
                    cVar3.J = jSONObject.optInt("ltafemty", 10);
                    cVar3.K = jSONObject.optInt("ltorwc", 60);
                    return cVar3;
                } catch (Exception e) {
                    cVar = cVar3;
                    e = e;
                    e.printStackTrace();
                    cVar2 = cVar;
                    return cVar2;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cVar = null;
        }
        return cVar2;
    }

    private void b(long j) {
        this.D = j;
    }

    public static c c(String str) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        cVar.m = 1;
        cVar.i = str;
        cVar.k = arrayList;
        cVar.o = arrayList2;
        cVar.p = 1;
        cVar.r = -2;
        cVar.q = -2;
        cVar.s = 5;
        cVar.z = com.anythink.expressad.d.a.b.P;
        cVar.y = 2;
        cVar.x = 1;
        cVar.c(100);
        cVar.d(0);
        cVar.P = 1;
        cVar.Q = 0;
        cVar.E = 60;
        cVar.J = 10;
        cVar.K = 60;
        return cVar;
    }

    private static Queue<Integer> c(List<Integer> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (Integer num : list) {
                        if (num != null) {
                            linkedList.add(num);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    private void c(long j) {
        this.l = j;
    }

    public static c d(String str) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            cVar.k = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            cVar.o = arrayList2;
            cVar.i = str;
            cVar.m = 1;
            cVar.p = 1;
            cVar.r = -2;
            cVar.q = -2;
            cVar.s = 5;
            cVar.z = com.anythink.expressad.d.a.b.P;
            cVar.y = 2;
            cVar.x = 3;
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }

    private Queue<Integer> d(List<Integer> list) {
        LinkedList linkedList = new LinkedList();
        try {
            if (this.k != null && this.k.size() > 0) {
                for (Integer num : list) {
                    if (num != null) {
                        linkedList.add(Integer.valueOf(num.intValue() * 1000));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkedList;
    }

    private void e(int i) {
        this.M = i;
    }

    private void f(int i) {
        this.F = i;
    }

    private void f(String str) {
        this.t = str;
    }

    private void g(int i) {
        this.u = i;
    }

    private void g(String str) {
        this.A = str;
    }

    private void h(int i) {
        this.B = i;
    }

    private void i(int i) {
        this.e = i;
    }

    private void j(int i) {
        this.f = i;
    }

    private void k(int i) {
        this.g = i;
    }

    private void l(int i) {
        this.h = i;
    }

    private void m(int i) {
        this.v = i;
    }

    private void n(int i) {
        this.w = i;
    }

    public static c y() {
        c cVar = new c();
        cVar.x = 0;
        return cVar;
    }

    private int z() {
        return this.G;
    }

    public final double a() {
        return this.L;
    }

    public final void a(int i) {
        this.G = i;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void a(List<Integer> list) {
        this.k = list;
    }

    public final int b() {
        return this.E;
    }

    public final void b(int i) {
        this.H = i;
    }

    public final void b(List<Integer> list) {
        this.o = list;
    }

    public final void c() {
        this.E = 60;
    }

    public final void c(int i) {
        try {
            this.N = i;
        } catch (Exception e) {
            this.N = 100;
        }
    }

    public final int d() {
        return this.F;
    }

    public final void d(int i) {
        try {
            this.O = i;
        } catch (Exception e) {
            this.O = 0;
        }
    }

    public final void e() {
        this.Q = 0;
    }

    public final void e(String str) {
        this.I = str;
    }

    public final int f() {
        return this.N;
    }

    public final int g() {
        return this.O;
    }

    public final void h() {
        this.P = 1;
    }

    public final long i() {
        return this.z;
    }

    public final void j() {
        this.y = 2;
    }

    public final int k() {
        return this.x;
    }

    public final void l() {
        this.x = 1;
    }

    public final int m() {
        return this.y;
    }

    public final void n() {
        this.z = com.anythink.expressad.d.a.b.P;
    }

    public final void o() {
        this.s = 5;
    }

    public final void p() {
        this.p = 1;
    }

    public final void q() {
        this.q = -2;
    }

    public final void r() {
        this.r = -2;
    }

    public final JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.k != null && this.k.size() > 0) {
                int size = this.k.size();
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    jSONArray.put(this.k.get(i2));
                    i = i2 + 1;
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            if (this.o != null && this.o.size() > 0) {
                int size2 = this.o.size();
                JSONArray jSONArray2 = new JSONArray();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    jSONArray2.put(this.o.get(i4));
                    i3 = i4 + 1;
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put(com.anythink.expressad.d.a.b.J, this.p);
            jSONObject.put("aqn", this.q);
            jSONObject.put("acn", this.r);
            jSONObject.put(com.anythink.expressad.d.a.b.R, this.s);
            jSONObject.put("current_time", this.l);
            jSONObject.put("offset", this.m);
            jSONObject.put("dlct", this.z);
            jSONObject.put(com.anythink.expressad.d.a.b.aX, this.x);
            jSONObject.put("dlnet", this.y);
            jSONObject.put(com.anythink.expressad.d.a.b.aL, this.A);
            jSONObject.put(com.anythink.expressad.d.a.b.aM, this.B);
            jSONObject.put(com.anythink.expressad.d.a.b.aN, this.C);
            jSONObject.put(com.anythink.expressad.d.a.b.aO, this.D);
            jSONObject.put("ready_rate", this.N);
            jSONObject.put("content", this.P);
            jSONObject.put(com.anythink.expressad.d.a.b.bC, this.Q);
            jSONObject.put(com.anythink.expressad.d.a.b.cf, this.u);
            jSONObject.put(com.anythink.expressad.d.a.b.cd, this.t);
            jSONObject.put("playclosebtn_tm", this.e);
            jSONObject.put("play_ctdown", this.f);
            jSONObject.put("close_alert", this.g);
            jSONObject.put(com.anythink.expressad.d.a.b.dd, this.F);
            jSONObject.put(com.anythink.expressad.d.a.b.db, this.E);
            jSONObject.put("countdown", this.H);
            jSONObject.put(com.anythink.expressad.d.a.b.dm, this.G);
            jSONObject.put("tmorl", this.M);
            jSONObject.put("unitId", this.i);
            jSONObject.put("placementid", this.I);
            jSONObject.put("ltafemty", this.J);
            jSONObject.put("ltorwc", this.K);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final int t() {
        return this.m;
    }

    public final String toString() {
        List<Integer> list = this.k;
        String str = "";
        String str2 = str;
        if (list != null) {
            str2 = str;
            if (list.size() > 0) {
                Iterator<Integer> it = this.k.iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str + it.next() + ",";
                }
            }
        }
        return "offset = " + this.m + " unitId = " + this.i + " fbPlacementId = " + this.j + str2;
    }

    public final void u() {
        this.m = 1;
    }

    public final void v() {
        this.n = 2;
    }

    public final void w() {
        this.J = 10;
    }

    public final void x() {
        this.K = 60;
    }
}
