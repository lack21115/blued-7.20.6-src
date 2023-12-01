package android.app;

import android.app.FragmentManager;
import android.graphics.Rect;
import android.net.wifi.WifiEnterpriseConfig;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LogWriter;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.android.internal.util.FastPrintWriter;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/BackStackRecord.class */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    Op mHead;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    Op mTail;
    int mTransition;
    int mTransitionStyle;
    boolean mAllowAddToBackStack = true;
    int mIndex = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/BackStackRecord$Op.class */
    public static final class Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        Op next;
        int popEnterAnim;
        int popExitAnim;
        Op prev;
        ArrayList<Fragment> removed;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/BackStackRecord$TransitionState.class */
    public class TransitionState {
        public View enteringEpicenterView;
        public ArrayMap<String, String> nameOverrides = new ArrayMap<>();
        public View nonExistentView;

        public TransitionState() {
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.mManager = fragmentManagerImpl;
    }

    public static void addTargets(Transition transition, ArrayList<View> arrayList) {
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= transitionCount) {
                    return;
                }
                addTargets(transitionSet.getTransitionAt(i2), arrayList);
                i = i2 + 1;
            }
        } else if (hasSimpleTarget(transition) || !isNullOrEmpty(transition.getTargets())) {
        } else {
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    return;
                }
                transition.addTarget(arrayList.get(i4));
                i3 = i4 + 1;
            }
        }
    }

    private ArrayList<View> addTransitionTargets(final TransitionState transitionState, final Transition transition, final Transition transition2, final Transition transition3, final View view, final Fragment fragment, final Fragment fragment2, final ArrayList<View> arrayList, final boolean z, final ArrayList<View> arrayList2) {
        if (transition == null && transition2 == null && transition3 == null) {
            return null;
        }
        final ArrayList<View> arrayList3 = new ArrayList<>();
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.BackStackRecord.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                BackStackRecord.this.excludeHiddenFragments(arrayList, fragment.mContainerId, transition3);
                ArrayMap arrayMap = null;
                if (transition2 != null) {
                    arrayMap = BackStackRecord.this.mapSharedElementsIn(transitionState, z, fragment);
                    BackStackRecord.removeTargets(transition2, arrayList2);
                    arrayList2.clear();
                    arrayList2.add(transitionState.nonExistentView);
                    arrayList2.addAll(arrayMap.values());
                    BackStackRecord.addTargets(transition2, arrayList2);
                    BackStackRecord.this.setEpicenterIn(arrayMap, transitionState);
                    BackStackRecord.this.callSharedElementEnd(transitionState, fragment, fragment2, z, arrayMap);
                }
                if (transition != null) {
                    View view2 = fragment.getView();
                    if (view2 != null) {
                        view2.captureTransitioningViews(arrayList3);
                        if (arrayMap != null) {
                            arrayList3.removeAll(arrayMap.values());
                        }
                        arrayList3.add(transitionState.nonExistentView);
                        transition.removeTarget(transitionState.nonExistentView);
                        BackStackRecord.addTargets(transition, arrayList3);
                    }
                    BackStackRecord.this.setSharedElementEpicenter(transition, transitionState);
                    return true;
                }
                return true;
            }
        });
        return arrayList3;
    }

    private TransitionState beginTransition(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        TransitionState transitionState = new TransitionState();
        transitionState.nonExistentView = new View(this.mManager.mActivity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseArray.size()) {
                break;
            }
            configureTransitions(sparseArray.keyAt(i2), transitionState, z, sparseArray, sparseArray2);
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray2.size()) {
                return transitionState;
            }
            int keyAt = sparseArray2.keyAt(i4);
            if (sparseArray.get(keyAt) == null) {
                configureTransitions(keyAt, transitionState, z, sparseArray, sparseArray2);
            }
            i3 = i4 + 1;
        }
    }

    private void calculateFragments(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Fragment fragment;
        if (!this.mManager.mContainer.hasView()) {
            return;
        }
        Op op = this.mHead;
        while (true) {
            Op op2 = op;
            if (op2 == null) {
                return;
            }
            switch (op2.cmd) {
                case 1:
                    setLastIn(sparseArray2, op2.fragment);
                    break;
                case 2:
                    Fragment fragment2 = op2.fragment;
                    Fragment fragment3 = fragment2;
                    if (this.mManager.mAdded != null) {
                        int i = 0;
                        while (true) {
                            fragment3 = fragment2;
                            if (i < this.mManager.mAdded.size()) {
                                Fragment fragment4 = this.mManager.mAdded.get(i);
                                if (fragment2 != null) {
                                    fragment = fragment2;
                                    if (fragment4.mContainerId != fragment2.mContainerId) {
                                        i++;
                                        fragment2 = fragment;
                                    }
                                }
                                if (fragment4 == fragment2) {
                                    fragment = null;
                                } else {
                                    setFirstOut(sparseArray, fragment4);
                                    fragment = fragment2;
                                }
                                i++;
                                fragment2 = fragment;
                            }
                        }
                    }
                    setLastIn(sparseArray2, fragment3);
                    break;
                case 3:
                    setFirstOut(sparseArray, op2.fragment);
                    break;
                case 4:
                    setFirstOut(sparseArray, op2.fragment);
                    break;
                case 5:
                    setLastIn(sparseArray2, op2.fragment);
                    break;
                case 6:
                    setFirstOut(sparseArray, op2.fragment);
                    break;
                case 7:
                    setLastIn(sparseArray2, op2.fragment);
                    break;
            }
            op = op2.next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSharedElementEnd(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        (z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback).onSharedElementEnd(new ArrayList(arrayMap.keySet()), new ArrayList(arrayMap.values()), null);
    }

    private static ArrayList<View> captureExitingViews(Transition transition, Fragment fragment, ArrayMap<String, View> arrayMap, View view) {
        ArrayList<View> arrayList = null;
        if (transition != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            fragment.getView().captureTransitioningViews(arrayList2);
            if (arrayMap != null) {
                arrayList2.removeAll(arrayMap.values());
            }
            arrayList = arrayList2;
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                addTargets(transition, arrayList2);
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    private static Transition cloneTransition(Transition transition) {
        Transition transition2 = transition;
        if (transition != null) {
            transition2 = transition.mo996clone();
        }
        return transition2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e3, code lost:
        if (r0.isEmpty() != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void configureTransitions(int r13, android.app.BackStackRecord.TransitionState r14, boolean r15, android.util.SparseArray<android.app.Fragment> r16, android.util.SparseArray<android.app.Fragment> r17) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.BackStackRecord.configureTransitions(int, android.app.BackStackRecord$TransitionState, boolean, android.util.SparseArray, android.util.SparseArray):void");
    }

    private void doAddOp(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.mManager;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        Op op = new Op();
        op.cmd = i2;
        op.fragment = fragment;
        addOp(op);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void excludeHiddenFragments(ArrayList<View> arrayList, int i, Transition transition) {
        if (this.mManager.mAdded == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mManager.mAdded.size()) {
                return;
            }
            Fragment fragment = this.mManager.mAdded.get(i3);
            if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i) {
                if (!fragment.mHidden) {
                    transition.excludeTarget(fragment.mView, false);
                    arrayList.remove(fragment.mView);
                } else if (!arrayList.contains(fragment.mView)) {
                    transition.excludeTarget(fragment.mView, true);
                    arrayList.add(fragment.mView);
                }
            }
            i2 = i3 + 1;
        }
    }

    private static Transition getEnterTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Transition getExitTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Transition getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private static boolean hasSimpleTarget(Transition transition) {
        return (isNullOrEmpty(transition.getTargetIds()) && isNullOrEmpty(transition.getTargetNames()) && isNullOrEmpty(transition.getTargetTypes())) ? false : true;
    }

    private static boolean isNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }

    private ArrayMap<String, View> mapEnteringSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        View view = fragment.getView();
        ArrayMap<String, View> arrayMap2 = arrayMap;
        if (view != null) {
            arrayMap2 = arrayMap;
            if (this.mSharedElementSourceNames != null) {
                view.findNamedViews(arrayMap);
                if (!z) {
                    arrayMap.retainAll(this.mSharedElementTargetNames);
                    return arrayMap;
                }
                arrayMap2 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, arrayMap);
            }
        }
        return arrayMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayMap<String, View> mapSharedElementsIn(TransitionState transitionState, boolean z, Fragment fragment) {
        ArrayMap<String, View> mapEnteringSharedElements = mapEnteringSharedElements(transitionState, fragment, z);
        if (z) {
            fragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
            setBackNameOverrides(transitionState, mapEnteringSharedElements, true);
            return mapEnteringSharedElements;
        }
        fragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
        setNameOverrides(transitionState, mapEnteringSharedElements, true);
        return mapEnteringSharedElements;
    }

    private static Transition mergeTransitions(Transition transition, Transition transition2, Transition transition3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (transition != null) {
            z2 = true;
            if (transition2 != null) {
                z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
            }
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            return transitionSet;
        }
        if (transition2 != null && transition != null) {
            transition2 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 == null) {
            transition2 = null;
            if (transition != null) {
                transition2 = transition;
            }
        }
        if (transition3 != null) {
            TransitionSet transitionSet2 = new TransitionSet();
            if (transition2 != null) {
                transitionSet2.addTransition(transition2);
            }
            transitionSet2.addTransition(transition3);
            return transitionSet2;
        }
        return transition2;
    }

    private static ArrayMap<String, View> remapNames(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayMap<String, View> arrayMap) {
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        if (!arrayMap.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                View view = arrayMap.get(arrayList.get(i2));
                if (view != null) {
                    arrayMap2.put(arrayList2.get(i2), view);
                }
                i = i2 + 1;
            }
        }
        return arrayMap2;
    }

    private ArrayMap<String, View> remapSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        ArrayMap<String, View> arrayMap2 = arrayMap;
        if (this.mSharedElementSourceNames != null) {
            fragment.getView().findNamedViews(arrayMap);
            if (z) {
                arrayMap.retainAll(this.mSharedElementTargetNames);
                arrayMap2 = arrayMap;
            } else {
                arrayMap2 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, arrayMap);
            }
        }
        if (z) {
            fragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, arrayMap2);
            setBackNameOverrides(transitionState, arrayMap2, false);
            return arrayMap2;
        }
        fragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, arrayMap2);
        setNameOverrides(transitionState, arrayMap2, false);
        return arrayMap2;
    }

    private void removeTargetedViewsFromTransitions(final ViewGroup viewGroup, final View view, final Transition transition, final ArrayList<View> arrayList, final Transition transition2, final ArrayList<View> arrayList2, final Transition transition3, final ArrayList<View> arrayList3, final Transition transition4, final ArrayList<View> arrayList4) {
        if (transition4 != null) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.BackStackRecord.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        transition.removeTarget(view);
                        BackStackRecord.removeTargets(transition, arrayList);
                    }
                    if (transition2 != null) {
                        BackStackRecord.removeTargets(transition2, arrayList2);
                    }
                    if (transition3 != null) {
                        BackStackRecord.removeTargets(transition3, arrayList3);
                    }
                    int size = arrayList4.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            transition4.excludeTarget(view, false);
                            return true;
                        }
                        transition4.excludeTarget((View) arrayList4.get(i2), false);
                        i = i2 + 1;
                    }
                }
            });
        }
    }

    public static void removeTargets(Transition transition, ArrayList<View> arrayList) {
        List<View> targets;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= transitionCount) {
                    return;
                }
                removeTargets(transitionSet.getTransitionAt(i2), arrayList);
                i = i2 + 1;
            }
        } else if (hasSimpleTarget(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
        } else {
            int size = arrayList.size();
            while (true) {
                int i3 = size - 1;
                if (i3 < 0) {
                    return;
                }
                transition.removeTarget(arrayList.get(i3));
                size = i3;
            }
        }
    }

    private void setBackNameOverrides(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = this.mSharedElementTargetNames.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String str = this.mSharedElementSourceNames.get(i2);
            View view = arrayMap.get(this.mSharedElementTargetNames.get(i2));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    setNameOverride(transitionState.nameOverrides, str, transitionName);
                } else {
                    setNameOverride(transitionState.nameOverrides, transitionName, str);
                }
            }
            i = i2 + 1;
        }
    }

    private static void setEpicenter(Transition transition, View view) {
        final Rect rect = new Rect();
        view.getBoundsOnScreen(rect);
        transition.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: android.app.BackStackRecord.3
            @Override // android.transition.Transition.EpicenterCallback
            public Rect onGetEpicenter(Transition transition2) {
                return Rect.this;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEpicenterIn(ArrayMap<String, View> arrayMap, TransitionState transitionState) {
        View view;
        if (this.mSharedElementTargetNames == null || arrayMap.isEmpty() || (view = arrayMap.get(this.mSharedElementTargetNames.get(0))) == null) {
            return;
        }
        transitionState.enteringEpicenterView = view;
    }

    private static void setFirstOut(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment == null || (i = fragment.mContainerId) == 0 || fragment.isHidden() || !fragment.isAdded() || fragment.getView() == null || sparseArray.get(i) != null) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    private void setLastIn(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment == null || (i = fragment.mContainerId) == 0) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    private static void setNameOverride(ArrayMap<String, String> arrayMap, String str, String str2) {
        if (str == null || str2 == null || str.equals(str2)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayMap.size()) {
                arrayMap.put(str, str2);
                return;
            } else if (str.equals(arrayMap.valueAt(i2))) {
                arrayMap.setValueAt(i2, str2);
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    private void setNameOverrides(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = arrayMap.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String keyAt = arrayMap.keyAt(i2);
            String transitionName = arrayMap.valueAt(i2).getTransitionName();
            if (z) {
                setNameOverride(transitionState.nameOverrides, keyAt, transitionName);
            } else {
                setNameOverride(transitionState.nameOverrides, transitionName, keyAt);
            }
            i = i2 + 1;
        }
    }

    private static void setNameOverrides(TransitionState transitionState, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            setNameOverride(transitionState.nameOverrides, arrayList.get(i2), arrayList2.get(i2));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSharedElementEpicenter(Transition transition, final TransitionState transitionState) {
        transition.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: android.app.BackStackRecord.4
            private Rect mEpicenter;

            @Override // android.transition.Transition.EpicenterCallback
            public Rect onGetEpicenter(Transition transition2) {
                if (this.mEpicenter == null && transitionState.enteringEpicenterView != null) {
                    this.mEpicenter = new Rect();
                    transitionState.enteringEpicenterView.getBoundsOnScreen(this.mEpicenter);
                }
                return this.mEpicenter;
            }
        });
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction add(int i, Fragment fragment, String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction add(Fragment fragment, String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOp(Op op) {
        if (this.mHead == null) {
            this.mTail = op;
            this.mHead = op;
        } else {
            op.prev = this.mTail;
            this.mTail.next = op;
            this.mTail = op;
        }
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
        this.mNumOp++;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction addSharedElement(View view, String str) {
        String transitionName = view.getTransitionName();
        if (transitionName == null) {
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        if (this.mSharedElementSourceNames == null) {
            this.mSharedElementSourceNames = new ArrayList<>();
            this.mSharedElementTargetNames = new ArrayList<>();
        }
        this.mSharedElementSourceNames.add(transitionName);
        this.mSharedElementTargetNames.add(str);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction addToBackStack(String str) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction attach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 7;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bumpBackStackNesting(int i) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Bump nesting in " + this + " by " + i);
        }
        Op op = this.mHead;
        while (true) {
            Op op2 = op;
            if (op2 == null) {
                return;
            }
            if (op2.fragment != null) {
                op2.fragment.mBackStackNesting += i;
                if (FragmentManagerImpl.DEBUG) {
                    Log.v(TAG, "Bump nesting of " + op2.fragment + " to " + op2.fragment.mBackStackNesting);
                }
            }
            if (op2.removed != null) {
                int size = op2.removed.size();
                while (true) {
                    int i2 = size - 1;
                    if (i2 >= 0) {
                        Fragment fragment = op2.removed.get(i2);
                        fragment.mBackStackNesting += i;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v(TAG, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                        size = i2;
                    }
                }
            }
            op = op2.next;
        }
    }

    public void calculateBackFragments(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (!this.mManager.mContainer.hasView()) {
            return;
        }
        Op op = this.mHead;
        while (true) {
            Op op2 = op;
            if (op2 == null) {
                return;
            }
            switch (op2.cmd) {
                case 1:
                    setFirstOut(sparseArray, op2.fragment);
                    break;
                case 2:
                    if (op2.removed != null) {
                        int size = op2.removed.size();
                        while (true) {
                            int i = size - 1;
                            if (i >= 0) {
                                setLastIn(sparseArray2, op2.removed.get(i));
                                size = i;
                            }
                        }
                    }
                    setFirstOut(sparseArray, op2.fragment);
                    break;
                case 3:
                    setLastIn(sparseArray2, op2.fragment);
                    break;
                case 4:
                    setLastIn(sparseArray2, op2.fragment);
                    break;
                case 5:
                    setFirstOut(sparseArray, op2.fragment);
                    break;
                case 6:
                    setLastIn(sparseArray2, op2.fragment);
                    break;
                case 7:
                    setFirstOut(sparseArray, op2.fragment);
                    break;
            }
            op = op2.next;
        }
    }

    @Override // android.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // android.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean z) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Commit: " + this);
            FastPrintWriter fastPrintWriter = new FastPrintWriter(new LogWriter(2, TAG), false, 1024);
            dump("  ", null, fastPrintWriter, null);
            fastPrintWriter.flush();
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z);
        return this.mIndex;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 6;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dump(str, printWriter, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mHead == null) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        Op op = this.mHead;
        int i = 0;
        while (true) {
            int i2 = i;
            if (op == null) {
                return;
            }
            switch (op.cmd) {
                case 0:
                    str2 = WifiEnterpriseConfig.EMPTY_VALUE;
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                default:
                    str2 = "cmd=" + op.cmd;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.fragment);
            if (z) {
                if (op.enterAnim != 0 || op.exitAnim != 0) {
                    printWriter.print(str3);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.enterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.exitAnim));
                }
                if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                    printWriter.print(str3);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.popEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.popExitAnim));
                }
            }
            if (op.removed != null && op.removed.size() > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < op.removed.size()) {
                        printWriter.print(str3);
                        if (op.removed.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i4 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i4);
                            printWriter.print(": ");
                        }
                        printWriter.println(op.removed.get(i4));
                        i3 = i4 + 1;
                    }
                }
            }
            op = op.next;
            i = i2 + 1;
        }
    }

    @Override // android.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    @Override // android.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // android.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mActivity.getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    @Override // android.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // android.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // android.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        Op op = new Op();
        op.cmd = 4;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    @Override // android.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mNumOp == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005a, code lost:
        if (r11.size() != 0) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.BackStackRecord.TransitionState popFromBackStack(boolean r8, android.app.BackStackRecord.TransitionState r9, android.util.SparseArray<android.app.Fragment> r10, android.util.SparseArray<android.app.Fragment> r11) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.BackStackRecord.popFromBackStack(boolean, android.app.BackStackRecord$TransitionState, android.util.SparseArray, android.util.SparseArray):android.app.BackStackRecord$TransitionState");
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        Op op = new Op();
        op.cmd = 3;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i, fragment, str, 2);
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment;
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Run: " + this);
        }
        if (this.mAddToBackStack && this.mIndex < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        bumpBackStackNesting(1);
        SparseArray<Fragment> sparseArray = new SparseArray<>();
        SparseArray<Fragment> sparseArray2 = new SparseArray<>();
        calculateFragments(sparseArray, sparseArray2);
        beginTransition(sparseArray, sparseArray2, false);
        Op op = this.mHead;
        while (true) {
            Op op2 = op;
            if (op2 == null) {
                this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, true);
                if (this.mAddToBackStack) {
                    this.mManager.addBackStackState(this);
                    return;
                }
                return;
            }
            switch (op2.cmd) {
                case 1:
                    Fragment fragment2 = op2.fragment;
                    fragment2.mNextAnim = op2.enterAnim;
                    this.mManager.addFragment(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = op2.fragment;
                    Fragment fragment4 = fragment3;
                    if (this.mManager.mAdded != null) {
                        int i = 0;
                        while (true) {
                            fragment4 = fragment3;
                            if (i < this.mManager.mAdded.size()) {
                                Fragment fragment5 = this.mManager.mAdded.get(i);
                                if (FragmentManagerImpl.DEBUG) {
                                    Log.v(TAG, "OP_REPLACE: adding=" + fragment3 + " old=" + fragment5);
                                }
                                if (fragment3 != null) {
                                    fragment = fragment3;
                                    if (fragment5.mContainerId != fragment3.mContainerId) {
                                        i++;
                                        fragment3 = fragment;
                                    }
                                }
                                if (fragment5 == fragment3) {
                                    fragment = null;
                                    op2.fragment = null;
                                } else {
                                    if (op2.removed == null) {
                                        op2.removed = new ArrayList<>();
                                    }
                                    op2.removed.add(fragment5);
                                    fragment5.mNextAnim = op2.exitAnim;
                                    if (this.mAddToBackStack) {
                                        fragment5.mBackStackNesting++;
                                        if (FragmentManagerImpl.DEBUG) {
                                            Log.v(TAG, "Bump nesting of " + fragment5 + " to " + fragment5.mBackStackNesting);
                                        }
                                    }
                                    this.mManager.removeFragment(fragment5, this.mTransition, this.mTransitionStyle);
                                    fragment = fragment3;
                                }
                                i++;
                                fragment3 = fragment;
                            }
                        }
                    }
                    if (fragment4 == null) {
                        break;
                    } else {
                        fragment4.mNextAnim = op2.enterAnim;
                        this.mManager.addFragment(fragment4, false);
                        break;
                    }
                case 3:
                    Fragment fragment6 = op2.fragment;
                    fragment6.mNextAnim = op2.exitAnim;
                    this.mManager.removeFragment(fragment6, this.mTransition, this.mTransitionStyle);
                    break;
                case 4:
                    Fragment fragment7 = op2.fragment;
                    fragment7.mNextAnim = op2.exitAnim;
                    this.mManager.hideFragment(fragment7, this.mTransition, this.mTransitionStyle);
                    break;
                case 5:
                    Fragment fragment8 = op2.fragment;
                    fragment8.mNextAnim = op2.enterAnim;
                    this.mManager.showFragment(fragment8, this.mTransition, this.mTransitionStyle);
                    break;
                case 6:
                    Fragment fragment9 = op2.fragment;
                    fragment9.mNextAnim = op2.exitAnim;
                    this.mManager.detachFragment(fragment9, this.mTransition, this.mTransitionStyle);
                    break;
                case 7:
                    Fragment fragment10 = op2.fragment;
                    fragment10.mNextAnim = op2.enterAnim;
                    this.mManager.attachFragment(fragment10, this.mTransition, this.mTransitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op2.cmd);
            }
            op = op2.next;
        }
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setSharedElement(View view, String str) {
        String transitionName = view.getTransitionName();
        if (transitionName == null) {
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        this.mSharedElementSourceNames = new ArrayList<>(1);
        this.mSharedElementSourceNames.add(transitionName);
        this.mSharedElementTargetNames = new ArrayList<>(1);
        this.mSharedElementTargetNames.add(str);
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setSharedElements(Pair<View, String>... pairArr) {
        if (pairArr == null || pairArr.length == 0) {
            this.mSharedElementSourceNames = null;
            this.mSharedElementTargetNames = null;
            return this;
        }
        ArrayList<String> arrayList = new ArrayList<>(pairArr.length);
        ArrayList<String> arrayList2 = new ArrayList<>(pairArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pairArr.length) {
                this.mSharedElementSourceNames = arrayList;
                this.mSharedElementTargetNames = arrayList2;
                return this;
            }
            String transitionName = pairArr[i2].first.getTransitionName();
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            arrayList.add(transitionName);
            arrayList2.add(pairArr[i2].second);
            i = i2 + 1;
        }
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction setTransitionStyle(int i) {
        this.mTransitionStyle = i;
        return this;
    }

    @Override // android.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        Op op = new Op();
        op.cmd = 5;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }
}
