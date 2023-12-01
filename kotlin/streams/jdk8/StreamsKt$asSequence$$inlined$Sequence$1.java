package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/streams/jdk8/StreamsKt$asSequence$$inlined$Sequence$1.class */
public final class StreamsKt$asSequence$$inlined$Sequence$1<T> implements Sequence<T> {
    final /* synthetic */ Stream a;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Iterator<T> it = this.a.iterator();
        Intrinsics.c(it, "iterator()");
        return it;
    }
}
