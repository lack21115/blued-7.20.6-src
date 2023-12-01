package com.huawei.hms.framework.common;

import android.content.Context;
import com.anythink.expressad.foundation.g.b.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/AssetsUtil.class */
public class AssetsUtil {
    private static final int GET_SP_TIMEOUT = 5;
    private static final String TAG = "AssetsUtil";
    private static final String THREAD_NAME = "AssetsUtil_Operate";
    private static final ExecutorService EXECUTOR_SERVICE = ExecutorsUtils.newSingleThreadExecutor(THREAD_NAME);

    public static String[] list(final Context context, final String str) {
        if (context == null) {
            Logger.w(TAG, b.f4996a);
            return new String[0];
        }
        FutureTask futureTask = new FutureTask(new Callable<String[]>() { // from class: com.huawei.hms.framework.common.AssetsUtil.1
            @Override // java.util.concurrent.Callable
            public String[] call() throws Exception {
                return Context.this.getAssets().list(str);
            }
        });
        EXECUTOR_SERVICE.execute(futureTask);
        try {
            try {
                try {
                    try {
                        try {
                            return (String[]) futureTask.get(5L, TimeUnit.SECONDS);
                        } catch (InterruptedException e) {
                            Logger.w(TAG, "get local config files from sp task interrupted", e);
                            futureTask.cancel(true);
                            return new String[0];
                        }
                    } catch (ExecutionException e2) {
                        Logger.w(TAG, "get local config files from sp task failed", e2);
                        futureTask.cancel(true);
                        return new String[0];
                    }
                } catch (Exception e3) {
                    Logger.w(TAG, "get local config files from sp task occur unknown Exception");
                    futureTask.cancel(true);
                    return new String[0];
                }
            } catch (TimeoutException e4) {
                Logger.w(TAG, "get local config files from sp task timed out");
                futureTask.cancel(true);
                return new String[0];
            }
        } finally {
            futureTask.cancel(true);
        }
    }

    public static InputStream open(Context context, String str) throws IOException {
        if (context == null) {
            Logger.w(TAG, b.f4996a);
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (RuntimeException e) {
            Logger.e(TAG, "AssetManager has been destroyed", e);
            return null;
        }
    }
}
