package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.DoubleStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/streams/jdk8/StreamsKt$asSequence$$inlined$Sequence$4.class */
public final class StreamsKt$asSequence$$inlined$Sequence$4 implements Sequence<Double> {
    final /* synthetic */ DoubleStream a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Double> iterator() {
        PrimitiveIterator.OfDouble it = this.a.iterator();
        Intrinsics.c(it, "iterator()");
        return it;
    }
}
