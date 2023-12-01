package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.class */
public final class SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1<T> implements Iterable<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Sequence f42659a;

    public SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(Sequence sequence) {
        this.f42659a = sequence;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f42659a.iterator();
    }
}
