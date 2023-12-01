package com.tencent.tmsbeacon.a.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f25766a;

    /* renamed from: c  reason: collision with root package name */
    private final Object f25767c = new Object();
    private AtomicBoolean f = new AtomicBoolean(false);
    private final SparseArray<List<d>> b = new SparseArray<>();
    private final SparseArray<List<c>> d = new SparseArray<>();
    private final SparseArray<Object> e = new SparseArray<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/a/b$a.class */
    public class a implements Runnable {
        public final /* synthetic */ c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.b);
        }
    }

    private b() {
    }

    public static b a() {
        if (f25766a == null) {
            synchronized (b.class) {
                try {
                    if (f25766a == null) {
                        f25766a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25766a;
    }

    private Object b(int i) {
        Object obj;
        synchronized (this.f25767c) {
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
        synchronized (b(cVar.f25769a)) {
            List<d> c2 = c(cVar.f25769a);
            if (c2 == null) {
                return;
            }
            for (d dVar : c2) {
                dVar.onEvent(cVar);
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
                    dVar.onEvent(cVar);
                }
                if (i == 6 || i == 12) {
                    a(i);
                }
            }
        }
    }

    public void a(c cVar) {
        com.tencent.tmsbeacon.a.b.a.a().a(new a(cVar));
    }

    public void b(c cVar) {
        synchronized (b(cVar.f25769a)) {
            c cVar2 = new c(cVar.f25769a, cVar.b);
            List<c> list = this.d.get(cVar2.f25769a);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
                this.d.put(cVar2.f25769a, arrayList);
            }
            arrayList.add(cVar2);
            c(cVar);
        }
    }
}
