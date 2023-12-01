package android.app.backup;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/FullBackup.class */
public class FullBackup {
    public static final String APK_TREE_TOKEN = "a";
    public static final String APPS_PREFIX = "apps/";
    public static final String CACHE_TREE_TOKEN = "c";
    public static final String CONF_TOKEN_INTENT_EXTRA = "conftoken";
    public static final String DATABASE_TREE_TOKEN = "db";
    public static final String DATA_TREE_TOKEN = "f";
    public static final String FULL_BACKUP_INTENT_ACTION = "fullback";
    public static final String FULL_RESTORE_INTENT_ACTION = "fullrest";
    public static final String MANAGED_EXTERNAL_TREE_TOKEN = "ef";
    public static final String NO_BACKUP_TREE_TOKEN = "nb";
    public static final String OBB_TREE_TOKEN = "obb";
    public static final String ROOT_TREE_TOKEN = "r";
    public static final String SHAREDPREFS_TREE_TOKEN = "sp";
    public static final String SHARED_PREFIX = "shared/";
    public static final String SHARED_STORAGE_TOKEN = "shared";
    static final String TAG = "FullBackup";

    public static native int backupToTar(String str, String str2, String str3, String str4, String str5, BackupDataOutput backupDataOutput);

    public static void restoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, int i, long j2, long j3, File file) throws IOException {
        if (i != 2) {
            FileOutputStream fileOutputStream = null;
            if (file != null) {
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    Log.e(TAG, "Unable to create/open file " + file.getPath(), e);
                    fileOutputStream = null;
                }
            }
            byte[] bArr = new byte[32768];
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
            long j4 = j;
            while (true) {
                if (j4 <= 0) {
                    break;
                }
                int read = fileInputStream.read(bArr, 0, j4 > ((long) bArr.length) ? bArr.length : (int) j4);
                if (read <= 0) {
                    Log.w(TAG, "Incomplete read: expected " + j4 + " but got " + (j - j4));
                    break;
                }
                FileOutputStream fileOutputStream2 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream2 = fileOutputStream;
                    } catch (IOException e2) {
                        Log.e(TAG, "Unable to write to file " + file.getPath(), e2);
                        fileOutputStream.close();
                        fileOutputStream2 = null;
                        file.delete();
                    }
                }
                j4 -= read;
                fileOutputStream = fileOutputStream2;
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } else if (file != null) {
            file.mkdirs();
        }
        if (j2 < 0 || file == null) {
            return;
        }
        try {
            Os.chmod(file.getPath(), (int) (j2 & 448));
        } catch (ErrnoException e3) {
            e3.rethrowAsIOException();
        }
        file.setLastModified(j3);
    }
}
