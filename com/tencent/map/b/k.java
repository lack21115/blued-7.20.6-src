package com.tencent.map.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES31;
import android.telephony.TelephonyManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static int f23548a = 12000;
    private static int b = 20000;

    /* renamed from: c  reason: collision with root package name */
    private static int f23549c = 8000;
    private static int d = 20000;
    private static int e = 25000;
    private static int f = 15000;
    private static ArrayList<a> g;
    private static long h;
    private static long i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static int r;
    private static int s;
    private static int t;
    private static int u;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public long f23550a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public long f23551c;
        public long d;
        public int e;
        public long f;
        public int g;
        public int h;
    }

    static {
        NetworkInfo activeNetworkInfo;
        String subscriberId;
        ConnectivityManager connectivityManager = (ConnectivityManager) l.b().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return;
        }
        int type = activeNetworkInfo.getType();
        if (!activeNetworkInfo.isConnected() || type != 0 || (subscriberId = ((TelephonyManager) l.b().getSystemService("phone")).getSubscriberId()) == null || subscriberId.length() <= 3 || subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
            return;
        }
        f23548a = 15000;
        b = 25000;
        f23549c = 10000;
        d = 25000;
        e = GLES31.GL_READ_ONLY;
        f = 15000;
    }

    public static int a() {
        int i2 = f23548a;
        long j2 = j;
        int i3 = i2;
        if (j2 > 0) {
            i3 = i2;
            if (k > 0) {
                i3 = (int) ((Math.max(m, j2) + k) - l);
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) l.b().getSystemService(Context.CONNECTIVITY_SERVICE);
        int i4 = i3;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i4 = i3;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected() || !activeNetworkInfo.isAvailable()) {
                    long j3 = k;
                    i4 = i3;
                    if (j3 > 0) {
                        int i5 = f23549c;
                        i4 = i3;
                        if (j3 < i5) {
                            i4 = i5;
                        }
                    }
                } else {
                    i4 = b;
                }
            }
        }
        int i6 = u;
        int i7 = f23549c;
        int i8 = i4 + (i6 * i7);
        if (i8 > i7) {
            i7 = i8;
        }
        long j4 = i7;
        long j5 = k;
        if (j4 <= j5) {
            i7 = (int) (j5 + f23549c);
        }
        int i9 = b;
        int i10 = i7;
        if (i7 >= i9) {
            i10 = i9;
        }
        a b2 = b(Thread.currentThread().getId());
        a aVar = b2;
        if (b2 == null) {
            aVar = a(Thread.currentThread().getId());
        }
        int i11 = i10;
        if (i10 < aVar.g + f23549c) {
            i11 = f23549c + aVar.g;
        }
        aVar.g = i11;
        return i11;
    }

    private static a a(long j2) {
        a aVar;
        if (g == null) {
            g = new ArrayList<>();
        }
        synchronized (g) {
            if (g.size() > 20) {
                int size = g.size();
                boolean z = false;
                int i2 = 0;
                for (int i3 = 0; i3 < size / 2; i3++) {
                    if (g.get(i2).f <= 0 && System.currentTimeMillis() - g.get(i2).b <= 600000) {
                        i2++;
                    }
                    g.remove(i2);
                    z = true;
                }
                if (z) {
                    g.get(0);
                    h = 0L;
                    g.get(0);
                    i = 0L;
                    k = g.get(0).f23551c;
                    l = g.get(0).f23551c;
                    o = g.get(0).d;
                    p = g.get(0).d;
                    if (g.get(0).f > 0) {
                        r = (int) ((g.get(0).e * 1000) / g.get(0).f);
                    }
                    s = r;
                    Iterator<a> it = g.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        if (0 > h) {
                            h = 0L;
                        }
                        if (0 < i) {
                            i = 0L;
                        }
                        if (next.f23551c > k) {
                            k = next.f23551c;
                        }
                        if (next.f23551c < l) {
                            l = next.f23551c;
                        }
                        if (next.d > o) {
                            o = next.d;
                        }
                        if (next.d < p) {
                            p = next.d;
                        }
                        if (next.f > 0) {
                            int i4 = (int) ((next.e * 1000) / next.f);
                            if (i4 > r) {
                                r = i4;
                            }
                            if (i4 < s) {
                                s = i4;
                            }
                        }
                    }
                }
            }
            aVar = new a();
            aVar.f23550a = j2;
            g.add(aVar);
        }
        return aVar;
    }

    public static void a(int i2) {
        a b2 = b(Thread.currentThread().getId());
        if (b2 == null) {
            return;
        }
        b2.f = System.currentTimeMillis() - b2.b;
        b2.b = System.currentTimeMillis();
        b2.e = i2;
        int i3 = (int) ((i2 * 1000) / (b2.f == 0 ? 1L : b2.f));
        t = i3;
        int i4 = r;
        if (i3 <= i4) {
            i3 = i4;
        }
        r = i3;
        int i5 = t;
        int i6 = s;
        if (i5 >= i6 && i6 != 0) {
            i5 = i6;
        }
        s = i5;
        ArrayList<a> arrayList = g;
        if (arrayList != null) {
            synchronized (arrayList) {
                Iterator<a> it = g.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    int i7 = next.e;
                    long j2 = next.f;
                }
            }
        }
        if (u > 0 && b2.f23551c < f23549c && b2.d < f) {
            u--;
        }
        b2.g = (int) b2.f23551c;
    }

    public static void a(HttpURLConnection httpURLConnection) {
        a b2 = b(Thread.currentThread().getId());
        a aVar = b2;
        if (b2 == null) {
            aVar = a(Thread.currentThread().getId());
        }
        if (aVar == null) {
            return;
        }
        aVar.b = System.currentTimeMillis();
    }

    public static void a(boolean z) {
        if (!z) {
            u++;
        }
        a c2 = c(Thread.currentThread().getId());
        if (c2 != null) {
            long j2 = c2.b;
        }
    }

    public static int b() {
        int i2 = d;
        long j2 = n;
        int i3 = i2;
        if (j2 > 0) {
            i3 = i2;
            if (o > 0) {
                i3 = (int) ((Math.max(q, j2) + o) - p);
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) l.b().getSystemService(Context.CONNECTIVITY_SERVICE);
        int i4 = i3;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i4 = i3;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected() || !activeNetworkInfo.isAvailable()) {
                    long j3 = o;
                    i4 = i3;
                    if (j3 > 0) {
                        int i5 = f;
                        i4 = i3;
                        if (j3 < i5) {
                            i4 = i5;
                        }
                    }
                } else {
                    i4 = e;
                }
            }
        }
        int i6 = i4 + (u * f23549c);
        int i7 = f;
        int i8 = i6;
        if (i6 <= i7) {
            i8 = i7;
        }
        long j4 = i8;
        long j5 = o;
        int i9 = i8;
        if (j4 <= j5) {
            i9 = (int) (j5 + f);
        }
        int i10 = e;
        int i11 = i9;
        if (i9 >= i10) {
            i11 = i10;
        }
        a b2 = b(Thread.currentThread().getId());
        int i12 = i11;
        if (b2 != null) {
            int i13 = i11;
            if (i11 < b2.h + f) {
                i13 = b2.h + f;
            }
            int i14 = i13;
            if (i13 < b2.g + f) {
                i14 = b2.g + f;
            }
            b2.h = i14;
            i12 = i14;
        }
        return i12;
    }

    private static a b(long j2) {
        a next;
        ArrayList<a> arrayList = g;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            Iterator<a> it = g.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (next.f23550a != j2);
            return next;
        }
    }

    private static a c(long j2) {
        ArrayList<a> arrayList = g;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            int size = g.size();
            while (true) {
                int i2 = size - 1;
                if (i2 < 0) {
                    return null;
                }
                if (g.get(i2).f23550a == j2) {
                    return g.remove(i2);
                }
                size = i2;
            }
        }
    }

    public static void c() {
        long j2;
        a b2 = b(Thread.currentThread().getId());
        if (b2 == null) {
            return;
        }
        b2.f23551c = System.currentTimeMillis() - b2.b;
        b2.b = System.currentTimeMillis();
        m = b2.f23551c;
        long j3 = b2.f23551c;
        long j4 = k;
        long j5 = j4;
        if (j3 > j4) {
            j5 = b2.f23551c;
        }
        k = j5;
        long j6 = b2.f23551c;
        long j7 = l;
        if (j6 < j7) {
            j2 = b2.f23551c;
        } else {
            j2 = j7;
            if (j7 == 0) {
                j2 = b2.f23551c;
            }
        }
        l = j2;
        ArrayList<a> arrayList = g;
        if (arrayList != null) {
            synchronized (arrayList) {
                int i2 = 0;
                Iterator<a> it = g.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f23551c > 0) {
                        j += next.f23551c;
                        i2++;
                    }
                }
                if (i2 > 0) {
                    j /= i2;
                }
            }
        }
    }

    public static void d() {
        long j2;
        a b2 = b(Thread.currentThread().getId());
        if (b2 == null) {
            return;
        }
        b2.d = System.currentTimeMillis() - b2.b;
        b2.b = System.currentTimeMillis();
        q = b2.d;
        long j3 = b2.d;
        long j4 = o;
        long j5 = j4;
        if (j3 > j4) {
            j5 = b2.d;
        }
        o = j5;
        long j6 = b2.d;
        long j7 = p;
        if (j6 < j7) {
            j2 = b2.d;
        } else {
            j2 = j7;
            if (j7 == 0) {
                j2 = b2.d;
            }
        }
        p = j2;
        ArrayList<a> arrayList = g;
        if (arrayList != null) {
            synchronized (arrayList) {
                int i2 = 0;
                Iterator<a> it = g.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.d > 0) {
                        n += next.d;
                        i2++;
                    }
                }
                if (i2 > 0) {
                    n /= i2;
                }
            }
        }
    }
}
