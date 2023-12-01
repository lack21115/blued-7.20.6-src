package android.app.backup;

import android.app.IBackupAgent;
import android.app.QueuedWork;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupAgent.class */
public abstract class BackupAgent extends ContextWrapper {
    private static final boolean DEBUG = false;
    private static final String GENERIC_FILE_NAME = "foo";
    private static final String TAG = "BackupAgent";
    public static final int TYPE_DIRECTORY = 2;
    public static final int TYPE_EOF = 0;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_SYMLINK = 3;
    private final IBinder mBinder;
    Handler mHandler;

    /* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupAgent$BackupServiceBinder.class */
    private class BackupServiceBinder extends IBackupAgent.Stub {
        private static final String TAG = "BackupServiceBinder";

        private BackupServiceBinder() {
        }

        @Override // android.app.IBackupAgent
        public void doBackup(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, ParcelFileDescriptor parcelFileDescriptor3, int i, IBackupManager iBackupManager) throws RemoteException {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    try {
                        BackupAgent.this.onBackup(parcelFileDescriptor, new BackupDataOutput(parcelFileDescriptor2.getFileDescriptor()), parcelFileDescriptor3);
                    } catch (RuntimeException e) {
                        Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", e);
                        throw e;
                    }
                } catch (IOException e2) {
                    Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", e2);
                    throw new RuntimeException(e2);
                }
            } finally {
                BackupAgent.this.waitForSharedPrefs();
                Binder.restoreCallingIdentity(clearCallingIdentity);
                try {
                    iBackupManager.opComplete(i);
                } catch (RemoteException e3) {
                }
            }
        }

        @Override // android.app.IBackupAgent
        public void doBackupFiles(ParcelFileDescriptor parcelFileDescriptor, int i, String[] strArr, String str, IBackupManager iBackupManager) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            BackupAgent.this.waitForSharedPrefs();
            try {
                try {
                    BackupAgent.this.onBackupFiles(strArr, str, new FullBackupDataOutput(parcelFileDescriptor));
                    BackupAgent.this.waitForSharedPrefs();
                    try {
                        new FileOutputStream(parcelFileDescriptor.getFileDescriptor()).write(new byte[4]);
                    } catch (IOException e) {
                        Log.e(TAG, "Unable to finalize backup stream!");
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    try {
                        iBackupManager.opComplete(i);
                    } catch (RemoteException e2) {
                    }
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                } catch (RuntimeException e4) {
                    throw e4;
                }
            } catch (Throwable th) {
                BackupAgent.this.waitForSharedPrefs();
                try {
                    new FileOutputStream(parcelFileDescriptor.getFileDescriptor()).write(new byte[4]);
                } catch (IOException e5) {
                    Log.e(TAG, "Unable to finalize backup stream!");
                }
                Binder.restoreCallingIdentity(clearCallingIdentity);
                try {
                    iBackupManager.opComplete(i);
                } catch (RemoteException e6) {
                }
                throw th;
            }
        }

        @Override // android.app.IBackupAgent
        public void doFullBackup(ParcelFileDescriptor parcelFileDescriptor, int i, IBackupManager iBackupManager) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            BackupAgent.this.waitForSharedPrefs();
            try {
                try {
                    try {
                        BackupAgent.this.onFullBackup(new FullBackupDataOutput(parcelFileDescriptor));
                        BackupAgent.this.waitForSharedPrefs();
                        try {
                            new FileOutputStream(parcelFileDescriptor.getFileDescriptor()).write(new byte[4]);
                        } catch (IOException e) {
                            Log.e(TAG, "Unable to finalize backup stream!");
                        }
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        try {
                            iBackupManager.opComplete(i);
                        } catch (RemoteException e2) {
                        }
                    } catch (IOException e3) {
                        Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", e3);
                        throw new RuntimeException(e3);
                    }
                } catch (RuntimeException e4) {
                    Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", e4);
                    throw e4;
                }
            } catch (Throwable th) {
                BackupAgent.this.waitForSharedPrefs();
                try {
                    new FileOutputStream(parcelFileDescriptor.getFileDescriptor()).write(new byte[4]);
                } catch (IOException e5) {
                    Log.e(TAG, "Unable to finalize backup stream!");
                }
                Binder.restoreCallingIdentity(clearCallingIdentity);
                try {
                    iBackupManager.opComplete(i);
                } catch (RemoteException e6) {
                }
                throw th;
            }
        }

        @Override // android.app.IBackupAgent
        public void doRestore(ParcelFileDescriptor parcelFileDescriptor, int i, ParcelFileDescriptor parcelFileDescriptor2, int i2, IBackupManager iBackupManager) throws RemoteException {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    try {
                        BackupAgent.this.onRestore(new BackupDataInput(parcelFileDescriptor.getFileDescriptor()), i, parcelFileDescriptor2);
                    } catch (RuntimeException e) {
                        Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", e);
                        throw e;
                    }
                } catch (IOException e2) {
                    Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", e2);
                    throw new RuntimeException(e2);
                }
            } finally {
                BackupAgent.this.waitForSharedPrefs();
                Binder.restoreCallingIdentity(clearCallingIdentity);
                try {
                    iBackupManager.opComplete(i2);
                } catch (RemoteException e3) {
                }
            }
        }

        @Override // android.app.IBackupAgent
        public void doRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, int i, String str, String str2, long j2, long j3, int i2, IBackupManager iBackupManager) throws RemoteException {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    BackupAgent.this.onRestoreFile(parcelFileDescriptor, j, i, str, str2, j2, j3);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                BackupAgent.this.waitForSharedPrefs();
                Binder.restoreCallingIdentity(clearCallingIdentity);
                try {
                    iBackupManager.opComplete(i2);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.app.IBackupAgent
        public void doRestoreFinished(int i, IBackupManager iBackupManager) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                BackupAgent.this.onRestoreFinished();
            } finally {
                BackupAgent.this.waitForSharedPrefs();
                Binder.restoreCallingIdentity(clearCallingIdentity);
                try {
                    iBackupManager.opComplete(i);
                } catch (RemoteException e) {
                }
            }
        }

        @Override // android.app.IBackupAgent
        public void fail(String str) {
            BackupAgent.this.getHandler().post(new FailRunnable(str));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupAgent$FailRunnable.class */
    static class FailRunnable implements Runnable {
        private String mMessage;

        FailRunnable(String str) {
            this.mMessage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException(this.mMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupAgent$SharedPrefsSynchronizer.class */
    public class SharedPrefsSynchronizer implements Runnable {
        public final CountDownLatch mLatch = new CountDownLatch(1);

        SharedPrefsSynchronizer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QueuedWork.waitToFinish();
            this.mLatch.countDown();
        }
    }

    public BackupAgent() {
        super(null);
        this.mHandler = null;
        this.mBinder = new BackupServiceBinder().asBinder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackupFiles(String[] strArr, String str, FullBackupDataOutput fullBackupDataOutput) throws IOException {
        ApplicationInfo applicationInfo = getApplicationInfo();
        String canonicalPath = new File(applicationInfo.dataDir).getCanonicalPath();
        String canonicalPath2 = getFilesDir().getCanonicalPath();
        String canonicalPath3 = getDatabasePath(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
        String canonicalPath4 = getSharedPrefsFile(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
        String canonicalPath5 = getCacheDir().getCanonicalPath();
        String canonicalPath6 = applicationInfo.nativeLibraryDir != null ? new File(applicationInfo.nativeLibraryDir).getCanonicalPath() : null;
        String canonicalPath7 = getExternalFilesDir(null).getCanonicalPath();
        HashSet<String> hashSet = new HashSet<>();
        String packageName = getPackageName();
        if (canonicalPath6 != null) {
            hashSet.add(canonicalPath6);
        }
        hashSet.add(canonicalPath5);
        hashSet.add(canonicalPath3);
        hashSet.add(canonicalPath4);
        hashSet.add(canonicalPath2);
        Pattern pattern = null;
        if (str != null) {
            pattern = Pattern.compile(str, 2);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = strArr[i2];
            if ("r".equals(str2)) {
                fullBackupFileTree(packageName, "r", canonicalPath, hashSet, pattern, fullBackupDataOutput);
            }
            if (FullBackup.DATA_TREE_TOKEN.equals(str2)) {
                hashSet.add(canonicalPath);
                hashSet.remove(canonicalPath2);
                fullBackupFileTree(packageName, FullBackup.DATA_TREE_TOKEN, canonicalPath2, hashSet, pattern, fullBackupDataOutput);
            }
            if (FullBackup.DATABASE_TREE_TOKEN.equals(str2)) {
                hashSet.add(canonicalPath2);
                hashSet.remove(canonicalPath3);
                fullBackupFileTree(packageName, FullBackup.DATABASE_TREE_TOKEN, canonicalPath3, hashSet, pattern, fullBackupDataOutput);
            }
            if (FullBackup.SHAREDPREFS_TREE_TOKEN.equals(str2)) {
                hashSet.add(canonicalPath3);
                hashSet.remove(canonicalPath4);
                fullBackupFileTree(packageName, FullBackup.SHAREDPREFS_TREE_TOKEN, canonicalPath4, hashSet, pattern, fullBackupDataOutput);
            }
            if (FullBackup.MANAGED_EXTERNAL_TREE_TOKEN.equals(str2) && Process.myUid() != 1000) {
                fullBackupFileTree(packageName, FullBackup.MANAGED_EXTERNAL_TREE_TOKEN, canonicalPath7, null, pattern, fullBackupDataOutput);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForSharedPrefs() {
        Handler handler = getHandler();
        SharedPrefsSynchronizer sharedPrefsSynchronizer = new SharedPrefsSynchronizer();
        handler.postAtFrontOfQueue(sharedPrefsSynchronizer);
        try {
            sharedPrefsSynchronizer.mLatch.await();
        } catch (InterruptedException e) {
        }
    }

    public void attach(Context context) {
        attachBaseContext(context);
    }

    public final void fullBackupFile(File file, FullBackupDataOutput fullBackupDataOutput) {
        String str;
        ApplicationInfo applicationInfo = getApplicationInfo();
        try {
            String canonicalPath = new File(applicationInfo.dataDir).getCanonicalPath();
            String canonicalPath2 = getFilesDir().getCanonicalPath();
            String canonicalPath3 = getNoBackupFilesDir().getCanonicalPath();
            String canonicalPath4 = getDatabasePath(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
            String canonicalPath5 = getSharedPrefsFile(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
            String canonicalPath6 = getCacheDir().getCanonicalPath();
            String canonicalPath7 = applicationInfo.nativeLibraryDir == null ? null : new File(applicationInfo.nativeLibraryDir).getCanonicalPath();
            String str2 = null;
            if (Process.myUid() != 1000) {
                File externalFilesDir = getExternalFilesDir(null);
                str2 = null;
                if (externalFilesDir != null) {
                    str2 = externalFilesDir.getCanonicalPath();
                }
            }
            String canonicalPath8 = file.getCanonicalPath();
            if (canonicalPath8.startsWith(canonicalPath6) || canonicalPath8.startsWith(canonicalPath7) || canonicalPath8.startsWith(canonicalPath3)) {
                Log.w(TAG, "lib, cache, and no_backup files are not backed up");
                return;
            }
            if (canonicalPath8.startsWith(canonicalPath4)) {
                str = FullBackup.DATABASE_TREE_TOKEN;
                str2 = canonicalPath4;
            } else if (canonicalPath8.startsWith(canonicalPath5)) {
                str = FullBackup.SHAREDPREFS_TREE_TOKEN;
                str2 = canonicalPath5;
            } else if (canonicalPath8.startsWith(canonicalPath2)) {
                str = FullBackup.DATA_TREE_TOKEN;
                str2 = canonicalPath2;
            } else if (canonicalPath8.startsWith(canonicalPath)) {
                str = "r";
                str2 = canonicalPath;
            } else if (str2 == null || !canonicalPath8.startsWith(str2)) {
                Log.w(TAG, "File " + canonicalPath8 + " is in an unsupported location; skipping");
                return;
            } else {
                str = FullBackup.MANAGED_EXTERNAL_TREE_TOKEN;
            }
            Log.i(TAG, "backupFile() of " + canonicalPath8 + " => domain=" + str + " rootpath=" + str2);
            FullBackup.backupToTar(getPackageName(), str, null, str2, canonicalPath8, fullBackupDataOutput.getData());
        } catch (IOException e) {
            Log.w(TAG, "Unable to obtain canonical paths");
        }
    }

    protected final void fullBackupFileTree(String str, String str2, String str3, HashSet<String> hashSet, FullBackupDataOutput fullBackupDataOutput) {
        fullBackupFileTree(str, str2, str3, hashSet, null, fullBackupDataOutput);
    }

    protected final void fullBackupFileTree(String str, String str2, String str3, HashSet<String> hashSet, Pattern pattern, FullBackupDataOutput fullBackupDataOutput) {
        File[] listFiles;
        File file = new File(str3);
        if (file.exists()) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(file);
            while (linkedList.size() > 0) {
                File file2 = (File) linkedList.remove(0);
                try {
                    String canonicalPath = file2.getCanonicalPath();
                    if (hashSet == null || !hashSet.contains(canonicalPath)) {
                        if (pattern == null || !pattern.matcher(canonicalPath).find()) {
                            StructStat lstat = Os.lstat(canonicalPath);
                            if (!OsConstants.S_ISLNK(lstat.st_mode)) {
                                if (OsConstants.S_ISDIR(lstat.st_mode) && (listFiles = file2.listFiles()) != null) {
                                    int length = listFiles.length;
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= length) {
                                            break;
                                        }
                                        linkedList.add(0, listFiles[i2]);
                                        i = i2 + 1;
                                    }
                                }
                                FullBackup.backupToTar(str, str2, null, str3, canonicalPath, fullBackupDataOutput.getData());
                            }
                        }
                    }
                } catch (ErrnoException e) {
                } catch (IOException e2) {
                }
            }
        }
    }

    Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }

    public abstract void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException;

    public final IBinder onBind() {
        return this.mBinder;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        File externalFilesDir;
        ApplicationInfo applicationInfo = getApplicationInfo();
        String canonicalPath = new File(applicationInfo.dataDir).getCanonicalPath();
        String canonicalPath2 = getFilesDir().getCanonicalPath();
        String canonicalPath3 = getDatabasePath(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
        String canonicalPath4 = getSharedPrefsFile(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
        String canonicalPath5 = getCacheDir().getCanonicalPath();
        String canonicalPath6 = applicationInfo.nativeLibraryDir != null ? new File(applicationInfo.nativeLibraryDir).getCanonicalPath() : null;
        HashSet<String> hashSet = new HashSet<>();
        String packageName = getPackageName();
        if (canonicalPath6 != null) {
            hashSet.add(canonicalPath6);
        }
        hashSet.add(canonicalPath5);
        hashSet.add(canonicalPath3);
        hashSet.add(canonicalPath4);
        hashSet.add(canonicalPath2);
        fullBackupFileTree(packageName, "r", canonicalPath, hashSet, fullBackupDataOutput);
        hashSet.add(canonicalPath);
        hashSet.remove(canonicalPath2);
        fullBackupFileTree(packageName, FullBackup.DATA_TREE_TOKEN, canonicalPath2, hashSet, fullBackupDataOutput);
        hashSet.add(canonicalPath2);
        hashSet.remove(canonicalPath3);
        fullBackupFileTree(packageName, FullBackup.DATABASE_TREE_TOKEN, canonicalPath3, hashSet, fullBackupDataOutput);
        hashSet.add(canonicalPath3);
        hashSet.remove(canonicalPath4);
        fullBackupFileTree(packageName, FullBackup.SHAREDPREFS_TREE_TOKEN, canonicalPath4, hashSet, fullBackupDataOutput);
        if (Process.myUid() == 1000 || (externalFilesDir = getExternalFilesDir(null)) == null) {
            return;
        }
        fullBackupFileTree(packageName, FullBackup.MANAGED_EXTERNAL_TREE_TOKEN, externalFilesDir.getCanonicalPath(), null, fullBackupDataOutput);
    }

    public abstract void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    protected void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, int i, String str, String str2, long j2, long j3) throws IOException {
        String str3;
        long j4;
        if (str.equals(FullBackup.DATA_TREE_TOKEN)) {
            str3 = getFilesDir().getCanonicalPath();
            j4 = j2;
        } else if (str.equals(FullBackup.DATABASE_TREE_TOKEN)) {
            str3 = getDatabasePath(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
            j4 = j2;
        } else if (str.equals("r")) {
            str3 = new File(getApplicationInfo().dataDir).getCanonicalPath();
            j4 = j2;
        } else if (str.equals(FullBackup.SHAREDPREFS_TREE_TOKEN)) {
            str3 = getSharedPrefsFile(GENERIC_FILE_NAME).getParentFile().getCanonicalPath();
            j4 = j2;
        } else if (str.equals("c")) {
            str3 = getCacheDir().getCanonicalPath();
            j4 = j2;
        } else if (str.equals(FullBackup.MANAGED_EXTERNAL_TREE_TOKEN)) {
            str3 = null;
            j4 = j2;
            if (Process.myUid() != 1000) {
                str3 = null;
                j4 = j2;
                if (getExternalFilesDir(null) != null) {
                    str3 = getExternalFilesDir(null).getCanonicalPath();
                    j4 = -1;
                }
            }
        } else if (str.equals(FullBackup.NO_BACKUP_TREE_TOKEN)) {
            str3 = getNoBackupFilesDir().getCanonicalPath();
            j4 = j2;
        } else {
            Log.i(TAG, "Unrecognized domain " + str);
            str3 = null;
            j4 = j2;
        }
        if (str3 != null) {
            File file = new File(str3, str2);
            if (file.getCanonicalPath().startsWith(str3 + File.separatorChar)) {
                onRestoreFile(parcelFileDescriptor, j, file, i, j4, j3);
                return;
            }
        }
        FullBackup.restoreFile(parcelFileDescriptor, j, i, j4, j3, null);
    }

    public void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException {
        FullBackup.restoreFile(parcelFileDescriptor, j, i, j2, j3, file);
    }

    public void onRestoreFinished() {
    }
}
