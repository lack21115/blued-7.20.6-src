package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/SparseArrayKt.class */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        Intrinsics.e(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        Intrinsics.e(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        Intrinsics.e(sparseArray, "<this>");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.e(sparseArray, "<this>");
        Intrinsics.e(action, "action");
        int size = sparseArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.e(sparseArray, "<this>");
        T t2 = sparseArray.get(i);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, Function0<? extends T> defaultValue) {
        Intrinsics.e(sparseArray, "<this>");
        Intrinsics.e(defaultValue, "defaultValue");
        T t = sparseArray.get(i);
        T t2 = t;
        if (t == null) {
            t2 = defaultValue.invoke();
        }
        return t2;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        Intrinsics.e(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        Intrinsics.e(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        Intrinsics.e(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    public static final <T> IntIterator keyIterator(final SparseArray<T> sparseArray) {
        Intrinsics.e(sparseArray, "<this>");
        return new IntIterator() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < sparseArray.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i = this.b;
                this.b = i + 1;
                return sparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> other) {
        Intrinsics.e(sparseArray, "<this>");
        Intrinsics.e(other, "other");
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size() + other.size());
        putAll(sparseArray2, sparseArray);
        putAll(sparseArray2, other);
        return sparseArray2;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> other) {
        Intrinsics.e(sparseArray, "<this>");
        Intrinsics.e(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            sparseArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.e(sparseArray, "<this>");
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey < 0 || !Intrinsics.a(t, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.e(sparseArray, "<this>");
        sparseArray.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        Intrinsics.e(sparseArray, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
