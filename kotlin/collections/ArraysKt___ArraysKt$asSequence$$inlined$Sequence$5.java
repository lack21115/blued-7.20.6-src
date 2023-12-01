package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5.class */
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5 implements Sequence<Long> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long[] f42357a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Long> iterator() {
        return ArrayIteratorsKt.a(this.f42357a);
    }
}
