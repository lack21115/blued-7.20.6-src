package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/LruCacheKt.class */
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        Intrinsics.d(function2, "sizeOf");
        Intrinsics.d(function1, "create");
        Intrinsics.d(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function2, function1, function4, i, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = new Function2<K, V, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                public final int invoke(K k, V v) {
                    Intrinsics.d(k, "<anonymous parameter 0>");
                    Intrinsics.d(v, "<anonymous parameter 1>");
                    return 1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke  reason: collision with other method in class */
                public /* synthetic */ Object m1134invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke((LruCacheKt$lruCache$1<K, V>) obj2, obj3));
                }
            };
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<K, V>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                public final V invoke(K k) {
                    Intrinsics.d(k, "it");
                    return null;
                }
            };
        }
        if ((i2 & 8) != 0) {
            function4 = new Function4<Boolean, K, V, V, Unit>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                /* JADX WARN: Multi-variable type inference failed */
                public /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj2).booleanValue(), (boolean) obj3, obj4, obj5);
                    return Unit.a;
                }

                public final void invoke(boolean z, K k, V v, V v2) {
                    Intrinsics.d(k, "<anonymous parameter 1>");
                    Intrinsics.d(v, "<anonymous parameter 2>");
                }
            };
        }
        Intrinsics.d(function2, "sizeOf");
        Intrinsics.d(function1, "create");
        Intrinsics.d(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function2, function1, function4, i, i);
    }
}
