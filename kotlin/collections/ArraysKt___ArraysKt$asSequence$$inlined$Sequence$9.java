package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9.class */
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9 implements Sequence<Character> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ char[] f42361a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Character> iterator() {
        return ArrayIteratorsKt.a(this.f42361a);
    }
}
