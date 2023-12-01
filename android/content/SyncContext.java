package android.content;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;

/* loaded from: source-9557208-dex2jar.jar:android/content/SyncContext.class */
public class SyncContext {
    private static final long HEARTBEAT_SEND_INTERVAL_IN_MS = 1000;
    private long mLastHeartbeatSendTime = 0;
    private ISyncContext mSyncContext;

    public SyncContext(ISyncContext iSyncContext) {
        this.mSyncContext = iSyncContext;
    }

    private void updateHeartbeat() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < this.mLastHeartbeatSendTime + 1000) {
            return;
        }
        try {
            this.mLastHeartbeatSendTime = elapsedRealtime;
            if (this.mSyncContext != null) {
                this.mSyncContext.sendHeartbeat();
            }
        } catch (RemoteException e) {
        }
    }

    public IBinder getSyncContextBinder() {
        if (this.mSyncContext == null) {
            return null;
        }
        return this.mSyncContext.asBinder();
    }

    public void onFinished(SyncResult syncResult) {
        try {
            if (this.mSyncContext != null) {
                this.mSyncContext.onFinished(syncResult);
            }
        } catch (RemoteException e) {
        }
    }

    public void setStatusText(String str) {
        updateHeartbeat();
    }
}
