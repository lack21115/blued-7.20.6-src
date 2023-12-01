package android.service.trust;

import android.Manifest;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.service.trust.ITrustAgentService;
import android.util.Log;
import android.util.Slog;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/trust/TrustAgentService.class */
public class TrustAgentService extends Service {
    private static final boolean DEBUG = false;
    private static final int MSG_CONFIGURE = 2;
    private static final int MSG_DEVICE_LOCKED = 4;
    private static final int MSG_DEVICE_UNLOCKED = 5;
    private static final int MSG_TRUST_TIMEOUT = 3;
    private static final int MSG_UNLOCK_ATTEMPT = 1;
    public static final String SERVICE_INTERFACE = "android.service.trust.TrustAgentService";
    public static final String TRUST_AGENT_META_DATA = "android.service.trust.trustagent";
    private ITrustAgentServiceCallback mCallback;
    private boolean mManagingTrust;
    private Runnable mPendingGrantTrustTask;
    private final String TAG = TrustAgentService.class.getSimpleName() + "[" + getClass().getSimpleName() + "]";
    private final Object mLock = new Object();
    private Handler mHandler = new Handler() { // from class: android.service.trust.TrustAgentService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    TrustAgentService.this.onUnlockAttempt(message.arg1 != 0);
                    return;
                case 2:
                    ConfigurationData configurationData = (ConfigurationData) message.obj;
                    boolean onConfigure = TrustAgentService.this.onConfigure(configurationData.options);
                    try {
                        synchronized (TrustAgentService.this.mLock) {
                            TrustAgentService.this.mCallback.onConfigureCompleted(onConfigure, configurationData.token);
                        }
                        return;
                    } catch (RemoteException e) {
                        TrustAgentService.this.onError("calling onSetTrustAgentFeaturesEnabledCompleted()");
                        return;
                    }
                case 3:
                    TrustAgentService.this.onTrustTimeout();
                    return;
                case 4:
                    TrustAgentService.this.onDeviceLocked();
                    return;
                case 5:
                    TrustAgentService.this.onDeviceUnlocked();
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/service/trust/TrustAgentService$ConfigurationData.class */
    private static final class ConfigurationData {
        final List<PersistableBundle> options;
        final IBinder token;

        ConfigurationData(List<PersistableBundle> list, IBinder iBinder) {
            this.options = list;
            this.token = iBinder;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/trust/TrustAgentService$TrustAgentServiceWrapper.class */
    private final class TrustAgentServiceWrapper extends ITrustAgentService.Stub {
        private TrustAgentServiceWrapper() {
        }

        @Override // android.service.trust.ITrustAgentService
        public void onConfigure(List<PersistableBundle> list, IBinder iBinder) {
            TrustAgentService.this.mHandler.obtainMessage(2, new ConfigurationData(list, iBinder)).sendToTarget();
        }

        @Override // android.service.trust.ITrustAgentService
        public void onDeviceLocked() throws RemoteException {
            TrustAgentService.this.mHandler.obtainMessage(4).sendToTarget();
        }

        @Override // android.service.trust.ITrustAgentService
        public void onDeviceUnlocked() throws RemoteException {
            TrustAgentService.this.mHandler.obtainMessage(5).sendToTarget();
        }

        @Override // android.service.trust.ITrustAgentService
        public void onTrustTimeout() {
            TrustAgentService.this.mHandler.sendEmptyMessage(3);
        }

        @Override // android.service.trust.ITrustAgentService
        public void onUnlockAttempt(boolean z) {
            TrustAgentService.this.mHandler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }

        @Override // android.service.trust.ITrustAgentService
        public void setCallback(ITrustAgentServiceCallback iTrustAgentServiceCallback) {
            synchronized (TrustAgentService.this.mLock) {
                TrustAgentService.this.mCallback = iTrustAgentServiceCallback;
                if (TrustAgentService.this.mManagingTrust) {
                    try {
                        TrustAgentService.this.mCallback.setManagingTrust(TrustAgentService.this.mManagingTrust);
                    } catch (RemoteException e) {
                        TrustAgentService.this.onError("calling setManagingTrust()");
                    }
                }
                if (TrustAgentService.this.mPendingGrantTrustTask != null) {
                    TrustAgentService.this.mPendingGrantTrustTask.run();
                    TrustAgentService.this.mPendingGrantTrustTask = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(String str) {
        Slog.v(this.TAG, "Remote exception while " + str);
    }

    public final void grantTrust(final CharSequence charSequence, final long j, final boolean z) {
        synchronized (this.mLock) {
            if (!this.mManagingTrust) {
                throw new IllegalStateException("Cannot grant trust if agent is not managing trust. Call setManagingTrust(true) first.");
            }
            if (this.mCallback != null) {
                try {
                    this.mCallback.grantTrust(charSequence.toString(), j, z);
                } catch (RemoteException e) {
                    onError("calling enableTrust()");
                }
            } else {
                this.mPendingGrantTrustTask = new Runnable() { // from class: android.service.trust.TrustAgentService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TrustAgentService.this.grantTrust(charSequence, j, z);
                    }
                };
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new TrustAgentServiceWrapper();
    }

    public boolean onConfigure(List<PersistableBundle> list) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ComponentName componentName = new ComponentName(this, getClass());
        try {
            if (Manifest.permission.BIND_TRUST_AGENT.equals(getPackageManager().getServiceInfo(componentName, 0).permission)) {
                return;
            }
            throw new IllegalStateException(componentName.flattenToShortString() + " is not declared with the permission \"" + Manifest.permission.BIND_TRUST_AGENT + "\"");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(this.TAG, "Can't get ServiceInfo for " + componentName.toShortString());
        }
    }

    public void onDeviceLocked() {
    }

    public void onDeviceUnlocked() {
    }

    public void onTrustTimeout() {
    }

    public void onUnlockAttempt(boolean z) {
    }

    public final void revokeTrust() {
        synchronized (this.mLock) {
            if (this.mPendingGrantTrustTask != null) {
                this.mPendingGrantTrustTask = null;
            }
            if (this.mCallback != null) {
                try {
                    this.mCallback.revokeTrust();
                } catch (RemoteException e) {
                    onError("calling revokeTrust()");
                }
            }
        }
    }

    public final void setManagingTrust(boolean z) {
        synchronized (this.mLock) {
            if (this.mManagingTrust != z) {
                this.mManagingTrust = z;
                if (this.mCallback != null) {
                    try {
                        this.mCallback.setManagingTrust(z);
                    } catch (RemoteException e) {
                        onError("calling setManagingTrust()");
                    }
                }
            }
        }
    }
}
