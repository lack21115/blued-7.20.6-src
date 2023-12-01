package com.kwai.filedownloader.e;

import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/b.class */
public class b {
    private static volatile ThreadPoolExecutor aJn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/b$a.class */
    public static final class a implements ThreadFactory {
        private static final AtomicInteger aJo = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        a(String str) {
            this.namePrefix = f.fE(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static ThreadPoolExecutor IY() {
        if (aJn == null) {
            synchronized (b.class) {
                try {
                    if (aJn == null) {
                        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                        aJn = bVar;
                        com.kwad.sdk.core.threads.c.a(bVar, "ksad-filedownload-default");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aJn;
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (sL()) {
            return IY();
        }
        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(i, i, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor fy(String str) {
        if (sL()) {
            return IY();
        }
        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor n(int i, String str) {
        return sL() ? IY() : a(i, new LinkedBlockingQueue(), str);
    }

    private static boolean sL() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null) {
            return fVar.sL();
        }
        return false;
    }
}
