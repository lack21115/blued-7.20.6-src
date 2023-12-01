package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/streams/jdk8/StreamsKt$asSequence$$inlined$Sequence$2.class */
public final class StreamsKt$asSequence$$inlined$Sequence$2 implements Sequence<Integer> {
    final /* synthetic */ IntStream a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Integer> iterator() {
        PrimitiveIterator.OfInt it = this.a.iterator();
        Intrinsics.c(it, "iterator()");
        return it;
    }
}
