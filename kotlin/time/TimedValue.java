package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimedValue.class */
public final class TimedValue<T> {
    private final T a;
    private final long b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimedValue) {
            TimedValue timedValue = (TimedValue) obj;
            return Intrinsics.a(this.a, timedValue.a) && Duration.b(this.b, timedValue.b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        return ((t == null ? 0 : t.hashCode()) * 31) + Duration.r(this.b);
    }

    public String toString() {
        return "TimedValue(value=" + this.a + ", duration=" + ((Object) Duration.q(this.b)) + ')';
    }
}
