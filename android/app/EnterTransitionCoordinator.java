package android.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.ActivityTransitionCoordinator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/EnterTransitionCoordinator.class */
public class EnterTransitionCoordinator extends ActivityTransitionCoordinator {
    private static final int MIN_ANIMATION_FRAMES = 2;
    private static final String TAG = "EnterTransitionCoordinator";
    private Activity mActivity;
    private boolean mAreViewsReady;
    private ObjectAnimator mBackgroundAnimator;
    private Transition mEnterViewsTransition;
    private boolean mHasStopped;
    private boolean mIsCanceled;
    private boolean mIsExitTransitionComplete;
    private boolean mIsReadyForTransition;
    private boolean mIsSharedElementTransitionComplete;
    private boolean mIsViewsTransitionComplete;
    private boolean mIsViewsTransitionStarted;
    private boolean mSharedElementTransitionStarted;
    private Bundle mSharedElementsBundle;
    private boolean mWasOpaque;

    public EnterTransitionCoordinator(Activity activity, ResultReceiver resultReceiver, ArrayList<String> arrayList, boolean z) {
        super(activity.getWindow(), arrayList, getListener(activity, z), z);
        this.mActivity = activity;
        setResultReceiver(resultReceiver);
        prepareEnter();
        Bundle bundle = new Bundle();
        bundle.putParcelable("android:remoteReceiver", this);
        this.mResultReceiver.send(100, bundle);
        final ViewGroup decor = getDecor();
        if (decor != null) {
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.EnterTransitionCoordinator.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (EnterTransitionCoordinator.this.mIsReadyForTransition) {
                        decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    }
                    return EnterTransitionCoordinator.this.mIsReadyForTransition;
                }
            });
        }
    }

    private boolean allowOverlappingTransitions() {
        return this.mIsReturning ? getWindow().getAllowExitTransitionOverlap() : getWindow().getAllowEnterTransitionOverlap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Transition beginTransition(ViewGroup viewGroup, boolean z, boolean z2) {
        Transition transition = null;
        Transition transition2 = null;
        if (z2) {
            if (!this.mSharedElementNames.isEmpty()) {
                transition2 = configureTransition(getSharedElementTransition(), false);
            }
            if (transition2 == null) {
                sharedElementTransitionStarted();
                sharedElementTransitionComplete();
                transition = transition2;
            } else {
                transition2.addListener(new Transition.TransitionListenerAdapter() { // from class: android.app.EnterTransitionCoordinator.6
                    @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition3) {
                        transition3.removeListener(this);
                        EnterTransitionCoordinator.this.sharedElementTransitionComplete();
                    }

                    @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition3) {
                        EnterTransitionCoordinator.this.sharedElementTransitionStarted();
                    }
                });
                transition = transition2;
            }
        }
        Transition transition3 = null;
        if (z) {
            this.mIsViewsTransitionStarted = true;
            transition3 = null;
            if (this.mTransitioningViews != null) {
                transition3 = null;
                if (!this.mTransitioningViews.isEmpty()) {
                    Transition configureTransition = configureTransition(getViewsTransition(), true);
                    transition3 = configureTransition;
                    if (configureTransition != null) {
                        transition3 = configureTransition;
                        if (!this.mIsReturning) {
                            stripOffscreenViews();
                            transition3 = configureTransition;
                        }
                    }
                }
            }
            if (transition3 == null) {
                viewTransitionComplete();
            } else {
                transition3.forceVisibility(4, true);
                final ArrayList<View> arrayList = this.mTransitioningViews;
                transition3.addListener(new ActivityTransitionCoordinator.ContinueTransitionListener() { // from class: android.app.EnterTransitionCoordinator.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition4) {
                        EnterTransitionCoordinator.this.mEnterViewsTransition = null;
                        transition4.removeListener(this);
                        EnterTransitionCoordinator.this.viewTransitionComplete();
                        super.onTransitionEnd(transition4);
                    }

                    @Override // android.app.ActivityTransitionCoordinator.ContinueTransitionListener, android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition4) {
                        EnterTransitionCoordinator.this.mEnterViewsTransition = transition4;
                        if (arrayList != null) {
                            EnterTransitionCoordinator.this.showViews(arrayList, false);
                        }
                        super.onTransitionStart(transition4);
                    }
                });
            }
        }
        Transition mergeTransitions = mergeTransitions(transition, transition3);
        if (mergeTransitions == null) {
            transitionStarted();
            return mergeTransitions;
        }
        mergeTransitions.addListener(new ActivityTransitionCoordinator.ContinueTransitionListener());
        TransitionManager.beginDelayedTransition(viewGroup, mergeTransitions);
        if (z2 && !this.mSharedElementNames.isEmpty()) {
            this.mSharedElements.get(0).invalidate();
        } else if (z && this.mTransitioningViews != null && !this.mTransitioningViews.isEmpty()) {
            this.mTransitioningViews.get(0).invalidate();
            return mergeTransitions;
        }
        return mergeTransitions;
    }

    private void cancel() {
        if (this.mIsCanceled) {
            return;
        }
        this.mIsCanceled = true;
        if (getViewsTransition() == null || this.mIsViewsTransitionStarted) {
            showViews(this.mSharedElements, true);
        } else if (this.mTransitioningViews != null) {
            this.mTransitioningViews.addAll(this.mSharedElements);
        }
        this.mSharedElementNames.clear();
        this.mSharedElements.clear();
        this.mAllSharedElementNames.clear();
        startSharedElementTransition(null);
        onRemoteExitTransitionComplete();
    }

    private static SharedElementCallback getListener(Activity activity, boolean z) {
        return z ? activity.mExitTransitionListener : activity.mEnterTransitionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeOpaque() {
        if (this.mHasStopped || this.mActivity == null) {
            return;
        }
        if (this.mWasOpaque) {
            this.mActivity.convertFromTranslucent();
        }
        this.mActivity = null;
    }

    private ArrayMap<String, View> mapNamedElements(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        View remove;
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        ViewGroup decor = getDecor();
        if (decor != null) {
            decor.findNamedViews(arrayMap);
        }
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList2.size()) {
                    break;
                }
                String str = arrayList2.get(i2);
                String str2 = arrayList.get(i2);
                if (str != null && !str.equals(str2) && (remove = arrayMap.remove(str)) != null) {
                    arrayMap.put(str2, remove);
                }
                i = i2 + 1;
            }
        }
        return arrayMap;
    }

    private void onTakeSharedElements() {
        if (!this.mIsReadyForTransition || this.mSharedElementsBundle == null) {
            return;
        }
        final Bundle bundle = this.mSharedElementsBundle;
        this.mSharedElementsBundle = null;
        final ViewGroup decor = getDecor();
        if (decor != null) {
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.EnterTransitionCoordinator.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    EnterTransitionCoordinator.this.startTransition(new Runnable() { // from class: android.app.EnterTransitionCoordinator.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EnterTransitionCoordinator.this.startSharedElementTransition(bundle);
                        }
                    });
                    return false;
                }
            });
            decor.invalidate();
        }
    }

    private static void removeNullViews(ArrayList<View> arrayList) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            if (arrayList.get(i) == null) {
                arrayList.remove(i);
            }
            size = i;
        }
    }

    private void requestLayoutForSharedElements() {
        int size = this.mSharedElements.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mSharedElements.get(i2).requestLayout();
            i = i2 + 1;
        }
    }

    private void sendSharedElementDestination() {
        boolean z;
        final ViewGroup decor = getDecor();
        if (allowOverlappingTransitions() && getEnterViewsTransition() != null) {
            z = false;
        } else if (decor == null) {
            z = true;
        } else {
            boolean z2 = !decor.isLayoutRequested();
            z = z2;
            if (z2) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = z2;
                    if (i2 >= this.mSharedElements.size()) {
                        break;
                    } else if (this.mSharedElements.get(i2).isLayoutRequested()) {
                        z = false;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }
        if (z) {
            Bundle captureSharedElementState = captureSharedElementState();
            moveSharedElementsToOverlay();
            this.mResultReceiver.send(107, captureSharedElementState);
        } else if (decor != null) {
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.EnterTransitionCoordinator.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (EnterTransitionCoordinator.this.mResultReceiver != null) {
                        Bundle captureSharedElementState2 = EnterTransitionCoordinator.this.captureSharedElementState();
                        EnterTransitionCoordinator.this.moveSharedElementsToOverlay();
                        EnterTransitionCoordinator.this.mResultReceiver.send(107, captureSharedElementState2);
                        return true;
                    }
                    return true;
                }
            });
        }
        if (allowOverlappingTransitions()) {
            startEnterTransitionOnly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sharedElementTransitionComplete() {
        this.mIsSharedElementTransitionComplete = true;
        if (this.mIsViewsTransitionComplete) {
            moveSharedElementsFromOverlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sharedElementTransitionStarted() {
        this.mSharedElementTransitionStarted = true;
        if (this.mIsExitTransitionComplete) {
            send(104, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startEnterTransition(Transition transition) {
        ViewGroup decor = getDecor();
        if (this.mIsReturning || decor == null) {
            return;
        }
        Drawable background = decor.getBackground();
        if (background == null) {
            if (transition != null) {
                transition.addListener(new Transition.TransitionListenerAdapter() { // from class: android.app.EnterTransitionCoordinator.9
                    @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition2) {
                        transition2.removeListener(this);
                        EnterTransitionCoordinator.this.makeOpaque();
                    }
                });
                return;
            } else {
                makeOpaque();
                return;
            }
        }
        Drawable mutate = background.mutate();
        getWindow().setBackgroundDrawable(mutate);
        this.mBackgroundAnimator = ObjectAnimator.ofInt(mutate, "alpha", 255);
        this.mBackgroundAnimator.setDuration(getFadeDuration());
        this.mBackgroundAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.app.EnterTransitionCoordinator.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                EnterTransitionCoordinator.this.makeOpaque();
            }
        });
        this.mBackgroundAnimator.start();
    }

    private void startEnterTransitionOnly() {
        startTransition(new Runnable() { // from class: android.app.EnterTransitionCoordinator.11
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup decor = EnterTransitionCoordinator.this.getDecor();
                if (decor != null) {
                    EnterTransitionCoordinator.this.startEnterTransition(EnterTransitionCoordinator.this.beginTransition(decor, true, false));
                }
            }
        });
    }

    private void startRejectedAnimations(final ArrayList<View> arrayList) {
        final ViewGroup decor;
        if (arrayList == null || arrayList.isEmpty() || (decor = getDecor()) == null) {
            return;
        }
        ViewGroupOverlay overlay = decor.getOverlay();
        ObjectAnimator objectAnimator = null;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.app.EnterTransitionCoordinator.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewGroupOverlay overlay2 = decor.getOverlay();
                        int size2 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= size2) {
                                return;
                            }
                            overlay2.remove((View) arrayList.get(i4));
                            i3 = i4 + 1;
                        }
                    }
                });
                return;
            }
            View view = arrayList.get(i2);
            overlay.add(view);
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f);
            objectAnimator.start();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSharedElementTransition(Bundle bundle) {
        boolean z = true;
        ViewGroup decor = getDecor();
        if (decor == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mAllSharedElementNames);
        arrayList.removeAll(this.mSharedElementNames);
        ArrayList<View> createSnapshots = createSnapshots(bundle, arrayList);
        if (this.mListener != null) {
            this.mListener.onRejectSharedElements(createSnapshots);
        }
        removeNullViews(createSnapshots);
        startRejectedAnimations(createSnapshots);
        ArrayList<View> createSnapshots2 = createSnapshots(bundle, this.mSharedElementNames);
        showViews(this.mSharedElements, true);
        scheduleSetSharedElementEnd(createSnapshots2);
        ArrayList<ActivityTransitionCoordinator.SharedElementOriginalState> sharedElementState = setSharedElementState(bundle, createSnapshots2);
        requestLayoutForSharedElements();
        if (!allowOverlappingTransitions() || this.mIsReturning) {
            z = false;
        }
        setGhostVisibility(4);
        scheduleGhostVisibilityChange(4);
        Transition beginTransition = beginTransition(decor, z, true);
        scheduleGhostVisibilityChange(0);
        setGhostVisibility(0);
        if (z) {
            startEnterTransition(beginTransition);
        }
        setOriginalSharedElementState(this.mSharedElements, sharedElementState);
        if (this.mResultReceiver != null) {
            decor.postOnAnimation(new Runnable() { // from class: android.app.EnterTransitionCoordinator.4
                int mAnimations;

                @Override // java.lang.Runnable
                public void run() {
                    int i = this.mAnimations;
                    this.mAnimations = i + 1;
                    if (i < 2) {
                        ViewGroup decor2 = EnterTransitionCoordinator.this.getDecor();
                        if (decor2 != null) {
                            decor2.postOnAnimation(this);
                        }
                    } else if (EnterTransitionCoordinator.this.mResultReceiver != null) {
                        EnterTransitionCoordinator.this.mResultReceiver.send(101, null);
                        EnterTransitionCoordinator.this.mResultReceiver = null;
                    }
                }
            });
        }
    }

    private void triggerViewsReady(final ArrayMap<String, View> arrayMap) {
        if (this.mAreViewsReady) {
            return;
        }
        this.mAreViewsReady = true;
        final ViewGroup decor = getDecor();
        if (decor == null || (decor.isAttachedToWindow() && (arrayMap.isEmpty() || !arrayMap.valueAt(0).isLayoutRequested()))) {
            viewsReady(arrayMap);
        } else {
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.EnterTransitionCoordinator.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    EnterTransitionCoordinator.this.viewsReady(arrayMap);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewTransitionComplete() {
        this.mIsViewsTransitionComplete = true;
        if (this.mIsSharedElementTransitionComplete) {
            moveSharedElementsFromOverlay();
        }
    }

    public boolean cancelEnter() {
        setGhostVisibility(4);
        this.mHasStopped = true;
        this.mIsCanceled = true;
        this.mResultReceiver = null;
        if (this.mBackgroundAnimator != null) {
            this.mBackgroundAnimator.cancel();
            this.mBackgroundAnimator = null;
        }
        this.mActivity = null;
        clearState();
        return super.cancelPendingTransitions();
    }

    public Transition getEnterViewsTransition() {
        return this.mEnterViewsTransition;
    }

    protected Transition getSharedElementTransition() {
        Window window = getWindow();
        if (window == null) {
            return null;
        }
        return this.mIsReturning ? window.getSharedElementReenterTransition() : window.getSharedElementEnterTransition();
    }

    @Override // android.app.ActivityTransitionCoordinator
    protected Transition getViewsTransition() {
        Window window = getWindow();
        if (window == null) {
            return null;
        }
        return this.mIsReturning ? window.getReenterTransition() : window.getEnterTransition();
    }

    public boolean isReturning() {
        return this.mIsReturning;
    }

    public void namedViewsReady(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        triggerViewsReady(mapNamedElements(arrayList, arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        switch (i) {
            case 103:
                if (this.mIsCanceled) {
                    return;
                }
                this.mSharedElementsBundle = bundle;
                onTakeSharedElements();
                return;
            case 104:
                if (this.mIsCanceled) {
                    return;
                }
                this.mIsExitTransitionComplete = true;
                if (this.mSharedElementTransitionStarted) {
                    onRemoteExitTransitionComplete();
                    return;
                }
                return;
            case 105:
            default:
                return;
            case 106:
                cancel();
                return;
        }
    }

    protected void onRemoteExitTransitionComplete() {
        if (allowOverlappingTransitions()) {
            return;
        }
        startEnterTransitionOnly();
    }

    protected void prepareEnter() {
        ViewGroup decor = getDecor();
        if (this.mActivity == null || decor == null) {
            return;
        }
        this.mActivity.overridePendingTransition(0, 0);
        if (this.mIsReturning) {
            this.mActivity = null;
            return;
        }
        this.mWasOpaque = this.mActivity.convertToTranslucent(null, null);
        Drawable background = decor.getBackground();
        if (background != null) {
            getWindow().setBackgroundDrawable(null);
            Drawable mutate = background.mutate();
            mutate.setAlpha(0);
            getWindow().setBackgroundDrawable(mutate);
        }
    }

    public void stop() {
        ViewGroup decor;
        Drawable background;
        if (this.mBackgroundAnimator != null) {
            this.mBackgroundAnimator.end();
            this.mBackgroundAnimator = null;
        } else if (this.mWasOpaque && (decor = getDecor()) != null && (background = decor.getBackground()) != null) {
            background.setAlpha(1);
        }
        makeOpaque();
        this.mIsCanceled = true;
        this.mResultReceiver = null;
        this.mActivity = null;
        moveSharedElementsFromOverlay();
        if (this.mTransitioningViews != null) {
            showViews(this.mTransitioningViews, true);
        }
        showViews(this.mSharedElements, true);
        clearState();
    }

    public void viewInstancesReady(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<View> arrayList3) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = i;
            z = false;
            if (i2 >= arrayList3.size()) {
                break;
            }
            View view = arrayList3.get(i2);
            if (!TextUtils.equals(view.getTransitionName(), arrayList2.get(i2)) || !view.isAttachedToWindow()) {
                break;
            }
            i = i2 + 1;
        }
        z = true;
        if (z) {
            triggerViewsReady(mapNamedElements(arrayList, arrayList2));
        } else {
            triggerViewsReady(mapSharedElements(arrayList, arrayList3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ActivityTransitionCoordinator
    public void viewsReady(ArrayMap<String, View> arrayMap) {
        super.viewsReady(arrayMap);
        this.mIsReadyForTransition = true;
        hideViews(this.mSharedElements);
        if (getViewsTransition() != null && this.mTransitioningViews != null) {
            hideViews(this.mTransitioningViews);
        }
        if (this.mIsReturning) {
            sendSharedElementDestination();
        } else {
            moveSharedElementsToOverlay();
        }
        if (this.mSharedElementsBundle != null) {
            onTakeSharedElements();
        }
    }
}
