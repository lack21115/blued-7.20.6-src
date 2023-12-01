package com.amap.api.col.p0003sl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.ll  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ll.class */
public final class ll {
    private mp b;
    private List<mq> a = new ArrayList();
    private ArrayList<mq> c = new ArrayList<>();

    private static List<mq> a(List<mq> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                arrayList.addAll(hashMap.values());
                return arrayList;
            }
            mq mqVar = list.get(i2);
            hashMap.put(Integer.valueOf(mqVar.c), mqVar);
            i = i2 + 1;
        }
    }

    private boolean a(mp mpVar) {
        float f = 10.0f;
        if (mpVar.g > 10.0f) {
            f = 200.0f;
        } else if (mpVar.g > 2.0f) {
            f = 50.0f;
        }
        return mpVar.a(this.b) > ((double) f);
    }

    private static boolean a(mp mpVar, long j, long j2) {
        int i = mpVar.g >= 10.0f ? 2000 : 3500;
        boolean z = false;
        if (j > 0) {
            z = false;
            if (j2 - j < i) {
                z = true;
            }
        }
        return z;
    }

    private static boolean a(List<mq> list, List<mq> list2) {
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size <= size2) {
            list2 = list;
            list = list2;
        }
        HashMap hashMap = new HashMap(list.size());
        for (mq mqVar : list) {
            hashMap.put(Long.valueOf(mqVar.a), 1);
        }
        int i = 0;
        for (mq mqVar2 : list2) {
            if (((Integer) hashMap.get(Long.valueOf(mqVar2.a))) != null) {
                i++;
            }
        }
        return ((double) i) * 2.0d >= ((double) (size + size2)) * 0.5d;
    }

    private List<mq> b(List<mq> list) {
        Collections.sort(list, new Comparator<mq>() { // from class: com.amap.api.col.3sl.ll.1
            private static int a(mq mqVar, mq mqVar2) {
                return mqVar2.c - mqVar.c;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(mq mqVar, mq mqVar2) {
                return a(mqVar, mqVar2);
            }
        });
        return list;
    }

    private void b(List<mq> list, List<mq> list2) {
        list.clear();
        if (list2 == null) {
            return;
        }
        List<mq> b = b(a(list2));
        int size = b.size();
        int i = size;
        if (size > 40) {
            i = 40;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            list.add(b.get(i3));
            i2 = i3 + 1;
        }
    }

    private boolean b(mp mpVar, List<mq> list, boolean z, long j, long j2) {
        if (z) {
            boolean z2 = false;
            if (a(mpVar, j, j2)) {
                z2 = false;
                if (list != null) {
                    z2 = false;
                    if (list.size() > 0) {
                        if (this.b != null) {
                            boolean a = a(mpVar);
                            z2 = a;
                            if (!a) {
                                return !a(list, this.a);
                            }
                        } else {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<mq> a(mp mpVar, List<mq> list, boolean z, long j, long j2) {
        if (b(mpVar, list, z, j, j2)) {
            b(this.c, list);
            this.a.clear();
            this.a.addAll(list);
            this.b = mpVar;
            return this.c;
        }
        return null;
    }
}
