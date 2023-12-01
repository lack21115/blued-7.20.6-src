package com.amap.api.col.p0003sl;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.amap.api.col.3sl.eb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/eb.class */
public final class eb implements dz {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f4878a = new ConcurrentHashMap();

    /* renamed from: com.amap.api.col.3sl.eb$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/eb$a.class */
    final class a {

        /* renamed from: a  reason: collision with root package name */
        String f4879a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        int f4880c;
        final AtomicInteger d = new AtomicInteger(0);

        public a(int i, String str, String str2) {
            this.f4879a = "";
            this.b = "";
            this.f4879a = str;
            this.b = str2;
            this.f4880c = i;
        }

        public final int a() {
            return this.d.incrementAndGet();
        }
    }

    private static void a(int i, String str, String str2, int i2) {
        if (i == 0) {
            il a2 = il.a(dw.a());
            a2.a(ik.a(str, str2 + " counter " + i2));
        } else {
            il a3 = il.a(dw.a());
            a3.a(ik.a(str, str2 + " counter " + i2));
        }
        if (dx.b) {
            c(i, str, str2 + " counter " + i2);
        }
    }

    private static String b(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        sb.append(str3);
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        sb.append(str4);
        return sb.toString();
    }

    private static void c(int i, String str, String str2) {
        if (i == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    @Override // com.amap.api.col.p0003sl.dz
    public final void a() {
        try {
            for (Map.Entry<String, a> entry : f4878a.entrySet()) {
                a value = entry.getValue();
                if (value != null) {
                    a(value.f4880c, value.f4879a, value.b, value.d.get());
                }
            }
            f4878a.clear();
            il.a(dw.a()).a();
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.col.p0003sl.dz
    public final void a(int i, String str, String str2) {
        try {
            String b = b(i, str, str2);
            a aVar = f4878a.get(b);
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a(i, str, str2);
                f4878a.put(b, aVar2);
            }
            if (aVar2.a() > 100) {
                a(aVar2.f4880c, aVar2.f4879a, aVar2.b, aVar2.d.get());
                f4878a.remove(b);
            }
        } catch (Throwable th) {
        }
    }
}
