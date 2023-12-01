package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ExecutorCompletionService.class */
public class ExecutorCompletionService<V> implements CompletionService<V> {
    private final AbstractExecutorService aes;
    private final BlockingQueue<Future<V>> completionQueue;
    private final Executor executor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ExecutorCompletionService$QueueingFuture.class */
    public class QueueingFuture extends FutureTask<Void> {
        private final Future<V> task;

        QueueingFuture(RunnableFuture<V> runnableFuture) {
            super(runnableFuture, null);
            this.task = runnableFuture;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.concurrent.FutureTask
        public void done() {
            ExecutorCompletionService.this.completionQueue.add(this.task);
        }
    }

    public ExecutorCompletionService(Executor executor) {
        if (executor == null) {
            throw new NullPointerException();
        }
        this.executor = executor;
        this.aes = executor instanceof AbstractExecutorService ? (AbstractExecutorService) executor : null;
        this.completionQueue = new LinkedBlockingQueue();
    }

    public ExecutorCompletionService(Executor executor, BlockingQueue<Future<V>> blockingQueue) {
        if (executor == null || blockingQueue == null) {
            throw new NullPointerException();
        }
        this.executor = executor;
        this.aes = executor instanceof AbstractExecutorService ? (AbstractExecutorService) executor : null;
        this.completionQueue = blockingQueue;
    }

    private RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        return this.aes == null ? new FutureTask(runnable, v) : this.aes.newTaskFor(runnable, v);
    }

    private RunnableFuture<V> newTaskFor(Callable<V> callable) {
        return this.aes == null ? new FutureTask(callable) : this.aes.newTaskFor(callable);
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> poll() {
        return this.completionQueue.poll();
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.completionQueue.poll(j, timeUnit);
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> submit(Runnable runnable, V v) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture<V> newTaskFor = newTaskFor(runnable, v);
        this.executor.execute(new QueueingFuture(newTaskFor));
        return newTaskFor;
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> submit(Callable<V> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        RunnableFuture<V> newTaskFor = newTaskFor(callable);
        this.executor.execute(new QueueingFuture(newTaskFor));
        return newTaskFor;
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> take() throws InterruptedException {
        return this.completionQueue.take();
    }
}
