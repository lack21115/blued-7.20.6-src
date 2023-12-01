package android.app;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.accessibilityservice.IAccessibilityServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.display.DisplayManagerGlobal;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.WindowAnimationFrameStats;
import android.view.WindowContentFrameStats;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import libcore.io.IoUtils;

/* loaded from: source-9557208-dex2jar.jar:android/app/UiAutomation.class */
public final class UiAutomation {
    private static final int CONNECTION_ID_UNDEFINED = -1;
    private static final long CONNECT_TIMEOUT_MILLIS = 5000;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = UiAutomation.class.getSimpleName();
    public static final int ROTATION_FREEZE_0 = 0;
    public static final int ROTATION_FREEZE_180 = 2;
    public static final int ROTATION_FREEZE_270 = 3;
    public static final int ROTATION_FREEZE_90 = 1;
    public static final int ROTATION_FREEZE_CURRENT = -1;
    public static final int ROTATION_UNFREEZE = -2;
    private final IAccessibilityServiceClient mClient;
    private boolean mIsConnecting;
    private long mLastEventTimeMillis;
    private OnAccessibilityEventListener mOnAccessibilityEventListener;
    private final IUiAutomationConnection mUiAutomationConnection;
    private boolean mWaitingForEventDelivery;
    private final Object mLock = new Object();
    private final ArrayList<AccessibilityEvent> mEventQueue = new ArrayList<>();
    private int mConnectionId = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/app/UiAutomation$AccessibilityEventFilter.class */
    public interface AccessibilityEventFilter {
        boolean accept(AccessibilityEvent accessibilityEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/UiAutomation$IAccessibilityServiceClientImpl.class */
    private class IAccessibilityServiceClientImpl extends AccessibilityService.IAccessibilityServiceClientWrapper {
        public IAccessibilityServiceClientImpl(Looper looper) {
            super(null, looper, new AccessibilityService.Callbacks() { // from class: android.app.UiAutomation.IAccessibilityServiceClientImpl.1
                @Override // android.accessibilityservice.AccessibilityService.Callbacks
                public void init(int i, IBinder iBinder) {
                    synchronized (UiAutomation.this.mLock) {
                        UiAutomation.this.mConnectionId = i;
                        UiAutomation.this.mLock.notifyAll();
                    }
                }

                @Override // android.accessibilityservice.AccessibilityService.Callbacks
                public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
                    synchronized (UiAutomation.this.mLock) {
                        UiAutomation.this.mLastEventTimeMillis = accessibilityEvent.getEventTime();
                        if (UiAutomation.this.mWaitingForEventDelivery) {
                            UiAutomation.this.mEventQueue.add(AccessibilityEvent.obtain(accessibilityEvent));
                        }
                        UiAutomation.this.mLock.notifyAll();
                    }
                    OnAccessibilityEventListener onAccessibilityEventListener = UiAutomation.this.mOnAccessibilityEventListener;
                    if (onAccessibilityEventListener != null) {
                        onAccessibilityEventListener.onAccessibilityEvent(AccessibilityEvent.obtain(accessibilityEvent));
                    }
                }

                @Override // android.accessibilityservice.AccessibilityService.Callbacks
                public boolean onGesture(int i) {
                    return false;
                }

                @Override // android.accessibilityservice.AccessibilityService.Callbacks
                public void onInterrupt() {
                }

                @Override // android.accessibilityservice.AccessibilityService.Callbacks
                public boolean onKeyEvent(KeyEvent keyEvent) {
                    return false;
                }

                @Override // android.accessibilityservice.AccessibilityService.Callbacks
                public void onServiceConnected() {
                }
            });
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/UiAutomation$OnAccessibilityEventListener.class */
    public interface OnAccessibilityEventListener {
        void onAccessibilityEvent(AccessibilityEvent accessibilityEvent);
    }

    public UiAutomation(Looper looper, IUiAutomationConnection iUiAutomationConnection) {
        if (looper == null) {
            throw new IllegalArgumentException("Looper cannot be null!");
        }
        if (iUiAutomationConnection == null) {
            throw new IllegalArgumentException("Connection cannot be null!");
        }
        this.mUiAutomationConnection = iUiAutomationConnection;
        this.mClient = new IAccessibilityServiceClientImpl(looper);
    }

    private static float getDegreesForRotation(int i) {
        switch (i) {
            case 1:
                return 270.0f;
            case 2:
                return 180.0f;
            case 3:
                return 90.0f;
            default:
                return 0.0f;
        }
    }

    private boolean isConnectedLocked() {
        return this.mConnectionId != -1;
    }

    private void throwIfConnectedLocked() {
        if (this.mConnectionId != -1) {
            throw new IllegalStateException("UiAutomation not connected!");
        }
    }

    private void throwIfNotConnectedLocked() {
        if (!isConnectedLocked()) {
            throw new IllegalStateException("UiAutomation not connected!");
        }
    }

    public void clearWindowAnimationFrameStats() {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        try {
            this.mUiAutomationConnection.clearWindowAnimationFrameStats();
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error clearing window animation frame stats!", e);
        }
    }

    public boolean clearWindowContentFrameStats(int i) {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        try {
            return this.mUiAutomationConnection.clearWindowContentFrameStats(i);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error clearing window content frame stats!", e);
            return false;
        }
    }

    public void connect() {
        synchronized (this.mLock) {
            throwIfConnectedLocked();
            if (this.mIsConnecting) {
                return;
            }
            this.mIsConnecting = true;
            try {
                this.mUiAutomationConnection.connect(this.mClient);
                synchronized (this.mLock) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    while (!isConnectedLocked()) {
                        long uptimeMillis2 = 5000 - (SystemClock.uptimeMillis() - uptimeMillis);
                        if (uptimeMillis2 <= 0) {
                            throw new RuntimeException("Error while connecting UiAutomation");
                        }
                        try {
                            this.mLock.wait(uptimeMillis2);
                        } catch (InterruptedException e) {
                        }
                    }
                    this.mIsConnecting = false;
                }
            } catch (RemoteException e2) {
                throw new RuntimeException("Error while connecting UiAutomation", e2);
            }
        }
    }

    public void disconnect() {
        synchronized (this.mLock) {
            if (this.mIsConnecting) {
                throw new IllegalStateException("Cannot call disconnect() while connecting!");
            }
            throwIfNotConnectedLocked();
            this.mConnectionId = -1;
        }
        try {
            this.mUiAutomationConnection.disconnect();
        } catch (RemoteException e) {
            throw new RuntimeException("Error while disconnecting UiAutomation", e);
        }
    }

    public AccessibilityEvent executeAndWaitForEvent(Runnable runnable, AccessibilityEventFilter accessibilityEventFilter, long j) throws TimeoutException {
        AccessibilityEvent remove;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            this.mEventQueue.clear();
            this.mWaitingForEventDelivery = true;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        runnable.run();
        synchronized (this.mLock) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            while (true) {
                if (this.mEventQueue.isEmpty()) {
                    long uptimeMillis3 = j - (SystemClock.uptimeMillis() - uptimeMillis2);
                    if (uptimeMillis3 <= 0) {
                        throw new TimeoutException("Expected event not received within: " + j + " ms.");
                    }
                    try {
                        this.mLock.wait(uptimeMillis3);
                    } catch (InterruptedException e) {
                    }
                } else {
                    remove = this.mEventQueue.remove(0);
                    if (remove.getEventTime() < uptimeMillis) {
                        continue;
                    } else if (accessibilityEventFilter.accept(remove)) {
                        this.mWaitingForEventDelivery = false;
                        this.mEventQueue.clear();
                        this.mLock.notifyAll();
                    } else {
                        remove.recycle();
                    }
                }
            }
        }
        return remove;
    }

