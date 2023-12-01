package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/d.class */
public final class d {
    static volatile Executor aCA;
    static ExecutorService aCB = Executors.newSingleThreadExecutor();
    static c.d aCz;

    private d() {
    }

    public static void a(c.d dVar) {
        aCz = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor getExecutor() {
        if (aCA == null) {
            synchronized (d.class) {
                try {
                    if (aCA == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        aCA = threadPoolExecutor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aCA;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aCA = executor;
        }
    }
}
