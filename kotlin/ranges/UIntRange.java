package kotlin.ranges;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/UIntRange.class */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {
    public static final Companion b = new Companion(null);
    private static final UIntRange c = new UIntRange(-1, 0, null);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/UIntRange$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UIntRange(int i, int i2) {
        super(i, i2, 1, null);
    }

    public /* synthetic */ UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean c() {
        return UnsignedKt.a(a(), b()) > 0;
    }

    public int d() {
        return a();
    }

    public int e() {
        return b();
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object obj) {
        if (obj instanceof UIntRange) {
            if (c() && ((UIntRange) obj).c()) {
                return true;
            }
            UIntRange uIntRange = (UIntRange) obj;
            return a() == uIntRange.a() && b() == uIntRange.b();
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ UInt getEndInclusive() {
        return UInt.d(e());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ UInt getStart() {
        return UInt.d(d());
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return ((Object) UInt.a(a())) + ".." + ((Object) UInt.a(b()));
    }
}
