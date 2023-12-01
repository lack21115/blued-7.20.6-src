package android.app.backup;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/FileBackupHelperBase.class */
class FileBackupHelperBase {
    private static final String TAG = "FileBackupHelperBase";
    Context mContext;
    boolean mExceptionLogged;
    long mPtr = ctor();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileBackupHelperBase(Context context) {
        this.mContext = context;
    }

    private static native long ctor();

    private static native void dtor(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void performBackup_checked(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2, String[] strArr, String[] strArr2) {
        if (strArr.length == 0) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (strArr.length != strArr2.length) {
                    throw new RuntimeException("files.length=" + strArr.length + " keys.length=" + strArr2.length);
                }
                FileDescriptor fileDescriptor = parcelFileDescriptor != null ? parcelFileDescriptor.getFileDescriptor() : null;
                FileDescriptor fileDescriptor2 = parcelFileDescriptor2.getFileDescriptor();
                if (fileDescriptor2 == null) {
                    throw new NullPointerException();
                }
                int performBackup_native = performBackup_native(fileDescriptor, backupDataOutput.mBackupWriter, fileDescriptor2, strArr, strArr2);
                if (performBackup_native != 0) {
                    throw new RuntimeException("Backup failed 0x" + Integer.toHexString(performBackup_native));
                }
                return;
            }
            String str = strArr[i2];
            if (str.charAt(0) != '/') {
                throw new RuntimeException("files must have all absolute paths: " + str);
            }
            i = i2 + 1;
        }
    }

    private static native int performBackup_native(FileDescriptor fileDescriptor, long j, FileDescriptor fileDescriptor2, String[] strArr, String[] strArr2);

    private static native int writeFile_native(long j, String str, long j2);

    private static native int writeSnapshot_native(long j, FileDescriptor fileDescriptor);

    protected void finalize() throws Throwable {
        try {
            dtor(this.mPtr);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isKeyInList(String str, String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean writeFile(File file, BackupDataInputStream backupDataInputStream) {
        file.getParentFile().mkdirs();
        int writeFile_native = writeFile_native(this.mPtr, file.getAbsolutePath(), backupDataInputStream.mData.mBackupReader);
        if (writeFile_native != 0 && !this.mExceptionLogged) {
            Log.e(TAG, "Failed restoring file '" + file + "' for app '" + this.mContext.getPackageName() + "' result=0x" + Integer.toHexString(writeFile_native));
            this.mExceptionLogged = true;
        }
        return writeFile_native == 0;
    }

    public void writeNewStateDescription(ParcelFileDescriptor parcelFileDescriptor) {
        writeSnapshot_native(this.mPtr, parcelFileDescriptor.getFileDescriptor());
    }
}
