package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ReversedComparator.class */
final class ReversedComparator<T> implements Comparator<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Comparator<T> f42443a;

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f42443a.compare(t2, t);
    }

    public final Comparator<T> reversed() {
        return this.f42443a;
    }
}
