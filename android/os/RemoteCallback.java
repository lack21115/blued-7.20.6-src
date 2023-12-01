package android.os;

import android.os.IRemoteCallback;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/os/RemoteCallback.class */
public abstract class RemoteCallback implements Parcelable {
    public static final Parcelable.Creator<RemoteCallback> CREATOR = new Parcelable.Creator<RemoteCallback>() { // from class: android.os.RemoteCallback.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteCallback createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new RemoteCallbackProxy(IRemoteCallback.Stub.asInterface(readStrongBinder));
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteCallback[] newArray(int i) {
            return new RemoteCallback[i];
        }
    };
    final Handler mHandler;
    final IRemoteCallback mTarget;

    /* loaded from: source-9557208-dex2jar.jar:android/os/RemoteCallback$DeliverResult.class */
    class DeliverResult implements Runnable {
        final Bundle mResult;

        DeliverResult(Bundle bundle) {
            this.mResult = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteCallback.this.onResult(this.mResult);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/RemoteCallback$LocalCallback.class */
    class LocalCallback extends IRemoteCallback.Stub {
        LocalCallback() {
        }

        @Override // android.os.IRemoteCallback
        public void sendResult(Bundle bundle) {
            RemoteCallback.this.mHandler.post(new DeliverResult(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/RemoteCallback$RemoteCallbackProxy.class */
    public static class RemoteCallbackProxy extends RemoteCallback {
        RemoteCallbackProxy(IRemoteCallback iRemoteCallback) {
            super(iRemoteCallback);
        }

        @Override // android.os.RemoteCallback
        protected void onResult(Bundle bundle) {
        }
    }

    public RemoteCallback(Handler handler) {
        this.mHandler = handler;
        this.mTarget = new LocalCallback();
    }

    RemoteCallback(IRemoteCallback iRemoteCallback) {
        this.mHandler = null;
        this.mTarget = iRemoteCallback;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.mTarget.asBinder().equals(((RemoteCallback) obj).mTarget.asBinder());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.mTarget.asBinder().hashCode();
    }

    protected abstract void onResult(Bundle bundle);

    public void sendResult(Bundle bundle) throws RemoteException {
        this.mTarget.sendResult(bundle);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mTarget.asBinder());
    }
}
