package androidx.collection;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/LongSparseArrayKt.class */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> receiver$0, long j) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.containsKey(j);
    }

    public static final <T> void forEach(LongSparseArray<T> receiver$0, Function2<? super Long, ? super T, Unit> action) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(action, "action");
        int size = receiver$0.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            action.invoke(Long.valueOf(receiver$0.keyAt(i2)), receiver$0.valueAt(i2));
            i = i2 + 1;
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> receiver$0, long j, T t) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.get(j, t);
    }

    public static final <T> T getOrElse(LongSparseArray<T> receiver$0, long j, Function0<? extends T> defaultValue) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(defaultValue, "defaultValue");
        T t = receiver$0.get(j);
        return t != null ? t : defaultValue.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> LongIterator keyIterator(final LongSparseArray<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return new LongIterator() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < receiver$0.size();
            }

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i = this.b;
                this.b = i + 1;
                return longSparseArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> receiver$0, LongSparseArray<T> other) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    @Deprecated
    public static final <T> boolean remove(LongSparseArray<T> receiver$0, long j, T t) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.remove(j, t);
    }

    public static final <T> void set(LongSparseArray<T> receiver$0, long j, T t) {
        Intrinsics.d(receiver$0, "receiver$0");
        receiver$0.put(j, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(receiver$0);
    }
}
