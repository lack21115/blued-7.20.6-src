package java.util.concurrent.atomic;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicReferenceArray.class */
public class AtomicReferenceArray<E> implements Serializable {
    private static final long arrayFieldOffset;
    private static final int base;
    private static final long serialVersionUID = -6209656149925076980L;
    private static final int shift;
    private static final Unsafe unsafe;
    private final Object[] array;

    static {
        try {
            unsafe = Unsafe.getUnsafe();
            arrayFieldOffset = unsafe.objectFieldOffset(AtomicReferenceArray.class.getDeclaredField("array"));
            base = unsafe.arrayBaseOffset(Object[].class);
            int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            shift = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public AtomicReferenceArray(int i) {
        this.array = new Object[i];
    }

    public AtomicReferenceArray(E[] eArr) {
        this.array = Arrays.copyOf(eArr, eArr.length, Object[].class);
    }

    private static long byteOffset(int i) {
        return (i << shift) + base;
    }

    private long checkedByteOffset(int i) {
        if (i < 0 || i >= this.array.length) {
            throw new IndexOutOfBoundsException("index " + i);
        }
        return byteOffset(i);
    }

    private boolean compareAndSetRaw(long j, E e, E e2) {
        return unsafe.compareAndSwapObject(this.array, j, e, e2);
    }

    private E getRaw(long j) {
        return (E) unsafe.getObjectVolatile(this.array, j);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException, InvalidObjectException {
        Object obj = objectInputStream.readFields().get("array", (Object) null);
        if (obj == null || !obj.getClass().isArray()) {
            throw new InvalidObjectException("Not array type");
        }
        Object[] objArr = obj;
        if (obj.getClass() != Object[].class) {
            objArr = Arrays.copyOf((Object[]) obj, Array.getLength(obj), Object[].class);
        }
        unsafe.putObjectVolatile(this, arrayFieldOffset, objArr);
    }

    public final boolean compareAndSet(int i, E e, E e2) {
        return compareAndSetRaw(checkedByteOffset(i), e, e2);
    }

    public final E get(int i) {
        return getRaw(checkedByteOffset(i));
    }

    public final E getAndSet(int i, E e) {
        E raw;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
        } while (!compareAndSetRaw(checkedByteOffset, raw, e));
        return raw;
    }

    public final void lazySet(int i, E e) {
        unsafe.putOrderedObject(this.array, checkedByteOffset(i), e);
    }

    public final int length() {
        return this.array.length;
    }

    public final void set(int i, E e) {
        unsafe.putObjectVolatile(this.array, checkedByteOffset(i), e);
    }

    public String toString() {
        int length = this.array.length - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (true) {
            int i2 = i;
            sb.append(getRaw(byteOffset(i2)));
            if (i2 == length) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
            i = i2 + 1;
        }
    }

    public final boolean weakCompareAndSet(int i, E e, E e2) {
        return compareAndSet(i, e, e2);
    }
}
