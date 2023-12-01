package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/SparseBooleanArrayKt.class */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        Intrinsics.e(action, "action");
        int size = sparseBooleanArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i, z);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> defaultValue) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        Intrinsics.e(defaultValue, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    public static final IntIterator keyIterator(final SparseBooleanArray sparseBooleanArray) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return new IntIterator() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < SparseBooleanArray.this.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = SparseBooleanArray.this;
                int i = this.b;
                this.b = i + 1;
                return sparseBooleanArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray other) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        Intrinsics.e(other, "other");
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(sparseBooleanArray.size() + other.size());
        putAll(sparseBooleanArray2, sparseBooleanArray);
        putAll(sparseBooleanArray2, other);
        return sparseBooleanArray2;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray other) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        Intrinsics.e(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            sparseBooleanArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        if (indexOfKey < 0 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i, z);
    }

    public static final BooleanIterator valueIterator(final SparseBooleanArray sparseBooleanArray) {
        Intrinsics.e(sparseBooleanArray, "<this>");
        return new BooleanIterator() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int b;

            public final int getIndex() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < SparseBooleanArray.this.size();
            }

            @Override // kotlin.collections.BooleanIterator
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = SparseBooleanArray.this;
                int i = this.b;
                this.b = i + 1;
                return sparseBooleanArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }
}
