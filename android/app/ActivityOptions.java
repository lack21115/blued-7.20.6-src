package android.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityOptions.class */
public class ActivityOptions {
    public static final int ANIM_CUSTOM = 1;
    public static final int ANIM_CUSTOM_IN_PLACE = 10;
    public static final int ANIM_DEFAULT = 6;
    public static final int ANIM_LAUNCH_TASK_BEHIND = 7;
    public static final int ANIM_NONE = 0;
    public static final int ANIM_SCALE_UP = 2;
    public static final int ANIM_SCENE_TRANSITION = 5;
    public static final int ANIM_THUMBNAIL_ASPECT_SCALE_DOWN = 9;
    public static final int ANIM_THUMBNAIL_ASPECT_SCALE_UP = 8;
    public static final int ANIM_THUMBNAIL_SCALE_DOWN = 4;
    public static final int ANIM_THUMBNAIL_SCALE_UP = 3;
    public static final String KEY_ANIM_ENTER_RES_ID = "android:animEnterRes";
    public static final String KEY_ANIM_EXIT_RES_ID = "android:animExitRes";
    public static final String KEY_ANIM_HEIGHT = "android:animHeight";
    public static final String KEY_ANIM_IN_PLACE_RES_ID = "android:animInPlaceRes";
    public static final String KEY_ANIM_START_LISTENER = "android:animStartListener";
    public static final String KEY_ANIM_START_X = "android:animStartX";
    public static final String KEY_ANIM_START_Y = "android:animStartY";
    public static final String KEY_ANIM_THUMBNAIL = "android:animThumbnail";
    public static final String KEY_ANIM_TYPE = "android:animType";
    public static final String KEY_ANIM_WIDTH = "android:animWidth";
    private static final String KEY_EXIT_COORDINATOR_INDEX = "android:exitCoordinatorIndex";
    public static final String KEY_PACKAGE_NAME = "android:packageName";
    private static final String KEY_RESULT_CODE = "android:resultCode";
    private static final String KEY_RESULT_DATA = "android:resultData";
    private static final String KEY_TRANSITION_COMPLETE_LISTENER = "android:transitionCompleteListener";
    private static final String KEY_TRANSITION_IS_RETURNING = "android:transitionIsReturning";
    private static final String KEY_TRANSITION_SHARED_ELEMENTS = "android:sharedElementNames";
    private static final String TAG = "ActivityOptions";
    private IRemoteCallback mAnimationStartedListener;
    private int mAnimationType;
    private int mCustomEnterResId;
    private int mCustomExitResId;
    private int mCustomInPlaceResId;
    private int mExitCoordinatorIndex;
    private int mHeight;
    private boolean mIsReturning;
    private String mPackageName;
    private int mResultCode;
    private Intent mResultData;
    private ArrayList<String> mSharedElementNames;
    private int mStartX;
    private int mStartY;
    private Bitmap mThumbnail;
    private ResultReceiver mTransitionReceiver;
    private int mWidth;

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityOptions$OnAnimationStartedListener.class */
    public interface OnAnimationStartedListener {
        void onAnimationStarted();
    }

    private ActivityOptions() {
        this.mAnimationType = 0;
    }

