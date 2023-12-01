package android.view;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.util.LongSparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityInteractionController.class */
public final class AccessibilityInteractionController {
    private static final boolean ENFORCE_NODE_TREE_CONSISTENT = false;
    private AddNodeInfosForViewId mAddNodeInfosForViewId;
    private final Handler mHandler;
    private final long mMyLooperThreadId;
    private final int mMyProcessId;
    private final AccessibilityNodePrefetcher mPrefetcher;
    private final ArrayList<AccessibilityNodeInfo> mTempAccessibilityNodeInfoList = new ArrayList<>();
    private final ArrayList<View> mTempArrayList = new ArrayList<>();
    private final Point mTempPoint = new Point();
    private final Rect mTempRect = new Rect();
    private final Rect mTempRect1 = new Rect();
    private final Rect mTempRect2 = new Rect();
    private final ViewRootImpl mViewRootImpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityInteractionController$AccessibilityNodePrefetcher.class */
    public class AccessibilityNodePrefetcher {
        private static final int MAX_ACCESSIBILITY_NODE_INFO_BATCH_SIZE = 50;
        private final ArrayList<View> mTempViewList;

        private AccessibilityNodePrefetcher() {
            this.mTempViewList = new ArrayList<>();
        }

        private void enforceNodeTreeConsistent(List<AccessibilityNodeInfo> list) {
            LongSparseArray longSparseArray = new LongSparseArray();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                AccessibilityNodeInfo accessibilityNodeInfo = list.get(i2);
                longSparseArray.put(accessibilityNodeInfo.getSourceNodeId(), accessibilityNodeInfo);
                i = i2 + 1;
            }
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) longSparseArray.valueAt(0);
            AccessibilityNodeInfo accessibilityNodeInfo3 = accessibilityNodeInfo2;
            while (true) {
                AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfo3;
                if (accessibilityNodeInfo4 == null) {
                    break;
                }
                accessibilityNodeInfo2 = accessibilityNodeInfo4;
                accessibilityNodeInfo3 = (AccessibilityNodeInfo) longSparseArray.get(accessibilityNodeInfo4.getParentNodeId());
            }
            AccessibilityNodeInfo accessibilityNodeInfo5 = null;
            HashSet hashSet = new HashSet();
            LinkedList linkedList = new LinkedList();
            linkedList.add(accessibilityNodeInfo2);
            AccessibilityNodeInfo accessibilityNodeInfo6 = null;
            while (!linkedList.isEmpty()) {
                AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) linkedList.poll();
                if (!hashSet.add(accessibilityNodeInfo7)) {
                    throw new IllegalStateException("Duplicate node: " + accessibilityNodeInfo7 + " in window:" + AccessibilityInteractionController.this.mViewRootImpl.mAttachInfo.mAccessibilityWindowId);
                }
                AccessibilityNodeInfo accessibilityNodeInfo8 = accessibilityNodeInfo5;
                if (accessibilityNodeInfo7.isAccessibilityFocused()) {
                    if (accessibilityNodeInfo5 != null) {
                        throw new IllegalStateException("Duplicate accessibility focus:" + accessibilityNodeInfo7 + " in window:" + AccessibilityInteractionController.this.mViewRootImpl.mAttachInfo.mAccessibilityWindowId);
                    }
                    accessibilityNodeInfo8 = accessibilityNodeInfo7;
                }
                AccessibilityNodeInfo accessibilityNodeInfo9 = accessibilityNodeInfo6;
                if (accessibilityNodeInfo7.isFocused()) {
                    if (accessibilityNodeInfo6 != null) {
                        throw new IllegalStateException("Duplicate input focus: " + accessibilityNodeInfo7 + " in window:" + AccessibilityInteractionController.this.mViewRootImpl.mAttachInfo.mAccessibilityWindowId);
                    }
                    accessibilityNodeInfo9 = accessibilityNodeInfo7;
                }
                int childCount = accessibilityNodeInfo7.getChildCount();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    accessibilityNodeInfo5 = accessibilityNodeInfo8;
                    accessibilityNodeInfo6 = accessibilityNodeInfo9;
                    if (i4 < childCount) {
                        AccessibilityNodeInfo accessibilityNodeInfo10 = (AccessibilityNodeInfo) longSparseArray.get(accessibilityNodeInfo7.getChildId(i4));
                        if (accessibilityNodeInfo10 != null) {
                            linkedList.add(accessibilityNodeInfo10);
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            int size2 = longSparseArray.size();
            while (true) {
                int i5 = size2 - 1;
                if (i5 < 0) {
                    return;
                }
                AccessibilityNodeInfo accessibilityNodeInfo11 = (AccessibilityNodeInfo) longSparseArray.valueAt(i5);
                if (!hashSet.contains(accessibilityNodeInfo11)) {
                    throw new IllegalStateException("Disconnected node: " + accessibilityNodeInfo11);
                }
                size2 = i5;
            }
        }

        private void prefetchDescendantsOfRealNode(View view, List<AccessibilityNodeInfo> list) {
            if (!(view instanceof ViewGroup)) {
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList<View> arrayList = this.mTempViewList;
            arrayList.clear();
            try {
                view.addChildrenForAccessibility(arrayList);
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        arrayList.clear();
                        if (list.size() < 50) {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                View view2 = (View) entry.getKey();
                                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) entry.getValue();
                                if (accessibilityNodeInfo == null) {
                                    prefetchDescendantsOfRealNode(view2, list);
                                } else {
                                    prefetchDescendantsOfVirtualNode(accessibilityNodeInfo, view2.getAccessibilityNodeProvider(), list);
                                }
                            }
                            return;
                        }
                        return;
                    } else if (list.size() >= 50) {
                        return;
                    } else {
                        View view3 = arrayList.get(i2);
                        if (AccessibilityInteractionController.this.isShown(view3)) {
                            AccessibilityNodeProvider accessibilityNodeProvider = view3.getAccessibilityNodeProvider();
                            if (accessibilityNodeProvider == null) {
                                AccessibilityNodeInfo createAccessibilityNodeInfo = view3.createAccessibilityNodeInfo();
                                if (createAccessibilityNodeInfo != null) {
                                    list.add(createAccessibilityNodeInfo);
                                    hashMap.put(view3, null);
                                }
                            } else {
                                AccessibilityNodeInfo createAccessibilityNodeInfo2 = accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
                                if (createAccessibilityNodeInfo2 != null) {
                                    list.add(createAccessibilityNodeInfo2);
                                    hashMap.put(view3, createAccessibilityNodeInfo2);
                                }
                            }
                        }
                        i = i2 + 1;
                    }
                }
            } finally {
                arrayList.clear();
            }
        }

        private void prefetchDescendantsOfVirtualNode(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeProvider accessibilityNodeProvider, List<AccessibilityNodeInfo> list) {
            int size = list.size();
            int childCount = accessibilityNodeInfo.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < childCount) {
                    if (list.size() >= 50) {
                        return;
                    }
                    AccessibilityNodeInfo createAccessibilityNodeInfo = accessibilityNodeProvider.createAccessibilityNodeInfo(AccessibilityNodeInfo.getVirtualDescendantId(accessibilityNodeInfo.getChildId(i2)));
                    if (createAccessibilityNodeInfo != null) {
                        list.add(createAccessibilityNodeInfo);
                    }
                    i = i2 + 1;
                } else if (list.size() >= 50) {
                    return;
                } else {
                    int size2 = list.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2 - size) {
                            return;
                        }
                        prefetchDescendantsOfVirtualNode(list.get(size + i4), accessibilityNodeProvider, list);
                        i3 = i4 + 1;
                    }
                }
            }
        }

        private void prefetchPredecessorsOfRealNode(View view, List<AccessibilityNodeInfo> list) {
            ViewParent parentForAccessibility = view.getParentForAccessibility();
            while (true) {
                ViewParent viewParent = parentForAccessibility;
                if (!(viewParent instanceof View) || list.size() >= 50) {
                    return;
                }
                AccessibilityNodeInfo createAccessibilityNodeInfo = ((View) viewParent).createAccessibilityNodeInfo();
                if (createAccessibilityNodeInfo != null) {
                    list.add(createAccessibilityNodeInfo);
                }
                parentForAccessibility = viewParent.getParentForAccessibility();
            }
        }

        private void prefetchPredecessorsOfVirtualNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeProvider accessibilityNodeProvider, List<AccessibilityNodeInfo> list) {
            long parentNodeId = accessibilityNodeInfo.getParentNodeId();
            int accessibilityViewId = AccessibilityNodeInfo.getAccessibilityViewId(parentNodeId);
            while (true) {
                int i = accessibilityViewId;
                if (i == Integer.MAX_VALUE || list.size() >= 50) {
                    return;
                }
                int virtualDescendantId = AccessibilityNodeInfo.getVirtualDescendantId(parentNodeId);
                if (virtualDescendantId == Integer.MAX_VALUE && i != view.getAccessibilityViewId()) {
                    prefetchPredecessorsOfRealNode(view, list);
                    return;
                }
                AccessibilityNodeInfo createAccessibilityNodeInfo = virtualDescendantId != Integer.MAX_VALUE ? accessibilityNodeProvider.createAccessibilityNodeInfo(virtualDescendantId) : accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
                if (createAccessibilityNodeInfo == null) {
                    return;
                }
                list.add(createAccessibilityNodeInfo);
                parentNodeId = createAccessibilityNodeInfo.getParentNodeId();
                accessibilityViewId = AccessibilityNodeInfo.getAccessibilityViewId(parentNodeId);
            }
        }

        private void prefetchSiblingsOfRealNode(View view, List<AccessibilityNodeInfo> list) {
            ViewParent parentForAccessibility = view.getParentForAccessibility();
            if (!(parentForAccessibility instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) parentForAccessibility;
            ArrayList<View> arrayList = this.mTempViewList;
            arrayList.clear();
            try {
                viewGroup.addChildrenForAccessibility(arrayList);
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return;
                    }
                    if (list.size() >= 50) {
                        return;
                    }
                    View view2 = arrayList.get(i2);
                    if (view2.getAccessibilityViewId() != view.getAccessibilityViewId() && AccessibilityInteractionController.this.isShown(view2)) {
                        AccessibilityNodeProvider accessibilityNodeProvider = view2.getAccessibilityNodeProvider();
                        AccessibilityNodeInfo createAccessibilityNodeInfo = accessibilityNodeProvider == null ? view2.createAccessibilityNodeInfo() : accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
                        if (createAccessibilityNodeInfo != null) {
                            list.add(createAccessibilityNodeInfo);
                        }
                    }
                    i = i2 + 1;
                }
            } finally {
                arrayList.clear();
            }
        }

        private void prefetchSiblingsOfVirtualNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeProvider accessibilityNodeProvider, List<AccessibilityNodeInfo> list) {
            AccessibilityNodeInfo createAccessibilityNodeInfo;
            long parentNodeId = accessibilityNodeInfo.getParentNodeId();
            int accessibilityViewId = AccessibilityNodeInfo.getAccessibilityViewId(parentNodeId);
            int virtualDescendantId = AccessibilityNodeInfo.getVirtualDescendantId(parentNodeId);
            if (virtualDescendantId == Integer.MAX_VALUE && accessibilityViewId != view.getAccessibilityViewId()) {
                prefetchSiblingsOfRealNode(view, list);
                return;
            }
            AccessibilityNodeInfo createAccessibilityNodeInfo2 = virtualDescendantId != Integer.MAX_VALUE ? accessibilityNodeProvider.createAccessibilityNodeInfo(virtualDescendantId) : accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
            if (createAccessibilityNodeInfo2 == null) {
                return;
            }
            int childCount = createAccessibilityNodeInfo2.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount || list.size() >= 50) {
                    return;
                }
                long childId = createAccessibilityNodeInfo2.getChildId(i2);
                if (childId != accessibilityNodeInfo.getSourceNodeId() && (createAccessibilityNodeInfo = accessibilityNodeProvider.createAccessibilityNodeInfo(AccessibilityNodeInfo.getVirtualDescendantId(childId))) != null) {
                    list.add(createAccessibilityNodeInfo);
                }
                i = i2 + 1;
            }
        }

        public void prefetchAccessibilityNodeInfos(View view, int i, int i2, List<AccessibilityNodeInfo> list) {
            AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
            if (accessibilityNodeProvider == null) {
                AccessibilityNodeInfo createAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
                if (createAccessibilityNodeInfo != null) {
                    list.add(createAccessibilityNodeInfo);
                    if ((i2 & 1) != 0) {
                        prefetchPredecessorsOfRealNode(view, list);
                    }
                    if ((i2 & 2) != 0) {
                        prefetchSiblingsOfRealNode(view, list);
                    }
                    if ((i2 & 4) != 0) {
                        prefetchDescendantsOfRealNode(view, list);
                        return;
                    }
                    return;
                }
                return;
            }
            AccessibilityNodeInfo createAccessibilityNodeInfo2 = i != Integer.MAX_VALUE ? accessibilityNodeProvider.createAccessibilityNodeInfo(i) : accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
            if (createAccessibilityNodeInfo2 != null) {
                list.add(createAccessibilityNodeInfo2);
                if ((i2 & 1) != 0) {
                    prefetchPredecessorsOfVirtualNode(createAccessibilityNodeInfo2, view, accessibilityNodeProvider, list);
                }
                if ((i2 & 2) != 0) {
                    prefetchSiblingsOfVirtualNode(createAccessibilityNodeInfo2, view, accessibilityNodeProvider, list);
                }
                if ((i2 & 4) != 0) {
                    prefetchDescendantsOfVirtualNode(createAccessibilityNodeInfo2, accessibilityNodeProvider, list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityInteractionController$AddNodeInfosForViewId.class */
    public final class AddNodeInfosForViewId implements Predicate<View> {
        private List<AccessibilityNodeInfo> mInfos;
        private int mViewId;

        private AddNodeInfosForViewId() {
            this.mViewId = -1;
        }

        public boolean apply(View view) {
            if (view.getId() == this.mViewId && AccessibilityInteractionController.this.isShown(view)) {
                this.mInfos.add(view.createAccessibilityNodeInfo());
                return false;
            }
            return false;
        }

        public void init(int i, List<AccessibilityNodeInfo> list) {
            this.mViewId = i;
            this.mInfos = list;
        }

        public void reset() {
            this.mViewId = -1;
            this.mInfos = null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityInteractionController$PrivateHandler.class */
    private class PrivateHandler extends Handler {
        private static final int MSG_FIND_ACCESSIBILITY_NODE_INFOS_BY_VIEW_ID = 3;
        private static final int MSG_FIND_ACCESSIBILITY_NODE_INFO_BY_ACCESSIBILITY_ID = 2;
        private static final int MSG_FIND_ACCESSIBILITY_NODE_INFO_BY_TEXT = 4;
        private static final int MSG_FIND_FOCUS = 5;
        private static final int MSG_FOCUS_SEARCH = 6;
        private static final int MSG_PERFORM_ACCESSIBILITY_ACTION = 1;

        public PrivateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public String getMessageName(Message message) {
            int i = message.what;
            switch (i) {
                case 1:
                    return "MSG_PERFORM_ACCESSIBILITY_ACTION";
                case 2:
                    return "MSG_FIND_ACCESSIBILITY_NODE_INFO_BY_ACCESSIBILITY_ID";
                case 3:
                    return "MSG_FIND_ACCESSIBILITY_NODE_INFOS_BY_VIEW_ID";
                case 4:
                    return "MSG_FIND_ACCESSIBILITY_NODE_INFO_BY_TEXT";
                case 5:
                    return "MSG_FIND_FOCUS";
                case 6:
                    return "MSG_FOCUS_SEARCH";
                default:
                    throw new IllegalArgumentException("Unknown message type: " + i);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case 1:
                    AccessibilityInteractionController.this.perfromAccessibilityActionUiThread(message);
                    return;
                case 2:
                    AccessibilityInteractionController.this.findAccessibilityNodeInfoByAccessibilityIdUiThread(message);
                    return;
                case 3:
                    AccessibilityInteractionController.this.findAccessibilityNodeInfosByViewIdUiThread(message);
                    return;
                case 4:
                    AccessibilityInteractionController.this.findAccessibilityNodeInfosByTextUiThread(message);
                    return;
                case 5:
                    AccessibilityInteractionController.this.findFocusUiThread(message);
                    return;
                case 6:
                    AccessibilityInteractionController.this.focusSearchUiThread(message);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown message type: " + i);
            }
        }
    }

    public AccessibilityInteractionController(ViewRootImpl viewRootImpl) {
        Looper looper = viewRootImpl.mHandler.getLooper();
        this.mMyLooperThreadId = looper.getThread().getId();
        this.mMyProcessId = Process.myPid();
        this.mHandler = new PrivateHandler(looper);
        this.mViewRootImpl = viewRootImpl;
        this.mPrefetcher = new AccessibilityNodePrefetcher();
    }

    private void adjustIsVisibleToUserIfNeeded(AccessibilityNodeInfo accessibilityNodeInfo, Region region) {
        if (region == null || accessibilityNodeInfo == null) {
            return;
        }
        Rect rect = this.mTempRect;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        if (region.quickReject(rect)) {
            accessibilityNodeInfo.setVisibleToUser(false);
        }
    }

    private void adjustIsVisibleToUserIfNeeded(List<AccessibilityNodeInfo> list, Region region) {
        if (region == null || list == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            adjustIsVisibleToUserIfNeeded(list.get(i2), region);
            i = i2 + 1;
        }
    }

    private void applyAppScaleAndMagnificationSpecIfNeeded(Point point, MagnificationSpec magnificationSpec) {
        float f = this.mViewRootImpl.mAttachInfo.mApplicationScale;
        if (shouldApplyAppScaleAndMagnificationSpec(f, magnificationSpec)) {
            if (f != 1.0f) {
                point.x = (int) (point.x * f);
                point.y = (int) (point.y * f);
            }
            if (magnificationSpec != null) {
                point.x = (int) (point.x * magnificationSpec.scale);
                point.y = (int) (point.y * magnificationSpec.scale);
                point.x += (int) magnificationSpec.offsetX;
                point.y += (int) magnificationSpec.offsetY;
            }
        }
    }

    private void applyAppScaleAndMagnificationSpecIfNeeded(AccessibilityNodeInfo accessibilityNodeInfo, MagnificationSpec magnificationSpec) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        float f = this.mViewRootImpl.mAttachInfo.mApplicationScale;
        if (shouldApplyAppScaleAndMagnificationSpec(f, magnificationSpec)) {
            Rect rect = this.mTempRect;
            Rect rect2 = this.mTempRect1;
            accessibilityNodeInfo.getBoundsInParent(rect);
            accessibilityNodeInfo.getBoundsInScreen(rect2);
            if (f != 1.0f) {
                rect.scale(f);
                rect2.scale(f);
            }
            if (magnificationSpec != null) {
                rect.scale(magnificationSpec.scale);
                rect2.scale(magnificationSpec.scale);
                rect2.offset((int) magnificationSpec.offsetX, (int) magnificationSpec.offsetY);
            }
            accessibilityNodeInfo.setBoundsInParent(rect);
            accessibilityNodeInfo.setBoundsInScreen(rect2);
            if (magnificationSpec != null) {
                View.AttachInfo attachInfo = this.mViewRootImpl.mAttachInfo;
                if (attachInfo.mDisplay != null) {
                    float f2 = attachInfo.mApplicationScale * magnificationSpec.scale;
                    Rect rect3 = this.mTempRect1;
                    rect3.left = (int) ((attachInfo.mWindowLeft * f2) + magnificationSpec.offsetX);
                    rect3.top = (int) ((attachInfo.mWindowTop * f2) + magnificationSpec.offsetY);
                    rect3.right = (int) (rect3.left + (this.mViewRootImpl.mWidth * f2));
                    rect3.bottom = (int) (rect3.top + (this.mViewRootImpl.mHeight * f2));
                    attachInfo.mDisplay.getRealSize(this.mTempPoint);
                    int i = this.mTempPoint.x;
                    int i2 = this.mTempPoint.y;
                    Rect rect4 = this.mTempRect2;
                    rect4.set(0, 0, i, i2);
                    rect3.intersect(rect4);
                    if (rect3.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                        return;
                    }
                    accessibilityNodeInfo.setVisibleToUser(false);
                }
            }
        }
    }

    private void applyAppScaleAndMagnificationSpecIfNeeded(List<AccessibilityNodeInfo> list, MagnificationSpec magnificationSpec) {
        if (list == null || !shouldApplyAppScaleAndMagnificationSpec(this.mViewRootImpl.mAttachInfo.mApplicationScale, magnificationSpec)) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            applyAppScaleAndMagnificationSpecIfNeeded(list.get(i2), magnificationSpec);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
        int i = message.arg1;
        SomeArgs someArgs = (SomeArgs) message.obj;
        int i2 = someArgs.argi1;
        int i3 = someArgs.argi2;
        int i4 = someArgs.argi3;
        IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback = (IAccessibilityInteractionConnectionCallback) someArgs.arg1;
        MagnificationSpec magnificationSpec = (MagnificationSpec) someArgs.arg2;
        Region region = (Region) someArgs.arg3;
        someArgs.recycle();
        ArrayList<AccessibilityNodeInfo> arrayList = this.mTempAccessibilityNodeInfoList;
        arrayList.clear();
        try {
            if (this.mViewRootImpl.mView == null || this.mViewRootImpl.mAttachInfo == null) {
                try {
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = i;
            View findViewByAccessibilityId = i2 == Integer.MAX_VALUE ? this.mViewRootImpl.mView : findViewByAccessibilityId(i2);
            if (findViewByAccessibilityId != null && isShown(findViewByAccessibilityId)) {
                this.mPrefetcher.prefetchAccessibilityNodeInfos(findViewByAccessibilityId, i3, i, arrayList);
            }
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(arrayList, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(arrayList, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(arrayList, i4);
                arrayList.clear();
            } catch (RemoteException e2) {
            }
        } finally {
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(arrayList, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(arrayList, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(arrayList, i4);
                arrayList.clear();
            } catch (RemoteException e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findAccessibilityNodeInfosByTextUiThread(Message message) {
        int i = message.arg1;
        SomeArgs someArgs = (SomeArgs) message.obj;
        String str = (String) someArgs.arg1;
        IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback = (IAccessibilityInteractionConnectionCallback) someArgs.arg2;
        MagnificationSpec magnificationSpec = (MagnificationSpec) someArgs.arg3;
        int i2 = someArgs.argi1;
        int i3 = someArgs.argi2;
        int i4 = someArgs.argi3;
        Region region = (Region) someArgs.arg4;
        someArgs.recycle();
        try {
            if (this.mViewRootImpl.mView == null || this.mViewRootImpl.mAttachInfo == null) {
                try {
                    this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                    applyAppScaleAndMagnificationSpecIfNeeded((List<AccessibilityNodeInfo>) null, magnificationSpec);
                    if (magnificationSpec != null) {
                        magnificationSpec.recycle();
                    }
                    adjustIsVisibleToUserIfNeeded((List<AccessibilityNodeInfo>) null, region);
                    iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult((List) null, i4);
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = i;
            View findViewByAccessibilityId = i2 != Integer.MAX_VALUE ? findViewByAccessibilityId(i2) : this.mViewRootImpl.mView;
            ArrayList<AccessibilityNodeInfo> arrayList = null;
            if (findViewByAccessibilityId != null) {
                arrayList = null;
                if (isShown(findViewByAccessibilityId)) {
                    AccessibilityNodeProvider accessibilityNodeProvider = findViewByAccessibilityId.getAccessibilityNodeProvider();
                    if (accessibilityNodeProvider != null) {
                        arrayList = i3 != Integer.MAX_VALUE ? accessibilityNodeProvider.findAccessibilityNodeInfosByText(str, i3) : accessibilityNodeProvider.findAccessibilityNodeInfosByText(str, -1);
                    } else {
                        arrayList = null;
                        if (i3 == Integer.MAX_VALUE) {
                            ArrayList<View> arrayList2 = this.mTempArrayList;
                            arrayList2.clear();
                            findViewByAccessibilityId.findViewsWithText(arrayList2, str, 7);
                            arrayList = null;
                            if (!arrayList2.isEmpty()) {
                                ArrayList<AccessibilityNodeInfo> arrayList3 = this.mTempAccessibilityNodeInfoList;
                                arrayList3.clear();
                                int size = arrayList2.size();
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    arrayList = arrayList3;
                                    if (i6 >= size) {
                                        break;
                                    }
                                    View view = arrayList2.get(i6);
                                    if (isShown(view)) {
                                        AccessibilityNodeProvider accessibilityNodeProvider2 = view.getAccessibilityNodeProvider();
                                        if (accessibilityNodeProvider2 != null) {
                                            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = accessibilityNodeProvider2.findAccessibilityNodeInfosByText(str, -1);
                                            if (findAccessibilityNodeInfosByText != null) {
                                                arrayList3.addAll(findAccessibilityNodeInfosByText);
                                            }
                                        } else {
                                            arrayList3.add(view.createAccessibilityNodeInfo());
                                        }
                                    }
                                    i5 = i6 + 1;
                                }
                            }
                        }
                    }
                }
            }
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(arrayList, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(arrayList, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(arrayList, i4);
            } catch (RemoteException e2) {
            }
        } catch (Throwable th) {
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded((List<AccessibilityNodeInfo>) null, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded((List<AccessibilityNodeInfo>) null, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult((List) null, i4);
            } catch (RemoteException e3) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findAccessibilityNodeInfosByViewIdUiThread(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        SomeArgs someArgs = (SomeArgs) message.obj;
        int i3 = someArgs.argi1;
        IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback = (IAccessibilityInteractionConnectionCallback) someArgs.arg1;
        MagnificationSpec magnificationSpec = (MagnificationSpec) someArgs.arg2;
        String str = (String) someArgs.arg3;
        Region region = (Region) someArgs.arg4;
        someArgs.recycle();
        ArrayList<AccessibilityNodeInfo> arrayList = this.mTempAccessibilityNodeInfoList;
        arrayList.clear();
        try {
            if (this.mViewRootImpl.mView == null || this.mViewRootImpl.mAttachInfo == null) {
                try {
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = i;
            View findViewByAccessibilityId = i2 != Integer.MAX_VALUE ? findViewByAccessibilityId(i2) : this.mViewRootImpl.mView;
            if (findViewByAccessibilityId != null) {
                int identifier = findViewByAccessibilityId.getContext().getResources().getIdentifier(str, null, null);
                if (identifier <= 0) {
                    try {
                        this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                        applyAppScaleAndMagnificationSpecIfNeeded(arrayList, magnificationSpec);
                        if (magnificationSpec != null) {
                            magnificationSpec.recycle();
                        }
                        adjustIsVisibleToUserIfNeeded(arrayList, region);
                        iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(arrayList, i3);
                        return;
                    } catch (RemoteException e2) {
                        return;
                    }
                }
                if (this.mAddNodeInfosForViewId == null) {
                    this.mAddNodeInfosForViewId = new AddNodeInfosForViewId();
                }
                this.mAddNodeInfosForViewId.init(identifier, arrayList);
                findViewByAccessibilityId.findViewByPredicate(this.mAddNodeInfosForViewId);
                this.mAddNodeInfosForViewId.reset();
            }
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(arrayList, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(arrayList, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(arrayList, i3);
            } catch (RemoteException e3) {
            }
        } finally {
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(arrayList, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(arrayList, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfosResult(arrayList, i3);
            } catch (RemoteException e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findFocusUiThread(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        SomeArgs someArgs = (SomeArgs) message.obj;
        int i3 = someArgs.argi1;
        int i4 = someArgs.argi2;
        int i5 = someArgs.argi3;
        IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback = (IAccessibilityInteractionConnectionCallback) someArgs.arg1;
        MagnificationSpec magnificationSpec = (MagnificationSpec) someArgs.arg2;
        Region region = (Region) someArgs.arg3;
        someArgs.recycle();
        try {
            if (this.mViewRootImpl.mView == null || this.mViewRootImpl.mAttachInfo == null) {
                try {
                    this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                    applyAppScaleAndMagnificationSpecIfNeeded((AccessibilityNodeInfo) null, magnificationSpec);
                    if (magnificationSpec != null) {
                        magnificationSpec.recycle();
                    }
                    adjustIsVisibleToUserIfNeeded((AccessibilityNodeInfo) null, region);
                    iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult((AccessibilityNodeInfo) null, i3);
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = i;
            View findViewByAccessibilityId = i4 != Integer.MAX_VALUE ? findViewByAccessibilityId(i4) : this.mViewRootImpl.mView;
            AccessibilityNodeInfo accessibilityNodeInfo = null;
            if (findViewByAccessibilityId != null) {
                accessibilityNodeInfo = null;
                if (isShown(findViewByAccessibilityId)) {
                    switch (i2) {
                        case 1:
                            View findFocus = findViewByAccessibilityId.findFocus();
                            accessibilityNodeInfo = null;
                            if (findFocus != null) {
                                accessibilityNodeInfo = null;
                                if (isShown(findFocus)) {
                                    AccessibilityNodeProvider accessibilityNodeProvider = findFocus.getAccessibilityNodeProvider();
                                    AccessibilityNodeInfo accessibilityNodeInfo2 = null;
                                    if (accessibilityNodeProvider != null) {
                                        accessibilityNodeInfo2 = accessibilityNodeProvider.findFocus(i2);
                                    }
                                    accessibilityNodeInfo = accessibilityNodeInfo2;
                                    if (accessibilityNodeInfo2 == null) {
                                        accessibilityNodeInfo = findFocus.createAccessibilityNodeInfo();
                                        break;
                                    }
                                }
                            }
                            break;
                        case 2:
                            View view = this.mViewRootImpl.mAccessibilityFocusedHost;
                            accessibilityNodeInfo = null;
                            if (view != null) {
                                if (!ViewRootImpl.isViewDescendantOf(view, findViewByAccessibilityId)) {
                                    accessibilityNodeInfo = null;
                                    break;
                                } else {
                                    accessibilityNodeInfo = null;
                                    if (isShown(view)) {
                                        if (view.getAccessibilityNodeProvider() == null) {
                                            accessibilityNodeInfo = null;
                                            if (i5 == Integer.MAX_VALUE) {
                                                accessibilityNodeInfo = view.createAccessibilityNodeInfo();
                                                break;
                                            }
                                        } else {
                                            accessibilityNodeInfo = null;
                                            if (this.mViewRootImpl.mAccessibilityFocusedVirtualView != null) {
                                                accessibilityNodeInfo = AccessibilityNodeInfo.obtain(this.mViewRootImpl.mAccessibilityFocusedVirtualView);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown focus type: " + i2);
                    }
                }
            }
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(accessibilityNodeInfo, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(accessibilityNodeInfo, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult(accessibilityNodeInfo, i3);
            } catch (RemoteException e2) {
            }
        } catch (Throwable th) {
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded((AccessibilityNodeInfo) null, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded((AccessibilityNodeInfo) null, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult((AccessibilityNodeInfo) null, i3);
            } catch (RemoteException e3) {
            }
            throw th;
        }
    }

    private View findViewByAccessibilityId(int i) {
        View view;
        View view2 = this.mViewRootImpl.mView;
        if (view2 == null) {
            view = null;
        } else {
            View findViewByAccessibilityId = view2.findViewByAccessibilityId(i);
            view = findViewByAccessibilityId;
            if (findViewByAccessibilityId != null) {
                view = findViewByAccessibilityId;
                if (!isShown(findViewByAccessibilityId)) {
                    return null;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void focusSearchUiThread(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        SomeArgs someArgs = (SomeArgs) message.obj;
        int i3 = someArgs.argi2;
        int i4 = someArgs.argi3;
        IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback = (IAccessibilityInteractionConnectionCallback) someArgs.arg1;
        MagnificationSpec magnificationSpec = (MagnificationSpec) someArgs.arg2;
        Region region = (Region) someArgs.arg3;
        someArgs.recycle();
        try {
            if (this.mViewRootImpl.mView == null || this.mViewRootImpl.mAttachInfo == null) {
                try {
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = i;
            View findViewByAccessibilityId = i2 != Integer.MAX_VALUE ? findViewByAccessibilityId(i2) : this.mViewRootImpl.mView;
            AccessibilityNodeInfo accessibilityNodeInfo = null;
            if (findViewByAccessibilityId != null) {
                accessibilityNodeInfo = null;
                if (isShown(findViewByAccessibilityId)) {
                    View focusSearch = findViewByAccessibilityId.focusSearch(i3);
                    accessibilityNodeInfo = null;
                    if (focusSearch != null) {
                        accessibilityNodeInfo = focusSearch.createAccessibilityNodeInfo();
                    }
                }
            }
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded(accessibilityNodeInfo, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded(accessibilityNodeInfo, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult(accessibilityNodeInfo, i4);
            } catch (RemoteException e2) {
            }
        } finally {
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                applyAppScaleAndMagnificationSpecIfNeeded((AccessibilityNodeInfo) null, magnificationSpec);
                if (magnificationSpec != null) {
                    magnificationSpec.recycle();
                }
                adjustIsVisibleToUserIfNeeded((AccessibilityNodeInfo) null, region);
                iAccessibilityInteractionConnectionCallback.setFindAccessibilityNodeInfoResult((AccessibilityNodeInfo) null, i4);
            } catch (RemoteException e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShown(View view) {
        return view.mAttachInfo != null && view.mAttachInfo.mWindowVisibility == 0 && view.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfromAccessibilityActionUiThread(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        SomeArgs someArgs = (SomeArgs) message.obj;
        int i3 = someArgs.argi1;
        int i4 = someArgs.argi2;
        int i5 = someArgs.argi3;
        IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback = (IAccessibilityInteractionConnectionCallback) someArgs.arg1;
        Bundle bundle = (Bundle) someArgs.arg2;
        someArgs.recycle();
        try {
            if (this.mViewRootImpl.mView == null || this.mViewRootImpl.mAttachInfo == null) {
                try {
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = i;
            View findViewByAccessibilityId = i2 != Integer.MAX_VALUE ? findViewByAccessibilityId(i2) : this.mViewRootImpl.mView;
            boolean z = false;
            if (findViewByAccessibilityId != null) {
                z = false;
                if (isShown(findViewByAccessibilityId)) {
                    AccessibilityNodeProvider accessibilityNodeProvider = findViewByAccessibilityId.getAccessibilityNodeProvider();
                    if (accessibilityNodeProvider != null) {
                        z = i3 != Integer.MAX_VALUE ? accessibilityNodeProvider.performAction(i3, i4, bundle) : accessibilityNodeProvider.performAction(-1, i4, bundle);
                    } else {
                        z = false;
                        if (i3 == Integer.MAX_VALUE) {
                            z = findViewByAccessibilityId.performAccessibilityAction(i4, bundle);
                        }
                    }
                }
            }
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                iAccessibilityInteractionConnectionCallback.setPerformAccessibilityActionResult(z, i5);
            } catch (RemoteException e2) {
            }
        } finally {
            try {
                this.mViewRootImpl.mAttachInfo.mAccessibilityFetchFlags = 0;
                iAccessibilityInteractionConnectionCallback.setPerformAccessibilityActionResult(false, i5);
            } catch (RemoteException e3) {
            }
        }
    }

    private boolean shouldApplyAppScaleAndMagnificationSpec(float f, MagnificationSpec magnificationSpec) {
        if (f == 1.0f) {
            return (magnificationSpec == null || magnificationSpec.isNop()) ? false : true;
        }
        return true;
    }

    public void findAccessibilityNodeInfoByAccessibilityIdClientThread(long j, Region region, int i, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i2, int i3, long j2, MagnificationSpec magnificationSpec) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.arg1 = i2;
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi1 = AccessibilityNodeInfo.getAccessibilityViewId(j);
        obtain.argi2 = AccessibilityNodeInfo.getVirtualDescendantId(j);
        obtain.argi3 = i;
        obtain.arg1 = iAccessibilityInteractionConnectionCallback;
        obtain.arg2 = magnificationSpec;
        obtain.arg3 = region;
        obtainMessage.obj = obtain;
        if (i3 == this.mMyProcessId && j2 == this.mMyLooperThreadId) {
            AccessibilityInteractionClient.getInstanceForThread(j2).setSameThreadMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void findAccessibilityNodeInfosByTextClientThread(long j, String str, Region region, int i, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i2, int i3, long j2, MagnificationSpec magnificationSpec) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.arg1 = i2;
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = str;
        obtain.arg2 = iAccessibilityInteractionConnectionCallback;
        obtain.arg3 = magnificationSpec;
        obtain.argi1 = AccessibilityNodeInfo.getAccessibilityViewId(j);
        obtain.argi2 = AccessibilityNodeInfo.getVirtualDescendantId(j);
        obtain.argi3 = i;
        obtain.arg4 = region;
        obtainMessage.obj = obtain;
        if (i3 == this.mMyProcessId && j2 == this.mMyLooperThreadId) {
            AccessibilityInteractionClient.getInstanceForThread(j2).setSameThreadMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void findAccessibilityNodeInfosByViewIdClientThread(long j, String str, Region region, int i, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i2, int i3, long j2, MagnificationSpec magnificationSpec) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = i2;
        obtainMessage.arg2 = AccessibilityNodeInfo.getAccessibilityViewId(j);
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi1 = i;
        obtain.arg1 = iAccessibilityInteractionConnectionCallback;
        obtain.arg2 = magnificationSpec;
        obtain.arg3 = str;
        obtain.arg4 = region;
        obtainMessage.obj = obtain;
        if (i3 == this.mMyProcessId && j2 == this.mMyLooperThreadId) {
            AccessibilityInteractionClient.getInstanceForThread(j2).setSameThreadMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void findFocusClientThread(long j, int i, Region region, int i2, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i3, int i4, long j2, MagnificationSpec magnificationSpec) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.arg1 = i3;
        obtainMessage.arg2 = i;
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi1 = i2;
        obtain.argi2 = AccessibilityNodeInfo.getAccessibilityViewId(j);
        obtain.argi3 = AccessibilityNodeInfo.getVirtualDescendantId(j);
        obtain.arg1 = iAccessibilityInteractionConnectionCallback;
        obtain.arg2 = magnificationSpec;
        obtain.arg3 = region;
        obtainMessage.obj = obtain;
        if (i4 == this.mMyProcessId && j2 == this.mMyLooperThreadId) {
            AccessibilityInteractionClient.getInstanceForThread(j2).setSameThreadMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void focusSearchClientThread(long j, int i, Region region, int i2, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i3, int i4, long j2, MagnificationSpec magnificationSpec) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        obtainMessage.arg1 = i3;
        obtainMessage.arg2 = AccessibilityNodeInfo.getAccessibilityViewId(j);
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi2 = i;
        obtain.argi3 = i2;
        obtain.arg1 = iAccessibilityInteractionConnectionCallback;
        obtain.arg2 = magnificationSpec;
        obtain.arg3 = region;
        obtainMessage.obj = obtain;
        if (i4 == this.mMyProcessId && j2 == this.mMyLooperThreadId) {
            AccessibilityInteractionClient.getInstanceForThread(j2).setSameThreadMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void performAccessibilityActionClientThread(long j, int i, Bundle bundle, int i2, IAccessibilityInteractionConnectionCallback iAccessibilityInteractionConnectionCallback, int i3, int i4, long j2) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg1 = i3;
        obtainMessage.arg2 = AccessibilityNodeInfo.getAccessibilityViewId(j);
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi1 = AccessibilityNodeInfo.getVirtualDescendantId(j);
        obtain.argi2 = i;
        obtain.argi3 = i2;
        obtain.arg1 = iAccessibilityInteractionConnectionCallback;
        obtain.arg2 = bundle;
        obtainMessage.obj = obtain;
        if (i4 == this.mMyProcessId && j2 == this.mMyLooperThreadId) {
            AccessibilityInteractionClient.getInstanceForThread(j2).setSameThreadMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }
}
