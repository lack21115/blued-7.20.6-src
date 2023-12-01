package mtopsdk.mtop.util;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopSDKThreadPoolExecutorFactory.class */
public class MtopSDKThreadPoolExecutorFactory {
    private static int a = 10;
    private static volatile ThreadPoolExecutor b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ExecutorService[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopSDKThreadPoolExecutorFactory$MtopSDKThreadFactory.class */
    public class MtopSDKThreadFactory implements ThreadFactory {
        private int a;
        private final AtomicInteger b;
        private String c;

        public MtopSDKThreadFactory(int i) {
            this.a = 10;
            this.b = new AtomicInteger();
            this.c = "";
            this.a = i;
        }

        public MtopSDKThreadFactory(int i, String str) {
            this.a = 10;
            this.b = new AtomicInteger();
            this.c = "";
            this.a = i;
            this.c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str;
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK ");
            if (StringUtils.a(this.c)) {
                sb.append(this.c);
                str = " ";
            } else {
                str = "DefaultPool ";
            }
            sb.append(str);
            sb.append("Thread:");
            sb.append(this.b.getAndIncrement());
            return new Thread(runnable, sb.toString()) { // from class: mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory.MtopSDKThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(MtopSDKThreadFactory.this.a);
                    super.run();
                }
            };
        }
    }

    public static Future a(int i, Runnable runnable) {
        try {
            return c()[Math.abs(i % c().length)].submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[submitCallbackTask]submit runnable to Mtop Callback ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static Future a(Runnable runnable) {
        try {
            return a().submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[submit]submit runnable to Mtop Default ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static ThreadPoolExecutor a() {
        if (b == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                try {
                    if (b == null) {
                        b = a(3, 3, 1, 128, new MtopSDKThreadFactory(a));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static ThreadPoolExecutor a(int i, int i2, int i3, int i4, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(i, i2, i3, TimeUnit.SECONDS, i4 > 0 ? new LinkedBlockingQueue(i4) : new LinkedBlockingQueue(), threadFactory);
    }

    public static ThreadPoolExecutor b() {
        if (c == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                try {
                    if (c == null) {
                        c = a(4, 4, 1, 0, new MtopSDKThreadFactory(a, "RequestPool"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static ExecutorService[] c() {
        if (d == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                try {
                    if (d == null) {
                        d = new ExecutorService[2];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= 2) {
                                break;
                            }
                            ExecutorService[] executorServiceArr = d;
                            int i3 = a;
                            executorServiceArr[i2] = Executors.newSingleThreadExecutor(new MtopSDKThreadFactory(i3, "CallbackPool" + i2));
                            i = i2 + 1;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }
}
