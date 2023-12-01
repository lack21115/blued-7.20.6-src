package com.sobot.chat.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotExecutorService.class */
public class SobotExecutorService {
    private static ExecutorService executorService;

    public static ExecutorService executorService() {
        if (executorService == null) {
            synchronized (SobotExecutorService.class) {
                try {
                    if (executorService == null) {
                        executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory("sobot_Thread", false));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return executorService;
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.sobot.chat.utils.SobotExecutorService.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, String.this);
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
