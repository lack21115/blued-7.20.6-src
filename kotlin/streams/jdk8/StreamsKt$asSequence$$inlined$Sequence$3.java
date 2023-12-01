package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.LongStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/streams/jdk8/StreamsKt$asSequence$$inlined$Sequence$3.class */
public final class StreamsKt$asSequence$$inlined$Sequence$3 implements Sequence<Long> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongStream f42711a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Long> iterator() {
        PrimitiveIterator.OfLong it = this.f42711a.iterator();
        Intrinsics.c(it, "iterator()");
        return it;
    }
}
