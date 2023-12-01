package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/LongRange.class */
public final class LongRange extends LongProgression implements ClosedRange<Long> {
    public static final Companion b = new Companion(null);
    private static final LongRange c = new LongRange(1, 0);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/LongRange$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongRange(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.ranges.LongProgression
    public boolean d() {
        return a() > b();
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: e */
    public Long getStart() {
        return Long.valueOf(a());
    }

    @Override // kotlin.ranges.LongProgression
    public boolean equals(Object obj) {
        if (obj instanceof LongRange) {
            if (d() && ((LongRange) obj).d()) {
                return true;
            }
            LongRange longRange = (LongRange) obj;
            return a() == longRange.a() && b() == longRange.b();
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: f */
    public Long getEndInclusive() {
        return Long.valueOf(b());
    }

    @Override // kotlin.ranges.LongProgression
    public int hashCode() {
        if (d()) {
            return -1;
        }
        return (int) ((31 * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    @Override // kotlin.ranges.LongProgression
    public String toString() {
        return a() + ".." + b();
    }
}
