package android.app.trust;

import android.app.trust.ITrustListener;
import android.app.trust.ITrustManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/app/trust/TrustManager.class */
public class TrustManager {
    private static final String DATA_INITIATED_BY_USER = "initiatedByUser";
    private static final int MSG_TRUST_CHANGED = 1;
    private static final int MSG_TRUST_MANAGED_CHANGED = 2;
    private static final String TAG = "TrustManager";
    private final ITrustManager mService;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: android.app.trust.TrustManager.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            boolean z2 = true;
            switch (message.what) {
                case 1:
                    boolean z3 = message.peekData() != null && message.peekData().getBoolean(TrustManager.DATA_INITIATED_BY_USER);
                    TrustListener trustListener = (TrustListener) message.obj;
                    if (message.arg1 == 0) {
                        z2 = false;
                    }
                    trustListener.onTrustChanged(z2, message.arg2, z3);
                    return;
                case 2:
                    TrustListener trustListener2 = (TrustListener) message.obj;
                    if (message.arg1 == 0) {
                        z = false;
                    }
                    trustListener2.onTrustManagedChanged(z, message.arg2);
                    return;
                default:
                    return;
            }
        }
    };
    private final ArrayMap<TrustListener, ITrustListener> mTrustListeners = new ArrayMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/app/trust/TrustManager$TrustListener.class */
    public interface TrustListener {
        void onTrustChanged(boolean z, int i, boolean z2);

        void onTrustManagedChanged(boolean z, int i);
    }

    public TrustManager(IBinder iBinder) {
        this.mService = ITrustManager.Stub.asInterface(iBinder);
    }

    private void onError(Exception exc) {
        Log.e(TAG, "Error while calling TrustManagerService", exc);
    }

    public void registerTrustListener(final TrustListener trustListener) {
        try {
            ITrustListener.Stub stub = new ITrustListener.Stub() { // from class: android.app.trust.TrustManager.1
                @Override // android.app.trust.ITrustListener
                public void onTrustChanged(boolean z, int i, boolean z2) {
                    Message obtainMessage = TrustManager.this.mHandler.obtainMessage(1, z ? 1 : 0, i, trustListener);
                    if (z2) {
                        obtainMessage.getData().putBoolean(TrustManager.DATA_INITIATED_BY_USER, z2);
                    }
                    obtainMessage.sendToTarget();
                }

                @Override // android.app.trust.ITrustListener
                public void onTrustManagedChanged(boolean z, int i) {
                    TrustManager.this.mHandler.obtainMessage(2, z ? 1 : 0, i, trustListener).sendToTarget();
                }
            };
            this.mService.registerTrustListener(stub);
            this.mTrustListeners.put(trustListener, stub);
        } catch (RemoteException e) {
            onError(e);
        }
    }

    public void reportEnabledTrustAgentsChanged(int i) {
        try {
            this.mService.reportEnabledTrustAgentsChanged(i);
        } catch (RemoteException e) {
            onError(e);
        }
    }

    public void reportKeyguardShowingChanged() {
        try {
            this.mService.reportKeyguardShowingChanged();
        } catch (RemoteException e) {
            onError(e);
        }
    }

    public void reportRequireCredentialEntry(int i) {
        try {
            this.mService.reportRequireCredentialEntry(i);
        } catch (RemoteException e) {
            onError(e);
        }
    }

    public void reportUnlockAttempt(boolean z, int i) {
        try {
            this.mService.reportUnlockAttempt(z, i);
        } catch (RemoteException e) {
            onError(e);
        }
    }

    public void unregisterTrustListener(TrustListener trustListener) {
        ITrustListener remove = this.mTrustListeners.remove(trustListener);
        if (remove != null) {
            try {
                this.mService.unregisterTrustListener(remove);
            } catch (RemoteException e) {
                onError(e);
            }
        }
    }
}
