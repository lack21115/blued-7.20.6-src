package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mapsdk.internal.za;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ra.class */
public class ra implements qa {
    private static final HashSet<String> Y = new HashSet<>();
    private static final za.k<b> Z;
    private static final AtomicInteger a0;
    private static final Map<String, Map<String, d>> b0;
    private static Pair<String, StringBuilder> c0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ra$a.class */
    public static final class a implements za.i<b> {
        @Override // com.tencent.mapsdk.internal.za.i
        /* renamed from: b */
        public b a() {
            return new b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ra$b.class */
    public static class b implements za.l {

        /* renamed from: a  reason: collision with root package name */
        private int f24046a = 3;
        private String b = "TT";

        public b a(int i) {
            ra.a0.incrementAndGet();
            this.f24046a = i;
            return this;
        }

        public b a(String str) {
            ra.a0.incrementAndGet();
            this.b = str;
            return this;
        }

        @Override // com.tencent.mapsdk.internal.za.l
        public za.p a() {
            return za.p.a();
        }

        public void a(Object... objArr) {
            ra.a0.incrementAndGet();
            ra.b(this.f24046a, this.b, objArr);
            ra.Z.a(this);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ra$c.class */
    public interface c {
        void a(String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ra$d.class */
    public static class d {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f24048c;
        private c e;
        private Map<String, Object> f;
        private String g;
        private String h;
        public List<Long> d = new CopyOnWriteArrayList();

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f24047a = new AtomicInteger(0);

        public d(String str, String str2) {
            this.b = str;
            this.f24048c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f24047a.set(0);
            this.d.clear();
            this.e = null;
            Map<String, Object> map = this.f;
            if (map != null) {
                map.clear();
            }
        }

        public void a(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f == null) {
                this.f = new Hashtable();
            }
            this.f.put(str, obj);
        }

        public boolean a(String str) {
            return this.f24048c.equals(str);
        }

        public Object b(String str) {
            Map<String, Object> map = this.f;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (!TextUtils.isEmpty(this.h)) {
                sb.append(this.h);
            }
            if (this.b.equals(this.f24048c)) {
                sb.append("|");
                sb.append(this.b);
            } else {
                sb.append("|");
                sb.append(this.b);
                sb.append("|");
                sb.append(this.f24048c);
            }
            if (!TextUtils.isEmpty(this.g)) {
                sb.append("|");
                sb.append(this.g);
            }
            sb.append("]");
            return sb.toString();
        }

        public String toString() {
            return "TraceInfo{id='" + this.f24048c + "', values=" + this.f + '}';
        }
    }

    static {
        f(ma.p);
        f(ma.b);
        f("BD");
        f(ma.t);
        Z = za.b(30, new a());
        a0 = new AtomicInteger();
        b0 = Collections.synchronizedMap(new Hashtable());
    }

    public static int a(String str, String str2, int i) {
        return a(str, c(str), str2, i);
    }

    public static int a(String str, String str2, String str3, int i) {
        int i2 = -1;
        if (e(str)) {
            Map<String, d> map = b0.get(str);
            d dVar = null;
            if (map != null) {
                dVar = map.get(str2);
            }
            if (dVar != null) {
                Object b2 = dVar.b(str3);
                i2 = 1;
                if (b2 instanceof AtomicInteger) {
                    int i3 = i;
                    if (i < 1) {
                        i3 = 1;
                    }
                    AtomicInteger atomicInteger = (AtomicInteger) b2;
                    int i4 = atomicInteger.get() + i3;
                    atomicInteger.set(i4);
                    return i4;
                }
                dVar.a(str3, new AtomicInteger(1));
            }
            return i2;
        }
        return -1;
    }

    private static long a(d dVar) {
        long j;
        long j2 = -1;
        long j3 = -1;
        if (dVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (dVar.d.size() > 0) {
                j2 = currentTimeMillis - dVar.d.get(0).longValue();
                List<Long> list = dVar.d;
                j = currentTimeMillis - list.get(list.size() - 1).longValue();
            } else {
                j = -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(dVar.b());
            sb.append("\n");
            if (dVar.f24047a.get() != 0) {
                sb.append("idx:");
                sb.append(dVar.f24047a.get());
                sb.append("\n");
            }
            if (j2 > 0) {
                sb.append("ut:");
                sb.append(j2);
                sb.append("ms\n");
            }
            if (j > 0) {
                sb.append("it:");
                sb.append(j);
                sb.append("ms\n");
            }
            if (dVar.f != null && !dVar.f.isEmpty()) {
                sb.append("val:");
                sb.append(dVar.f);
                sb.append("\n");
            }
            String sb2 = sb.toString();
            na.c("TT", sb2);
            if (dVar.e != null) {
                dVar.e.a(sb2);
            }
            a(sb2);
            j3 = j2;
        }
        return j3;
    }

    public static long a(String str, String str2, Object obj) {
        if (e(str)) {
            return a(str, c(str), "", str2, obj);
        }
        return 0L;
    }

    private static long a(String str, String str2, String str3, String str4, Object obj) {
        if (e(str)) {
            a(str, str2, str4, obj);
            d a2 = a(str, str2);
            if (a2 != null) {
                a2.h = "Log";
                a2.f24047a.incrementAndGet();
                a2.g = str3;
                a2.d.add(Long.valueOf(System.currentTimeMillis()));
            }
            return a(a2);
        }
        return 0L;
    }

    public static b a(int i) {
        a0.incrementAndGet();
        b a2 = Z.a();
        a2.f24046a = i;
        return a2;
    }

    private static d a(String str, String str2) {
        Map<String, d> map = b0.get(str);
        d dVar = map != null ? map.get(str2) : null;
        if (dVar == null || !dVar.a(str2)) {
            return null;
        }
        return dVar;
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !mi.d) {
            String str2 = null;
            List<String> g = ga.g(new File(na.a(), "kv"));
            if (g == null || g.isEmpty() || TextUtils.isEmpty(g.get(0))) {
                try {
                    String a2 = sa.a(c7.t() + mi.j + mi.i + mi.f23959c + mi.b);
                    str2 = a2;
                    na.d("kv", a2);
                    str2 = a2;
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                }
            } else {
                str2 = g.get(0);
            }
            try {
                return !TextUtils.isEmpty(str2) ? sa.b(str2, str) : "";
            } catch (GeneralSecurityException e2) {
                return "";
            }
        }
        return str;
    }

    private static void a(String str) {
        String d2 = pa.d();
        Pair<String, StringBuilder> pair = c0;
        if (pair != null && !pair.first.equals(d2)) {
            c();
        }
        if (c0 == null) {
            c0 = new Pair<>(d2, new StringBuilder());
        }
        Pair<String, StringBuilder> pair2 = c0;
        StringBuilder sb = pair2.second;
        synchronized (pair2) {
            sb.append(System.currentTimeMillis());
            sb.append(" : ");
            sb.append(str);
        }
        if (sb.length() >= 10240) {
            na.d("TT", sb.toString());
            c0 = null;
        }
    }

    public static void a(String str, c cVar) {
        if (e(str)) {
            a(str, c(str), "", cVar);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (e(str)) {
            a(str, str2, str3, (c) null);
        }
    }

    public static void a(String str, String str2, String str3, c cVar) {
        d dVar;
        if (e(str)) {
            Map<String, Map<String, d>> map = b0;
            Map<String, d> map2 = map.get(str);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                d dVar2 = new d(str, str2);
                hashMap.put(str2, dVar2);
                map.put(str, hashMap);
                dVar = dVar2;
            } else {
                d dVar3 = map2.get(str2);
                if (dVar3 == null) {
                    dVar = new d(str, str2);
                    map2.put(str2, dVar);
                } else {
                    dVar3.a();
                    dVar = dVar3;
                }
            }
            dVar.f24048c = str2;
            dVar.e = cVar;
            dVar.d.add(Long.valueOf(System.currentTimeMillis()));
            dVar.h = "Begin";
            a(dVar);
        }
    }

    public static void a(String str, String str2, String str3, Object obj) {
        if (e(str)) {
            Map<String, d> map = b0.get(str);
            d dVar = null;
            if (map != null) {
                dVar = map.get(str2);
            }
            if (dVar != null) {
                dVar.a(str3, obj);
                dVar.h = "Set";
                a(dVar.b() + ":" + str3 + "=>" + obj + "\n");
            }
        }
    }

    public static void a(Throwable th) {
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                printWriter.close();
                sb.append(stringWriter.toString());
                sb.append("\n =============== ");
            } catch (Throwable th2) {
            }
            na.d("CRASH", sb.toString());
        }
    }

    public static void a(Object... objArr) {
        if (d()) {
            a0.incrementAndGet();
            b(3, "TT", objArr);
        }
    }

    public static int b(String str, String str2, String str3) {
        if (e(str)) {
            Map<String, d> map = b0.get(str);
            d dVar = null;
            if (map != null) {
                dVar = map.get(str2);
            }
            if (dVar != null) {
                Object b2 = dVar.b(str3);
                if (b2 instanceof AtomicInteger) {
                    AtomicInteger atomicInteger = (AtomicInteger) b2;
                    int decrementAndGet = atomicInteger.decrementAndGet();
                    int i = decrementAndGet;
                    if (decrementAndGet < 0) {
                        atomicInteger.set(0);
                        i = 0;
                    }
                    return i;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    private static String b(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
        r12 = r0.getParameterTypes();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(int r4, java.lang.String r5, java.lang.Object... r6) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ra.b(int, java.lang.String, java.lang.Object[]):void");
    }

    public static void b(String str, String str2, Object obj) {
        if (e(str)) {
            a(str, c(str), str2, obj);
        }
    }

    public static boolean b(String str, String str2) {
        return a(str, str2) != null;
    }

    public static int c(String str, String str2, String str3) {
        if (e(str)) {
            Map<String, d> map = b0.get(str);
            d dVar = null;
            if (map != null) {
                dVar = map.get(str2);
            }
            if (dVar != null) {
                Object b2 = dVar.b(str3);
                if (b2 instanceof AtomicInteger) {
                    return ((AtomicInteger) b2).get();
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    private static String c(String str) {
        return str;
    }

    private static void c() {
        StringBuilder sb;
        String str;
        Pair<String, StringBuilder> pair = c0;
        if (pair == null || (sb = pair.second) == null || sb.length() == 0) {
            return;
        }
        String d2 = pa.d();
        Pair<String, StringBuilder> pair2 = c0;
        StringBuilder sb2 = pair2.second;
        if (pair2.first.equals(d2)) {
            str = "TT";
        } else {
            str = "TT-" + c0.first;
        }
        synchronized (c0) {
            sb2.append("\n ============= \n");
        }
        na.d(str, sb2.toString());
        c0 = null;
    }

    public static void c(String str, String str2) {
        if (e(str)) {
            a(str, str2, "", (c) null);
        }
    }

    public static Object d(String str, String str2, String str3) {
        if (e(str)) {
            Map<String, d> map = b0.get(str);
            d dVar = map != null ? map.get(str2) : null;
            if (dVar != null) {
                return dVar.b(str3);
            }
            return null;
        }
        return null;
    }

    public static void d(String str, String str2) {
        if (e(str)) {
            a(str, c(str), str2, (c) null);
        }
    }

    private static boolean d() {
        return na.d("TT");
    }

    public static boolean d(String str) {
        return b(str, c(str));
    }

    public static int e(String str, String str2) {
        if (e(str)) {
            return b(str, c(str), str2);
        }
        return -1;
    }

    public static int e(String str, String str2, String str3) {
        if (e(str)) {
            Map<String, d> map = b0.get(str);
            d dVar = null;
            if (map != null) {
                dVar = map.get(str2);
            }
            if (dVar != null) {
                Object b2 = dVar.b(str3);
                if (b2 instanceof AtomicInteger) {
                    return ((AtomicInteger) b2).incrementAndGet();
                }
                dVar.a(str3, new AtomicInteger(1));
                return 1;
            }
            return -1;
        }
        return -1;
    }

    public static void e() {
        c();
    }

    private static boolean e(String str) {
        return na.d("TT") && !Y.contains(str);
    }

    public static long f(String str, String str2) {
        if (e(str)) {
            d a2 = a(str, str2);
            if (a2 != null) {
                a2.h = "End";
            }
            long a3 = a(a2);
            if (a3 != -1) {
                b0.remove(str);
            }
            return a3;
        }
        return 0L;
    }

    public static void f(String str) {
        Y.add(str);
    }

    public static int g(String str, String str2) {
        if (e(str)) {
            return c(str, c(str), str2);
        }
        return 0;
    }

    public static b g(String str) {
        a0.incrementAndGet();
        b a2 = Z.a();
        a2.b = str;
        return a2;
    }

    public static Object h(String str, String str2) {
        if (e(str)) {
            return d(str, c(str), str2);
        }
        return null;
    }

    public static void h(String str) {
        if (e(str)) {
            a(str, c(str), "", (c) null);
        }
    }

    public static int i(String str, String str2) {
        if (e(str)) {
            return e(str, c(str), str2);
        }
        return -1;
    }

    public static long i(String str) {
        if (e(str)) {
            return f(str, c(str));
        }
        return 0L;
    }

    public static long j(String str) {
        if (e(str)) {
            return j(str, c(str));
        }
        return 0L;
    }

    public static long j(String str, String str2) {
        if (e(str)) {
            return a(str, c(str), str2, "", null);
        }
        return 0L;
    }
}
