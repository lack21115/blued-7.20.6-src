package android.view.accessibility;

import android.accessibilityservice.IAccessibilityServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityInteractionClient.class */
public final class AccessibilityInteractionClient extends IAccessibilityInteractionConnectionCallback.Stub {
    private static final boolean CHECK_INTEGRITY = true;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityInteractionClient";
    public static final int NO_ID = -1;
    private static final long TIMEOUT_INTERACTION_MILLIS = 5000;
    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
    private boolean mPerformAccessibilityActionResult;
    private Message mSameThreadMessage;
    private static final Object sStaticLock = new Object();
    private static final LongSparseArray<AccessibilityInteractionClient> sClients = new LongSparseArray<>();
    private static final SparseArray<IAccessibilityServiceConnection> sConnectionCache = new SparseArray<>();
    private static final AccessibilityCache sAccessibilityCache = new AccessibilityCache();
    private final AtomicInteger mInteractionIdCounter = new AtomicInteger();
    private final Object mInstanceLock = new Object();
    private volatile int mInteractionId = -1;

    private AccessibilityInteractionClient() {
    }

    private void checkFindAccessibilityNodeInfoResultIntegrity(List<AccessibilityNodeInfo> list) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (list.size() == 0) {
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = list.get(0);
        int size = list.size();
        int i = 1;
        while (i < size) {
            int i2 = i;
            while (true) {
                int i3 = i2;
                accessibilityNodeInfo = accessibilityNodeInfo2;
                if (i3 < size) {
                    accessibilityNodeInfo = list.get(i3);
                    if (accessibilityNodeInfo2.getParentNodeId() == accessibilityNodeInfo.getSourceNodeId()) {
                        break;
                    }
                    i2 = i3 + 1;
                }
            }
            i++;
            accessibilityNodeInfo2 = accessibilityNodeInfo;
        }
        if (accessibilityNodeInfo2 == null) {
            Log.e(LOG_TAG, "No root.");
        }
        HashSet hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        linkedList.add(accessibilityNodeInfo2);
        while (!linkedList.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) linkedList.poll();
            if (!hashSet.add(accessibilityNodeInfo3)) {
                Log.e(LOG_TAG, "Duplicate node.");
                return;
            }
            int childCount = accessibilityNodeInfo3.getChildCount();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < childCount) {
                    long childId = accessibilityNodeInfo3.getChildId(i5);
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 < size) {
                            AccessibilityNodeInfo accessibilityNodeInfo4 = list.get(i7);
                            if (accessibilityNodeInfo4.getSourceNodeId() == childId) {
                                linkedList.add(accessibilityNodeInfo4);
                            }
                            i6 = i7 + 1;
                        }
                    }
                    i4 = i5 + 1;
                }
            }
        }
        int size2 = list.size() - hashSet.size();
        if (size2 > 0) {
            Log.e(LOG_TAG, size2 + " Disconnected nodes.");
        }
    }

    private void clearResultLocked() {
        this.mInteractionId = -1;
        this.mFindAccessibilityNodeInfoResult = null;
        this.mFindAccessibilityNodeInfosResult = null;
        this.mPerformAccessibilityActionResult = false;
    }

    private void finalizeAndCacheAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        if (accessibilityNodeInfo != null) {
            accessibilityNodeInfo.setConnectionId(i);
            accessibilityNodeInfo.setSealed(true);
            sAccessibilityCache.add(accessibilityNodeInfo);
        }
    }

    private void finalizeAndCacheAccessibilityNodeInfos(List<AccessibilityNodeInfo> list, int i) {
        if (list == null) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            finalizeAndCacheAccessibilityNodeInfo(list.get(i3), i);
            i2 = i3 + 1;
        }
    }

    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int i) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        synchronized (this.mInstanceLock) {
            accessibilityNodeInfo = waitForResultTimedLocked(i) ? this.mFindAccessibilityNodeInfoResult : null;
            clearResultLocked();
        }
        return accessibilityNodeInfo;
    }

    private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(int i) {
        List<AccessibilityNodeInfo> emptyList;
        synchronized (this.mInstanceLock) {
            emptyList = waitForResultTimedLocked(i) ? this.mFindAccessibilityNodeInfosResult : Collections.emptyList();
            clearResultLocked();
            if (Build.IS_DEBUGGABLE) {
                checkFindAccessibilityNodeInfoResultIntegrity(emptyList);
            }
        }
        return emptyList;
    }

    public static AccessibilityInteractionClient getInstance() {
        return getInstanceForThread(Thread.currentThread().getId());
    }

    public static AccessibilityInteractionClient getInstanceForThread(long j) {
        AccessibilityInteractionClient accessibilityInteractionClient;
        synchronized (sStaticLock) {
            AccessibilityInteractionClient accessibilityInteractionClient2 = sClients.get(j);
            accessibilityInteractionClient = accessibilityInteractionClient2;
            if (accessibilityInteractionClient2 == null) {
                accessibilityInteractionClient = new AccessibilityInteractionClient();
                sClients.put(j, accessibilityInteractionClient);
            }
        }
        return accessibilityInteractionClient;
    }

    private boolean getPerformAccessibilityActionResultAndClear(int i) {
        boolean z;
        synchronized (this.mInstanceLock) {
            z = waitForResultTimedLocked(i) ? this.mPerformAccessibilityActionResult : false;
            clearResultLocked();
        }
        return z;
    }

    private Message getSameProcessMessageAndClear() {
        Message message;
        synchronized (this.mInstanceLock) {
            message = this.mSameThreadMessage;
            this.mSameThreadMessage = null;
        }
        return message;
    }

    private boolean waitForResultTimedLocked(int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        while (true) {
            try {
                Message sameProcessMessageAndClear = getSameProcessMessageAndClear();
                if (sameProcessMessageAndClear != null) {
                    sameProcessMessageAndClear.getTarget().handleMessage(sameProcessMessageAndClear);
                }
            } catch (InterruptedException e) {
            }
            if (this.mInteractionId == i) {
                return true;
            }
            if (this.mInteractionId > i) {
                return false;
            }
            long uptimeMillis2 = 5000 - (SystemClock.uptimeMillis() - uptimeMillis);
            if (uptimeMillis2 <= 0) {
                return false;
            }
            this.mInstanceLock.wait(uptimeMillis2);
        }
    }

    public void addConnection(int i, IAccessibilityServiceConnection iAccessibilityServiceConnection) {
        synchronized (sConnectionCache) {
            sConnectionCache.put(i, iAccessibilityServiceConnection);
        }
    }

    public void clearCache() {
        sAccessibilityCache.clear();
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int i, int i2, long j, boolean z, int i3) {
        AccessibilityNodeInfo node;
        if ((i3 & 2) == 0 || (i3 & 1) != 0) {
            try {
                IAccessibilityServiceConnection connection = getConnection(i);
                if (connection != null) {
                    if (z || (node = sAccessibilityCache.getNode(i2, j)) == null) {
                        int andIncrement = this.mInteractionIdCounter.getAndIncrement();
                        if (connection.findAccessibilityNodeInfoByAccessibilityId(i2, j, andIncrement, this, i3, Thread.currentThread().getId())) {
                            List<AccessibilityNodeInfo> findAccessibilityNodeInfosResultAndClear = getFindAccessibilityNodeInfosResultAndClear(andIncrement);
                            finalizeAndCacheAccessibilityNodeInfos(findAccessibilityNodeInfosResultAndClear, i);
                            if (findAccessibilityNodeInfosResultAndClear == null || findAccessibilityNodeInfosResultAndClear.isEmpty()) {
                                return null;
                            }
                            return findAccessibilityNodeInfosResultAndClear.get(0);
                        }
                        return null;
                    }
                    return node;
                }
                return null;
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error while calling remote findAccessibilityNodeInfoByAccessibilityId", e);
                return null;
            }
        }
        throw new IllegalArgumentException("FLAG_PREFETCH_SIBLINGS requires FLAG_PREFETCH_PREDECESSORS");
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(int i, int i2, long j, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosResultAndClear;
        try {
            IAccessibilityServiceConnection connection = getConnection(i);
            if (connection != null) {
                int andIncrement = this.mInteractionIdCounter.getAndIncrement();
                if (connection.findAccessibilityNodeInfosByText(i2, j, str, andIncrement, this, Thread.currentThread().getId()) && (findAccessibilityNodeInfosResultAndClear = getFindAccessibilityNodeInfosResultAndClear(andIncrement)) != null) {
                    finalizeAndCacheAccessibilityNodeInfos(findAccessibilityNodeInfosResultAndClear, i);
                    return findAccessibilityNodeInfosResultAndClear;
                }
            }
        } catch (RemoteException e) {
            Log.w(LOG_TAG, "Error while calling remote findAccessibilityNodeInfosByViewText", e);
        }
        return Collections.emptyList();
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId(int i, int i2, long j, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosResultAndClear;
        try {
            IAccessibilityServiceConnection connection = getConnection(i);
            if (connection != null) {
                int andIncrement = this.mInteractionIdCounter.getAndIncrement();
                if (connection.findAccessibilityNodeInfosByViewId(i2, j, str, andIncrement, this, Thread.currentThread().getId()) && (findAccessibilityNodeInfosResultAndClear = getFindAccessibilityNodeInfosResultAndClear(andIncrement)) != null) {
                    finalizeAndCacheAccessibilityNodeInfos(findAccessibilityNodeInfosResultAndClear, i);
                    return findAccessibilityNodeInfosResultAndClear;
                }
            }
        } catch (RemoteException e) {
            Log.w(LOG_TAG, "Error while calling remote findAccessibilityNodeInfoByViewIdInActiveWindow", e);
        }
        return Collections.emptyList();
    }

    public AccessibilityNodeInfo findFocus(int i, int i2, long j, int i3) {
        try {
            IAccessibilityServiceConnection connection = getConnection(i);
            if (connection != null) {
                int andIncrement = this.mInteractionIdCounter.getAndIncrement();
                if (connection.findFocus(i2, j, i3, andIncrement, this, Thread.currentThread().getId())) {
                    AccessibilityNodeInfo findAccessibilityNodeInfoResultAndClear = getFindAccessibilityNodeInfoResultAndClear(andIncrement);
                    finalizeAndCacheAccessibilityNodeInfo(findAccessibilityNodeInfoResultAndClear, i);
                    return findAccessibilityNodeInfoResultAndClear;
                }
                return null;
            }
            return null;
        } catch (RemoteException e) {
            Log.w(LOG_TAG, "Error while calling remote findFocus", e);
            return null;
        }
    }

    public AccessibilityNodeInfo focusSearch(int i, int i2, long j, int i3) {
        try {
            IAccessibilityServiceConnection connection = getConnection(i);
            if (connection != null) {
                int andIncrement = this.mInteractionIdCounter.getAndIncrement();
                if (connection.focusSearch(i2, j, i3, andIncrement, this, Thread.currentThread().getId())) {
                    AccessibilityNodeInfo findAccessibilityNodeInfoResultAndClear = getFindAccessibilityNodeInfoResultAndClear(andIncrement);
                    finalizeAndCacheAccessibilityNodeInfo(findAccessibilityNodeInfoResultAndClear, i);
                    return findAccessibilityNodeInfoResultAndClear;
                }
                return null;
            }
            return null;
        } catch (RemoteException e) {
            Log.w(LOG_TAG, "Error while calling remote accessibilityFocusSearch", e);
            return null;
        }
    }

    public IAccessibilityServiceConnection getConnection(int i) {
        IAccessibilityServiceConnection iAccessibilityServiceConnection;
        synchronized (sConnectionCache) {
            iAccessibilityServiceConnection = sConnectionCache.get(i);
        }
        return iAccessibilityServiceConnection;
    }

    public AccessibilityNodeInfo getRootInActiveWindow(int i) {
        return findAccessibilityNodeInfoByAccessibilityId(i, Integer.MAX_VALUE, AccessibilityNodeInfo.ROOT_NODE_ID, false, 4);
    }

    public AccessibilityWindowInfo getWindow(int i, int i2) {
        try {
            IAccessibilityServiceConnection connection = getConnection(i);
            if (connection != null) {
                AccessibilityWindowInfo window = sAccessibilityCache.getWindow(i2);
                if (window != null) {
                    return window;
                }
                AccessibilityWindowInfo window2 = connection.getWindow(i2);
                if (window2 != null) {
                    sAccessibilityCache.addWindow(window2);
                    return window2;
                }
                return null;
            }
            return null;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error while calling remote getWindow", e);
            return null;
        }
    }

    public List<AccessibilityWindowInfo> getWindows(int i) {
        List<AccessibilityWindowInfo> emptyList;
        IAccessibilityServiceConnection connection;
        try {
            connection = getConnection(i);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error while calling remote getWindows", e);
        }
        if (connection != null) {
            List<AccessibilityWindowInfo> windows = sAccessibilityCache.getWindows();
            if (windows != null) {
                return windows;
            }
            List<AccessibilityWindowInfo> windows2 = connection.getWindows();
            if (windows2 != null) {
                int size = windows2.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    emptyList = windows2;
                    if (i3 >= size) {
                        break;
                    }
                    sAccessibilityCache.addWindow(windows2.get(i3));
                    i2 = i3 + 1;
                }
                return emptyList;
            }
        }
        emptyList = Collections.emptyList();
        return emptyList;
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        sAccessibilityCache.onAccessibilityEvent(accessibilityEvent);
    }

    public boolean performAccessibilityAction(int i, int i2, long j, int i3, Bundle bundle) {
        try {
            IAccessibilityServiceConnection connection = getConnection(i);
            if (connection != null) {
                int andIncrement = this.mInteractionIdCounter.getAndIncrement();
                if (connection.performAccessibilityAction(i2, j, i3, bundle, andIncrement, this, Thread.currentThread().getId())) {
                    return getPerformAccessibilityActionResultAndClear(andIncrement);
                }
                return false;
            }
            return false;
        } catch (RemoteException e) {
            Log.w(LOG_TAG, "Error while calling remote performAccessibilityAction", e);
            return false;
        }
    }

    public void removeConnection(int i) {
        synchronized (sConnectionCache) {
            sConnectionCache.remove(i);
        }
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        synchronized (this.mInstanceLock) {
            if (i > this.mInteractionId) {
                this.mFindAccessibilityNodeInfoResult = accessibilityNodeInfo;
                this.mInteractionId = i;
            }
            this.mInstanceLock.notifyAll();
        }
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> list, int i) {
        synchronized (this.mInstanceLock) {
            if (i > this.mInteractionId) {
                if (list != null) {
                    if (Binder.getCallingPid() != Process.myPid()) {
                        this.mFindAccessibilityNodeInfosResult = list;
                    } else {
                        this.mFindAccessibilityNodeInfosResult = new ArrayList(list);
                    }
                } else {
                    this.mFindAccessibilityNodeInfosResult = Collections.emptyList();
                }
                this.mInteractionId = i;
            }
            this.mInstanceLock.notifyAll();
        }
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setPerformAccessibilityActionResult(boolean z, int i) {
        synchronized (this.mInstanceLock) {
            if (i > this.mInteractionId) {
                this.mPerformAccessibilityActionResult = z;
                this.mInteractionId = i;
            }
            this.mInstanceLock.notifyAll();
        }
    }

    public void setSameThreadMessage(Message message) {
        synchronized (this.mInstanceLock) {
            this.mSameThreadMessage = message;
            this.mInstanceLock.notifyAll();
        }
    }
}
