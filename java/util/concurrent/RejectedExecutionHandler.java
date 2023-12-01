package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/RejectedExecutionHandler.class */
public interface RejectedExecutionHandler {
    void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor);
}
