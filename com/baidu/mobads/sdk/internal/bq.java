package com.baidu.mobads.sdk.internal;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bq.class */
public class bq {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9354a = "logger";
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9355c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = -1;
    private static volatile bq i;

    private bq() {
    }

    public static bq a() {
        if (i == null) {
            synchronized (bq.class) {
                try {
                    if (i == null) {
                        i = new bq();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.toString();
            }
            sb.append(objArr[i3]);
            sb.append(' ');
            i2 = i3 + 1;
        }
    }

    public void a(String str) {
        a(f9354a, str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                av.h(str).c(str2);
            } catch (Exception e2) {
            }
        }
    }

    public void a(String str, Throwable th) {
        if (a(3)) {
            try {
                av.h(f9354a).b(th, str);
            } catch (Exception e2) {
            }
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public boolean a(int i2) {
        return a(f9354a, i2);
    }

    public boolean a(String str, int i2) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                av.c().e(str);
            } catch (Exception e2) {
            }
        }
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                av.c().c(str, str2);
            } catch (Exception e2) {
            }
        }
    }

    public void b(String str, Throwable th) {
        if (a(5)) {
            try {
                av.c().d(th, str);
            } catch (Exception e2) {
            }
        }
    }

    public void b(Throwable th) {
        b("", th);
    }

    public void b(Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(String str) {
        if (a(6)) {
            try {
                av.c().f(str);
            } catch (Exception e2) {
            }
        }
    }

    public void c(String str, Throwable th) {
        if (a(6)) {
            try {
                av.c().e(th, str);
            } catch (Exception e2) {
            }
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(String str) {
        b(f9354a, str);
    }

    public void d(String str, Throwable th) {
        if (a(4)) {
            try {
                av.c().c(th, str);
            } catch (Exception e2) {
            }
        }
    }

    public void d(Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }
}
