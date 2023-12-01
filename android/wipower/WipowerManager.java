package android.wipower;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import android.wipower.IWipower;
import android.wipower.IWipowerManagerCallback;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/wipower/WipowerManager.class */
public final class WipowerManager {
    private static final boolean DBG = true;
    private static final String TAG = "WipowerManager";
    private static final boolean VDBG = false;
    private static ArrayList<WipowerManagerCallback> mCallbacks;
    private static WipowerDynamicParam mPruData;
    private static IWipower mService;
    private static WipowerState mState;
    private static WipowerManager mWipowerManager;
    private final IWipowerManagerCallback mWiPowerMangerCallback = new IWipowerManagerCallback.Stub() { // from class: android.wipower.WipowerManager.1
        @Override // android.wipower.IWipowerManagerCallback
        public void onPowerApply(byte b) {
            WipowerManager.this.updatePowerApplyAlert(b == 1 ? PowerApplyEvent.ON : PowerApplyEvent.OFF);
        }

        @Override // android.wipower.IWipowerManagerCallback
        public void onWipowerAlert(byte b) {
            Log.v(WipowerManager.TAG, "onWipowerAlert: alert" + ((int) b));
            WipowerManager.this.updateWipowerAlert(b);
        }

        @Override // android.wipower.IWipowerManagerCallback
        public void onWipowerData(byte[] bArr) {
            Log.v(WipowerManager.TAG, "onWipowerData: " + bArr);
            if (WipowerManager.mPruData == null) {
                Log.e(WipowerManager.TAG, "mPruData is null");
                return;
            }
            WipowerManager.mPruData.setValue(bArr);
            WipowerManager.this.updateWipowerData(WipowerManager.mPruData);
        }

        @Override // android.wipower.IWipowerManagerCallback
        public void onWipowerStateChange(int i) {
            WipowerState wipowerState = i == 1 ? WipowerState.ON : WipowerState.OFF;
            Log.v(WipowerManager.TAG, "onWipowerStateChange: state" + i);
            WipowerManager.this.updateWipowerState(wipowerState);
        }
    };
    private ServiceConnection mConnection = new ServiceConnection() { // from class: android.wipower.WipowerManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IWipower unused = WipowerManager.mService = IWipower.Stub.asInterface(iBinder);
            Log.v(WipowerManager.TAG, "Proxy object connected: " + WipowerManager.mService);
            try {
                WipowerManager.mService.registerCallback(WipowerManager.this.mWiPowerMangerCallback);
            } catch (RemoteException e) {
                Log.e(WipowerManager.TAG, "not able to register as client");
            }
            Log.v(WipowerManager.TAG, "Calling onWipowerReady");
            WipowerManager.this.updateWipowerReady();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.v(WipowerManager.TAG, "Proxy object disconnected");
            try {
                WipowerManager.mService.unregisterCallback(WipowerManager.this.mWiPowerMangerCallback);
            } catch (RemoteException e) {
                Log.e(WipowerManager.TAG, "not able to unregister as client");
            }
            IWipower unused = WipowerManager.mService = null;
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:android/wipower/WipowerManager$PowerApplyEvent.class */
    public enum PowerApplyEvent {
        OFF,
        ON
    }

    /* loaded from: source-4181928-dex2jar.jar:android/wipower/WipowerManager$PowerLevel.class */
    public enum PowerLevel {
        POWER_LEVEL_MAXIMUM,
        POWER_LEVEL_MEDIUM,
        POWER_LEVEL_MINIMUM,
        POWER_LEVEL_UNKNOWN
    }

    /* loaded from: source-4181928-dex2jar.jar:android/wipower/WipowerManager$WipowerState.class */
    public enum WipowerState {
        OFF,
        ON
    }

    private WipowerManager(Context context, WipowerManagerCallback wipowerManagerCallback) {
        if (mService == null) {
            try {
                Intent intent = new Intent(IWipower.class.getName());
                ComponentName resolveSystemService = intent.resolveSystemService(context.getPackageManager(), 0);
                intent.setComponent(resolveSystemService);
                if (resolveSystemService == null || !context.bindService(intent, this.mConnection, 1)) {
                    Log.e(TAG, "Could not bind to Wipower Service");
                }
            } catch (SecurityException e) {
                Log.e(TAG, "Security Exception");
            }
        }
        Log.v(TAG, "Bound to Wipower Service");
        mPruData = new WipowerDynamicParam();
        mCallbacks = new ArrayList<>();
    }

    public static WipowerManager getWipowerManger(Context context, WipowerManagerCallback wipowerManagerCallback) {
        WipowerManager wipowerManager;
        synchronized (WipowerManager.class) {
            try {
                if (isWipowerSupported()) {
                    if (mWipowerManager == null) {
                        Log.v(TAG, "Instantiate Singleton");
                        mWipowerManager = new WipowerManager(context.getApplicationContext(), wipowerManagerCallback);
                    }
                    wipowerManager = mWipowerManager;
                } else {
                    Log.e(TAG, "Wipower not supported");
                    wipowerManager = null;
                }
            } finally {
            }
        }
        return wipowerManager;
    }

    static boolean isWipowerSupported() {
        if (SystemProperties.getBoolean("ro.bluetooth.a4wp", false)) {
            Log.v(TAG, "System.getProperty is true");
            return true;
        }
        Log.v(TAG, "System.getProperty is false");
        return false;
    }

    public boolean enableAlertNotification(boolean z) {
        if (mService == null) {
            Log.e(TAG, "Service  not available");
            return false;
        }
        try {
            return mService.enableAlert(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Service  Exception");
            return false;
        }
    }

    public boolean enableDataNotification(boolean z) {
        if (mService == null) {
            Log.e(TAG, "Service  not available");
            return false;
        }
        try {
            return mService.enableData(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Service  Exceptione");
            return false;
        }
    }

    public boolean enablePowerApply(boolean z, boolean z2, boolean z3) {
        Log.v(TAG, "enablePowerApply: enable: " + z + " on: " + z2 + " time_flag:" + z3);
        if (mService == null) {
            Log.e(TAG, "Service  not available");
            return false;
        }
        try {
            return mService.enablePowerApply(z, z2, z3);
        } catch (RemoteException e) {
            Log.e(TAG, "Service  Exceptione");
            return false;
        }
    }

    public PowerLevel getPowerLevel() {
        PowerLevel powerLevel = PowerLevel.POWER_LEVEL_UNKNOWN;
        if (mService == null) {
            Log.e(TAG, " Wipower Service not available");
        } else {
            byte b = 0;
            try {
                b = mService.getCurrentLimit();
            } catch (RemoteException e) {
                Log.e(TAG, "Service  Exceptione");
            }
            if (b == 0) {
                return PowerLevel.POWER_LEVEL_MINIMUM;
            }
            if (b == 1) {
                return PowerLevel.POWER_LEVEL_MEDIUM;
            }
            if (b == 2) {
                return PowerLevel.POWER_LEVEL_MAXIMUM;
            }
        }
        return powerLevel;
    }

    public WipowerState getState() {
        WipowerState wipowerState = WipowerState.OFF;
        if (mService == null) {
            Log.e(TAG, " Wipower Service not available");
            return wipowerState;
        }
        int i = 0;
        try {
            i = mService.getState();
        } catch (RemoteException e) {
            Log.e(TAG, "Service  Exceptione");
        }
        return i == 0 ? WipowerState.OFF : WipowerState.ON;
    }

    public void registerCallback(WipowerManagerCallback wipowerManagerCallback) {
        if (mService == null) {
            Log.e(TAG, "registerCallback:Service  not available");
        }
        mCallbacks.add(wipowerManagerCallback);
    }

    public boolean setPowerLevel(PowerLevel powerLevel) {
        boolean z = false;
        if (!isWipowerSupported()) {
            Log.e(TAG, "Wipower not supported");
            return false;
        }
        if (mService == null) {
            Log.e(TAG, " Wipower Service not available");
        } else {
            byte b = 0;
            if (powerLevel == PowerLevel.POWER_LEVEL_MINIMUM) {
                b = 2;
            } else if (powerLevel == PowerLevel.POWER_LEVEL_MEDIUM) {
                b = 1;
            } else if (powerLevel == PowerLevel.POWER_LEVEL_MAXIMUM) {
                b = 0;
            }
            try {
                z = mService.setCurrentLimit(b);
            } catch (RemoteException e) {
                Log.e(TAG, "Service  Exceptione");
            }
        }
        return z;
    }

    public boolean startCharging() {
        boolean z = false;
        if (!isWipowerSupported()) {
            Log.e(TAG, "Wipower not supported");
            return false;
        }
        if (mService == null) {
            Log.e(TAG, "startCharging: Service  not available");
        } else {
            try {
                z = mService.startCharging();
            } catch (RemoteException e) {
                Log.e(TAG, "Service  Exceptione");
            }
        }
        return z;
    }

    public boolean stopCharging() {
        boolean z = false;
        if (!isWipowerSupported()) {
            Log.e(TAG, "Wipower not supported");
            return false;
        }
        if (mService == null) {
            Log.e(TAG, " Wipower Service not available");
        } else {
            try {
                z = mService.stopCharging();
            } catch (RemoteException e) {
                Log.e(TAG, "Service  Exceptione");
            }
        }
        return z;
    }

    public void unregisterCallback(WipowerManagerCallback wipowerManagerCallback) {
        if (mService == null) {
            Log.e(TAG, "Service  not available");
        }
        mCallbacks.remove(wipowerManagerCallback);
    }

    void updatePowerApplyAlert(PowerApplyEvent powerApplyEvent) {
        if (mCallbacks == null) {
            return;
        }
        int size = mCallbacks.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            mCallbacks.get(i2).onPowerApply(powerApplyEvent);
            i = i2 + 1;
        }
    }

    void updateWipowerAlert(byte b) {
        if (mCallbacks == null) {
            return;
        }
        int size = mCallbacks.size();
        Log.v(TAG, "Broadcasting updateWipowerAlert() to " + size + " receivers.");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            mCallbacks.get(i2).onWipowerAlert(b);
            i = i2 + 1;
        }
    }

    void updateWipowerData(WipowerDynamicParam wipowerDynamicParam) {
        if (mCallbacks == null) {
            return;
        }
        int size = mCallbacks.size();
        Log.v(TAG, "Broadcasting updateWipowerData() to " + size + " receivers.");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            mCallbacks.get(i2).onWipowerData(wipowerDynamicParam);
            i = i2 + 1;
        }
    }

    void updateWipowerReady() {
        if (mCallbacks == null) {
            return;
        }
        int size = mCallbacks.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            mCallbacks.get(i2).onWipowerReady();
            i = i2 + 1;
        }
    }

    void updateWipowerState(WipowerState wipowerState) {
        if (mCallbacks == null) {
            return;
        }
        int size = mCallbacks.size();
        Log.v(TAG, "Broadcasting updateAdapterState() to " + size + " receivers.");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            mCallbacks.get(i2).onWipowerStateChange(wipowerState);
            i = i2 + 1;
        }
    }
}
