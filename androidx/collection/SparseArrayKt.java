package androidx.collection;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/SparseArrayKt.class */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> receiver$0, int i) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.containsKey(i);
    }

    public static final <T> void forEach(SparseArrayCompat<T> receiver$0, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(action, "action");
        int size = receiver$0.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            action.invoke(Integer.valueOf(receiver$0.keyAt(i2)), receiver$0.valueAt(i2));
            i = i2 + 1;
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> receiver$0, int i, T t) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.get(i, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> receiver$0, int i, Function0<? extends T> defaultValue) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(defaultValue, "defaultValue");
        T t = receiver$0.get(i);
        return t != null ? t : defaultValue.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> IntIterator keyIterator(final SparseArrayCompat<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return new IntIterator() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < receiver$0.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = receiver$0;
                int i = this.b;
                this.b = i + 1;
                return sparseArrayCompat.keyAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> receiver$0, SparseArrayCompat<T> other) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(other, "other");
        SparseArrayCompat<T> sparseArrayCompat = new SparseArrayCompat<>(receiver$0.size() + other.size());
        sparseArrayCompat.putAll(receiver$0);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    @Deprecated
    public static final <T> boolean remove(SparseArrayCompat<T> receiver$0, int i, T t) {
        Intrinsics.d(receiver$0, "receiver$0");
        return receiver$0.remove(i, t);
    }

    public static final <T> void set(SparseArrayCompat<T> receiver$0, int i, T t) {
        Intrinsics.d(receiver$0, "receiver$0");
        receiver$0.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> receiver$0) {
        Intrinsics.d(receiver$0, "receiver$0");
        return new SparseArrayKt$valueIterator$1(receiver$0);
    }
}
