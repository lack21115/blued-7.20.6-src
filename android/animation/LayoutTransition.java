package android.animation;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/animation/LayoutTransition.class */
public class LayoutTransition {
    public static final int APPEARING = 2;
    public static final int CHANGE_APPEARING = 0;
    public static final int CHANGE_DISAPPEARING = 1;
    public static final int CHANGING = 4;
    public static final int DISAPPEARING = 3;
    private static final int FLAG_APPEARING = 1;
    private static final int FLAG_CHANGE_APPEARING = 4;
    private static final int FLAG_CHANGE_DISAPPEARING = 8;
    private static final int FLAG_CHANGING = 16;
    private static final int FLAG_DISAPPEARING = 2;
    private static ObjectAnimator defaultChange;
    private static ObjectAnimator defaultChangeIn;
    private static ObjectAnimator defaultChangeOut;
    private static ObjectAnimator defaultFadeIn;
    private static ObjectAnimator defaultFadeOut;
    private Animator mAppearingAnim;
    private Animator mChangingAnim;
    private Animator mChangingAppearingAnim;
    private Animator mChangingDisappearingAnim;
    private Animator mDisappearingAnim;
    private ArrayList<TransitionListener> mListeners;
    private long staggerDelay;
    private static long DEFAULT_DURATION = 300;
    private static TimeInterpolator ACCEL_DECEL_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private static TimeInterpolator DECEL_INTERPOLATOR = new DecelerateInterpolator();
    private static TimeInterpolator sAppearingInterpolator = ACCEL_DECEL_INTERPOLATOR;
    private static TimeInterpolator sDisappearingInterpolator = ACCEL_DECEL_INTERPOLATOR;
    private static TimeInterpolator sChangingAppearingInterpolator = DECEL_INTERPOLATOR;
    private static TimeInterpolator sChangingDisappearingInterpolator = DECEL_INTERPOLATOR;
    private static TimeInterpolator sChangingInterpolator = DECEL_INTERPOLATOR;
    private long mChangingAppearingDuration = DEFAULT_DURATION;
    private long mChangingDisappearingDuration = DEFAULT_DURATION;
    private long mChangingDuration = DEFAULT_DURATION;
    private long mAppearingDuration = DEFAULT_DURATION;
    private long mDisappearingDuration = DEFAULT_DURATION;
    private long mAppearingDelay = DEFAULT_DURATION;
    private long mDisappearingDelay = 0;
    private long mChangingAppearingDelay = 0;
    private long mChangingDisappearingDelay = DEFAULT_DURATION;
    private long mChangingDelay = 0;
    private long mChangingAppearingStagger = 0;
    private long mChangingDisappearingStagger = 0;
    private long mChangingStagger = 0;
    private TimeInterpolator mAppearingInterpolator = sAppearingInterpolator;
    private TimeInterpolator mDisappearingInterpolator = sDisappearingInterpolator;
    private TimeInterpolator mChangingAppearingInterpolator = sChangingAppearingInterpolator;
    private TimeInterpolator mChangingDisappearingInterpolator = sChangingDisappearingInterpolator;
    private TimeInterpolator mChangingInterpolator = sChangingInterpolator;
    private final HashMap<View, Animator> pendingAnimations = new HashMap<>();
    private final LinkedHashMap<View, Animator> currentChangingAnimations = new LinkedHashMap<>();
    private final LinkedHashMap<View, Animator> currentAppearingAnimations = new LinkedHashMap<>();
    private final LinkedHashMap<View, Animator> currentDisappearingAnimations = new LinkedHashMap<>();
    private final HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap = new HashMap<>();
    private int mTransitionTypes = 15;
    private boolean mAnimateParentHierarchy = true;

    /* loaded from: source-9557208-dex2jar.jar:android/animation/LayoutTransition$TransitionListener.class */
    public interface TransitionListener {
        void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i);

