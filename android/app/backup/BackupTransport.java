package android.app.backup;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.android.internal.backup.IBackupTransport;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupTransport.class */
public class BackupTransport {
    public static final int AGENT_ERROR = -1003;
    public static final int AGENT_UNKNOWN = -1004;
    public static final int NO_MORE_DATA = -1;
    public static final int TRANSPORT_ERROR = -1000;
    public static final int TRANSPORT_NOT_INITIALIZED = -1001;
    public static final int TRANSPORT_OK = 0;
    public static final int TRANSPORT_PACKAGE_REJECTED = -1002;
    IBackupTransport mBinderImpl = new TransportImpl();

    /* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupTransport$TransportImpl.class */
    class TransportImpl extends IBackupTransport.Stub {
        TransportImpl() {
        }

        public int abortFullRestore() {
            return BackupTransport.this.abortFullRestore();
        }

        public void cancelFullBackup() throws RemoteException {
            BackupTransport.this.cancelFullBackup();
        }

        public int clearBackupData(PackageInfo packageInfo) throws RemoteException {
            return BackupTransport.this.clearBackupData(packageInfo);
        }

        public Intent configurationIntent() throws RemoteException {
            return BackupTransport.this.configurationIntent();
        }

        public String currentDestinationString() throws RemoteException {
            return BackupTransport.this.currentDestinationString();
        }

        public Intent dataManagementIntent() {
            return BackupTransport.this.dataManagementIntent();
        }

        public String dataManagementLabel() {
            return BackupTransport.this.dataManagementLabel();
        }

        public int finishBackup() throws RemoteException {
            return BackupTransport.this.finishBackup();
        }

        public void finishRestore() throws RemoteException {
            BackupTransport.this.finishRestore();
        }

        public RestoreSet[] getAvailableRestoreSets() throws RemoteException {
            return BackupTransport.this.getAvailableRestoreSets();
        }

        public long getCurrentRestoreSet() throws RemoteException {
            return BackupTransport.this.getCurrentRestoreSet();
        }

        public int getNextFullRestoreDataChunk(ParcelFileDescriptor parcelFileDescriptor) {
            return BackupTransport.this.getNextFullRestoreDataChunk(parcelFileDescriptor);
        }

        public int getRestoreData(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
            return BackupTransport.this.getRestoreData(parcelFileDescriptor);
        }

        public int initializeDevice() throws RemoteException {
            return BackupTransport.this.initializeDevice();
        }

        public String name() throws RemoteException {
            return BackupTransport.this.name();
        }

        public RestoreDescription nextRestorePackage() throws RemoteException {
            return BackupTransport.this.nextRestorePackage();
        }

        public int performBackup(PackageInfo packageInfo, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
            return BackupTransport.this.performBackup(packageInfo, parcelFileDescriptor);
        }

        public int performFullBackup(PackageInfo packageInfo, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
            return BackupTransport.this.performFullBackup(packageInfo, parcelFileDescriptor);
        }

        public long requestBackupTime() throws RemoteException {
            return BackupTransport.this.requestBackupTime();
        }

        public long requestFullBackupTime() throws RemoteException {
            return BackupTransport.this.requestFullBackupTime();
        }

        public int sendBackupData(int i) throws RemoteException {
            return BackupTransport.this.sendBackupData(i);
        }

        public int startRestore(long j, PackageInfo[] packageInfoArr) throws RemoteException {
            return BackupTransport.this.startRestore(j, packageInfoArr);
        }

        public String transportDirName() throws RemoteException {
            return BackupTransport.this.transportDirName();
        }
    }

    public int abortFullRestore() {
        return 0;
    }

    public void cancelFullBackup() {
        throw new UnsupportedOperationException("Transport cancelFullBackup() not implemented");
    }

    public int clearBackupData(PackageInfo packageInfo) {
        return -1000;
    }

    public Intent configurationIntent() {
        return null;
    }

    public String currentDestinationString() {
        throw new UnsupportedOperationException("Transport currentDestinationString() not implemented");
    }

    public Intent dataManagementIntent() {
        return null;
    }

    public String dataManagementLabel() {
        throw new UnsupportedOperationException("Transport dataManagementLabel() not implemented");
    }

    public int finishBackup() {
        return -1000;
    }

    public void finishRestore() {
        throw new UnsupportedOperationException("Transport finishRestore() not implemented");
    }

    public RestoreSet[] getAvailableRestoreSets() {
        return null;
    }

    public IBinder getBinder() {
        return this.mBinderImpl.asBinder();
    }

    public long getCurrentRestoreSet() {
        return 0L;
    }

    public int getNextFullRestoreDataChunk(ParcelFileDescriptor parcelFileDescriptor) {
        return 0;
    }

    public int getRestoreData(ParcelFileDescriptor parcelFileDescriptor) {
        return -1000;
    }

    public int initializeDevice() {
        return -1000;
    }

    public String name() {
        throw new UnsupportedOperationException("Transport name() not implemented");
    }

    public RestoreDescription nextRestorePackage() {
        return null;
    }

    public int performBackup(PackageInfo packageInfo, ParcelFileDescriptor parcelFileDescriptor) {
        return -1000;
    }

    public int performFullBackup(PackageInfo packageInfo, ParcelFileDescriptor parcelFileDescriptor) {
        return -1002;
    }

    public long requestBackupTime() {
        return 0L;
    }

    public long requestFullBackupTime() {
        return 0L;
    }

    public int sendBackupData(int i) {
        return -1000;
    }

    public int startRestore(long j, PackageInfo[] packageInfoArr) {
        return -1000;
    }

    public String transportDirName() {
        throw new UnsupportedOperationException("Transport transportDirName() not implemented");
    }
}
