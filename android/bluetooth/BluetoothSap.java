package android.bluetooth;

import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothSap;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothSap.class */
public final class BluetoothSap implements BluetoothProfile {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "codeaurora.bluetooth.sap.profile.action.CONNECTION_STATE_CHANGED";
    private static final boolean DBG = false;
    private static final String TAG = "BluetoothSap";
    private static final boolean VDBG = false;
    private Context mContext;
    private IBluetoothSap mSapService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private IBluetoothStateChangeCallback mStateChangeCallback = new IBluetoothStateChangeCallback.Stub() { // from class: android.bluetooth.BluetoothSap.1
        @Override // android.bluetooth.IBluetoothStateChangeCallback
        public void onBluetoothStateChange(boolean z) {
            Log.d(BluetoothSap.TAG, "onBluetoothStateChange on: " + z);
            if (!z) {
                synchronized (BluetoothSap.this.mConnection) {
                    if (BluetoothSap.this.mSapService != null) {
                        try {
                            BluetoothSap.this.mSapService = null;
                            BluetoothSap.this.mContext.unbindService(BluetoothSap.this.mConnection);
                        } catch (Exception e) {
                            Log.e(BluetoothSap.TAG, "", e);
                        }
                    }
                }
                return;
            }
            try {
                if (BluetoothSap.this.mSapService == null) {
                    Log.d(BluetoothSap.TAG, "onBluetoothStateChange call bindService");
                    BluetoothSap.this.doBind();
                }
            } catch (IllegalStateException e2) {
                Log.e(BluetoothSap.TAG, "onBluetoothStateChange: could not bind to SAP service: ", e2);
            } catch (SecurityException e3) {
                Log.e(BluetoothSap.TAG, "onBluetoothStateChange: could not bind to SAP service: ", e3);
            }
            Log.d(BluetoothSap.TAG, "BluetoothSap(), bindService called");
        }
    };
    private ServiceConnection mConnection = new ServiceConnection() { // from class: android.bluetooth.BluetoothSap.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BluetoothSap.this.mSapService = IBluetoothSap.Stub.asInterface(iBinder);
            if (BluetoothSap.this.mServiceListener != null) {
                BluetoothSap.this.mServiceListener.onServiceConnected(20, BluetoothSap.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BluetoothSap.this.mSapService = null;
            if (BluetoothSap.this.mServiceListener != null) {
                BluetoothSap.this.mServiceListener.onServiceDisconnected(20);
            }
        }
    };
    private BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothSap(Context context, BluetoothProfile.ServiceListener serviceListener) {
        this.mContext = context;
        this.mServiceListener = serviceListener;
        try {
            this.mAdapter.getBluetoothManager().registerStateChangeCallback(this.mStateChangeCallback);
        } catch (RemoteException e) {
            Log.w(TAG, "Unable to register BluetoothStateChangeCallback", e);
        }
        Log.d(TAG, "BluetoothSap() call bindService");
        doBind();
    }

    private boolean isEnabled() {
        return this.mAdapter.getState() == 12;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress());
    }

    private static void log(String str) {
        Log.d(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        this.mServiceListener = null;
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.unregisterStateChangeCallback(this.mStateChangeCallback);
            } catch (RemoteException e) {
                Log.w(TAG, "Unable to unregister BluetoothStateChangeCallback", e);
            }
        }
        synchronized (this.mConnection) {
            if (this.mSapService != null) {
                try {
                    this.mSapService = null;
                    this.mContext.unbindService(this.mConnection);
                } catch (Exception e2) {
                    Log.e(TAG, "", e2);
                }
            }
        }
    }

    public boolean disconnect(BluetoothDevice bluetoothDevice) {
        boolean z = false;
        if (this.mSapService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mSapService.disconnect(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        } else if (this.mSapService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return false;
        }
        return z;
    }

    boolean doBind() {
        Intent intent = new Intent(IBluetoothSap.class.getName());
        ComponentName resolveSystemService = intent.resolveSystemService(this.mContext.getPackageManager(), 0);
        intent.setComponent(resolveSystemService);
        if (resolveSystemService == null || !this.mContext.bindServiceAsUser(intent, this.mConnection, 0, Process.myUserHandle())) {
            Log.e(TAG, "Could not bind to Bluetooth SAP Service with " + intent);
            return false;
        }
        return true;
    }

    protected void finalize() {
        close();
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        if (this.mSapService == null || !isEnabled()) {
            if (this.mSapService == null) {
                Log.w(TAG, "Proxy not attached to service");
            }
            return new ArrayList();
        }
        try {
            return this.mSapService.getConnectedDevices();
        } catch (RemoteException e) {
            Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            return new ArrayList();
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        int i = 0;
        if (this.mSapService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                i = this.mSapService.getConnectionState(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return 0;
            }
        } else if (this.mSapService == null) {
            Log.w(TAG, "Proxy not attached to service");
            return 0;
        }
        return i;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        if (this.mSapService == null || !isEnabled()) {
            if (this.mSapService == null) {
                Log.w(TAG, "Proxy not attached to service");
            }
            return new ArrayList();
        }
        try {
            return this.mSapService.getDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException e) {
            Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            return new ArrayList();
        }
    }
}
