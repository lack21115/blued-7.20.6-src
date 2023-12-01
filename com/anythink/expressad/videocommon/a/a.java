package com.anythink.expressad.videocommon.a;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8721a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final String f8722c = a.class.getName();
    private static a d = null;

    private a() {
        try {
            n.a().g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                try {
                    if (d == null) {
                        d = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public static List<c> a(List<c> list) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        if (list != null) {
            try {
                com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
                long c2 = b2 != null ? b2.c() : 0L;
                long currentTimeMillis = System.currentTimeMillis();
                arrayList2 = null;
                if (list != null) {
                    arrayList2 = null;
                    if (list.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        try {
                            for (c cVar : list) {
                                if (cVar != null) {
                                    long o = cVar.o() * 1000;
                                    long bg = currentTimeMillis - cVar.bg();
                                    int i = (o > 0L ? 1 : (o == 0L ? 0 : -1));
                                    if ((i > 0 && o >= bg) || (i <= 0 && c2 >= bg)) {
                                        arrayList3.add(cVar);
                                    }
                                }
                            }
                            return arrayList3;
                        } catch (Exception e) {
                            arrayList = arrayList3;
                            e = e;
                            e.printStackTrace();
                            arrayList2 = arrayList;
                            return arrayList2;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                arrayList = null;
            }
        }
        return arrayList2;
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        }
    }

    public static boolean a(c cVar) {
        try {
            com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
            long c2 = b2 != null ? b2.c() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            if (cVar != null) {
                long o = cVar.o() * 1000;
                long bg = currentTimeMillis - cVar.bg();
                int i = (o > 0L ? 1 : (o == 0L ? 0 : -1));
                if (i <= 0 || o < bg) {
                    return i > 0 || c2 < bg;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static void b() {
    }

    private static void c() {
    }

    private static void d() {
    }

    private static void e() {
    }

    private static void f() {
    }
}
