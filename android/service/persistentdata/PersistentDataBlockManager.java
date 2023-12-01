package android.service.persistentdata;

import android.os.RemoteException;
import android.util.Slog;

/* loaded from: source-9557208-dex2jar.jar:android/service/persistentdata/PersistentDataBlockManager.class */
public class PersistentDataBlockManager {
    private static final String TAG = PersistentDataBlockManager.class.getSimpleName();
    private IPersistentDataBlockService sService;

    public PersistentDataBlockManager(IPersistentDataBlockService iPersistentDataBlockService) {
        this.sService = iPersistentDataBlockService;
    }

    private void onError(String str) {
        Slog.v(TAG, "Remote exception while " + str);
    }

    public int getDataBlockSize() {
        try {
            return this.sService.getDataBlockSize();
        } catch (RemoteException e) {
            onError("getting data block size");
            return -1;
        }
    }

    public long getMaximumDataBlockSize() {
        try {
            return this.sService.getMaximumDataBlockSize();
        } catch (RemoteException e) {
            onError("getting maximum data block size");
            return -1L;
        }
    }

    public boolean getOemUnlockEnabled() {
        try {
            return this.sService.getOemUnlockEnabled();
        } catch (RemoteException e) {
            onError("getting OEM unlock enabled bit");
            return false;
        }
    }

    public byte[] read() {
        try {
            return this.sService.read();
        } catch (RemoteException e) {
            onError("reading data");
            return null;
        }
    }

    public void setOemUnlockEnabled(boolean z) {
        try {
            this.sService.setOemUnlockEnabled(z);
        } catch (RemoteException e) {
            onError("setting OEM unlock enabled to " + z);
        }
    }

    public void wipe() {
        try {
            this.sService.wipe();
        } catch (RemoteException e) {
            onError("wiping persistent partition");
        }
    }

    public int write(byte[] bArr) {
        try {
            return this.sService.write(bArr);
        } catch (RemoteException e) {
            onError("writing data");
            return -1;
        }
    }
}
