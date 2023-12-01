package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ClosedDoubleRange.class */
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {

    /* renamed from: a  reason: collision with root package name */
    private final double f42573a;
    private final double b;

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: a */
    public Double getStart() {
        return Double.valueOf(this.f42573a);
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: b */
    public Double getEndInclusive() {
        return Double.valueOf(this.b);
    }

    public boolean c() {
        return this.f42573a > this.b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj instanceof ClosedDoubleRange) {
            if (!c() || !((ClosedDoubleRange) obj).c()) {
                ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
                if (this.f42573a == closedDoubleRange.f42573a) {
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
        return (Double.valueOf(this.f42573a).hashCode() * 31) + Double.valueOf(this.b).hashCode();
    }

    public String toString() {
        return this.f42573a + ".." + this.b;
    }
}
