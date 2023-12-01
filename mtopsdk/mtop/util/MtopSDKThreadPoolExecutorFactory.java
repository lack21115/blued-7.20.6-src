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

    /* renamed from: a  reason: collision with root package name */
    private static int f43785a = 10;
    private static volatile ThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f43786c;
    private static volatile ExecutorService[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopSDKThreadPoolExecutorFactory$MtopSDKThreadFactory.class */
    public class MtopSDKThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f43787a;
        private final AtomicInteger b;

        /* renamed from: c  reason: collision with root package name */
        private String f43788c;

        public MtopSDKThreadFactory(int i) {
            this.f43787a = 10;
            this.b = new AtomicInteger();
            this.f43788c = "";
            this.f43787a = i;
        }

        public MtopSDKThreadFactory(int i, String str) {
            this.f43787a = 10;
            this.b = new AtomicInteger();
            this.f43788c = "";
            this.f43787a = i;
            this.f43788c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str;
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK ");
            if (StringUtils.a(this.f43788c)) {
                sb.append(this.f43788c);
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
                    Process.setThreadPriority(MtopSDKThreadFactory.this.f43787a);
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
                        b = a(3, 3, 1, 128, new MtopSDKThreadFactory(f43785a));
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
        if (f43786c == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                try {
                    if (f43786c == null) {
                        f43786c = a(4, 4, 1, 0, new MtopSDKThreadFactory(f43785a, "RequestPool"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f43786c;
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
                            int i3 = f43785a;
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
