package java.util.concurrent;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors.class */
public class Executors {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$DefaultThreadFactory.class */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        DefaultThreadFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$DelegatedExecutorService.class */
    static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService e;

        DelegatedExecutorService(ExecutorService executorService) {
            this.e = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.e.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.e.execute(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.e.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.e.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return (T) this.e.invokeAny(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.e.invokeAny(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.e.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.e.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.e.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.e.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.e.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.e.submit(runnable, t);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.e.submit(callable);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$DelegatedScheduledExecutorService.class */
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        private final ScheduledExecutorService e;

        DelegatedScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.e = scheduledExecutorService;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.e.schedule(runnable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            return this.e.schedule(callable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.e.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.e.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$FinalizableDelegatedExecutorService.class */
    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        FinalizableDelegatedExecutorService(ExecutorService executorService) {
            super(executorService);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$PrivilegedCallable.class */
    static final class PrivilegedCallable<T> implements Callable<T> {
        private final AccessControlContext acc = AccessController.getContext();
        private final Callable<T> task;

        PrivilegedCallable(Callable<T> callable) {
            this.task = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) AccessController.doPrivileged(new PrivilegedExceptionAction<T>() { // from class: java.util.concurrent.Executors.PrivilegedCallable.1
                    @Override // java.security.PrivilegedExceptionAction
                    public T run() throws Exception {
                        return (T) PrivilegedCallable.this.task.call();
                    }
                }, this.acc);
            } catch (PrivilegedActionException e) {
                throw e.getException();
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$PrivilegedCallableUsingCurrentClassLoader.class */
    static final class PrivilegedCallableUsingCurrentClassLoader<T> implements Callable<T> {
        private final AccessControlContext acc = AccessController.getContext();
        private final ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        private final Callable<T> task;

        PrivilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
            this.task = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) AccessController.doPrivileged(new PrivilegedExceptionAction<T>() { // from class: java.util.concurrent.Executors.PrivilegedCallableUsingCurrentClassLoader.1
                    @Override // java.security.PrivilegedExceptionAction
                    public T run() throws Exception {
                        Thread currentThread = Thread.currentThread();
                        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
                        if (PrivilegedCallableUsingCurrentClassLoader.this.ccl == contextClassLoader) {
                            return (T) PrivilegedCallableUsingCurrentClassLoader.this.task.call();
                        }
                        currentThread.setContextClassLoader(PrivilegedCallableUsingCurrentClassLoader.this.ccl);
                        try {
                            return (T) PrivilegedCallableUsingCurrentClassLoader.this.task.call();
                        } finally {
                            currentThread.setContextClassLoader(contextClassLoader);
                        }
                    }
                }, this.acc);
            } catch (PrivilegedActionException e) {
                throw e.getException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$PrivilegedThreadFactory.class */
    public static class PrivilegedThreadFactory extends DefaultThreadFactory {
        private final AccessControlContext acc = AccessController.getContext();
        private final ClassLoader ccl = Thread.currentThread().getContextClassLoader();

        PrivilegedThreadFactory() {
        }

        @Override // java.util.concurrent.Executors.DefaultThreadFactory, java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            return super.newThread(new Runnable() { // from class: java.util.concurrent.Executors.PrivilegedThreadFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.concurrent.Executors.PrivilegedThreadFactory.1.1
                        @Override // java.security.PrivilegedAction
                        public Void run() {
                            Thread.currentThread().setContextClassLoader(PrivilegedThreadFactory.this.ccl);
                            runnable.run();
                            return null;
                        }
                    }, PrivilegedThreadFactory.this.acc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Executors$RunnableAdapter.class */
    public static final class RunnableAdapter<T> implements Callable<T> {
        final T result;
        final Runnable task;

        RunnableAdapter(Runnable runnable, T t) {
            this.task = runnable;
            this.result = t;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            this.task.run();
            return this.result;
        }
    }

    private Executors() {
    }

    public static Callable<Object> callable(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        return new RunnableAdapter(runnable, null);
    }

    public static <T> Callable<T> callable(Runnable runnable, T t) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        return new RunnableAdapter(runnable, t);
    }

    public static Callable<Object> callable(final PrivilegedAction<?> privilegedAction) {
        if (privilegedAction == null) {
            throw new NullPointerException();
        }
        return new Callable<Object>() { // from class: java.util.concurrent.Executors.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                return PrivilegedAction.this.run();
            }
        };
    }

    public static Callable<Object> callable(final PrivilegedExceptionAction<?> privilegedExceptionAction) {
        if (privilegedExceptionAction == null) {
            throw new NullPointerException();
        }
        return new Callable<Object>() { // from class: java.util.concurrent.Executors.2
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                return PrivilegedExceptionAction.this.run();
            }
        };
    }

    public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ExecutorService newFixedThreadPool(int i) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newFixedThreadPool(int i, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i) {
        return new ScheduledThreadPoolExecutor(i);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(i, threadFactory);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ExecutorService newWorkStealingPool() {
        return new ForkJoinPool(Runtime.getRuntime().availableProcessors(), ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    public static ExecutorService newWorkStealingPool(int i) {
        return new ForkJoinPool(i, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    public static <T> Callable<T> privilegedCallable(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new PrivilegedCallable(callable);
    }

    public static <T> Callable<T> privilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new PrivilegedCallableUsingCurrentClassLoader(callable);
    }

    public static ThreadFactory privilegedThreadFactory() {
        return new PrivilegedThreadFactory();
    }

    public static ExecutorService unconfigurableExecutorService(ExecutorService executorService) {
        if (executorService == null) {
            throw new NullPointerException();
        }
        return new DelegatedExecutorService(executorService);
    }

    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            throw new NullPointerException();
        }
        return new DelegatedScheduledExecutorService(scheduledExecutorService);
    }
}
