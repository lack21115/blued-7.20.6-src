package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ReverseOrderComparator.class */
final class ReverseOrderComparator implements Comparator<Comparable<? super Object>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ReverseOrderComparator f42442a = new ReverseOrderComparator();

    private ReverseOrderComparator() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Comparable<Object> a2, Comparable<Object> b) {
        Intrinsics.e(a2, "a");
        Intrinsics.e(b, "b");
        return b.compareTo(a2);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return NaturalOrderComparator.f42441a;
    }
}
