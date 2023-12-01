package android.service.notification;

import android.app.INotificationManager;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.service.notification.IConditionProvider;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/ConditionProviderService.class */
public abstract class ConditionProviderService extends Service {
    public static final String SERVICE_INTERFACE = "android.service.notification.ConditionProviderService";
    private final String TAG = ConditionProviderService.class.getSimpleName() + "[" + getClass().getSimpleName() + "]";
    private final H mHandler = new H();
    private INotificationManager mNoMan;
    private Provider mProvider;

    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/ConditionProviderService$H.class */
    private final class H extends Handler {
        private static final int ON_CONNECTED = 1;
        private static final int ON_REQUEST_CONDITIONS = 2;
        private static final int ON_SUBSCRIBE = 3;
        private static final int ON_UNSUBSCRIBE = 4;

        private H() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1:
                        ConditionProviderService.this.onConnected();
                        return;
                    case 2:
                        ConditionProviderService.this.onRequestConditions(message.arg1);
                        return;
                    case 3:
                        ConditionProviderService.this.onSubscribe((Uri) message.obj);
                        return;
                    case 4:
                        ConditionProviderService.this.onUnsubscribe((Uri) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                Log.w(ConditionProviderService.this.TAG, "Error running " + ((String) null), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/ConditionProviderService$Provider.class */
    public final class Provider extends IConditionProvider.Stub {
        private Provider() {
        }

        @Override // android.service.notification.IConditionProvider
        public void onConnected() {
            ConditionProviderService.this.mHandler.obtainMessage(1).sendToTarget();
        }

        @Override // android.service.notification.IConditionProvider
        public void onRequestConditions(int i) {
            ConditionProviderService.this.mHandler.obtainMessage(2, i, 0).sendToTarget();
        }

        @Override // android.service.notification.IConditionProvider
        public void onSubscribe(Uri uri) {
            ConditionProviderService.this.mHandler.obtainMessage(3, uri).sendToTarget();
        }

        @Override // android.service.notification.IConditionProvider
        public void onUnsubscribe(Uri uri) {
            ConditionProviderService.this.mHandler.obtainMessage(4, uri).sendToTarget();
        }
    }

    private final INotificationManager getNotificationInterface() {
        if (this.mNoMan == null) {
            this.mNoMan = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        }
        return this.mNoMan;
    }

    private boolean isBound() {
        if (this.mProvider == null) {
            Log.w(this.TAG, "Condition provider service not yet bound.");
            return false;
        }
        return true;
    }

    public final void notifyCondition(Condition condition) {
        if (condition == null) {
            return;
        }
        notifyConditions(condition);
    }

    public final void notifyConditions(Condition... conditionArr) {
        if (!isBound() || conditionArr == null) {
            return;
        }
        try {
            getNotificationInterface().notifyConditions(getPackageName(), this.mProvider, conditionArr);
        } catch (RemoteException e) {
            Log.v(this.TAG, "Unable to contact notification manager", e);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mProvider == null) {
            this.mProvider = new Provider();
        }
        return this.mProvider;
    }

    public abstract void onConnected();

    public abstract void onRequestConditions(int i);

    public abstract void onSubscribe(Uri uri);

    public abstract void onUnsubscribe(Uri uri);
}
