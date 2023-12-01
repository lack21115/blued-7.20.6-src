package android.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.IWindow;
import android.view.accessibility.IAccessibilityManager;
import android.view.accessibility.IAccessibilityManagerClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityManager.class */
public final class AccessibilityManager {
    public static final int DALTONIZER_CORRECT_DEUTERANOMALY = 12;
    public static final int DALTONIZER_DISABLED = -1;
    public static final int DALTONIZER_SIMULATE_MONOCHROMACY = 0;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityManager";
    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 1;
    public static final int STATE_FLAG_HIGH_TEXT_CONTRAST_ENABLED = 4;
    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 2;
    private static AccessibilityManager sInstance;
    static final Object sInstanceSync = new Object();
    final Handler mHandler;
    boolean mIsEnabled;
    boolean mIsHighTextContrastEnabled;
    boolean mIsTouchExplorationEnabled;
    private IAccessibilityManager mService;
    final int mUserId;
    private final Object mLock = new Object();
    private final CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<TouchExplorationStateChangeListener> mTouchExplorationStateChangeListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<HighTextContrastChangeListener> mHighTextContrastStateChangeListeners = new CopyOnWriteArrayList<>();
    private final IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() { // from class: android.view.accessibility.AccessibilityManager.1
        @Override // android.view.accessibility.IAccessibilityManagerClient
        public void setState(int i) {
            AccessibilityManager.this.mHandler.obtainMessage(4, i, 0).sendToTarget();
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener.class */
    public interface AccessibilityStateChangeListener {
        void onAccessibilityStateChanged(boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityManager$HighTextContrastChangeListener.class */
    public interface HighTextContrastChangeListener {
        void onHighTextContrastStateChanged(boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityManager$MyHandler.class */
    private final class MyHandler extends Handler {
        public static final int MSG_NOTIFY_ACCESSIBILITY_STATE_CHANGED = 1;
        public static final int MSG_NOTIFY_EXPLORATION_STATE_CHANGED = 2;
        public static final int MSG_NOTIFY_HIGH_TEXT_CONTRAST_STATE_CHANGED = 3;
        public static final int MSG_SET_STATE = 4;

        public MyHandler(Looper looper) {
            super(looper, null, false);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    AccessibilityManager.this.handleNotifyAccessibilityStateChanged();
                    return;
                case 2:
                    AccessibilityManager.this.handleNotifyTouchExplorationStateChanged();
                    return;
                case 3:
                    AccessibilityManager.this.handleNotifyHighTextContrastStateChanged();
                    return;
                case 4:
                    int i = message.arg1;
                    synchronized (AccessibilityManager.this.mLock) {
                        AccessibilityManager.this.setStateLocked(i);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener.class */
    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z);
    }

    public AccessibilityManager(Context context, IAccessibilityManager iAccessibilityManager, int i) {
        this.mHandler = new MyHandler(context.getMainLooper());
        this.mService = iAccessibilityManager;
        this.mUserId = i;
        synchronized (this.mLock) {
            tryConnectToServiceLocked();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x0058, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x000c, B:8:0x0015, B:10:0x001e, B:21:0x0049, B:13:0x002a, B:16:0x0036, B:22:0x0050, B:18:0x0044, B:19:0x0045), top: B:29:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.accessibility.AccessibilityManager getInstance(android.content.Context r6) {
        /*
            java.lang.Object r0 = android.view.accessibility.AccessibilityManager.sInstanceSync
            r9 = r0
            r0 = r9
            monitor-enter(r0)
            android.view.accessibility.AccessibilityManager r0 = android.view.accessibility.AccessibilityManager.sInstance     // Catch: java.lang.Throwable -> L58
            if (r0 != 0) goto L43
            int r0 = android.os.Binder.getCallingUid()     // Catch: java.lang.Throwable -> L58
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 == r1) goto L5d
            r0 = r6
            java.lang.String r1 = "android.permission.INTERACT_ACROSS_USERS"
            int r0 = r0.checkCallingOrSelfPermission(r1)     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L5d
            r0 = r6
            java.lang.String r1 = "android.permission.INTERACT_ACROSS_USERS_FULL"
            int r0 = r0.checkCallingOrSelfPermission(r1)     // Catch: java.lang.Throwable -> L58
            if (r0 != 0) goto L49
            goto L5d
        L2a:
            java.lang.String r0 = "accessibility"
            android.os.IBinder r0 = android.os.ServiceManager.getService(r0)     // Catch: java.lang.Throwable -> L58
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L50
            r0 = 0
            r8 = r0
        L36:
            android.view.accessibility.AccessibilityManager r0 = new android.view.accessibility.AccessibilityManager     // Catch: java.lang.Throwable -> L58
            r1 = r0
            r2 = r6
            r3 = r8
            r4 = r7
            r1.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L58
            android.view.accessibility.AccessibilityManager.sInstance = r0     // Catch: java.lang.Throwable -> L58
        L43:
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            android.view.accessibility.AccessibilityManager r0 = android.view.accessibility.AccessibilityManager.sInstance     // Catch: java.lang.Throwable -> L58
            return r0
        L49:
            int r0 = android.os.UserHandle.myUserId()     // Catch: java.lang.Throwable -> L58
            r7 = r0
            goto L2a
        L50:
            r0 = r8
            android.view.accessibility.IAccessibilityManager r0 = android.view.accessibility.IAccessibilityManager.Stub.asInterface(r0)     // Catch: java.lang.Throwable -> L58
            r8 = r0
            goto L36
        L58:
            r6 = move-exception
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            r0 = r6
            throw r0
        L5d:
            r0 = -2
            r7 = r0
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.accessibility.AccessibilityManager.getInstance(android.content.Context):android.view.accessibility.AccessibilityManager");
    }

    private IAccessibilityManager getServiceLocked() {
        if (this.mService == null) {
            tryConnectToServiceLocked();
        }
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotifyAccessibilityStateChanged() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mIsEnabled;
        }
        Iterator<AccessibilityStateChangeListener> it = this.mAccessibilityStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onAccessibilityStateChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotifyHighTextContrastStateChanged() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mIsHighTextContrastEnabled;
        }
        Iterator<HighTextContrastChangeListener> it = this.mHighTextContrastStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onHighTextContrastStateChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotifyTouchExplorationStateChanged() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mIsTouchExplorationEnabled;
        }
        Iterator<TouchExplorationStateChangeListener> it = this.mTouchExplorationStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onTouchExplorationStateChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateLocked(int i) {
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        boolean z3 = (i & 2) != 0;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z4 = this.mIsEnabled;
        boolean z5 = this.mIsTouchExplorationEnabled;
        boolean z6 = this.mIsHighTextContrastEnabled;
        this.mIsEnabled = z2;
        this.mIsTouchExplorationEnabled = z3;
        this.mIsHighTextContrastEnabled = z;
        if (z4 != z2) {
            this.mHandler.sendEmptyMessage(1);
        }
        if (z5 != z3) {
            this.mHandler.sendEmptyMessage(2);
        }
        if (z6 != z) {
            this.mHandler.sendEmptyMessage(3);
        }
    }

    private void tryConnectToServiceLocked() {
        IBinder service = ServiceManager.getService("accessibility");
        if (service == null) {
            return;
        }
        IAccessibilityManager asInterface = IAccessibilityManager.Stub.asInterface(service);
        try {
            setStateLocked(asInterface.addClient(this.mClient, this.mUserId));
            this.mService = asInterface;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "AccessibilityManagerService is dead", e);
        }
    }

    public int addAccessibilityInteractionConnection(IWindow iWindow, IAccessibilityInteractionConnection iAccessibilityInteractionConnection) {
        synchronized (this.mLock) {
            IAccessibilityManager serviceLocked = getServiceLocked();
            if (serviceLocked == null) {
                return -1;
            }
            int i = this.mUserId;
            try {
                return serviceLocked.addAccessibilityInteractionConnection(iWindow, iAccessibilityInteractionConnection, i);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error while adding an accessibility interaction connection. ", e);
                return -1;
            }
        }
    }

    public boolean addAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilityStateChangeListener) {
        return this.mAccessibilityStateChangeListeners.add(accessibilityStateChangeListener);
    }

    public boolean addHighTextContrastStateChangeListener(HighTextContrastChangeListener highTextContrastChangeListener) {
        return this.mHighTextContrastStateChangeListeners.add(highTextContrastChangeListener);
    }

    public boolean addTouchExplorationStateChangeListener(TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return this.mTouchExplorationStateChangeListeners.add(touchExplorationStateChangeListener);
    }

    @Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = getInstalledAccessibilityServiceList();
        ArrayList arrayList = new ArrayList();
        int size = installedAccessibilityServiceList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(installedAccessibilityServiceList.get(i2).getResolveInfo().serviceInfo);
            i = i2 + 1;
        }
    }

    public IAccessibilityManagerClient getClient() {
        return this.mClient;
    }

    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int i) {
        synchronized (this.mLock) {
            IAccessibilityManager serviceLocked = getServiceLocked();
            if (serviceLocked == null) {
                return Collections.emptyList();
            }
            int i2 = this.mUserId;
            List<AccessibilityServiceInfo> list = null;
            try {
                list = serviceLocked.getEnabledAccessibilityServiceList(i, i2);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error while obtaining the installed AccessibilityServices. ", e);
            }
            return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
        }
    }

    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        synchronized (this.mLock) {
            IAccessibilityManager serviceLocked = getServiceLocked();
            if (serviceLocked == null) {
                return Collections.emptyList();
            }
            int i = this.mUserId;
            List<AccessibilityServiceInfo> list = null;
            try {
                list = serviceLocked.getInstalledAccessibilityServiceList(i);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error while obtaining the installed AccessibilityServices. ", e);
            }
            return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
        }
    }

    public void interrupt() {
        synchronized (this.mLock) {
            IAccessibilityManager serviceLocked = getServiceLocked();
            if (serviceLocked == null) {
                return;
            }
            if (!this.mIsEnabled) {
                throw new IllegalStateException("Accessibility off. Did you forget to check that?");
            }
            int i = this.mUserId;
            try {
                serviceLocked.interrupt(i);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error while requesting interrupt from all services. ", e);
            }
        }
    }

    public boolean isEnabled() {
        synchronized (this.mLock) {
            if (getServiceLocked() == null) {
                return false;
            }
            return this.mIsEnabled;
        }
    }

    public boolean isHighTextContrastEnabled() {
        synchronized (this.mLock) {
            if (getServiceLocked() == null) {
                return false;
            }
            return this.mIsHighTextContrastEnabled;
        }
    }

    public boolean isTouchExplorationEnabled() {
        synchronized (this.mLock) {
            if (getServiceLocked() == null) {
                return false;
            }
            return this.mIsTouchExplorationEnabled;
        }
    }

    public void removeAccessibilityInteractionConnection(IWindow iWindow) {
        synchronized (this.mLock) {
            IAccessibilityManager serviceLocked = getServiceLocked();
            if (serviceLocked == null) {
                return;
            }
            try {
                serviceLocked.removeAccessibilityInteractionConnection(iWindow);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error while removing an accessibility interaction connection. ", e);
            }
        }
    }

    public boolean removeAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilityStateChangeListener) {
        return this.mAccessibilityStateChangeListeners.remove(accessibilityStateChangeListener);
    }

    public boolean removeHighTextContrastStateChangeListener(HighTextContrastChangeListener highTextContrastChangeListener) {
        return this.mHighTextContrastStateChangeListeners.remove(highTextContrastChangeListener);
    }

    public boolean removeTouchExplorationStateChangeListener(TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return this.mTouchExplorationStateChangeListeners.remove(touchExplorationStateChangeListener);
    }

    public void sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        synchronized (this.mLock) {
            IAccessibilityManager serviceLocked = getServiceLocked();
            if (serviceLocked == null) {
                return;
            }
            if (!this.mIsEnabled) {
                throw new IllegalStateException("Accessibility off. Did you forget to check that?");
            }
            int i = this.mUserId;
            boolean z = false;
            boolean z2 = false;
            try {
                try {
                    accessibilityEvent.setEventTime(SystemClock.uptimeMillis());
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    boolean sendAccessibilityEvent = serviceLocked.sendAccessibilityEvent(accessibilityEvent, i);
                    z = sendAccessibilityEvent;
                    z2 = sendAccessibilityEvent;
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    if (!sendAccessibilityEvent) {
                        return;
                    }
                    accessibilityEvent.recycle();
                } catch (RemoteException e) {
                    Log.e(LOG_TAG, "Error during sending " + accessibilityEvent + " ", e);
                    if (z) {
                        accessibilityEvent.recycle();
                    }
                }
            } catch (Throwable th) {
                if (z2) {
                    accessibilityEvent.recycle();
                }
                throw th;
            }
        }
    }
}
