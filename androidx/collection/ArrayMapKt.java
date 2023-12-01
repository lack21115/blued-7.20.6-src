package androidx.collection;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/ArrayMapKt.class */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.d(pairArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairArr.length);
        int length = pairArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayMap;
            }
            Pair<? extends K, ? extends V> pair = pairArr[i2];
            arrayMap.put(pair.a(), pair.b());
            i = i2 + 1;
        }
    }
}
