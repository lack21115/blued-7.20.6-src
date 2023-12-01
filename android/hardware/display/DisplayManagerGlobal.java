package android.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.IDisplayManager;
import android.hardware.display.IDisplayManagerCallback;
import android.hardware.display.IVirtualDisplayCallback;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayAdjustments;
import android.view.DisplayInfo;
import android.view.Surface;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerGlobal.class */
public final class DisplayManagerGlobal {
    private static final boolean DEBUG = false;
    public static final int EVENT_DISPLAY_ADDED = 1;
    public static final int EVENT_DISPLAY_CHANGED = 2;
    public static final int EVENT_DISPLAY_REMOVED = 3;
    private static final String TAG = "DisplayManager";
    private static final boolean USE_CACHE = false;
    private static DisplayManagerGlobal sInstance;
    private DisplayManagerCallback mCallback;
    private int[] mDisplayIdCache;
    private final IDisplayManager mDm;
    private int mWifiDisplayScanNestCount;
    private final Object mLock = new Object();
    private final ArrayList<DisplayListenerDelegate> mDisplayListeners = new ArrayList<>();
    private final SparseArray<DisplayInfo> mDisplayInfoCache = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerGlobal$DisplayListenerDelegate.class */
    public static final class DisplayListenerDelegate extends Handler {
        public final DisplayManager.DisplayListener mListener;

        public DisplayListenerDelegate(DisplayManager.DisplayListener displayListener, Handler handler) {
            super(handler != null ? handler.getLooper() : Looper.myLooper(), null, true);
            this.mListener = displayListener;
        }

        public void clearEvents() {
            removeCallbacksAndMessages(null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.mListener.onDisplayAdded(message.arg1);
                    return;
                case 2:
                    this.mListener.onDisplayChanged(message.arg1);
                    return;
                case 3:
                    this.mListener.onDisplayRemoved(message.arg1);
                    return;
                default:
                    return;
            }
        }

