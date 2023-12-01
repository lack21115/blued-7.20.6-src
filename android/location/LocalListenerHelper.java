package android.location;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: source-9557208-dex2jar.jar:android/location/LocalListenerHelper.class */
abstract class LocalListenerHelper<TListener> {
    private final Context mContext;
    private final HashSet<TListener> mListeners = new HashSet<>();
    private final String mTag;

    /* loaded from: source-9557208-dex2jar.jar:android/location/LocalListenerHelper$ListenerOperation.class */
    protected interface ListenerOperation<TListener> {
        void execute(TListener tlistener) throws RemoteException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LocalListenerHelper(Context context, String str) {
        Preconditions.checkNotNull(str);
        this.mContext = context;
        this.mTag = str;
    }

    public boolean add(TListener tlistener) {
        Preconditions.checkNotNull(tlistener);
        synchronized (this.mListeners) {
            if (this.mListeners.isEmpty()) {
                try {
                    if (!registerWithServer()) {
                        Log.e(this.mTag, "Unable to register listener transport.");
                        return false;
                    }
                } catch (RemoteException e) {
                    Log.e(this.mTag, "Error handling first listener.", e);
                    return false;
                }
            }
            if (this.mListeners.contains(tlistener)) {
                return true;
            }
            return this.mListeners.add(tlistener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void foreach(ListenerOperation<TListener> listenerOperation) {
        ArrayList<Object> arrayList;
        synchronized (this.mListeners) {
            arrayList = new ArrayList(this.mListeners);
        }
        for (Object obj : arrayList) {
            try {
                listenerOperation.execute(obj);
            } catch (RemoteException e) {
                Log.e(this.mTag, "Error in monitored listener.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    protected abstract boolean registerWithServer() throws RemoteException;

    public void remove(TListener tlistener) {
        Preconditions.checkNotNull(tlistener);
        synchronized (this.mListeners) {
            if (this.mListeners.remove(tlistener) && this.mListeners.isEmpty()) {
                try {
                    unregisterFromServer();
                } catch (RemoteException e) {
                    Log.v(this.mTag, "Error handling last listener removal", e);
                }
            }
        }
    }

    protected abstract void unregisterFromServer() throws RemoteException;
}
