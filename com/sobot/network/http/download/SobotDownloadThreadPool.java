package com.sobot.network.http.download;

import com.sobot.network.http.task.PriorityBlockingQueue;
import com.sobot.network.http.task.XExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/download/SobotDownloadThreadPool.class */
public class SobotDownloadThreadPool {
    private static final int KEEP_ALIVE_TIME = 1;
    private static final int MAX_POOL_SIZE = 5;
    private static final TimeUnit UNIT = TimeUnit.HOURS;
    private int corePoolSize = 3;
    private XExecutor executor;

    public void execute(Runnable runnable) {
        if (runnable != null) {
            getExecutor().execute(runnable);
        }
    }

    public XExecutor getExecutor() {
        if (this.executor == null) {
            synchronized (SobotDownloadThreadPool.class) {
                try {
                    if (this.executor == null) {
                        this.executor = new XExecutor(this.corePoolSize, 5, 1L, UNIT, new PriorityBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.executor;
    }

    public void remove(Runnable runnable) {
        if (runnable != null) {
            getExecutor().remove(runnable);
        }
    }

    public void setCorePoolSize(int i) {
        int i2 = i;
        if (i <= 0) {
            i2 = 1;
        }
        int i3 = i2;
        if (i2 > 5) {
            i3 = 5;
        }
        this.corePoolSize = i3;
    }
}
