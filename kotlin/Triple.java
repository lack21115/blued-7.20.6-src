package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/Triple.class */
public final class Triple<A, B, C> implements Serializable {
    private final A a;
    private final B b;
    private final C c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Triple) {
            Triple triple = (Triple) obj;
            return Intrinsics.a(this.a, triple.a) && Intrinsics.a(this.b, triple.b) && Intrinsics.a(this.c, triple.c);
        }
        return false;
    }

    public int hashCode() {
        A a = this.a;
        int i = 0;
        int hashCode = a == null ? 0 : a.hashCode();
        B b = this.b;
        int hashCode2 = b == null ? 0 : b.hashCode();
        C c = this.c;
        if (c != null) {
            i = c.hashCode();
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ", " + this.c + ')';
    }
}
