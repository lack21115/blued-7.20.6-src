package android.bluetooth;

import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothHealth;
import android.bluetooth.IBluetoothHealthCallback;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHealth.class */
public final class BluetoothHealth implements BluetoothProfile {
    public static final int APP_CONFIG_REGISTRATION_FAILURE = 1;
    public static final int APP_CONFIG_REGISTRATION_SUCCESS = 0;
    public static final int APP_CONFIG_UNREGISTRATION_FAILURE = 3;
    public static final int APP_CONFIG_UNREGISTRATION_SUCCESS = 2;
    public static final int CHANNEL_TYPE_ANY = 12;
    public static final int CHANNEL_TYPE_RELIABLE = 10;
    public static final int CHANNEL_TYPE_STREAMING = 11;
    private static final boolean DBG = true;
    public static final int HEALTH_OPERATION_ERROR = 6001;
    public static final int HEALTH_OPERATION_GENERIC_FAILURE = 6003;
    public static final int HEALTH_OPERATION_INVALID_ARGS = 6002;
    public static final int HEALTH_OPERATION_NOT_ALLOWED = 6005;
    public static final int HEALTH_OPERATION_NOT_FOUND = 6004;
    public static final int HEALTH_OPERATION_SUCCESS = 6000;
    public static final int SINK_ROLE = 2;
    public static final int SOURCE_ROLE = 1;
    public static final int STATE_CHANNEL_CONNECTED = 2;
    public static final int STATE_CHANNEL_CONNECTING = 1;
    public static final int STATE_CHANNEL_DISCONNECTED = 0;
    public static final int STATE_CHANNEL_DISCONNECTING = 3;
    private static final String TAG = "BluetoothHealth";
    private static final boolean VDBG = false;
    private Context mContext;
    private IBluetoothHealth mService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private final IBluetoothStateChangeCallback mBluetoothStateChangeCallback = new IBluetoothStateChangeCallback.Stub() { // from class: android.bluetooth.BluetoothHealth.1
        @Override // android.bluetooth.IBluetoothStateChangeCallback
        public void onBluetoothStateChange(boolean z) {
            Log.d(BluetoothHealth.TAG, "onBluetoothStateChange: up=" + z);
            if (z) {
                synchronized (BluetoothHealth.this.mConnection) {
                    try {
                        if (BluetoothHealth.this.mService == null) {
                            BluetoothHealth.this.doBind();
                        }
                    } catch (Exception e) {
                        Log.e(BluetoothHealth.TAG, "", e);
                    }
                }
                return;
            }
            synchronized (BluetoothHealth.this.mConnection) {
                try {
                    BluetoothHealth.this.mService = null;
                    BluetoothHealth.this.mContext.unbindService(BluetoothHealth.this.mConnection);
                } catch (Exception e2) {
                    Log.e(BluetoothHealth.TAG, "", e2);
                }
            }
        }
    };
    private final ServiceConnection mConnection = new ServiceConnection() { // from class: android.bluetooth.BluetoothHealth.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(BluetoothHealth.TAG, "Proxy object connected");
            BluetoothHealth.this.mService = IBluetoothHealth.Stub.asInterface(iBinder);
            if (BluetoothHealth.this.mServiceListener != null) {
                BluetoothHealth.this.mServiceListener.onServiceConnected(3, BluetoothHealth.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(BluetoothHealth.TAG, "Proxy object disconnected");
            BluetoothHealth.this.mService = null;
            if (BluetoothHealth.this.mServiceListener != null) {
                BluetoothHealth.this.mServiceListener.onServiceDisconnected(3);
            }
        }
    };
    BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHealth$BluetoothHealthCallbackWrapper.class */
    public static class BluetoothHealthCallbackWrapper extends IBluetoothHealthCallback.Stub {
        private BluetoothHealthCallback mCallback;

        public BluetoothHealthCallbackWrapper(BluetoothHealthCallback bluetoothHealthCallback) {
            this.mCallback = bluetoothHealthCallback;
        }

        @Override // android.bluetooth.IBluetoothHealthCallback
        public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration, int i) {
            this.mCallback.onHealthAppConfigurationStatusChange(bluetoothHealthAppConfiguration, i);
        }

        @Override // android.bluetooth.IBluetoothHealthCallback
        public void onHealthChannelStateChange(BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration, BluetoothDevice bluetoothDevice, int i, int i2, ParcelFileDescriptor parcelFileDescriptor, int i3) {
            this.mCallback.onHealthChannelStateChange(bluetoothHealthAppConfiguration, bluetoothDevice, i, i2, parcelFileDescriptor, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothHealth(Context context, BluetoothProfile.ServiceListener serviceListener) {
        this.mContext = context;
        this.mServiceListener = serviceListener;
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.registerStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
            }
        }
        doBind();
    }

    private boolean checkAppParam(String str, int i, int i2, BluetoothHealthCallback bluetoothHealthCallback) {
        if (str != null) {
            if (i == 1 || i == 2) {
                if ((i2 == 10 || i2 == 11 || i2 == 12) && bluetoothHealthCallback != null) {
                    return (i == 1 && i2 == 12) ? false : true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean isEnabled() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            log("Bluetooth is Not enabled");
            return false;
        }
        return true;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress());
    }

    private static void log(String str) {
        Log.d(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.unregisterStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (Exception e) {
                Log.e(TAG, "", e);
            }
        }
        synchronized (this.mConnection) {
            if (this.mService != null) {
                try {
                    this.mService = null;
                    this.mContext.unbindService(this.mConnection);
                } catch (Exception e2) {
                    Log.e(TAG, "", e2);
                }
            }
        }
        this.mServiceListener = null;
    }

    public boolean connectChannelToSink(BluetoothDevice bluetoothDevice, BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration, int i) {
        if (this.mService == null || !isEnabled() || !isValidDevice(bluetoothDevice) || bluetoothHealthAppConfiguration == null) {
            Log.w(TAG, "Proxy not attached to service");
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
            return false;
        }
        try {
            return this.mService.connectChannelToSink(bluetoothDevice, bluetoothHealthAppConfiguration, i);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean connectChannelToSource(BluetoothDevice bluetoothDevice, BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration) {
        if (this.mService == null || !isEnabled() || !isValidDevice(bluetoothDevice) || bluetoothHealthAppConfiguration == null) {
            Log.w(TAG, "Proxy not attached to service");
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
            return false;
        }
        try {
            return this.mService.connectChannelToSource(bluetoothDevice, bluetoothHealthAppConfiguration);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean disconnectChannel(BluetoothDevice bluetoothDevice, BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration, int i) {
        if (this.mService == null || !isEnabled() || !isValidDevice(bluetoothDevice) || bluetoothHealthAppConfiguration == null) {
            Log.w(TAG, "Proxy not attached to service");
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
            return false;
        }
        try {
            return this.mService.disconnectChannel(bluetoothDevice, bluetoothHealthAppConfiguration, i);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    boolean doBind() {
        Intent intent = new Intent(IBluetoothHealth.class.getName());
        ComponentName resolveSystemService = intent.resolveSystemService(this.mContext.getPackageManager(), 0);
        intent.setComponent(resolveSystemService);
        if (resolveSystemService == null || !this.mContext.bindServiceAsUser(intent, this.mConnection, 0, Process.myUserHandle())) {
            Log.e(TAG, "Could not bind to Bluetooth Health Service with " + intent);
            return false;
        }
        return true;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        if (this.mService == null || !isEnabled()) {
            if (this.mService == null) {
                Log.w(TAG, "Proxy not attached to service");
            }
            return new ArrayList();
        }
        try {
            return this.mService.getConnectedHealthDevices();
        } catch (RemoteException e) {
            Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            return new ArrayList();
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        if (this.mService == null || !isEnabled() || !isValidDevice(bluetoothDevice)) {
            Log.w(TAG, "Proxy not attached to service");
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
            return 0;
        }
        try {
            return this.mService.getHealthDeviceConnectionState(bluetoothDevice);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        if (this.mService == null || !isEnabled()) {
            if (this.mService == null) {
                Log.w(TAG, "Proxy not attached to service");
            }
            return new ArrayList();
        }
        try {
            return this.mService.getHealthDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException e) {
            Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            return new ArrayList();
        }
    }

    public ParcelFileDescriptor getMainChannelFd(BluetoothDevice bluetoothDevice, BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration) {
        if (this.mService == null || !isEnabled() || !isValidDevice(bluetoothDevice) || bluetoothHealthAppConfiguration == null) {
            Log.w(TAG, "Proxy not attached to service");
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
            return null;
        }
        try {
            return this.mService.getMainChannelFd(bluetoothDevice, bluetoothHealthAppConfiguration);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public boolean registerAppConfiguration(String str, int i, int i2, int i3, BluetoothHealthCallback bluetoothHealthCallback) {
        boolean z = false;
        if (isEnabled() && checkAppParam(str, i2, i3, bluetoothHealthCallback)) {
            BluetoothHealthCallbackWrapper bluetoothHealthCallbackWrapper = new BluetoothHealthCallbackWrapper(bluetoothHealthCallback);
            BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration = new BluetoothHealthAppConfiguration(str, i, i2, i3);
            if (this.mService != null) {
                try {
                    z = this.mService.registerAppConfiguration(bluetoothHealthAppConfiguration, bluetoothHealthCallbackWrapper);
                } catch (RemoteException e) {
                    Log.e(TAG, e.toString());
                }
            } else {
                Log.w(TAG, "Proxy not attached to service");
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            }
            return z;
        }
        return false;
    }

    public boolean registerSinkAppConfiguration(String str, int i, BluetoothHealthCallback bluetoothHealthCallback) {
        if (!isEnabled() || str == null) {
            return false;
        }
        return registerAppConfiguration(str, i, 2, 12, bluetoothHealthCallback);
    }

    public boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration) {
        if (this.mService == null || !isEnabled() || bluetoothHealthAppConfiguration == null) {
            Log.w(TAG, "Proxy not attached to service");
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
            return false;
        }
        try {
            return this.mService.unregisterAppConfiguration(bluetoothHealthAppConfiguration);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }
}
