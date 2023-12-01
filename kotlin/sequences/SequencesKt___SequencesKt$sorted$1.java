package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$sorted$1.class */
public final class SequencesKt___SequencesKt$sorted$1<T> implements Sequence<T> {
    final /* synthetic */ Sequence<T> a;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        List e = SequencesKt.e(this.a);
        CollectionsKt.d(e);
        return e.iterator();
    }
}
