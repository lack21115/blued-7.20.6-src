package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTransition.class */
public class FragmentTransition {

    /* renamed from: a  reason: collision with root package name */
    static final FragmentTransitionImpl f2966a;
    static final FragmentTransitionImpl b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2967c = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTransition$Callback.class */
    public interface Callback {
        void onComplete(Fragment fragment, CancellationSignal cancellationSignal);

        void onStart(Fragment fragment, CancellationSignal cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTransition$FragmentContainerTransition.class */
    public static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    static {
        f2966a = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        b = b();
    }

    private FragmentTransition() {
    }

    static View a(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.q == null || backStackRecord.q.isEmpty()) {
            return null;
        }
        return arrayMap.get(z ? backStackRecord.q.get(0) : backStackRecord.r.get(0));
    }

    private static ArrayMap<String, String> a(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        while (true) {
            i3--;
            if (i3 < i2) {
                return arrayMap;
            }
            BackStackRecord backStackRecord = arrayList.get(i3);
            if (backStackRecord.b(i)) {
                boolean booleanValue = arrayList2.get(i3).booleanValue();
                if (backStackRecord.q != null) {
                    int size = backStackRecord.q.size();
                    if (booleanValue) {
                        arrayList4 = backStackRecord.q;
                        arrayList3 = backStackRecord.r;
                    } else {
                        arrayList3 = backStackRecord.q;
                        arrayList4 = backStackRecord.r;
                    }
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < size) {
                            String str = arrayList3.get(i5);
                            String str2 = arrayList4.get(i5);
                            String remove = arrayMap.remove(str2);
                            if (remove != null) {
                                arrayMap.put(str, remove);
                            } else {
                                arrayMap.put(str, str2);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
            }
        }
    }

    static ArrayMap<String, View> a(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.a(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.q;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.r;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            int size = arrayList.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                String str = arrayList.get(i);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String a3 = a(arrayMap, str);
                    if (a3 != null) {
                        arrayMap.remove(a3);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (a2 = a(arrayMap, str)) != null) {
                    arrayMap.put(a2, ViewCompat.getTransitionName(view2));
                }
                size = i;
            }
        } else {
            a(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static FragmentContainerTransition a(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        if (fragmentContainerTransition == null) {
            fragmentContainerTransition2 = new FragmentContainerTransition();
            sparseArray.put(i, fragmentContainerTransition2);
        }
        return fragmentContainerTransition2;
    }

    private static FragmentTransitionImpl a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f2966a;
        if (fragmentTransitionImpl == null || !a(fragmentTransitionImpl, arrayList)) {
            FragmentTransitionImpl fragmentTransitionImpl2 = b;
            if (fragmentTransitionImpl2 == null || !a(fragmentTransitionImpl2, arrayList)) {
                if (f2966a == null && b == null) {
                    return null;
                }
                throw new IllegalArgumentException("Invalid Transition types");
            }
            return b;
        }
        return f2966a;
    }

    private static Object a(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        View view2;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        Object a2 = arrayMap.isEmpty() ? null : a(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> b2 = b(fragmentTransitionImpl, arrayMap, a2, fragmentContainerTransition);
        final ArrayMap<String, View> a3 = a(fragmentTransitionImpl, arrayMap, a2, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, arrayMap.keySet());
            a(arrayList2, a3, arrayMap.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            a(fragmentTransitionImpl, obj3, obj2, b2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            Rect rect2 = new Rect();
            view2 = a(a3, fragmentContainerTransition, obj, z);
            if (view2 != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect2);
            }
            rect = rect2;
        } else {
            rect = null;
            view2 = null;
        }
        final View view3 = view2;
        final Rect rect3 = rect;
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.5
            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.a(Fragment.this, fragment2, z, (ArrayMap<String, View>) a3, false);
                View view4 = view3;
                if (view4 != null) {
                    fragmentTransitionImpl.a(view4, rect3);
                }
            }
        });
        return obj3;
    }

    private static Object a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3) : fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            if (str.equals(arrayMap.valueAt(i2))) {
                return arrayMap.keyAt(i2);
            }
            i = i2 + 1;
        }
    }

    static ArrayList<View> a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2;
        if (obj != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                fragmentTransitionImpl.a(arrayList3, view2);
            }
            if (arrayList != null) {
                arrayList3.removeAll(arrayList);
            }
            arrayList2 = arrayList3;
            if (!arrayList3.isEmpty()) {
                arrayList3.add(view);
                fragmentTransitionImpl.addTargets(obj, arrayList3);
                return arrayList3;
            }
        } else {
            arrayList2 = null;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, FragmentContainer fragmentContainer, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, Callback callback) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                calculatePopFragments(backStackRecord, sparseArray, z);
            } else {
                calculateFragments(backStackRecord, sparseArray, z);
            }
            i3 = i4 + 1;
        }
        if (sparseArray.size() == 0) {
            return;
        }
        View view = new View(context);
        int size = sparseArray.size();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                return;
            }
            int keyAt = sparseArray.keyAt(i6);
            ArrayMap<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
            FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i6);
            if (fragmentContainer.onHasView() && (viewGroup = (ViewGroup) fragmentContainer.onFindViewById(keyAt)) != null) {
                if (z) {
                    a(viewGroup, fragmentContainerTransition, view, a2, callback);
                } else {
                    b(viewGroup, fragmentContainerTransition, view, a2, callback);
                }
            }
            i5 = i6 + 1;
        }
    }

    private static void a(ViewGroup viewGroup, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, final Callback callback) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        FragmentTransitionImpl a2 = a(fragment2, fragment);
        if (a2 == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object a4 = a(a2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, a3, b2);
        if (a3 == null && a4 == null && b2 == null) {
            return;
        }
        ArrayList<View> a5 = a(a2, b2, fragment2, arrayList2, view);
        ArrayList<View> a6 = a(a2, a3, fragment, arrayList, view);
        a(a6, 4);
        Object a7 = a(a2, a3, b2, a4, fragment, z);
        if (fragment2 != null && a5 != null && (a5.size() > 0 || arrayList2.size() > 0)) {
            final CancellationSignal cancellationSignal = new CancellationSignal();
            callback.onStart(fragment2, cancellationSignal);
            a2.setListenerForTransitionEnd(fragment2, a7, cancellationSignal, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onComplete(fragment2, cancellationSignal);
                }
            });
        }
        if (a7 != null) {
            a(a2, b2, fragment2, a5);
            ArrayList<String> a8 = a2.a(arrayList);
            a2.scheduleRemoveTargets(a7, a3, a6, b2, a5, a4, arrayList);
            a2.beginDelayedTransition(viewGroup, a7);
            a2.a(viewGroup, arrayList2, arrayList, a8, arrayMap);
            a(a6, 0);
            a2.swapSharedElementTargets(a4, arrayList2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        int size = arrayMap.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            if (!arrayMap2.containsKey(arrayMap.valueAt(i))) {
                arrayMap.removeAt(i);
            }
            size = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r0.mAdded != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f2, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x013e, code lost:
        if (r0.mHidden == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0141, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01d3, code lost:
        if (r5.firstOut == null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(androidx.fragment.app.BackStackRecord r4, androidx.fragment.app.FragmentTransaction.Op r5, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> r6, boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.a(androidx.fragment.app.BackStackRecord, androidx.fragment.app.FragmentTransaction$Op, android.util.SparseArray, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static void a(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.4
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    fragmentTransitionImpl.removeTarget(obj3, view);
                    arrayList2.addAll(FragmentTransition.a(fragmentTransitionImpl, obj, fragment, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        fragmentTransitionImpl.replaceTargets(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.2
                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.a(arrayList, 4);
                }
            });
        }
    }

    private static void a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        if (backStackRecord.q == null || backStackRecord.q.isEmpty()) {
            return;
        }
        View view = arrayMap.get(z ? backStackRecord.r.get(0) : backStackRecord.q.get(0));
        fragmentTransitionImpl.setEpicenter(obj, view);
        if (obj2 != null) {
            fragmentTransitionImpl.setEpicenter(obj2, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return;
            }
            arrayList.get(i2).setVisibility(i);
            size = i2;
        }
    }

    private static void a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        int size = arrayMap.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            View valueAt = arrayMap.valueAt(i);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f2966a == null && b == null) ? false : true;
    }

    private static boolean a(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (!fragmentTransitionImpl.canHandle(list.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static ArrayMap<String, View> b(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.a(arrayMap2, fragment.requireView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.r;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.q;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (exitTransitionCallback != null) {
            exitTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            int size = arrayList.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                String str = arrayList.get(i);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
                size = i;
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl b() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static Object b(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final View view, final ArrayMap<String, String> arrayMap, final FragmentContainerTransition fragmentContainerTransition, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Rect rect;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        Object a2 = arrayMap.isEmpty() ? null : a(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> b2 = b(fragmentTransitionImpl, arrayMap, a2, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            a2 = null;
        } else {
            arrayList.addAll(b2.values());
        }
        if (obj == null && obj2 == null && a2 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (a2 != null) {
            Rect rect2 = new Rect();
            fragmentTransitionImpl.setSharedElementTargets(a2, view, arrayList);
            a(fragmentTransitionImpl, a2, obj2, b2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            rect = rect2;
            if (obj != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect2);
                rect = rect2;
            }
        } else {
            rect = null;
        }
        final Object obj3 = a2;
        final Rect rect3 = rect;
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.6
            @Override // java.lang.Runnable
            public void run() {
                ArrayMap<String, View> a3 = FragmentTransition.a(FragmentTransitionImpl.this, arrayMap, obj3, fragmentContainerTransition);
                if (a3 != null) {
                    arrayList2.addAll(a3.values());
                    arrayList2.add(view);
                }
                FragmentTransition.a(fragment, fragment2, z, a3, false);
                Object obj4 = obj3;
                if (obj4 != null) {
                    FragmentTransitionImpl.this.swapSharedElementTargets(obj4, arrayList, arrayList2);
                    View a4 = FragmentTransition.a(a3, fragmentContainerTransition, obj, z);
                    if (a4 != null) {
                        FragmentTransitionImpl.this.a(a4, rect3);
                    }
                }
            }
        });
        return a2;
    }

    private static Object b(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static void b(ViewGroup viewGroup, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, final Callback callback) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        FragmentTransitionImpl a2 = a(fragment2, fragment);
        if (a2 == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object b3 = b(a2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, a3, b2);
        if (a3 == null && b3 == null && b2 == null) {
            return;
        }
        ArrayList<View> a4 = a(a2, b2, fragment2, arrayList, view);
        if (a4 == null || a4.isEmpty()) {
            b2 = null;
        }
        a2.addTarget(a3, view);
        Object a5 = a(a2, a3, b2, b3, fragment, fragmentContainerTransition.lastInIsPop);
        if (fragment2 != null && a4 != null && (a4.size() > 0 || arrayList.size() > 0)) {
            final CancellationSignal cancellationSignal = new CancellationSignal();
            callback.onStart(fragment2, cancellationSignal);
            a2.setListenerForTransitionEnd(fragment2, a5, cancellationSignal, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.3
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onComplete(fragment2, cancellationSignal);
                }
            });
        }
        if (a5 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.scheduleRemoveTargets(a5, a3, arrayList3, b2, a4, b3, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, b2, a4);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) arrayMap);
            a2.beginDelayedTransition(viewGroup, a5);
            a2.a(viewGroup, arrayList2, (Map<String, String>) arrayMap);
        }
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            a(backStackRecord, backStackRecord.d.get(i2), sparseArray, false, z);
            i = i2 + 1;
        }
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (!backStackRecord.f2852a.j().onHasView()) {
            return;
        }
        int size = backStackRecord.d.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            a(backStackRecord, backStackRecord.d.get(i), sparseArray, true, z);
            size = i;
        }
    }
}
