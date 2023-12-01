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
    final /* synthetic */ Function2<K, V, Integer> f2599a;
    final /* synthetic */ Function1<K, V> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function4<Boolean, K, V, V, Unit> f2600c;
    final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4, int i) {
        super(i);
        this.f2599a = function2;
        this.b = function1;
        this.f2600c = function4;
        this.d = i;
    }

    @Override // android.util.LruCache
    protected V create(K key) {
        Intrinsics.e(key, "key");
        return this.b.invoke(key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, K key, V oldValue, V v) {
        Intrinsics.e(key, "key");
        Intrinsics.e(oldValue, "oldValue");
        this.f2600c.invoke(Boolean.valueOf(z), key, oldValue, v);
    }

    @Override // android.util.LruCache
    protected int sizeOf(K key, V value) {
        Intrinsics.e(key, "key");
        Intrinsics.e(value, "value");
        return this.f2599a.invoke(key, value).intValue();
    }
}
