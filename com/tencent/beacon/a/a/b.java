package com.tencent.beacon.a.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f34918a;

    /* renamed from: c  reason: collision with root package name */
    private final Object f34919c = new Object();
    private AtomicBoolean f = new AtomicBoolean(false);
    private final SparseArray<List<d>> b = new SparseArray<>();
    private final SparseArray<List<c>> d = new SparseArray<>();
    private final SparseArray<Object> e = new SparseArray<>();

    private b() {
    }

    public static b a() {
        if (f34918a == null) {
            synchronized (b.class) {
                try {
                    if (f34918a == null) {
                        f34918a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f34918a;
    }

    private Object b(int i) {
        Object obj;
        synchronized (this.f34919c) {
            Object obj2 = this.e.get(i);
            obj = obj2;
            if (obj2 == null) {
                obj = new Object();
                this.e.put(i, obj);
            }
        }
        return obj;
    }

    private List<d> c(int i) {
        List<d> list = this.b.get(i);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private void c(c cVar) {
        d(cVar);
        synchronized (b(cVar.f34920a)) {
            List<d> c2 = c(cVar.f34920a);
            if (c2 == null) {
                return;
            }
            for (d dVar : c2) {
                dVar.a(cVar);
            }
        }
    }

    private void d(c cVar) {
    }

    public void a(int i) {
        synchronized (b(i)) {
            this.d.remove(i);
        }
    }

    public void a(int i, d dVar) {
        synchronized (b(i)) {
            List<d> list = this.b.get(i);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
                this.b.put(i, arrayList);
            }
            if (arrayList.contains(dVar)) {
                return;
            }
            arrayList.add(dVar);
            List<c> list2 = this.d.get(i);
            if (list2 != null) {
                for (c cVar : list2) {
                    dVar.a(cVar);
                }
                if (i == 6 || i == 12) {
                    a(i);
                }
            }
        }
    }

    public void a(c cVar) {
        com.tencent.beacon.a.b.a.a().a(new a(this, cVar));
    }

    public void b(c cVar) {
        synchronized (b(cVar.f34920a)) {
            c cVar2 = new c(cVar.f34920a, cVar.b);
            List<c> list = this.d.get(cVar2.f34920a);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
                this.d.put(cVar2.f34920a, arrayList);
            }
            arrayList.add(cVar2);
            c(cVar);
        }
    }
}
