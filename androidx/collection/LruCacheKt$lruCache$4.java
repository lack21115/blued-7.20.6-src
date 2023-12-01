package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/collection/LruCacheKt$lruCache$4.class */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2 f1953a;
    final /* synthetic */ Function1 b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function4 f1954c;
    final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, Function4 function4, int i, int i2) {
        super(i2);
        this.f1953a = function2;
        this.b = function1;
        this.f1954c = function4;
        this.d = i;
    }

    @Override // androidx.collection.LruCache
    protected int a(K key, V value) {
        Intrinsics.d(key, "key");
        Intrinsics.d(value, "value");
        return ((Number) this.f1953a.invoke(key, value)).intValue();
    }

    @Override // androidx.collection.LruCache
    protected V a(K key) {
        Intrinsics.d(key, "key");
        return (V) this.b.invoke(key);
    }

    @Override // androidx.collection.LruCache
    protected void a(boolean z, K key, V oldValue, V v) {
        Intrinsics.d(key, "key");
        Intrinsics.d(oldValue, "oldValue");
        this.f1954c.invoke(Boolean.valueOf(z), key, oldValue, v);
    }
}
