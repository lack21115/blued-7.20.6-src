package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/MatchGroup.class */
public final class MatchGroup {
    private final String a;
    private final IntRange b;

    public MatchGroup(String value, IntRange range) {
        Intrinsics.e(value, "value");
        Intrinsics.e(range, "range");
        this.a = value;
        this.b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MatchGroup) {
            MatchGroup matchGroup = (MatchGroup) obj;
            return Intrinsics.a((Object) this.a, (Object) matchGroup.a) && Intrinsics.a(this.b, matchGroup.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
