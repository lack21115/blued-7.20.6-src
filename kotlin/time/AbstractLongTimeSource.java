package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/AbstractLongTimeSource.class */
public abstract class AbstractLongTimeSource implements TimeSource {

    /* renamed from: a  reason: collision with root package name */
    private final DurationUnit f42761a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/AbstractLongTimeSource$LongTimeMark.class */
    static final class LongTimeMark extends TimeMark {
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.e(unit, "unit");
        this.f42761a = unit;
    }
}
