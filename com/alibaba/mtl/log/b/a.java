package com.alibaba.mtl.log.b;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static StringBuilder f4483a = new StringBuilder();
    private static volatile long e;
    private static long f;
    private static long g;
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
    private static long r;
    private static long s;
    private static long t;
    private static int u;

    /* renamed from: u  reason: collision with other field name */
    private static long f29u;
    private static int v;

    /* renamed from: v  reason: collision with other field name */
    private static long f30v;
    private static int w;

    /* renamed from: w  reason: collision with other field name */
    private static long f31w;
    private static long x;
    private static long y;

    public static void A() {
        synchronized (a.class) {
            try {
                s++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void B() {
        synchronized (a.class) {
            try {
                t++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void C() {
        synchronized (a.class) {
            try {
                f29u++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void D() {
        String u2 = l.u();
        if ("wifi".equalsIgnoreCase(u2)) {
            m++;
        } else if ("3G".equalsIgnoreCase(u2)) {
            k++;
        } else if ("4G".equalsIgnoreCase(u2)) {
            l++;
        } else if ("2G".equalsIgnoreCase(u2)) {
            j++;
        } else {
            v++;
        }
    }

    public static void E() {
        synchronized (a.class) {
            try {
                w++;
                if (e == 0 && g == 0) {
                    return;
                }
                if (com.alibaba.mtl.log.a.o || w >= 6) {
                    c(true);
                }
            } finally {
            }
        }
    }

    public static void a(List<com.alibaba.mtl.log.model.a> list, int i2) {
        int i3;
        synchronized (a.class) {
            if (list == null) {
                return;
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                try {
                    i3 = i5;
                    if (i4 >= list.size()) {
                        break;
                    }
                    com.alibaba.mtl.log.model.a aVar = list.get(i4);
                    int i6 = i3;
                    if (aVar != null) {
                        int i7 = i3;
                        if (!"6005".equalsIgnoreCase(aVar.T)) {
                            i7 = i3 + 1;
                        }
                        f4483a.append(aVar.X);
                        i6 = i7;
                        if (i4 != list.size() - 1) {
                            f4483a.append(",");
                            i6 = i7;
                        }
                    }
                    i4++;
                    i5 = i6;
                } catch (Throwable th) {
                    throw th;
                }
            }
            i.a("CoreStatics", "[uploadInc]:", Long.valueOf(g), "count:", Integer.valueOf(i2));
            long j2 = g + i2;
            g = j2;
            i.a("CoreStatics", "[uploadInc]:", Long.valueOf(j2));
            if (i3 != i2) {
                i.a("CoreStatics", "Mutil Process Upload Error");
            }
        }
    }

    public static void c(boolean z) {
        synchronized (a.class) {
        }
    }

    public static void d(int i2) {
        synchronized (a.class) {
            try {
                u += i2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }

    public static void l(String str) {
        synchronized (a.class) {
            try {
                if (d(str)) {
                    return;
                }
                if ("65501".equalsIgnoreCase(str)) {
                    y++;
                } else if ("65133".equalsIgnoreCase(str)) {
                    f31w++;
                } else if ("65502".equalsIgnoreCase(str)) {
                    x++;
                } else if ("65503".equalsIgnoreCase(str)) {
                    f30v++;
                }
                e++;
            } finally {
            }
        }
    }

    public static void m(String str) {
        synchronized (a.class) {
            try {
                if (d(str)) {
                    return;
                }
                f++;
                D();
            } finally {
            }
        }
    }

    public static void t() {
        synchronized (a.class) {
            try {
                h++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void u() {
        synchronized (a.class) {
            try {
                i++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void v() {
        synchronized (a.class) {
            try {
                n++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void w() {
        synchronized (a.class) {
            try {
                o++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void x() {
        synchronized (a.class) {
            try {
                p++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void y() {
        synchronized (a.class) {
            try {
                q++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void z() {
        synchronized (a.class) {
            try {
                r++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
