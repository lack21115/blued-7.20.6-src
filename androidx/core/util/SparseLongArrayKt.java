package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/SparseLongArrayKt.class */
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int i) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.e(sparseLongArray, "<this>");
        Intrinsics.e(function2, "action");
        int size = sparseLongArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.get(i, j);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        Intrinsics.e(sparseLongArray, "<this>");
        Intrinsics.e(function0, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : ((Number) function0.invoke()).longValue();
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        Intrinsics.e(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    public static final IntIterator keyIterator(final SparseLongArray sparseLongArray) {
        Intrinsics.e(sparseLongArray, "<this>");
        return new IntIterator() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            public boolean hasNext() {
                return this.b < SparseLongArray.this.size();
            }

            public int nextInt() {
                SparseLongArray sparseLongArray2 = SparseLongArray.this;
                int i = this.b;
                this.b = i + 1;
                return sparseLongArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        Intrinsics.e(sparseLongArray, "<this>");
        Intrinsics.e(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        Intrinsics.e(sparseLongArray, "<this>");
        Intrinsics.e(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.e(sparseLongArray, "<this>");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey < 0 || j != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.e(sparseLongArray, "<this>");
        sparseLongArray.put(i, j);
    }

    public static final LongIterator valueIterator(final SparseLongArray sparseLongArray) {
        Intrinsics.e(sparseLongArray, "<this>");
        return new LongIterator() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            public boolean hasNext() {
                return this.b < SparseLongArray.this.size();
            }

            public long nextLong() {
                SparseLongArray sparseLongArray2 = SparseLongArray.this;
                int i = this.b;
                this.b = i + 1;
                return sparseLongArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }
}
