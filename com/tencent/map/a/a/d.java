package com.tencent.map.a.a;

import com.tencent.map.b.h;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/a/a/d.class */
public class d {
    private long A;

    /* renamed from: a  reason: collision with root package name */
    public int f23507a;
    public double b;

    /* renamed from: c  reason: collision with root package name */
    public double f23508c;
    public double d;
    public double e;
    public double f;
    public double g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public ArrayList<c> w;
    public boolean x;
    public int y;
    public int z;

    public d() {
        this.f23507a = 1;
        this.b = 0.0d;
        this.f23508c = 0.0d;
        this.d = -1.0d;
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = 0;
        this.z = -1;
        this.A = -1L;
        this.e = 0.0d;
        this.d = 0.0d;
        this.f23508c = 0.0d;
        this.b = 0.0d;
        this.p = null;
        this.o = null;
        this.n = null;
        this.m = null;
        this.x = false;
        this.A = System.currentTimeMillis();
        this.y = 0;
        this.z = -1;
        this.w = null;
    }

    public d(d dVar) {
        this.f23507a = 1;
        this.b = 0.0d;
        this.f23508c = 0.0d;
        this.d = -1.0d;
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = 0;
        this.z = -1;
        this.A = -1L;
        this.f23507a = dVar.f23507a;
        this.b = dVar.b;
        this.f23508c = dVar.f23508c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.x = dVar.x;
        this.i = dVar.i;
        this.h = 0;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.o = dVar.o;
        this.p = dVar.p;
        this.q = dVar.q;
        this.r = dVar.r;
        this.s = dVar.s;
        this.t = dVar.t;
        this.u = dVar.u;
        this.v = dVar.v;
        this.A = dVar.a();
        this.y = dVar.y;
        this.z = dVar.z;
        this.w = null;
        if (dVar.w != null) {
            this.w = new ArrayList<>();
            Iterator<c> it = dVar.w.iterator();
            while (it.hasNext()) {
                this.w.add(it.next());
            }
        }
    }

    public long a() {
        return this.A;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r1 = "Unknown"
            r0.l = r1
            r0 = r4
            java.lang.String r1 = "Unknown"
            r0.k = r1
            r0 = r4
            java.lang.String r1 = "Unknown"
            r0.j = r1
            r0 = r4
            java.lang.String r1 = "Unknown"
            r0.i = r1
            r0 = r5
            if (r0 != 0) goto L1d
            return
        L1d:
            r0 = r5
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L29
            return
        L29:
            r0 = r7
            int r0 = r0.length
            r6 = r0
            r0 = r6
            if (r0 <= 0) goto L37
            r0 = r4
            r1 = r7
            r2 = 0
            r1 = r1[r2]
            r0.i = r1
        L37:
            r0 = r6
            r1 = 1
            if (r0 <= r1) goto L43
            r0 = r4
            r1 = r7
            r2 = 1
            r1 = r1[r2]
            r0.j = r1
        L43:
            r0 = r6
            r1 = 3
            if (r0 != r1) goto L54
            r0 = r7
            r1 = 1
            r0 = r0[r1]
            r5 = r0
        L4c:
            r0 = r4
            r1 = r5
            r0.k = r1
            goto L60
        L54:
            r0 = r6
            r1 = 3
            if (r0 <= r1) goto L60
            r0 = r7
            r1 = 2
            r0 = r0[r1]
            r5 = r0
            goto L4c
        L60:
            r0 = r6
            r1 = 3
            if (r0 != r1) goto L6d
            r0 = r4
            r1 = r7
            r2 = 2
            r1 = r1[r2]
            r0.l = r1
            return
        L6d:
            r0 = r6
            r1 = 3
            if (r0 <= r1) goto L79
            r0 = r4
            r1 = r7
            r2 = 3
            r1 = r1[r2]
            r0.l = r1
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.a.a.d.a(java.lang.String):void");
    }

    public String toString() {
        String str;
        ArrayList<c> arrayList;
        StringBuilder sb = new StringBuilder();
        sb.append(this.z);
        sb.append(" ");
        sb.append(this.y);
        sb.append(" ");
        sb.append(this.x ? "Mars" : "WGS84");
        sb.append(" ");
        sb.append(this.f23507a == 0 ? "GPS" : "Network");
        sb.append("\n");
        sb.append(this.b);
        sb.append(" ");
        sb.append(this.f23508c);
        sb.append("\n");
        sb.append(this.d);
        sb.append(" ");
        sb.append(this.e);
        sb.append("\n");
        sb.append(this.f);
        sb.append(" ");
        sb.append(this.g);
        sb.append("\n");
        int i = this.z;
        if (i == 3 || i == 4) {
            sb.append(this.i);
            sb.append(" ");
            sb.append(this.j);
            sb.append(" ");
            sb.append(this.k);
            sb.append(" ");
            sb.append(this.l);
            sb.append(" ");
            sb.append(this.m);
            sb.append(" ");
            sb.append(this.n);
            sb.append(" ");
            sb.append(this.o);
            sb.append(" ");
            sb.append(this.p);
            sb.append("\n");
        }
        if (this.z == 4 && (arrayList = this.w) != null) {
            sb.append(arrayList.size());
            sb.append("\n");
            Iterator<c> it = this.w.iterator();
            while (it.hasNext()) {
                c next = it.next();
                sb.append(next.f23505a);
                sb.append(",");
                sb.append(next.b);
                sb.append(",");
                sb.append(next.f23506c);
                sb.append(",");
                sb.append(next.d);
                sb.append(",");
                sb.append(next.e);
                sb.append(",");
                sb.append(next.f);
                sb.append("\n");
            }
        }
        if (this.z == 7) {
            int i2 = this.h;
            if (i2 == 0) {
                sb.append(this.i);
                sb.append(" ");
                sb.append(this.j);
                sb.append(" ");
                sb.append(this.k);
                sb.append(" ");
                sb.append(this.l);
                sb.append(" ");
                sb.append(this.m);
                sb.append(" ");
                sb.append(this.n);
                sb.append(" ");
                sb.append(this.o);
                sb.append(" ");
                str = this.p;
            } else if (i2 == 1) {
                sb.append(this.i);
                sb.append(" ");
                sb.append(this.q);
                sb.append(" ");
                sb.append(this.r);
                sb.append(" ");
                sb.append(this.s);
                sb.append(" ");
                sb.append(this.t);
                sb.append(" ");
                sb.append(this.u);
                sb.append(" ");
                str = this.v;
            }
            sb.append(str);
            sb.append("\n");
        }
        h.a(sb.toString());
        return sb.toString();
    }
}
