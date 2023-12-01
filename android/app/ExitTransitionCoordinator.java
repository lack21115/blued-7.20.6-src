package android.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityTransitionCoordinator;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/ExitTransitionCoordinator.class */
public class ExitTransitionCoordinator extends ActivityTransitionCoordinator {
    private static final long MAX_WAIT_MS = 1000;
    private static final String TAG = "ExitTransitionCoordinator";
    private Activity mActivity;
    private ObjectAnimator mBackgroundAnimator;
    private boolean mExitComplete;
    private boolean mExitNotified;
    private Bundle mExitSharedElementBundle;
    private Handler mHandler;
    private boolean mIsBackgroundReady;
    private boolean mIsCanceled;
    private boolean mIsExitStarted;
    private boolean mIsHidden;
    private Bundle mSharedElementBundle;
    private boolean mSharedElementNotified;
    private boolean mSharedElementsHidden;

    public ExitTransitionCoordinator(Activity activity, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<View> arrayList3, boolean z) {
        super(activity.getWindow(), arrayList, getListener(activity, z), z);
        viewsReady(mapSharedElements(arrayList2, arrayList3));
        stripOffscreenViews();
        this.mIsBackgroundReady = !z;
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginTransitions() {
        Transition mergeTransitions = mergeTransitions(getSharedElementExitTransition(), getExitTransition());
        ViewGroup decor = getDecor();
        if (mergeTransitions == null || decor == null) {
            transitionStarted();
            return;
        }
        setGhostVisibility(4);
        scheduleGhostVisibilityChange(4);
        TransitionManager.beginDelayedTransition(decor, mergeTransitions);
        scheduleGhostVisibilityChange(0);
        setGhostVisibility(0);
        decor.invalidate();
    }

    private Bundle captureExitSharedElementsState() {
        Bundle bundle = new Bundle();
        RectF rectF = new RectF();
        Matrix matrix = new Matrix();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSharedElements.size()) {
                return bundle;
            }
            String str = this.mSharedElementNames.get(i2);
            Bundle bundle2 = this.mExitSharedElementBundle.getBundle(str);
            if (bundle2 != null) {
                bundle.putBundle(str, bundle2);
            } else {
                captureSharedElementState(this.mSharedElements.get(i2), str, bundle, matrix, rectF);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayCancel() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(106, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitTransitionComplete() {
        this.mExitComplete = true;
        notifyComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fadeOutBackground() {
        Drawable background;
        if (this.mBackgroundAnimator == null) {
            ViewGroup decor = getDecor();
            if (decor == null || (background = decor.getBackground()) == null) {
                this.mIsBackgroundReady = true;
                return;
            }
            Drawable mutate = background.mutate();
            getWindow().setBackgroundDrawable(mutate);
            this.mBackgroundAnimator = ObjectAnimator.ofInt(mutate, "alpha", 0);
            this.mBackgroundAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.app.ExitTransitionCoordinator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ExitTransitionCoordinator.this.mBackgroundAnimator = null;
                    if (ExitTransitionCoordinator.this.mIsCanceled) {
                        return;
                    }
                    ExitTransitionCoordinator.this.mIsBackgroundReady = true;
                    ExitTransitionCoordinator.this.notifyComplete();
                }
            });
            this.mBackgroundAnimator.setDuration(getFadeDuration());
            this.mBackgroundAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        stopCancel();
        if (this.mActivity != null) {
            this.mActivity.mActivityTransitionState.clear();
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
            this.mActivity = null;
        }
        this.mHandler = null;
        this.mSharedElementBundle = null;
        if (this.mBackgroundAnimator != null) {
            this.mBackgroundAnimator.cancel();
            this.mBackgroundAnimator = null;
        }
        this.mExitSharedElementBundle = null;
        clearState();
    }

    private void finishIfNecessary() {
        if (this.mIsReturning && this.mExitNotified && this.mActivity != null && (this.mSharedElements.isEmpty() || this.mSharedElementsHidden)) {
            finish();
        }
        if (this.mIsReturning || !this.mExitNotified) {
            return;
        }
        this.mActivity = null;
    }

    private Transition getExitTransition() {
        Transition transition = null;
        if (this.mTransitioningViews != null) {
            transition = null;
            if (!this.mTransitioningViews.isEmpty()) {
                transition = configureTransition(getViewsTransition(), true);
            }
        }
        if (transition == null) {
            exitTransitionComplete();
            return transition;
        }
        final ArrayList<View> arrayList = this.mTransitioningViews;
        transition.addListener(new ActivityTransitionCoordinator.ContinueTransitionListener() { // from class: android.app.ExitTransitionCoordinator.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                transition2.removeListener(this);
                ExitTransitionCoordinator.this.exitTransitionComplete();
                if (ExitTransitionCoordinator.this.mIsHidden && arrayList != null) {
                    ExitTransitionCoordinator.this.showViews(arrayList, true);
                }
                if (ExitTransitionCoordinator.this.mSharedElementBundle != null) {
                    ExitTransitionCoordinator.this.delayCancel();
                }
                super.onTransitionEnd(transition2);
            }
        });
        transition.forceVisibility(4, false);
        return transition;
    }

    private static SharedElementCallback getListener(Activity activity, boolean z) {
        return z ? activity.mEnterTransitionListener : activity.mExitTransitionListener;
    }

    private Transition getSharedElementExitTransition() {
        Transition transition = null;
        if (!this.mSharedElements.isEmpty()) {
            transition = configureTransition(getSharedElementTransition(), false);
        }
        if (transition == null) {
            sharedElementTransitionComplete();
            return transition;
        }
        transition.addListener(new ActivityTransitionCoordinator.ContinueTransitionListener() { // from class: android.app.ExitTransitionCoordinator.10
            @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                transition2.removeListener(this);
                ExitTransitionCoordinator.this.sharedElementTransitionComplete();
                if (ExitTransitionCoordinator.this.mIsHidden) {
                    ExitTransitionCoordinator.this.showViews(ExitTransitionCoordinator.this.mSharedElements, true);
                }
            }
        });
        this.mSharedElements.get(0).invalidate();
        return transition;
    }

