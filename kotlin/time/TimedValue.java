package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimedValue.class */
public final class TimedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f42773a;
    private final long b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimedValue) {
            TimedValue timedValue = (TimedValue) obj;
            return Intrinsics.a(this.f42773a, timedValue.f42773a) && Duration.b(this.b, timedValue.b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f42773a;
        return ((t == null ? 0 : t.hashCode()) * 31) + Duration.r(this.b);
    }

    public String toString() {
        return "TimedValue(value=" + this.f42773a + ", duration=" + ((Object) Duration.q(this.b)) + ')';
    }
}
