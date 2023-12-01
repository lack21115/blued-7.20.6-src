package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.internal.k8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8.class */
public class z8 extends k8 {
    public static final int A = 2;
    private static ThreadLocal<f> B = new ThreadLocal<>();
    private static final ThreadLocal<ArrayList<z8>> C = new a();
    private static final ThreadLocal<ArrayList<z8>> D = new b();
    private static final ThreadLocal<ArrayList<z8>> E = new c();
    private static final ThreadLocal<ArrayList<z8>> F = new d();
    private static final ThreadLocal<ArrayList<z8>> G = new e();
    private static final Interpolator H = new LinearInterpolator();
    private static long I = 10;
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = -1;
    private static final long v = 10;
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 0;
    public static final int z = 1;

    /* renamed from: c  reason: collision with root package name */
    public long f24456c;
    private long i;
    public v8[] s;
    public HashMap<Integer, v8> t;
    public h8 u;
    public long d = -1;
    private boolean e = false;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = false;
    public int j = 0;
    private boolean k = false;
    private boolean l = false;
    private long m = 300;
    private long n = 0;
    private int o = 0;
    private int p = 1;
    private Interpolator q = H;
    private ArrayList<g> r = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$a.class */
    public static final class a extends ThreadLocal<ArrayList<z8>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<z8> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$b.class */
    public static final class b extends ThreadLocal<ArrayList<z8>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<z8> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$c.class */
    public static final class c extends ThreadLocal<ArrayList<z8>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<z8> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$d.class */
    public static final class d extends ThreadLocal<ArrayList<z8>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<z8> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$e.class */
    public static final class e extends ThreadLocal<ArrayList<z8>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<z8> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$f.class */
    public static class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) z8.C.get();
            ArrayList arrayList2 = (ArrayList) z8.E.get();
            int i = message.what;
            if (i == 0) {
                ArrayList arrayList3 = (ArrayList) z8.D.get();
                boolean z2 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (true) {
                    z = z2;
                    if (arrayList3.size() <= 0) {
                        break;
                    }
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < size) {
                            z8 z8Var = (z8) arrayList4.get(i3);
                            if (z8Var.n == 0) {
                                z8Var.D();
                            } else {
                                arrayList2.add(z8Var);
                            }
                            i2 = i3 + 1;
                        }
                    }
                }
            } else if (i != 1) {
                return;
            } else {
                z = true;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            ArrayList arrayList5 = (ArrayList) z8.G.get();
            ArrayList arrayList6 = (ArrayList) z8.F.get();
            int size2 = arrayList2.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size2) {
                    break;
                }
                z8 z8Var2 = (z8) arrayList2.get(i5);
                if (z8Var2.d(uptimeMillis)) {
                    arrayList5.add(z8Var2);
                }
                i4 = i5 + 1;
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= size3) {
                        break;
                    }
                    z8 z8Var3 = (z8) arrayList5.get(i7);
                    z8Var3.D();
                    z8Var3.k = true;
                    arrayList2.remove(z8Var3);
                    i6 = i7 + 1;
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i8 = 0;
            while (i8 < size4) {
                z8 z8Var4 = (z8) arrayList.get(i8);
                if (z8Var4.c(uptimeMillis)) {
                    arrayList6.add(z8Var4);
                }
                if (arrayList.size() == size4) {
                    i8++;
                } else {
                    size4--;
                    arrayList6.remove(z8Var4);
                }
            }
            if (arrayList6.size() > 0) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= arrayList6.size()) {
                        break;
                    }
                    ((z8) arrayList6.get(i10)).r();
                    i9 = i10 + 1;
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, z8.I - (SystemClock.uptimeMillis() - uptimeMillis)));
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z8$g.class */
    public interface g {
        void a(z8 z8Var);
    }

    public z8(h8 h8Var) {
        this.u = h8Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ArrayList<k8.a> arrayList;
        C.get().add(this);
        if (this.n <= 0 || (arrayList = this.b) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ((k8.a) arrayList2.get(i2)).d(this);
            i = i2 + 1;
        }
    }

    public static z8 a(h8 h8Var, y8<?> y8Var, Object[] objArr) {
        z8 z8Var = new z8(h8Var);
        z8Var.a(objArr);
        z8Var.a(y8Var);
        return z8Var;
    }

    public static z8 a(h8 h8Var, double... dArr) {
        z8 z8Var = new z8(h8Var);
        z8Var.a(dArr);
        return z8Var;
    }

    public static z8 a(h8 h8Var, int... iArr) {
        z8 z8Var = new z8(h8Var);
        z8Var.a(iArr);
        return z8Var;
    }

    public static z8 a(h8 h8Var, v8... v8VarArr) {
        z8 z8Var = new z8(h8Var);
        z8Var.a(v8VarArr);
        return z8Var;
    }

    private void a(boolean z2) {
        this.e = z2;
        this.f = 0;
        this.j = 0;
        this.l = true;
        this.h = false;
        D.get().add(this);
        if (this.n == 0) {
            e(v());
            this.j = 0;
            this.k = true;
            ArrayList<k8.a> arrayList = this.b;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    ((k8.a) arrayList2.get(i2)).d(this);
                    i = i2 + 1;
                }
            }
        }
        f fVar = B.get();
        if (fVar == null) {
            fVar = new f(Looper.getMainLooper());
            B.set(fVar);
        } else {
            fVar.removeMessages(0);
            fVar.removeMessages(1);
        }
        fVar.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(long j) {
        if (!this.h) {
            this.h = true;
            this.i = j;
            return false;
        }
        long j2 = j - this.i;
        long j3 = this.n;
        if (j2 > j3) {
            this.f24456c = j - (j2 - j3);
            this.j = 1;
            return true;
        }
        return false;
    }

    public static void f(long j) {
        I = j;
    }

    public static void q() {
        C.get().clear();
        D.get().clear();
        E.get().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ArrayList<k8.a> arrayList;
        C.get().remove(this);
        D.get().remove(this);
        E.get().remove(this);
        this.j = 0;
        if (this.k && (arrayList = this.b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ((k8.a) arrayList2.get(i2)).c(this);
                i = i2 + 1;
            }
        }
        this.k = false;
        this.l = false;
    }

    public static int u() {
        return C.get().size();
    }

    public static long w() {
        return I;
    }

    public v8[] A() {
        return this.s;
    }

    public void B() {
        ArrayList<g> arrayList = this.r;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.r = null;
    }

    public void C() {
        this.e = !this.e;
        if (this.j != 1) {
            a(true);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f24456c = uptimeMillis - (this.m - (uptimeMillis - this.f24456c));
    }

    @Override // com.tencent.mapsdk.internal.k8
    public k8 a(long j) {
        if (j >= 0) {
            this.m = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    public Object a(int i) {
        v8 v8Var = this.t.get(Integer.valueOf(i));
        if (v8Var != null) {
            return v8Var.b();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void a() {
        ArrayList<k8.a> arrayList;
        if (this.j != 0 || D.get().contains(this) || E.get().contains(this)) {
            if (this.k && (arrayList = this.b) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((k8.a) it.next()).b(this);
                }
            }
            r();
        }
    }

    public void a(float f2) {
        float interpolation = this.q.getInterpolation(f2);
        this.g = interpolation;
        int length = this.s.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            this.s[i2].a(interpolation);
            h8 h8Var = this.u;
            if (h8Var != null) {
                v8[] v8VarArr = this.s;
                h8Var.a(v8VarArr[i2].b, v8VarArr[i2].b());
            }
            i = i2 + 1;
        }
        ArrayList<g> arrayList = this.r;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            this.r.get(i4).a(this);
            i3 = i4 + 1;
        }
    }

    public void a(int i, double d2) {
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.q = interpolator;
        } else {
            this.q = new LinearInterpolator();
        }
    }

    public void a(y8<?> y8Var) {
        v8[] v8VarArr;
        if (y8Var == null || (v8VarArr = this.s) == null || v8VarArr.length <= 0) {
            return;
        }
        v8VarArr[0].a(y8Var);
    }

    public void a(g gVar) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(gVar);
    }

    public void a(double... dArr) {
        if (dArr == null || dArr.length == 0) {
            return;
        }
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length == 0) {
            a(v8.a(0, dArr));
        } else {
            v8VarArr[0].a(dArr);
        }
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length == 0) {
            a(v8.a(0, iArr));
        } else {
            v8VarArr[0].a(iArr);
        }
    }

    public void a(v8... v8VarArr) {
        int length = v8VarArr.length;
        this.s = v8VarArr;
        this.t = new HashMap<>(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            v8 v8Var = v8VarArr[i2];
            this.t.put(Integer.valueOf(v8Var.c()), v8Var);
            i = i2 + 1;
        }
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length == 0) {
            a(v8.a(0, null, objArr));
        } else {
            v8VarArr[0].a(objArr);
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    /* renamed from: b */
    public k8 clone() {
        z8 z8Var = (z8) super.clone();
        ArrayList<g> arrayList = this.r;
        if (arrayList != null) {
            z8Var.r = new ArrayList<>();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                z8Var.r.add(arrayList.get(i2));
                i = i2 + 1;
            }
        }
        z8Var.d = -1L;
        z8Var.e = false;
        z8Var.f = 0;
        z8Var.j = 0;
        z8Var.h = false;
        v8[] v8VarArr = this.s;
        if (v8VarArr != null) {
            int length = v8VarArr.length;
            z8Var.s = new v8[length];
            z8Var.t = new HashMap<>(length);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                v8 clone = v8VarArr[i4].clone();
                z8Var.s[i4] = clone;
                z8Var.t.put(Integer.valueOf(clone.c()), clone);
                i3 = i4 + 1;
            }
        }
        return z8Var;
    }

    public void b(int i) {
        this.o = i;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void b(long j) {
        this.n = j;
    }

    public void b(g gVar) {
        ArrayList<g> arrayList = this.r;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gVar);
        if (this.r.size() == 0) {
            this.r = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void c() {
        if (!C.get().contains(this) && !D.get().contains(this)) {
            this.h = false;
            D();
        }
        int i = this.o;
        if (i <= 0 || (i & 1) != 1) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        r();
    }

    public void c(int i) {
        this.p = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(long r7) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.z8.c(long):boolean");
    }

    @Override // com.tencent.mapsdk.internal.k8
    public long d() {
        return this.m;
    }

    public void e(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.j != 1) {
            this.d = j;
            this.j = 2;
        }
        this.f24456c = uptimeMillis - j;
        c(uptimeMillis);
    }

    @Override // com.tencent.mapsdk.internal.k8
    public long f() {
        return this.n;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public boolean g() {
        boolean z2 = true;
        if (this.j != 1) {
            if (this.k) {
                return true;
            }
            z2 = false;
        }
        return z2;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public boolean h() {
        return this.l;
    }

    @Override // com.tencent.mapsdk.internal.k8
    public void j() {
        a(false);
    }

    public float s() {
        return this.g;
    }

    public Object t() {
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length <= 0) {
            return null;
        }
        return v8VarArr[0].b();
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        String str2 = str;
        if (this.s != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                str2 = str;
                if (i2 >= this.s.length) {
                    break;
                }
                str = str + "\n    " + this.s[i2].toString();
                i = i2 + 1;
            }
        }
        return str2;
    }

    public long v() {
        if (this.j == 0) {
            return 0L;
        }
        return SystemClock.uptimeMillis() - this.f24456c;
    }

    public Interpolator x() {
        return this.q;
    }

    public int y() {
        return this.o;
    }

    public int z() {
        return this.p;
    }
}
