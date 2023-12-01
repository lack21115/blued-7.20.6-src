package android.app.backup;

import android.app.backup.IBackupManager;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupManager.class */
public class BackupManager {
    private static final String TAG = "BackupManager";
    private static IBackupManager sService;
    private Context mContext;

    public BackupManager(Context context) {
        this.mContext = context;
    }

    private static void checkServiceBinder() {
        if (sService == null) {
            sService = IBackupManager.Stub.asInterface(ServiceManager.getService(Context.BACKUP_SERVICE));
        }
    }

    public static void dataChanged(String str) {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.dataChanged(str);
            } catch (RemoteException e) {
                Log.e(TAG, "dataChanged(pkg) couldn't connect");
            }
        }
    }

    public void backupNow() {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.backupNow();
            } catch (RemoteException e) {
                Log.e(TAG, "backupNow() couldn't connect");
            }
        }
    }

    public RestoreSession beginRestoreSession() {
        checkServiceBinder();
        RestoreSession restoreSession = null;
        if (sService != null) {
            try {
                IRestoreSession beginRestoreSession = sService.beginRestoreSession(null, null);
                restoreSession = null;
                if (beginRestoreSession != null) {
                    restoreSession = new RestoreSession(this.mContext, beginRestoreSession);
                }
            } catch (RemoteException e) {
                Log.e(TAG, "beginRestoreSession() couldn't connect");
                return null;
            }
        }
        return restoreSession;
    }

    public void dataChanged() {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.dataChanged(this.mContext.getPackageName());
            } catch (RemoteException e) {
                Log.d(TAG, "dataChanged() couldn't connect");
            }
        }
    }

    public String getCurrentTransport() {
        checkServiceBinder();
        if (sService != null) {
            try {
                return sService.getCurrentTransport();
            } catch (RemoteException e) {
                Log.e(TAG, "getCurrentTransport() couldn't connect");
                return null;
            }
        }
        return null;
    }

    public boolean isBackupEnabled() {
        checkServiceBinder();
        if (sService != null) {
            try {
                return sService.isBackupEnabled();
            } catch (RemoteException e) {
                Log.e(TAG, "isBackupEnabled() couldn't connect");
                return false;
            }
        }
        return false;
    }

    public String[] listAllTransports() {
        checkServiceBinder();
        if (sService != null) {
            try {
                return sService.listAllTransports();
            } catch (RemoteException e) {
                Log.e(TAG, "listAllTransports() couldn't connect");
                return null;
            }
        }
        return null;
    }

    public int requestRestore(RestoreObserver restoreObserver) {
        RestoreSession restoreSession;
        checkServiceBinder();
        int i = -1;
        if (sService != null) {
            RestoreSession restoreSession2 = null;
            try {
                try {
                    IRestoreSession beginRestoreSession = sService.beginRestoreSession(this.mContext.getPackageName(), null);
                    int i2 = -1;
                    RestoreSession restoreSession3 = null;
                    if (beginRestoreSession != null) {
                        RestoreSession restoreSession4 = new RestoreSession(this.mContext, beginRestoreSession);
                        try {
                            i2 = restoreSession4.restorePackage(this.mContext.getPackageName(), restoreObserver);
                            restoreSession3 = restoreSession4;
                        } catch (RemoteException e) {
                            restoreSession = restoreSession4;
                            restoreSession2 = restoreSession;
                            Log.e(TAG, "restoreSelf() unable to contact service");
                            i = -1;
                            if (restoreSession != null) {
                                restoreSession.endRestoreSession();
                                return -1;
                            }
                            return i;
                        } catch (Throwable th) {
                            th = th;
                            restoreSession2 = restoreSession4;
                            if (restoreSession2 != null) {
                                restoreSession2.endRestoreSession();
                            }
                            throw th;
                        }
                    }
                    i = i2;
                    if (restoreSession3 != null) {
                        restoreSession3.endRestoreSession();
                        i = i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (RemoteException e2) {
                restoreSession = null;
            }
        }
        return i;
    }

    public String selectBackupTransport(String str) {
        checkServiceBinder();
        if (sService != null) {
            try {
                return sService.selectBackupTransport(str);
            } catch (RemoteException e) {
                Log.e(TAG, "selectBackupTransport() couldn't connect");
                return null;
            }
        }
        return null;
    }

    public void setAutoRestore(boolean z) {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.setAutoRestore(z);
            } catch (RemoteException e) {
                Log.e(TAG, "setAutoRestore() couldn't connect");
            }
        }
    }

    public void setBackupEnabled(boolean z) {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.setBackupEnabled(z);
            } catch (RemoteException e) {
                Log.e(TAG, "setBackupEnabled() couldn't connect");
            }
        }
    }
}
