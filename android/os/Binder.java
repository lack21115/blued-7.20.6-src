package android.os;

import android.os.IBinder;
import android.util.Log;
import com.android.internal.util.FastPrintWriter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/os/Binder.class */
public class Binder implements IBinder {
    private static final boolean CHECK_PARCEL_SIZE = false;
    private static final boolean FIND_POTENTIAL_LEAKS = false;
    static final String TAG = "Binder";
    private static String sDumpDisabled = null;
    private String mDescriptor;
    private long mObject;
    private IInterface mOwner;

    public Binder() {
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkParcel(IBinder iBinder, int i, Parcel parcel, String str) {
    }

    public static final native long clearCallingIdentity();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void destroy();

    private boolean execTransact(int i, long j, long j2, int i2) {
        boolean z;
        Parcel obtain = Parcel.obtain(j);
        Parcel obtain2 = Parcel.obtain(j2);
        try {
            z = onTransact(i, obtain, obtain2, i2);
        } catch (RemoteException e) {
            if ((i2 & 1) != 0) {
                Log.w(TAG, "Binder call failed.", e);
            } else {
                obtain2.setDataPosition(0);
                obtain2.writeException(e);
            }
            z = true;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "Caught an OutOfMemoryError from the binder stub implementation.", e2);
            RuntimeException runtimeException = new RuntimeException("Out of memory", e2);
            obtain2.setDataPosition(0);
            obtain2.writeException(runtimeException);
            z = true;
        } catch (RuntimeException e3) {
            if ((i2 & 1) != 0) {
                Log.w(TAG, "Caught a RuntimeException from the binder stub implementation.", e3);
            } else {
                obtain2.setDataPosition(0);
                obtain2.writeException(e3);
            }
            z = true;
        }
        checkParcel(this, i, obtain2, "Unreasonably large binder reply buffer");
        obtain2.recycle();
        obtain.recycle();
        StrictMode.clearGatheredViolations();
        return z;
    }

    public static final native void flushPendingCommands();

    public static final native int getCallingPid();

    public static final native int getCallingUid();

    public static final UserHandle getCallingUserHandle() {
        return new UserHandle(UserHandle.getUserId(getCallingUid()));
    }

    public static final native int getThreadStrictModePolicy();

    private final native void init();

    public static final boolean isProxy(IInterface iInterface) {
        return iInterface.asBinder() != iInterface;
    }

    public static final native void joinThreadPool();

    public static final native void restoreCallingIdentity(long j);

    public static void setDumpDisabled(String str) {
        synchronized (Binder.class) {
            try {
                sDumpDisabled = str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final native void setThreadStrictModePolicy(int i);

    public void attachInterface(IInterface iInterface, String str) {
        this.mOwner = iInterface;
        this.mDescriptor = str;
    }

    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) {
        String str;
        FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(fileDescriptor));
        try {
            synchronized (Binder.class) {
                str = sDumpDisabled;
            }
            if (str == null) {
                try {
                    dump(fileDescriptor, fastPrintWriter, strArr);
                } catch (SecurityException e) {
                    fastPrintWriter.println("Security exception: " + e.getMessage());
                    throw e;
                }
            } else {
                fastPrintWriter.println(sDumpDisabled);
            }
        } finally {
            fastPrintWriter.flush();
        }
    }

    @Override // android.os.IBinder
    public void dumpAsync(final FileDescriptor fileDescriptor, final String[] strArr) {
        final FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(fileDescriptor));
        new Thread("Binder.dumpAsync") { // from class: android.os.Binder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Binder.this.dump(fileDescriptor, fastPrintWriter, strArr);
                } finally {
                    fastPrintWriter.flush();
                }
            }
        }.start();
    }

    protected void finalize() throws Throwable {
        try {
            destroy();
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() {
        return this.mDescriptor;
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        return true;
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1598968902) {
            parcel2.writeString(getInterfaceDescriptor());
            return true;
        } else if (i == 1598311760) {
            ParcelFileDescriptor readFileDescriptor = parcel.readFileDescriptor();
            String[] readStringArray = parcel.readStringArray();
            if (readFileDescriptor != null) {
                try {
                    dump(readFileDescriptor.getFileDescriptor(), readStringArray);
                } finally {
                    try {
                        readFileDescriptor.close();
                    } catch (IOException e) {
                    }
                }
            }
            if (parcel2 != null) {
                parcel2.writeNoException();
                return true;
            }
            StrictMode.clearGatheredViolations();
            return true;
        } else {
            return false;
        }
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        return true;
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        if (this.mDescriptor.equals(str)) {
            return this.mOwner;
        }
        return null;
    }

    @Override // android.os.IBinder
    public final boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (parcel != null) {
            parcel.setDataPosition(0);
        }
        boolean onTransact = onTransact(i, parcel, parcel2, i2);
        if (parcel2 != null) {
            parcel2.setDataPosition(0);
        }
        return onTransact;
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        return true;
    }
}