    public ActivityOptions(Bundle bundle) {
        this.mAnimationType = 0;
        this.mPackageName = bundle.getString(KEY_PACKAGE_NAME);
        this.mAnimationType = bundle.getInt(KEY_ANIM_TYPE);
        switch (this.mAnimationType) {
            case 1:
                this.mCustomEnterResId = bundle.getInt(KEY_ANIM_ENTER_RES_ID, 0);
                this.mCustomExitResId = bundle.getInt(KEY_ANIM_EXIT_RES_ID, 0);
                this.mAnimationStartedListener = IRemoteCallback.Stub.asInterface(bundle.getBinder(KEY_ANIM_START_LISTENER));
                return;
            case 2:
                this.mStartX = bundle.getInt(KEY_ANIM_START_X, 0);
                this.mStartY = bundle.getInt(KEY_ANIM_START_Y, 0);
                this.mWidth = bundle.getInt(KEY_ANIM_WIDTH, 0);
                this.mHeight = bundle.getInt(KEY_ANIM_HEIGHT, 0);
                return;
            case 3:
            case 4:
            case 8:
            case 9:
                this.mThumbnail = (Bitmap) bundle.getParcelable(KEY_ANIM_THUMBNAIL);
                this.mStartX = bundle.getInt(KEY_ANIM_START_X, 0);
                this.mStartY = bundle.getInt(KEY_ANIM_START_Y, 0);
                this.mWidth = bundle.getInt(KEY_ANIM_WIDTH, 0);
                this.mHeight = bundle.getInt(KEY_ANIM_HEIGHT, 0);
                this.mAnimationStartedListener = IRemoteCallback.Stub.asInterface(bundle.getBinder(KEY_ANIM_START_LISTENER));
                return;
            case 5:
                this.mTransitionReceiver = (ResultReceiver) bundle.getParcelable(KEY_TRANSITION_COMPLETE_LISTENER);
                this.mIsReturning = bundle.getBoolean(KEY_TRANSITION_IS_RETURNING, false);
                this.mSharedElementNames = bundle.getStringArrayList(KEY_TRANSITION_SHARED_ELEMENTS);
                this.mResultData = (Intent) bundle.getParcelable(KEY_RESULT_DATA);
                this.mResultCode = bundle.getInt(KEY_RESULT_CODE);
                this.mExitCoordinatorIndex = bundle.getInt(KEY_EXIT_COORDINATOR_INDEX);
                return;
            case 6:
            case 7:
            default:
                return;
            case 10:
                this.mCustomInPlaceResId = bundle.getInt(KEY_ANIM_IN_PLACE_RES_ID, 0);
                return;
        }
    }

    public static void abort(Bundle bundle) {
        if (bundle != null) {
            new ActivityOptions(bundle).abort();
        }
    }

    private static ActivityOptions makeAspectScaledThumbnailAnimation(View view, Bitmap bitmap, int i, int i2, int i3, int i4, Handler handler, OnAnimationStartedListener onAnimationStartedListener, boolean z) {
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mPackageName = view.getContext().getPackageName();
        activityOptions.mAnimationType = z ? 8 : 9;
        activityOptions.mThumbnail = bitmap;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        activityOptions.mStartX = iArr[0] + i;
        activityOptions.mStartY = iArr[1] + i2;
        activityOptions.mWidth = i3;
        activityOptions.mHeight = i4;
        activityOptions.setOnAnimationStartedListener(handler, onAnimationStartedListener);
        return activityOptions;
    }

    public static ActivityOptions makeCustomAnimation(Context context, int i, int i2) {
        return makeCustomAnimation(context, i, i2, null, null);
    }

    public static ActivityOptions makeCustomAnimation(Context context, int i, int i2, Handler handler, OnAnimationStartedListener onAnimationStartedListener) {
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mPackageName = context.getPackageName();
        activityOptions.mAnimationType = 1;
        activityOptions.mCustomEnterResId = i;
        activityOptions.mCustomExitResId = i2;
        activityOptions.setOnAnimationStartedListener(handler, onAnimationStartedListener);
        return activityOptions;
    }

    public static ActivityOptions makeCustomInPlaceAnimation(Context context, int i) {
        if (i == 0) {
            throw new RuntimeException("You must specify a valid animation.");
        }
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mPackageName = context.getPackageName();
        activityOptions.mAnimationType = 10;
        activityOptions.mCustomInPlaceResId = i;
        return activityOptions;
    }

