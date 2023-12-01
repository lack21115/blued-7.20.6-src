package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPScreenRefreshRateDetector.class */
public class TPScreenRefreshRateDetector {
    public static final int DISPLAY_CHANGE = 10001;
    private static String TAG = "TPScreenRefreshRateDetector";
    private static boolean isInitted = false;
    private static WeakReference<Context> mContext;
    private static Handler mHandler;
    private static WindowManager mWindowManager;
    private static List<ScreenRefreshRateChangedListener> listeners = new LinkedList();
    private static float mCurScreenRefreshRate = 60.0f;
    private static DisplayManager mDisplayManager = null;
    private static DisplayManager.DisplayListener mDisplayListener = new DisplayManager.DisplayListener() { // from class: com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.2
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            if (i == 0) {
                TPScreenRefreshRateDetector.mHandler.sendEmptyMessage(10001);
            }
            TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "onDisplayChanged displayId:".concat(String.valueOf(i)));
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPScreenRefreshRateDetector$ScreenRefreshRateChangedListener.class */
    public interface ScreenRefreshRateChangedListener {
        void onScreenRefreshRateChanged(float f);
    }

    public static void addListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                listeners.add(screenRefreshRateChangedListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void deinit() {
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                if (isInitted && mContext != null) {
                    mContext.clear();
                    isInitted = false;
                    TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector deinit succeed!");
                }
            } finally {
            }
        }
    }

    private static Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static float getScreenRefreshRate() {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT < 23) {
            str = TAG;
            str2 = "Current version can not get screen refresh rate, set default.";
        } else {
            WeakReference<Context> weakReference = mContext;
            if (weakReference != null) {
                Context context = weakReference.get();
                if (context != null) {
                    if (mWindowManager == null) {
                        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    }
                    if (mDisplayManager == null) {
                        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
                        mDisplayManager = displayManager;
                        displayManager.registerDisplayListener(mDisplayListener, mHandler);
                    }
                    WindowManager windowManager = mWindowManager;
                    if (windowManager != null) {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
                        Display.Mode mode = defaultDisplay.getMode();
                        String str3 = TAG;
                        TPNativeLog.printLog(2, str3, "getMode width:" + mode.getPhysicalWidth() + " height:" + mode.getPhysicalHeight() + " refreshRate:" + mode.getRefreshRate() + " ModeId:" + mode.getModeId());
                        String str4 = TAG;
                        StringBuilder sb = new StringBuilder("getSupportedModes length:");
                        sb.append(supportedModes.length);
                        TPNativeLog.printLog(2, str4, sb.toString());
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= supportedModes.length) {
                                break;
                            }
                            String str5 = TAG;
                            TPNativeLog.printLog(2, str5, "getSupportedModes width:" + supportedModes[i2].getPhysicalWidth() + " height:" + supportedModes[i2].getPhysicalHeight() + " refreshRate:" + supportedModes[i2].getRefreshRate() + " ModeId:" + supportedModes[i2].getModeId());
                            i = i2 + 1;
                        }
                        mCurScreenRefreshRate = mode.getRefreshRate();
                    }
                }
                return mCurScreenRefreshRate;
            }
            str = TAG;
            str2 = "Current mContext is null, set default.";
        }
        TPNativeLog.printLog(4, str, str2);
        return mCurScreenRefreshRate;
    }

    public static void init(Context context) {
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init enter!");
                if (isInitted) {
                    return;
                }
                mContext = new WeakReference<>(context.getApplicationContext());
                isInitted = true;
                initHandleMsg();
                TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init succeed!");
            } finally {
            }
        }
    }

    public static void initHandleMsg() {
        mHandler = new Handler(getLooper()) { // from class: com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10001 && TPScreenRefreshRateDetector.mDisplayManager != null) {
                    Display display = TPScreenRefreshRateDetector.mDisplayManager.getDisplay(0);
                    String mode = display.getMode().toString();
                    String str = TPScreenRefreshRateDetector.TAG;
                    TPNativeLog.printLog(2, str, "handleMessage DISPLAY_CHANGE, mode:" + mode.toString());
                    TPScreenRefreshRateDetector.notifyScreenRefreshRateChange(display.getMode().getRefreshRate());
                }
                super.handleMessage(message);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyScreenRefreshRateChange(float f) {
        boolean z;
        if (Math.abs(f - mCurScreenRefreshRate) >= 1.0f) {
            TPNativeLog.printLog(2, TAG, "notifyScreenRefreshRateChange Change From " + mCurScreenRefreshRate + " to " + f);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            mCurScreenRefreshRate = f;
            synchronized (TPScreenRefreshRateDetector.class) {
                try {
                    for (ScreenRefreshRateChangedListener screenRefreshRateChangedListener : listeners) {
                        screenRefreshRateChangedListener.onScreenRefreshRateChanged(f);
                    }
                } finally {
                }
            }
        }
    }

    public static void removeListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                listeners.remove(screenRefreshRateChangedListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
