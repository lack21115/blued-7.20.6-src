package kotlin.time;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/MonotonicTimeSource.class */
public final class MonotonicTimeSource extends AbstractLongTimeSource implements TimeSource {

    /* renamed from: a  reason: collision with root package name */
    public static final MonotonicTimeSource f42769a = new MonotonicTimeSource();

    private MonotonicTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
