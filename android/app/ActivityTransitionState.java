package android.app;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.transition.Transition;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityTransitionState.class */
public class ActivityTransitionState {
    private static final String ENTERING_SHARED_ELEMENTS = "android:enteringSharedElements";
    private static final String EXITING_MAPPED_FROM = "android:exitingMappedFrom";
    private static final String EXITING_MAPPED_TO = "android:exitingMappedTo";
    private ExitTransitionCoordinator mCalledExitCoordinator;
    private ActivityOptions mEnterActivityOptions;
    private EnterTransitionCoordinator mEnterTransitionCoordinator;
    private ArrayList<String> mEnteringNames;
    private SparseArray<WeakReference<ExitTransitionCoordinator>> mExitTransitionCoordinators;
    private int mExitTransitionCoordinatorsKey = 1;
    private ArrayList<String> mExitingFrom;
    private ArrayList<String> mExitingTo;
    private ArrayList<View> mExitingToView;
    private boolean mHasExited;
    private boolean mIsEnterPostponed;
    private boolean mIsEnterTriggered;
    private ExitTransitionCoordinator mReturnExitCoordinator;

    private void restoreExitedViews() {
        if (this.mCalledExitCoordinator != null) {
            this.mCalledExitCoordinator.resetViews();
            this.mCalledExitCoordinator = null;
        }
    }

    private void startEnter() {
        if (!this.mEnterActivityOptions.isReturning()) {
            this.mEnterTransitionCoordinator.namedViewsReady(null, null);
            this.mEnteringNames = this.mEnterTransitionCoordinator.getAllSharedElementNames();
        } else if (this.mExitingToView != null) {
            this.mEnterTransitionCoordinator.viewInstancesReady(this.mExitingFrom, this.mExitingTo, this.mExitingToView);
        } else {
            this.mEnterTransitionCoordinator.namedViewsReady(this.mExitingFrom, this.mExitingTo);
        }
        this.mExitingFrom = null;
        this.mExitingTo = null;
        this.mExitingToView = null;
        this.mEnterActivityOptions = null;
    }

