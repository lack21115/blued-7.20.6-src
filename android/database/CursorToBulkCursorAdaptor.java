package android.database;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/database/CursorToBulkCursorAdaptor.class */
public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    private static final String TAG = "Cursor";
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    private final Object mLock = new Object();
    private ContentObserverProxy mObserver;
    private final String mProviderName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/database/CursorToBulkCursorAdaptor$ContentObserverProxy.class */
    public static final class ContentObserverProxy extends ContentObserver {
        protected IContentObserver mRemote;

        public ContentObserverProxy(IContentObserver iContentObserver, IBinder.DeathRecipient deathRecipient) {
            super(null);
            this.mRemote = iContentObserver;
            try {
                iContentObserver.asBinder().linkToDeath(deathRecipient, 0);
            } catch (RemoteException e) {
            }
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            try {
                this.mRemote.onChange(z, uri, Process.myUid());
            } catch (RemoteException e) {
            }
        }

        public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient) {
            return this.mRemote.asBinder().unlinkToDeath(deathRecipient, 0);
        }
    }

    public CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver iContentObserver, String str) {
        if (cursor instanceof CrossProcessCursor) {
            this.mCursor = (CrossProcessCursor) cursor;
        } else {
            this.mCursor = new CrossProcessCursorWrapper(cursor);
        }
        this.mProviderName = str;
        synchronized (this.mLock) {
            createAndRegisterObserverProxyLocked(iContentObserver);
        }
    }

    private void closeFilledWindowLocked() {
        if (this.mFilledWindow != null) {
            this.mFilledWindow.close();
            this.mFilledWindow = null;
        }
    }

    private void createAndRegisterObserverProxyLocked(IContentObserver iContentObserver) {
        if (this.mObserver != null) {
            throw new IllegalStateException("an observer is already registered");
        }
        this.mObserver = new ContentObserverProxy(iContentObserver, this);
        this.mCursor.registerContentObserver(this.mObserver);
    }

    private void disposeLocked() {
        if (this.mCursor != null) {
            unregisterObserverProxyLocked();
            this.mCursor.close();
            this.mCursor = null;
        }
        closeFilledWindowLocked();
    }

    private void throwIfCursorIsClosed() {
        if (this.mCursor == null) {
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        }
    }

    private void unregisterObserverProxyLocked() {
        if (this.mObserver != null) {
            this.mCursor.unregisterContentObserver(this.mObserver);
            this.mObserver.unlinkToDeath(this);
            this.mObserver = null;
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.mLock) {
            disposeLocked();
        }
    }

    @Override // android.database.IBulkCursor
    public void close() {
        synchronized (this.mLock) {
            disposeLocked();
        }
    }

    @Override // android.database.IBulkCursor
    public void deactivate() {
        synchronized (this.mLock) {
            if (this.mCursor != null) {
                unregisterObserverProxyLocked();
                this.mCursor.deactivate();
            }
            closeFilledWindowLocked();
        }
    }

    public BulkCursorDescriptor getBulkCursorDescriptor() {
        BulkCursorDescriptor bulkCursorDescriptor;
        synchronized (this.mLock) {
            throwIfCursorIsClosed();
            bulkCursorDescriptor = new BulkCursorDescriptor();
            bulkCursorDescriptor.cursor = this;
            bulkCursorDescriptor.columnNames = this.mCursor.getColumnNames();
            bulkCursorDescriptor.wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
            bulkCursorDescriptor.count = this.mCursor.getCount();
            bulkCursorDescriptor.window = this.mCursor.getWindow();
            if (bulkCursorDescriptor.window != null) {
                bulkCursorDescriptor.window.acquireReference();
            }
        }
        return bulkCursorDescriptor;
    }

    @Override // android.database.IBulkCursor
    public Bundle getExtras() {
        Bundle extras;
        synchronized (this.mLock) {
            throwIfCursorIsClosed();
            extras = this.mCursor.getExtras();
        }
        return extras;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (r6 >= (r0.getStartPosition() + r0.getNumRows())) goto L31;
     */
    @Override // android.database.IBulkCursor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.CursorWindow getWindow(int r6) {
        /*
            r5 = this;
            r0 = r5
            java.lang.Object r0 = r0.mLock
            r9 = r0
            r0 = r9
            monitor-enter(r0)
            r0 = r5
            r0.throwIfCursorIsClosed()     // Catch: java.lang.Throwable -> L42
            r0 = r5
            android.database.CrossProcessCursor r0 = r0.mCursor     // Catch: java.lang.Throwable -> L42
            r1 = r6
            boolean r0 = r0.moveToPosition(r1)     // Catch: java.lang.Throwable -> L42
            if (r0 != 0) goto L23
            r0 = r5
            r0.closeFilledWindowLocked()     // Catch: java.lang.Throwable -> L42
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            r0 = 0
            return r0
        L23:
            r0 = r5
            android.database.CrossProcessCursor r0 = r0.mCursor     // Catch: java.lang.Throwable -> L42
            android.database.CursorWindow r0 = r0.getWindow()     // Catch: java.lang.Throwable -> L42
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L48
            r0 = r5
            r0.closeFilledWindowLocked()     // Catch: java.lang.Throwable -> L42
        L35:
            r0 = r7
            if (r0 == 0) goto L3d
            r0 = r7
            r0.acquireReference()     // Catch: java.lang.Throwable -> L42
        L3d:
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            r0 = r7
            return r0
        L42:
            r7 = move-exception
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            r0 = r7
            throw r0
        L48:
            r0 = r5
            android.database.CursorWindow r0 = r0.mFilledWindow     // Catch: java.lang.Throwable -> L42
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L73
            r0 = r5
            android.database.CursorWindow r1 = new android.database.CursorWindow     // Catch: java.lang.Throwable -> L42
            r2 = r1
            r3 = r5
            java.lang.String r3 = r3.mProviderName     // Catch: java.lang.Throwable -> L42
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L42
            r0.mFilledWindow = r1     // Catch: java.lang.Throwable -> L42
            r0 = r5
            android.database.CursorWindow r0 = r0.mFilledWindow     // Catch: java.lang.Throwable -> L42
            r7 = r0
        L65:
            r0 = r5
            android.database.CrossProcessCursor r0 = r0.mCursor     // Catch: java.lang.Throwable -> L42
            r1 = r6
            r2 = r7
            r0.fillWindow(r1, r2)     // Catch: java.lang.Throwable -> L42
            goto L35
        L73:
            r0 = r6
            r1 = r8
            int r1 = r1.getStartPosition()     // Catch: java.lang.Throwable -> L42
            if (r0 < r1) goto L8a
            r0 = r8
            r7 = r0
            r0 = r6
            r1 = r8
            int r1 = r1.getStartPosition()     // Catch: java.lang.Throwable -> L42
            r2 = r8
            int r2 = r2.getNumRows()     // Catch: java.lang.Throwable -> L42
            int r1 = r1 + r2
            if (r0 < r1) goto L65
        L8a:
            r0 = r8
            r0.clear()     // Catch: java.lang.Throwable -> L42
            r0 = r8
            r7 = r0
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: android.database.CursorToBulkCursorAdaptor.getWindow(int):android.database.CursorWindow");
    }

    @Override // android.database.IBulkCursor
    public void onMove(int i) {
        synchronized (this.mLock) {
            throwIfCursorIsClosed();
            this.mCursor.onMove(this.mCursor.getPosition(), i);
        }
    }

    @Override // android.database.IBulkCursor
    public int requery(IContentObserver iContentObserver) {
        synchronized (this.mLock) {
            throwIfCursorIsClosed();
            closeFilledWindowLocked();
            try {
                if (this.mCursor.requery()) {
                    unregisterObserverProxyLocked();
                    createAndRegisterObserverProxyLocked(iContentObserver);
                    return this.mCursor.getCount();
                }
                return -1;
            } catch (IllegalStateException e) {
                throw new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), e);
            }
        }
    }

    @Override // android.database.IBulkCursor
    public Bundle respond(Bundle bundle) {
        Bundle respond;
        synchronized (this.mLock) {
            throwIfCursorIsClosed();
            respond = this.mCursor.respond(bundle);
        }
        return respond;
    }
}
