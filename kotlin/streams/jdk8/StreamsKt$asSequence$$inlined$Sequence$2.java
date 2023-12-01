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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntStream f42710a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Integer> iterator() {
        PrimitiveIterator.OfInt it = this.f42710a.iterator();
        Intrinsics.c(it, "iterator()");
        return it;
    }
}
