package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.internal.da;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/na.class */
public class na {

    /* renamed from: a  reason: collision with root package name */
    private static oa f37661a;

    public static String a() {
        oa oaVar = f37661a;
        if (oaVar != null) {
            return oaVar.c();
        }
        return null;
    }

    public static void a(Context context, da.a aVar) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(context, aVar);
        }
    }

    public static void a(oa oaVar) {
        oa oaVar2 = f37661a;
        if (oaVar2 != oaVar) {
            if (oaVar2 != null) {
                oaVar2.a();
            }
            f37661a = oaVar;
        }
    }

    public static void a(File file, String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(file, str, str2);
        }
    }

    public static void a(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.f(str);
        } else {
            f(str);
        }
    }

    public static void a(String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.d(str, str2);
        } else {
            e(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.b(str, str2, th);
        } else {
            d(str, str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.b(str, th);
        } else {
            d(str, th);
        }
    }

    public static void a(boolean z, int i, String... strArr) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(z, i, strArr);
        }
    }

    public static void a(boolean z, String... strArr) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(z, strArr);
        }
    }

    public static boolean a(int i, String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            return oaVar.a(i, str);
        }
        return false;
    }

    public static void b(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.b(str);
        } else {
            f(str);
        }
    }

    public static void b(String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.e(str, str2);
        } else {
            e(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.d(str, str2, th);
        } else {
            d(str, str2, th);
        }
    }

    public static void b(String str, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.e(str, th);
        } else {
            d(str, th);
        }
    }

    public static boolean b() {
        oa oaVar = f37661a;
        if (oaVar != null) {
            return oaVar.b();
        }
        return false;
    }

    public static void c(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(str);
        } else {
            f(str);
        }
    }

    public static void c(String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.i(str, str2);
        } else {
            e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.c(str, str2, th);
        } else {
            d(str, str2, th);
        }
    }

    public static void c(String str, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(str, th);
        } else {
            d(str, th);
        }
    }

    public static void d(String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(str, str2);
        }
    }

    private static void d(String str, String str2, Throwable th) {
        f("[" + str + "]:" + str2 + th);
    }

    private static void d(String str, Throwable th) {
        f(str + th);
    }

    public static boolean d(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            return oaVar.d(str);
        }
        return false;
    }

    public static void e(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.e(str);
        } else {
            f(str);
        }
    }

    private static void e(String str, String str2) {
        f("[" + str + "]:" + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.e(str, str2, th);
        } else {
            d(str, str2, th);
        }
    }

    public static void e(String str, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.d(str, th);
        } else {
            d(str, th);
        }
    }

    private static void f(String str) {
        System.out.println(str);
    }

    public static void f(String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.v(str, str2);
        } else {
            e(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.a(str, str2, th);
        } else {
            d(str, str2, th);
        }
    }

    public static void f(String str, Throwable th) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.c(str, th);
        } else {
            d(str, th);
        }
    }

    public static void g(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.c(str);
        } else {
            f(str);
        }
    }

    public static void g(String str, String str2) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.w(str, str2);
        } else {
            e(str, str2);
        }
    }

    public static void h(String str) {
        oa oaVar = f37661a;
        if (oaVar != null) {
            oaVar.g(str);
        } else {
            f(str);
        }
    }
}
