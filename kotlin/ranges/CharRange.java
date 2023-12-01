package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/CharRange.class */
public final class CharRange extends CharProgression implements ClosedRange<Character> {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final CharRange f42572c = new CharRange(1, 0);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/CharRange$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharRange(char c2, char c3) {
        super(c2, c3, 1);
    }

    @Override // kotlin.ranges.CharProgression
    public boolean d() {
        return Intrinsics.a((int) a(), (int) b()) > 0;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: e */
    public Character getStart() {
        return Character.valueOf(a());
    }

    @Override // kotlin.ranges.CharProgression
    public boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (d() && ((CharRange) obj).d()) {
                return true;
            }
            CharRange charRange = (CharRange) obj;
            return a() == charRange.a() && b() == charRange.b();
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: f */
    public Character getEndInclusive() {
        return Character.valueOf(b());
    }

    @Override // kotlin.ranges.CharProgression
    public int hashCode() {
        if (d()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.ranges.CharProgression
    public String toString() {
        return a() + ".." + b();
    }
}
