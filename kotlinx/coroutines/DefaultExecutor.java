package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DefaultExecutor.class */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    public static final DefaultExecutor b;
    private static final long c;
    private static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        b = defaultExecutor;
        EventLoop.a(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException e) {
            l = 1000L;
        }
        c = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    private final boolean k() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    private final Thread l() {
        Thread thread;
        synchronized (this) {
            Thread thread2 = _thread;
            thread = thread2;
            if (thread2 == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    private final boolean m() {
        synchronized (this) {
            if (k()) {
                return false;
            }
            debugStatus = 1;
            notifyAll();
            return true;
        }
    }

    private final void n() {
        synchronized (this) {
            if (k()) {
                debugStatus = 3;
                i();
                notifyAll();
            }
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread a() {
        Thread thread = _thread;
        Thread thread2 = thread;
        if (thread == null) {
            thread2 = l();
        }
        return thread2;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return a(j, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        long j2;
        boolean c2;
        ThreadLocalEventLoop.a.a(this);
        AbstractTimeSource a = AbstractTimeSourceKt.a();
        if (a != null) {
            a.d();
        }
        try {
            if (!m()) {
                if (c2) {
                    return;
                }
                return;
            }
            long j3 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long b2 = b();
                if (b2 == Long.MAX_VALUE) {
                    AbstractTimeSource a2 = AbstractTimeSourceKt.a();
                    long nanoTime = a2 == null ? System.nanoTime() : a2.a();
                    j = j3;
                    if (j3 == Long.MAX_VALUE) {
                        j = c + nanoTime;
                    }
                    long j4 = j - nanoTime;
                    if (j4 <= 0) {
                        _thread = null;
                        n();
                        AbstractTimeSource a3 = AbstractTimeSourceKt.a();
                        if (a3 != null) {
                            a3.e();
                        }
                        if (c()) {
                            return;
                        }
                        a();
                        return;
                    }
                    j2 = RangesKt.b(b2, j4);
                } else {
                    j = Long.MAX_VALUE;
                    j2 = b2;
                }
                j3 = j;
                if (j2 > 0) {
                    if (k()) {
                        _thread = null;
                        n();
                        AbstractTimeSource a4 = AbstractTimeSourceKt.a();
                        if (a4 != null) {
                            a4.e();
                        }
                        if (c()) {
                            return;
                        }
                        a();
                        return;
                    }
                    AbstractTimeSource a5 = AbstractTimeSourceKt.a();
                    if (a5 == null) {
                        LockSupport.parkNanos(this, j2);
                        j3 = j;
                    } else {
                        a5.a(this, j2);
                        j3 = j;
                    }
                }
            }
        } finally {
            _thread = null;
            n();
            AbstractTimeSource a6 = AbstractTimeSourceKt.a();
            if (a6 != null) {
                a6.e();
            }
            if (!c()) {
                a();
            }
        }
    }
}
