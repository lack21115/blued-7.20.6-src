package com.opos.mobad.model.e;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.j;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, com.opos.mobad.model.b.e> f12799a = new ConcurrentHashMap();

    public static void a(final Context context, y yVar) {
        final List<x> list = yVar.aq;
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (x xVar : list) {
                    if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, xVar.d, xVar.e))) {
                        String a2 = com.opos.cmn.d.c.a(xVar.d);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + e.f12799a.size());
                        if (e.f12799a.size() >= 2 || e.f12799a.containsKey(a2) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.d.b.a.c() <= 2147483648L) {
                            com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                            return;
                        }
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + xVar.toString());
                        HashSet hashSet = new HashSet();
                        com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
                        eVar.a(xVar.d);
                        eVar.b(xVar.e);
                        eVar.c(com.opos.cmn.d.d.b(context, xVar.d));
                        hashSet.add(eVar);
                        e.f12799a.put(a2, eVar);
                        boolean a3 = new j(context).a(hashSet);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + xVar.toString() + ",result=" + a3);
                        e.f12799a.remove(a2);
                        return;
                    }
                }
            }
        });
    }

    public static final boolean a(Context context, AdData adData) {
        if (context == null || adData == null) {
            return false;
        }
        try {
            List<AdItemData> f = adData.f();
            if (f == null || f.size() <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= f.size()) {
                    return false;
                }
                if (1 == f.get(i2).r()) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("VideoCacheUtils", "", e);
            return false;
        }
    }
}
