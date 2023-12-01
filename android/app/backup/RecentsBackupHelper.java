package android.app.backup;

import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/RecentsBackupHelper.class */
public class RecentsBackupHelper implements BackupHelper {
    private static final boolean DEBUG = false;
    private static final String RECENTS_IMAGE_DIR = "recent_images";
    private static final String RECENTS_IMAGE_KEY = "image:";
    private static final String RECENTS_IMAGE_RESTORE_DIR = "restored_recent_images";
    private static final String RECENTS_TASK_DIR = "recent_tasks";
    private static final String RECENTS_TASK_KEY = "task:";
    private static final String RECENTS_TASK_RESTORE_DIR = "restored_recent_tasks";
    private static final String TAG = "RecentsBackup";
    final String[] mRecentFiles;
    final String[] mRecentKeys;
    FileBackupHelperBase mTaskFileHelper;
    final File mSystemDir = new File(Environment.getDataDirectory(), "system");
    final File mTasksDir = new File(this.mSystemDir, RECENTS_TASK_DIR);
    final File mRestoredTasksDir = new File(this.mSystemDir, RECENTS_TASK_RESTORE_DIR);
    final File mRestoredImagesDir = new File(this.mSystemDir, RECENTS_IMAGE_RESTORE_DIR);

    public RecentsBackupHelper(Context context) {
        this.mTaskFileHelper = new FileBackupHelperBase(context);
        File[] listFiles = this.mTasksDir.listFiles();
        if (listFiles == null) {
            String[] strArr = new String[0];
            this.mRecentKeys = strArr;
            this.mRecentFiles = strArr;
            return;
        }
        int length = listFiles.length;
        this.mRecentKeys = new String[length];
        this.mRecentFiles = new String[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mRecentKeys[i2] = new String(RECENTS_TASK_KEY + listFiles[i2].getName());
            this.mRecentFiles[i2] = listFiles[i2].getAbsolutePath();
            i = i2 + 1;
        }
    }

    @Override // android.app.backup.BackupHelper
    public void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        FileBackupHelperBase.performBackup_checked(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2, this.mRecentFiles, this.mRecentKeys);
    }

    @Override // android.app.backup.BackupHelper
    public void restoreEntity(BackupDataInputStream backupDataInputStream) {
        String key = backupDataInputStream.getKey();
        File file = null;
        if (key.startsWith(RECENTS_TASK_KEY)) {
            file = new File(this.mRestoredTasksDir, key.substring(RECENTS_TASK_KEY.length()));
            this.mRestoredTasksDir.mkdirs();
        } else if (key.startsWith(RECENTS_IMAGE_KEY)) {
            file = new File(this.mRestoredImagesDir, key.substring(RECENTS_IMAGE_KEY.length()));
            this.mRestoredImagesDir.mkdirs();
        }
        if (file != null) {
            this.mTaskFileHelper.writeFile(file, backupDataInputStream);
        }
    }

    @Override // android.app.backup.BackupHelper
    public void writeNewStateDescription(ParcelFileDescriptor parcelFileDescriptor) {
        this.mTaskFileHelper.writeNewStateDescription(parcelFileDescriptor);
    }
}
