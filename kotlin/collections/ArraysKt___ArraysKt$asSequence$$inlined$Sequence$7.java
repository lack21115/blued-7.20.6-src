package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7.class */
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7 implements Sequence<Double> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ double[] f42359a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Double> iterator() {
        return ArrayIteratorsKt.a(this.f42359a);
    }
}