    private void hideSharedElements() {
        moveSharedElementsFromOverlay();
        if (!this.mIsHidden) {
            hideViews(this.mSharedElements);
        }
        this.mSharedElementsHidden = true;
        finishIfNecessary();
    }

    private void sharedElementExitBack() {
        final ViewGroup decor = getDecor();
        if (decor != null) {
            decor.suppressLayout(true);
        }
        if (decor == null || this.mExitSharedElementBundle == null || this.mExitSharedElementBundle.isEmpty() || this.mSharedElements.isEmpty() || getSharedElementTransition() == null) {
            sharedElementTransitionComplete();
        } else {
            startTransition(new Runnable() { // from class: android.app.ExitTransitionCoordinator.1
                @Override // java.lang.Runnable
                public void run() {
                    ExitTransitionCoordinator.this.startSharedElementExit(decor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sharedElementTransitionComplete() {
        this.mSharedElementBundle = this.mExitSharedElementBundle == null ? captureSharedElementState() : captureExitSharedElementsState();
        notifyComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExitTransition() {
        Transition exitTransition = getExitTransition();
        ViewGroup decor = getDecor();
        if (exitTransition == null || decor == null || this.mTransitioningViews == null) {
            transitionStarted();
            return;
        }
        TransitionManager.beginDelayedTransition(decor, exitTransition);
        this.mTransitioningViews.get(0).invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSharedElementExit(final ViewGroup viewGroup) {
        Transition sharedElementExitTransition = getSharedElementExitTransition();
        sharedElementExitTransition.addListener(new Transition.TransitionListenerAdapter() { // from class: android.app.ExitTransitionCoordinator.2
            @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                if (ExitTransitionCoordinator.this.mExitComplete) {
                    ExitTransitionCoordinator.this.delayCancel();
                }
            }
        });
        final ArrayList<View> createSnapshots = createSnapshots(this.mExitSharedElementBundle, this.mSharedElementNames);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.ExitTransitionCoordinator.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                ExitTransitionCoordinator.this.setSharedElementState(ExitTransitionCoordinator.this.mExitSharedElementBundle, createSnapshots);
                return true;
            }
        });
        setGhostVisibility(4);
        scheduleGhostVisibilityChange(4);
        if (this.mListener != null) {
            this.mListener.onSharedElementEnd(this.mSharedElementNames, this.mSharedElements, createSnapshots);
        }
        TransitionManager.beginDelayedTransition(viewGroup, sharedElementExitTransition);
        scheduleGhostVisibilityChange(0);
        setGhostVisibility(0);
        viewGroup.invalidate();
    }

    private void stopCancel() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(106);
        }
    }

    protected Transition getSharedElementTransition() {
        return this.mIsReturning ? getWindow().getSharedElementReturnTransition() : getWindow().getSharedElementExitTransition();
    }

    @Override // android.app.ActivityTransitionCoordinator
    protected Transition getViewsTransition() {
        return this.mIsReturning ? getWindow().getReturnTransition() : getWindow().getExitTransition();
    }

    protected boolean isReadyToNotify() {
        return (this.mSharedElementBundle == null || this.mResultReceiver == null || !this.mIsBackgroundReady) ? false : true;
    }

    @Override // android.app.ActivityTransitionCoordinator
    protected boolean moveSharedElementWithParent() {
        return !this.mIsReturning;
    }

    protected void notifyComplete() {
        if (isReadyToNotify()) {
            if (!this.mSharedElementNotified) {
                this.mSharedElementNotified = true;
                delayCancel();
                this.mResultReceiver.send(103, this.mSharedElementBundle);
            }
            if (this.mExitNotified || !this.mExitComplete) {
                return;
            }
            this.mExitNotified = true;
            this.mResultReceiver.send(104, null);
            this.mResultReceiver = null;
            ViewGroup decor = getDecor();
            if (!this.mIsReturning && decor != null) {
                decor.suppressLayout(false);
            }
            finishIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        switch (i) {
            case 100:
                stopCancel();
                this.mResultReceiver = (ResultReceiver) bundle.getParcelable("android:remoteReceiver");
                if (!this.mIsCanceled) {
                    notifyComplete();
                    return;
                }
                this.mResultReceiver.send(106, null);
                this.mResultReceiver = null;
                return;
            case 101:
                stopCancel();
                if (this.mIsCanceled) {
                    return;
                }
                hideSharedElements();
                return;
            case 102:
            case 103:
            case 104:
            case 106:
            default:
                return;
            case 105:
                this.mHandler.removeMessages(106);
                startExit();
                return;
            case 107:
                this.mExitSharedElementBundle = bundle;
                sharedElementExitBack();
                return;
        }
    }

    public void resetViews() {
        if (this.mTransitioningViews != null) {
            showViews(this.mTransitioningViews, true);
        }
        showViews(this.mSharedElements, true);
        this.mIsHidden = true;
        ViewGroup decor = getDecor();
        if (!this.mIsReturning && decor != null) {
            decor.suppressLayout(false);
        }
        moveSharedElementsFromOverlay();
        clearState();
    }

    public void startExit() {
        if (this.mIsExitStarted) {
            return;
        }
        this.mIsExitStarted = true;
        ViewGroup decor = getDecor();
        if (decor != null) {
            decor.suppressLayout(true);
        }
        moveSharedElementsToOverlay();
        startTransition(new Runnable() { // from class: android.app.ExitTransitionCoordinator.4
            @Override // java.lang.Runnable
            public void run() {
                ExitTransitionCoordinator.this.beginTransitions();
            }
        });
    }

    public void startExit(int i, Intent intent) {
        if (this.mIsExitStarted) {
            return;
        }
        this.mIsExitStarted = true;
        ViewGroup decor = getDecor();
        if (decor != null) {
            decor.suppressLayout(true);
        }
        this.mHandler = new Handler() { // from class: android.app.ExitTransitionCoordinator.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ExitTransitionCoordinator.this.mIsCanceled = true;
                ExitTransitionCoordinator.this.finish();
            }
        };
        delayCancel();
        moveSharedElementsToOverlay();
        if (decor != null && decor.getBackground() == null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        this.mActivity.convertToTranslucent(new Activity.TranslucentConversionListener() { // from class: android.app.ExitTransitionCoordinator.6
            @Override // android.app.Activity.TranslucentConversionListener
            public void onTranslucentConversionComplete(boolean z) {
                if (ExitTransitionCoordinator.this.mIsCanceled) {
                    return;
                }
                ExitTransitionCoordinator.this.fadeOutBackground();
            }
        }, ActivityOptions.makeSceneTransitionAnimation(this.mActivity, this, this.mAllSharedElementNames, i, intent));
        startTransition(new Runnable() { // from class: android.app.ExitTransitionCoordinator.7
            @Override // java.lang.Runnable
            public void run() {
                ExitTransitionCoordinator.this.startExitTransition();
            }
        });
    }

    public void stop() {
        if (!this.mIsReturning || this.mActivity == null) {
            return;
        }
        this.mActivity.convertToTranslucent(null, null);
        finish();
    }
}
