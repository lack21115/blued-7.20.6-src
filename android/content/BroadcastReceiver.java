package android.content;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.app.QueuedWork;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/content/BroadcastReceiver.class */
public abstract class BroadcastReceiver {
    private boolean mDebugUnregister;
    private PendingResult mPendingResult;

    /* loaded from: source-9557208-dex2jar.jar:android/content/BroadcastReceiver$PendingResult.class */
    public static class PendingResult {
        public static final int TYPE_COMPONENT = 0;
        public static final int TYPE_REGISTERED = 1;
        public static final int TYPE_UNREGISTERED = 2;
        boolean mAbortBroadcast;
        boolean mFinished;
        final int mFlags;
        final boolean mInitialStickyHint;
        final boolean mOrderedHint;
        int mResultCode;
        String mResultData;
        Bundle mResultExtras;
        final int mSendingUser;
        final IBinder mToken;
        final int mType;

        public PendingResult(int i, String str, Bundle bundle, int i2, boolean z, boolean z2, IBinder iBinder, int i3, int i4) {
            this.mResultCode = i;
            this.mResultData = str;
            this.mResultExtras = bundle;
            this.mType = i2;
            this.mOrderedHint = z;
            this.mInitialStickyHint = z2;
            this.mToken = iBinder;
            this.mSendingUser = i3;
            this.mFlags = i4;
        }

        public final void abortBroadcast() {
            checkSynchronousHint();
            this.mAbortBroadcast = true;
        }

        void checkSynchronousHint() {
            if (this.mOrderedHint || this.mInitialStickyHint) {
                return;
            }
            RuntimeException runtimeException = new RuntimeException("BroadcastReceiver trying to return result during a non-ordered broadcast");
            runtimeException.fillInStackTrace();
            Log.e("BroadcastReceiver", runtimeException.getMessage(), runtimeException);
        }

        public final void clearAbortBroadcast() {
            this.mAbortBroadcast = false;
        }

        public final void finish() {
            if (this.mType != 0) {
                if (!this.mOrderedHint || this.mType == 2) {
                    return;
                }
                sendFinished(ActivityManagerNative.getDefault());
                return;
            }
            final IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            if (QueuedWork.hasPendingWork()) {
                QueuedWork.singleThreadExecutor().execute(new Runnable() { // from class: android.content.BroadcastReceiver.PendingResult.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PendingResult.this.sendFinished(iActivityManager);
                    }
                });
            } else {
                sendFinished(iActivityManager);
            }
        }

        public final boolean getAbortBroadcast() {
            return this.mAbortBroadcast;
        }

        public final int getResultCode() {
            return this.mResultCode;
        }

        public final String getResultData() {
            return this.mResultData;
        }

        public final Bundle getResultExtras(boolean z) {
            Bundle bundle = this.mResultExtras;
            if (z) {
                Bundle bundle2 = bundle;
                if (bundle == null) {
                    bundle2 = new Bundle();
                    this.mResultExtras = bundle2;
                }
                return bundle2;
            }
            return bundle;
        }

        public int getSendingUserId() {
            return this.mSendingUser;
        }

        public void sendFinished(IActivityManager iActivityManager) {
            synchronized (this) {
                if (this.mFinished) {
                    throw new IllegalStateException("Broadcast already finished");
                }
                this.mFinished = true;
                try {
                    if (this.mResultExtras != null) {
                        this.mResultExtras.setAllowFds(false);
                    }
                    if (this.mOrderedHint) {
                        iActivityManager.finishReceiver(this.mToken, this.mResultCode, this.mResultData, this.mResultExtras, this.mAbortBroadcast, this.mFlags);
                    } else {
                        iActivityManager.finishReceiver(this.mToken, 0, null, null, false, this.mFlags);
                    }
                } catch (RemoteException e) {
                }
            }
        }

        public void setExtrasClassLoader(ClassLoader classLoader) {
            if (this.mResultExtras != null) {
                this.mResultExtras.setClassLoader(classLoader);
            }
        }

        public final void setResult(int i, String str, Bundle bundle) {
            checkSynchronousHint();
            this.mResultCode = i;
            this.mResultData = str;
            this.mResultExtras = bundle;
        }

        public final void setResultCode(int i) {
            checkSynchronousHint();
            this.mResultCode = i;
        }

