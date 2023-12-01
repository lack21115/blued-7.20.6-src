package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.ga;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.amap.api.col.3sl.gb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gb.class */
class gb {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4986a = true;
    private long b = 86400;

    /* renamed from: c  reason: collision with root package name */
    private int f4987c = 10;
    private long d = 0;
    private final LinkedHashMap<ga.b, Object> e = new LinkedHashMap<>();
    private final Object f = new Object();
    private final LinkedHashMap<ga.b, Object> g = new LinkedHashMap<>();
    private final Object h = new Object();
    private ArrayList<String> i = new ArrayList<>();

    public gb(String... strArr) {
        a(strArr);
    }

    private void a() {
        ga.b bVar;
        int size = this.e.size();
        if (size <= 0 || size < this.f4987c) {
            return;
        }
        Iterator<ga.b> it = this.e.keySet().iterator();
        do {
            bVar = null;
            if (!it.hasNext()) {
                break;
            }
            bVar = it.next();
        } while (bVar == null);
        c(this.e, bVar);
    }

    private void a(String... strArr) {
        this.d = System.currentTimeMillis();
        this.e.clear();
        this.i.clear();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            if (str != null) {
                this.i.add(str);
            }
            i = i2 + 1;
        }
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = currentTimeMillis;
        }
    }

    private void b(ga.b bVar, Object obj) {
        synchronized (this.f) {
            a();
            b();
            this.e.put(bVar, obj);
        }
    }

    public final ga.c a(ga.b bVar) {
        if (this.f4986a && bVar != null && b(bVar)) {
            b();
            synchronized (this.f) {
                if (a(this.e, bVar)) {
                    return new ga.c(b(this.e, bVar), true);
                }
                synchronized (this.h) {
                    if (a(this.g, bVar)) {
                        while (!a(this.e, bVar) && a(this.g, bVar)) {
                            try {
                                this.h.wait(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        this.g.put(bVar, null);
                    }
                }
                return new ga.c(b(this.e, bVar), false);
            }
        }
        return null;
    }

    public void a(ga.a aVar) {
        if (aVar != null) {
            this.f4986a = aVar.a();
            this.b = aVar.b();
            this.f4987c = aVar.c();
        }
    }

    public final void a(ga.b bVar, Object obj) {
        if (this.f4986a && bVar != null && b(bVar)) {
            b(bVar, obj);
            synchronized (this.h) {
                c(this.g, bVar);
                this.h.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(LinkedHashMap<ga.b, Object> linkedHashMap, ga.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b(LinkedHashMap<ga.b, Object> linkedHashMap, ga.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    public final boolean b(ga.b bVar) {
        if (bVar == null || bVar.f4984a == null) {
            return false;
        }
        Iterator<String> it = this.i.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && bVar.f4984a.contains(next)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object c(LinkedHashMap<ga.b, Object> linkedHashMap, ga.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }
}
