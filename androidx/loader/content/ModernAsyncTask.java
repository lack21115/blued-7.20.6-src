package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/ModernAsyncTask.class */
abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final Executor THREAD_POOL_EXECUTOR;

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f3038a = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f3040a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f3040a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue(10);
    private static InternalHandler e;
    private static volatile Executor f;
    private volatile Status i = Status.PENDING;

    /* renamed from: c  reason: collision with root package name */
    final AtomicBoolean f3039c = new AtomicBoolean();
    final AtomicBoolean d = new AtomicBoolean();
    private final WorkerRunnable<Params, Result> g = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.d.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                Result result2 = (Result) ModernAsyncTask.this.a((Object[]) this.b);
                result = result2;
                Binder.flushPendingCommands();
                ModernAsyncTask.this.d(result2);
                return result2;
            } finally {
            }
        }
    };
    private final FutureTask<Result> h = new FutureTask<Result>(this.g) { // from class: androidx.loader.content.ModernAsyncTask.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                ModernAsyncTask.this.c(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException e3) {
                ModernAsyncTask.this.c(null);
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e4.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/ModernAsyncTask$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3043a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Status.values().length];
            f3043a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3043a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/ModernAsyncTask$AsyncTaskResult.class */
    public static class AsyncTaskResult<Data> {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f3044a;
        final Data[] b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f3044a = modernAsyncTask;
            this.b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/ModernAsyncTask$InternalHandler.class */
    public static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.f3044a.e(asyncTaskResult.b[0]);
            } else if (i != 2) {
            } else {
                asyncTaskResult.f3044a.b((Object[]) asyncTaskResult.b);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/ModernAsyncTask$Status.class */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/ModernAsyncTask$WorkerRunnable.class */
    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] b;

        WorkerRunnable() {
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, f3038a);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        f = threadPoolExecutor;
    }

    private static Handler c() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            try {
                if (e == null) {
                    e = new InternalHandler();
                }
                internalHandler = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return internalHandler;
    }

    public static void execute(Runnable runnable) {
        f.execute(runnable);
    }

    public static void setDefaultExecutor(Executor executor) {
        f = executor;
    }

    protected abstract Result a(Params... paramsArr);

    protected void a() {
    }

    protected void a(Result result) {
    }

    protected void b() {
    }

    protected void b(Result result) {
        b();
    }

    protected void b(Progress... progressArr) {
    }

    void c(Result result) {
        if (this.d.get()) {
            return;
        }
        d(result);
    }

    public final boolean cancel(boolean z) {
        this.f3039c.set(true);
        return this.h.cancel(z);
    }

    Result d(Result result) {
        c().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    void e(Result result) {
        if (isCancelled()) {
            b((ModernAsyncTask<Params, Progress, Result>) result);
        } else {
            a((ModernAsyncTask<Params, Progress, Result>) result);
        }
        this.i = Status.FINISHED;
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(f, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.i == Status.PENDING) {
            this.i = Status.RUNNING;
            a();
            this.g.b = paramsArr;
            executor.execute(this.h);
            return this;
        }
        int i = AnonymousClass4.f3043a[this.i.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            }
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.h.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.h.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.i;
    }

    public final boolean isCancelled() {
        return this.f3039c.get();
    }
}
