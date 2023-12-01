package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ArrayQueue;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoop.class */
public abstract class EventLoop extends CoroutineDispatcher {
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42816c;
    private ArrayQueue<DispatchedTask<?>> d;

    public static /* synthetic */ void a(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        eventLoop.a(z);
    }

    private final long c(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void a(DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.d;
        ArrayQueue<DispatchedTask<?>> arrayQueue2 = arrayQueue;
        if (arrayQueue == null) {
            arrayQueue2 = new ArrayQueue<>();
            this.d = arrayQueue2;
        }
        arrayQueue2.a(dispatchedTask);
    }

    public final void a(boolean z) {
        this.b += c(z);
        if (z) {
            return;
        }
        this.f42816c = true;
    }

    public long b() {
        return !e() ? Long.MAX_VALUE : 0L;
    }

    public final void b(boolean z) {
        long c2 = this.b - c(z);
        this.b = c2;
        if (c2 > 0) {
            return;
        }
        if (DebugKt.a()) {
            if (!(this.b == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f42816c) {
            h();
        }
    }

    protected boolean c() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long d() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.d;
        return (arrayQueue == null || arrayQueue.a()) ? Long.MAX_VALUE : 0L;
    }

    public final boolean e() {
        DispatchedTask<?> b;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.d;
        if (arrayQueue == null || (b = arrayQueue.b()) == null) {
            return false;
        }
        b.run();
        return true;
    }

    public final boolean f() {
        return this.b >= c(true);
    }

    public final boolean g() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.d;
        if (arrayQueue == null) {
            return true;
        }
        return arrayQueue.a();
    }

    protected void h() {
    }
}
