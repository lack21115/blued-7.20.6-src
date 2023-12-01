package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.a.e;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f25146a = "EmergencyManager";
    private static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f25147c = 1;
    private static int d = 2;
    private static int e = 3;
    private static int f = 4;
    private static int g = 5;
    private static c h;
    private long i = 60000;
    private long j = 86400000;
    private boolean k = false;
    private DexLoader l;

    private c() {
    }

    public static c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (h == null) {
                    h = new c();
                }
                cVar = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, List<com.tencent.smtt.sdk.a.b> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.smtt.sdk.a.g a2 = com.tencent.smtt.sdk.a.g.a();
        List<String> a3 = a2.a(context, "emergence_ids");
        HashSet hashSet = new HashSet();
        if (a3 != null && !a3.isEmpty()) {
            for (String str : a3) {
                String[] a4 = com.tencent.smtt.sdk.a.g.a(str);
                if (a4 != null && a4.length == 2) {
                    hashSet.add(Integer.valueOf(Integer.parseInt(a4[0])));
                }
            }
        }
        for (com.tencent.smtt.sdk.a.b bVar : list) {
            int b2 = bVar.b();
            int a5 = bVar.a();
            if (!hashSet.contains(Integer.valueOf(a5)) && !bVar.e()) {
                linkedHashMap.put(Integer.valueOf(b2), bVar.c());
                a2.a(context, "emergence_ids", com.tencent.smtt.sdk.a.g.a(new String[]{String.valueOf(a5), String.valueOf(bVar.d())}));
            }
        }
        e.a().a(i, linkedHashMap);
        a(context, Integer.valueOf(i), linkedHashMap);
    }

    private void b(final Context context) {
        String[] a2;
        com.tencent.smtt.sdk.a.c cVar = new com.tencent.smtt.sdk.a.c();
        cVar.a(com.tencent.smtt.utils.b.a(context));
        cVar.b(com.tencent.smtt.utils.b.c(context));
        cVar.a(Integer.valueOf(com.tencent.smtt.utils.b.b(context)));
        cVar.c(com.tencent.smtt.utils.b.a());
        ArrayList arrayList = new ArrayList();
        for (String str : com.tencent.smtt.sdk.a.g.a().a(context, "emergence_ids")) {
            try {
                if (!TextUtils.isEmpty(str) && (a2 = com.tencent.smtt.sdk.a.g.a(str)) != null && a2.length == 2) {
                    int parseInt = Integer.parseInt(a2[0]);
                    if (System.currentTimeMillis() < Long.parseLong(a2[1])) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        cVar.a(arrayList);
        new com.tencent.smtt.sdk.a.e(context, com.tencent.smtt.utils.m.a(context).g(), cVar.a()).a(new e.a() { // from class: com.tencent.smtt.sdk.c.1
            @Override // com.tencent.smtt.sdk.a.e.a
            public void a(String str2) {
                c cVar2;
                Context context2;
                int i;
                ArrayList arrayList2;
                com.tencent.smtt.sdk.a.d a3 = com.tencent.smtt.sdk.a.d.a(str2);
                if (a3 == null || a3.a() != 0) {
                    cVar2 = c.this;
                    context2 = context;
                    i = c.e;
                    arrayList2 = new ArrayList();
                } else {
                    com.tencent.smtt.sdk.a.g.a().a(context, "emergence_req_interval", a3.b());
                    List<com.tencent.smtt.sdk.a.b> c2 = a3.c();
                    if (c2 != null) {
                        c.this.a(context, c.b, c2);
                        return;
                    }
                    cVar2 = c.this;
                    context2 = context;
                    i = c.d;
                    arrayList2 = new ArrayList();
                }
                cVar2.a(context2, i, arrayList2);
            }
        });
    }

    public void a(Context context) {
        if (this.k) {
            return;
        }
        this.k = true;
        com.tencent.smtt.sdk.a.g a2 = com.tencent.smtt.sdk.a.g.a();
        if (a2.b()) {
            a(context, f, new ArrayList());
            return;
        }
        a2.a(context);
        try {
            try {
                long b2 = com.tencent.smtt.sdk.a.g.a().b(context, "emergence_timestamp");
                long b3 = com.tencent.smtt.sdk.a.g.a().b(context, "emergence_req_interval");
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - b2 > Math.min(Math.max(this.i, b3), this.j)) {
                    com.tencent.smtt.sdk.a.g.a().a(context, "emergence_timestamp", currentTimeMillis);
                    b(context);
                } else {
                    a(context, f25147c, new ArrayList());
                }
            } catch (Exception e2) {
                a(context, g, new ArrayList());
            }
            com.tencent.smtt.sdk.a.g.a().c();
        } catch (Throwable th) {
            com.tencent.smtt.sdk.a.g.a().c();
            throw th;
        }
    }

    public void a(Context context, Integer num, Map<Integer, String> map) {
        if (this.l != null) {
            TbsLog.e(f25146a, "Dispatch emergency commands on tbs shell");
            this.l.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
        } else {
            TbsLog.e(f25146a, "Dex loader is null, cancel commands dispatching of tbs shell");
        }
        TbsLog.e(f25146a, "Dispatch emergency commands on tbs extension");
        QbSdk.a(context, num, map);
    }

    public void a(DexLoader dexLoader) {
        this.l = dexLoader;
    }
}
