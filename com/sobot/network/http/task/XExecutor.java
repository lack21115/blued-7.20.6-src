package com.sobot.network.http.task;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/XExecutor.class */
public class XExecutor extends ThreadPoolExecutor {
    private List<OnAllTaskEndListener> allTaskEndListenerList;
    private Handler innerHandler;
    private List<OnTaskEndListener> taskEndListenerList;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/XExecutor$OnAllTaskEndListener.class */
    public interface OnAllTaskEndListener {
        void onAllTaskEnd();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/XExecutor$OnTaskEndListener.class */
    public interface OnTaskEndListener {
        void onTaskEnd(Runnable runnable);
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, rejectedExecutionHandler);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public void addOnAllTaskEndListener(OnAllTaskEndListener onAllTaskEndListener) {
        if (this.allTaskEndListenerList == null) {
            this.allTaskEndListenerList = new ArrayList();
        }
        this.allTaskEndListenerList.add(onAllTaskEndListener);
    }

    public void addOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        if (this.taskEndListenerList == null) {
            this.taskEndListenerList = new ArrayList();
        }
        this.taskEndListenerList.add(onTaskEndListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(final Runnable runnable, Throwable th) {
        List<OnAllTaskEndListener> list;
        super.afterExecute(runnable, th);
        List<OnTaskEndListener> list2 = this.taskEndListenerList;
        if (list2 != null && list2.size() > 0) {
            for (final OnTaskEndListener onTaskEndListener : this.taskEndListenerList) {
                this.innerHandler.post(new Runnable() { // from class: com.sobot.network.http.task.XExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onTaskEndListener.onTaskEnd(runnable);
                    }
                });
            }
        }
        if (getActiveCount() != 1 || getQueue().size() != 0 || (list = this.allTaskEndListenerList) == null || list.size() <= 0) {
            return;
        }
        for (final OnAllTaskEndListener onAllTaskEndListener : this.allTaskEndListenerList) {
            this.innerHandler.post(new Runnable() { // from class: com.sobot.network.http.task.XExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    onAllTaskEndListener.onAllTaskEnd();
                }
            });
        }
    }

    public void removeOnAllTaskEndListener(OnAllTaskEndListener onAllTaskEndListener) {
        this.allTaskEndListenerList.remove(onAllTaskEndListener);
    }

    public void removeOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        this.taskEndListenerList.remove(onTaskEndListener);
    }
}
