package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/RangeKt.class */
public final class RangeKt {
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        Intrinsics.e(range, "<this>");
        Intrinsics.e(range2, "other");
        Range<T> intersect = range.intersect(range2);
        Intrinsics.c(intersect, "intersect(other)");
        return intersect;
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        Intrinsics.e(range, "<this>");
        Intrinsics.e(range2, "other");
        Range<T> extend = range.extend(range2);
        Intrinsics.c(extend, "extend(other)");
        return extend;
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        Intrinsics.e(range, "<this>");
        Intrinsics.e(t, "value");
        Range<T> extend = range.extend((Range<T>) t);
        Intrinsics.c(extend, "extend(value)");
        return extend;
    }

    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        Intrinsics.e(t, "<this>");
        Intrinsics.e(t2, "that");
        return new Range<>(t, t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(final Range<T> range) {
        Intrinsics.e(range, "<this>");
        return new ClosedRange<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public boolean contains(Comparable comparable) {
                return ClosedRange.DefaultImpls.a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Comparable] */
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Comparable] */
            public Comparable getStart() {
                return range.getLower();
            }

            public boolean isEmpty() {
                return ClosedRange.DefaultImpls.a(this);
            }
        };
    }

    public static final <T extends Comparable<? super T>> Range<T> toRange(ClosedRange<T> closedRange) {
        Intrinsics.e(closedRange, "<this>");
        return new Range<>(closedRange.getStart(), closedRange.getEndInclusive());
    }
}
