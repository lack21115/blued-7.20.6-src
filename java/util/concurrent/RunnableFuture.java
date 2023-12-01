package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/RunnableFuture.class */
public interface RunnableFuture<V> extends Runnable, Future<V> {
    @Override // java.lang.Runnable
    void run();
}
