package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/DurationUnitKt__DurationUnitJvmKt.class */
class DurationUnitKt__DurationUnitJvmKt {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/DurationUnitKt__DurationUnitJvmKt$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42767a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            iArr[TimeUnit.SECONDS.ordinal()] = 4;
            iArr[TimeUnit.MINUTES.ordinal()] = 5;
            iArr[TimeUnit.HOURS.ordinal()] = 6;
            iArr[TimeUnit.DAYS.ordinal()] = 7;
            f42767a = iArr;
        }
    }

    public static final long a(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.e(sourceUnit, "sourceUnit");
        Intrinsics.e(targetUnit, "targetUnit");
        return targetUnit.a().convert(j, sourceUnit.a());
    }
}
