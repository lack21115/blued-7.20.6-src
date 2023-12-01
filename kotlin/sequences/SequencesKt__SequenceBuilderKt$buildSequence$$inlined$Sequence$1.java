package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequenceBuilderKt$buildSequence$$inlined$Sequence$1.class */
public final class SequencesKt__SequenceBuilderKt$buildSequence$$inlined$Sequence$1<T> implements Sequence<T> {
    final /* synthetic */ Function2 a;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return SequencesKt.b(this.a);
    }
}
