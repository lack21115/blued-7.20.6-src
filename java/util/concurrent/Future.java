package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Future.class */
public interface Future<V> {
    boolean cancel(boolean z);

    V get() throws InterruptedException, ExecutionException;

    V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException;

    boolean isCancelled();

    boolean isDone();
}
