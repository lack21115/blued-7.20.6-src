package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$withIndex$4.class */
final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements Function0<Iterator<? extends Integer>> {
    final /* synthetic */ int[] a;

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Iterator<Integer> invoke() {
        return ArrayIteratorsKt.a(this.a);
    }
}
