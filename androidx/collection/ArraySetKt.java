package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/ArraySetKt.class */
public final class ArraySetKt {
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        Intrinsics.d(tArr, "values");
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arraySet;
            }
            arraySet.add(tArr[i2]);
            i = i2 + 1;
        }
    }
}
