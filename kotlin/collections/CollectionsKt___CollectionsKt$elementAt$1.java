package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt___CollectionsKt$elementAt$1.class */
final class CollectionsKt___CollectionsKt$elementAt$1<T> extends Lambda implements Function1<Integer, T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f42376a;

    public final T a(int i) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f42376a + '.');
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Integer num) {
        return a(num.intValue());
    }
}
