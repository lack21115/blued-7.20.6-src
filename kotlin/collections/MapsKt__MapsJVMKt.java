package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/MapsKt__MapsJVMKt.class */
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    public static final <K, V> Map<K, V> a(int i) {
        return new MapBuilder(i);
    }

    public static final <K, V> Map<K, V> a(Map<K, V> builder) {
        Intrinsics.e(builder, "builder");
        return ((MapBuilder) builder).c();
    }

    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V> pair) {
        Intrinsics.e(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.a(), pair.b());
        Intrinsics.c(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final int b(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> b(Map<? extends K, ? extends V> map) {
        Intrinsics.e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.c(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
