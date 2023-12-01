package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/RingBuffer.class */
public final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f42391a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f42392c;
    private int d;

    public RingBuffer(int i) {
        this(new Object[i], 0);
    }

    public RingBuffer(Object[] buffer, int i) {
        Intrinsics.e(buffer, "buffer");
        this.f42391a = buffer;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
        }
        if (i <= this.f42391a.length) {
            this.b = this.f42391a.length;
            this.d = i;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + this.f42391a.length).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> a(int i) {
        Object[] array;
        int i2 = this.b;
        int d = RangesKt.d(i2 + (i2 >> 1) + 1, i);
        if (this.f42392c == 0) {
            array = Arrays.copyOf(this.f42391a, d);
            Intrinsics.c(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[d]);
        }
        return new RingBuffer<>(array, size());
    }

    public final void a(T t) {
        if (a()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f42391a[(this.f42392c + size()) % this.b] = t;
        this.d = size() + 1;
    }

    public final boolean a() {
        return size() == this.b;
    }

    public final void b(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (!(i <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        } else if (i > 0) {
            int i2 = this.f42392c;
            int i3 = (i2 + i) % this.b;
            if (i2 > i3) {
                ArraysKt.a(this.f42391a, (Object) null, i2, this.b);
                ArraysKt.a(this.f42391a, (Object) null, 0, i3);
            } else {
                ArraysKt.a(this.f42391a, (Object) null, i2, i3);
            }
            this.f42392c = i3;
            this.d = size() - i;
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.Companion.a(i, size());
        return (T) this.f42391a[(this.f42392c + i) % this.b];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.d;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RingBuffer<T> f42393a;
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f42394c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i;
                this.f42393a = this;
                this.b = this.size();
                i = ((RingBuffer) this).f42392c;
                this.f42394c = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void a() {
                Object[] objArr;
                if (this.b == 0) {
                    b();
                    return;
                }
                objArr = ((RingBuffer) this.f42393a).f42391a;
                a(objArr[this.f42394c]);
                this.f42394c = (this.f42394c + 1) % ((RingBuffer) this.f42393a).b;
                this.b--;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.lang.Object[]] */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] array) {
        int i;
        int i2;
        Intrinsics.e(array, "array");
        T[] tArr = array;
        if (array.length < size()) {
            tArr = Arrays.copyOf(array, size());
            Intrinsics.c(tArr, "copyOf(this, newSize)");
        }
        int size = size();
        int i3 = this.f42392c;
        int i4 = 0;
        while (true) {
            i = 0;
            i2 = i4;
            if (i4 >= size) {
                break;
            }
            i = 0;
            i2 = i4;
            if (i3 >= this.b) {
                break;
            }
            tArr[i4] = this.f42391a[i3];
            i4++;
            i3++;
        }
        while (i2 < size) {
            tArr[i2] = this.f42391a[i];
            i2++;
            i++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }
}
