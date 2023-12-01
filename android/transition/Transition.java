package android.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: source-9557208-dex2jar.jar:android/transition/Transition.class */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final String MATCH_VIEW_NAME_STR = "viewName";
    ArrayList<TransitionValues> mEndValuesList;
    EpicenterCallback mEpicenterCallback;
    ArrayMap<String, String> mNameOverrides;
    TransitionPropagation mPropagation;
    ArrayList<TransitionValues> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() { // from class: android.transition.Transition.1
        @Override // android.transition.PathMotion
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    long mStartDelay = -1;
    long mDuration = -1;
    TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    ArrayList<String> mTargetNames = null;
    ArrayList<Class> mTargetTypes = null;
    ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<View> mTargetExcludes = null;
    ArrayList<Class> mTargetTypeExcludes = null;
    ArrayList<String> mTargetNameExcludes = null;
    ArrayList<Integer> mTargetIdChildExcludes = null;
    ArrayList<View> mTargetChildExcludes = null;
    ArrayList<Class> mTargetTypeChildExcludes = null;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    private ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    int mNumInstances = 0;
    boolean mPaused = false;
    private boolean mEnded = false;
    ArrayList<TransitionListener> mListeners = null;
    ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* loaded from: source-9557208-dex2jar.jar:android/transition/Transition$AnimationInfo.class */
    public static class AnimationInfo {
        String name;
        Transition transition;
        TransitionValues values;
        public View view;
        WindowId windowId;

        AnimationInfo(View view, String str, Transition transition, WindowId windowId, TransitionValues transitionValues) {
            this.view = view;
            this.name = str;
            this.values = transitionValues;
            this.windowId = windowId;
            this.transition = transition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/transition/Transition$ArrayListManager.class */
    public static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            ArrayList<T> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
            }
            if (!arrayList2.contains(t)) {
                arrayList2.add(t);
            }
            return arrayList2;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            ArrayList<T> arrayList2 = arrayList;
            if (arrayList != null) {
                arrayList.remove(t);
                arrayList2 = arrayList;
                if (arrayList.isEmpty()) {
                    arrayList2 = null;
                }
            }
            return arrayList2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/transition/Transition$EpicenterCallback.class */
    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(Transition transition);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/transition/Transition$TransitionListener.class */
    public interface TransitionListener {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/transition/Transition$TransitionListenerAdapter.class */
    public static class TransitionListenerAdapter implements TransitionListener {
        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
        long j = obtainStyledAttributes.getInt(1, -1);
        if (j >= 0) {
            setDuration(j);
        }
        long j2 = obtainStyledAttributes.getInt(2, -1);
        if (j2 > 0) {
            setStartDelay(j2);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        String string = obtainStyledAttributes.getString(3);
        if (string != null) {
            setMatchOrder(parseMatchOrder(string));
        }
        obtainStyledAttributes.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayMap.size()) {
                break;
            }
            this.mStartValuesList.add(arrayMap.valueAt(i2));
            this.mEndValuesList.add(null);
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayMap2.size()) {
                return;
            }
            this.mEndValuesList.add(arrayMap2.valueAt(i4));
            this.mStartValuesList.add(null);
            i3 = i4 + 1;
        }
    }

    static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.viewValues.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.idValues.indexOfKey(id) >= 0) {
                transitionValuesMaps.idValues.put(id, null);
            } else {
                transitionValuesMaps.idValues.put(id, view);
            }
        }
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            if (transitionValuesMaps.nameValues.containsKey(transitionName)) {
                transitionValuesMaps.nameValues.put(transitionName, null);
            } else {
                transitionValuesMaps.nameValues.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.itemIdValues.indexOfKey(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    transitionValuesMaps.itemIdValues.put(itemIdAtPosition, view);
                    return;
                }
                View view2 = transitionValuesMaps.itemIdValues.get(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    transitionValuesMaps.itemIdValues.put(itemIdAtPosition, null);
                }
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return false;
            }
            if (iArr[i4] == i2) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
            return;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return;
        }
        if (this.mTargetTypeExcludes != null && view != null) {
            int size = this.mTargetTypeExcludes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                } else if (this.mTargetTypeExcludes.get(i2).isInstance(view)) {
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            TransitionValues transitionValues = new TransitionValues();
            transitionValues.view = view;
            if (z) {
                captureStartValues(transitionValues);
            } else {
                captureEndValues(transitionValues);
            }
            transitionValues.targetedTransitions.add(this);
            capturePropagationValues(transitionValues);
            if (z) {
                addViewValues(this.mStartValues, view, transitionValues);
            } else {
                addViewValues(this.mEndValues, view, transitionValues);
            }
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        if (this.mTargetIdChildExcludes != null && this.mTargetIdChildExcludes.contains(Integer.valueOf(id))) {
            return;
        }
        if (this.mTargetChildExcludes != null && this.mTargetChildExcludes.contains(view)) {
            return;
        }
        if (this.mTargetTypeChildExcludes != null) {
            int size2 = this.mTargetTypeChildExcludes.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                } else if (this.mTargetTypeChildExcludes.get(i4).isInstance(view)) {
                    return;
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= viewGroup.getChildCount()) {
                return;
            }
            captureHierarchy(viewGroup.getChildAt(i6), z);
            i5 = i6 + 1;
        }
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        ArrayList<T> arrayList2 = arrayList;
        if (t != null) {
            if (!z) {
                return ArrayListManager.remove(arrayList, t);
            }
            arrayList2 = ArrayListManager.add(arrayList, t);
        }
        return arrayList2;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        ArrayMap<Animator, AnimationInfo> arrayMap2 = arrayMap;
        if (arrayMap == null) {
            arrayMap2 = new ArrayMap<>();
            sRunningAnimators.set(arrayMap2);
        }
        return arrayMap2;
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        boolean z = false;
        if (transitionValues.values.containsKey(str) != transitionValues2.values.containsKey(str)) {
            return false;
        }
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        if (!obj.equals(obj2)) {
            z = true;
        }
        return z;
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
            i = i2 + 1;
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        int size = arrayMap.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            TransitionValues remove = arrayMap2.remove(arrayMap.keyAt(i));
            if (remove != null) {
                this.mStartValuesList.add(arrayMap.removeAt(i));
                this.mEndValuesList.add(remove);
            }
            size = i;
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View valueAt = longSparseArray.valueAt(i2);
            if (valueAt != null && (view = longSparseArray2.get(longSparseArray.keyAt(i2))) != null) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
            i = i2 + 1;
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View valueAt = arrayMap3.valueAt(i2);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i2))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
            i = i2 + 1;
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.viewValues);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.viewValues);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mMatchOrder.length) {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
            switch (this.mMatchOrder[i2]) {
                case 1:
                    matchInstances(arrayMap, arrayMap2);
                    break;
                case 2:
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.nameValues, transitionValuesMaps2.nameValues);
                    break;
                case 3:
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.idValues, transitionValuesMaps2.idValues);
                    break;
                case 4:
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.itemIdValues, transitionValuesMaps2.itemIdValues);
                    break;
            }
            i = i2 + 1;
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (!stringTokenizer.hasMoreTokens()) {
                return iArr;
            }
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if (MATCH_VIEW_NAME_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (!trim.isEmpty()) {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            } else {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                iArr = iArr2;
                i2--;
            }
            i = i2 + 1;
        }
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.mCurrentAnimators.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.mCurrentAnimators.add(animator2);
                }
            });
            animate(animator);
        }
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition addTarget(int i) {
        if (i > 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(Class cls) {
        if (cls != null) {
            if (this.mTargetTypes == null) {
                this.mTargetTypes = new ArrayList<>();
            }
            this.mTargetTypes.add(cls);
        }
        return this;
    }

    public Transition addTarget(String str) {
        if (str != null) {
            if (this.mTargetNames == null) {
                this.mTargetNames = new ArrayList<>();
            }
            this.mTargetNames.add(str);
        }
        return this;
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    boolean areValuesChanged(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z = false;
        if (transitionValues != null) {
            z = false;
            if (transitionValues2 != null) {
                String[] transitionProperties = getTransitionProperties();
                if (transitionProperties == null) {
                    Iterator<String> it = transitionValues.values.keySet().iterator();
                    do {
                        z = false;
                        if (it.hasNext()) {
                        }
                    } while (!isValueChanged(transitionValues, transitionValues2, it.next()));
                    return true;
                }
                int length = transitionProperties.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 >= length) {
                        break;
                    } else if (isValueChanged(transitionValues, transitionValues2, transitionProperties[i2])) {
                        z = true;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }
        return z;
    }

    public boolean canRemoveViews() {
        return this.mCanRemoveViews;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        int size = this.mCurrentAnimators.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            this.mCurrentAnimators.get(i).cancel();
            size = i;
        }
        if (this.mListeners == null || this.mListeners.size() <= 0) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.mListeners.clone();
        int size2 = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size2) {
                return;
            }
            ((TransitionListener) arrayList.get(i3)).onTransitionCancel(this);
            i2 = i3 + 1;
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        boolean z;
        if (this.mPropagation == null || transitionValues.values.isEmpty() || (propagationProperties = this.mPropagation.getPropagationProperties()) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            z = true;
            if (i2 >= propagationProperties.length) {
                break;
            } else if (!transitionValues.values.containsKey(propagationProperties[i2])) {
                z = false;
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.captureValues(transitionValues);
    }

    public abstract void captureStartValues(TransitionValues transitionValues);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && ((this.mTargetNames == null || this.mTargetNames.isEmpty()) && (this.mTargetTypes == null || this.mTargetTypes.isEmpty()))) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mTargetIds.size()) {
                    break;
                }
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i2).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = findViewById;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.targetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mTargets.size()) {
                    break;
                }
                View view = this.mTargets.get(i4);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.view = view;
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.targetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
                i3 = i4 + 1;
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (z || this.mNameOverrides == null) {
            return;
        }
        int size = this.mNameOverrides.size();
        ArrayList arrayList = new ArrayList(size);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                break;
            }
            arrayList.add(this.mStartValues.nameValues.remove(this.mNameOverrides.keyAt(i6)));
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= size) {
                return;
            }
            View view2 = (View) arrayList.get(i8);
            if (view2 != null) {
                this.mStartValues.nameValues.put(this.mNameOverrides.valueAt(i8), view2);
            }
            i7 = i8 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.viewValues.clear();
            this.mStartValues.idValues.clear();
            this.mStartValues.itemIdValues.clear();
            this.mStartValues.nameValues.clear();
            this.mStartValuesList = null;
            return;
        }
        this.mEndValues.viewValues.clear();
        this.mEndValues.idValues.clear();
        this.mEndValues.itemIdValues.clear();
        this.mEndValues.nameValues.clear();
        this.mEndValuesList = null;
    }

    @Override // 
    /* renamed from: clone */
    public Transition mo996clone() {
        Transition transition = null;
        try {
            Transition transition2 = (Transition) super.clone();
            transition2.mAnimators = new ArrayList<>();
            transition2.mStartValues = new TransitionValuesMaps();
            transition2.mEndValues = new TransitionValuesMaps();
            transition2.mStartValuesList = null;
            transition = transition2;
            transition2.mEndValuesList = null;
            return transition2;
        } catch (CloneNotSupportedException e) {
            return transition;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long j;
        View view;
        TransitionValues transitionValues;
        Animator animator;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        long j2 = Long.MAX_VALUE;
        this.mAnimators.size();
        SparseLongArray sparseLongArray = new SparseLongArray();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            TransitionValues transitionValues2 = arrayList.get(i);
            TransitionValues transitionValues3 = arrayList2.get(i);
            TransitionValues transitionValues4 = transitionValues2;
            if (transitionValues2 != null) {
                transitionValues4 = transitionValues2;
                if (!transitionValues2.targetedTransitions.contains(this)) {
                    transitionValues4 = null;
                }
            }
            TransitionValues transitionValues5 = transitionValues3;
            if (transitionValues3 != null) {
                transitionValues5 = transitionValues3;
                if (!transitionValues3.targetedTransitions.contains(this)) {
                    transitionValues5 = null;
                }
            }
            if (transitionValues4 == null && transitionValues5 == null) {
                j = j2;
            } else {
                j = j2;
                if (transitionValues4 == null || transitionValues5 == null || areValuesChanged(transitionValues4, transitionValues5)) {
                    Animator createAnimator = createAnimator(viewGroup, transitionValues4, transitionValues5);
                    j = j2;
                    if (createAnimator != null) {
                        if (transitionValues5 != null) {
                            View view2 = transitionValues5.view;
                            String[] transitionProperties = getTransitionProperties();
                            view = view2;
                            transitionValues = null;
                            animator = createAnimator;
                            if (view2 != null) {
                                view = view2;
                                transitionValues = null;
                                animator = createAnimator;
                                if (transitionProperties != null) {
                                    view = view2;
                                    transitionValues = null;
                                    animator = createAnimator;
                                    if (transitionProperties.length > 0) {
                                        TransitionValues transitionValues6 = new TransitionValues();
                                        transitionValues6.view = view2;
                                        TransitionValues transitionValues7 = transitionValuesMaps2.viewValues.get(view2);
                                        if (transitionValues7 != null) {
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = i2;
                                                if (i3 >= transitionProperties.length) {
                                                    break;
                                                }
                                                transitionValues6.values.put(transitionProperties[i3], transitionValues7.values.get(transitionProperties[i3]));
                                                i2 = i3 + 1;
                                            }
                                        }
                                        int size2 = runningAnimators.size();
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            view = view2;
                                            transitionValues = transitionValues6;
                                            animator = createAnimator;
                                            if (i5 >= size2) {
                                                break;
                                            }
                                            AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i5));
                                            if (animationInfo.values != null && animationInfo.view == view2 && (((animationInfo.name == null && getName() == null) || animationInfo.name.equals(getName())) && animationInfo.values.equals(transitionValues6))) {
                                                animator = null;
                                                transitionValues = transitionValues6;
                                                view = view2;
                                                break;
                                            }
                                            i4 = i5 + 1;
                                        }
                                    }
                                }
                            }
                        } else {
                            view = transitionValues4 != null ? transitionValues4.view : null;
                            transitionValues = null;
                            animator = createAnimator;
                        }
                        j = j2;
                        if (animator != null) {
                            j = j2;
                            if (this.mPropagation != null) {
                                long startDelay = this.mPropagation.getStartDelay(viewGroup, this, transitionValues4, transitionValues5);
                                sparseLongArray.put(this.mAnimators.size(), startDelay);
                                j = Math.min(startDelay, j2);
                            }
                            runningAnimators.put(animator, new AnimationInfo(view, getName(), this, viewGroup.getWindowId(), transitionValues));
                            this.mAnimators.add(animator);
                        }
                    }
                }
            }
            i++;
            j2 = j;
        }
        if (j2 == 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= sparseLongArray.size()) {
                return;
            }
            Animator animator2 = this.mAnimators.get(sparseLongArray.keyAt(i7));
            animator2.setStartDelay((sparseLongArray.valueAt(i7) - j2) + animator2.getStartDelay());
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances != 0) {
            return;
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ((TransitionListener) arrayList.get(i2)).onTransitionEnd(this);
                i = i2 + 1;
            }
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mStartValues.itemIdValues.size()) {
                break;
            }
            View valueAt = this.mStartValues.itemIdValues.valueAt(i4);
            if (valueAt != null) {
                valueAt.setHasTransientState(false);
            }
            i3 = i4 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.mEndValues.itemIdValues.size()) {
                this.mEnded = true;
                return;
            }
            View valueAt2 = this.mEndValues.itemIdValues.valueAt(i6);
            if (valueAt2 != null) {
                valueAt2.setHasTransientState(false);
            }
            i5 = i6 + 1;
        }
    }

    public Transition excludeChildren(int i, boolean z) {
        if (i >= 0) {
            this.mTargetIdChildExcludes = excludeObject(this.mTargetIdChildExcludes, Integer.valueOf(i), z);
        }
        return this;
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeObject(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeObject(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        if (i >= 0) {
            this.mTargetIdExcludes = excludeObject(this.mTargetIdExcludes, Integer.valueOf(i), z);
        }
        return this;
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeObject(this.mTargetExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeObject(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public void forceVisibility(int i, boolean z) {
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        if (this.mEpicenterCallback == null) {
            return null;
        }
        return this.mEpicenterCallback.onGetEpicenter(this);
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionValues getMatchedTransitionValues(View view, boolean z) {
        int i;
        TransitionValues transitionValues;
        if (this.mParent != null) {
            transitionValues = this.mParent.getMatchedTransitionValues(view, z);
        } else {
            ArrayList<TransitionValues> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = -1;
                if (i3 >= size) {
                    break;
                }
                TransitionValues transitionValues2 = arrayList.get(i3);
                if (transitionValues2 == null) {
                    return null;
                }
                if (transitionValues2.view == view) {
                    i = i3;
                    break;
                }
                i2 = i3 + 1;
            }
            transitionValues = null;
            if (i >= 0) {
                return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
            }
        }
        return transitionValues;
    }

    public String getName() {
        return this.mName;
    }

    public ArrayMap<String, String> getNameOverrides() {
        return this.mNameOverrides;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<String> getTargetViewNames() {
        return this.mTargetNames;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).viewValues.get(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        int id = view.getId();
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return false;
        }
        if (this.mTargetTypeExcludes != null && view != null) {
            int size = this.mTargetTypeExcludes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                } else if (this.mTargetTypeExcludes.get(i2).isInstance(view)) {
                    return false;
                } else {
                    i = i2 + 1;
                }
            }
        }
        if (this.mTargetNameExcludes != null && view != null && view.getTransitionName() != null && this.mTargetNameExcludes.contains(view.getTransitionName())) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && ((this.mTargetTypes == null || this.mTargetTypes.isEmpty()) && (this.mTargetNames == null || this.mTargetNames.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        if (this.mTargetNames != null && this.mTargetNames.contains(view.getTransitionName())) {
            return true;
        }
        if (this.mTargetTypes == null) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mTargetTypes.size()) {
                return false;
            }
            if (this.mTargetTypes.get(i4).isInstance(view)) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (view != null) {
            WindowId windowId = view.getWindowId();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                AnimationInfo valueAt = runningAnimators.valueAt(size);
                if (valueAt.view != null && windowId != null && windowId.equals(valueAt.windowId)) {
                    runningAnimators.keyAt(size).pause();
                }
            }
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size2) {
                    break;
                }
                ((TransitionListener) arrayList.get(i2)).onTransitionPause(this);
                i = i2 + 1;
            }
        }
        this.mPaused = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowId windowId = viewGroup.getWindowId();
        while (true) {
            size--;
            if (size < 0) {
                createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
                runAnimators();
                return;
            }
            Animator keyAt = runningAnimators.keyAt(size);
            if (keyAt != null && (animationInfo = runningAnimators.get(keyAt)) != null && animationInfo.view != null && animationInfo.windowId == windowId) {
                TransitionValues transitionValues = animationInfo.values;
                View view = animationInfo.view;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.transition.areValuesChanged(transitionValues, matchedTransitionValues)) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        runningAnimators.remove(keyAt);
                    }
                }
            }
        }
    }

    public Transition removeListener(TransitionListener transitionListener) {
        if (this.mListeners != null) {
            this.mListeners.remove(transitionListener);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
                return this;
            }
        }
        return this;
    }

    public Transition removeTarget(int i) {
        if (i > 0) {
            this.mTargetIds.remove(i);
        }
        return this;
    }

    public Transition removeTarget(View view) {
        if (view != null) {
            this.mTargets.remove(view);
        }
        return this;
    }

    public Transition removeTarget(Class cls) {
        if (cls != null) {
            this.mTargetTypes.remove(cls);
        }
        return this;
    }

    public Transition removeTarget(String str) {
        if (str != null && this.mTargetNames != null) {
            this.mTargetNames.remove(str);
        }
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowId windowId = view.getWindowId();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    AnimationInfo valueAt = runningAnimators.valueAt(size);
                    if (valueAt.view != null && windowId != null && windowId.equals(valueAt.windowId)) {
                        runningAnimators.keyAt(size).resume();
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size2) {
                            break;
                        }
                        ((TransitionListener) arrayList.get(i2)).onTransitionResume(this);
                        i = i2 + 1;
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                this.mMatchOrder = (int[]) iArr.clone();
                return;
            } else if (!isValidMatch(iArr[i2])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else {
                if (alreadyContains(iArr, i2)) {
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
                i = i2 + 1;
            }
        }
    }

    public void setNameOverrides(ArrayMap<String, String> arrayMap) {
        this.mNameOverrides = arrayMap;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    ((TransitionListener) arrayList.get(i2)).onTransitionStart(this);
                    i = i2 + 1;
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00cb, code lost:
        if (r5.mTargets.size() > 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.transition.Transition.toString(java.lang.String):java.lang.String");
    }
}
