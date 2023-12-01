package com.tencent.thumbplayer.core.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/utils/TPThreadPool.class */
public class TPThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 20;
    private static final String PRE_THREAD_NAME = "TPCoreHdr";
    private static final String SHARE_THREAD_NAME = "TPCore-ShareThread";
    private static final String TAG = "TPCore[TPThreadPool]";
    private static volatile ExecutorService sCustomExecutor;
    private static volatile HandlerThread sHandlerThread;
    private static volatile TPThreadPool sInstance;
    private static volatile Handler sMainThreadHandler;
    private static volatile ScheduledExecutorService sScheduler;
    private static volatile ExecutorService sShareSingleExecutor;
    private static int sShareThreadCount;

    private TPThreadPool() {
    }

    public static TPThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (TPThreadPool.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new TPThreadPool();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0018, B:12:0x002e, B:14:0x0037, B:16:0x0052, B:9:0x001e, B:11:0x0027), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void initHandlerThread() {
        /*
            java.lang.Class<com.tencent.thumbplayer.core.utils.TPThreadPool> r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.class
            monitor-enter(r0)
            android.os.HandlerThread r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L1e
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L54
            r1 = r0
            java.lang.String r2 = "TPCore-ShareThread"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L54
            r4 = r0
            r0 = r4
            com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread = r0     // Catch: java.lang.Throwable -> L54
        L17:
            r0 = r4
            r0.start()     // Catch: java.lang.Throwable -> L54
            goto L2e
        L1e:
            android.os.HandlerThread r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.isAlive()     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L2e
            android.os.HandlerThread r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread     // Catch: java.lang.Throwable -> L54
            r4 = r0
            goto L17
        L2e:
            android.os.HandlerThread r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread     // Catch: java.lang.Throwable -> L54
            android.os.Looper r0 = r0.getLooper()     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L50
            android.os.HandlerThread r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.quit()     // Catch: java.lang.Throwable -> L54
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L54
            r1 = r0
            java.lang.String r2 = "TPCore-ShareThread"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L54
            r4 = r0
            r0 = r4
            com.tencent.thumbplayer.core.utils.TPThreadPool.sHandlerThread = r0     // Catch: java.lang.Throwable -> L54
            r0 = r4
            r0.start()     // Catch: java.lang.Throwable -> L54
        L50:
            java.lang.Class<com.tencent.thumbplayer.core.utils.TPThreadPool> r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L54
            return
        L54:
            r4 = move-exception
            java.lang.Class<com.tencent.thumbplayer.core.utils.TPThreadPool> r0 = com.tencent.thumbplayer.core.utils.TPThreadPool.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L54
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.utils.TPThreadPool.initHandlerThread():void");
    }

    private static void initMainThreadHandler() {
        if (sMainThreadHandler != null) {
            return;
        }
        synchronized (TPThreadPool.class) {
            try {
                if (sMainThreadHandler != null) {
                    return;
                }
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper != null) {
                    sMainThreadHandler = new Handler(mainLooper);
                } else {
                    sMainThreadHandler = null;
                    TPNativeLog.printLog(4, TAG, "cannot get thread looper");
                }
            } finally {
            }
        }
    }

    public HandlerThread obtainHandleThread(String str) {
        return obtainHandleThread(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
        if (r7 <= (-19)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.HandlerThread obtainHandleThread(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = r7
            r1 = 19
            if (r0 >= r1) goto Le
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = -19
            if (r0 > r1) goto L10
        Le:
            r0 = 0
            r8 = r0
        L10:
            r0 = r6
            r9 = r0
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1e
            java.lang.String r0 = "TPCoreHdr"
            r9 = r0
        L1e:
            android.os.HandlerThread r0 = new android.os.HandlerThread
            r1 = r0
            r2 = r9
            r3 = r8
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            r0.start()
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.utils.TPThreadPool.obtainHandleThread(java.lang.String, int):android.os.HandlerThread");
    }

    public ScheduledExecutorService obtainScheduledExecutorService() {
        if (sScheduler == null) {
            synchronized (TPThreadPool.class) {
                try {
                    if (sScheduler == null) {
                        sScheduler = Executors.newScheduledThreadPool(1);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sScheduler;
    }

    public HandlerThread obtainShareThread() {
        HandlerThread handlerThread;
        initHandlerThread();
        synchronized (TPThreadPool.class) {
            try {
                sShareThreadCount++;
                TPNativeLog.printLog(2, TAG, "handlerThread obtainShareThread mShareThreadCount:" + sShareThreadCount);
                handlerThread = sHandlerThread;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handlerThread;
    }

    public ExecutorService obtainSingleThreadExecutor() {
        if (sShareSingleExecutor == null) {
            synchronized (TPThreadPool.class) {
                try {
                    if (sShareSingleExecutor == null) {
                        sShareSingleExecutor = Executors.newSingleThreadExecutor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sShareSingleExecutor;
    }

    public ExecutorService obtainThreadExecutor() {
        if (sCustomExecutor == null) {
            synchronized (TPThreadPool.class) {
                try {
                    if (sCustomExecutor == null) {
                        sCustomExecutor = TPThreadPoolExecutor.newCustomThreadExecutor(1, 20);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sCustomExecutor;
    }

    public void postDelayRunnableOnMainThread(Runnable runnable, long j) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postDelayed(runnable, j);
        }
    }

    public void postRunnableOnMainThread(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.post(runnable);
        }
    }

    public void postRunnableOnMainThreadFront(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postAtFrontOfQueue(runnable);
        }
    }

    public void recycle(HandlerThread handlerThread, Handler handler) {
        if (handlerThread == null) {
            return;
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (!handlerThread.equals(sHandlerThread)) {
            handlerThread.quit();
            return;
        }
        synchronized (TPThreadPool.class) {
            try {
                sShareThreadCount--;
                TPNativeLog.printLog(2, TAG, "handlerThread recycle mShareThreadCount:" + sShareThreadCount);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
