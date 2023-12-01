package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.me  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/me.class */
public final class me {
    private static volatile me g;
    private static Object h = new Object();
    private Object e = new Object();
    private Object f = new Object();

    /* renamed from: a  reason: collision with root package name */
    private LongSparseArray<a> f5375a = new LongSparseArray<>();
    private LongSparseArray<a> b = new LongSparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private LongSparseArray<a> f5376c = new LongSparseArray<>();
    private LongSparseArray<a> d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.me$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/me$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f5377a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5378c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private me() {
    }

    public static me a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new me();
                }
            }
        }
        return g;
    }

    private static short a(LongSparseArray<a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return (short) 0;
            }
            short max = (short) Math.max(1L, Math.min(32767L, (b() - aVar.b) / 1000));
            if (!aVar.f5378c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    private static void a(List<md> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        a aVar;
        long b = b();
        if (longSparseArray.size() == 0) {
            for (md mdVar : list) {
                a aVar2 = new a((byte) 0);
                aVar2.f5377a = mdVar.b();
                aVar2.b = b;
                aVar2.f5378c = false;
                longSparseArray2.put(mdVar.a(), aVar2);
            }
            return;
        }
        for (md mdVar2 : list) {
            long a2 = mdVar2.a();
            a aVar3 = longSparseArray.get(a2);
            if (aVar3 == null) {
                aVar = new a((byte) 0);
                aVar.f5377a = mdVar2.b();
                aVar.b = b;
                aVar.f5378c = true;
            } else {
                aVar = aVar3;
                if (aVar3.f5377a != mdVar2.b()) {
                    aVar3.f5377a = mdVar2.b();
                    aVar3.b = b;
                    aVar3.f5378c = true;
                    aVar = aVar3;
                }
            }
            longSparseArray2.put(a2, aVar);
        }
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short a(long j) {
        return a(this.f5375a, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(List<md> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            a(list, this.f5375a, this.b);
            LongSparseArray<a> longSparseArray = this.f5375a;
            this.f5375a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short b(long j) {
        return a(this.f5376c, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(List<md> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            a(list, this.f5376c, this.d);
            LongSparseArray<a> longSparseArray = this.f5376c;
            this.f5376c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
