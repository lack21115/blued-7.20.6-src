package android.app;

import android.app.IActivityContainerCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.SurfaceTexture;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import dalvik.system.CloseGuard;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityView.class */
public class ActivityView extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final String TAG = "ActivityView";
    private Activity mActivity;
    private ActivityContainerWrapper mActivityContainer;
    private ActivityViewCallback mActivityViewCallback;
    private int mHeight;
    private int mLastVisibility;
    DisplayMetrics mMetrics;
    Intent mQueuedIntent;
    IIntentSender mQueuedPendingIntent;
    private Surface mSurface;
    private final TextureView mTextureView;
    private int mWidth;

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityView$ActivityContainerCallback.class */
    private static class ActivityContainerCallback extends IActivityContainerCallback.Stub {
        private final WeakReference<ActivityView> mActivityViewWeakReference;

        ActivityContainerCallback(ActivityView activityView) {
            this.mActivityViewWeakReference = new WeakReference<>(activityView);
        }

        @Override // android.app.IActivityContainerCallback
        public void onAllActivitiesComplete(IBinder iBinder) {
            final ActivityViewCallback activityViewCallback;
            final ActivityView activityView = this.mActivityViewWeakReference.get();
            if (activityView == null || (activityViewCallback = activityView.mActivityViewCallback) == null) {
                return;
            }
            activityView.post(new Runnable() { // from class: android.app.ActivityView.ActivityContainerCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    activityViewCallback.onAllActivitiesComplete(activityView);
                }
            });
        }

        @Override // android.app.IActivityContainerCallback
        public void setVisible(IBinder iBinder, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityView$ActivityContainerWrapper.class */
    public static class ActivityContainerWrapper {
        private final IActivityContainer mIActivityContainer;
        private final CloseGuard mGuard = CloseGuard.get();
        boolean mOpened = true;

        ActivityContainerWrapper(IActivityContainer iActivityContainer) {
            this.mIActivityContainer = iActivityContainer;
            this.mGuard.open("release");
        }

        void attachToDisplay(int i) {
            try {
                this.mIActivityContainer.attachToDisplay(i);
            } catch (RemoteException e) {
            }
        }

        void checkEmbeddedAllowed(Intent intent) {
            try {
                this.mIActivityContainer.checkEmbeddedAllowed(intent);
            } catch (RemoteException e) {
                throw new RuntimeException("ActivityView: Unable to startActivity from Intent. " + e);
            }
        }

        void checkEmbeddedAllowedIntentSender(IIntentSender iIntentSender) {
            try {
                this.mIActivityContainer.checkEmbeddedAllowedIntentSender(iIntentSender);
            } catch (RemoteException e) {
                throw new RuntimeException("ActivityView: Unable to startActivity from IntentSender. " + e);
            }
        }

        protected void finalize() throws Throwable {
            try {
                if (this.mGuard != null) {
                    this.mGuard.warnIfOpen();
                    release();
                }
            } finally {
                super.finalize();
            }
        }

        int getDisplayId() {
            try {
                return this.mIActivityContainer.getDisplayId();
            } catch (RemoteException e) {
                return -1;
            }
        }

        boolean injectEvent(InputEvent inputEvent) {
            try {
                return this.mIActivityContainer.injectEvent(inputEvent);
            } catch (RemoteException e) {
                return false;
            }
        }

        void release() {
            synchronized (this.mGuard) {
                if (this.mOpened) {
                    try {
                        this.mIActivityContainer.release();
                        this.mGuard.close();
                    } catch (RemoteException e) {
                    }
                    this.mOpened = false;
                }
            }
        }

        void setSurface(Surface surface, int i, int i2, int i3) throws RemoteException {
            this.mIActivityContainer.setSurface(surface, i, i2, i3);
        }

        int startActivity(Intent intent) {
            try {
                return this.mIActivityContainer.startActivity(intent);
            } catch (RemoteException e) {
                throw new RuntimeException("ActivityView: Unable to startActivity. " + e);
            }
        }

        int startActivityIntentSender(IIntentSender iIntentSender) {
            try {
                return this.mIActivityContainer.startActivityIntentSender(iIntentSender);
            } catch (RemoteException e) {
                throw new RuntimeException("ActivityView: Unable to startActivity from IntentSender. " + e);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityView$ActivityViewCallback.class */
    public static abstract class ActivityViewCallback {
        public abstract void onAllActivitiesComplete(ActivityView activityView);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityView$ActivityViewSurfaceTextureListener.class */
    private class ActivityViewSurfaceTextureListener implements TextureView.SurfaceTextureListener {
        private ActivityViewSurfaceTextureListener() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (ActivityView.this.mActivityContainer == null) {
                return;
            }
            ActivityView.this.mWidth = i;
            ActivityView.this.mHeight = i2;
            ActivityView.this.attachToSurfaceWhenReady();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (ActivityView.this.mActivityContainer == null) {
                return true;
            }
            ActivityView.this.mSurface.release();
            ActivityView.this.mSurface = null;
            try {
                ActivityView.this.mActivityContainer.setSurface(null, ActivityView.this.mWidth, ActivityView.this.mHeight, ActivityView.this.mMetrics.densityDpi);
                return true;
            } catch (RemoteException e) {
                throw new RuntimeException("ActivityView: Unable to set surface of ActivityContainer. " + e);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (ActivityView.this.mActivityContainer == null) {
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public ActivityView(Context context) {
        this(context, null);
    }

    public ActivityView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (this.mActivity == null) {
            throw new IllegalStateException("The ActivityView's Context is not an Activity.");
        }
        try {
            this.mActivityContainer = new ActivityContainerWrapper(ActivityManagerNative.getDefault().createActivityContainer(this.mActivity.getActivityToken(), new ActivityContainerCallback(this)));
            this.mTextureView = new TextureView(context);
            this.mTextureView.setSurfaceTextureListener(new ActivityViewSurfaceTextureListener());
            addView(this.mTextureView);
            this.mMetrics = new DisplayMetrics();
            ((WindowManager) this.mActivity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(this.mMetrics);
            this.mLastVisibility = getVisibility();
        } catch (RemoteException e) {
            throw new RuntimeException("ActivityView: Unable to create ActivityContainer. " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachToSurfaceWhenReady() {
        SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
        if (surfaceTexture == null || this.mSurface != null) {
            return;
        }
        this.mSurface = new Surface(surfaceTexture);
        try {
            this.mActivityContainer.setSurface(this.mSurface, this.mWidth, this.mHeight, this.mMetrics.densityDpi);
            if (this.mQueuedIntent != null) {
                this.mActivityContainer.startActivity(this.mQueuedIntent);
                this.mQueuedIntent = null;
            } else if (this.mQueuedPendingIntent != null) {
                this.mActivityContainer.startActivityIntentSender(this.mQueuedPendingIntent);
                this.mQueuedPendingIntent = null;
            }
        } catch (RemoteException e) {
            this.mSurface.release();
            this.mSurface = null;
            throw new RuntimeException("ActivityView: Unable to create ActivityContainer. " + e);
        }
    }

    private boolean injectInputEvent(InputEvent inputEvent) {
        return this.mActivityContainer != null && this.mActivityContainer.injectEvent(inputEvent);
    }

    public boolean isAttachedToDisplay() {
        return this.mSurface != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.isFromSource(2) && injectInputEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mTextureView.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectInputEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.mSurface != null) {
            try {
                if (i == 8) {
                    this.mActivityContainer.setSurface(null, this.mWidth, this.mHeight, this.mMetrics.densityDpi);
                } else if (this.mLastVisibility == 8) {
                    this.mActivityContainer.setSurface(this.mSurface, this.mWidth, this.mHeight, this.mMetrics.densityDpi);
                }
            } catch (RemoteException e) {
                throw new RuntimeException("ActivityView: Unable to set surface of ActivityContainer. " + e);
            }
        }
        this.mLastVisibility = i;
    }

    public void release() {
        if (this.mActivityContainer == null) {
            Log.e(TAG, "Duplicate call to release");
            return;
        }
        this.mActivityContainer.release();
        this.mActivityContainer = null;
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        this.mTextureView.setSurfaceTextureListener(null);
    }

    public void setCallback(ActivityViewCallback activityViewCallback) {
        this.mActivityViewCallback = activityViewCallback;
    }

    public void startActivity(PendingIntent pendingIntent) {
        if (this.mActivityContainer == null) {
            throw new IllegalStateException("Attempt to call startActivity after release");
        }
        IIntentSender target = pendingIntent.getTarget();
        if (this.mSurface != null) {
            this.mActivityContainer.startActivityIntentSender(target);
            return;
        }
        this.mActivityContainer.checkEmbeddedAllowedIntentSender(target);
        this.mQueuedPendingIntent = target;
        this.mQueuedIntent = null;
    }

    public void startActivity(Intent intent) {
        if (this.mActivityContainer == null) {
            throw new IllegalStateException("Attempt to call startActivity after release");
        }
        if (this.mSurface != null) {
            this.mActivityContainer.startActivity(intent);
            return;
        }
        this.mActivityContainer.checkEmbeddedAllowed(intent);
        this.mQueuedIntent = intent;
        this.mQueuedPendingIntent = null;
    }

    public void startActivity(IntentSender intentSender) {
        if (this.mActivityContainer == null) {
            throw new IllegalStateException("Attempt to call startActivity after release");
        }
        IIntentSender target = intentSender.getTarget();
        if (this.mSurface != null) {
            this.mActivityContainer.startActivityIntentSender(target);
            return;
        }
        this.mActivityContainer.checkEmbeddedAllowedIntentSender(target);
        this.mQueuedPendingIntent = target;
        this.mQueuedIntent = null;
    }
}
