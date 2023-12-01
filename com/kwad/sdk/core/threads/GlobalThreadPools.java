package com.kwad.sdk.core.threads;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools.class */
public final class GlobalThreadPools {
    private static String TAG;
    private static final int amm;
    private static final int amn;
    private static final int amo;
    private static Map<String, WeakReference<ExecutorService>> amp;
    private static Map<String, Integer> amq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$4.class */
    public static final /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] amr;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ParamType.values().length];
            amr = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                amr[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                amr[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$ParamType.class */
    enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$a.class */
    public interface a {
        ExecutorService xZ();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$b.class */
    static final class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService xZ() {
            return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.amn), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.amo), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$c.class */
    static final class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService xZ() {
            return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new d(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$d.class */
    public static final class d implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public d(int i, String str) {
            this.threadPriority = i;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$e.class */
    static final class e implements a {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService xZ() {
            return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "uil-pool-"));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$f.class */
    static final class f implements a {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService xZ() {
            return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$g.class */
    public static final class g implements a {
        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService xZ() {
            return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "report-"));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/GlobalThreadPools$h.class */
    static final class h implements a {
        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService xZ() {
            return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "videoCache"));
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        amm = availableProcessors;
        int i = availableProcessors > 0 ? availableProcessors + 4 : 9;
        amn = i;
        amo = i;
        TAG = "GlobalThreadPools";
        amp = new ConcurrentHashMap();
        amq = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str, ParamType paramType, int i) {
        StringBuilder sb;
        String str2;
        int i2 = AnonymousClass4.amr[paramType.ordinal()];
        if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_core";
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_max";
        } else if (i2 != 3) {
            return i;
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_keep_alive";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        return (!amq.containsKey(sb2) || amq.get(sb2) == null) ? i : amq.get(sb2).intValue();
    }

    private static ExecutorService a(String str, a aVar) {
        WeakReference<ExecutorService> weakReference = amp.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService xZ = aVar.xZ();
            amp.put(str, new WeakReference<>(xZ));
            return xZ;
        }
        return weakReference.get();
    }

    public static ExecutorService cK(String str) {
        if (!amp.containsKey(str) || amp.get(str) == null) {
            return null;
        }
        return amp.get(str).get();
    }

    public static void m(String str, int i) {
        amq.put(str, Integer.valueOf(i));
    }

    public static void xK() {
        for (String str : amp.keySet()) {
            if (amp.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) amp.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);
                int a2 = a(str, ParamType.CORE, corePoolSize);
                int a3 = a(str, ParamType.MAX, maximumPoolSize);
                threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), TimeUnit.SECONDS);
                if (corePoolSize != a2 || maximumPoolSize != a3) {
                    if (corePoolSize <= a3) {
                        threadPoolExecutor.setMaximumPoolSize(a3);
                        threadPoolExecutor.setCorePoolSize(a2);
                    } else if (a2 <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(a2);
                        threadPoolExecutor.setMaximumPoolSize(a3);
                    }
                }
            }
        }
    }

    public static ExecutorService xL() {
        return a("lruDiskCache", new f((byte) 0));
    }

    public static ExecutorService xM() {
        ExecutorService a2;
        synchronized (GlobalThreadPools.class) {
            try {
                com.kwad.sdk.core.d.b.d(TAG, "forKsImageLoaderTask");
                a2 = a("ksImageLoaderTask", new e((byte) 0));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static ExecutorService xN() {
        ExecutorService a2;
        synchronized (GlobalThreadPools.class) {
            try {
                com.kwad.sdk.core.d.b.d(TAG, "forKsImageLoaderCachedImages");
                a2 = a("ksImageLoaderTask", new e((byte) 0));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static ExecutorService xO() {
        com.kwad.sdk.core.d.b.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new c((byte) 0));
    }

    public static ExecutorService xP() {
        ExecutorService a2;
        synchronized (GlobalThreadPools.class) {
            try {
                com.kwad.sdk.core.d.b.d(TAG, "forBaseBatchReporter");
                a2 = a("report", new g((byte) 0));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static ExecutorService xQ() {
        ExecutorService a2;
        synchronized (GlobalThreadPools.class) {
            try {
                com.kwad.sdk.core.d.b.d(TAG, "forAdReportManager");
                a2 = a("report", new g((byte) 0));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static ExecutorService xR() {
        com.kwad.sdk.core.d.b.d(TAG, "forBaseNetwork");
        return a("httpIO", new b((byte) 0));
    }

    public static ExecutorService xS() {
        com.kwad.sdk.core.d.b.d(TAG, "forHttpCacheServer");
        return a("videoCache", new h((byte) 0));
    }

    public static ExecutorService xT() {
        com.kwad.sdk.core.d.b.d(TAG, "forAppStatusHelper");
        return new com.kwad.sdk.core.threads.kwai.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService xU() {
        com.kwad.sdk.core.d.b.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService xZ() {
                return new com.kwad.sdk.core.threads.kwai.b(GlobalThreadPools.a("async", ParamType.CORE, 3), GlobalThreadPools.a("async", ParamType.MAX, 3), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService xV() {
        com.kwad.sdk.core.d.b.d(TAG, "forAsyncSchedule");
        ExecutorService a2 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService xZ() {
                return new com.kwad.sdk.core.threads.kwai.a(1, new d(5, "async-schedule"));
            }
        });
        return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new com.kwad.sdk.core.threads.kwai.a(1, new d(5, "async-schedule"));
    }

    public static Set<String> xW() {
        return amp.keySet();
    }
}
