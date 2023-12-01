package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/IntRange.class */
public final class IntRange extends IntProgression implements ClosedRange<Integer> {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final IntRange f42580c = new IntRange(1, 0);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/IntRange$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange a() {
            return IntRange.f42580c;
        }
    }

    public IntRange(int i, int i2) {
        super(i, i2, 1);
    }

    public boolean a(int i) {
        return a() <= i && i <= b();
    }

    @Override // kotlin.ranges.IntProgression
    public boolean e() {
        return a() > b();
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (e() && ((IntRange) obj).e()) {
                return true;
            }
            IntRange intRange = (IntRange) obj;
            return a() == intRange.a() && b() == intRange.b();
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: f */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        return a() + ".." + b();
    }
}
