package android.content;

import android.app.ActivityManagerNative;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.AndroidException;

/* loaded from: source-9557208-dex2jar.jar:android/content/IntentSender.class */
public class IntentSender implements Parcelable {
    public static final Parcelable.Creator<IntentSender> CREATOR = new Parcelable.Creator<IntentSender>() { // from class: android.content.IntentSender.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSender createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new IntentSender(readStrongBinder);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSender[] newArray(int i) {
            return new IntentSender[i];
        }
    };
    private final IIntentSender mTarget;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/IntentSender$FinishedDispatcher.class */
    public static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        private final Handler mHandler;
        private Intent mIntent;
        private final IntentSender mIntentSender;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        private final OnFinished mWho;

        FinishedDispatcher(IntentSender intentSender, OnFinished onFinished, Handler handler) {
            this.mIntentSender = intentSender;
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
            this.mWho.onSendFinished(this.mIntentSender, this.mIntent, this.mResultCode, this.mResultData, this.mResultExtras);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/IntentSender$OnFinished.class */
    public interface OnFinished {
        void onSendFinished(IntentSender intentSender, Intent intent, int i, String str, Bundle bundle);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/IntentSender$SendIntentException.class */
    public static class SendIntentException extends AndroidException {
        public SendIntentException() {
        }

        public SendIntentException(Exception exc) {
            super(exc);
        }

        public SendIntentException(String str) {
            super(str);
        }
    }

    public IntentSender(IIntentSender iIntentSender) {
        this.mTarget = iIntentSender;
    }

    public IntentSender(IBinder iBinder) {
        this.mTarget = IIntentSender.Stub.asInterface(iBinder);
    }

    public static IntentSender readIntentSenderOrNullFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new IntentSender(readStrongBinder);
        }
        return null;
    }

    public static void writeIntentSenderOrNullToParcel(IntentSender intentSender, Parcel parcel) {
        parcel.writeStrongBinder(intentSender != null ? intentSender.mTarget.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntentSender) {
            return this.mTarget.asBinder().equals(((IntentSender) obj).mTarget.asBinder());
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

    public void sendIntent(Context context, int i, Intent intent, OnFinished onFinished, Handler handler) throws SendIntentException {
        sendIntent(context, i, intent, onFinished, handler, null);
    }

    public void sendIntent(Context context, int i, Intent intent, OnFinished onFinished, Handler handler, String str) throws SendIntentException {
        String resolveTypeIfNeeded;
        FinishedDispatcher finishedDispatcher = null;
        if (intent != null) {
            try {
                resolveTypeIfNeeded = intent.resolveTypeIfNeeded(context.getContentResolver());
            } catch (RemoteException e) {
                throw new SendIntentException();
            }
        } else {
            resolveTypeIfNeeded = null;
        }
        IIntentSender iIntentSender = this.mTarget;
        if (onFinished != null) {
            finishedDispatcher = new FinishedDispatcher(this, onFinished, handler);
        }
        if (iIntentSender.send(i, intent, resolveTypeIfNeeded, finishedDispatcher, str) < 0) {
            throw new SendIntentException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("IntentSender{");
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
