package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharingStarted.class */
public interface SharingStarted {
    public static final Companion a = Companion.a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharingStarted$Companion.class */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();
        private static final SharingStarted b = new StartedEagerly();
        private static final SharingStarted c = new StartedLazily();

        private Companion() {
        }

        public final SharingStarted a() {
            return b;
        }

        public final SharingStarted b() {
            return c;
        }
    }

    Flow<SharingCommand> a(StateFlow<Integer> stateFlow);
}
