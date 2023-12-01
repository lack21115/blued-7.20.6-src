package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/SparseIntArrayKt.class */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> action) {
        Intrinsics.e(sparseIntArray, "<this>");
        Intrinsics.e(action, "action");
        int size = sparseIntArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseIntArray.keyAt(i2)), Integer.valueOf(sparseIntArray.valueAt(i2)));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i, Function0<Integer> defaultValue) {
        Intrinsics.e(sparseIntArray, "<this>");
        Intrinsics.e(defaultValue, "defaultValue");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : defaultValue.invoke().intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        Intrinsics.e(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    public static final IntIterator keyIterator(final SparseIntArray sparseIntArray) {
        Intrinsics.e(sparseIntArray, "<this>");
        return new IntIterator() { // from class: androidx.core.util.SparseIntArrayKt$keyIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < SparseIntArray.this.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseIntArray sparseIntArray2 = SparseIntArray.this;
                int i = this.b;
                this.b = i + 1;
                return sparseIntArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray other) {
        Intrinsics.e(sparseIntArray, "<this>");
        Intrinsics.e(other, "other");
        SparseIntArray sparseIntArray2 = new SparseIntArray(sparseIntArray.size() + other.size());
        putAll(sparseIntArray2, sparseIntArray);
        putAll(sparseIntArray2, other);
        return sparseIntArray2;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray other) {
        Intrinsics.e(sparseIntArray, "<this>");
        Intrinsics.e(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            sparseIntArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics.e(sparseIntArray, "<this>");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey < 0 || i2 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics.e(sparseIntArray, "<this>");
        sparseIntArray.put(i, i2);
    }

    public static final IntIterator valueIterator(final SparseIntArray sparseIntArray) {
        Intrinsics.e(sparseIntArray, "<this>");
        return new IntIterator() { // from class: androidx.core.util.SparseIntArrayKt$valueIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < SparseIntArray.this.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseIntArray sparseIntArray2 = SparseIntArray.this;
                int i = this.b;
                this.b = i + 1;
                return sparseIntArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }
}
