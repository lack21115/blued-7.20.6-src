package com.heytap.mcssdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/utils/ThreadUtil.class */
public class ThreadUtil {
    private static final ExecutorService sFixedThreadExecutor = Executors.newSingleThreadExecutor();
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    public static void executeOnBackground(Runnable runnable) {
        sFixedThreadExecutor.execute(runnable);
    }

    public static void executeOnUiThread(Runnable runnable) {
        mainHandler.post(runnable);
    }
}
