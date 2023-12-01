package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/Pair.class */
public final class Pair<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final A f42290a;
    private final B b;

    public Pair(A a2, B b) {
        this.f42290a = a2;
        this.b = b;
    }

    public final A a() {
        return this.f42290a;
    }

    public final B b() {
        return this.b;
    }

    public final A c() {
        return this.f42290a;
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
            return Intrinsics.a(this.f42290a, pair.f42290a) && Intrinsics.a(this.b, pair.b);
        }
        return false;
    }

    public int hashCode() {
        A a2 = this.f42290a;
        int i = 0;
        int hashCode = a2 == null ? 0 : a2.hashCode();
        B b = this.b;
        if (b != null) {
            i = b.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        return '(' + this.f42290a + ", " + this.b + ')';
    }
}
