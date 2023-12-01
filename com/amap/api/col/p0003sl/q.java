package com.amap.api.col.p0003sl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3sl.q  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f5411a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.q$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/q$a.class */
    public final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public List<T> f5412a = Collections.synchronizedList(new ArrayList());
        public T b = null;

        public a() {
        }
    }

    public final <T> List<T> a(int i) {
        try {
            a aVar = this.f5411a.get(Integer.valueOf(i));
            if (aVar != null) {
                return aVar.f5412a;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public final <T> void a() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f5411a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            for (Map.Entry<Integer, a> entry : concurrentHashMap.entrySet()) {
                a value = entry.getValue();
                value.f5412a.clear();
                value.b = null;
            }
            this.f5411a.clear();
        } catch (Throwable th) {
        }
    }

    public final <T> void a(int i, T t) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f5411a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(Integer.valueOf(i));
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a();
                this.f5411a.putIfAbsent(Integer.valueOf(i), aVar2);
            }
            if (aVar2.b == t) {
                return;
            }
            b(Integer.valueOf(i), aVar2.b);
            aVar2.b = t;
            a(Integer.valueOf(i), (Integer) t);
        } catch (Throwable th) {
        }
    }

    public final <T> void a(Integer num) {
        a aVar;
        try {
            if (!this.f5411a.containsKey(num) || (aVar = this.f5411a.get(num)) == null || aVar.f5412a == null) {
                return;
            }
            aVar.f5412a.clear();
        } catch (Throwable th) {
        }
    }

    public final <T> void a(Integer num, T t) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t == null || (concurrentHashMap = this.f5411a) == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(num);
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a();
                this.f5411a.putIfAbsent(num, aVar2);
            }
            if (aVar2.f5412a == null || aVar2.f5412a.contains(t)) {
                return;
            }
            aVar2.f5412a.add(t);
        } catch (Throwable th) {
        }
    }

    public final <T> void b(Integer num, T t) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        if (t == null || (concurrentHashMap = this.f5411a) == null) {
            return;
        }
        try {
            if (!concurrentHashMap.containsKey(num) || (aVar = this.f5411a.get(num)) == null || aVar.f5412a == null || !aVar.f5412a.contains(t)) {
                return;
            }
            aVar.f5412a.remove(t);
        } catch (Throwable th) {
        }
    }
}
