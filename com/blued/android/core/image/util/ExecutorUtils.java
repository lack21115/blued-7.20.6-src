package com.blued.android.core.image.util;

import com.blued.android.core.pool.DefaultThreadFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/util/ExecutorUtils.class */
public class ExecutorUtils {
    private static ConcurrentHashMap<Integer, Future> a = new ConcurrentHashMap<>();
    private static ThreadPoolExecutor b = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory("image-http"), new ThreadPoolExecutor.DiscardOldestPolicy());
    private static ConcurrentHashMap<Integer, Future> c = new ConcurrentHashMap<>();
    private static ThreadPoolExecutor d = new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory("image-local"), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void a(int i, Runnable runnable) {
        if (runnable != null) {
            a.put(Integer.valueOf(i), b.submit(runnable));
        }
    }

    public static void b(int i, Runnable runnable) {
        if (runnable != null) {
            c.put(Integer.valueOf(i), d.submit(runnable));
        }
    }
}
