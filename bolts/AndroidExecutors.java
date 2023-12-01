package bolts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:bolts/AndroidExecutors.class */
final class AndroidExecutors {

    /* renamed from: a  reason: collision with root package name */
    static final int f3681a;
    static final int b;

    /* renamed from: c  reason: collision with root package name */
    private static final AndroidExecutors f3682c = new AndroidExecutors();
    private static final int e;
    private final Executor d = new UIThreadExecutor();

    /* loaded from: source-8756600-dex2jar.jar:bolts/AndroidExecutors$UIThreadExecutor.class */
    static class UIThreadExecutor implements Executor {
        private UIThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        e = availableProcessors;
        f3681a = availableProcessors + 1;
        b = (availableProcessors * 2) + 1;
    }

    private AndroidExecutors() {
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f3681a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor b() {
        return f3682c.d;
    }
}