    public ParcelFileDescriptor executeShellCommand(String str) {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        ParcelFileDescriptor parcelFileDescriptor3 = null;
        ParcelFileDescriptor parcelFileDescriptor4 = null;
        ParcelFileDescriptor parcelFileDescriptor5 = null;
        try {
            try {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor parcelFileDescriptor6 = createPipe[0];
                    ParcelFileDescriptor parcelFileDescriptor7 = createPipe[1];
                    parcelFileDescriptor5 = parcelFileDescriptor7;
                    parcelFileDescriptor2 = parcelFileDescriptor6;
                    parcelFileDescriptor3 = parcelFileDescriptor7;
                    parcelFileDescriptor = parcelFileDescriptor6;
                    parcelFileDescriptor4 = parcelFileDescriptor7;
                    this.mUiAutomationConnection.executeShellCommand(str, parcelFileDescriptor7);
                    IoUtils.closeQuietly(parcelFileDescriptor7);
                    return parcelFileDescriptor6;
                } catch (RemoteException e) {
                    Log.e(LOG_TAG, "Error executing shell command!", e);
                    IoUtils.closeQuietly(parcelFileDescriptor3);
                    return parcelFileDescriptor;
                }
            } catch (IOException e2) {
                Log.e(LOG_TAG, "Error executing shell command!", e2);
                IoUtils.closeQuietly(parcelFileDescriptor5);
                return parcelFileDescriptor2;
            }
        } catch (Throwable th) {
            IoUtils.closeQuietly(parcelFileDescriptor4);
            throw th;
        }
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return AccessibilityInteractionClient.getInstance().findFocus(this.mConnectionId, -2, AccessibilityNodeInfo.ROOT_NODE_ID, i);
    }

