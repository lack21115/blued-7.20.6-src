package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$withIndex$6.class */
final class ArraysKt___ArraysKt$withIndex$6 extends Lambda implements Function0<Iterator<? extends Float>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float[] f42367a;

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Iterator<Float> invoke() {
        return ArrayIteratorsKt.a(this.f42367a);
    }
}
