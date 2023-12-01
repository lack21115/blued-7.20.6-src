package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/ArraySetKt.class */
public final class ArraySetKt {
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    public static final <T> ArraySet<T> arraySetOf(T... values) {
        Intrinsics.d(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arraySet;
            }
            arraySet.add(values[i2]);
            i = i2 + 1;
        }
    }
}
