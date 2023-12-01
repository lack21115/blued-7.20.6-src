package android.hardware;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.ITorchCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/TorchManager.class */
public class TorchManager {
    private static final int DISPATCH_TORCH_AVAILABILITY_CHANGE = 3;
    private static final int DISPATCH_TORCH_ERROR = 2;
    private static final int DISPATCH_TORCH_STATE_CHANGE = 1;
    public static final String TAG = TorchManager.class.getSimpleName();
    private Context mContext;
    private ITorchService mService;
    private final List<TorchCallback> mCallbacks = new ArrayList();
    private final ITorchCallback mTorchChangeListener = new ITorchCallback.Stub() { // from class: android.hardware.TorchManager.1
        @Override // android.hardware.ITorchCallback
        public void onTorchAvailabilityChanged(boolean z) throws RemoteException {
            TorchManager.this.mHandler.sendMessage(Message.obtain(TorchManager.this.mHandler, 3, z ? 1 : 0, 0));
        }

        @Override // android.hardware.ITorchCallback
        public void onTorchError() throws RemoteException {
            TorchManager.this.mHandler.sendEmptyMessage(2);
        }

        @Override // android.hardware.ITorchCallback
        public void onTorchStateChanged(boolean z) throws RemoteException {
            TorchManager.this.mHandler.sendMessage(Message.obtain(TorchManager.this.mHandler, 1, z ? 1 : 0, 0));
        }
    };
    private TorchHandler mHandler = new TorchHandler(Looper.getMainLooper());

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/TorchManager$TorchCallback.class */
    public interface TorchCallback {
        void onTorchAvailabilityChanged(boolean z);

        void onTorchError();

        void onTorchStateChanged(boolean z);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/TorchManager$TorchHandler.class */
    private class TorchHandler extends Handler {
        public TorchHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    synchronized (TorchManager.this.mCallbacks) {
                        ArrayList<TorchCallback> arrayList = new ArrayList();
                        for (TorchCallback torchCallback : TorchManager.this.mCallbacks) {
                            torchCallback.onTorchStateChanged(message.arg1 != 0);
                        }
                        if (arrayList.size() > 0) {
                            for (TorchCallback torchCallback2 : arrayList) {
                                TorchManager.this.mCallbacks.remove(torchCallback2);
                            }
                        }
                    }
                    return;
                case 2:
                    synchronized (TorchManager.this.mCallbacks) {
                        ArrayList<TorchCallback> arrayList2 = new ArrayList();
                        for (TorchCallback torchCallback3 : TorchManager.this.mCallbacks) {
                            torchCallback3.onTorchError();
                        }
                        if (arrayList2.size() > 0) {
                            for (TorchCallback torchCallback4 : arrayList2) {
                                TorchManager.this.mCallbacks.remove(torchCallback4);
                            }
                        }
                    }
                    return;
                case 3:
                    synchronized (TorchManager.this.mCallbacks) {
                        ArrayList<TorchCallback> arrayList3 = new ArrayList();
                        for (TorchCallback torchCallback5 : TorchManager.this.mCallbacks) {
                            torchCallback5.onTorchAvailabilityChanged(message.arg1 == 1);
                        }
                        if (arrayList3.size() > 0) {
                            for (TorchCallback torchCallback6 : arrayList3) {
                                TorchManager.this.mCallbacks.remove(torchCallback6);
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public TorchManager(Context context, ITorchService iTorchService) {
        this.mContext = context;
        this.mService = iTorchService;
    }

    public void addListener(TorchCallback torchCallback) {
        synchronized (this.mCallbacks) {
            if (this.mCallbacks.contains(torchCallback)) {
                throw new IllegalArgumentException("Torch client was already added");
            }
            if (this.mCallbacks.size() == 0) {
                try {
                    this.mService.addListener(this.mTorchChangeListener);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to register torch listener");
                }
            }
            this.mCallbacks.add(torchCallback);
        }
    }

    public boolean isAvailable() {
        try {
            return this.mService.isAvailable();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isTorchOn() {
        try {
            return this.mService.isTorchOn();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isTorchSupported() {
        return this.mContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void removeListener(TorchCallback torchCallback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.remove(torchCallback);
            if (this.mCallbacks.size() == 0) {
                try {
                    this.mService.removeListener(this.mTorchChangeListener);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to remove torch listener");
                }
            }
        }
    }

    public void setTorchEnabled(final boolean z) {
        this.mHandler.post(new Runnable() { // from class: android.hardware.TorchManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TorchManager.this.mService.setTorchEnabled(z);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void toggleTorch() {
        this.mHandler.post(new Runnable() { // from class: android.hardware.TorchManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TorchManager.this.mService.toggleTorch();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
