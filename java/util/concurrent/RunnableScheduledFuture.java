package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/RunnableScheduledFuture.class */
public interface RunnableScheduledFuture<V> extends RunnableFuture<V>, ScheduledFuture<V> {
    boolean isPeriodic();
}
