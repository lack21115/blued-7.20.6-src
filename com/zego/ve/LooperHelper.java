package com.zego.ve;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/LooperHelper.class */
public class LooperHelper {
    private static LooperHelper gInstance;
    private Handler mHandler;
    private HandlerThread mThread;

    public LooperHelper() {
        this.mThread = null;
        this.mHandler = null;
        HandlerThread handlerThread = new HandlerThread("dead-loop");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    public static LooperHelper getInstance() {
        if (gInstance == null) {
            gInstance = new LooperHelper();
        }
        return gInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int on_run(long j, int i);

    public static int postMsg(final long j, final int i) {
        getInstance().mHandler.post(new Runnable() { // from class: com.zego.ve.LooperHelper.1
            @Override // java.lang.Runnable
            public void run() {
                LooperHelper.on_run(j, i);
            }
        });
        return 0;
    }
}
