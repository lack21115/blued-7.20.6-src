package android.location;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/location/SettingInjectorService.class */
public abstract class SettingInjectorService extends Service {
    public static final String ACTION_INJECTED_SETTING_CHANGED = "android.location.InjectedSettingChanged";
    public static final String ACTION_SERVICE_INTENT = "android.location.SettingInjectorService";
    public static final String ATTRIBUTES_NAME = "injected-location-setting";
    public static final String ENABLED_KEY = "enabled";
    public static final String MESSENGER_KEY = "messenger";
    public static final String META_DATA_NAME = "android.location.SettingInjectorService";
    private static final String TAG = "SettingInjectorService";
    private final String mName;

    public SettingInjectorService(String str) {
        this.mName = str;
    }

    private void onHandleIntent(Intent intent) {
        try {
            sendStatus(intent, onGetEnabled());
        } catch (RuntimeException e) {
            sendStatus(intent, true);
            throw e;
        }
    }

    private void sendStatus(Intent intent, boolean z) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z);
        obtain.setData(bundle);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, this.mName + ": received " + intent + ", enabled=" + z + ", sending message: " + obtain);
        }
        try {
            ((Messenger) intent.getParcelableExtra(MESSENGER_KEY)).send(obtain);
        } catch (RemoteException e) {
            Log.e(TAG, this.mName + ": sending dynamic status failed", e);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    protected abstract boolean onGetEnabled();

    @Deprecated
    protected abstract String onGetSummary();

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        onHandleIntent(intent);
        stopSelf(i2);
        return 2;
    }
}
