package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Delayed.class */
public interface Delayed extends Comparable<Delayed> {
    long getDelay(TimeUnit timeUnit);
}
