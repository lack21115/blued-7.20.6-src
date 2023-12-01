package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/SlidingWindowKt$windowedSequence$$inlined$Sequence$1.class */
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1<T> implements Sequence<List<? extends T>> {
    final /* synthetic */ Sequence a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;

    @Override // kotlin.sequences.Sequence
    public Iterator<List<? extends T>> iterator() {
        return SlidingWindowKt.a(this.a.iterator(), this.b, this.c, this.d, this.e);
    }
}
