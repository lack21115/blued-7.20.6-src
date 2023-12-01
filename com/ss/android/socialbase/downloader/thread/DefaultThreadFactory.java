package com.ss.android.socialbase.downloader.thread;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/DefaultThreadFactory.class */
public class DefaultThreadFactory implements ThreadFactory {
    private final boolean ignoreStatusCheck;
    private final String threadName;
    private final AtomicInteger threadSeq;

    public DefaultThreadFactory(String str) {
        this(str, false);
    }

    public DefaultThreadFactory(String str, boolean z) {
        this.threadSeq = new AtomicInteger();
        this.threadName = str;
        this.ignoreStatusCheck = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.threadSeq.incrementAndGet();
        Thread thread = new Thread(runnable, this.threadName + Constants.ACCEPT_TIME_SEPARATOR_SERVER + incrementAndGet);
        if (!this.ignoreStatusCheck) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }
}
