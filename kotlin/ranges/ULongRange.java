package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ULongRange.class */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong> {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final ULongRange f42595c = new ULongRange(-1, 0, null);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ULongRange$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ULongRange(long j, long j2) {
        super(j, j2, 1L, null);
    }

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean c() {
        return UnsignedKt.a(a(), b()) > 0;
    }

    public long d() {
        return a();
    }

    public long e() {
        return b();
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object obj) {
        if (obj instanceof ULongRange) {
            if (c() && ((ULongRange) obj).c()) {
                return true;
            }
            ULongRange uLongRange = (ULongRange) obj;
            return a() == uLongRange.a() && b() == uLongRange.b();
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ ULong getEndInclusive() {
        return ULong.d(e());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ ULong getStart() {
        return ULong.d(d());
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (c()) {
            return -1;
        }
        return ((int) ULong.c(b() ^ ULong.c(b() >>> 32))) + (((int) ULong.c(a() ^ ULong.c(a() >>> 32))) * 31);
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ((Object) ULong.a(a())) + ".." + ((Object) ULong.a(b()));
    }
}
