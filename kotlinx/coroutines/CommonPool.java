package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CommonPool.class */
public final class CommonPool extends ExecutorCoroutineDispatcher {
    public static final CommonPool b = new CommonPool();
    private static final int d;
    private static boolean e;
    private static volatile Executor pool;

    static {
        String str;
        int intValue;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable th) {
            str = null;
        }
        if (str == null) {
            intValue = -1;
        } else {
            Integer b2 = StringsKt.b(str);
            if (b2 == null || b2.intValue() < 1) {
                throw new IllegalStateException(Intrinsics.a("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", (Object) str).toString());
            }
            intValue = b2.intValue();
        }
        d = intValue;
    }

    private CommonPool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread a(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, Intrinsics.a("CommonPool-worker-", (Object) Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    private final int b() {
        Integer valueOf = Integer.valueOf(d);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        return valueOf == null ? RangesKt.c(Runtime.getRuntime().availableProcessors() - 1, 1) : valueOf.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.concurrent.ExecutorService c() {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CommonPool.c():java.util.concurrent.ExecutorService");
    }

    private final ExecutorService d() {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return Executors.newFixedThreadPool(b(), new ThreadFactory() { // from class: kotlinx.coroutines.-$$Lambda$CommonPool$PDKI0o-Duc9e5CdSIbdhgq6TQwk
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread a;
                a = CommonPool.a(AtomicInteger.this, runnable);
                return a;
            }
        });
    }

    private final Executor e() {
        ExecutorService executorService;
        synchronized (this) {
            Executor executor = pool;
            executorService = executor;
            if (executor == null) {
                ExecutorService c = c();
                pool = c;
                executorService = c;
            }
        }
        return executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor a() {
        Executor executor = pool;
        Executor executor2 = executor;
        if (executor == null) {
            executor2 = e();
        }
        return executor2;
    }

    public final boolean a(Class<?> cls, ExecutorService executorService) {
        Integer num;
        executorService.submit(new Runnable() { // from class: kotlinx.coroutines.-$$Lambda$CommonPool$pTCvPtFEJAG6b-DYNvb8aCVsrdo
            @Override // java.lang.Runnable
            public final void run() {
                CommonPool.f();
            }
        });
        boolean z = false;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            num = null;
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable th) {
            num = null;
        }
        if (num == null) {
            return false;
        }
        if (num.intValue() >= 1) {
            z = true;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executor = pool;
            Executor executor2 = executor;
            if (executor == null) {
                executor2 = e();
            }
            AbstractTimeSource a = AbstractTimeSourceKt.a();
            executor2.execute(a == null ? runnable : a.a(runnable));
        } catch (RejectedExecutionException e2) {
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            if (a2 != null) {
                a2.c();
            }
            DefaultExecutor.b.a(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }
}
