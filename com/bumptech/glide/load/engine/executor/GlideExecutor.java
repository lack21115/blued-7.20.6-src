package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/executor/GlideExecutor.class */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final long f7236a = TimeUnit.SECONDS.toMillis(10);
    private static volatile int b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f7237c;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/executor/GlideExecutor$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f7238a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f7239c;
        private UncaughtThrowableStrategy d = UncaughtThrowableStrategy.d;
        private String e;
        private long f;

        Builder(boolean z) {
            this.f7238a = z;
        }

        public Builder a(int i) {
            this.b = i;
            this.f7239c = i;
            return this;
        }

        public Builder a(String str) {
            this.e = str;
            return this;
        }

        public GlideExecutor a() {
            if (TextUtils.isEmpty(this.e)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.e);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.f7239c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.e, this.d, this.f7238a));
            if (this.f != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new GlideExecutor(threadPoolExecutor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/executor/GlideExecutor$DefaultThreadFactory.class */
    public static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final UncaughtThrowableStrategy f7240a;
        final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final String f7241c;
        private int d;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.f7241c = str;
            this.f7240a = uncaughtThrowableStrategy;
            this.b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread;
            synchronized (this) {
                thread = new Thread(runnable, "glide-" + this.f7241c + "-thread-" + this.d) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(9);
                        if (DefaultThreadFactory.this.b) {
                            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                        }
                        try {
                            super.run();
                        } catch (Throwable th) {
                            DefaultThreadFactory.this.f7240a.a(th);
                        }
                    }
                };
                this.d = this.d + 1;
            }
            return thread;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/executor/GlideExecutor$UncaughtThrowableStrategy.class */
    public interface UncaughtThrowableStrategy {

        /* renamed from: a  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f7243a = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void a(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy b = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f7244c = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        public static final UncaughtThrowableStrategy d = b;

        void a(Throwable th);
    }

    GlideExecutor(ExecutorService executorService) {
        this.f7237c = executorService;
    }

    public static Builder a() {
        return new Builder(true).a(1).a("disk-cache");
    }

    public static GlideExecutor b() {
        return a().a();
    }

    public static Builder c() {
        return new Builder(false).a(h()).a("source");
    }

    public static GlideExecutor d() {
        return c().a();
    }

    public static GlideExecutor e() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f7236a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.d, false)));
    }

    public static Builder f() {
        return new Builder(true).a(h() >= 4 ? 2 : 1).a("animation");
    }

    public static GlideExecutor g() {
        return f().a();
    }

    public static int h() {
        if (b == 0) {
            b = Math.min(4, RuntimeCompat.a());
        }
        return b;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f7237c.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f7237c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f7237c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f7237c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f7237c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f7237c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f7237c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f7237c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f7237c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f7237c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f7237c.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f7237c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f7237c.submit(callable);
    }

    public String toString() {
        return this.f7237c.toString();
    }
}