        public final void setResultData(String str) {
            checkSynchronousHint();
            this.mResultData = str;
        }

        public final void setResultExtras(Bundle bundle) {
            checkSynchronousHint();
            this.mResultExtras = bundle;
        }
    }

    public final void abortBroadcast() {
        checkSynchronousHint();
        this.mPendingResult.mAbortBroadcast = true;
    }

    void checkSynchronousHint() {
        if (this.mPendingResult == null) {
            throw new IllegalStateException("Call while result is not pending");
        }
        if (this.mPendingResult.mOrderedHint || this.mPendingResult.mInitialStickyHint) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException("BroadcastReceiver trying to return result during a non-ordered broadcast");
        runtimeException.fillInStackTrace();
        Log.e("BroadcastReceiver", runtimeException.getMessage(), runtimeException);
    }

    public final void clearAbortBroadcast() {
        if (this.mPendingResult != null) {
            this.mPendingResult.mAbortBroadcast = false;
        }
    }

    public final boolean getAbortBroadcast() {
        if (this.mPendingResult != null) {
            return this.mPendingResult.mAbortBroadcast;
        }
        return false;
    }

    public final boolean getDebugUnregister() {
        return this.mDebugUnregister;
    }

    public final PendingResult getPendingResult() {
        return this.mPendingResult;
    }

    public final int getResultCode() {
        if (this.mPendingResult != null) {
            return this.mPendingResult.mResultCode;
        }
        return 0;
    }

    public final String getResultData() {
        if (this.mPendingResult != null) {
            return this.mPendingResult.mResultData;
        }
        return null;
    }

    public final Bundle getResultExtras(boolean z) {
        Bundle bundle;
        if (this.mPendingResult == null) {
            bundle = null;
        } else {
            Bundle bundle2 = this.mPendingResult.mResultExtras;
            bundle = bundle2;
            if (z) {
                bundle = bundle2;
                if (bundle2 == null) {
                    PendingResult pendingResult = this.mPendingResult;
                    Bundle bundle3 = new Bundle();
                    pendingResult.mResultExtras = bundle3;
                    return bundle3;
                }
            }
        }
        return bundle;
    }

    public String getSendingPackage(Intent intent) {
        try {
            return ActivityManagerNative.getDefault().getCallingPackageForBroadcast((intent.getFlags() & 268435456) != 0);
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getSendingUserId() {
        return this.mPendingResult.mSendingUser;
    }

    public final PendingResult goAsync() {
        PendingResult pendingResult = this.mPendingResult;
        this.mPendingResult = null;
        return pendingResult;
    }

    public final boolean isInitialStickyBroadcast() {
        if (this.mPendingResult != null) {
            return this.mPendingResult.mInitialStickyHint;
        }
        return false;
    }

    public final boolean isOrderedBroadcast() {
        if (this.mPendingResult != null) {
            return this.mPendingResult.mOrderedHint;
        }
        return false;
    }

    public abstract void onReceive(Context context, Intent intent);

    public IBinder peekService(Context context, Intent intent) {
        IActivityManager iActivityManager = ActivityManagerNative.getDefault();
        try {
            intent.prepareToLeaveProcess();
            return iActivityManager.peekService(intent, intent.resolveTypeIfNeeded(context.getContentResolver()));
        } catch (RemoteException e) {
            return null;
        }
    }

    public final void setDebugUnregister(boolean z) {
        this.mDebugUnregister = z;
    }

    public final void setOrderedHint(boolean z) {
    }

    public final void setPendingResult(PendingResult pendingResult) {
        this.mPendingResult = pendingResult;
    }

    public final void setResult(int i, String str, Bundle bundle) {
        checkSynchronousHint();
        this.mPendingResult.mResultCode = i;
        this.mPendingResult.mResultData = str;
        this.mPendingResult.mResultExtras = bundle;
    }

    public final void setResultCode(int i) {
        checkSynchronousHint();
        this.mPendingResult.mResultCode = i;
    }

    public final void setResultData(String str) {
        checkSynchronousHint();
        this.mPendingResult.mResultData = str;
    }

    public final void setResultExtras(Bundle bundle) {
        checkSynchronousHint();
        this.mPendingResult.mResultExtras = bundle;
    }
}
