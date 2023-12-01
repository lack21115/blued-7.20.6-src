package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/Transition.class */
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
    private ArrayList<TransitionValues> mEndValuesList;
    private EpicenterCallback mEpicenterCallback;
    private ArrayMap<String, String> mNameOverrides;
    TransitionPropagation mPropagation;
    private ArrayList<TransitionValues> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() { // from class: androidx.transition.Transition.1
        @Override // androidx.transition.PathMotion
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<TransitionListener> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Transition$AnimationInfo.class */
    public static class AnimationInfo {

        /* renamed from: a  reason: collision with root package name */
        View f3471a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        TransitionValues f3472c;
        WindowIdImpl d;
        Transition e;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f3471a = view;
            this.b = str;
            this.f3472c = transitionValues;
            this.d = windowIdImpl;
            this.e = transition;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Transition$ArrayListManager.class */
    public static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            ArrayList<T> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
            }
            if (!arrayList2.contains(t)) {
                arrayList2.add(t);
            }
            return arrayList2;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
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

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Transition$EpicenterCallback.class */
    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(Transition transition);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Transition$MatchOrder.class */
    public @interface MatchOrder {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Transition$TransitionListener.class */
    public interface TransitionListener {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3468c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayMap.size()) {
                break;
            }
            TransitionValues valueAt = arrayMap.valueAt(i3);
            if (isValidTarget(valueAt.view)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add(null);
            }
            i2 = i3 + 1;
        }
        for (i = 0; i < arrayMap2.size(); i++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i);
            if (isValidTarget(valueAt2.view)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f3488a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.b.indexOfKey(id) >= 0) {
                transitionValuesMaps.b.put(id, null);
            } else {
                transitionValuesMaps.b.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.d.containsKey(transitionName)) {
                transitionValuesMaps.d.put(transitionName, null);
            } else {
                transitionValuesMaps.d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f3489c.indexOfKey(itemIdAtPosition) < 0) {
                    ViewCompat.setHasTransientState(view, true);
                    transitionValuesMaps.f3489c.put(itemIdAtPosition, view);
                    return;
                }
                View view2 = transitionValuesMaps.f3489c.get(itemIdAtPosition);
                if (view2 != null) {
                    ViewCompat.setHasTransientState(view2, false);
                    transitionValuesMaps.f3489c.put(itemIdAtPosition, null);
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
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return;
        }
        ArrayList<View> arrayList2 = this.mTargetExcludes;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
        if (arrayList3 != null) {
            int size = arrayList3.size();
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
            TransitionValues transitionValues = new TransitionValues(view);
            if (z) {
                captureStartValues(transitionValues);
            } else {
                captureEndValues(transitionValues);
            }
            transitionValues.f3487a.add(this);
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
        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
        if (arrayList4 != null && arrayList4.contains(Integer.valueOf(id))) {
            return;
        }
        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
        if (arrayList5 != null && arrayList5.contains(view)) {
            return;
        }
        ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
        if (arrayList6 != null) {
            int size2 = arrayList6.size();
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

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        ArrayList<Integer> arrayList2 = arrayList;
        if (i > 0) {
            if (z) {
                return ArrayListManager.a(arrayList, Integer.valueOf(i));
            }
            arrayList2 = ArrayListManager.b(arrayList, Integer.valueOf(i));
        }
        return arrayList2;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        ArrayList<T> arrayList2 = arrayList;
        if (t != null) {
            if (z) {
                return ArrayListManager.a(arrayList, t);
            }
            arrayList2 = ArrayListManager.b(arrayList, t);
        }
        return arrayList2;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        ArrayList<Class<?>> arrayList2 = arrayList;
        if (cls != null) {
            if (z) {
                return ArrayListManager.a(arrayList, cls);
            }
            arrayList2 = ArrayListManager.b(arrayList, cls);
        }
        return arrayList2;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        ArrayList<View> arrayList2 = arrayList;
        if (view != null) {
            if (z) {
                return ArrayListManager.a(arrayList, view);
            }
            arrayList2 = ArrayListManager.b(arrayList, view);
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
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        boolean z = true;
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj != null) {
            if (obj2 == null) {
                return true;
            }
            z = true ^ obj.equals(obj2);
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
        TransitionValues remove;
        int size = arrayMap.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            View keyAt = arrayMap.keyAt(i);
            if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.view)) {
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
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i2))) != null && isValidTarget(view)) {
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
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.f3488a);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.f3488a);
        int i = 0;
        while (true) {
            int i2 = i;
            int[] iArr = this.mMatchOrder;
            if (i2 >= iArr.length) {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
            int i3 = iArr[i2];
            if (i3 == 1) {
                matchInstances(arrayMap, arrayMap2);
            } else if (i3 == 2) {
                matchNames(arrayMap, arrayMap2, transitionValuesMaps.d, transitionValuesMaps2.d);
            } else if (i3 == 3) {
                matchIds(arrayMap, arrayMap2, transitionValuesMaps.b, transitionValuesMaps2.b);
            } else if (i3 == 4) {
                matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.f3489c, transitionValuesMaps2.f3489c);
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
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (!trim.isEmpty()) {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            } else {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            }
            i = i2 + 1;
        }
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
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
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
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
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
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
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size2) {
                return;
            }
            ((TransitionListener) arrayList2.get(i3)).onTransitionCancel(this);
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
            if (i2 >= propagationProperties.length) {
                z = true;
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
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        int i;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mTargetIds.size()) {
                    break;
                }
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i3).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.f3487a.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
                i2 = i3 + 1;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.mTargets.size()) {
                    break;
                }
                View view = this.mTargets.get(i5);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.f3487a.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
                i4 = i5 + 1;
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (z || (arrayMap = this.mNameOverrides) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= size) {
                break;
            }
            arrayList3.add(this.mStartValues.d.remove(this.mNameOverrides.keyAt(i7)));
            i6 = i7 + 1;
        }
        for (i = 0; i < size; i++) {
            View view2 = (View) arrayList3.get(i);
            if (view2 != null) {
                this.mStartValues.d.put(this.mNameOverrides.valueAt(i), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f3488a.clear();
            this.mStartValues.b.clear();
            this.mStartValues.f3489c.clear();
            return;
        }
        this.mEndValues.f3488a.clear();
        this.mEndValues.b.clear();
        this.mEndValues.f3489c.clear();
    }

    @Override // 
    /* renamed from: clone */
    public Transition mo1622clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        View view;
        Animator animator;
        TransitionValues transitionValues;
        long j;
        int i;
        TransitionValues transitionValues2;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            TransitionValues transitionValues3 = arrayList.get(i2);
            TransitionValues transitionValues4 = arrayList2.get(i2);
            TransitionValues transitionValues5 = transitionValues3;
            if (transitionValues3 != null) {
                transitionValues5 = transitionValues3;
                if (!transitionValues3.f3487a.contains(this)) {
                    transitionValues5 = null;
                }
            }
            TransitionValues transitionValues6 = transitionValues4;
            if (transitionValues4 != null) {
                transitionValues6 = transitionValues4;
                if (!transitionValues4.f3487a.contains(this)) {
                    transitionValues6 = null;
                }
            }
            if (transitionValues5 != null || transitionValues6 != null) {
                if (transitionValues5 == null || transitionValues6 == null || isTransitionRequired(transitionValues5, transitionValues6)) {
                    Animator createAnimator = createAnimator(viewGroup, transitionValues5, transitionValues6);
                    if (createAnimator != null) {
                        if (transitionValues6 != null) {
                            View view2 = transitionValues6.view;
                            String[] transitionProperties = getTransitionProperties();
                            if (transitionProperties != null && transitionProperties.length > 0) {
                                TransitionValues transitionValues7 = new TransitionValues(view2);
                                TransitionValues transitionValues8 = transitionValuesMaps2.f3488a.get(view2);
                                int i3 = i2;
                                if (transitionValues8 != null) {
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        i3 = i2;
                                        if (i5 >= transitionProperties.length) {
                                            break;
                                        }
                                        transitionValues7.values.put(transitionProperties[i5], transitionValues8.values.get(transitionProperties[i5]));
                                        i4 = i5 + 1;
                                    }
                                }
                                i2 = i3;
                                int size2 = runningAnimators.size();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= size2) {
                                        transitionValues2 = transitionValues7;
                                        break;
                                    }
                                    AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i7));
                                    if (animationInfo.f3472c != null && animationInfo.f3471a == view2 && animationInfo.b.equals(getName()) && animationInfo.f3472c.equals(transitionValues7)) {
                                        createAnimator = null;
                                        transitionValues2 = transitionValues7;
                                        break;
                                    }
                                    i6 = i7 + 1;
                                }
                            } else {
                                transitionValues2 = null;
                            }
                            Animator animator2 = createAnimator;
                            transitionValues = transitionValues2;
                            animator = animator2;
                            view = view2;
                        } else {
                            view = transitionValues5.view;
                            animator = createAnimator;
                            transitionValues = null;
                        }
                        j = j2;
                        i = i2;
                        if (animator != null) {
                            TransitionPropagation transitionPropagation = this.mPropagation;
                            j = j2;
                            if (transitionPropagation != null) {
                                long startDelay = transitionPropagation.getStartDelay(viewGroup, this, transitionValues5, transitionValues6);
                                sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                                j = Math.min(startDelay, j2);
                            }
                            runningAnimators.put(animator, new AnimationInfo(view, getName(), this, ViewUtils.b(viewGroup), transitionValues));
                            this.mAnimators.add(animator);
                            i = i2;
                        }
                        i2 = i + 1;
                        j2 = j;
                    }
                }
            }
            j = j2;
            i = i2;
            i2 = i + 1;
            j2 = j;
        }
        if (sparseIntArray.size() == 0) {
            return;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= sparseIntArray.size()) {
                return;
            }
            Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i9));
            animator3.setStartDelay((sparseIntArray.valueAt(i9) - j2) + animator3.getStartDelay());
            i8 = i9 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i != 0) {
            return;
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                ((TransitionListener) arrayList2.get(i3)).onTransitionEnd(this);
                i2 = i3 + 1;
            }
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.mStartValues.f3489c.size()) {
                break;
            }
            View valueAt = this.mStartValues.f3489c.valueAt(i5);
            if (valueAt != null) {
                ViewCompat.setHasTransientState(valueAt, false);
            }
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.mEndValues.f3489c.size()) {
                this.mEnded = true;
                return;
            }
            View valueAt2 = this.mEndValues.f3489c.valueAt(i7);
            if (valueAt2 != null) {
                ViewCompat.setHasTransientState(valueAt2, false);
            }
            i6 = i7 + 1;
        }
    }

    public Transition excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        WindowIdImpl b = ViewUtils.b(viewGroup);
        ArrayMap arrayMap = new ArrayMap(runningAnimators);
        runningAnimators.clear();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            AnimationInfo animationInfo = (AnimationInfo) arrayMap.valueAt(size);
            if (animationInfo.f3471a != null && b != null && b.equals(animationInfo.d)) {
                ((Animator) arrayMap.keyAt(size)).end();
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
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
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
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
            TransitionValues transitionValues = arrayList.get(i3);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                i = i3;
                break;
            }
            i2 = i3 + 1;
        }
        TransitionValues transitionValues2 = null;
        if (i >= 0) {
            transitionValues2 = (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return transitionValues2;
    }

    public String getName() {
        return this.mName;
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

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f3488a.get(view);
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z = false;
        if (transitionValues != null) {
            z = false;
            if (transitionValues2 != null) {
                String[] transitionProperties = getTransitionProperties();
                if (transitionProperties != null) {
                    int length = transitionProperties.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        z = false;
                        if (i2 >= length) {
                            break;
                        } else if (isValueChanged(transitionValues, transitionValues2, transitionProperties[i2])) {
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                } else {
                    Iterator<String> it = transitionValues.values.keySet().iterator();
                    do {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        }
                    } while (!isValueChanged(transitionValues, transitionValues2, it.next()));
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
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
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
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
        WindowIdImpl b = ViewUtils.b(view);
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            AnimationInfo valueAt = runningAnimators.valueAt(size);
            if (valueAt.f3471a != null && b.equals(valueAt.d)) {
                AnimatorUtils.a(runningAnimators.keyAt(size));
            }
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size2) {
                    break;
                }
                ((TransitionListener) arrayList2.get(i2)).onTransitionPause(this);
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
        WindowIdImpl b = ViewUtils.b(viewGroup);
        while (true) {
            size--;
            if (size < 0) {
                createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
                runAnimators();
                return;
            }
            Animator keyAt = runningAnimators.keyAt(size);
            if (keyAt != null && (animationInfo = runningAnimators.get(keyAt)) != null && animationInfo.f3471a != null && b.equals(animationInfo.d)) {
                TransitionValues transitionValues = animationInfo.f3472c;
                View view = animationInfo.f3471a;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                TransitionValues transitionValues3 = matchedTransitionValues;
                if (transitionValues2 == null) {
                    transitionValues3 = matchedTransitionValues;
                    if (matchedTransitionValues == null) {
                        transitionValues3 = this.mEndValues.f3488a.get(view);
                    }
                }
                if (!(transitionValues2 == null && transitionValues3 == null) && animationInfo.e.isTransitionRequired(transitionValues, transitionValues3)) {
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
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdImpl b = ViewUtils.b(view);
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    AnimationInfo valueAt = runningAnimators.valueAt(size);
                    if (valueAt.f3471a != null && b.equals(valueAt.d)) {
                        AnimatorUtils.b(runningAnimators.keyAt(size));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size2) {
                            break;
                        }
                        ((TransitionListener) arrayList2.get(i2)).onTransitionResume(this);
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
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    ((TransitionListener) arrayList2.get(i2)).onTransitionStart(this);
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
    /* JADX WARN: Code restructure failed: missing block: B:14:0x010a, code lost:
        if (r5.mTargets.size() > 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.toString(java.lang.String):java.lang.String");
    }
}
