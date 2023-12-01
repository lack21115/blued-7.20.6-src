package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/AbstractLongTimeSource.class */
public abstract class AbstractLongTimeSource implements TimeSource {
    private final DurationUnit a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/AbstractLongTimeSource$LongTimeMark.class */
    static final class LongTimeMark extends TimeMark {
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.e(unit, "unit");
        this.a = unit;
    }
}
