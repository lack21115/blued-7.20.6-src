package kotlin.sequences;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$sortedWith$1.class */
public final class SequencesKt___SequencesKt$sortedWith$1<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Sequence<T> f42690a;
    final /* synthetic */ Comparator<? super T> b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        List e = SequencesKt.e(this.f42690a);
        CollectionsKt.a(e, (Comparator) this.b);
        return e.iterator();
    }
}
