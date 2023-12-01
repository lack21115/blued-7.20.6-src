package com.tencent.qcloud.core.task;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/task/TaskExecutors.class */
public class TaskExecutors {
    public static final ThreadPoolExecutor COMMAND_EXECUTOR = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(Integer.MAX_VALUE), new TaskThreadFactory("Command-", 8));
    public static final ThreadPoolExecutor UPLOAD_EXECUTOR = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new PriorityBlockingQueue(), new TaskThreadFactory("Upload-", 3));
    public static final ThreadPoolExecutor DOWNLOAD_EXECUTOR = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(Integer.MAX_VALUE), new TaskThreadFactory("Download-", 3));
    public static final UIThreadExecutor UI_THREAD_EXECUTOR = new UIThreadExecutor();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory.class */
    static final class TaskThreadFactory implements ThreadFactory {
        private final AtomicInteger increment = new AtomicInteger(1);
        private final int priority;
        private final String tag;

        TaskThreadFactory(String str, int i) {
            this.tag = str;
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "QCloud-" + this.tag + this.increment.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    static {
        UPLOAD_EXECUTOR.allowCoreThreadTimeOut(true);
        COMMAND_EXECUTOR.allowCoreThreadTimeOut(true);
        DOWNLOAD_EXECUTOR.allowCoreThreadTimeOut(true);
    }
}
