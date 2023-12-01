package kotlin.collections;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Incorrect field signature: TK; */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1.class */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1<T> extends Lambda implements Function1<T, Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<T, K> f42372a;
    final /* synthetic */ Comparable b;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Integer invoke(T t) {
        return Integer.valueOf(ComparisonsKt.a((Comparable) this.f42372a.invoke(t), this.b));
    }
}
