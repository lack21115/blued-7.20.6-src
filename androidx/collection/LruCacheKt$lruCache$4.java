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
    final /* synthetic */ Function2 f1905a;
    final /* synthetic */ Function1 b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function4 f1906c;
    final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, Function4 function4, int i, int i2) {
        super(i2);
        this.f1905a = function2;
        this.b = function1;
        this.f1906c = function4;
        this.d = i;
    }

    @Override // androidx.collection.LruCache
    protected int a(K k, V v) {
        Intrinsics.d(k, "key");
        Intrinsics.d(v, "value");
        return ((Number) this.f1905a.invoke(k, v)).intValue();
    }

    @Override // androidx.collection.LruCache
    protected V a(K k) {
        Intrinsics.d(k, "key");
        return (V) this.b.invoke(k);
    }

    @Override // androidx.collection.LruCache
    protected void a(boolean z, K k, V v, V v2) {
        Intrinsics.d(k, "key");
        Intrinsics.d(v, "oldValue");
        this.f1906c.invoke(Boolean.valueOf(z), k, v, v2);
    }
}
