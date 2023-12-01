package com.android.internal.widget.multiwaveview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Tweener.class */
class Tweener {
    private static final boolean DEBUG = false;
    private static final String TAG = "Tweener";
    ObjectAnimator animator;
    private static HashMap<Object, Tweener> sTweens = new HashMap<>();
    private static Animator.AnimatorListener mCleanupListener = new AnimatorListenerAdapter() { // from class: com.android.internal.widget.multiwaveview.Tweener.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Tweener.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Tweener.remove(animator);
        }
    };

    public Tweener(ObjectAnimator objectAnimator) {
        this.animator = objectAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void remove(Animator animator) {
        Iterator<Map.Entry<Object, Tweener>> it = sTweens.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().animator == animator) {
                it.remove();
                return;
            }
        }
    }

    private static void replace(ArrayList<PropertyValuesHolder> arrayList, Object... objArr) {
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Tweener tweener = sTweens.get(objArr[i2]);
            if (tweener != null) {
                tweener.animator.cancel();
                if (arrayList != null) {
                    tweener.animator.setValues((PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
                } else {
                    sTweens.remove(tweener);
                }
            }
            i = i2 + 1;
        }
    }

    public static void reset() {
        sTweens.clear();
    }

    public static Tweener to(Object obj, long j, Object... objArr) {
        ObjectAnimator objectAnimator;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        long j2;
        TimeInterpolator timeInterpolator;
        Animator.AnimatorListener animatorListener;
        long j3 = 0;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = null;
        Animator.AnimatorListener animatorListener2 = null;
        TimeInterpolator timeInterpolator2 = null;
        ArrayList arrayList = new ArrayList(objArr.length / 2);
        int i = 0;
        while (i < objArr.length) {
            if (!(objArr[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be a string: " + objArr[i]);
            }
            String str = (String) objArr[i];
            Object obj2 = objArr[i + 1];
            if ("simultaneousTween".equals(str)) {
                animatorUpdateListener = animatorUpdateListener2;
                animatorListener = animatorListener2;
                timeInterpolator = timeInterpolator2;
                j2 = j3;
            } else if ("ease".equals(str)) {
                timeInterpolator = (TimeInterpolator) obj2;
                j2 = j3;
                animatorListener = animatorListener2;
                animatorUpdateListener = animatorUpdateListener2;
            } else if ("onUpdate".equals(str) || "onUpdateListener".equals(str)) {
                animatorUpdateListener = (ValueAnimator.AnimatorUpdateListener) obj2;
                j2 = j3;
                timeInterpolator = timeInterpolator2;
                animatorListener = animatorListener2;
            } else if ("onComplete".equals(str) || "onCompleteListener".equals(str)) {
                animatorListener = (Animator.AnimatorListener) obj2;
                j2 = j3;
                timeInterpolator = timeInterpolator2;
                animatorUpdateListener = animatorUpdateListener2;
            } else if ("delay".equals(str)) {
                j2 = ((Number) obj2).longValue();
                timeInterpolator = timeInterpolator2;
                animatorListener = animatorListener2;
                animatorUpdateListener = animatorUpdateListener2;
            } else {
                j2 = j3;
                timeInterpolator = timeInterpolator2;
                animatorListener = animatorListener2;
                animatorUpdateListener = animatorUpdateListener2;
                if ("syncWith".equals(str)) {
                    continue;
                } else if (obj2 instanceof float[]) {
                    arrayList.add(PropertyValuesHolder.ofFloat(str, ((float[]) obj2)[0], ((float[]) obj2)[1]));
                    j2 = j3;
                    timeInterpolator = timeInterpolator2;
                    animatorListener = animatorListener2;
                    animatorUpdateListener = animatorUpdateListener2;
                } else if (obj2 instanceof int[]) {
                    arrayList.add(PropertyValuesHolder.ofInt(str, ((int[]) obj2)[0], ((int[]) obj2)[1]));
                    j2 = j3;
                    timeInterpolator = timeInterpolator2;
                    animatorListener = animatorListener2;
                    animatorUpdateListener = animatorUpdateListener2;
                } else if (!(obj2 instanceof Number)) {
                    throw new IllegalArgumentException("Bad argument for key \"" + str + "\" with value " + obj2.getClass());
                } else {
                    arrayList.add(PropertyValuesHolder.ofFloat(str, ((Number) obj2).floatValue()));
                    j2 = j3;
                    timeInterpolator = timeInterpolator2;
                    animatorListener = animatorListener2;
                    animatorUpdateListener = animatorUpdateListener2;
                }
            }
            i += 2;
            j3 = j2;
            timeInterpolator2 = timeInterpolator;
            animatorListener2 = animatorListener;
            animatorUpdateListener2 = animatorUpdateListener;
        }
        Tweener tweener = sTweens.get(obj);
        if (tweener == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
            tweener = new Tweener(ofPropertyValuesHolder);
            sTweens.put(obj, tweener);
            objectAnimator = ofPropertyValuesHolder;
        } else {
            ObjectAnimator objectAnimator2 = sTweens.get(obj).animator;
            replace(arrayList, obj);
            objectAnimator = objectAnimator2;
        }
        if (timeInterpolator2 != null) {
            objectAnimator.setInterpolator(timeInterpolator2);
        }
        objectAnimator.setStartDelay(j3);
        objectAnimator.setDuration(j);
        if (animatorUpdateListener2 != null) {
            objectAnimator.removeAllUpdateListeners();
            objectAnimator.addUpdateListener(animatorUpdateListener2);
        }
        if (animatorListener2 != null) {
            objectAnimator.removeAllListeners();
            objectAnimator.addListener(animatorListener2);
        }
        objectAnimator.addListener(mCleanupListener);
        return tweener;
    }

    Tweener from(Object obj, long j, Object... objArr) {
        return to(obj, j, objArr);
    }
}
