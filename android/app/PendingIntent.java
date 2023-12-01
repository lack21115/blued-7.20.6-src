package android.app;

import android.content.Context;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.AndroidException;

/* loaded from: source-9557208-dex2jar.jar:android/app/PendingIntent.class */
public final class PendingIntent implements Parcelable {
    public static final Parcelable.Creator<PendingIntent> CREATOR = new Parcelable.Creator<PendingIntent>() { // from class: android.app.PendingIntent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PendingIntent createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new PendingIntent(readStrongBinder);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PendingIntent[] newArray(int i) {
            return new PendingIntent[i];
        }
    };
    public static final int FLAG_CANCEL_CURRENT = 268435456;
    public static final int FLAG_NO_CREATE = 536870912;
    public static final int FLAG_ONE_SHOT = 1073741824;
    public static final int FLAG_UPDATE_CURRENT = 134217728;
    private final IIntentSender mTarget;

    /* loaded from: source-9557208-dex2jar.jar:android/app/PendingIntent$CanceledException.class */
    public static class CanceledException extends AndroidException {
        public CanceledException() {
        }

        public CanceledException(Exception exc) {
            super(exc);
        }

        public CanceledException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/PendingIntent$FinishedDispatcher.class */
    public static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        private final Handler mHandler;
        private Intent mIntent;
        private final PendingIntent mPendingIntent;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        private final OnFinished mWho;

        FinishedDispatcher(PendingIntent pendingIntent, OnFinished onFinished, Handler handler) {
            this.mPendingIntent = pendingIntent;
            this.mWho = onFinished;
            this.mHandler = handler;
        }

        @Override // android.content.IIntentReceiver
        public void performReceive(Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2) {
            this.mIntent = intent;
            this.mResultCode = i;
            this.mResultData = str;
            this.mResultExtras = bundle;
            if (this.mHandler == null) {
                run();
            } else {
                this.mHandler.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mWho.onSendFinished(this.mPendingIntent, this.mIntent, this.mResultCode, this.mResultData, this.mResultExtras);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/PendingIntent$OnFinished.class */
    public interface OnFinished {
        void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingIntent(IIntentSender iIntentSender) {
        this.mTarget = iIntentSender;
    }

    PendingIntent(IBinder iBinder) {
        this.mTarget = IIntentSender.Stub.asInterface(iBinder);
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        return getActivities(context, i, intentArr, i2, null);
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle) {
        String packageName = context.getPackageName();
        String[] strArr = new String[intentArr.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= intentArr.length) {
                try {
                    break;
                } catch (RemoteException e) {
                    return null;
                }
            }
            intentArr[i4].migrateExtraStreamToClipData();
            intentArr[i4].prepareToLeaveProcess();
            strArr[i4] = intentArr[i4].resolveTypeIfNeeded(context.getContentResolver());
            i3 = i4 + 1;
        }
        IIntentSender intentSender = ActivityManagerNative.getDefault().getIntentSender(2, packageName, null, null, i, intentArr, strArr, i2, bundle, UserHandle.myUserId());
        if (intentSender != null) {
            return new PendingIntent(intentSender);
        }
        return null;
    }

    public static PendingIntent getActivitiesAsUser(Context context, int i, Intent[] intentArr, int i2, Bundle bundle, UserHandle userHandle) {
        String packageName = context.getPackageName();
        String[] strArr = new String[intentArr.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= intentArr.length) {
                try {
                    break;
                } catch (RemoteException e) {
                    return null;
                }
            }
            intentArr[i4].migrateExtraStreamToClipData();
            intentArr[i4].prepareToLeaveProcess();
            strArr[i4] = intentArr[i4].resolveTypeIfNeeded(context.getContentResolver());
            i3 = i4 + 1;
        }
        IIntentSender intentSender = ActivityManagerNative.getDefault().getIntentSender(2, packageName, null, null, i, intentArr, strArr, i2, bundle, userHandle.getIdentifier());
        if (intentSender != null) {
            return new PendingIntent(intentSender);
        }
        return null;
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2) {
        return getActivity(context, i, intent, i2, null);
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle) {
        String[] strArr;
        String packageName = context.getPackageName();
        String resolveTypeIfNeeded = intent != null ? intent.resolveTypeIfNeeded(context.getContentResolver()) : null;
        try {
            intent.migrateExtraStreamToClipData();
            intent.prepareToLeaveProcess();
            IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            if (resolveTypeIfNeeded != null) {
                String[] strArr2 = new String[1];
                strArr2[0] = resolveTypeIfNeeded;
                strArr = strArr2;
            } else {
                strArr = null;
            }
            IIntentSender intentSender = iActivityManager.getIntentSender(2, packageName, null, null, i, new Intent[]{intent}, strArr, i2, bundle, UserHandle.myUserId());
            if (intentSender != null) {
                return new PendingIntent(intentSender);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public static PendingIntent getActivityAsUser(Context context, int i, Intent intent, int i2, Bundle bundle, UserHandle userHandle) {
        String[] strArr;
        String packageName = context.getPackageName();
        String resolveTypeIfNeeded = intent != null ? intent.resolveTypeIfNeeded(context.getContentResolver()) : null;
        try {
            intent.migrateExtraStreamToClipData();
            intent.prepareToLeaveProcess();
            IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            if (resolveTypeIfNeeded != null) {
                String[] strArr2 = new String[1];
                strArr2[0] = resolveTypeIfNeeded;
                strArr = strArr2;
            } else {
                strArr = null;
            }
            IIntentSender intentSender = iActivityManager.getIntentSender(2, packageName, null, null, i, new Intent[]{intent}, strArr, i2, bundle, userHandle.getIdentifier());
            if (intentSender != null) {
                return new PendingIntent(intentSender);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int i2) {
        return getBroadcastAsUser(context, i, intent, i2, new UserHandle(UserHandle.myUserId()));
    }

    public static PendingIntent getBroadcastAsUser(Context context, int i, Intent intent, int i2, UserHandle userHandle) {
        String[] strArr;
        String packageName = context.getPackageName();
        String resolveTypeIfNeeded = intent != null ? intent.resolveTypeIfNeeded(context.getContentResolver()) : null;
        try {
            intent.prepareToLeaveProcess();
            IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            if (resolveTypeIfNeeded != null) {
                String[] strArr2 = new String[1];
                strArr2[0] = resolveTypeIfNeeded;
                strArr = strArr2;
            } else {
                strArr = null;
            }
            IIntentSender intentSender = iActivityManager.getIntentSender(1, packageName, null, null, i, new Intent[]{intent}, strArr, i2, null, userHandle.getIdentifier());
            if (intentSender != null) {
                return new PendingIntent(intentSender);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public static PendingIntent getService(Context context, int i, Intent intent, int i2) {
        String[] strArr;
        String packageName = context.getPackageName();
        String resolveTypeIfNeeded = intent != null ? intent.resolveTypeIfNeeded(context.getContentResolver()) : null;
        try {
            intent.prepareToLeaveProcess();
            IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            if (resolveTypeIfNeeded != null) {
                String[] strArr2 = new String[1];
                strArr2[0] = resolveTypeIfNeeded;
                strArr = strArr2;
            } else {
                strArr = null;
            }
            IIntentSender intentSender = iActivityManager.getIntentSender(4, packageName, null, null, i, new Intent[]{intent}, strArr, i2, null, UserHandle.myUserId());
            if (intentSender != null) {
                return new PendingIntent(intentSender);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public static PendingIntent readPendingIntentOrNullFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new PendingIntent(readStrongBinder);
        }
        return null;
    }

    public static void writePendingIntentOrNullToParcel(PendingIntent pendingIntent, Parcel parcel) {
        parcel.writeStrongBinder(pendingIntent != null ? pendingIntent.mTarget.asBinder() : null);
    }

    public void cancel() {
        try {
            ActivityManagerNative.getDefault().cancelIntentSender(this.mTarget);
        } catch (RemoteException e) {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PendingIntent) {
            return this.mTarget.asBinder().equals(((PendingIntent) obj).mTarget.asBinder());
        }
        return false;
    }

    public String getCreatorPackage() {
        try {
            return ActivityManagerNative.getDefault().getPackageForIntentSender(this.mTarget);
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getCreatorUid() {
        try {
            return ActivityManagerNative.getDefault().getUidForIntentSender(this.mTarget);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public UserHandle getCreatorUserHandle() {
        try {
            int uidForIntentSender = ActivityManagerNative.getDefault().getUidForIntentSender(this.mTarget);
            if (uidForIntentSender > 0) {
                return new UserHandle(UserHandle.getUserId(uidForIntentSender));
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public Intent getIntent() {
        try {
            return ActivityManagerNative.getDefault().getIntentForIntentSender(this.mTarget);
        } catch (RemoteException e) {
            return null;
        }
    }

    public IntentSender getIntentSender() {
        return new IntentSender(this.mTarget);
    }

    public String getTag(String str) {
        try {
            return ActivityManagerNative.getDefault().getTagForIntentSender(this.mTarget, str);
        } catch (RemoteException e) {
            return null;
        }
    }

    public IIntentSender getTarget() {
        return this.mTarget;
    }

    @Deprecated
    public String getTargetPackage() {
        try {
            return ActivityManagerNative.getDefault().getPackageForIntentSender(this.mTarget);
        } catch (RemoteException e) {
            return null;
        }
    }

    public int hashCode() {
        return this.mTarget.asBinder().hashCode();
    }

    public boolean isActivity() {
        try {
            return ActivityManagerNative.getDefault().isIntentSenderAnActivity(this.mTarget);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isTargetedToPackage() {
        try {
            return ActivityManagerNative.getDefault().isIntentSenderTargetedToPackage(this.mTarget);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
    }

    public void send(int i) throws CanceledException {
        send(null, i, null, null, null, null);
    }

    public void send(int i, OnFinished onFinished, Handler handler) throws CanceledException {
        send(null, i, null, onFinished, handler, null);
    }

    public void send(Context context, int i, Intent intent) throws CanceledException {
        send(context, i, intent, null, null, null);
    }

    public void send(Context context, int i, Intent intent, OnFinished onFinished, Handler handler) throws CanceledException {
        send(context, i, intent, onFinished, handler, null);
    }

    public void send(Context context, int i, Intent intent, OnFinished onFinished, Handler handler, String str) throws CanceledException {
        String resolveTypeIfNeeded;
        FinishedDispatcher finishedDispatcher = null;
        if (intent != null) {
            try {
                resolveTypeIfNeeded = intent.resolveTypeIfNeeded(context.getContentResolver());
            } catch (RemoteException e) {
                throw new CanceledException(e);
            }
        } else {
            resolveTypeIfNeeded = null;
        }
        IIntentSender iIntentSender = this.mTarget;
        if (onFinished != null) {
            finishedDispatcher = new FinishedDispatcher(this, onFinished, handler);
        }
        if (iIntentSender.send(i, intent, resolveTypeIfNeeded, finishedDispatcher, str) < 0) {
            throw new CanceledException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("PendingIntent{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(this.mTarget != null ? this.mTarget.asBinder() : null);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mTarget.asBinder());
    }
}
