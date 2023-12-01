package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ComparableRange.class */
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f42575a;
    private final T b;

    public boolean a() {
        return ClosedRange.DefaultImpls.a(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ComparableRange) {
            if (a() && ((ComparableRange) obj).a()) {
                return true;
            }
            ComparableRange comparableRange = (ComparableRange) obj;
            return Intrinsics.a(getStart(), comparableRange.getStart()) && Intrinsics.a(getEndInclusive(), comparableRange.getEndInclusive());
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getEndInclusive() {
        return this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getStart() {
        return this.f42575a;
    }

    public int hashCode() {
        if (a()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
