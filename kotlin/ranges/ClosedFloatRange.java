package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ClosedFloatRange.class */
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {

    /* renamed from: a  reason: collision with root package name */
    private final float f42574a;
    private final float b;

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: a */
    public Float getStart() {
        return Float.valueOf(this.f42574a);
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: b */
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    public boolean c() {
        return this.f42574a > this.b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj instanceof ClosedFloatRange) {
            if (!c() || !((ClosedFloatRange) obj).c()) {
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
                if (this.f42574a == closedFloatRange.f42574a) {
                    if (this.b == closedFloatRange.b) {
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
        return (Float.valueOf(this.f42574a).hashCode() * 31) + Float.valueOf(this.b).hashCode();
    }

    public String toString() {
        return this.f42574a + ".." + this.b;
    }
}
