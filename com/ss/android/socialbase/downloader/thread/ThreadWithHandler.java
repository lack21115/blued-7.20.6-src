package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/ThreadWithHandler.class */
public class ThreadWithHandler {
    private InnerThread handlerThread;
    private Object lock = new Object();
    private Queue<MessageEntity> mCacheQueue = new ConcurrentLinkedQueue();
    private Handler mHandler;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/ThreadWithHandler$InnerThread.class */
    class InnerThread extends HandlerThread {
        InnerThread(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (ThreadWithHandler.this.lock) {
                ThreadWithHandler.this.mHandler = new Handler(looper);
            }
            while (!ThreadWithHandler.this.mCacheQueue.isEmpty()) {
                MessageEntity messageEntity = (MessageEntity) ThreadWithHandler.this.mCacheQueue.poll();
                if (messageEntity != null) {
                    ThreadWithHandler.this.mHandler.postDelayed(messageEntity.target, messageEntity.delayMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/ThreadWithHandler$MessageEntity.class */
    public class MessageEntity {
        public long delayMillis;
        public Runnable target;

        public MessageEntity(Runnable runnable, long j) {
            this.target = runnable;
            this.delayMillis = j;
        }
    }

    public ThreadWithHandler(String str) {
        this.handlerThread = new InnerThread(str);
    }

    public void post(Runnable runnable) {
        postDelayed(runnable, 0L);
    }

    public void postDelayed(Runnable runnable, long j) {
        if (this.mHandler == null) {
            synchronized (this.lock) {
                if (this.mHandler == null) {
                    this.mCacheQueue.add(new MessageEntity(runnable, j));
                    return;
                }
            }
        }
        this.mHandler.postDelayed(runnable, j);
    }

    public void quit() {
        this.handlerThread.quit();
    }

    public void start() {
        this.handlerThread.start();
    }
}
