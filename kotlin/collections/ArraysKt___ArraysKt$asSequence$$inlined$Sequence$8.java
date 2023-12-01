package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asSequence$$inlined$Sequence$8.class */
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$8 implements Sequence<Boolean> {
    final /* synthetic */ boolean[] a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Boolean> iterator() {
        return ArrayIteratorsKt.a(this.a);
    }
}