        public void sendDisplayEvent(int i, int i2) {
            sendMessage(obtainMessage(i2, i, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerGlobal$DisplayManagerCallback.class */
    public final class DisplayManagerCallback extends IDisplayManagerCallback.Stub {
        private DisplayManagerCallback() {
        }

        @Override // android.hardware.display.IDisplayManagerCallback
        public void onDisplayEvent(int i, int i2) {
            DisplayManagerGlobal.this.handleDisplayEvent(i, i2);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerGlobal$VirtualDisplayCallback.class */
    private static final class VirtualDisplayCallback extends IVirtualDisplayCallback.Stub {
        private VirtualDisplayCallbackDelegate mDelegate;

        public VirtualDisplayCallback(VirtualDisplay.Callback callback, Handler handler) {
            if (callback != null) {
                this.mDelegate = new VirtualDisplayCallbackDelegate(callback, handler);
            }
        }

        @Override // android.hardware.display.IVirtualDisplayCallback
        public void onPaused() {
            if (this.mDelegate != null) {
                this.mDelegate.sendEmptyMessage(0);
            }
        }

        @Override // android.hardware.display.IVirtualDisplayCallback
        public void onResumed() {
            if (this.mDelegate != null) {
                this.mDelegate.sendEmptyMessage(1);
            }
        }

        @Override // android.hardware.display.IVirtualDisplayCallback
        public void onStopped() {
            if (this.mDelegate != null) {
                this.mDelegate.sendEmptyMessage(2);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerGlobal$VirtualDisplayCallbackDelegate.class */
    private static final class VirtualDisplayCallbackDelegate extends Handler {
        public static final int MSG_DISPLAY_PAUSED = 0;
        public static final int MSG_DISPLAY_RESUMED = 1;
        public static final int MSG_DISPLAY_STOPPED = 2;
        private final VirtualDisplay.Callback mCallback;

        public VirtualDisplayCallbackDelegate(VirtualDisplay.Callback callback, Handler handler) {
            super(handler != null ? handler.getLooper() : Looper.myLooper(), null, true);
            this.mCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.mCallback.onPaused();
                    return;
                case 1:
                    this.mCallback.onResumed();
                    return;
                case 2:
                    this.mCallback.onStopped();
                    return;
                default:
                    return;
            }
        }
    }

    private DisplayManagerGlobal(IDisplayManager iDisplayManager) {
        this.mDm = iDisplayManager;
    }

    private int findDisplayListenerLocked(DisplayManager.DisplayListener displayListener) {
        int size = this.mDisplayListeners.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            if (this.mDisplayListeners.get(i2).mListener == displayListener) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static DisplayManagerGlobal getInstance() {
        DisplayManagerGlobal displayManagerGlobal;
        IBinder service;
        synchronized (DisplayManagerGlobal.class) {
            try {
                if (sInstance == null && (service = ServiceManager.getService("display")) != null) {
                    sInstance = new DisplayManagerGlobal(IDisplayManager.Stub.asInterface(service));
                }
                displayManagerGlobal = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return displayManagerGlobal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDisplayEvent(int i, int i2) {
        synchronized (this.mLock) {
            int size = this.mDisplayListeners.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < size) {
                    this.mDisplayListeners.get(i4).sendDisplayEvent(i, i2);
                    i3 = i4 + 1;
                }
            }
        }
    }

    private void registerCallbackIfNeededLocked() {
        if (this.mCallback == null) {
            this.mCallback = new DisplayManagerCallback();
            try {
                this.mDm.registerCallback(this.mCallback);
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to register callback with display manager service.", e);
                this.mCallback = null;
            }
        }
    }

    public void connectWifiDisplay(String str) {
        if (str == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }
        try {
            this.mDm.connectWifiDisplay(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to connect to Wifi display " + str + ".", e);
        }
    }

    public VirtualDisplay createVirtualDisplay(Context context, MediaProjection mediaProjection, String str, int i, int i2, int i3, Surface surface, int i4, VirtualDisplay.Callback callback, Handler handler) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name must be non-null and non-empty");
        }
        if (i <= 0 || i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("width, height, and densityDpi must be greater than 0");
        }
        VirtualDisplayCallback virtualDisplayCallback = new VirtualDisplayCallback(callback, handler);
        try {
            int createVirtualDisplay = this.mDm.createVirtualDisplay(virtualDisplayCallback, mediaProjection != null ? mediaProjection.getProjection() : null, context.getPackageName(), str, i, i2, i3, surface, i4);
            if (createVirtualDisplay < 0) {
                Log.e(TAG, "Could not create virtual display: " + str);
                return null;
            }
            Display realDisplay = getRealDisplay(createVirtualDisplay);
            if (realDisplay == null) {
                Log.wtf(TAG, "Could not obtain display info for newly created virtual display: " + str);
                try {
                    this.mDm.releaseVirtualDisplay(virtualDisplayCallback);
                    return null;
                } catch (RemoteException e) {
                    return null;
                }
            }
            return new VirtualDisplay(this, realDisplay, virtualDisplayCallback, surface);
        } catch (RemoteException e2) {
            Log.e(TAG, "Could not create virtual display: " + str, e2);
            return null;
        }
    }

    public void disconnectWifiDisplay() {
        try {
            this.mDm.disconnectWifiDisplay();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to disconnect from Wifi display.", e);
        }
    }

    public void forgetWifiDisplay(String str) {
        if (str == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }
        try {
            this.mDm.forgetWifiDisplay(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to forget Wifi display.", e);
        }
    }

    public Display getCompatibleDisplay(int i, DisplayAdjustments displayAdjustments) {
        DisplayInfo displayInfo = getDisplayInfo(i);
        if (displayInfo == null) {
            return null;
        }
        return new Display(this, i, displayInfo, displayAdjustments);
    }

    public int[] getDisplayIds() {
        int[] displayIds;
        try {
            synchronized (this.mLock) {
                displayIds = this.mDm.getDisplayIds();
                registerCallbackIfNeededLocked();
            }
            return displayIds;
        } catch (RemoteException e) {
            Log.e(TAG, "Could not get display ids from display manager.", e);
            return new int[]{0};
        }
    }

    public DisplayInfo getDisplayInfo(int i) {
        try {
            synchronized (this.mLock) {
                DisplayInfo displayInfo = this.mDm.getDisplayInfo(i);
                if (displayInfo == null) {
                    return null;
                }
                registerCallbackIfNeededLocked();
                return displayInfo;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Could not get display information from display manager.", e);
            return null;
        }
    }

    public Display getRealDisplay(int i) {
        return getCompatibleDisplay(i, DisplayAdjustments.DEFAULT_DISPLAY_ADJUSTMENTS);
    }

    public Display getRealDisplay(int i, IBinder iBinder) {
        return getCompatibleDisplay(i, new DisplayAdjustments(iBinder));
    }

    public WifiDisplayStatus getWifiDisplayStatus() {
        try {
            return this.mDm.getWifiDisplayStatus();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get Wifi display status.", e);
            return new WifiDisplayStatus();
        }
    }

    public void pauseWifiDisplay() {
        try {
            this.mDm.pauseWifiDisplay();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to pause Wifi display.", e);
        }
    }

    public void registerDisplayListener(DisplayManager.DisplayListener displayListener, Handler handler) {
        if (displayListener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        synchronized (this.mLock) {
            if (findDisplayListenerLocked(displayListener) < 0) {
                this.mDisplayListeners.add(new DisplayListenerDelegate(displayListener, handler));
                registerCallbackIfNeededLocked();
            }
        }
    }

    public void releaseVirtualDisplay(IVirtualDisplayCallback iVirtualDisplayCallback) {
        try {
            this.mDm.releaseVirtualDisplay(iVirtualDisplayCallback);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to release virtual display.", e);
        }
    }

    public void renameWifiDisplay(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }
        try {
            this.mDm.renameWifiDisplay(str, str2);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to rename Wifi display " + str + " with alias " + str2 + ".", e);
        }
    }

    public void resizeVirtualDisplay(IVirtualDisplayCallback iVirtualDisplayCallback, int i, int i2, int i3) {
        try {
            this.mDm.resizeVirtualDisplay(iVirtualDisplayCallback, i, i2, i3);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to resize virtual display.", e);
        }
    }

    public void resumeWifiDisplay() {
        try {
            this.mDm.resumeWifiDisplay();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to resume Wifi display.", e);
        }
    }

    public void setVirtualDisplaySurface(IVirtualDisplayCallback iVirtualDisplayCallback, Surface surface) {
        try {
            this.mDm.setVirtualDisplaySurface(iVirtualDisplayCallback, surface);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to set virtual display surface.", e);
        }
    }

    public void startWifiDisplayScan() {
        synchronized (this.mLock) {
            int i = this.mWifiDisplayScanNestCount;
            this.mWifiDisplayScanNestCount = i + 1;
            if (i == 0) {
                registerCallbackIfNeededLocked();
                try {
                    this.mDm.startWifiDisplayScan();
                } catch (RemoteException e) {
                    Log.e(TAG, "Failed to scan for Wifi displays.", e);
                }
            }
        }
    }

    public void stopWifiDisplayScan() {
        synchronized (this.mLock) {
            int i = this.mWifiDisplayScanNestCount - 1;
            this.mWifiDisplayScanNestCount = i;
            if (i == 0) {
                try {
                    this.mDm.stopWifiDisplayScan();
                } catch (RemoteException e) {
                    Log.e(TAG, "Failed to scan for Wifi displays.", e);
                }
            } else if (this.mWifiDisplayScanNestCount < 0) {
                Log.wtf(TAG, "Wifi display scan nest count became negative: " + this.mWifiDisplayScanNestCount);
                this.mWifiDisplayScanNestCount = 0;
            }
        }
    }

    public void unregisterDisplayListener(DisplayManager.DisplayListener displayListener) {
        if (displayListener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        synchronized (this.mLock) {
            int findDisplayListenerLocked = findDisplayListenerLocked(displayListener);
            if (findDisplayListenerLocked >= 0) {
                this.mDisplayListeners.get(findDisplayListenerLocked).clearEvents();
                this.mDisplayListeners.remove(findDisplayListenerLocked);
            }
        }
    }
}