    public int addExitTransitionCoordinator(ExitTransitionCoordinator exitTransitionCoordinator) {
        if (this.mExitTransitionCoordinators == null) {
            this.mExitTransitionCoordinators = new SparseArray<>();
        }
        WeakReference<ExitTransitionCoordinator> weakReference = new WeakReference<>(exitTransitionCoordinator);
        int size = this.mExitTransitionCoordinators.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                int i2 = this.mExitTransitionCoordinatorsKey;
                this.mExitTransitionCoordinatorsKey = i2 + 1;
                this.mExitTransitionCoordinators.append(i2, weakReference);
                return i2;
            }
            if (this.mExitTransitionCoordinators.valueAt(i).get() == null) {
                this.mExitTransitionCoordinators.removeAt(i);
            }
            size = i;
        }
    }

    public void clear() {
        this.mEnteringNames = null;
        this.mExitingFrom = null;
        this.mExitingTo = null;
        this.mExitingToView = null;
        this.mCalledExitCoordinator = null;
        this.mEnterTransitionCoordinator = null;
        this.mEnterActivityOptions = null;
        this.mExitTransitionCoordinators = null;
    }

    public void enterReady(Activity activity) {
        if (this.mEnterActivityOptions == null || this.mIsEnterTriggered) {
            return;
        }
        this.mIsEnterTriggered = true;
        this.mHasExited = false;
        ArrayList<String> sharedElementNames = this.mEnterActivityOptions.getSharedElementNames();
        ResultReceiver resultReceiver = this.mEnterActivityOptions.getResultReceiver();
        if (this.mEnterActivityOptions.isReturning()) {
            restoreExitedViews();
            activity.getWindow().getDecorView().setVisibility(0);
        }
        this.mEnterTransitionCoordinator = new EnterTransitionCoordinator(activity, resultReceiver, sharedElementNames, this.mEnterActivityOptions.isReturning());
        if (this.mIsEnterPostponed) {
            return;
        }
        startEnter();
    }

    public void onResume() {
        restoreExitedViews();
    }

    public void onStop() {
        restoreExitedViews();
        if (this.mEnterTransitionCoordinator != null) {
            this.mEnterTransitionCoordinator.stop();
            this.mEnterTransitionCoordinator = null;
        }
        if (this.mReturnExitCoordinator != null) {
            this.mReturnExitCoordinator.stop();
            this.mReturnExitCoordinator = null;
        }
    }

    public void postponeEnterTransition() {
        this.mIsEnterPostponed = true;
    }

    public void readState(Bundle bundle) {
        if (bundle != null) {
            if (this.mEnterTransitionCoordinator == null || this.mEnterTransitionCoordinator.isReturning()) {
                this.mEnteringNames = bundle.getStringArrayList(ENTERING_SHARED_ELEMENTS);
            }
            if (this.mEnterTransitionCoordinator == null) {
                this.mExitingFrom = bundle.getStringArrayList(EXITING_MAPPED_FROM);
                this.mExitingTo = bundle.getStringArrayList(EXITING_MAPPED_TO);
            }
        }
    }

    public void saveState(Bundle bundle) {
        if (this.mEnteringNames != null) {
            bundle.putStringArrayList(ENTERING_SHARED_ELEMENTS, this.mEnteringNames);
        }
        if (this.mExitingFrom != null) {
            bundle.putStringArrayList(EXITING_MAPPED_FROM, this.mExitingFrom);
            bundle.putStringArrayList(EXITING_MAPPED_TO, this.mExitingTo);
        }
    }

    public void setEnterActivityOptions(Activity activity, ActivityOptions activityOptions) {
        if (activity.getWindow().hasFeature(13) && activityOptions != null && this.mEnterActivityOptions == null && this.mEnterTransitionCoordinator == null && activityOptions.getAnimationType() == 5) {
            this.mEnterActivityOptions = activityOptions;
            this.mIsEnterTriggered = false;
            if (this.mEnterActivityOptions.isReturning()) {
                restoreExitedViews();
                int resultCode = this.mEnterActivityOptions.getResultCode();
                if (resultCode != 0) {
                    activity.onActivityReenter(resultCode, this.mEnterActivityOptions.getResultData());
                }
            }
        }
    }

    public boolean startExitBackTransition(final Activity activity) {
        boolean z = true;
        if (this.mEnteringNames == null) {
            z = false;
        } else if (!this.mHasExited) {
            this.mHasExited = true;
            Transition transition = null;
            ViewGroup viewGroup = null;
            boolean z2 = false;
            if (this.mEnterTransitionCoordinator != null) {
                Transition enterViewsTransition = this.mEnterTransitionCoordinator.getEnterViewsTransition();
                ViewGroup decor = this.mEnterTransitionCoordinator.getDecor();
                boolean cancelEnter = this.mEnterTransitionCoordinator.cancelEnter();
                this.mEnterTransitionCoordinator = null;
                viewGroup = decor;
                z2 = cancelEnter;
                transition = enterViewsTransition;
                if (enterViewsTransition != null) {
                    viewGroup = decor;
                    z2 = cancelEnter;
                    transition = enterViewsTransition;
                    if (decor != null) {
                        enterViewsTransition.pause(decor);
                        transition = enterViewsTransition;
                        z2 = cancelEnter;
                        viewGroup = decor;
                    }
                }
            }
            this.mReturnExitCoordinator = new ExitTransitionCoordinator(activity, this.mEnteringNames, null, null, true);
            if (transition != null && viewGroup != null) {
                transition.resume(viewGroup);
            }
            if (!z2 || viewGroup == null) {
                this.mReturnExitCoordinator.startExit(activity.mResultCode, activity.mResultData);
                return true;
            }
            final ViewGroup viewGroup2 = viewGroup;
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.ActivityTransitionState.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    viewGroup2.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (ActivityTransitionState.this.mReturnExitCoordinator != null) {
                        ActivityTransitionState.this.mReturnExitCoordinator.startExit(activity.mResultCode, activity.mResultData);
                        return true;
                    }
                    return true;
                }
            });
            return true;
        }
        return z;
    }

    public void startExitOutTransition(Activity activity, Bundle bundle) {
        if (activity.getWindow().hasFeature(13)) {
            ActivityOptions activityOptions = new ActivityOptions(bundle);
            this.mEnterTransitionCoordinator = null;
            if (activityOptions.getAnimationType() == 5) {
                int indexOfKey = this.mExitTransitionCoordinators.indexOfKey(activityOptions.getExitCoordinatorKey());
                if (indexOfKey >= 0) {
                    this.mCalledExitCoordinator = this.mExitTransitionCoordinators.valueAt(indexOfKey).get();
                    this.mExitTransitionCoordinators.removeAt(indexOfKey);
                    if (this.mCalledExitCoordinator != null) {
                        this.mExitingFrom = this.mCalledExitCoordinator.getAcceptedNames();
                        this.mExitingTo = this.mCalledExitCoordinator.getMappedNames();
                        this.mExitingToView = this.mCalledExitCoordinator.copyMappedViews();
                        this.mCalledExitCoordinator.startExit();
                    }
                }
            }
        }
    }

    public void startPostponedEnterTransition() {
        if (this.mIsEnterPostponed) {
            this.mIsEnterPostponed = false;
            if (this.mEnterTransitionCoordinator != null) {
                startEnter();
            }
        }
    }
}
