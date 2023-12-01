package com.kwad.sdk.api.kwai;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/kwai/a.class */
public final class a {
    private static final ExecutorService aaU = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private static final Handler Uk = new Handler(Looper.getMainLooper());

    public static Future<?> submit(Runnable runnable) {
        return aaU.submit(runnable);
    }
}
