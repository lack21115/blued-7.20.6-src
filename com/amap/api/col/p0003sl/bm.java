package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.bm  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bm.class */
public class bm {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bm f4784a;
    private static ja b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4785c;

    private bm(Context context) {
        this.f4785c = context;
        b = b(context);
    }

    public static bm a(Context context) {
        if (f4784a == null) {
            synchronized (bm.class) {
                try {
                    if (f4784a == null) {
                        f4784a = new bm(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4784a;
    }

    private static List<String> a(List<bj> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (bj bjVar : list) {
                arrayList.add(bjVar.a());
            }
        }
        return arrayList;
    }

    private void a(String str, int i, long j, long[] jArr, long[] jArr2) {
        synchronized (this) {
            if (b()) {
                b.a(new bi(str, j, i, jArr[0], jArr2[0]), bi.a(str));
            }
        }
    }

    private static void a(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String a2 = bj.a(str);
        if (b.b(a2, bj.class).size() > 0) {
            b.a(a2, bj.class);
        }
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                b.a((List) arrayList);
                return;
            } else {
                arrayList.add(new bj(str, split[i2]));
                i = i2 + 1;
            }
        }
    }

    private static ja b(Context context) {
        try {
            return new ja(context, bl.a());
        } catch (Throwable th) {
            iw.c(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean b() {
        if (b == null) {
            b = b(this.f4785c);
        }
        return b != null;
    }

    public final bh a(String str) {
        synchronized (this) {
            if (b()) {
                List b2 = b.b(bh.e(str), bh.class);
                if (b2.size() > 0) {
                    return (bh) b2.get(0);
                }
                return null;
            }
            return null;
        }
    }

    public final ArrayList<bh> a() {
        ArrayList<bh> arrayList = new ArrayList<>();
        if (b()) {
            for (bh bhVar : b.b("", bh.class)) {
                arrayList.add(bhVar);
            }
            return arrayList;
        }
        return arrayList;
    }

    public final void a(bh bhVar) {
        synchronized (this) {
            if (b()) {
                b.a(bhVar, bh.f(bhVar.h()));
                a(bhVar.e(), bhVar.a());
            }
        }
    }

    public final void a(String str, int i, long j, long j2, long j3) {
        if (b()) {
            a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    public final List<String> b(String str) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            if (b()) {
                arrayList.addAll(a(b.b(bj.a(str), bj.class)));
                return arrayList;
            }
            return arrayList;
        }
    }

    public final void b(bh bhVar) {
        synchronized (this) {
            if (b()) {
                b.a(bk.f(bhVar.h()), bk.class);
                b.a(bj.a(bhVar.e()), bj.class);
                b.a(bi.a(bhVar.e()), bi.class);
            }
        }
    }

    public final void c(String str) {
        synchronized (this) {
            if (b()) {
                b.a(bk.e(str), bk.class);
                b.a(bj.a(str), bj.class);
                b.a(bi.a(str), bi.class);
            }
        }
    }

    public final String d(String str) {
        synchronized (this) {
            if (b()) {
                List b2 = b.b(bk.f(str), bk.class);
                String str2 = null;
                if (b2.size() > 0) {
                    str2 = ((bk) b2.get(0)).d();
                }
                return str2;
            }
            return null;
        }
    }
}
