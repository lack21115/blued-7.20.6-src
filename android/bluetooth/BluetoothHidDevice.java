package android.bluetooth;

import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothHidDevice;
import android.bluetooth.IBluetoothHidDeviceCallback;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHidDevice.class */
public final class BluetoothHidDevice implements BluetoothProfile {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.hid.profile.action.CONNECTION_STATE_CHANGED";
    public static final byte ERROR_RSP_INVALID_PARAM = 4;
    public static final byte ERROR_RSP_INVALID_RPT_ID = 2;
    public static final byte ERROR_RSP_NOT_READY = 1;
    public static final byte ERROR_RSP_SUCCESS = 0;
    public static final byte ERROR_RSP_UNKNOWN = 14;
    public static final byte ERROR_RSP_UNSUPPORTED_REQ = 3;
    public static final byte PROTOCOL_BOOT_MODE = 0;
    public static final byte PROTOCOL_REPORT_MODE = 1;
    public static final byte REPORT_TYPE_FEATURE = 3;
    public static final byte REPORT_TYPE_INPUT = 1;
    public static final byte REPORT_TYPE_OUTPUT = 2;
    public static final byte SUBCLASS1_COMBO = -64;
    public static final byte SUBCLASS1_KEYBOARD = 64;
    public static final byte SUBCLASS1_MOUSE = Byte.MIN_VALUE;
    public static final byte SUBCLASS1_NONE = 0;
    public static final byte SUBCLASS2_CARD_READER = 6;
    public static final byte SUBCLASS2_DIGITIZER_TABLED = 5;
    public static final byte SUBCLASS2_GAMEPAD = 2;
    public static final byte SUBCLASS2_JOYSTICK = 1;
    public static final byte SUBCLASS2_REMOTE_CONTROL = 3;
    public static final byte SUBCLASS2_SENSING_DEVICE = 4;
    public static final byte SUBCLASS2_UNCATEGORIZED = 0;
    private static final String TAG = BluetoothHidDevice.class.getSimpleName();
    private BluetoothAdapter mAdapter;
    private final IBluetoothStateChangeCallback mBluetoothStateChangeCallback = new IBluetoothStateChangeCallback.Stub() { // from class: android.bluetooth.BluetoothHidDevice.1
        @Override // android.bluetooth.IBluetoothStateChangeCallback
        public void onBluetoothStateChange(boolean z) {
            Log.d(BluetoothHidDevice.TAG, "onBluetoothStateChange: up=" + z);
            synchronized (BluetoothHidDevice.this.mConnection) {
                if (z) {
                    try {
                        if (BluetoothHidDevice.this.mService == null) {
                            Log.d(BluetoothHidDevice.TAG, "Binding HID Device service...");
                            BluetoothHidDevice.this.doBind();
                        }
                    } catch (IllegalStateException e) {
                        Log.e(BluetoothHidDevice.TAG, "onBluetoothStateChange: could not bind to HID Dev service: ", e);
                    } catch (SecurityException e2) {
                        Log.e(BluetoothHidDevice.TAG, "onBluetoothStateChange: could not bind to HID Dev service: ", e2);
                    }
                } else {
                    Log.d(BluetoothHidDevice.TAG, "Unbinding service...");
                    if (BluetoothHidDevice.this.mService != null) {
                        BluetoothHidDevice.this.mService = null;
                        try {
                            BluetoothHidDevice.this.mContext.unbindService(BluetoothHidDevice.this.mConnection);
                        } catch (IllegalArgumentException e3) {
                            Log.e(BluetoothHidDevice.TAG, "onBluetoothStateChange: could not unbind service:", e3);
                        }
                    }
                }
            }
        }
    };
    private ServiceConnection mConnection = new ServiceConnection() { // from class: android.bluetooth.BluetoothHidDevice.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(BluetoothHidDevice.TAG, "onServiceConnected()");
            BluetoothHidDevice.this.mService = IBluetoothHidDevice.Stub.asInterface(iBinder);
            if (BluetoothHidDevice.this.mServiceListener != null) {
                BluetoothHidDevice.this.mServiceListener.onServiceConnected(17, BluetoothHidDevice.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(BluetoothHidDevice.TAG, "onServiceDisconnected()");
            BluetoothHidDevice.this.mService = null;
            if (BluetoothHidDevice.this.mServiceListener != null) {
                BluetoothHidDevice.this.mServiceListener.onServiceDisconnected(17);
            }
        }
    };
    private Context mContext;
    private IBluetoothHidDevice mService;
    private BluetoothProfile.ServiceListener mServiceListener;

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHidDevice$BluetoothHidDeviceCallbackWrapper.class */
    private static class BluetoothHidDeviceCallbackWrapper extends IBluetoothHidDeviceCallback.Stub {
        private BluetoothHidDeviceCallback mCallback;

        public BluetoothHidDeviceCallbackWrapper(BluetoothHidDeviceCallback bluetoothHidDeviceCallback) {
            this.mCallback = bluetoothHidDeviceCallback;
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onAppStatusChanged(BluetoothDevice bluetoothDevice, BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration, boolean z) {
            this.mCallback.onAppStatusChanged(bluetoothDevice, bluetoothHidDeviceAppConfiguration, z);
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, int i) {
            this.mCallback.onConnectionStateChanged(bluetoothDevice, i);
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onGetReport(byte b, byte b2, int i) {
            this.mCallback.onGetReport(b, b2, i);
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onIntrData(byte b, byte[] bArr) {
            this.mCallback.onIntrData(b, bArr);
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onSetProtocol(byte b) {
            this.mCallback.onSetProtocol(b);
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onSetReport(byte b, byte b2, byte[] bArr) {
            this.mCallback.onSetReport(b, b2, bArr);
        }

        @Override // android.bluetooth.IBluetoothHidDeviceCallback
        public void onVirtualCableUnplug() {
            this.mCallback.onVirtualCableUnplug();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothHidDevice(Context context, BluetoothProfile.ServiceListener serviceListener) {
        Log.v(TAG, "BluetoothHidDevice");
        this.mContext = context;
        this.mServiceListener = serviceListener;
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.registerStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        doBind();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        Log.v(TAG, "close()");
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.unregisterStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        synchronized (this.mConnection) {
            if (this.mService != null) {
                this.mService = null;
                try {
                    this.mContext.unbindService(this.mConnection);
                } catch (IllegalArgumentException e2) {
                    Log.e(TAG, "close: could not unbind HID Dev service: ", e2);
                }
            }
        }
        this.mServiceListener = null;
    }

    public boolean connect() {
        Log.v(TAG, "connect()");
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.connect();
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean disconnect() {
        Log.v(TAG, "disconnect()");
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.disconnect();
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    boolean doBind() {
        Intent intent = new Intent(IBluetoothHidDevice.class.getName());
        ComponentName resolveSystemService = intent.resolveSystemService(this.mContext.getPackageManager(), 0);
        intent.setComponent(resolveSystemService);
        if (resolveSystemService == null || !this.mContext.bindService(intent, this.mConnection, 0)) {
            Log.e(TAG, "Could not bind to Bluetooth HID Device Service with " + intent);
            return false;
        }
        Log.d(TAG, "Bound to HID Device Service");
        return true;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        Log.v(TAG, "getConnectedDevices()");
        return null;
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        Log.v(TAG, "getConnectionState(): device=" + bluetoothDevice.getAddress());
        return 0;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        Log.v(TAG, "getDevicesMatchingConnectionStates(): states=" + Arrays.toString(iArr));
        return null;
    }

    public boolean registerApp(BluetoothHidDeviceAppSdpSettings bluetoothHidDeviceAppSdpSettings, BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings2, BluetoothHidDeviceCallback bluetoothHidDeviceCallback) {
        Log.v(TAG, "registerApp(): sdp=" + bluetoothHidDeviceAppSdpSettings + " inQos=" + bluetoothHidDeviceAppQosSettings + " outQos=" + bluetoothHidDeviceAppQosSettings2 + " callback=" + bluetoothHidDeviceCallback);
        boolean z = false;
        if (bluetoothHidDeviceAppSdpSettings == null || bluetoothHidDeviceCallback == null) {
            return false;
        }
        if (this.mService != null) {
            try {
                z = this.mService.registerApp(new BluetoothHidDeviceAppConfiguration(), bluetoothHidDeviceAppSdpSettings, bluetoothHidDeviceAppQosSettings, bluetoothHidDeviceAppQosSettings2, new BluetoothHidDeviceCallbackWrapper(bluetoothHidDeviceCallback));
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean replyReport(byte b, byte b2, byte[] bArr) {
        Log.v(TAG, "replyReport(): type=" + ((int) b) + " id=" + ((int) b2));
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.replyReport(b, b2, bArr);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean reportError(byte b) {
        Log.v(TAG, "reportError(): error = " + ((int) b));
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.reportError(b);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean sendReport(int i, byte[] bArr) {
        Log.v(TAG, "sendReport(): id=" + i);
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.sendReport(i, bArr);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean unplug() {
        Log.v(TAG, "unplug()");
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.unplug();
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean unregisterApp(BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration) {
        Log.v(TAG, "unregisterApp()");
        if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        try {
            return this.mService.unregisterApp(bluetoothHidDeviceAppConfiguration);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }
}
