package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ClosedDoubleRange.class */
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    private final double a;
    private final double b;

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: a */
    public Double getStart() {
        return Double.valueOf(this.a);
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: b */
    public Double getEndInclusive() {
        return Double.valueOf(this.b);
    }

    public boolean c() {
        return this.a > this.b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj instanceof ClosedDoubleRange) {
            if (!c() || !((ClosedDoubleRange) obj).c()) {
                ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
                if (this.a == closedDoubleRange.a) {
                    if (this.b == closedDoubleRange.b) {
                        return true;
                    }
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (Double.valueOf(this.a).hashCode() * 31) + Double.valueOf(this.b).hashCode();
    }

    public String toString() {
        return this.a + ".." + this.b;
    }
}
