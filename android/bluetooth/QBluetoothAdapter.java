package android.bluetooth;

import android.bluetooth.IBluetoothManagerCallback;
import android.bluetooth.IQBluetoothAdapterCallback;
import android.bluetooth.IQBluetoothManagerCallback;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/QBluetoothAdapter.class */
public final class QBluetoothAdapter {
    private static final boolean DBG = false;
    private static final String TAG = "QBluetoothAdapter";
    private static final boolean VDBG = false;
    private static BluetoothAdapter mAdapter;
    private static QBluetoothAdapter sAdapter;
    private final IBluetoothManager mManagerService;
    private IQBluetooth mQService;
    private IBluetooth mService;
    private final Map<LeLppCallback, LeLppClientWrapper> mLppClients = new HashMap();
    private final IBluetoothManagerCallback mAdapterServiceCallback = new IBluetoothManagerCallback.Stub() { // from class: android.bluetooth.QBluetoothAdapter.1
        @Override // android.bluetooth.IBluetoothManagerCallback
        public void onBluetoothServiceDown() {
            synchronized (QBluetoothAdapter.this.mAdapterServiceCallback) {
                QBluetoothAdapter.this.mService = null;
                Log.i(QBluetoothAdapter.TAG, "onBluetoothServiceDown Adapter OFF: mService: " + QBluetoothAdapter.this.mService + " mQService: " + QBluetoothAdapter.this.mQService);
            }
        }

        @Override // android.bluetooth.IBluetoothManagerCallback
        public void onBluetoothServiceUp(IBluetooth iBluetooth) {
            synchronized (QBluetoothAdapter.this.mAdapterServiceCallback) {
                QBluetoothAdapter.this.mService = iBluetooth;
                Log.i(QBluetoothAdapter.TAG, "onBluetoothServiceUp Adapter ON: mService: " + QBluetoothAdapter.this.mService + " mQService: " + QBluetoothAdapter.this.mQService + " ManagerService:" + QBluetoothAdapter.this.mManagerService);
            }
        }
    };
    private final IQBluetoothManagerCallback mManagerCallback = new IQBluetoothManagerCallback.Stub() { // from class: android.bluetooth.QBluetoothAdapter.2
        @Override // android.bluetooth.IQBluetoothManagerCallback
        public void onQBluetoothServiceDown() {
            synchronized (QBluetoothAdapter.this.mManagerCallback) {
                QBluetoothAdapter.this.mQService = null;
                Log.i(QBluetoothAdapter.TAG, "onQBluetoothServiceDown: Adapter OFF: mService: " + QBluetoothAdapter.this.mService + " mQService: " + QBluetoothAdapter.this.mQService);
            }
        }

        @Override // android.bluetooth.IQBluetoothManagerCallback
        public void onQBluetoothServiceUp(IQBluetooth iQBluetooth) {
            synchronized (QBluetoothAdapter.this.mManagerCallback) {
                QBluetoothAdapter.this.mQService = iQBluetooth;
                Log.i(QBluetoothAdapter.TAG, "onQBluetoothServiceUp: Adapter ON: mService: " + QBluetoothAdapter.this.mService + " mQService: " + QBluetoothAdapter.this.mQService + " ManagerService:" + QBluetoothAdapter.this.mManagerService);
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/QBluetoothAdapter$LeLppCallback.class */
    public interface LeLppCallback {
        void onEnableRssiMonitor(int i, int i2);

        void onReadRssiThreshold(int i, int i2, int i3, int i4);

        void onRssiThresholdEvent(int i, int i2);

        boolean onUpdateLease();

        void onWriteRssiThreshold(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/QBluetoothAdapter$LeLppClientWrapper.class */
    private static class LeLppClientWrapper extends IQBluetoothAdapterCallback.Stub {
        private final LeLppCallback client;
        private final WeakReference<QBluetoothAdapter> mAdapter;
        private final String mDevice;
        private final IQBluetooth mQBluetoothAdapterService;

        public LeLppClientWrapper(QBluetoothAdapter qBluetoothAdapter, IQBluetooth iQBluetooth, String str, LeLppCallback leLppCallback) {
            this.mAdapter = new WeakReference<>(qBluetoothAdapter);
            this.mQBluetoothAdapterService = iQBluetooth;
            this.mDevice = str;
            this.client = leLppCallback;
        }

        public void enableMonitor(boolean z) {
            if (this.mQBluetoothAdapterService != null) {
                try {
                    this.mQBluetoothAdapterService.enableLeLppRssiMonitor(this.mDevice, z);
                } catch (RemoteException e) {
                    Log.w(QBluetoothAdapter.TAG, "", e);
                }
            }
        }

        @Override // android.bluetooth.IQBluetoothAdapterCallback
        public void onEnableRssiMonitor(String str, int i, int i2) {
            if (this.client == null) {
                return;
            }
            try {
                this.client.onEnableRssiMonitor(i, i2);
            } catch (Exception e) {
                Log.w(QBluetoothAdapter.TAG, "Unhandled exception: " + e);
            }
        }

        @Override // android.bluetooth.IQBluetoothAdapterCallback
        public void onReadRssiThreshold(String str, int i, int i2, int i3, int i4) {
            if (this.client == null) {
                return;
            }
            try {
                this.client.onReadRssiThreshold(i, i2, i3, i4);
            } catch (Exception e) {
                Log.w(QBluetoothAdapter.TAG, "Unhandled exception: " + e);
            }
        }

        @Override // android.bluetooth.IQBluetoothAdapterCallback
        public void onRssiThresholdEvent(String str, int i, int i2) {
            if (this.client == null) {
                return;
            }
            try {
                this.client.onRssiThresholdEvent(i, i2);
            } catch (Exception e) {
                Log.w(QBluetoothAdapter.TAG, "Unhandled exception: " + e);
            }
        }

        @Override // android.bluetooth.IQBluetoothAdapterCallback
        public boolean onUpdateLease() {
            if (this.client == null) {
                return false;
            }
            try {
                return this.client.onUpdateLease();
            } catch (Exception e) {
                Log.w(QBluetoothAdapter.TAG, "Unhandled exception: " + e);
                return false;
            }
        }

        @Override // android.bluetooth.IQBluetoothAdapterCallback
        public void onWriteRssiThreshold(String str, int i) {
            if (this.client == null) {
                return;
            }
            try {
                this.client.onWriteRssiThreshold(i);
            } catch (Exception e) {
                Log.w(QBluetoothAdapter.TAG, "Unhandled exception: " + e);
            }
        }

        public void readRssiThreshold() {
            if (this.mQBluetoothAdapterService != null) {
                try {
                    this.mQBluetoothAdapterService.readLeLppRssiThreshold(this.mDevice);
                } catch (RemoteException e) {
                    Log.w(QBluetoothAdapter.TAG, "", e);
                }
            }
        }

        public boolean register2(boolean z) {
            if (this.mQBluetoothAdapterService != null) {
                try {
                    return this.mQBluetoothAdapterService.registerLeLppRssiMonitorClient(this.mDevice, this, z);
                } catch (RemoteException e) {
                    Log.w(QBluetoothAdapter.TAG, "", e);
                    return false;
                }
            }
            return false;
        }

        public void writeRssiThreshold(byte b, byte b2) {
            if (this.mQBluetoothAdapterService != null) {
                try {
                    this.mQBluetoothAdapterService.writeLeLppRssiThreshold(this.mDevice, b, b2);
                } catch (RemoteException e) {
                    Log.w(QBluetoothAdapter.TAG, "", e);
                }
            }
        }
    }

    QBluetoothAdapter(IBluetoothManager iBluetoothManager) {
        if (iBluetoothManager == null) {
            throw new IllegalArgumentException("bluetooth manager service is null");
        }
        try {
            this.mService = mAdapter.getBluetoothService(this.mAdapterServiceCallback);
            this.mQService = iBluetoothManager.registerQAdapter(this.mManagerCallback);
            Log.i(TAG, "mQService= :" + this.mQService);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        }
        this.mManagerService = iBluetoothManager;
    }

    public static QBluetoothAdapter getDefaultAdapter() {
        QBluetoothAdapter qBluetoothAdapter;
        synchronized (QBluetoothAdapter.class) {
            try {
                mAdapter = BluetoothAdapter.getDefaultAdapter();
                sAdapter = new QBluetoothAdapter(mAdapter.getBluetoothManager());
                qBluetoothAdapter = sAdapter;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qBluetoothAdapter;
    }

    public boolean enableRssiMonitor(LeLppCallback leLppCallback, boolean z) {
        LeLppClientWrapper leLppClientWrapper;
        synchronized (this.mLppClients) {
            leLppClientWrapper = this.mLppClients.get(leLppCallback);
        }
        if (leLppClientWrapper == null) {
            return false;
        }
        leLppClientWrapper.enableMonitor(z);
        return true;
    }

    protected void finalize() throws Throwable {
        try {
            this.mManagerService.unregisterQAdapter(this.mManagerCallback);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        } finally {
            super.finalize();
        }
    }

    public boolean readRssiThreshold(LeLppCallback leLppCallback) {
        LeLppClientWrapper leLppClientWrapper;
        synchronized (this.mLppClients) {
            leLppClientWrapper = this.mLppClients.get(leLppCallback);
        }
        if (leLppClientWrapper == null) {
            return false;
        }
        leLppClientWrapper.readRssiThreshold();
        return true;
    }

    public boolean registerLppClient(LeLppCallback leLppCallback, String str, boolean z) {
        synchronized (this.mLppClients) {
            if (!z) {
                LeLppClientWrapper remove = this.mLppClients.remove(leLppCallback);
                if (remove != null) {
                    remove.register2(false);
                    return true;
                }
                return false;
            } else if (this.mLppClients.containsKey(leLppCallback)) {
                Log.e(TAG, "Lpp Client has been already registered");
                return false;
            } else {
                LeLppClientWrapper leLppClientWrapper = new LeLppClientWrapper(this, this.mQService, str, leLppCallback);
                if (leLppClientWrapper == null || !leLppClientWrapper.register2(true)) {
                    return false;
                }
                this.mLppClients.put(leLppCallback, leLppClientWrapper);
                return true;
            }
        }
    }

    public boolean writeRssiThreshold(LeLppCallback leLppCallback, int i, int i2) {
        LeLppClientWrapper leLppClientWrapper;
        synchronized (this.mLppClients) {
            leLppClientWrapper = this.mLppClients.get(leLppCallback);
        }
        if (leLppClientWrapper == null) {
            return false;
        }
        leLppClientWrapper.writeRssiThreshold((byte) i, (byte) i2);
        return true;
    }
}
