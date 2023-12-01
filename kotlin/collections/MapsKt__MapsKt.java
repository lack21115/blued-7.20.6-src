package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/MapsKt__MapsKt.class */
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static final <K, V> Map<K, V> a() {
        return EmptyMap.a;
    }

    public static final <K, V> Map<K, V> a(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return MapsKt.a(iterable, new LinkedHashMap(MapsKt.b(collection.size())));
                }
                return MapsKt.a((Pair) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
            }
            return MapsKt.a();
        }
        return MapsKt.e(MapsKt.a(iterable, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M destination) {
        Intrinsics.e(iterable, "<this>");
        Intrinsics.e(destination, "destination");
        MapsKt.a(destination, iterable);
        return destination;
    }

    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.e(pairs, "pairs");
        return pairs.length > 0 ? MapsKt.a(pairs, new LinkedHashMap(MapsKt.b(pairs.length))) : MapsKt.a();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Pair<? extends K, ? extends V>[] pairArr, M destination) {
        Intrinsics.e(pairArr, "<this>");
        Intrinsics.e(destination, "destination");
        MapsKt.a(destination, pairArr);
        return destination;
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.e(map, "<this>");
        Intrinsics.e(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.c(), (V) pair.d());
        }
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.e(map, "<this>");
        Intrinsics.e(pairs, "pairs");
        int length = pairs.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Pair<? extends K, ? extends V> pair = pairs[i2];
            map.put((K) pair.c(), (V) pair.d());
            i = i2 + 1;
        }
    }

    public static final <K, V> Map<K, V> b(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.e(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.b(pairs.length));
        MapsKt.a(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> c(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.e(pairs, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(MapsKt.b(pairs.length));
        MapsKt.a(hashMap, pairs);
        return hashMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        Intrinsics.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? MapsKt.d(map) : MapsKt.b(map) : MapsKt.a();
    }

    public static final <K, V> Map<K, V> d(Map<? extends K, ? extends V> map) {
        Intrinsics.e(map, "<this>");
        return new LinkedHashMap(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        Intrinsics.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : MapsKt.b(map) : MapsKt.a();
    }
}
