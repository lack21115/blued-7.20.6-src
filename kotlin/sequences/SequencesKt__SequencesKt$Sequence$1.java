package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$Sequence$1.class */
public final class SequencesKt__SequencesKt$Sequence$1<T> implements Sequence<T> {
    final /* synthetic */ Function0<Iterator<T>> a;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return this.a.invoke();
    }
}