        void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i);
    }

    public LayoutTransition() {
        this.mDisappearingAnim = null;
        this.mAppearingAnim = null;
        this.mChangingAppearingAnim = null;
        this.mChangingDisappearingAnim = null;
        this.mChangingAnim = null;
        if (defaultChangeIn == null) {
            defaultChangeIn = ObjectAnimator.ofPropertyValuesHolder(null, PropertyValuesHolder.ofInt("left", 0, 1), PropertyValuesHolder.ofInt(Constant.MAP_KEY_TOP, 0, 1), PropertyValuesHolder.ofInt("right", 0, 1), PropertyValuesHolder.ofInt("bottom", 0, 1), PropertyValuesHolder.ofInt("scrollX", 0, 1), PropertyValuesHolder.ofInt("scrollY", 0, 1));
            defaultChangeIn.setDuration(DEFAULT_DURATION);
            defaultChangeIn.setStartDelay(this.mChangingAppearingDelay);
            defaultChangeIn.setInterpolator(this.mChangingAppearingInterpolator);
            defaultChangeOut = defaultChangeIn.mo53clone();
            defaultChangeOut.setStartDelay(this.mChangingDisappearingDelay);
            defaultChangeOut.setInterpolator(this.mChangingDisappearingInterpolator);
            defaultChange = defaultChangeIn.mo53clone();
            defaultChange.setStartDelay(this.mChangingDelay);
            defaultChange.setInterpolator(this.mChangingInterpolator);
            defaultFadeIn = ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f, 1.0f);
            defaultFadeIn.setDuration(DEFAULT_DURATION);
            defaultFadeIn.setStartDelay(this.mAppearingDelay);
            defaultFadeIn.setInterpolator(this.mAppearingInterpolator);
            defaultFadeOut = ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f);
            defaultFadeOut.setDuration(DEFAULT_DURATION);
            defaultFadeOut.setStartDelay(this.mDisappearingDelay);
            defaultFadeOut.setInterpolator(this.mDisappearingInterpolator);
        }
        this.mChangingAppearingAnim = defaultChangeIn;
        this.mChangingDisappearingAnim = defaultChangeOut;
        this.mChangingAnim = defaultChange;
        this.mAppearingAnim = defaultFadeIn;
        this.mDisappearingAnim = defaultFadeOut;
    }

    static /* synthetic */ long access$314(LayoutTransition layoutTransition, long j) {
        long j2 = layoutTransition.staggerDelay + j;
        layoutTransition.staggerDelay = j2;
        return j2;
    }

    private void addChild(ViewGroup viewGroup, View view, boolean z) {
        if (viewGroup.getWindowVisibility() != 0) {
            return;
        }
        if ((this.mTransitionTypes & 1) == 1) {
            cancel(3);
        }
        if (z && (this.mTransitionTypes & 4) == 4) {
            cancel(0);
            cancel(4);
        }
        if (hasListeners() && (this.mTransitionTypes & 1) == 1) {
            Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
            while (it.hasNext()) {
                ((TransitionListener) it.next()).startTransition(this, viewGroup, view, 2);
            }
        }
        if (z && (this.mTransitionTypes & 4) == 4) {
            runChangeTransition(viewGroup, view, 2);
        }
        if ((this.mTransitionTypes & 1) == 1) {
            runAppearingTransition(viewGroup, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasListeners() {
        return this.mListeners != null && this.mListeners.size() > 0;
    }

    private void removeChild(ViewGroup viewGroup, View view, boolean z) {
        if (viewGroup.getWindowVisibility() != 0) {
            return;
        }
        if ((this.mTransitionTypes & 2) == 2) {
            cancel(2);
        }
        if (z && (this.mTransitionTypes & 8) == 8) {
            cancel(1);
            cancel(4);
        }
        if (hasListeners() && (this.mTransitionTypes & 2) == 2) {
            Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
            while (it.hasNext()) {
                ((TransitionListener) it.next()).startTransition(this, viewGroup, view, 3);
            }
        }
        if (z && (this.mTransitionTypes & 8) == 8) {
            runChangeTransition(viewGroup, view, 3);
        }
        if ((this.mTransitionTypes & 2) == 2) {
            runDisappearingTransition(viewGroup, view);
        }
    }

    private void runAppearingTransition(final ViewGroup viewGroup, final View view) {
        Animator animator = this.currentDisappearingAnimations.get(view);
        if (animator != null) {
            animator.cancel();
        }
        if (this.mAppearingAnim == null) {
            if (hasListeners()) {
                Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((TransitionListener) it.next()).endTransition(this, viewGroup, view, 2);
                }
                return;
            }
            return;
        }
        Animator mo53clone = this.mAppearingAnim.mo53clone();
        mo53clone.setTarget(view);
        mo53clone.setStartDelay(this.mAppearingDelay);
        mo53clone.setDuration(this.mAppearingDuration);
        if (this.mAppearingInterpolator != sAppearingInterpolator) {
            mo53clone.setInterpolator(this.mAppearingInterpolator);
        }
        if (mo53clone instanceof ObjectAnimator) {
            ((ObjectAnimator) mo53clone).setCurrentPlayTime(0L);
        }
        mo53clone.addListener(new AnimatorListenerAdapter() { // from class: android.animation.LayoutTransition.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                LayoutTransition.this.currentAppearingAnimations.remove(view);
                if (LayoutTransition.this.hasListeners()) {
                    Iterator it2 = ((ArrayList) LayoutTransition.this.mListeners.clone()).iterator();
                    while (it2.hasNext()) {
                        ((TransitionListener) it2.next()).endTransition(LayoutTransition.this, viewGroup, view, 2);
                    }
                }
            }
        });
        this.currentAppearingAnimations.put(view, mo53clone);
        mo53clone.start();
    }

    private void runChangeTransition(final ViewGroup viewGroup, View view, int i) {
        long j;
        Animator animator = null;
        ObjectAnimator objectAnimator = null;
        switch (i) {
            case 2:
                animator = this.mChangingAppearingAnim;
                j = this.mChangingAppearingDuration;
                objectAnimator = defaultChangeIn;
                break;
            case 3:
                animator = this.mChangingDisappearingAnim;
                j = this.mChangingDisappearingDuration;
                objectAnimator = defaultChangeOut;
                break;
            case 4:
                animator = this.mChangingAnim;
                j = this.mChangingDuration;
                objectAnimator = defaultChange;
                break;
            default:
                j = 0;
                break;
        }
        if (animator == null) {
            return;
        }
        this.staggerDelay = 0L;
        ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                if (this.mAnimateParentHierarchy) {
                    ViewGroup viewGroup2 = viewGroup;
                    while (true) {
                        ViewGroup viewGroup3 = viewGroup2;
                        if (viewGroup3 != null) {
                            ViewParent parent = viewGroup3.getParent();
                            if (parent instanceof ViewGroup) {
                                setupChangeAnimation((ViewGroup) parent, i, objectAnimator, j, viewGroup3);
                                viewGroup2 = (ViewGroup) parent;
                            } else {
                                viewGroup2 = null;
                            }
                        }
                    }
                }
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.animation.LayoutTransition.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (LayoutTransition.this.layoutChangeListenerMap.size() > 0) {
                            for (View view2 : LayoutTransition.this.layoutChangeListenerMap.keySet()) {
                                view2.removeOnLayoutChangeListener((View.OnLayoutChangeListener) LayoutTransition.this.layoutChangeListenerMap.get(view2));
                            }
                        }
                        LayoutTransition.this.layoutChangeListenerMap.clear();
                        return true;
                    }
                });
                return;
            }
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != view) {
                setupChangeAnimation(viewGroup, i, animator, j, childAt);
            }
            i2 = i3 + 1;
        }
    }

    private void runDisappearingTransition(final ViewGroup viewGroup, final View view) {
        Animator animator = this.currentAppearingAnimations.get(view);
        if (animator != null) {
            animator.cancel();
        }
        if (this.mDisappearingAnim == null) {
            if (hasListeners()) {
                Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((TransitionListener) it.next()).endTransition(this, viewGroup, view, 3);
                }
                return;
            }
            return;
        }
        Animator mo53clone = this.mDisappearingAnim.mo53clone();
        mo53clone.setStartDelay(this.mDisappearingDelay);
        mo53clone.setDuration(this.mDisappearingDuration);
        if (this.mDisappearingInterpolator != sDisappearingInterpolator) {
            mo53clone.setInterpolator(this.mDisappearingInterpolator);
        }
        mo53clone.setTarget(view);
        final float alpha = view.getAlpha();
        mo53clone.addListener(new AnimatorListenerAdapter() { // from class: android.animation.LayoutTransition.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                LayoutTransition.this.currentDisappearingAnimations.remove(view);
                view.setAlpha(alpha);
                if (LayoutTransition.this.hasListeners()) {
                    Iterator it2 = ((ArrayList) LayoutTransition.this.mListeners.clone()).iterator();
                    while (it2.hasNext()) {
                        ((TransitionListener) it2.next()).endTransition(LayoutTransition.this, viewGroup, view, 3);
                    }
                }
            }
        });
        if (mo53clone instanceof ObjectAnimator) {
            ((ObjectAnimator) mo53clone).setCurrentPlayTime(0L);
        }
        this.currentDisappearingAnimations.put(view, mo53clone);
        mo53clone.start();
    }

    private void setupChangeAnimation(final ViewGroup viewGroup, final int i, Animator animator, final long j, final View view) {
        if (this.layoutChangeListenerMap.get(view) != null) {
            return;
        }
        if (view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        final Animator mo53clone = animator.mo53clone();
        mo53clone.setTarget(view);
        mo53clone.setupStartValues();
        Animator animator2 = this.pendingAnimations.get(view);
        if (animator2 != null) {
            animator2.cancel();
            this.pendingAnimations.remove(view);
        }
        this.pendingAnimations.put(view, mo53clone);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(100 + j);
        duration.addListener(new AnimatorListenerAdapter() { // from class: android.animation.LayoutTransition.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator3) {
                LayoutTransition.this.pendingAnimations.remove(view);
            }
        });
        duration.start();
        final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: android.animation.LayoutTransition.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                mo53clone.setupEndValues();
                if (mo53clone instanceof ValueAnimator) {
                    boolean z = false;
                    PropertyValuesHolder[] values = ((ValueAnimator) mo53clone).getValues();
                    int i10 = 0;
                    while (true) {
                        int i11 = i10;
                        if (i11 >= values.length) {
                            break;
                        }
                        PropertyValuesHolder propertyValuesHolder = values[i11];
                        if (propertyValuesHolder.mKeyframes instanceof KeyframeSet) {
                            KeyframeSet keyframeSet = (KeyframeSet) propertyValuesHolder.mKeyframes;
                            if (keyframeSet.mFirstKeyframe == null || keyframeSet.mLastKeyframe == null || !keyframeSet.mFirstKeyframe.getValue().equals(keyframeSet.mLastKeyframe.getValue())) {
                                z = true;
                            }
                        } else if (!propertyValuesHolder.mKeyframes.getValue(0.0f).equals(propertyValuesHolder.mKeyframes.getValue(1.0f))) {
                            z = true;
                        }
                        i10 = i11 + 1;
                    }
                    if (!z) {
                        return;
                    }
                }
                long j2 = 0;
                switch (i) {
                    case 2:
                        long j3 = LayoutTransition.this.mChangingAppearingDelay + LayoutTransition.this.staggerDelay;
                        LayoutTransition.access$314(LayoutTransition.this, LayoutTransition.this.mChangingAppearingStagger);
                        j2 = j3;
                        if (LayoutTransition.this.mChangingAppearingInterpolator != LayoutTransition.sChangingAppearingInterpolator) {
                            mo53clone.setInterpolator(LayoutTransition.this.mChangingAppearingInterpolator);
                            j2 = j3;
                            break;
                        }
                        break;
                    case 3:
                        long j4 = LayoutTransition.this.mChangingDisappearingDelay + LayoutTransition.this.staggerDelay;
                        LayoutTransition.access$314(LayoutTransition.this, LayoutTransition.this.mChangingDisappearingStagger);
                        j2 = j4;
                        if (LayoutTransition.this.mChangingDisappearingInterpolator != LayoutTransition.sChangingDisappearingInterpolator) {
                            mo53clone.setInterpolator(LayoutTransition.this.mChangingDisappearingInterpolator);
                            j2 = j4;
                            break;
                        }
                        break;
                    case 4:
                        long j5 = LayoutTransition.this.mChangingDelay + LayoutTransition.this.staggerDelay;
                        LayoutTransition.access$314(LayoutTransition.this, LayoutTransition.this.mChangingStagger);
                        j2 = j5;
                        if (LayoutTransition.this.mChangingInterpolator != LayoutTransition.sChangingInterpolator) {
                            mo53clone.setInterpolator(LayoutTransition.this.mChangingInterpolator);
                            j2 = j5;
                            break;
                        }
                        break;
                }
                mo53clone.setStartDelay(j2);
                mo53clone.setDuration(j);
                Animator animator3 = (Animator) LayoutTransition.this.currentChangingAnimations.get(view);
                if (animator3 != null) {
                    animator3.cancel();
                }
                if (((Animator) LayoutTransition.this.pendingAnimations.get(view)) != null) {
                    LayoutTransition.this.pendingAnimations.remove(view);
                }
                LayoutTransition.this.currentChangingAnimations.put(view, mo53clone);
                viewGroup.requestTransitionStart(LayoutTransition.this);
                view.removeOnLayoutChangeListener(this);
                LayoutTransition.this.layoutChangeListenerMap.remove(view);
            }
        };
        mo53clone.addListener(new AnimatorListenerAdapter() { // from class: android.animation.LayoutTransition.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator3) {
                view.removeOnLayoutChangeListener(onLayoutChangeListener);
                LayoutTransition.this.layoutChangeListenerMap.remove(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator3) {
                LayoutTransition.this.currentChangingAnimations.remove(view);
                if (LayoutTransition.this.hasListeners()) {
                    Iterator it = ((ArrayList) LayoutTransition.this.mListeners.clone()).iterator();
                    while (it.hasNext()) {
                        ((TransitionListener) it.next()).endTransition(LayoutTransition.this, viewGroup, view, i == 2 ? 0 : i == 3 ? 1 : 4);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator3) {
                if (LayoutTransition.this.hasListeners()) {
                    Iterator it = ((ArrayList) LayoutTransition.this.mListeners.clone()).iterator();
                    while (it.hasNext()) {
                        ((TransitionListener) it.next()).startTransition(LayoutTransition.this, viewGroup, view, i == 2 ? 0 : i == 3 ? 1 : 4);
                    }
                }
            }
        });
        view.addOnLayoutChangeListener(onLayoutChangeListener);
        this.layoutChangeListenerMap.put(view, onLayoutChangeListener);
    }

    public void addChild(ViewGroup viewGroup, View view) {
        addChild(viewGroup, view, true);
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
    }

    public void cancel() {
        if (this.currentChangingAnimations.size() > 0) {
            for (Animator animator : ((LinkedHashMap) this.currentChangingAnimations.clone()).values()) {
                animator.cancel();
            }
            this.currentChangingAnimations.clear();
        }
        if (this.currentAppearingAnimations.size() > 0) {
            for (Animator animator2 : ((LinkedHashMap) this.currentAppearingAnimations.clone()).values()) {
                animator2.end();
            }
            this.currentAppearingAnimations.clear();
        }
        if (this.currentDisappearingAnimations.size() > 0) {
            for (Animator animator3 : ((LinkedHashMap) this.currentDisappearingAnimations.clone()).values()) {
                animator3.end();
            }
            this.currentDisappearingAnimations.clear();
        }
    }

    public void cancel(int i) {
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (this.currentChangingAnimations.size() > 0) {
                    for (Animator animator : ((LinkedHashMap) this.currentChangingAnimations.clone()).values()) {
                        animator.cancel();
                    }
                    this.currentChangingAnimations.clear();
                    return;
                }
                return;
            case 2:
                if (this.currentAppearingAnimations.size() > 0) {
                    for (Animator animator2 : ((LinkedHashMap) this.currentAppearingAnimations.clone()).values()) {
                        animator2.end();
                    }
                    this.currentAppearingAnimations.clear();
                    return;
                }
                return;
            case 3:
                if (this.currentDisappearingAnimations.size() > 0) {
                    for (Animator animator3 : ((LinkedHashMap) this.currentDisappearingAnimations.clone()).values()) {
                        animator3.end();
                    }
                    this.currentDisappearingAnimations.clear();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void disableTransitionType(int i) {
        switch (i) {
            case 0:
                this.mTransitionTypes &= -5;
                return;
            case 1:
                this.mTransitionTypes &= -9;
                return;
            case 2:
                this.mTransitionTypes &= -2;
                return;
            case 3:
                this.mTransitionTypes &= -3;
                return;
            case 4:
                this.mTransitionTypes &= -17;
                return;
            default:
                return;
        }
    }

    public void enableTransitionType(int i) {
        switch (i) {
            case 0:
                this.mTransitionTypes |= 4;
                return;
            case 1:
                this.mTransitionTypes |= 8;
                return;
            case 2:
                this.mTransitionTypes |= 1;
                return;
            case 3:
                this.mTransitionTypes |= 2;
                return;
            case 4:
                this.mTransitionTypes |= 16;
                return;
            default:
                return;
        }
    }

    public void endChangingAnimations() {
        for (Animator animator : ((LinkedHashMap) this.currentChangingAnimations.clone()).values()) {
            animator.start();
            animator.end();
        }
        this.currentChangingAnimations.clear();
    }

    public Animator getAnimator(int i) {
        switch (i) {
            case 0:
                return this.mChangingAppearingAnim;
            case 1:
                return this.mChangingDisappearingAnim;
            case 2:
                return this.mAppearingAnim;
            case 3:
                return this.mDisappearingAnim;
            case 4:
                return this.mChangingAnim;
            default:
                return null;
        }
    }

    public long getDuration(int i) {
        switch (i) {
            case 0:
                return this.mChangingAppearingDuration;
            case 1:
                return this.mChangingDisappearingDuration;
            case 2:
                return this.mAppearingDuration;
            case 3:
                return this.mDisappearingDuration;
            case 4:
                return this.mChangingDuration;
            default:
                return 0L;
        }
    }

    public TimeInterpolator getInterpolator(int i) {
        switch (i) {
            case 0:
                return this.mChangingAppearingInterpolator;
            case 1:
                return this.mChangingDisappearingInterpolator;
            case 2:
                return this.mAppearingInterpolator;
            case 3:
                return this.mDisappearingInterpolator;
            case 4:
                return this.mChangingInterpolator;
            default:
                return null;
        }
    }

    public long getStagger(int i) {
        switch (i) {
            case 0:
                return this.mChangingAppearingStagger;
            case 1:
                return this.mChangingDisappearingStagger;
            case 2:
            case 3:
            default:
                return 0L;
            case 4:
                return this.mChangingStagger;
        }
    }

    public long getStartDelay(int i) {
        switch (i) {
            case 0:
                return this.mChangingAppearingDelay;
            case 1:
                return this.mChangingDisappearingDelay;
            case 2:
                return this.mAppearingDelay;
            case 3:
                return this.mDisappearingDelay;
            case 4:
                return this.mChangingDelay;
            default:
                return 0L;
        }
    }

    public List<TransitionListener> getTransitionListeners() {
        return this.mListeners;
    }

    @Deprecated
    public void hideChild(ViewGroup viewGroup, View view) {
        removeChild(viewGroup, view, true);
    }

    public void hideChild(ViewGroup viewGroup, View view, int i) {
        removeChild(viewGroup, view, i == 8);
    }

    public boolean isChangingLayout() {
        return this.currentChangingAnimations.size() > 0;
    }

    public boolean isRunning() {
        return this.currentChangingAnimations.size() > 0 || this.currentAppearingAnimations.size() > 0 || this.currentDisappearingAnimations.size() > 0;
    }

    public boolean isTransitionTypeEnabled(int i) {
        boolean z = true;
        switch (i) {
            case 0:
                if ((this.mTransitionTypes & 4) != 4) {
                    return false;
                }
                break;
            case 1:
                if ((this.mTransitionTypes & 8) != 8) {
                    return false;
                }
                break;
            case 2:
                if ((this.mTransitionTypes & 1) != 1) {
                    return false;
                }
                break;
            case 3:
                if ((this.mTransitionTypes & 2) != 2) {
                    return false;
                }
                break;
            case 4:
                if ((this.mTransitionTypes & 16) != 16) {
                    return false;
                }
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    public void layoutChange(ViewGroup viewGroup) {
        if (viewGroup.getWindowVisibility() == 0 && (this.mTransitionTypes & 16) == 16 && !isRunning()) {
            runChangeTransition(viewGroup, null, 4);
        }
    }

    public void removeChild(ViewGroup viewGroup, View view) {
        removeChild(viewGroup, view, true);
    }

    public void removeTransitionListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            return;
        }
        this.mListeners.remove(transitionListener);
    }

    public void setAnimateParentHierarchy(boolean z) {
        this.mAnimateParentHierarchy = z;
    }

    public void setAnimator(int i, Animator animator) {
        switch (i) {
            case 0:
                this.mChangingAppearingAnim = animator;
                return;
            case 1:
                this.mChangingDisappearingAnim = animator;
                return;
            case 2:
                this.mAppearingAnim = animator;
                return;
            case 3:
                this.mDisappearingAnim = animator;
                return;
            case 4:
                this.mChangingAnim = animator;
                return;
            default:
                return;
        }
    }

    public void setDuration(int i, long j) {
        switch (i) {
            case 0:
                this.mChangingAppearingDuration = j;
                return;
            case 1:
                this.mChangingDisappearingDuration = j;
                return;
            case 2:
                this.mAppearingDuration = j;
                return;
            case 3:
                this.mDisappearingDuration = j;
                return;
            case 4:
                this.mChangingDuration = j;
                return;
            default:
                return;
        }
    }

    public void setDuration(long j) {
        this.mChangingAppearingDuration = j;
        this.mChangingDisappearingDuration = j;
        this.mChangingDuration = j;
        this.mAppearingDuration = j;
        this.mDisappearingDuration = j;
    }

    public void setInterpolator(int i, TimeInterpolator timeInterpolator) {
        switch (i) {
            case 0:
                this.mChangingAppearingInterpolator = timeInterpolator;
                return;
            case 1:
                this.mChangingDisappearingInterpolator = timeInterpolator;
                return;
            case 2:
                this.mAppearingInterpolator = timeInterpolator;
                return;
            case 3:
                this.mDisappearingInterpolator = timeInterpolator;
                return;
            case 4:
                this.mChangingInterpolator = timeInterpolator;
                return;
            default:
                return;
        }
    }

    public void setStagger(int i, long j) {
        switch (i) {
            case 0:
                this.mChangingAppearingStagger = j;
                return;
            case 1:
                this.mChangingDisappearingStagger = j;
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.mChangingStagger = j;
                return;
        }
    }

    public void setStartDelay(int i, long j) {
        switch (i) {
            case 0:
                this.mChangingAppearingDelay = j;
                return;
            case 1:
                this.mChangingDisappearingDelay = j;
                return;
            case 2:
                this.mAppearingDelay = j;
                return;
            case 3:
                this.mDisappearingDelay = j;
                return;
            case 4:
                this.mChangingDelay = j;
                return;
            default:
                return;
        }
    }

    @Deprecated
    public void showChild(ViewGroup viewGroup, View view) {
        addChild(viewGroup, view, true);
    }

    public void showChild(ViewGroup viewGroup, View view, int i) {
        addChild(viewGroup, view, i == 8);
    }

    public void startChangingAnimations() {
        for (Animator animator : ((LinkedHashMap) this.currentChangingAnimations.clone()).values()) {
            if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setCurrentPlayTime(0L);
            }
            animator.start();
        }
    }
}
