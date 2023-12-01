package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ThreadSafeHeap.class */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;
    private T[] a;

    private final void a(int i, int i2) {
        T[] tArr = this.a;
        Intrinsics.a(tArr);
        T t = tArr[i2];
        Intrinsics.a(t);
        T t2 = tArr[i];
        Intrinsics.a(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.a(i);
        t2.a(i2);
    }

    private final void b(int i) {
        this._size = i;
    }

    private final void c(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.a(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.a(t);
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i];
            Intrinsics.a(t2);
            if (comparable.compareTo(t2) <= 0) {
                return;
            }
            a(i, i2);
            i = i2;
        }
    }

    private final void d(int i) {
        while (true) {
            int i2 = i;
            int i3 = (i2 * 2) + 1;
            if (i3 >= a()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.a(tArr);
            int i4 = i3 + 1;
            i = i3;
            if (i4 < a()) {
                T t = tArr[i4];
                Intrinsics.a(t);
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                Intrinsics.a(t2);
                i = i3;
                if (comparable.compareTo(t2) < 0) {
                    i = i4;
                }
            }
            T t3 = tArr[i2];
            Intrinsics.a(t3);
            Comparable comparable2 = (Comparable) t3;
            T t4 = tArr[i];
            Intrinsics.a(t4);
            if (comparable2.compareTo(t4) <= 0) {
                return;
            }
            a(i2, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [kotlinx.coroutines.internal.ThreadSafeHeapNode[]] */
    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        T[] tArr3 = tArr;
        if (a() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, a() * 2);
            Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.a = tArr3;
        }
        return tArr3;
    }

    public final int a() {
        return this._size;
    }

    public final T a(int i) {
        if (DebugKt.a()) {
            if (!(a() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        Intrinsics.a(tArr);
        b(a() - 1);
        if (i < a()) {
            a(i, a());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                Intrinsics.a(t);
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i2];
                Intrinsics.a(t2);
                if (comparable.compareTo(t2) < 0) {
                    a(i, i2);
                    c(i2);
                }
            }
            d(i);
        }
        T t3 = tArr[a()];
        Intrinsics.a(t3);
        if (DebugKt.a()) {
            boolean z = false;
            if (t3.a() == this) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        t3.a(null);
        t3.a(-1);
        tArr[a()] = null;
        return t3;
    }

    public final void a(T t) {
        synchronized (this) {
            c((ThreadSafeHeap<T>) t);
            Unit unit = Unit.a;
        }
    }

    public final boolean b() {
        return a() == 0;
    }

    public final boolean b(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            boolean z2 = false;
            if (t.a() == null) {
                z = false;
            } else {
                int b = t.b();
                if (DebugKt.a()) {
                    if (b >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                a(b);
            }
        }
        return z;
    }

    public final T c() {
        T e;
        synchronized (this) {
            e = e();
        }
        return e;
    }

    public final void c(T t) {
        if (DebugKt.a()) {
            if (!(t.a() == null)) {
                throw new AssertionError();
            }
        }
        t.a(this);
        T[] f = f();
        int a = a();
        b(a + 1);
        f[a] = t;
        t.a(a);
        c(a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.internal.ThreadSafeHeapNode] */
    public final T d() {
        T a;
        synchronized (this) {
            a = a() > 0 ? a(0) : (ThreadSafeHeapNode) 0;
        }
        return a;
    }

    public final T e() {
        T[] tArr = this.a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }
}
