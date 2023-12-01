package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharingStarted.class */
public interface SharingStarted {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f43420a = Companion.f43421a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharingStarted$Companion.class */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f43421a = new Companion();
        private static final SharingStarted b = new StartedEagerly();

        /* renamed from: c  reason: collision with root package name */
        private static final SharingStarted f43422c = new StartedLazily();

        private Companion() {
        }

        public final SharingStarted a() {
            return b;
        }

        public final SharingStarted b() {
            return f43422c;
        }
    }

    Flow<SharingCommand> a(StateFlow<Integer> stateFlow);
}
