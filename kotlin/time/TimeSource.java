package kotlin.time;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimeSource.class */
public interface TimeSource {
    public static final Companion b = Companion.f42770a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimeSource$Companion.class */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f42770a = new Companion();

        private Companion() {
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/TimeSource$Monotonic.class */
    public static final class Monotonic implements TimeSource {

        /* renamed from: a  reason: collision with root package name */
        public static final Monotonic f42771a = new Monotonic();

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ MonotonicTimeSource f42772c = MonotonicTimeSource.f42769a;

        private Monotonic() {
        }

        public String toString() {
            return MonotonicTimeSource.f42769a.toString();
        }
    }
}
