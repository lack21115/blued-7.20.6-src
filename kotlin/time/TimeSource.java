package kotlin.time;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimeSource.class */
public interface TimeSource {
    public static final Companion b = Companion.a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimeSource$Companion.class */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        private Companion() {
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimeSource$Monotonic.class */
    public static final class Monotonic implements TimeSource {
        public static final Monotonic a = new Monotonic();
        private final /* synthetic */ MonotonicTimeSource c = MonotonicTimeSource.a;

        private Monotonic() {
        }

        public String toString() {
            return MonotonicTimeSource.a.toString();
        }
    }
}
