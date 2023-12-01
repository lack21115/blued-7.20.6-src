package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/LruCacheKt$lruCache$4.class */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2<K, V, Integer> f2551a;
    final /* synthetic */ Function1<K, V> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function4<Boolean, K, V, V, Unit> f2552c;
    final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4, int i) {
        super(i);
        this.f2551a = function2;
        this.b = function1;
        this.f2552c = function4;
        this.d = i;
    }

    @Override // android.util.LruCache
    protected V create(K k) {
        Intrinsics.e(k, "key");
        return (V) this.b.invoke(k);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, K k, V v, V v2) {
        Intrinsics.e(k, "key");
        Intrinsics.e(v, "oldValue");
        this.f2552c.invoke(Boolean.valueOf(z), k, v, v2);
    }

    @Override // android.util.LruCache
    protected int sizeOf(K k, V v) {
        Intrinsics.e(k, "key");
        Intrinsics.e(v, "value");
        return ((Number) this.f2551a.invoke(k, v)).intValue();
    }
}
