package android.net;

import android.content.Context;
import android.net.IEthernetServiceListener;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/EthernetManager.class */
public class EthernetManager {
    private static final int MSG_AVAILABILITY_CHANGED = 1000;
    private static final String TAG = "EthernetManager";
    private final Context mContext;
    private final IEthernetManager mService;
    private final Handler mHandler = new Handler() { // from class: android.net.EthernetManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what == 1000) {
                if (message.arg1 != 1) {
                    z = false;
                }
                Iterator it = EthernetManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((Listener) it.next()).onAvailabilityChanged(z);
                }
            }
        }
    };
    private final ArrayList<Listener> mListeners = new ArrayList<>();
    private final IEthernetServiceListener.Stub mServiceListener = new IEthernetServiceListener.Stub() { // from class: android.net.EthernetManager.2
        @Override // android.net.IEthernetServiceListener
        public void onAvailabilityChanged(boolean z) {
            EthernetManager.this.mHandler.obtainMessage(1000, z ? 1 : 0, 0, null).sendToTarget();
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/net/EthernetManager$Listener.class */
    public interface Listener {
        void onAvailabilityChanged(boolean z);
    }

    public EthernetManager(Context context, IEthernetManager iEthernetManager) {
        this.mContext = context;
        this.mService = iEthernetManager;
    }

    public void addListener(Listener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        this.mListeners.add(listener);
        if (this.mListeners.size() == 1) {
            try {
                this.mService.addListener(this.mServiceListener);
            } catch (RemoteException e) {
            } catch (NullPointerException e2) {
            }
        }
    }

    public IpConfiguration getConfiguration() {
        try {
            return this.mService.getConfiguration();
        } catch (RemoteException | NullPointerException e) {
            return new IpConfiguration();
        }
    }

    public boolean isAvailable() {
        try {
            return this.mService.isAvailable();
        } catch (RemoteException | NullPointerException e) {
            return false;
        }
    }

    public void removeListener(Listener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        this.mListeners.remove(listener);
        if (this.mListeners.isEmpty()) {
            try {
                this.mService.removeListener(this.mServiceListener);
            } catch (RemoteException e) {
            } catch (NullPointerException e2) {
            }
        }
    }

    public void setConfiguration(IpConfiguration ipConfiguration) {
        try {
            this.mService.setConfiguration(ipConfiguration);
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
    }
}