    public int getConnectionId() {
        int i;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            i = this.mConnectionId;
        }
        return i;
    }

    public AccessibilityNodeInfo getRootInActiveWindow() {
        int i;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            i = this.mConnectionId;
        }
        return AccessibilityInteractionClient.getInstance().getRootInActiveWindow(i);
    }

    public final AccessibilityServiceInfo getServiceInfo() {
        IAccessibilityServiceConnection connection;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            connection = AccessibilityInteractionClient.getInstance().getConnection(this.mConnectionId);
        }
        if (connection != null) {
            try {
                return connection.getServiceInfo();
            } catch (RemoteException e) {
                Log.w(LOG_TAG, "Error while getting AccessibilityServiceInfo", e);
                return null;
            }
        }
        return null;
    }

    public WindowAnimationFrameStats getWindowAnimationFrameStats() {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        try {
            return this.mUiAutomationConnection.getWindowAnimationFrameStats();
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error getting window animation frame stats!", e);
            return null;
        }
    }

    public WindowContentFrameStats getWindowContentFrameStats(int i) {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        try {
            return this.mUiAutomationConnection.getWindowContentFrameStats(i);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error getting window content frame stats!", e);
            return null;
        }
    }

    public List<AccessibilityWindowInfo> getWindows() {
        int i;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            i = this.mConnectionId;
        }
        return AccessibilityInteractionClient.getInstance().getWindows(i);
    }

    public boolean injectInputEvent(InputEvent inputEvent, boolean z) {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        try {
            return this.mUiAutomationConnection.injectInputEvent(inputEvent, z);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error while injecting input event!", e);
            return false;
        }
    }

    public final boolean performGlobalAction(int i) {
        IAccessibilityServiceConnection connection;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            connection = AccessibilityInteractionClient.getInstance().getConnection(this.mConnectionId);
        }
        if (connection != null) {
            try {
                return connection.performGlobalAction(i);
            } catch (RemoteException e) {
                Log.w(LOG_TAG, "Error while calling performGlobalAction", e);
                return false;
            }
        }
        return false;
    }

    public void setOnAccessibilityEventListener(OnAccessibilityEventListener onAccessibilityEventListener) {
        synchronized (this.mLock) {
            this.mOnAccessibilityEventListener = onAccessibilityEventListener;
        }
    }

    public boolean setRotation(int i) {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        switch (i) {
            case -2:
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
                try {
                    this.mUiAutomationConnection.setRotation(i);
                    return true;
                } catch (RemoteException e) {
                    Log.e(LOG_TAG, "Error while setting rotation!", e);
                    return false;
                }
            default:
                throw new IllegalArgumentException("Invalid rotation.");
        }
    }

    public void setRunAsMonkey(boolean z) {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        try {
            ActivityManagerNative.getDefault().setUserIsMonkey(z);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error while setting run as monkey!", e);
        }
    }

    public final void setServiceInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
        IAccessibilityServiceConnection connection;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            AccessibilityInteractionClient.getInstance().clearCache();
            connection = AccessibilityInteractionClient.getInstance().getConnection(this.mConnectionId);
        }
        if (connection != null) {
            try {
                connection.setServiceInfo(accessibilityServiceInfo);
            } catch (RemoteException e) {
                Log.w(LOG_TAG, "Error while setting AccessibilityServiceInfo", e);
            }
        }
    }

    public Bitmap takeScreenshot() {
        float f;
        float f2;
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
        }
        Display realDisplay = DisplayManagerGlobal.getInstance().getRealDisplay(0);
        Point point = new Point();
        realDisplay.getRealSize(point);
        int i = point.x;
        int i2 = point.y;
        int rotation = realDisplay.getRotation();
        switch (rotation) {
            case 0:
                f = i;
                f2 = i2;
                break;
            case 1:
                f = i2;
                f2 = i;
                break;
            case 2:
                f = i;
                f2 = i2;
                break;
            case 3:
                f = i2;
                f2 = i;
                break;
            default:
                throw new IllegalArgumentException("Invalid rotation: " + rotation);
        }
        try {
            Bitmap takeScreenshot = this.mUiAutomationConnection.takeScreenshot((int) f, (int) f2);
            if (takeScreenshot == null) {
                return null;
            }
            Bitmap bitmap = takeScreenshot;
            if (rotation != 0) {
                bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.translate(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
                canvas.rotate(getDegreesForRotation(rotation));
                canvas.translate((-f) / 2.0f, (-f2) / 2.0f);
                canvas.drawBitmap(takeScreenshot, 0.0f, 0.0f, (Paint) null);
                canvas.setBitmap(null);
                takeScreenshot.recycle();
            }
            bitmap.setHasAlpha(false);
            return bitmap;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error while taking screnshot!", e);
            return null;
        }
    }

    public void waitForIdle(long j, long j2) throws TimeoutException {
        synchronized (this.mLock) {
            throwIfNotConnectedLocked();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.mLastEventTimeMillis <= 0) {
                this.mLastEventTimeMillis = uptimeMillis;
            }
            while (true) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                if (j2 - (uptimeMillis2 - uptimeMillis) <= 0) {
                    throw new TimeoutException("No idle state with idle timeout: " + j + " within global timeout: " + j2);
                }
                long j3 = j - (uptimeMillis2 - this.mLastEventTimeMillis);
                if (j3 > 0) {
                    try {
                        this.mLock.wait(j3);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
