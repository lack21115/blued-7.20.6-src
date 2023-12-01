package com.tencent.cloud.huiyansdkface.a.d;

import android.util.Log;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static c f35474a;
    private static int b = 6;

    /* renamed from: c  reason: collision with root package name */
    private static b f35475c = new b() { // from class: com.tencent.cloud.huiyansdkface.a.d.a.1
        @Override // com.tencent.cloud.huiyansdkface.a.d.a.b
        public void a(boolean z, Throwable th) {
            if (th == null || z) {
                return;
            }
            th.printStackTrace();
        }
    };
    private static C0903a d = new C0903a();

    /* renamed from: com.tencent.cloud.huiyansdkface.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/d/a$a.class */
    public static final class C0903a {
        private C0903a() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/d/a$b.class */
    public interface b {
        void a(boolean z, Throwable th);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/d/a$c.class */
    public static abstract class c {
        public void a(int i, String str, Throwable th, String str2, Object... objArr) {
            switch (i) {
                case 2:
                    a(str, th, str2, objArr);
                    return;
                case 3:
                    b(str, th, str2, objArr);
                    return;
                case 4:
                    c(str, th, str2, objArr);
                    return;
                case 5:
                    d(str, th, str2, objArr);
                    return;
                case 6:
                    e(str, th, str2, objArr);
                    return;
                case 7:
                    f(str, th, str2, objArr);
                    return;
                default:
                    return;
            }
        }

        public abstract void a(String str, Throwable th, String str2, Object... objArr);

        public abstract void b(String str, Throwable th, String str2, Object... objArr);

        public abstract void c(String str, Throwable th, String str2, Object... objArr);

        public abstract void d(String str, Throwable th, String str2, Object... objArr);

        public abstract void e(String str, Throwable th, String str2, Object... objArr);

        public void f(String str, Throwable th, String str2, Object... objArr) {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/d/a$d.class */
    public static abstract class d extends c {
    }

    static {
        a();
    }

    private static String a(String str) {
        if (str == null) {
            return "WeCamera";
        }
        return "WeCamera-" + str;
    }

    public static void a() {
        b = 10;
    }

    public static void a(c cVar) {
        f35474a = cVar;
    }

    public static void a(d dVar) {
        f35474a = dVar;
    }

    public static void a(String str, String str2, Object... objArr) {
        a(str, null, str2, objArr);
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        String a2 = a(str);
        c cVar = f35474a;
        if (cVar != null) {
            cVar.a(3, a2, th, str2, objArr);
        } else if (b <= 3) {
            if (objArr.length > 0) {
                Log.d(a2, String.format(str2, objArr), th);
            } else {
                Log.d(a2, str2, th);
            }
            a(true, th);
        }
    }

    private static void a(boolean z, Throwable th) {
        b bVar = f35475c;
        if (bVar == null || th == null) {
            return;
        }
        bVar.a(z, th);
    }

    public static void b(String str, String str2, Object... objArr) {
        b(str, null, str2, objArr);
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        String a2 = a(str);
        c cVar = f35474a;
        if (cVar != null) {
            cVar.a(4, a2, th, str2, objArr);
        } else if (b <= 4) {
            if (objArr.length > 0) {
                Log.i(a2, String.format(str2, objArr), th);
            } else {
                Log.i(a2, str2, th);
            }
            a(true, th);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        c(str, null, str2, objArr);
    }

    public static void c(String str, Throwable th, String str2, Object... objArr) {
        String a2 = a(str);
        c cVar = f35474a;
        if (cVar != null) {
            cVar.a(5, a2, th, str2, objArr);
        } else if (b <= 5) {
            if (objArr.length > 0) {
                Log.w(a2, String.format(str2, objArr), th);
            } else {
                Log.w(a2, str2, th);
            }
            a(true, th);
        }
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        String a2 = a(str);
        c cVar = f35474a;
        if (cVar != null) {
            cVar.a(6, a2, th, str2, objArr);
        } else if (b <= 6) {
            if (objArr.length > 0) {
                Log.e(a2, String.format(str2, objArr), th);
            } else {
                Log.e(a2, str2, th);
            }
            a(true, th);
        }
    }
}
