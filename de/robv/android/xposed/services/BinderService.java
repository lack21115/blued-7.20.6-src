package de.robv.android.xposed.services;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.io.IOException;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/services/BinderService.class */
public final class BinderService extends BaseService {
    private static final int ACCESS_FILE_TRANSACTION = 3;
    private static final String INTERFACE_TOKEN = "de.robv.android.xposed.IXposedService";
    private static final int READ_FILE_TRANSACTION = 5;
    private static final int STAT_FILE_TRANSACTION = 4;
    public static final int TARGET_APP = 0;
    public static final int TARGET_SYSTEM = 1;
    private final IBinder mRemote;
    private static final String[] SERVICE_NAMES = {"user.xposed.app", "user.xposed.system"};
    private static final BinderService[] sServices = new BinderService[2];

    private BinderService(int i) {
        IBinder service = ServiceManager.getService(SERVICE_NAMES[i]);
        if (service == null) {
            throw new IllegalStateException("Service " + SERVICE_NAMES[i] + " does not exist");
        }
        this.mRemote = service;
    }

    public static BinderService getService(int i) {
        BinderService binderService;
        if (i < 0 || i > sServices.length) {
            throw new IllegalArgumentException("Invalid service target " + i);
        }
        synchronized (sServices) {
            if (sServices[i] == null) {
                sServices[i] = new BinderService(i);
            }
            binderService = sServices[i];
        }
        return binderService;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public boolean checkFileAccess(String str, int i) {
        boolean z = false;
        ensureAbsolutePath(str);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(INTERFACE_TOKEN);
        obtain.writeString(str);
        obtain.writeInt(i);
        try {
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            obtain2.recycle();
            obtain.recycle();
            if (readInt == 0) {
                z = true;
            }
            return z;
        } catch (RemoteException e) {
            obtain.recycle();
            obtain2.recycle();
            return false;
        }
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String str, int i, int i2, long j, long j2) throws IOException {
        ensureAbsolutePath(str);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(INTERFACE_TOKEN);
        obtain.writeString(str);
        obtain.writeInt(i);
        obtain.writeInt(i2);
        obtain.writeLong(j);
        obtain.writeLong(j2);
        try {
            this.mRemote.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            String readString = obtain2.readString();
            long readLong = obtain2.readLong();
            long readLong2 = obtain2.readLong();
            byte[] createByteArray = obtain2.createByteArray();
            obtain2.recycle();
            obtain.recycle();
            switch (readInt) {
                case 0:
                    return new FileResult(createByteArray, readLong, readLong2);
                case 22:
                    if (readString != null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(readString);
                        if (i == 0 && i2 == 0) {
                            throw new IOException(illegalArgumentException);
                        }
                        throw illegalArgumentException;
                    }
                    throw new IllegalArgumentException("Offset " + i + " / Length " + i2 + " is out of range for " + str + " with size " + readLong);
                default:
                    throwCommonIOException(readInt, readString, str, " while reading ");
                    throw new IllegalStateException();
            }
        } catch (RemoteException e) {
            obtain.recycle();
            obtain2.recycle();
            throw new IOException(e);
        }
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String str, long j, long j2) throws IOException {
        return readFile(str, 0, 0, j, j2);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public byte[] readFile(String str) throws IOException {
        return readFile(str, 0, 0, 0L, 0L).content;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult statFile(String str) throws IOException {
        ensureAbsolutePath(str);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(INTERFACE_TOKEN);
        obtain.writeString(str);
        try {
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            if (readInt != 0) {
                throwCommonIOException(readInt, null, str, " while retrieving attributes for ");
            }
            long readLong = obtain2.readLong();
            long readLong2 = obtain2.readLong();
            obtain2.recycle();
            obtain.recycle();
            return new FileResult(readLong, readLong2);
        } catch (RemoteException e) {
            obtain.recycle();
            obtain2.recycle();
            throw new IOException(e);
        }
    }
}
