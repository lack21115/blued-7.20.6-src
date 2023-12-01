package android.app;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-9557208-dex2jar.jar:android/app/QueuedWork.class */
public class QueuedWork {
    private static final ConcurrentLinkedQueue<Runnable> sPendingWorkFinishers = new ConcurrentLinkedQueue<>();
    private static ExecutorService sSingleThreadExecutor = null;

    public static void add(Runnable runnable) {
        sPendingWorkFinishers.add(runnable);
    }

    public static boolean hasPendingWork() {
        return !sPendingWorkFinishers.isEmpty();
    }

    public static void remove(Runnable runnable) {
        sPendingWorkFinishers.remove(runnable);
    }

    public static ExecutorService singleThreadExecutor() {
        ExecutorService executorService;
        synchronized (QueuedWork.class) {
            try {
                if (sSingleThreadExecutor == null) {
                    sSingleThreadExecutor = Executors.newSingleThreadExecutor();
                }
                executorService = sSingleThreadExecutor;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static void waitToFinish() {
        while (true) {
            Runnable poll = sPendingWorkFinishers.poll();
            if (poll == null) {
                return;
            }
            poll.run();
        }
    }
}
