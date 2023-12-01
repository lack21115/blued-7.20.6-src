package android.view.accessibility;

import android.os.Build;
import android.util.ArraySet;
import android.util.Log;
import android.util.LongArray;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityCache.class */
public final class AccessibilityCache {
    private static final boolean CHECK_INTEGRITY = "eng".equals(Build.TYPE);
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityCache";
    private final Object mLock = new Object();
    private long mAccessibilityFocus = 2147483647L;
    private long mInputFocus = 2147483647L;
    private final SparseArray<AccessibilityWindowInfo> mWindowCache = new SparseArray<>();
    private final SparseArray<LongSparseArray<AccessibilityNodeInfo>> mNodeCache = new SparseArray<>();
    private final SparseArray<AccessibilityWindowInfo> mTempWindowArray = new SparseArray<>();

    private void clearNodesForWindowLocked(int i) {
        LongSparseArray<AccessibilityNodeInfo> longSparseArray = this.mNodeCache.get(i);
        if (longSparseArray == null) {
            return;
        }
        int size = longSparseArray.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                this.mNodeCache.remove(i);
                return;
            }
            longSparseArray.removeAt(i2);
            longSparseArray.valueAt(i2).recycle();
            size = i2;
        }
    }

    private void clearSubTreeLocked(int i, long j) {
        LongSparseArray<AccessibilityNodeInfo> longSparseArray = this.mNodeCache.get(i);
        if (longSparseArray != null) {
            clearSubTreeRecursiveLocked(longSparseArray, j);
        }
    }

    private void clearSubTreeRecursiveLocked(LongSparseArray<AccessibilityNodeInfo> longSparseArray, long j) {
        AccessibilityNodeInfo accessibilityNodeInfo = longSparseArray.get(j);
        if (accessibilityNodeInfo == null) {
            return;
        }
        longSparseArray.remove(j);
        int childCount = accessibilityNodeInfo.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            clearSubTreeRecursiveLocked(longSparseArray, accessibilityNodeInfo.getChildId(i2));
            i = i2 + 1;
        }
    }

    private void refreshCachedNodeLocked(int i, long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        LongSparseArray<AccessibilityNodeInfo> longSparseArray = this.mNodeCache.get(i);
        if (longSparseArray == null || (accessibilityNodeInfo = longSparseArray.get(j)) == null || accessibilityNodeInfo.refresh(true)) {
            return;
        }
        clearSubTreeLocked(i, j);
    }

    public void add(AccessibilityNodeInfo accessibilityNodeInfo) {
        synchronized (this.mLock) {
            int windowId = accessibilityNodeInfo.getWindowId();
            LongSparseArray<AccessibilityNodeInfo> longSparseArray = this.mNodeCache.get(windowId);
            LongSparseArray<AccessibilityNodeInfo> longSparseArray2 = longSparseArray;
            if (longSparseArray == null) {
                longSparseArray2 = new LongSparseArray<>();
                this.mNodeCache.put(windowId, longSparseArray2);
            }
            long sourceNodeId = accessibilityNodeInfo.getSourceNodeId();
            AccessibilityNodeInfo accessibilityNodeInfo2 = longSparseArray2.get(sourceNodeId);
            if (accessibilityNodeInfo2 != null) {
                LongArray childNodeIds = accessibilityNodeInfo.getChildNodeIds();
                int childCount = accessibilityNodeInfo2.getChildCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childCount) {
                        break;
                    }
                    long childId = accessibilityNodeInfo2.getChildId(i2);
                    if (childNodeIds == null || childNodeIds.indexOf(childId) < 0) {
                        clearSubTreeLocked(windowId, childId);
                    }
                    i = i2 + 1;
                }
                long parentNodeId = accessibilityNodeInfo2.getParentNodeId();
                if (accessibilityNodeInfo.getParentNodeId() != parentNodeId) {
                    clearSubTreeLocked(windowId, parentNodeId);
                }
            }
            longSparseArray2.put(sourceNodeId, AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
        }
    }

    public void addWindow(AccessibilityWindowInfo accessibilityWindowInfo) {
        synchronized (this.mLock) {
            int id = accessibilityWindowInfo.getId();
            AccessibilityWindowInfo accessibilityWindowInfo2 = this.mWindowCache.get(id);
            if (accessibilityWindowInfo2 != null) {
                accessibilityWindowInfo2.recycle();
            }
            this.mWindowCache.put(id, AccessibilityWindowInfo.obtain(accessibilityWindowInfo));
        }
    }

    public void checkIntegrity() {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        boolean z;
        synchronized (this.mLock) {
            if (this.mWindowCache.size() > 0 || this.mNodeCache.size() != 0) {
                AccessibilityWindowInfo accessibilityWindowInfo = null;
                AccessibilityWindowInfo accessibilityWindowInfo2 = null;
                int size = this.mWindowCache.size();
                int i = 0;
                while (i < size) {
                    AccessibilityWindowInfo valueAt = this.mWindowCache.valueAt(i);
                    AccessibilityWindowInfo accessibilityWindowInfo3 = accessibilityWindowInfo2;
                    if (valueAt.isActive()) {
                        if (accessibilityWindowInfo2 != null) {
                            Log.e(LOG_TAG, "Duplicate active window:" + valueAt);
                            accessibilityWindowInfo3 = accessibilityWindowInfo2;
                        } else {
                            accessibilityWindowInfo3 = valueAt;
                        }
                    }
                    AccessibilityWindowInfo accessibilityWindowInfo4 = accessibilityWindowInfo;
                    if (valueAt.isFocused()) {
                        if (accessibilityWindowInfo != null) {
                            Log.e(LOG_TAG, "Duplicate focused window:" + valueAt);
                            accessibilityWindowInfo4 = accessibilityWindowInfo;
                        } else {
                            accessibilityWindowInfo4 = valueAt;
                        }
                    }
                    i++;
                    accessibilityWindowInfo2 = accessibilityWindowInfo3;
                    accessibilityWindowInfo = accessibilityWindowInfo4;
                }
                AccessibilityNodeInfo accessibilityNodeInfo4 = null;
                AccessibilityNodeInfo accessibilityNodeInfo5 = null;
                int size2 = this.mNodeCache.size();
                int i2 = 0;
                while (i2 < size2) {
                    LongSparseArray<AccessibilityNodeInfo> valueAt2 = this.mNodeCache.valueAt(i2);
                    if (valueAt2.size() <= 0) {
                        accessibilityNodeInfo = accessibilityNodeInfo4;
                        accessibilityNodeInfo2 = accessibilityNodeInfo5;
                    } else {
                        ArraySet arraySet = new ArraySet();
                        int keyAt = this.mNodeCache.keyAt(i2);
                        int size3 = valueAt2.size();
                        int i3 = 0;
                        while (true) {
                            accessibilityNodeInfo = accessibilityNodeInfo4;
                            accessibilityNodeInfo2 = accessibilityNodeInfo5;
                            if (i3 < size3) {
                                AccessibilityNodeInfo valueAt3 = valueAt2.valueAt(i3);
                                if (arraySet.add(valueAt3)) {
                                    AccessibilityNodeInfo accessibilityNodeInfo6 = accessibilityNodeInfo4;
                                    if (valueAt3.isAccessibilityFocused()) {
                                        if (accessibilityNodeInfo4 != null) {
                                            Log.e(LOG_TAG, "Duplicate accessibility focus:" + valueAt3 + " in window:" + keyAt);
                                            accessibilityNodeInfo6 = accessibilityNodeInfo4;
                                        } else {
                                            accessibilityNodeInfo6 = valueAt3;
                                        }
                                    }
                                    AccessibilityNodeInfo accessibilityNodeInfo7 = accessibilityNodeInfo5;
                                    if (valueAt3.isFocused()) {
                                        if (accessibilityNodeInfo5 != null) {
                                            Log.e(LOG_TAG, "Duplicate input focus: " + valueAt3 + " in window:" + keyAt);
                                            accessibilityNodeInfo7 = accessibilityNodeInfo5;
                                        } else {
                                            accessibilityNodeInfo7 = valueAt3;
                                        }
                                    }
                                    AccessibilityNodeInfo accessibilityNodeInfo8 = valueAt2.get(valueAt3.getParentNodeId());
                                    if (accessibilityNodeInfo8 != null) {
                                        int childCount = accessibilityNodeInfo8.getChildCount();
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            z = false;
                                            if (i5 >= childCount) {
                                                break;
                                            } else if (valueAt2.get(accessibilityNodeInfo8.getChildId(i5)) == valueAt3) {
                                                z = true;
                                                break;
                                            } else {
                                                i4 = i5 + 1;
                                            }
                                        }
                                        if (!z) {
                                            Log.e(LOG_TAG, "Invalid parent-child relation between parent: " + accessibilityNodeInfo8 + " and child: " + valueAt3);
                                        }
                                    }
                                    int childCount2 = valueAt3.getChildCount();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        accessibilityNodeInfo3 = accessibilityNodeInfo6;
                                        accessibilityNodeInfo5 = accessibilityNodeInfo7;
                                        if (i7 < childCount2) {
                                            AccessibilityNodeInfo accessibilityNodeInfo9 = valueAt2.get(valueAt3.getChildId(i7));
                                            if (accessibilityNodeInfo9 != null && valueAt2.get(accessibilityNodeInfo9.getParentNodeId()) != valueAt3) {
                                                Log.e(LOG_TAG, "Invalid child-parent relation between child: " + valueAt3 + " and parent: " + accessibilityNodeInfo8);
                                            }
                                            i6 = i7 + 1;
                                        }
                                    }
                                } else {
                                    Log.e(LOG_TAG, "Duplicate node: " + valueAt3 + " in window:" + keyAt);
                                    accessibilityNodeInfo3 = accessibilityNodeInfo4;
                                }
                                i3++;
                                accessibilityNodeInfo4 = accessibilityNodeInfo3;
                            }
                        }
                    }
                    i2++;
                    accessibilityNodeInfo4 = accessibilityNodeInfo;
                    accessibilityNodeInfo5 = accessibilityNodeInfo2;
                }
            }
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            int size = this.mWindowCache.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                this.mWindowCache.valueAt(i).recycle();
                this.mWindowCache.removeAt(i);
                size = i;
            }
            int size2 = this.mNodeCache.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < size2) {
                    clearNodesForWindowLocked(this.mNodeCache.keyAt(i3));
                    i2 = i3 + 1;
                } else {
                    this.mAccessibilityFocus = 2147483647L;
                    this.mInputFocus = 2147483647L;
                }
            }
        }
    }

    public AccessibilityNodeInfo getNode(int i, long j) {
        synchronized (this.mLock) {
            LongSparseArray<AccessibilityNodeInfo> longSparseArray = this.mNodeCache.get(i);
            if (longSparseArray == null) {
                return null;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = longSparseArray.get(j);
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
            if (accessibilityNodeInfo != null) {
                accessibilityNodeInfo2 = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
            return accessibilityNodeInfo2;
        }
    }

    public AccessibilityWindowInfo getWindow(int i) {
        synchronized (this.mLock) {
            AccessibilityWindowInfo accessibilityWindowInfo = this.mWindowCache.get(i);
            if (accessibilityWindowInfo != null) {
                return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
            }
            return null;
        }
    }

    public List<AccessibilityWindowInfo> getWindows() {
        synchronized (this.mLock) {
            int size = this.mWindowCache.size();
            if (size <= 0) {
                return null;
            }
            SparseArray<AccessibilityWindowInfo> sparseArray = this.mTempWindowArray;
            sparseArray.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                AccessibilityWindowInfo valueAt = this.mWindowCache.valueAt(i2);
                sparseArray.put(valueAt.getLayer(), valueAt);
                i = i2 + 1;
            }
            ArrayList arrayList = new ArrayList(size);
            int i3 = size;
            while (true) {
                int i4 = i3 - 1;
                if (i4 < 0) {
                    return arrayList;
                }
                arrayList.add(AccessibilityWindowInfo.obtain(sparseArray.valueAt(i4)));
                sparseArray.removeAt(i4);
                i3 = i4;
            }
        }
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        synchronized (this.mLock) {
            switch (accessibilityEvent.getEventType()) {
                case 1:
                case 4:
                case 16:
                case 8192:
                    refreshCachedNodeLocked(accessibilityEvent.getWindowId(), accessibilityEvent.getSourceNodeId());
                    break;
                case 8:
                    if (this.mInputFocus != 2147483647L) {
                        refreshCachedNodeLocked(accessibilityEvent.getWindowId(), this.mInputFocus);
                    }
                    this.mInputFocus = accessibilityEvent.getSourceNodeId();
                    refreshCachedNodeLocked(accessibilityEvent.getWindowId(), this.mInputFocus);
                    break;
                case 32:
                case 4194304:
                    clear();
                    break;
                case 2048:
                    synchronized (this.mLock) {
                        int windowId = accessibilityEvent.getWindowId();
                        long sourceNodeId = accessibilityEvent.getSourceNodeId();
                        if ((accessibilityEvent.getContentChangeTypes() & 1) != 0) {
                            clearSubTreeLocked(windowId, sourceNodeId);
                        } else {
                            refreshCachedNodeLocked(windowId, sourceNodeId);
                        }
                    }
                    break;
                case 4096:
                    clearSubTreeLocked(accessibilityEvent.getWindowId(), accessibilityEvent.getSourceNodeId());
                    break;
                case 32768:
                    if (this.mAccessibilityFocus != 2147483647L) {
                        refreshCachedNodeLocked(accessibilityEvent.getWindowId(), this.mAccessibilityFocus);
                    }
                    this.mAccessibilityFocus = accessibilityEvent.getSourceNodeId();
                    refreshCachedNodeLocked(accessibilityEvent.getWindowId(), this.mAccessibilityFocus);
                    break;
                case 65536:
                    if (this.mAccessibilityFocus == accessibilityEvent.getSourceNodeId()) {
                        refreshCachedNodeLocked(accessibilityEvent.getWindowId(), this.mAccessibilityFocus);
                        this.mAccessibilityFocus = 2147483647L;
                        break;
                    }
                    break;
            }
        }
        if (CHECK_INTEGRITY) {
            checkIntegrity();
        }
    }
}
