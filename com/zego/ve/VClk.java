package com.zego.ve;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VClk.class */
public class VClk {
    private static final int MESSAGE_RESTART = 2;
    private static final int MESSAGE_START = 0;
    private static final int MESSAGE_STOP = 1;
    private static final String TAG = "VClk";
    private static VClk sInstance = new VClk();
    private EventHandler mCallback;
    private Handler mHandler;
    private HandlerThread mThread;
    private long pThis = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VClk$EventHandler.class */
    static class EventHandler implements Handler.Callback, Choreographer.FrameCallback {
        private AtomicLong mAtomicThis;
        private boolean mRunning;

        private EventHandler() {
            this.mAtomicThis = new AtomicLong();
            this.mRunning = false;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (this.mRunning) {
                long j2 = this.mAtomicThis.get();
                if (j2 == 0) {
                    return;
                }
                VClk.on_video_tick(j2, j);
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (this.mRunning) {
                    return false;
                }
                this.mRunning = true;
                try {
                    Choreographer.getInstance().postFrameCallback(this);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    long j = this.mAtomicThis.get();
                    if (j != 0) {
                        VClk.on_error(j);
                        return false;
                    }
                    return false;
                }
            }
            try {
            } catch (Exception e2) {
                return false;
            }
            if (message.what != 1) {
                if (message.what == 2) {
                    Choreographer.getInstance().removeFrameCallback(this);
                    Choreographer.getInstance().postFrameCallback(this);
                    return false;
                }
                return false;
            } else if (this.mRunning) {
                this.mRunning = false;
                Choreographer.getInstance().removeFrameCallback(this);
                if (Build.VERSION.SDK_INT >= 28) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        try {
                            Choreographer.class.getMethod("releaseInstance", new Class[0]).invoke(null, new Object[0]);
                            return false;
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                            return false;
                        } catch (NoSuchMethodException e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                        return false;
                    }
                } else if (Build.VERSION.SDK_INT >= 16) {
                    Choreographer choreographer = Choreographer.getInstance();
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        Field declaredField = Choreographer.class.getDeclaredField("sThreadInstance");
                                        declaredField.setAccessible(true);
                                        ((ThreadLocal) declaredField.get(null)).remove();
                                        Field declaredField2 = Choreographer.class.getDeclaredField("mDisplayEventReceiver");
                                        declaredField2.setAccessible(true);
                                        Object obj = declaredField2.get(choreographer);
                                        obj.getClass().getMethod("dispose", new Class[0]).invoke(obj, new Object[0]);
                                        return false;
                                    } catch (NullPointerException e6) {
                                        e6.printStackTrace();
                                        return false;
                                    }
                                } catch (InvocationTargetException e7) {
                                    e7.printStackTrace();
                                    return false;
                                }
                            } catch (NoSuchFieldException e8) {
                                e8.printStackTrace();
                                return false;
                            }
                        } catch (NoSuchMethodException e9) {
                            e9.printStackTrace();
                            return false;
                        }
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                        return false;
                    }
                } else {
                    return false;
                }
                return false;
            } else {
                return false;
            }
        }

        public void init(long j) {
            this.mAtomicThis.set(j);
        }

        public void uninit() {
            this.mAtomicThis.set(0L);
        }
    }

    VClk() {
        this.mThread = null;
        this.mCallback = null;
        this.mHandler = null;
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mCallback = new EventHandler();
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
    }

    private static VClk getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int on_error(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int on_video_tick(long j, long j2);

    public int restartClock() {
        if (this.pThis != 0) {
            this.mHandler.sendEmptyMessage(2);
            return 0;
        }
        return 0;
    }

    public int start(long j) {
        this.pThis = j;
        return 0;
    }

    public int startClock() {
        long j = this.pThis;
        if (j != 0) {
            this.mCallback.init(j);
            this.mHandler.sendEmptyMessage(0);
            return 0;
        }
        return 0;
    }

    public int stop(long j) {
        this.mHandler.removeCallbacksAndMessages(null);
        this.pThis = 0L;
        return 0;
    }

    public int stopClock() {
        if (this.pThis != 0) {
            this.mHandler.sendEmptyMessage(1);
            this.mCallback.uninit();
            return 0;
        }
        return 0;
    }
}
