package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/BlockingEventLoop.class */
public final class BlockingEventLoop extends EventLoopImplBase {
    private final Thread b;

    public BlockingEventLoop(Thread thread) {
        this.b = thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread a() {
        return this.b;
    }
}
