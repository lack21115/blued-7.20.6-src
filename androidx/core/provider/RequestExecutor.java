package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/RequestExecutor.class */
public class RequestExecutor {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/RequestExecutor$DefaultThreadFactory.class */
    static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f2543a;
        private int b;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/RequestExecutor$DefaultThreadFactory$ProcessPriorityThread.class */
        static class ProcessPriorityThread extends Thread {

            /* renamed from: a  reason: collision with root package name */
            private final int f2544a;

            ProcessPriorityThread(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.f2544a = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f2544a);
                super.run();
            }
        }

        DefaultThreadFactory(String str, int i) {
            this.f2543a = str;
            this.b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f2543a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/RequestExecutor$HandlerExecutor.class */
    public static class HandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f2545a;

        HandlerExecutor(Handler handler) {
            this.f2545a = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f2545a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f2545a + " is shutting down");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/RequestExecutor$ReplyRunnable.class */
    static class ReplyRunnable<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Callable<T> f2546a;
        private Consumer<T> b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f2547c;

        ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
            this.f2546a = callable;
            this.b = consumer;
            this.f2547c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.f2546a.call();
            } catch (Exception e) {
                t = null;
            }
            final Consumer<T> consumer = this.b;
            final T t2 = t;
            this.f2547c.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(t2);
                }
            });
        }
    }

    private RequestExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(ExecutorService executorService, Callable<T> callable, int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException e3) {
            throw new InterruptedException("timeout");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a(Handler handler) {
        return new HandlerExecutor(handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }
}
