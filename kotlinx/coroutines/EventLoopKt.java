package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopKt.class */
public final class EventLoopKt {
    public static final EventLoop a() {
        return new BlockingEventLoop(Thread.currentThread());
    }
}
