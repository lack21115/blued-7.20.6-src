package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/Triple.class */
public final class Triple<A, B, C> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final A f42299a;
    private final B b;

    /* renamed from: c  reason: collision with root package name */
    private final C f42300c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Triple) {
            Triple triple = (Triple) obj;
            return Intrinsics.a(this.f42299a, triple.f42299a) && Intrinsics.a(this.b, triple.b) && Intrinsics.a(this.f42300c, triple.f42300c);
        }
        return false;
    }

    public int hashCode() {
        A a2 = this.f42299a;
        int i = 0;
        int hashCode = a2 == null ? 0 : a2.hashCode();
        B b = this.b;
        int hashCode2 = b == null ? 0 : b.hashCode();
        C c2 = this.f42300c;
        if (c2 != null) {
            i = c2.hashCode();
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public String toString() {
        return '(' + this.f42299a + ", " + this.b + ", " + this.f42300c + ')';
    }
}
