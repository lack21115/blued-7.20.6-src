package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ArrayQueue.class */
public class ArrayQueue<T> {
    private Object[] a = new Object[16];
    private int b;
    private int c;

    private final void c() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        ArraysKt.a(objArr, objArr2, 0, this.b, 0, 10, (Object) null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i = this.b;
        ArraysKt.a(objArr3, objArr2, length2 - i, 0, i, 4, (Object) null);
        this.a = objArr2;
        this.b = 0;
        this.c = length;
    }

    public final void a(T t) {
        Object[] objArr = this.a;
        int i = this.c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.c = length;
        if (length == this.b) {
            c();
        }
    }

    public final boolean a() {
        return this.b == this.c;
    }

    public final T b() {
        int i = this.b;
        if (i == this.c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.b = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
