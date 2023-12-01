package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hr;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bb.class */
public class bb {
    public static int a(ba baVar, hm hmVar) {
        int i = 1;
        if (bc.f41626a[hmVar.ordinal()] != 1) {
            i = 0;
        }
        return baVar.a(hmVar, i);
    }

    private static List<Pair<Integer, Object>> a(List<hr> list, boolean z) {
        if (com.xiaomi.push.ac.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hr hrVar : list) {
            int a2 = hrVar.a();
            hn a3 = hn.a(hrVar.b());
            if (a3 != null) {
                if (z && hrVar.f589a) {
                    arrayList.add(new Pair(Integer.valueOf(a2), null));
                } else {
                    int i = bc.b[a3.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a2), Boolean.valueOf(hrVar.g())) : new Pair(Integer.valueOf(a2), hrVar.m11879a()) : new Pair(Integer.valueOf(a2), Long.valueOf(hrVar.m11878a())) : new Pair(Integer.valueOf(a2), Integer.valueOf(hrVar.c())));
                }
            }
        }
        return arrayList;
    }

    public static void a(ba baVar, id idVar) {
        baVar.a(a(idVar.a(), true));
        baVar.b();
    }

    public static void a(ba baVar, ie ieVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (hp hpVar : ieVar.a()) {
            arrayList.add(new Pair<>(hpVar.m11872a(), Integer.valueOf(hpVar.a())));
            List<Pair<Integer, Object>> a2 = a(hpVar.f581a, false);
            if (!com.xiaomi.push.ac.a(a2)) {
                arrayList2.addAll(a2);
            }
        }
        baVar.a(arrayList, arrayList2);
        baVar.b();
    }
}
