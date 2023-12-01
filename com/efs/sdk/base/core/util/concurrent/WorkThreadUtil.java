package com.efs.sdk.base.core.util.concurrent;

import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/concurrent/WorkThreadUtil.class */
public class WorkThreadUtil {
    public static final int DEFAULT_THREAD_POOL_MAX_CNT = 2;

    /* renamed from: a  reason: collision with root package name */
    private static ThreadPoolExecutor f8188a = new ThreadPoolExecutor(2, 2, 10, TimeUnit.MINUTES, new LinkedBlockingQueue(Integer.MAX_VALUE), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static Future<?> submit(Runnable runnable) {
        try {
            return f8188a.submit(runnable);
        } catch (Throwable th) {
            Log.e("efs.util.concurrent", "submit task error!", th);
            return null;
        }
    }
}
