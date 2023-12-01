package android.os;

import android.content.Context;
import android.os.IUpdateLock;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/os/UpdateLock.class */
public class UpdateLock {
    private static final boolean DEBUG = false;
    public static final String NOW_IS_CONVENIENT = "nowisconvenient";
    private static final String TAG = "UpdateLock";
    public static final String TIMESTAMP = "timestamp";
    public static final String UPDATE_LOCK_CHANGED = "android.os.UpdateLock.UPDATE_LOCK_CHANGED";
    private static IUpdateLock sService;
    final String mTag;
    int mCount = 0;
    boolean mRefCounted = true;
    boolean mHeld = false;
    IBinder mToken = new Binder();

    public UpdateLock(String str) {
        this.mTag = str;
    }

    private void acquireLocked() {
        if (this.mRefCounted) {
            int i = this.mCount;
            this.mCount = i + 1;
            if (i != 0) {
                return;
            }
        }
        if (sService != null) {
            try {
                sService.acquireUpdateLock(this.mToken, this.mTag);
            } catch (RemoteException e) {
                Log.e(TAG, "Unable to contact service to acquire");
            }
        }
        this.mHeld = true;
    }

    private static void checkService() {
        if (sService == null) {
            sService = IUpdateLock.Stub.asInterface(ServiceManager.getService(Context.UPDATE_LOCK_SERVICE));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0 == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void releaseLocked() {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.mRefCounted
            if (r0 == 0) goto L17
            r0 = r4
            int r0 = r0.mCount
            r1 = 1
            int r0 = r0 - r1
            r5 = r0
            r0 = r4
            r1 = r5
            r0.mCount = r1
            r0 = r5
            if (r0 != 0) goto L2e
        L17:
            android.os.IUpdateLock r0 = android.os.UpdateLock.sService
            if (r0 == 0) goto L29
            android.os.IUpdateLock r0 = android.os.UpdateLock.sService     // Catch: android.os.RemoteException -> L3f
            r1 = r4
            android.os.IBinder r1 = r1.mToken     // Catch: android.os.RemoteException -> L3f
            r0.releaseUpdateLock(r1)     // Catch: android.os.RemoteException -> L3f
        L29:
            r0 = r4
            r1 = 0
            r0.mHeld = r1
        L2e:
            r0 = r4
            int r0 = r0.mCount
            if (r0 >= 0) goto L4b
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            java.lang.String r2 = "UpdateLock under-locked"
            r1.<init>(r2)
            throw r0
        L3f:
            r6 = move-exception
            java.lang.String r0 = "UpdateLock"
            java.lang.String r1 = "Unable to contact service to release"
            int r0 = android.util.Log.e(r0, r1)
            goto L29
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.UpdateLock.releaseLocked():void");
    }

    public void acquire() {
        checkService();
        synchronized (this.mToken) {
            acquireLocked();
        }
    }

    protected void finalize() throws Throwable {
        synchronized (this.mToken) {
            if (this.mHeld) {
                Log.wtf(TAG, "UpdateLock finalized while still held");
                try {
                    sService.releaseUpdateLock(this.mToken);
                } catch (RemoteException e) {
                    Log.e(TAG, "Unable to contact service to release");
                }
            }
        }
    }

    public boolean isHeld() {
        boolean z;
        synchronized (this.mToken) {
            z = this.mHeld;
        }
        return z;
    }

    public void release() {
        checkService();
        synchronized (this.mToken) {
            releaseLocked();
        }
    }

    public void setReferenceCounted(boolean z) {
        this.mRefCounted = z;
    }
}
