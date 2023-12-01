package android.os;

import android.os.IBinder;
import android.os.IInterface;
import android.util.ArrayMap;

/* loaded from: source-9557208-dex2jar.jar:android/os/RemoteCallbackList.class */
public class RemoteCallbackList<E extends IInterface> {
    private Object[] mActiveBroadcast;
    ArrayMap<IBinder, RemoteCallbackList<E>.Callback> mCallbacks = new ArrayMap<>();
    private int mBroadcastCount = -1;
    private boolean mKilled = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/RemoteCallbackList$Callback.class */
    public final class Callback implements IBinder.DeathRecipient {
        final E mCallback;
        final Object mCookie;

        Callback(E e, Object obj) {
            this.mCallback = e;
            this.mCookie = obj;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (RemoteCallbackList.this.mCallbacks) {
                RemoteCallbackList.this.mCallbacks.remove(this.mCallback.asBinder());
            }
            RemoteCallbackList.this.onCallbackDied(this.mCallback, this.mCookie);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r0.length < r0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int beginBroadcast() {
        /*
            r5 = this;
            r0 = r5
            android.util.ArrayMap<android.os.IBinder, android.os.RemoteCallbackList<E>$Callback> r0 = r0.mCallbacks
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r5
            int r0 = r0.mBroadcastCount     // Catch: java.lang.Throwable -> L1a
            if (r0 <= 0) goto L20
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            r1 = r0
            java.lang.String r2 = "beginBroadcast() called while already in a broadcast"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            throw r0     // Catch: java.lang.Throwable -> L1a
        L1a:
            r8 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            r0 = r8
            throw r0
        L20:
            r0 = r5
            android.util.ArrayMap<android.os.IBinder, android.os.RemoteCallbackList<E>$Callback> r0 = r0.mCallbacks     // Catch: java.lang.Throwable -> L1a
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L1a
            r7 = r0
            r0 = r5
            r1 = r7
            r0.mBroadcastCount = r1     // Catch: java.lang.Throwable -> L1a
            r0 = r7
            if (r0 > 0) goto L36
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            r0 = 0
            return r0
        L36:
            r0 = r5
            java.lang.Object[] r0 = r0.mActiveBroadcast     // Catch: java.lang.Throwable -> L1a
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L4b
            r0 = r9
            r8 = r0
            r0 = r9
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1a
            r1 = r7
            if (r0 >= r1) goto L74
        L4b:
            r0 = r7
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L1a
            r8 = r0
            r0 = r5
            r1 = r8
            r0.mActiveBroadcast = r1     // Catch: java.lang.Throwable -> L1a
            goto L74
        L58:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L6f
            r0 = r8
            r1 = r6
            r2 = r5
            android.util.ArrayMap<android.os.IBinder, android.os.RemoteCallbackList<E>$Callback> r2 = r2.mCallbacks     // Catch: java.lang.Throwable -> L1a
            r3 = r6
            java.lang.Object r2 = r2.valueAt(r3)     // Catch: java.lang.Throwable -> L1a
            r0[r1] = r2     // Catch: java.lang.Throwable -> L1a
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L58
        L6f:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            r0 = r7
            return r0
        L74:
            r0 = 0
            r6 = r0
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.RemoteCallbackList.beginBroadcast():int");
    }

    public void finishBroadcast() {
        if (this.mBroadcastCount < 0) {
            throw new IllegalStateException("finishBroadcast() called outside of a broadcast");
        }
        Object[] objArr = this.mActiveBroadcast;
        if (objArr != null) {
            int i = this.mBroadcastCount;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                objArr[i3] = null;
                i2 = i3 + 1;
            }
        }
        this.mBroadcastCount = -1;
    }

    public Object getBroadcastCookie(int i) {
        return ((Callback) this.mActiveBroadcast[i]).mCookie;
    }

    public E getBroadcastItem(int i) {
        return ((Callback) this.mActiveBroadcast[i]).mCallback;
    }

    public int getRegisteredCallbackCount() {
        synchronized (this.mCallbacks) {
            if (this.mKilled) {
                return 0;
            }
            return this.mCallbacks.size();
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [E extends android.os.IInterface, android.os.IInterface] */
    public void kill() {
        synchronized (this.mCallbacks) {
            int size = this.mCallbacks.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    RemoteCallbackList<E>.Callback valueAt = this.mCallbacks.valueAt(i);
                    valueAt.mCallback.asBinder().unlinkToDeath(valueAt, 0);
                    size = i;
                } else {
                    this.mCallbacks.clear();
                    this.mKilled = true;
                }
            }
        }
    }

    public void onCallbackDied(E e) {
    }

    public void onCallbackDied(E e, Object obj) {
        onCallbackDied(e);
    }

    public boolean register(E e) {
        return register(e, null);
    }

    public boolean register(E e, Object obj) {
        synchronized (this.mCallbacks) {
            if (this.mKilled) {
                return false;
            }
            IBinder asBinder = e.asBinder();
            try {
                RemoteCallbackList<E>.Callback callback = new Callback(e, obj);
                asBinder.linkToDeath(callback, 0);
                this.mCallbacks.put(asBinder, callback);
                return true;
            } catch (RemoteException e2) {
                return false;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [E extends android.os.IInterface, android.os.IInterface] */
    public boolean unregister(E e) {
        synchronized (this.mCallbacks) {
            RemoteCallbackList<E>.Callback remove = this.mCallbacks.remove(e.asBinder());
            if (remove != null) {
                remove.mCallback.asBinder().unlinkToDeath(remove, 0);
                return true;
            }
            return false;
        }
    }
}
