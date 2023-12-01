package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/Pair.class */
public final class Pair<A, B> implements Serializable {
    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.b;
    }

    public final A c() {
        return this.a;
    }

    public final B d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return Intrinsics.a(this.a, pair.a) && Intrinsics.a(this.b, pair.b);
        }
        return false;
    }

    public int hashCode() {
        A a = this.a;
        int i = 0;
        int hashCode = a == null ? 0 : a.hashCode();
        B b = this.b;
        if (b != null) {
            i = b.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ')';
    }
}
