package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asSequence$$inlined$Sequence$3.class */
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$3 implements Sequence<Short> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ short[] f42355a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Short> iterator() {
        return ArrayIteratorsKt.a(this.f42355a);
    }
}