    public static ActivityOptions makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mPackageName = view.getContext().getPackageName();
        activityOptions.mAnimationType = 2;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        activityOptions.mStartX = iArr[0] + i;
        activityOptions.mStartY = iArr[1] + i2;
        activityOptions.mWidth = i3;
        activityOptions.mHeight = i4;
        return activityOptions;
    }

    public static ActivityOptions makeSceneTransitionAnimation(Activity activity, ExitTransitionCoordinator exitTransitionCoordinator, ArrayList<String> arrayList, int i, Intent intent) {
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mAnimationType = 5;
        activityOptions.mSharedElementNames = arrayList;
        activityOptions.mTransitionReceiver = exitTransitionCoordinator;
        activityOptions.mIsReturning = true;
        activityOptions.mResultCode = i;
        activityOptions.mResultData = intent;
        activityOptions.mExitCoordinatorIndex = activity.mActivityTransitionState.addExitTransitionCoordinator(exitTransitionCoordinator);
        return activityOptions;
    }

    public static ActivityOptions makeSceneTransitionAnimation(Activity activity, View view, String str) {
        return makeSceneTransitionAnimation(activity, Pair.create(view, str));
    }

    public static ActivityOptions makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        ActivityOptions activityOptions = new ActivityOptions();
        if (!activity.getWindow().hasFeature(13)) {
            activityOptions.mAnimationType = 6;
            return activityOptions;
        }
        activityOptions.mAnimationType = 5;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (pairArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pairArr.length) {
                    break;
                }
                Pair<View, String> pair = pairArr[i2];
                String str = pair.second;
                if (str == null) {
                    throw new IllegalArgumentException("Shared element name must not be null");
                }
                arrayList.add(str);
                if (pair.first == null) {
                    throw new IllegalArgumentException("Shared element must not be null");
                }
                arrayList2.add(pair.first);
                i = i2 + 1;
            }
        }
        ExitTransitionCoordinator exitTransitionCoordinator = new ExitTransitionCoordinator(activity, arrayList, arrayList, arrayList2, false);
        activityOptions.mTransitionReceiver = exitTransitionCoordinator;
        activityOptions.mSharedElementNames = arrayList;
        activityOptions.mIsReturning = false;
        activityOptions.mExitCoordinatorIndex = activity.mActivityTransitionState.addExitTransitionCoordinator(exitTransitionCoordinator);
        return activityOptions;
    }

    public static ActivityOptions makeTaskLaunchBehind() {
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mAnimationType = 7;
        return activityOptions;
    }

    private static ActivityOptions makeThumbnailAnimation(View view, Bitmap bitmap, int i, int i2, OnAnimationStartedListener onAnimationStartedListener, boolean z) {
        ActivityOptions activityOptions = new ActivityOptions();
        activityOptions.mPackageName = view.getContext().getPackageName();
        activityOptions.mAnimationType = z ? 3 : 4;
        activityOptions.mThumbnail = bitmap;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        activityOptions.mStartX = iArr[0] + i;
        activityOptions.mStartY = iArr[1] + i2;
        activityOptions.setOnAnimationStartedListener(view.getHandler(), onAnimationStartedListener);
        return activityOptions;
    }

    public static ActivityOptions makeThumbnailAspectScaleDownAnimation(View view, Bitmap bitmap, int i, int i2, int i3, int i4, Handler handler, OnAnimationStartedListener onAnimationStartedListener) {
        return makeAspectScaledThumbnailAnimation(view, bitmap, i, i2, i3, i4, handler, onAnimationStartedListener, false);
    }

    public static ActivityOptions makeThumbnailAspectScaleUpAnimation(View view, Bitmap bitmap, int i, int i2, int i3, int i4, Handler handler, OnAnimationStartedListener onAnimationStartedListener) {
        return makeAspectScaledThumbnailAnimation(view, bitmap, i, i2, i3, i4, handler, onAnimationStartedListener, true);
    }

    public static ActivityOptions makeThumbnailScaleDownAnimation(View view, Bitmap bitmap, int i, int i2, OnAnimationStartedListener onAnimationStartedListener) {
        return makeThumbnailAnimation(view, bitmap, i, i2, onAnimationStartedListener, false);
    }

    public static ActivityOptions makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        return makeThumbnailScaleUpAnimation(view, bitmap, i, i2, null);
    }

    public static ActivityOptions makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2, OnAnimationStartedListener onAnimationStartedListener) {
        return makeThumbnailAnimation(view, bitmap, i, i2, onAnimationStartedListener, true);
    }

    private void setOnAnimationStartedListener(final Handler handler, final OnAnimationStartedListener onAnimationStartedListener) {
        if (onAnimationStartedListener != null) {
            this.mAnimationStartedListener = new IRemoteCallback.Stub() { // from class: android.app.ActivityOptions.1
                @Override // android.os.IRemoteCallback
                public void sendResult(Bundle bundle) throws RemoteException {
                    handler.post(new Runnable() { // from class: android.app.ActivityOptions.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            onAnimationStartedListener.onAnimationStarted();
                        }
                    });
                }
            };
        }
    }

    public void abort() {
        if (this.mAnimationStartedListener != null) {
            try {
                this.mAnimationStartedListener.sendResult(null);
            } catch (RemoteException e) {
            }
        }
    }

    public ActivityOptions forTargetActivity() {
        if (this.mAnimationType == 5) {
            ActivityOptions activityOptions = new ActivityOptions();
            activityOptions.update(this);
            return activityOptions;
        }
        return null;
    }

    public int getAnimationType() {
        return this.mAnimationType;
    }

    public int getCustomEnterResId() {
        return this.mCustomEnterResId;
    }

    public int getCustomExitResId() {
        return this.mCustomExitResId;
    }

    public int getCustomInPlaceResId() {
        return this.mCustomInPlaceResId;
    }

    public int getExitCoordinatorKey() {
        return this.mExitCoordinatorIndex;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean getLaunchTaskBehind() {
        return this.mAnimationType == 7;
    }

    public IRemoteCallback getOnAnimationStartListener() {
        return this.mAnimationStartedListener;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public Intent getResultData() {
        return this.mResultData;
    }

    public ResultReceiver getResultReceiver() {
        return this.mTransitionReceiver;
    }

    public ArrayList<String> getSharedElementNames() {
        return this.mSharedElementNames;
    }

    public int getStartX() {
        return this.mStartX;
    }

    public int getStartY() {
        return this.mStartY;
    }

    public Bitmap getThumbnail() {
        return this.mThumbnail;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isReturning() {
        return this.mIsReturning;
    }

    public Bundle toBundle() {
        IBinder iBinder = null;
        if (this.mAnimationType == 6) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.mPackageName != null) {
            bundle.putString(KEY_PACKAGE_NAME, this.mPackageName);
        }
        bundle.putInt(KEY_ANIM_TYPE, this.mAnimationType);
        switch (this.mAnimationType) {
            case 1:
                bundle.putInt(KEY_ANIM_ENTER_RES_ID, this.mCustomEnterResId);
                bundle.putInt(KEY_ANIM_EXIT_RES_ID, this.mCustomExitResId);
                if (this.mAnimationStartedListener != null) {
                    iBinder = this.mAnimationStartedListener.asBinder();
                }
                bundle.putBinder(KEY_ANIM_START_LISTENER, iBinder);
                break;
            case 2:
                bundle.putInt(KEY_ANIM_START_X, this.mStartX);
                bundle.putInt(KEY_ANIM_START_Y, this.mStartY);
                bundle.putInt(KEY_ANIM_WIDTH, this.mWidth);
                bundle.putInt(KEY_ANIM_HEIGHT, this.mHeight);
                break;
            case 3:
            case 4:
            case 8:
            case 9:
                bundle.putParcelable(KEY_ANIM_THUMBNAIL, this.mThumbnail);
                bundle.putInt(KEY_ANIM_START_X, this.mStartX);
                bundle.putInt(KEY_ANIM_START_Y, this.mStartY);
                bundle.putInt(KEY_ANIM_WIDTH, this.mWidth);
                bundle.putInt(KEY_ANIM_HEIGHT, this.mHeight);
                IBinder iBinder2 = null;
                if (this.mAnimationStartedListener != null) {
                    iBinder2 = this.mAnimationStartedListener.asBinder();
                }
                bundle.putBinder(KEY_ANIM_START_LISTENER, iBinder2);
                break;
            case 5:
                if (this.mTransitionReceiver != null) {
                    bundle.putParcelable(KEY_TRANSITION_COMPLETE_LISTENER, this.mTransitionReceiver);
                }
                bundle.putBoolean(KEY_TRANSITION_IS_RETURNING, this.mIsReturning);
                bundle.putStringArrayList(KEY_TRANSITION_SHARED_ELEMENTS, this.mSharedElementNames);
                bundle.putParcelable(KEY_RESULT_DATA, this.mResultData);
                bundle.putInt(KEY_RESULT_CODE, this.mResultCode);
                bundle.putInt(KEY_EXIT_COORDINATOR_INDEX, this.mExitCoordinatorIndex);
                break;
            case 10:
                bundle.putInt(KEY_ANIM_IN_PLACE_RES_ID, this.mCustomInPlaceResId);
                break;
        }
        return bundle;
    }

    public void update(ActivityOptions activityOptions) {
        if (activityOptions.mPackageName != null) {
            this.mPackageName = activityOptions.mPackageName;
        }
        this.mTransitionReceiver = null;
        this.mSharedElementNames = null;
        this.mIsReturning = false;
        this.mResultData = null;
        this.mResultCode = 0;
        this.mExitCoordinatorIndex = 0;
        this.mAnimationType = activityOptions.mAnimationType;
        switch (activityOptions.mAnimationType) {
            case 1:
                this.mCustomEnterResId = activityOptions.mCustomEnterResId;
                this.mCustomExitResId = activityOptions.mCustomExitResId;
                this.mThumbnail = null;
                if (this.mAnimationStartedListener != null) {
                    try {
                        this.mAnimationStartedListener.sendResult(null);
                    } catch (RemoteException e) {
                    }
                }
                this.mAnimationStartedListener = activityOptions.mAnimationStartedListener;
                return;
            case 2:
                this.mStartX = activityOptions.mStartX;
                this.mStartY = activityOptions.mStartY;
                this.mWidth = activityOptions.mWidth;
                this.mHeight = activityOptions.mHeight;
                if (this.mAnimationStartedListener != null) {
                    try {
                        this.mAnimationStartedListener.sendResult(null);
                    } catch (RemoteException e2) {
                    }
                }
                this.mAnimationStartedListener = null;
                return;
            case 3:
            case 4:
            case 8:
            case 9:
                this.mThumbnail = activityOptions.mThumbnail;
                this.mStartX = activityOptions.mStartX;
                this.mStartY = activityOptions.mStartY;
                this.mWidth = activityOptions.mWidth;
                this.mHeight = activityOptions.mHeight;
                if (this.mAnimationStartedListener != null) {
                    try {
                        this.mAnimationStartedListener.sendResult(null);
                    } catch (RemoteException e3) {
                    }
                }
                this.mAnimationStartedListener = activityOptions.mAnimationStartedListener;
                return;
            case 5:
                this.mTransitionReceiver = activityOptions.mTransitionReceiver;
                this.mSharedElementNames = activityOptions.mSharedElementNames;
                this.mIsReturning = activityOptions.mIsReturning;
                this.mThumbnail = null;
                this.mAnimationStartedListener = null;
                this.mResultData = activityOptions.mResultData;
                this.mResultCode = activityOptions.mResultCode;
                this.mExitCoordinatorIndex = activityOptions.mExitCoordinatorIndex;
                return;
            case 6:
            case 7:
            default:
                return;
            case 10:
                this.mCustomInPlaceResId = activityOptions.mCustomInPlaceResId;
                return;
        }
    }
}
