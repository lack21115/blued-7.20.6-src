package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ThreadLocalEventLoop.class */
public final class ThreadLocalEventLoop {
    public static final ThreadLocalEventLoop a = new ThreadLocalEventLoop();
    private static final ThreadLocal<EventLoop> b = new ThreadLocal<>();

    private ThreadLocalEventLoop() {
    }

    public final EventLoop a() {
        EventLoop eventLoop = b.get();
        EventLoop eventLoop2 = eventLoop;
        if (eventLoop == null) {
            eventLoop2 = EventLoopKt.a();
            b.set(eventLoop2);
        }
        return eventLoop2;
    }

    public final void a(EventLoop eventLoop) {
        b.set(eventLoop);
    }

    public final void b() {
        b.set(null);
    }
}
